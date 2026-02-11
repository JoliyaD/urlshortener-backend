package com.newproject.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UrlShortenerController {

    @Autowired
    private UrlShortenerService urlShortenerService;

    // Base URL comes from application-dev.yml or application-prod.yml
    @Value("${app.base-url}")
    private String baseUrl;

    @PostMapping("/api/shorten")
    public ResponseEntity<Map<String, String>> shortenUrl(
            @RequestBody UrlRequest request) {

        // Service returns ONLY the short code
        String shortCode = urlShortenerService
                .shortenUrl(request.getOriginalUrl());

        // Controller builds the full URL
        String shortUrl = baseUrl + "/" + shortCode;

        Map<String, String> response = new HashMap<>();
        response.put("shortCode", shortCode);
        response.put("shortUrl", shortUrl);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(
            @PathVariable String shortCode) {

        String originalUrl =
                urlShortenerService.getOriginalUrl(shortCode);

        if (originalUrl == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(302)
                .header("Location", originalUrl)
                .build();
    }
}

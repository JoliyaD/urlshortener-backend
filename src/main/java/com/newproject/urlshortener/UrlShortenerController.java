package com.newproject.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UrlShortenerController {

    @Autowired
    private UrlShortenerService urlShortenerService;

    // ============================
    // POST: Create Short URL
    // ============================
    @PostMapping("/api/shorten")
    public ResponseEntity<Map<String, String>> shortenUrl(@RequestBody UrlRequest request) {

        String shortCode = urlShortenerService.shortenUrl(request.getOriginalUrl());
        String shortUrl = "https://urlshortener-backend-4uge.onrender.com/" + shortCode;

        Map<String, String> response = new HashMap<>();
        response.put("shortCode", shortCode);
        response.put("shortUrl", shortUrl);

        return ResponseEntity.ok(response);
    }

    // ============================
    // GET: Redirect to Original URL
    // ============================
    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode) {

        String originalUrl = urlShortenerService.getOriginalUrl(shortCode);

        if (originalUrl == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(302)
                .header("Location", originalUrl)
                .build();
    }
}


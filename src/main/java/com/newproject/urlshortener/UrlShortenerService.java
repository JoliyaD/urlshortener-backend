package com.newproject.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UrlShortenerService {

    @Autowired
    private ShortUrlRepository repository;

    // Generates short code and saves mapping
    public String shortenUrl(String originalUrl) {

        String shortCode = UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 6);

        ShortUrl shortUrl = new ShortUrl(shortCode, originalUrl);
        repository.save(shortUrl);

        // IMPORTANT: return ONLY the short code
        return shortCode;
    }

    // Fetch original URL using short code
    public String getOriginalUrl(String shortCode) {

        Optional<ShortUrl> shortUrl =
                repository.findByShortCode(shortCode);

        return shortUrl
                .map(ShortUrl::getOriginalUrl)
                .orElse(null);
    }
}

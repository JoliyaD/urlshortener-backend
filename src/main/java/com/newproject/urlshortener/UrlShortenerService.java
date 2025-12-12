package com.newproject.urlshortener;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UrlShortenerService {

    private Map<String, String> urlStore = new HashMap<>();

    // Create short code + store mapping
    public String shortenUrl(String originalUrl) {
        String shortCode = UUID.randomUUID().toString().substring(0, 6);
        urlStore.put(shortCode, originalUrl);
        return shortCode;
    }

    // Get original URL for redirect
    public String getOriginalUrl(String shortCode) {
        return urlStore.get(shortCode);
    }
}

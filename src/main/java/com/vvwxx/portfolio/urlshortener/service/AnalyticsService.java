package com.vvwxx.portfolio.urlshortener.service;

import com.vvwxx.portfolio.urlshortener.repository.UrlRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnalyticsService {

    private final UrlRepository urlRepository;

    @Async
    @Transactional
    public void trackClick(Long id) {

        try {
            urlRepository.incrementClickCount(id);
            System.out.println("Update for id " + id + " in background success.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

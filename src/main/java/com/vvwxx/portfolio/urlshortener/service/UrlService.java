package com.vvwxx.portfolio.urlshortener.service;

import com.vvwxx.portfolio.urlshortener.entity.Url;
import com.vvwxx.portfolio.urlshortener.repository.UrlRepository;
import com.vvwxx.portfolio.urlshortener.util.Base62Convert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;

    public String shortenUrl(String originalUrl) {

        Url url = new Url();
        url.setLongUrl(originalUrl);
        Url saveUrl = urlRepository.save(url);

        return Base62Convert.encode(saveUrl.getId());
    }

    public String getOriginalUrl(String shortUrl) {

        long id = Base62Convert.decode(shortUrl);

        Url data = urlRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Url not found for code: " + shortUrl));

        return data.getLongUrl();

    }
}

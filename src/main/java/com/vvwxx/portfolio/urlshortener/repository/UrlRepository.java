package com.vvwxx.portfolio.urlshortener.repository;

import com.vvwxx.portfolio.urlshortener.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

}

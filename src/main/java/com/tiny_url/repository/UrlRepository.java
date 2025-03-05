package com.tiny_url.repository;

import com.tiny_url.entity.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UrlRepository extends JpaRepository<UrlEntity, UUID> {

    UrlEntity findByTinyUrl(String tinyUrl);

}

package com.tiny_url.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "url")
@Getter
@Setter
public class UrlEntity extends BaseEntity{

    @Id
    @UuidGenerator
    @GeneratedValue
    private UUID id;

    @Column(name = "original_url")
    private String originalUrl;

    @Column(name = "tiny_url")
    private String tinyUrl;

    @Column(name = "expire_at")
    private LocalDateTime expireAt;

    @Column(name = "is_expired")
    private boolean isExpired;
}

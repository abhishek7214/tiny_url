package com.tiny_url.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {
    @Column(name = "created_at",updatable = false)
    @JsonSerialize
    @JsonDeserialize
    private LocalDateTime CreatedAt = LocalDateTime.now();

    @Column(name = "updated_at")
    @JsonSerialize
    @JsonDeserialize
    private LocalDateTime UpdatedAt = LocalDateTime.now();
}

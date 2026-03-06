package com.latiendadekellyb.demo.api.dto;

import java.time.LocalDateTime;

public record ProductResponse(
    String id,
    String name,
    Integer price,
    String description,
    String category,
    String image,
    boolean featured,
    Integer sortOrder,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
}

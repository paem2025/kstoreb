package com.latiendadekellyb.demo.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductRequest(
    @NotBlank(message = "name is required")
    @Size(max = 255, message = "name max length is 255")
    String name,

    @NotNull(message = "price is required")
    @Min(value = 0, message = "price must be >= 0")
    Integer price,

    @NotBlank(message = "description is required")
    @Size(max = 3000, message = "description max length is 3000")
    String description,

    @NotBlank(message = "category is required")
    @Size(max = 120, message = "category max length is 120")
    String category,

    @NotBlank(message = "image is required")
    @Size(max = 2000, message = "image max length is 2000")
    String image,

    Boolean featured,

    @Min(value = 0, message = "sortOrder must be >= 0")
    Integer sortOrder
) {
}

package com.example.similar.infrastructure.primary.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class SimilarProductDto {
    private String id;
    private String name;
    private Integer price;
    private Boolean availability;
}

package com.example.similar.core.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Product {
    private String id;
    private String name;
    private Integer price;
    private Boolean availability;
}

package com.example.similar.core;

import com.example.similar.core.domain.Product;
import reactor.core.publisher.Flux;

public interface FindSimilarProductUseCase {
    Flux<Product> handle(String productId);
}

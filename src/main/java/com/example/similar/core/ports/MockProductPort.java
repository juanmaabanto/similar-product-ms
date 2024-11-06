package com.example.similar.core.ports;

import com.example.similar.core.domain.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MockProductPort {
    Flux<Integer> GetSimilarIds(String productId);
    Mono<Product> GetProductById(String productId);
}

package com.example.similar.core.services;

import com.example.similar.core.FindSimilarProductUseCase;
import com.example.similar.core.domain.Product;
import com.example.similar.core.ports.MockProductPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
@RequiredArgsConstructor
public class FindSimilarProductService implements FindSimilarProductUseCase {

    private final MockProductPort mockProductPort;

    @Override
    public Flux<Product> handle(String productId) {
        return mockProductPort.GetSimilarIds(productId)
                .flatMap(id -> mockProductPort.GetProductById(id.toString()))
                .doOnNext(product -> log.info("similar product found: {}", product))
                .onErrorResume(e -> {
                    log.error("Error getting similar products: {}", productId, e);
                    return Flux.empty();
                });
    }
}

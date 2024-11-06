package com.example.similar.infrastructure.secondary.httprequest;

import com.example.similar.core.domain.Product;
import com.example.similar.core.ports.MockProductPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class MockProductAdapter implements MockProductPort {

    private final WebClient webClient;

    @Autowired
    public MockProductAdapter(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:3001").build();  // Establecer la URL base
    }

    @Override
    public Flux<Integer> GetSimilarIds(String productId) {
        return webClient.get()
                .uri("/product/{productId}/similarids", productId)
                .retrieve()
                .bodyToFlux(Integer.class)
                .doOnError(error -> log.error("Error getting similar Ids: ", error));
    }

    @Override
    public Mono<Product> GetProductById(String productId) {
        return webClient.get()
                .uri("/product/{productId}", productId)
                .retrieve()
                .bodyToMono(Product.class)
                .doOnError(error -> log.error("Error getting product: ", error));
    }
}

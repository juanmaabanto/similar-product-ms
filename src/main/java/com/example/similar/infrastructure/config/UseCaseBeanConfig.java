package com.example.similar.infrastructure.config;

import com.example.similar.core.FindSimilarProductUseCase;
import com.example.similar.core.ports.MockProductPort;
import com.example.similar.core.services.FindSimilarProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class UseCaseBeanConfig {

    @Bean
    public FindSimilarProductUseCase findSimilarProductUseCase(MockProductPort mockProductPort) {
        return new FindSimilarProductService(mockProductPort);
    }
}

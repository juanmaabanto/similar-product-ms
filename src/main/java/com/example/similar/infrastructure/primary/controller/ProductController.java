package com.example.similar.infrastructure.primary.controller;

import com.example.similar.infrastructure.primary.controller.dto.SimilarProductDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import jakarta.validation.constraints.NotNull;

import static io.swagger.v3.oas.annotations.enums.ParameterIn.PATH;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
@Slf4j
@Validated
public class ProductController {

    @Operation(summary = "Find similar products.", description = "Find similar products.")
    @Parameters(
            {
                    @Parameter(
                            name = "productId",
                            in = PATH,
                            description = "Product Id",
                            required = true,
                            schema = @Schema(type = "string"),
                            example = "123"
                    )
            }
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Location were found.",
                            content = {
                                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseEntity.class))
                            }
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not Found.",
                            content = {
                                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseEntity.class))
                            }
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "The resource you were trying to reach had an error.",
                            content = {
                                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseEntity.class))
                            }
                    )
            }
    )
    @GetMapping(value = "{productId}/similar", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<SimilarProductDto> findSimilarProducts(@NotNull @PathVariable("productId") String productId) {
        return Flux.just(new SimilarProductDto("1", "product 1", 100, true));
    }
}

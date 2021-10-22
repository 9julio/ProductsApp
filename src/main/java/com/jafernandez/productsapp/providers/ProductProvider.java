package com.jafernandez.productsapp.providers;

import com.jafernandez.productsapp.models.dto.Product;
import com.jafernandez.productsapp.utils.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class ProductProvider {

    @Autowired
    public Properties properties;

    private WebClient webClient = WebClient.create("http://localhost:3001");

    public Flux<Product> getSimilarIdsByProductId(long productId) {
        return webClient
                .get()
                .uri("/product/{productId}/similarids", productId)
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<Integer>() {})
                .timeout(Duration.ofSeconds(properties.getProvidersTimeOutInSegs()))
                .flatMap(similarProductId ->
                        webClient
                                .get()
                                .uri("/product/{productId}", similarProductId)
                                .retrieve()
                                .onStatus(HttpStatus::isError, clientResponse -> { return Mono.empty(); })
                                .bodyToFlux(Product.class)
                                .timeout(Duration.ofSeconds(properties.getProvidersTimeOutInSegs()))
                );
    }

}

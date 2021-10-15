package com.jafernandez.productsapp.providers;

import com.jafernandez.productsapp.models.dto.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class ProductProvider {

    private WebClient webClient = WebClient.create("http://localhost:3001");

    public Flux<Product> getSimilarProductsById(long productId) {

        Flux<Long> productSimilarIdsFlux =
                webClient
                        .get()
                        .uri("/product/{productId}/similarids", productId)
                        .retrieve()
                        .bodyToFlux(Long.class);

        productSimilarIdsFlux
                .subscribe();

//        Flux<Product> getProductByIds =
//                webClient
//                        .get()
//                        .uri("/product/{productId}", productId)
//                        .retrieve()
//                        .bodyToFlux(Product.class);
//
//        getProductByIds
//                .subscribe();

        return null;
    }

}

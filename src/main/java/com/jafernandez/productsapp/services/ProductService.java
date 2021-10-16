package com.jafernandez.productsapp.services;

import com.jafernandez.productsapp.models.dto.Product;
import reactor.core.publisher.Flux;

public interface ProductService {

    public Flux<Product> getSimilarProductsById(long productId);

}

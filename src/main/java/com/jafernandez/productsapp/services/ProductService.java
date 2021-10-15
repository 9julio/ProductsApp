package com.jafernandez.productsapp.services;

import com.jafernandez.productsapp.models.dto.Product;
import com.jafernandez.productsapp.providers.ProductProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ProductService {

    @Autowired
    private ProductProvider productProvider;

    public Flux<Product> getSimilarProductsById(long productId) {

        Flux<Product> result = this.productProvider.getSimilarProductsById(productId);

        return result;
    }

}

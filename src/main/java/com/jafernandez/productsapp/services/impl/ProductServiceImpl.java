package com.jafernandez.productsapp.services.impl;

import com.jafernandez.productsapp.models.dto.Product;
import com.jafernandez.productsapp.providers.ProductProvider;
import com.jafernandez.productsapp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductProvider productProvider;

    @Override
    public Flux<Product> getSimilarProductsById(long productId) {
        return this.productProvider.getSimilarIdsByProductId(productId);
    }

}

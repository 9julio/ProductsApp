package com.jafernandez.productsapp.controllers;

import com.jafernandez.productsapp.models.dto.Product;
import com.jafernandez.productsapp.services.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/{productId}/similar")
    private Flux<Product> getProducts(@PathVariable("productId") String productId) {

        Long id = null;

        if (StringUtils.isEmpty(productId)) {
            // BAD REQUEST
        } else if (!StringUtils.isNumeric(productId)) {
            // BAD REQUEST
        } else {
            id = Long.parseLong(productId);
        }

        Flux<Product> result = this.productService.getSimilarProductsById(id);

        return result;
    }

}

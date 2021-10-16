package com.jafernandez.productsapp.units.services;

import com.jafernandez.productsapp.models.dto.Product;
import com.jafernandez.productsapp.providers.ProductProvider;
import com.jafernandez.productsapp.services.impl.ProductServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Flux;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTests {

    @InjectMocks
    public ProductServiceImpl productService;

    @Mock
    public ProductProvider productProviderMock;

    @Test
    public void getSimilarProductsById_OK() {

        long id = 1L;

        Product product = new Product(id, "name", 2.0, false);
        Flux<Product> productFlux = Flux.just(product);

        when(this.productProviderMock.getSimilarIdsByProductId(
                anyLong()
        )).thenReturn(productFlux);

        Flux<Product> result = this.productService.getSimilarProductsById(id);
        assertNotNull(result);
    }

    @Test
    public void getSimilarProductsByIdWithEmptyResult_OK() {

        long id = 1L;

        Flux<Product> productFlux = Flux.empty();

        when(this.productProviderMock.getSimilarIdsByProductId(
                anyLong()
        )).thenReturn(productFlux);

        Flux<Product> result = this.productService.getSimilarProductsById(id);
        assertNotNull(result);
    }

}

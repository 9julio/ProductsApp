package com.jafernandez.productsapp.units.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllersTests {

    @Autowired
    public MockMvc mvc;

    @Test
    public void test_getProductBySimilarId_OK() throws Exception {

        long id = 1L;

        MvcResult result = mvc
                .perform(get(String.format("/product/%s/similar", id)))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(result);
    }

}

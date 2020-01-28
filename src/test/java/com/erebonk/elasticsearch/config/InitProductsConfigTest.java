package com.erebonk.elasticsearch.config;

import com.erebonk.elasticsearch.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InitProductsConfigTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    InitProductsConfig initProductsConfig;

    @Test
    void hardProductsInit() {
        productRepository.deleteAll();
        initProductsConfig.initProductData();
   }

}
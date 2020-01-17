package com.erebonk.elasticsearch.config;

import com.erebonk.elasticsearch.repository.ReactiveProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InitProductsConfigTest {

    @Autowired
    ReactiveProductRepository reactiveProductRepository;

    @Autowired
    InitProductsConfig initProductsConfig;

    @Test
    void hardProductsInit() {
        reactiveProductRepository.deleteAll();
        initProductsConfig.initProductData();
   }


}
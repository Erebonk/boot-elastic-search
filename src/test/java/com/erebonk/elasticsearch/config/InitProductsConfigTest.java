package com.erebonk.elasticsearch.config;

import com.erebonk.elasticsearch.repository.ProductRepository;
import com.erebonk.elasticsearch.service.product.ProductRepositoryService;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.ElasticsearchClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class InitProductsConfigTest {

    @Autowired
    ProductRepository productRepository;

    @Mock
    ProductRepositoryService productRepositoryService;

    InitProductsConfig initProductsConfig;

    @BeforeEach
    void setUp() {
        given(productRepositoryService.findAll()).willReturn(null);
        initProductsConfig = new InitProductsConfig(productRepositoryService);
    }

    @Test
    void hardProductsInit() {
        productRepository.deleteAll();
        initProductsConfig.initProductData();
   }


}
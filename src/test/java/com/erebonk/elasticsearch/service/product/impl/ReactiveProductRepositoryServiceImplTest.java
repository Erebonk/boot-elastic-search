package com.erebonk.elasticsearch.service.product.impl;

import com.erebonk.elasticsearch.domain.Product;
import com.erebonk.elasticsearch.repository.ReactiveProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReactiveProductRepositoryServiceImplTest {

    @Autowired
    ReactiveProductRepository reactiveProductRepository;

    @Test
    void shouldSaveNewProduct() {
        Product product = new Product();
        product.setUid("uid123");
        product.setName("name");
        var savedProduct = reactiveProductRepository.save(product).block();
        assertNotNull(savedProduct);
        assertNotNull(savedProduct.getId());
    }

    @Test
    void shouldSaveAndFindById() {
        Product product = new Product();
        product.setName("test");
        product.setUid("UID123");
        var savedProduct = reactiveProductRepository.save(product).block();
        assertNotNull(savedProduct);
        var savProd = reactiveProductRepository.findById(savedProduct.getId()).block();
        assertNotNull(savProd);
        assertNotNull(savProd);
    }

    @Test
    void shouldDeleteAllProducts() {
        reactiveProductRepository.deleteAll().block();
    }

}
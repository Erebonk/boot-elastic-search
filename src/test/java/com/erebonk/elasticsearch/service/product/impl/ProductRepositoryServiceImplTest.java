package com.erebonk.elasticsearch.service.product.impl;

import com.erebonk.elasticsearch.domain.Product;
import com.erebonk.elasticsearch.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryServiceImplTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void shouldSaveNewProduct() {
        Product product = new Product();
        product.setUid("uid123");
        product.setName("name");
        var savedProduct = productRepository.save(product);
        assertNotNull(savedProduct);
        assertNotNull(savedProduct.getId());
    }

    @Test
    void shouldSaveAndFindById() {
        Product product = new Product();
        product.setName("test");
        product.setUid("UID123");
        var savedProduct = productRepository.save(product);
        assertNotNull(savedProduct);
        var savProd = productRepository.findById(savedProduct.getId());
        assertNotNull(savProd);
        assertNotNull(savProd);
    }

    @Test
    void shouldDeleteAllProducts() {
        productRepository.deleteAll();
    }

}
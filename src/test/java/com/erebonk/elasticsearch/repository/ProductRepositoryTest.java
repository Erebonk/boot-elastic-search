package com.erebonk.elasticsearch.repository;

import com.erebonk.elasticsearch.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void shouldDeleteAllProducts() {
        productRepository.deleteAll();
        productRepository.refresh();
    }

    @Test
    void shouldSaveProduct() {
        var product = productRepository.save(Product.builder()
                .name("test")
                .uid("123123")
                .build());
        assertNotNull(product);
        assertNotNull(product.getId());
    }

}
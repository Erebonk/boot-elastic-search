package com.erebonk.elasticsearch.repository;

import com.erebonk.elasticsearch.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Product repository test
 *
 * @author ilya
 * @version 1.0
 */
@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void shouldSaveProduct() {
        var product = productRepository.save(Product.builder()
                .name("test")
                .uid("123123")
                .build());
        assertNotNull(product);
        assertNotNull(product.getId());
    }

    @Test
    void shouldFindAllProducts() {
        var products = productRepository.findAll();
        assertNotNull(products);
    }

    @Test
    void shouldReturnAvailAmountOfProducts() {
        var availAmount = productRepository.count();
        assertTrue(availAmount > 0);
    }

    @Test
    void shouldDeleteAllProducts() {
        productRepository.deleteAll();
    }


}
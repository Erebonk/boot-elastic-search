package com.erebonk.elasticsearch.repository;

import com.erebonk.elasticsearch.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ReactiveProductRepositoryTest {

    @Autowired
    ReactiveProductRepository reactiveProductRepository;

    @Test
    void shouldSaveProduct() {
        var product = reactiveProductRepository.save(Product.builder()
                .name("test")
                .uid("123123")
                .build()).block();
        assertNotNull(product);
        assertNotNull(product.getId());
    }

    @Test
    void shouldFindAllProducts() {
        var products = reactiveProductRepository.findAll();
        assertNotNull(products);
        var productsList = products.collectList().block();
        assertNotNull(productsList);
    }

    @Test
    void shouldReturnAvailAmountOfProducts() {
        var availAmount = reactiveProductRepository.count().block();
        assertNotNull(availAmount);
        assertTrue(availAmount > 0);
    }

    @Test
    void shouldExecuteFindAllByNameAndReturnAvailProducts() {
        var searchProducts = reactiveProductRepository.findByName("hp").toStream();
        searchProducts.forEach(product -> {
            assertNotNull(product.getId());
        });
    }



}
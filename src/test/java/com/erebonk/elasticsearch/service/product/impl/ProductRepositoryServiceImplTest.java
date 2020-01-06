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
    void shouldSaveNewProductAndReturnSavedProduct() {
        var savedProducts = productRepository.findAll();
        assertNotNull(savedProducts);
        savedProducts.forEach(product -> {
            assertNotNull(product.getId());
            assertNotNull(product.getName());
        });

    }

}
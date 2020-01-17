package com.erebonk.elasticsearch.controller;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ProductControllerTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProductController productController;

    @Test
    void shouldFindAllProductsWhichStartsWithHP() {
        logger.info(() -> "start: " + LocalDateTime.now());
        var products = productController.searchByText("hp pavilion 15");
        assertNotNull(products);
        logger.info(() -> "end: " + LocalDateTime.now());
        logger.info(() -> "total products: " + products.get().count());
    }

}
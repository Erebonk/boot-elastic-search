package com.erebonk.elasticsearch.service.parse.impl;

import com.erebonk.elasticsearch.service.parse.ParserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParserServiceImplInt {

    @Autowired
    ParserService parserService;

    @Test
    void shouldReturnStreamOfProductsIfGoodLinks() {
        var productStream = parserService.parse(getClass().getResource("/static/Price-1.xml"));
        assertNotNull(productStream);
        assertTrue(productStream.findFirst().isPresent());
    }

    @Test
    void shouldReturnEmptyStreamIfLinkIsNull() {
        var productStream = parserService.parse(null);
        assertNotNull(productStream);
        assertFalse(productStream.findFirst().isPresent());
    }
}
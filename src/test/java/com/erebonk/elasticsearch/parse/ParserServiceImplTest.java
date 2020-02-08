package com.erebonk.elasticsearch.parse;

import com.erebonk.elasticsearch.service.parser.impl.ParserServiceImpl;
import com.erebonk.elasticsearch.service.processing.ProductRepositoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.MalformedURLException;

/**
 * Hard xml parser
 *
 * @author ilya
 * @version 1.0
 */
@SpringBootTest
class ParserServiceImplTest {

    @Autowired
    ProductRepositoryService productRepositoryService;

    @Test
    void shouldParseXMLAndSave() throws MalformedURLException {
        ParserServiceImpl parserServiceImpl = new ParserServiceImpl();
        var products = parserServiceImpl.parse("/Volumes/SP/Price.xml");
        products.forEach(productRepositoryService::save);
    }

}
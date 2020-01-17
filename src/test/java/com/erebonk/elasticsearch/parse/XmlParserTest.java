package com.erebonk.elasticsearch.parse;

import com.erebonk.elasticsearch.service.parse.XmlParser;
import com.erebonk.elasticsearch.service.product.ProductRepositoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;

/**
 * Hard xml parser
 *
 * @author ilya
 * @version 1.0
 */
@SpringBootTest
class XmlParserTest {

    @Autowired
    ProductRepositoryService productRepositoryService;

    @Test
    void shouldParseXMLAndSave() throws FileNotFoundException, XMLStreamException {
        XmlParser xmlParser = new XmlParser();
        var products = xmlParser.parse("/Volumes/SP/Price.xml");
        products.forEach(productRepositoryService::save);
    }

}
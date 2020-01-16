package com.erebonk.elasticsearch.parse;

import com.erebonk.elasticsearch.service.parse.XmlParser;
import org.junit.jupiter.api.Test;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class XmlParserTest {

    void shouldParseXML() throws FileNotFoundException, XMLStreamException {
        XmlParser xmlParser = new XmlParser();
        var products = xmlParser.parse("/Volumes/SP/Price.xml");
        assertNotNull(products);
        assertFalse(products.isEmpty());
    }

}
package com.erebonk.elasticsearch.service.parse.impl;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class ParserServiceImplTest {

    @Test
    void parse() throws ParserConfigurationException, IOException, SAXException {
        URL inputFile = getClass().getResource("/static/Price-1.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile.toString());
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("offer");

        for (int tempPosition = 0; tempPosition < nList.getLength(); tempPosition++) {
            Node nNode = nList.item(tempPosition);

        }

    }

}
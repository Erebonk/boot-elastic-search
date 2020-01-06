package com.erebonk.elasticsearch.service.parse.impl;

import com.erebonk.elasticsearch.domain.Product;
import com.erebonk.elasticsearch.service.parse.ParserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Xml parser services
 *
 * @author ilya
 * @version 1.0
 */
@Component
@Slf4j
public class ParserServiceImpl implements ParserService {

    @Override
    public Stream<Product> parse(URL url) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(url.toString());
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("offer");
            var productList = new ArrayList<Product>();

            for (int tempPosition = 0; tempPosition < nList.getLength(); tempPosition++) {
                Node nNode = nList.item(tempPosition);
                Element eElement = (Element) nNode;
                var uid = eElement.getElementsByTagName("uid").item(0).getTextContent();
                var prodUrl = eElement.getElementsByTagName("url").item(0).getTextContent();
                var priceR = eElement.getElementsByTagName("priceR").item(0).getTextContent();
                var priceB = eElement.getElementsByTagName("priceB").item(0).getTextContent();
                var priceC = eElement.getElementsByTagName("priceC").item(0).getTextContent();
                var priceD = eElement.getElementsByTagName("priceD").item(0).getTextContent();
                var priceE = eElement.getElementsByTagName("priceE").item(0).getTextContent();
                var priceF = eElement.getElementsByTagName("priceF").item(0).getTextContent();
                var priceRRP = eElement.getElementsByTagName("priceRRP").item(0).getTextContent();
                var categoryId = eElement.getElementsByTagName("categoryId").item(0).getTextContent();
                var currencyId = eElement.getElementsByTagName("currencyId").item(0).getTextContent();
                var name = eElement.getElementsByTagName("name").item(0).getTextContent();
                var picture = eElement.getElementsByTagName("picture").item(0).getTextContent();
                var pn = eElement.getElementsByTagName("PN").item(0).getTextContent();
                var remote = "";
                try {
                    remote = eElement.getElementsByTagName("remote").item(0).getTextContent();
                } catch (NullPointerException ignore) {}
                var russianName = eElement.getElementsByTagName("RussianName").item(0).getTextContent();
                var descrUpdated = eElement.getElementsByTagName("DescrUpdated").item(0).getTextContent();
                var model = eElement.getElementsByTagName("Model").item(0).getTextContent();
                var vendor = eElement.getElementsByTagName("Vendor").item(0).getTextContent();

                productList.add(Product.builder()
                        .uid(uid)
                        .url(prodUrl)
                        .priceR(BigDecimal.valueOf(Double.parseDouble(priceR)))
                        .priceB(BigDecimal.valueOf(Double.parseDouble(priceB)))
                        .priceC(BigDecimal.valueOf(Double.parseDouble(priceC)))
                        .priceD(BigDecimal.valueOf(Double.parseDouble(priceD)))
                        .priceE(BigDecimal.valueOf(Double.parseDouble(priceE)))
                        .priceF(BigDecimal.valueOf(Double.parseDouble(priceF)))
                        .priceRrc(BigDecimal.valueOf(Double.parseDouble(priceRRP)))
                        .categoryId(categoryId)
                        .currencyId(currencyId)
                        .name(name)
                        .picture(picture)
                        .partnumber(pn)
                        .remote(remote)
                        .nameRus(russianName)
                        .updateDate(LocalDate.parse(descrUpdated, DateTimeFormatter.ofPattern("yyyy.MM.dd")))
                        .model(model)
                        .vendor(vendor)
                        .build());
            }
            return productList.stream();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            log.error(e.getLocalizedMessage());
            return Stream.empty();
        }
    }
}

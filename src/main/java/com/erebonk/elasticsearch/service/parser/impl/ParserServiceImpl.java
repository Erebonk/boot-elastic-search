package com.erebonk.elasticsearch.service.parser.impl;

import com.erebonk.elasticsearch.domain.Product;
import com.erebonk.elasticsearch.service.parser.ParserService;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Xml parser for products xml list
 *
 * @author ilya
 * @version 1.1
 */
@Slf4j
public class ParserServiceImpl implements ParserService {

    @Override
    public Stream<Product> parse(@NotNull String address) {
        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            InputStream in = new FileInputStream(address);
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in, "Windows-1251");

            Stream.Builder<Product> productStream = Stream.builder();
            Product product = null;

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                //reach the start of an item
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();

                    if (startElement.getName().getLocalPart().equals("offer")) {
                        product = new Product();
                        // attribute
                        Iterator<Attribute> attributes = startElement.getAttributes();
                        while (attributes.hasNext()) {
                            Attribute attribute = attributes.next();
                            if (attribute.getName().toString().equals("id")) {
                                System.out.println("id = " + attribute.getValue());
                            }
                        }
                    }

                    // data
                    if (event.isStartElement()) {
                        switch (event.asStartElement().getName().getLocalPart()) {
                            case "uid":
                                event = eventReader.nextEvent();
                                if (!event.isEndElement()) {
                                    assert product != null;
                                    product.setUid(event.asCharacters().getData());
                                }
                                break;
                            case "url":
                                event = eventReader.nextEvent();
                                if (!event.isEndElement()) {
                                    assert product != null;
                                    product.setUrl(event.asCharacters().getData());
                                }
                                break;
                            case "priceR":
                                event = eventReader.nextEvent();
                                if (!event.isEndElement()) {
                                    assert product != null;
                                    product.setPriceR(BigDecimal.valueOf(
                                            Double.parseDouble(event.asCharacters().getData())));
                                }
                                break;
                            case "priceB":
                                event = eventReader.nextEvent();
                                if (!event.isEndElement()) {
                                    assert product != null;
                                    product.setPriceB(BigDecimal.valueOf(
                                            Double.parseDouble(event.asCharacters().getData())));
                                }
                                break;
                            case "priceC":
                                event = eventReader.nextEvent();
                                if (!event.isEndElement()) {
                                    assert product != null;
                                    product.setPriceC(BigDecimal.valueOf(
                                            Double.parseDouble(event.asCharacters().getData())));
                                }
                                break;
                            case "priceD":
                                event = eventReader.nextEvent();
                                if (!event.isEndElement()) {
                                    assert product != null;
                                    product.setPriceD(BigDecimal.valueOf(
                                            Double.parseDouble(event.asCharacters().getData())));
                                }
                                break;
                            case "priceE":
                                event = eventReader.nextEvent();
                                if (!event.isEndElement()) {
                                    assert product != null;
                                    product.setPriceE(BigDecimal.valueOf(
                                            Double.parseDouble(event.asCharacters().getData())));
                                }
                                break;
                            case "priceF":
                                event = eventReader.nextEvent();
                                if (!event.isEndElement()) {
                                    assert product != null;
                                    product.setPriceF(BigDecimal.valueOf(
                                            Double.parseDouble(event.asCharacters().getData())));
                                }
                                break;
                            case "priceRRP":
                                event = eventReader.nextEvent();
                                if (!event.isEndElement()) {
                                    assert product != null;
                                    product.setPriceRrc(
                                            BigDecimal.valueOf(
                                                    Double.parseDouble(
                                                            event.asCharacters().getData())));
                                }
                                break;
                            case "currencyId":
                                event = eventReader.nextEvent();
                                if (!event.isEndElement()) {
                                    assert product != null;
                                    product.setCurrencyId(event.asCharacters().getData());
                                }
                                break;
                            case "categoryId":
                                event = eventReader.nextEvent();
                                if (!event.isEndElement()) {
                                    assert product != null;
                                    product.setCategoryId(event.asCharacters().getData());
                                }
                                break;
                            case "picture":
                                event = eventReader.nextEvent();
                                if (!event.isEndElement()) {
                                    assert product != null;
                                    product.setPicture(event.asCharacters().getData());
                                }
                                break;
                            case "name":
                                event = eventReader.nextEvent();
                                if (!event.isEndElement()) {
                                    assert product != null;
                                    product.setName(event.asCharacters().getData());
                                }
                                break;
                            case "PN":
                                event = eventReader.nextEvent();
                                if (!event.isEndElement()) {
                                    assert product != null;
                                    product.setPartnumber(event.asCharacters().getData());
                                }
                                break;
                            case "RussianName":
                                event = eventReader.nextEvent();
                                if (!event.isEndElement()) {
                                    assert product != null;
                                    product.setNameRus(event.asCharacters().getData());
                                }
                                break;
                            case "DescrUpdated":
                                event = eventReader.nextEvent();
                                if (!event.isEndElement()) {
                                    assert product != null;
                                    product.setUpdateDate(event.asCharacters().getData());
                                }
                                break;
                            case "Model":
                                event = eventReader.nextEvent();
                                if (!event.isEndElement()) {
                                    assert product != null;
                                    product.setModel(event.asCharacters().getData());
                                }
                                break;
                            case "Vendor":
                                event = eventReader.nextEvent();
                                if (!event.isEndElement()) {
                                    assert product != null;
                                    product.setVendor(event.asCharacters().getData());
                                }
                                break;
                        }
                    }
                }

                //reach the end of an item
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals("offer")) {
                        productStream.add(product);
                        System.out.println("--end of an item\n");
                    }
                }
            }
            return productStream.build();
        } catch (FileNotFoundException | XMLStreamException e) {
            log.error("parser error! " + e.getLocalizedMessage());
            return Stream.empty();
        }
    }

}

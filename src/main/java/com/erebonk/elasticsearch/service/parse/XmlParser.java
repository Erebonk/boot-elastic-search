package com.erebonk.elasticsearch.service.parse;

import com.erebonk.elasticsearch.domain.Product;

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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Xml parser for products
 *
 * @author ilya
 * @version 1.0
 */
public class XmlParser {

    private List<Product> products = new ArrayList<>();

    public List<Product> parse(@NotNull String address) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        InputStream in = new FileInputStream(address);
        XMLEventReader eventReader = inputFactory.createXMLEventReader(in, "Windows-1251");
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
                    if (event.asStartElement().getName().getLocalPart().equals("uid")) {
                        event = eventReader.nextEvent();
                        if (!event.isEndElement()) {
                            product.setUid(event.asCharacters().getData());
                        }
                    } else if (event.asStartElement().getName().getLocalPart().equals("url")) {
                        event = eventReader.nextEvent();
                        if (!event.isEndElement()) {
                            product.setUrl(event.asCharacters().getData());
                        }
                    } else if (event.asStartElement().getName().getLocalPart().equals("priceR")) {
                        event = eventReader.nextEvent();
                        if (!event.isEndElement()) {
                            product.setPriceR(BigDecimal.valueOf(Double.parseDouble(event.asCharacters().getData())));
                        }
                    } else if (event.asStartElement().getName().getLocalPart().equals("priceB")) {
                        event = eventReader.nextEvent();
                        if (!event.isEndElement()) {
                            product.setPriceB(BigDecimal.valueOf(Double.parseDouble(event.asCharacters().getData())));
                        }
                    } else if (event.asStartElement().getName().getLocalPart().equals("priceC")) {
                        event = eventReader.nextEvent();
                        if (!event.isEndElement()) {
                            product.setPriceC(BigDecimal.valueOf(Double.parseDouble(event.asCharacters().getData())));
                        }
                    } else if (event.asStartElement().getName().getLocalPart().equals("priceD")) {
                        event = eventReader.nextEvent();
                        if (!event.isEndElement()) {
                            product.setPriceD(BigDecimal.valueOf(Double.parseDouble(event.asCharacters().getData())));
                        }
                    } else if (event.asStartElement().getName().getLocalPart().equals("priceE")) {
                        event = eventReader.nextEvent();
                        if (!event.isEndElement()) {
                            product.setPriceE(BigDecimal.valueOf(Double.parseDouble(event.asCharacters().getData())));
                        }
                    } else if (event.asStartElement().getName().getLocalPart().equals("priceF")) {
                        event = eventReader.nextEvent();
                        if (!event.isEndElement()) {
                            product.setPriceF(BigDecimal.valueOf(Double.parseDouble(event.asCharacters().getData())));
                        }
                    } else if (event.asStartElement().getName().getLocalPart().equals("priceRRP")) {
                        event = eventReader.nextEvent();
                        if (!event.isEndElement()) {
                            product.setPriceRrc(BigDecimal.valueOf(Double.parseDouble(event.asCharacters().getData())));
                        }
                    } else if (event.asStartElement().getName().getLocalPart().equals("currencyId")) {
                        event = eventReader.nextEvent();
                        if (!event.isEndElement()) {
                            product.setCurrencyId(event.asCharacters().getData());
                        }
                    } else if (event.asStartElement().getName().getLocalPart().equals("categoryId")) {
                        event = eventReader.nextEvent();
                        if (!event.isEndElement()) {
                            product.setCategoryId(event.asCharacters().getData());
                        }
                    } else if (event.asStartElement().getName().getLocalPart().equals("picture")) {
                        event = eventReader.nextEvent();
                        if (!event.isEndElement()) {
                            product.setPicture(event.asCharacters().getData());
                        }
                    } else if (event.asStartElement().getName().getLocalPart().equals("name")) {
                        event = eventReader.nextEvent();
                        if (!event.isEndElement()) {
                            product.setName(event.asCharacters().getData());
                        }
                    } else if (event.asStartElement().getName().getLocalPart().equals("PN")) {
                        event = eventReader.nextEvent();
                        if (!event.isEndElement()) {
                            product.setPartnumber(event.asCharacters().getData());
                        }
                    } else if (event.asStartElement().getName().getLocalPart().equals("RussianName")) {
                        event = eventReader.nextEvent();
                        if (!event.isEndElement()) {
                            product.setNameRus(event.asCharacters().getData());
                        }
                    } else if (event.asStartElement().getName().getLocalPart().equals("DescrUpdated")) {
                        event = eventReader.nextEvent();
                        if (!event.isEndElement()) {
                            product.setUpdateDate(event.asCharacters().getData());
                        }
                    } else if (event.asStartElement().getName().getLocalPart().equals("Model")) {
                        event = eventReader.nextEvent();
                        if (!event.isEndElement()) {
                            product.setModel(event.asCharacters().getData());
                        }
                    } else if (event.asStartElement().getName().getLocalPart().equals("Vendor")) {
                        event = eventReader.nextEvent();
                        if (!event.isEndElement()) {
                            product.setVendor(event.asCharacters().getData());
                        }
                    } else if (event.asStartElement().getName().getLocalPart().equals("currencyId")) {
                        event = eventReader.nextEvent();
                        if (!event.isEndElement()) {
                            product.setCurrencyId(event.asCharacters().getData());
                        }
                    } else if (event.asStartElement().getName().getLocalPart().equals("currencyId")) {
                        event = eventReader.nextEvent();
                        if (!event.isEndElement()) {
                            product.setCurrencyId(event.asCharacters().getData());
                        }
                    } else if (event.asStartElement().getName().getLocalPart().equals("currencyId")) {
                        event = eventReader.nextEvent();
                        if (!event.isEndElement()) {
                            product.setCurrencyId(event.asCharacters().getData());
                        }
                    }
                }
            }

            //reach the end of an item
            if (event.isEndElement()) {
                EndElement endElement = event.asEndElement();
                if (endElement.getName().getLocalPart().equals("offer")) {
                    products.add(product);
                    System.out.println("--end of an item\n");
                }
            }
        }
        return products;
    }

}

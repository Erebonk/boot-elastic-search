package com.erebonk.elasticsearch.service.parse;

import com.erebonk.elasticsearch.domain.Product;

import java.util.stream.Stream;

/**
 * Parse services for elastic search
 *
 * @author ilya
 * @version 1.0
 */
public interface ParserService {

    /**
     * Get product's stream
     * 
     * @param url url
     * @return stream of products
     */
    Stream<Product> parse(String url);

}

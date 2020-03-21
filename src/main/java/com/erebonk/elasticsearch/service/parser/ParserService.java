package com.erebonk.elasticsearch.service.parser;

import com.erebonk.elasticsearch.domain.Product;

import javax.validation.constraints.NotNull;
import java.util.stream.Stream;

/**
 * Parser services
 *
 * @author ilya
 * @version 1.0
 */
public interface ParserService {

    Stream<Product> parse(@NotNull String address);

}

package com.erebonk.elasticsearch.service.parse.impl;

import com.erebonk.elasticsearch.domain.Product;
import com.erebonk.elasticsearch.service.parse.ParserService;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ParserServiceImpl implements ParserService {


    @Override
    public Stream<Product> parse(String url) {
        return null;
    }
}

package com.erebonk.elasticsearch.config;

import com.erebonk.elasticsearch.service.parse.ParserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class InitProductsConf {

    private final ParserService parserService;

    @Bean
    public void initProductData() {
        var productStream = parserService.parse(getClass().getResource("/static/Price-1.xml"));
    }

}

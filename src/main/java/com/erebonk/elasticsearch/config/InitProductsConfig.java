package com.erebonk.elasticsearch.config;

import com.erebonk.elasticsearch.service.parser.ParserService;
import com.erebonk.elasticsearch.service.processing.ProductRepositoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Init configuration for elastic search
 *
 * @author ilya
 * @version 1.0
 */
@Slf4j
@Profile("dev")
@Configuration
@RequiredArgsConstructor
public class InitProductsConfig {

    private final ParserService parserService;
    private final ProductRepositoryService productRepositoryService;

    @Bean
    public void initProductData() {
        var productStream = parserService.parse(getClass().getResource("/static/Price-1.xml").toString());
        productStream.forEach(productRepositoryService::save);
    }
}

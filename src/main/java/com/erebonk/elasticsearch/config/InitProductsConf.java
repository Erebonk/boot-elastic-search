package com.erebonk.elasticsearch.config;

import com.erebonk.elasticsearch.service.parse.ParserService;
import com.erebonk.elasticsearch.service.product.ProductRepositoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Init configuration for elastic search
 *
 * @author ilya
 * @version 1.0
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class InitProductsConf {

    private final ParserService parserService;
    private final ProductRepositoryService productRepositoryService;

    @Bean
    public void initProductData() {
        var productStream = parserService.parse(getClass().getResource("/static/Price-1.xml"));
        productStream.forEach(productRepositoryService::save);
    }

}

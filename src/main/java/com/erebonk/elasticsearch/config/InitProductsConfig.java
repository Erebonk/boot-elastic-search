package com.erebonk.elasticsearch.config;

import com.erebonk.elasticsearch.service.parse.XmlParser;
import com.erebonk.elasticsearch.service.product.ProductRepositoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Init configuration for elastic search
 *
 * @author ilya
 * @version 1.2
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class InitProductsConfig {

    private final ProductRepositoryService productRepositoryService;

    @Value("${own.product.path}")
    private String pathValue;

    @Bean
    public void initProductData() {
        try {
            if (productRepositoryService.amount() <= 0L) {
                log.info("init new catalog....");
                XmlParser xmlParser = new XmlParser();
                try {
                    xmlParser.parse(pathValue).forEach(productRepositoryService::save);
                } catch (Exception ex) {
                    log.error("Error with creating products... see more details: "
                            + ex.getLocalizedMessage());
                }
                log.info("ready...");
            }
            log.info("Product already init");
        } catch (Exception ignore) {} // todo
    }

}

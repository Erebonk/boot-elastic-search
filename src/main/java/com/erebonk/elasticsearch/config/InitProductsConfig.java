package com.erebonk.elasticsearch.config;

import com.erebonk.elasticsearch.service.parse.XmlParser;
import com.erebonk.elasticsearch.service.product.ProductRepositoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
public class InitProductsConfig {

    private final ProductRepositoryService productRepositoryService;

    @Value("${settings.product.url}")
    private String address;

//    @Bean
    public void initProductData() {
//        try {
//            if (productRepositoryService.findAllByName("hp") == null) {
//                log.info("init new catalog....");
//                XmlParser xmlParser = new XmlParser();
//                try {
//                    xmlParser.parse(address).forEach(productRepositoryService::save);
//                } catch (Exception ex) {
//                    log.error("Error with creating products... see more details: " + ex.getLocalizedMessage());
//                }
//                log.info("ready...");
//            }
//            log.info("Product already init");
//        } catch (Exception ignore) {} // todo
    }

}

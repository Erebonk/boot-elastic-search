package com.erebonk.elasticsearch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class InitProducts {

    @Bean
    public void initProductData() {
        // todo: parse xml to elastic
    }

}

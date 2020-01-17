package com.erebonk.elasticsearch.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Map;

@SpringBootTest
class WebClient {

    @Autowired
    TestRestTemplate testRestTemplate;

    String url = "http://localhost:9000/products/search?";

    @Test
    void hardClientTest() {


        var req = testRestTemplate.getForObject(url + randomSymobls, Map.class);



    }

}

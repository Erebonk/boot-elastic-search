package com.erebonk.elasticsearch.client;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Fixed test
 *
 * @author ilya
 * @version 1.0
 */
@SpringBootTest
class WebHardClient {

    TestRestTemplate restTemplate = new TestRestTemplate();

    String url = "http://localhost:9000/products/search?text=";

    private static char rndChar() {
        int rnd = (int) (Math.random() * 52);
        char base = (rnd < 26) ? 'A' : 'a';
        return (char) (base + rnd % 26);
    }

    @Test
    void hardClientTest() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(50);

        for (int i = 0; i < 10000; i++) {
            service.execute(() -> {
                var twoChars = rndChar() + "" + rndChar();
                var result = restTemplate.getForObject(url + twoChars, Map.class);
                assertNotNull(result);
            });
        }

        service.shutdown();
        service.awaitTermination(10, TimeUnit.MINUTES);
    }

}

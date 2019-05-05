package org.spring.boot.examples.http.ssl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void sslTest() {

        ResponseEntity<String> response = restTemplate.getForEntity("https://reqres.in/api/products/3", String.class);
        System.out.println("Server response : , " + response.getBody());
    }
}

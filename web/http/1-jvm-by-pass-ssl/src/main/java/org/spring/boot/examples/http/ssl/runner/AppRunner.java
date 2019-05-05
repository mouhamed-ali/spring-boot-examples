package org.spring.boot.examples.http.ssl.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.examples.http.ssl.utils.SSLUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppRunner.class);
    private final RestTemplate restTemplate;
    private final SSLUtils sslUtils;

    public AppRunner(RestTemplate restTemplate, SSLUtils sslUtils) {
        this.restTemplate = restTemplate;
        this.sslUtils = sslUtils;
    }

    public void run(String... args) throws Exception {

        LOGGER.info("ssl verification status : {}", sslUtils.isSslVerificationEnabled());

        System.err.println("Start downloading ...");
        URL url = new URL("https://gorest.co.in/public-api/albums?_format=json&access-token=ysRSWNCcKHuO7xTHaqydo0Jo6rCbKpCch6B3");
        URLConnection con = url.openConnection();
        Reader reader = new InputStreamReader(con.getInputStream());
        while (true) {
            int ch = reader.read();
            if (ch == -1) {
                break;
            }
            System.err.print((char) ch);
        }

        System.err.println("End downloading.");

        //ResponseEntity<String> response = restTemplate.getForEntity("https://reqres.in/api/products/3", String.class);
        //LOGGER.info("Server response : {}", response.getBody());
    }
}

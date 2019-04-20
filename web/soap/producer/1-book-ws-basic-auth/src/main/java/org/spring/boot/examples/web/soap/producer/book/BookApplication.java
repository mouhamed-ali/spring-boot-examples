package org.spring.boot.examples.web.soap.producer.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }

    /*
     * to test the app you can create a soapui project using this url :
     * http://localhost:8080/ws/library/books.wsdl
     */
}

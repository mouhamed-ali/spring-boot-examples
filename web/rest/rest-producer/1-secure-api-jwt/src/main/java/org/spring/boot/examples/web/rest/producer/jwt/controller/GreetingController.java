package org.spring.boot.examples.web.rest.producer.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GreetingController {


    @GetMapping("/greeting/{name}")
    public String greeting(@PathVariable String name) {

        return String.format("Hello, %s!", name);
    }
}

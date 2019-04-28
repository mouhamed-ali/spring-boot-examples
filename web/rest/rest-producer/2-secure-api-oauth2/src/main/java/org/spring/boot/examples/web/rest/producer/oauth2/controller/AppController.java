package org.spring.boot.examples.web.rest.producer.oauth2.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {


    @GetMapping("/public")
    public String publicPage() {

        return "Public Page";
    }

    @GetMapping("/private")
    public String privatePage() {

        return "Private Page";
    }

    @GetMapping("/admin")
    public String adminPage() {

        return "Administrator Page";
    }
}

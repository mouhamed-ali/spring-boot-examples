package org.spring.boot.examples.testing.controller;

import org.spring.boot.examples.entities.GithubUser;
import org.spring.boot.examples.testing.service.GithubUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class GithubUserController {

    private final GithubUserService githubUserService;

    public GithubUserController(GithubUserService githubUserService) {
        this.githubUserService = githubUserService;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<GithubUser> findOne(@PathVariable Long id) {


        return new ResponseEntity<>(githubUserService.findById(id), HttpStatus.OK);
    }
}

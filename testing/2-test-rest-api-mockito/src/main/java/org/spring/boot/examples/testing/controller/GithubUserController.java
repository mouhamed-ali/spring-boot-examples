package org.spring.boot.examples.testing.controller;

import org.spring.boot.examples.entities.GithubRepository;
import org.spring.boot.examples.entities.GithubUser;
import org.spring.boot.examples.testing.service.GithubUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * our main service controller
 */
@RestController
@RequestMapping("/api/v1")
public class GithubUserController {

    private final GithubUserService githubUserService;

    public GithubUserController(GithubUserService githubUserService) {
        this.githubUserService = githubUserService;
    }

    /**
     * return a github user
     *
     * @param userName
     * @return
     */
    @GetMapping("/users/{userName}")
    public ResponseEntity<GithubUser> getUser(@PathVariable String userName) {


        return new ResponseEntity<>(githubUserService.findByUserName(userName), HttpStatus.OK);
    }

    /**
     * return a github user repositories
     *
     * @param userName
     * @return
     */
    @GetMapping("/users/{userName}/repos")
    public ResponseEntity<List<GithubRepository>> getUserRepositories(@PathVariable String userName) {


        return new ResponseEntity<>(githubUserService.getRepositories(userName), HttpStatus.OK);
    }

    /**
     * get a github user repository by its user name and repo name
     *
     * @param userName
     * @param reposName
     * @return
     */
    @GetMapping("/users/{userName}/repos/{reposName}")
    public ResponseEntity<GithubRepository> getUserRepository(@PathVariable String userName, @PathVariable String reposName) {


        return new ResponseEntity<>(githubUserService.getRepository(reposName, userName), HttpStatus.OK);
    }

    /**
     * get all database users userNames
     *
     * @return
     */
    @GetMapping("/users")
    public ResponseEntity<List<String>> getUsers() {


        return new ResponseEntity<>(githubUserService.findAll(), HttpStatus.OK);
    }
}

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
@RequestMapping("/github/api/v1")
public class GithubUserController {

    private final GithubUserService githubUserServiceDispatcher;

    public GithubUserController(GithubUserService githubUserServiceDispatcher) {
        this.githubUserServiceDispatcher = githubUserServiceDispatcher;
    }

    /**
     * return a github user
     *
     * @param userName
     * @return
     */
    @GetMapping("/users/{userName}")
    public ResponseEntity<GithubUser> getUser(@PathVariable String userName) {

        return new ResponseEntity<>(githubUserServiceDispatcher.findByUserName(userName), HttpStatus.OK);
    }

    /**
     * return a github user repositories
     *
     * @param userName
     * @return
     */
    @GetMapping("/users/{userName}/repos")
    public ResponseEntity<List<GithubRepository>> getUserRepositories(@PathVariable String userName) {

        return new ResponseEntity<>(githubUserServiceDispatcher.getRepositories(userName), HttpStatus.OK);
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

        return new ResponseEntity<>(githubUserServiceDispatcher.getRepository(userName, reposName), HttpStatus.OK);
    }

    /**
     * get all database users userNames
     *
     * @return
     */
    @GetMapping("/users")
    public ResponseEntity<List<String>> getUsers() {

        return new ResponseEntity<>(githubUserServiceDispatcher.findAll(), HttpStatus.OK);
    }
}

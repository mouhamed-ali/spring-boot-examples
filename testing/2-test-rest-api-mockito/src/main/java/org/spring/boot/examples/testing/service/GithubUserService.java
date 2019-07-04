package org.spring.boot.examples.testing.service;

import org.spring.boot.examples.entities.GithubRepository;
import org.spring.boot.examples.entities.GithubUser;

import java.util.List;

public interface GithubUserService {

    GithubUser findByUserName(String name);

    List<GithubRepository> getRepositories(String name);

    GithubRepository getRepository(String userName, String repoName);

    List<String> findAll();
}

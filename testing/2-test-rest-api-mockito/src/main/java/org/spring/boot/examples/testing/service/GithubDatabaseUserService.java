package org.spring.boot.examples.testing.service;

import org.spring.boot.examples.entities.GithubRepository;
import org.spring.boot.examples.entities.GithubUser;

import java.util.List;

public interface GithubDatabaseUserService {


    GithubUser saveUser(GithubUser s);

    List<GithubRepository> saveAllRepos(List<GithubRepository> repos);

    GithubRepository saveRepo(GithubRepository repo);
}

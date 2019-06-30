package org.spring.boot.examples.testing.service;

import org.spring.boot.examples.entities.GithubUser;

public interface GithubUserService {

    GithubUser findById(Long id);
}

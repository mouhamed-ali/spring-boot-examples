package org.spring.boot.examples.testing.dao;

import org.spring.boot.examples.entities.GithubUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GithubUserRepository extends JpaRepository<GithubUser, Long> {

    GithubUser findByLogin(String login);
}

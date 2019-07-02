package org.spring.boot.examples.testing.dao;

import org.spring.boot.examples.entities.GithubRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GithubRepositoryRepository extends JpaRepository<GithubRepository, Long> {

    List<GithubRepository> findByOwnerLogin(String id);

    GithubRepository findByNameAndOwnerLogin(String id, String ownerId);
}

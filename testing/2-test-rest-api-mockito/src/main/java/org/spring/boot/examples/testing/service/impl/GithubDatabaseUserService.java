package org.spring.boot.examples.testing.service.impl;

import org.spring.boot.examples.entities.GithubRepository;
import org.spring.boot.examples.entities.GithubUser;
import org.spring.boot.examples.testing.dao.GithubRepositoryRepository;
import org.spring.boot.examples.testing.dao.GithubUserRepository;
import org.spring.boot.examples.testing.service.GithubUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * this class implements the business layer of getting resources from the github api. after getting the resource will save it
 * in our database
 */
@Service
public class GithubDatabaseUserService implements GithubUserService, org.spring.boot.examples.testing.service.GithubDatabaseUserService {

    private final GithubUserRepository githubRepository;
    private final GithubRepositoryRepository githubRepositoryRepository;

    public GithubDatabaseUserService(GithubUserRepository githubRepository, GithubRepositoryRepository githubRepositoryRepository) {
        this.githubRepository = githubRepository;
        this.githubRepositoryRepository = githubRepositoryRepository;
    }

    @Override
    public GithubUser findByUserName(String id) {

        return githubRepository.findByLogin(id);
    }

    @Override
    public List<GithubRepository> getRepositories(String id) {

        return githubRepositoryRepository.findByOwnerLogin(id);
    }

    @Override
    public GithubRepository getRepository(String repoId, String userId) {

        return githubRepositoryRepository.findByLoginOwnerLogin(repoId, userId);
    }

    @Override
    public List<String> findAll() {

        return Optional.of(githubRepository.findAll())
                .orElse(new ArrayList<>())
                .stream()
                .map(GithubUser::getLogin)
                .collect(Collectors.toList());
    }

    @Override
    public GithubUser saveUser(GithubUser s) {

        return githubRepository.save(s);
    }

    @Override
    public List<GithubRepository> saveAllRepos(List<GithubRepository> repos) {

        return githubRepositoryRepository.saveAll(repos);
    }

    @Override
    public GithubRepository saveRepo(GithubRepository repo) {

        return githubRepositoryRepository.save(repo);
    }
}

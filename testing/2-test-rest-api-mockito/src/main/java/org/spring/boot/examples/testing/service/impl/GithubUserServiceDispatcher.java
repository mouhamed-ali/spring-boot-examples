package org.spring.boot.examples.testing.service.impl;

import org.spring.boot.examples.entities.GithubRepository;
import org.spring.boot.examples.entities.GithubUser;
import org.spring.boot.examples.testing.exceptions.ResourceNotFoundException;
import org.spring.boot.examples.testing.service.GithubUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class will try to get the github user from our database. if we can't find the user we will use the github
 * api to get it
 */
@Service
public class GithubUserServiceDispatcher implements GithubUserService {

    private final GithubUserService githubApiUserService;
    private final GithubUserService githubDatabaseUserService;

    public GithubUserServiceDispatcher(GithubUserService githubApiUserService, GithubUserService githubDatabaseUserService) {
        this.githubApiUserService = githubApiUserService;
        this.githubDatabaseUserService = githubDatabaseUserService;
    }

    @Override
    public GithubUser findByUserName(String userName) {

        GithubUser user = githubDatabaseUserService.findByUserName(userName);

        if (user == null) {

            user = githubApiUserService.findByUserName(userName);

            if (user == null)
                throw new ResourceNotFoundException(String.format("Not found user , %d", userName));

            ((GithubDatabaseUserService) githubDatabaseUserService).saveUser(user);
        }

        return user;
    }

    @Override
    public List<GithubRepository> getRepositories(String userName) {

        List<GithubRepository> repositories = githubDatabaseUserService.getRepositories(userName);

        if (repositories == null || repositories.isEmpty()) {

            repositories = githubApiUserService.getRepositories(userName);

            if (repositories == null || repositories.isEmpty())
                throw new ResourceNotFoundException(String.format("this user does not have any repository , %s", userName));

            ((GithubDatabaseUserService) githubDatabaseUserService).saveAllRepos(repositories);
        }
        return repositories;
    }

    @Override
    public GithubRepository getRepository(String userName, String repoName) {

        GithubRepository repository = githubDatabaseUserService.getRepository(userName, repoName);

        if (repository == null) {
            repository = githubApiUserService.getRepository(userName, repoName);
            ((GithubDatabaseUserService) githubDatabaseUserService).saveRepo(repository);
        }

        return repository;
    }

    @Override
    public List<String> findAll() {

        return githubDatabaseUserService.findAll();
    }
}

package org.spring.boot.examples.testing.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(GithubApiUserService.class);
    private final GithubUserService githubApiUserService;
    private final GithubUserService githubDatabaseUserService;

    public GithubUserServiceDispatcher(GithubUserService githubApiUserService, GithubUserService githubDatabaseUserService) {
        this.githubApiUserService = githubApiUserService;
        this.githubDatabaseUserService = githubDatabaseUserService;
    }

    @Override
    public GithubUser findByUserName(String userName) {

        GithubUser user = githubDatabaseUserService.findByUserName(userName);
        LOGGER.debug("The result of getting user from our data base was , {}", user);

        if (user == null) {

            LOGGER.debug("We didn't find the user in our data base, we will check for it in the github api");
            user = githubApiUserService.findByUserName(userName);
            LOGGER.debug("Received user from github api was , {}", user);

            if (user == null)
                throw new ResourceNotFoundException(String.format("Not found user , %s", userName));

            ((GithubDatabaseUserService) githubDatabaseUserService).saveUser(user);
            LOGGER.debug("We successfully saved the user in our data base");
        }

        return user;
    }

    @Override
    public List<GithubRepository> getRepositories(String userName) {

        List<GithubRepository> repositories = githubDatabaseUserService.getRepositories(userName);
        LOGGER.debug("The result of getting user repositories from our data base was , {}", repositories);


        if (repositories == null || repositories.isEmpty()) {

            LOGGER.debug("We didn't find the user repositories in our data base, we will check for it in the github api");
            repositories = githubApiUserService.getRepositories(userName);
            LOGGER.debug("Received repositories from github api was , {}", repositories);

            if (repositories == null || repositories.isEmpty())
                throw new ResourceNotFoundException(String.format("this user does not have any repository , %s", userName));

            // get user
            GithubUser user = findByUserName(userName);
            repositories.forEach(githubRepository -> user.addRepository(githubRepository));

            //((GithubDatabaseUserService) githubDatabaseUserService).saveAllRepos(repositories);
            ((GithubDatabaseUserService) githubDatabaseUserService).saveUser(user);
            LOGGER.debug("We successfully saved the user repositories in our data base");
        }
        return repositories;
    }

    @Override
    public GithubRepository getRepository(String userName, String repoName) {

        GithubRepository repository = githubDatabaseUserService.getRepository(userName, repoName);
        LOGGER.debug("The result of getting the user repository from our data base was , {}", repository);

        if (repository == null) {

            LOGGER.debug("We didn't find the user repository in our data base, we will check for it in the github api");
            repository = githubApiUserService.getRepository(userName, repoName);
            LOGGER.debug("Received user repository from github api was , {}", repository);

            if (repository == null)
                throw new ResourceNotFoundException(String.format("we can't match this repository [%s] to this user [%s]", repoName, userName));

            // get user
            GithubUser user = findByUserName(userName);
            user.addRepository(repository);

            //((GithubDatabaseUserService) githubDatabaseUserService).saveRepo(repository);
            ((GithubDatabaseUserService) githubDatabaseUserService).saveUser(user);
            LOGGER.debug("We successfully saved the user repository in our data base");
        }

        return repository;
    }

    @Override
    public List<String> findAll() {

        LOGGER.debug("Getting all the user names from our data base");
        return githubDatabaseUserService.findAll();
    }
}

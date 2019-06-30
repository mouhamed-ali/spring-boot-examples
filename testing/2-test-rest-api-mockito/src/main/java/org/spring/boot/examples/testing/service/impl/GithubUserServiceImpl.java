package org.spring.boot.examples.testing.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.examples.entities.GithubUser;
import org.spring.boot.examples.testing.dao.GithubUserRepository;
import org.spring.boot.examples.testing.service.GithubUserService;
import org.springframework.stereotype.Service;


@Service
public class GithubUserServiceImpl implements GithubUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GithubUserServiceImpl.class);

    private final GithubUserRepository githubRepository;

    public GithubUserServiceImpl(GithubUserRepository githubRepository) {
        this.githubRepository = githubRepository;
    }

    @Override
    public GithubUser findById(Long id) {

        LOGGER.debug("Searching for this user id : {}", id);
        return githubRepository.getOne(id);
    }
}

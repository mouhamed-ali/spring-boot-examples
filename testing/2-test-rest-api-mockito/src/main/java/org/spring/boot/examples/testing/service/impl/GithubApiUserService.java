package org.spring.boot.examples.testing.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.examples.entities.GithubRepository;
import org.spring.boot.examples.entities.GithubUser;
import org.spring.boot.examples.testing.dao.GithubRepositoryRepository;
import org.spring.boot.examples.testing.dao.GithubUserRepository;
import org.spring.boot.examples.testing.exceptions.ResourceFormatException;
import org.spring.boot.examples.testing.exceptions.ResourceNotFoundException;
import org.spring.boot.examples.testing.service.GithubUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * this class implements the business layer of getting resources from the github api. after getting the resource will save it
 * in our database
 */
@Service
public class GithubApiUserService implements GithubUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GithubApiUserService.class);

    @Value("${github.user.api}")
    private static String gitHubUserApi;
    @Value("${github.repo.api}")
    private static String gitHubRepoApi;

    private final RestTemplate restTemplate;
    private final GithubUserRepository githubUserRepository;
    private final GithubRepositoryRepository githubRepositoryRepository;

    public GithubApiUserService(RestTemplate restTemplate, GithubUserRepository githubUserRepository, GithubRepositoryRepository githubRepositoryRepository) {
        this.restTemplate = restTemplate;
        this.githubUserRepository = githubUserRepository;
        this.githubRepositoryRepository = githubRepositoryRepository;
    }

    @Override
    public GithubUser findByUserName(String id) {

        validateIdentifier(id);
        return githubUserRepository.findByLogin(id);
    }

    /**
     * Assert that the id cannot be null
     *
     * @param id
     */
    private void validateIdentifier(String id) {

        if (id == null || "".equals(id.trim()))
            throw new ResourceFormatException("id cannot be null");
    }

    @Override
    public List<GithubRepository> getRepositories(String id) {

        validateIdentifier(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<List<GithubRepository>> response = restTemplate.exchange(
                String.format(gitHubRepoApi, id),
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<GithubRepository>>() {
                });

        return response.getBody();
    }

    @Override
    public GithubRepository getRepository(String userId, String repoId) {

        LOGGER.debug("validate user id");
        validateIdentifier(userId);

        LOGGER.debug("validate repository id");
        validateIdentifier(repoId);

        ResponseEntity<List<GithubRepository>> response = restTemplate.exchange(
                String.format(gitHubRepoApi, userId),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<GithubRepository>>() {
                });

        GithubRepository repository = Optional.ofNullable(response)
                .map(ResponseEntity::getBody)
                .orElse(new ArrayList<>())
                .stream()
                .filter(
                        githubRepository -> userId.equals(githubRepository.getName())
                )
                .findFirst()
                .orElse(null);


        if (repository == null)
            throw new ResourceNotFoundException(String.format("this user does not have any repository , %s", userId));

        return repository;
    }

    @Override
    public List<String> findAll() {

        throw new RuntimeException("not yet implemented");
    }
}

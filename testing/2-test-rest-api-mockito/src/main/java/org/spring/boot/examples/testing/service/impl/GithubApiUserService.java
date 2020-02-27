package org.spring.boot.examples.testing.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.examples.entities.GithubRepository;
import org.spring.boot.examples.entities.GithubUser;
import org.spring.boot.examples.testing.config.GithubURLConfig;
import org.spring.boot.examples.testing.exceptions.ResourceNotFoundException;
import org.spring.boot.examples.testing.service.GithubUserService;
import org.spring.boot.examples.testing.utils.GithubDatesUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
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
    private final RestTemplate restTemplate;
    private final GithubURLConfig githubURLConfig;

    public GithubApiUserService(RestTemplate restTemplate, GithubURLConfig githubURLConfig) {
        this.restTemplate = restTemplate;
        this.githubURLConfig = githubURLConfig;
    }

    @Override
    public GithubUser findByUserName(String id) {

        try {

            GithubUser user = restTemplate.getForObject(
                    String.format(githubURLConfig.getGitHubUserApi(), id),
                    GithubUser.class);
            this.transformDates(user);
            return user;
        } catch (HttpClientErrorException e) {

            if (HttpStatus.NOT_FOUND.equals(e.getStatusCode()))
                throw new ResourceNotFoundException(String.format("Not found user , %s", id));
            else
                throw e;
        }
    }

    /**
     * this method will change the zoneid of the received dates
     *
     * @param user
     */
    private void transformDates(GithubUser user) {

        if (user.getCreationDate() != null)
            user.setCreationDate(
                    GithubDatesUtils.getLocalDateTime(user.getCreationDate())
            );
    }

    @Override
    public List<GithubRepository> getRepositories(String id) {

        try {

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<>("body", headers);

            ResponseEntity<List<GithubRepository>> response = restTemplate.exchange(
                    String.format(githubURLConfig.getGitHubRepoApi(), id),
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<List<GithubRepository>>() {
                    });

            return response.getBody();
        } catch (HttpClientErrorException e) {

            if (HttpStatus.NOT_FOUND.equals(e.getStatusCode()))
                throw new ResourceNotFoundException(String.format("this user does not have any repository , %s", id));
            else
                throw e;
        }
    }

    @Override
    public GithubRepository getRepository(String userName, String repoName) {

        try {

            ResponseEntity<List<GithubRepository>> response = restTemplate.exchange(
                    String.format(githubURLConfig.getGitHubRepoApi(), userName),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<GithubRepository>>() {
                    });

            GithubRepository repository = Optional.ofNullable(response)
                    .map(ResponseEntity::getBody)
                    .orElse(new ArrayList<>())
                    .stream()
                    .filter(
                            githubRepository -> repoName.equals(githubRepository.getName())
                    )
                    .findFirst()
                    .orElse(null);

            return repository;
        } catch (HttpClientErrorException e) {

            if (HttpStatus.NOT_FOUND.equals(e.getStatusCode()))
                throw new ResourceNotFoundException(String.format("we can't match this repository [%s] to this user [%s]", repoName, userName));
            else
                throw e;
        }
    }

    @Override
    public List<String> findAll() {

        throw new RuntimeException("not yet implemented");
    }
}

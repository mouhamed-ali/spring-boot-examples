package org.spring.boot.examples.testing.test.data.controller;

import org.spring.boot.examples.entities.GithubRepository;
import org.spring.boot.examples.entities.GithubUser;

import java.time.LocalDate;

public class GetUserController {

    public static final GithubUser getUser() {

        GithubRepository repository = new GithubRepository()
                .setId(188292833L)
                .setDefaultBranch("master")
                .setDescription(null)
                .setFork(false)
                .setFullName("pivotal/.github")
                .setLanguage(null)
                .setName(".github")
                .setUrl("https://api.github.com/repos/pivotal/.github");

        GithubUser user = new GithubUser()
                .setId(33104318L)
                .setCreationDate(LocalDate.of(2017, 10, 25))
                .setEmail("info@pivotal.io")
                .setLocation("San Francisco, CA")
                .setLogin("pivotal")
                .setName("Pivotal")
                .setType("Organization")
                .setUrl("https://api.github.com/users/pivotal")
                .addRepository(repository);

        return user;
    }

    public static final GithubUser getUserGithub(String login, Long id) {

        GithubUser user = new GithubUser()
                .setId(id)
                .setCreationDate(LocalDate.of(2017, 10, 25))
                .setEmail("info@pivotal.io")
                .setLocation("San Francisco, CA")
                .setLogin(login)
                .setName(login)
                .setType("Organization")
                .setUrl("https://api.github.com/users/" + login);

        return user;
    }
}

package org.spring.boot.examples.testing.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GithubURLConfig {

    @Value("${github.user.api}")
    private String gitHubUserApi;

    @Value("${github.repo.api}")
    private String gitHubRepoApi;

    public String getGitHubUserApi() {
        return gitHubUserApi;
    }

    public GithubURLConfig setGitHubUserApi(String gitHubUserApi) {
        this.gitHubUserApi = gitHubUserApi;
        return this;
    }

    public String getGitHubRepoApi() {
        return gitHubRepoApi;
    }

    public GithubURLConfig setGitHubRepoApi(String gitHubRepoApi) {
        this.gitHubRepoApi = gitHubRepoApi;
        return this;
    }

    @Override
    public String toString() {
        return "GithubURLConfig{" +
                "gitHubUserApi='" + gitHubUserApi + '\'' +
                ", gitHubRepoApi='" + gitHubRepoApi + '\'' +
                '}';
    }
}

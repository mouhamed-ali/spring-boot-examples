package org.spring.boot.examples.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class GithubUser {

    private Long id;
    private String login;
    private String url;
    private String type;
    private String name;
    private String location;
    private String email;
    private List<GithubRepository> repositories;

    @JsonProperty("created_at") // the name of the property is created_at on the github service
    private LocalDateTime creationDate;

    public GithubUser() {
        this.repositories = new ArrayList<>();
    }

    @Id
    public Long getId() {
        return id;
    }

    public GithubUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public GithubUser setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public GithubUser setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getType() {
        return type;
    }

    public GithubUser setType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public GithubUser setName(String name) {
        this.name = name;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public GithubUser setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public GithubUser setEmail(String email) {
        this.email = email;
        return this;
    }

    @Column(name = "creation_date", columnDefinition = "DATE")
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public GithubUser setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval=true)
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<GithubRepository> getRepositories() {
        return repositories;
    }

    public GithubUser setRepositories(List<GithubRepository> repositories) {
        this.repositories = repositories;
        return this;
    }

    /**
     * add a new repository to the current user
     *
     * @param githubRepository
     * @return
     */
    public GithubUser addRepository(GithubRepository githubRepository) {

        this.repositories.add(githubRepository);
        if (githubRepository.getOwner() != this) {
            githubRepository.setOwner(this);
        }
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", url='" + url + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GithubUser githubUser = (GithubUser) o;
        return id.equals(githubUser.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

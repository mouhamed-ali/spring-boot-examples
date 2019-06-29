package org.spring.boot.examples.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class User {

    private Long id;
    private String login;
    private String url;
    private String type;
    private String name;
    private String location;
    private String email;
    private LocalDate creationDate;
    private List<Repository> repositories;

    public User() {
        this.repositories = new ArrayList<>();
    }

    @Id
    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public User setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getType() {
        return type;
    }

    public User setType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public User setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    @Column(name = "creation_date", columnDefinition = "DATE")
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public User setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner", cascade = CascadeType.ALL)
    public List<Repository> getRepositories() {
        return repositories;
    }

    public User setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
        return this;
    }

    /**
     * add a new repository to the current user
     *
     * @param repository
     * @return
     */
    public User addRepository(Repository repository) {

        this.repositories.add(repository);
        if (repository.getOwner() != this) {
            repository.setOwner(this);
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
                ", repositories=" + repositories +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

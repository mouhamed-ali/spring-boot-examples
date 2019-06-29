package org.spring.boot.examples.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Repository {

    private Long id;
    private String name;
    private String fullName;
    private String description;
    private String url;
    private Boolean fork;
    private String language;
    private String defaultBranch;
    private User owner;

    @Id
    public Long getId() {
        return id;
    }

    public Repository setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Repository setName(String name) {
        this.name = name;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public Repository setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Repository setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Repository setUrl(String url) {
        this.url = url;
        return this;
    }

    public Boolean getFork() {
        return fork;
    }

    public Repository setFork(Boolean fork) {
        this.fork = fork;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public Repository setLanguage(String language) {
        this.language = language;
        return this;
    }

    @Column(name = "default_branch")
    public String getDefaultBranch() {
        return defaultBranch;
    }

    public Repository setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
        return this;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    public User getOwner() {
        return owner;
    }

    public Repository setOwner(User owner) {
        this.owner = owner;
        return this;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", fork=" + fork +
                ", language='" + language + '\'' +
                ", defaultBranch='" + defaultBranch + '\'' +
                ", owner=" + owner +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repository that = (Repository) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

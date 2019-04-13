package org.spring.boot.examples.multithreading.async.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;


@JsonIgnoreProperties(ignoreUnknown = true)
/*
 * The @JsonIgnoreProperties annotation signals Spring to ignore any attributes not listed in the class.
 * This makes it easy to make REST calls and produce domain objects.
 */
public class User {

    private String name;
    private String blog;

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getBlog() {
        return blog;
    }

    public User setBlog(String blog) {
        this.blog = blog;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", blog='" + blog + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name) &&
                blog.equals(user.blog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, blog);
    }
}

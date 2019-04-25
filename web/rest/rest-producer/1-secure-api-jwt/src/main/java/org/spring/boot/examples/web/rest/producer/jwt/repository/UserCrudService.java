package org.spring.boot.examples.web.rest.producer.jwt.repository;

import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UserCrudService {

    User save(User user);

    Optional<User> find(String id);

    Optional<User> findByUsername(String username);
}

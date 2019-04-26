package org.spring.boot.examples.web.rest.producer.jwt.repository;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InMemoryUsers implements UserCrudService, InitializingBean {

    Map<String, User> users = new HashMap<>();

    @Override
    public User save(final User user) {
        return users.put(user.getUsername(), user);
    }

    @Override
    public Optional<User> find(final String id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public Optional<User> findByUsername(final String username) {
        return users
                .values()
                .stream()
                .filter(u -> Objects.equals(username, u.getUsername()))
                .findFirst();
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        save(new User("user", "password", Arrays.asList(new SimpleGrantedAuthority("USER"))));
    }
}

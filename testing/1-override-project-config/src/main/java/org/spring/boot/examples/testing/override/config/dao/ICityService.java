package org.spring.boot.examples.testing.override.config.dao;

import org.spring.boot.examples.testing.override.config.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityService extends JpaRepository<City, Long> {
}

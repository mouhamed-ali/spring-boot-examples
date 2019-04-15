package org.spring.boot.examples.testing.override.config.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cities")
@SequenceGenerator(name = "my_sequence", initialValue = 10, allocationSize = 1)
public class City {

    private Long id;
    private String name;
    private Integer population;
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_sequence")
    public Long getId() {
        return id;
    }

    public City setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public City setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPopulation() {
        return population;
    }

    public City setPopulation(Integer population) {
        this.population = population;
        return this;
    }

    @Column(columnDefinition = "text")
    public String getDescription() {
        return description;
    }

    public City setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id.equals(city.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", description='" + description + '\'' +
                '}';
    }
}

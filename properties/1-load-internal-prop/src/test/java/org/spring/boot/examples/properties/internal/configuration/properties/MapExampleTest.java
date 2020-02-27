package org.spring.boot.examples.properties.internal.configuration.properties;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapExampleTest {

    @Autowired
    MapExample mapExample;

    @Test
    public void propertiesTest() {

        Assertions.assertThat(mapExample.getAdministrators()).containsKeys("admin", "owner");
        Assertions.assertThat(mapExample.getAdministrators()).containsValues("admin@mail.com", "owner@mail.com");
    }
}

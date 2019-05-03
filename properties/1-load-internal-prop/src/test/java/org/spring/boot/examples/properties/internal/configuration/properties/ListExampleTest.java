package org.spring.boot.examples.properties.internal.configuration.properties;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ListExampleTest {

    @Autowired
    ListExample listExample;

    @Test
    public void propertiesTest() {

        Assertions.assertThat(listExample.getUsers()).containsExactly("first", "second", "third");
    }
}

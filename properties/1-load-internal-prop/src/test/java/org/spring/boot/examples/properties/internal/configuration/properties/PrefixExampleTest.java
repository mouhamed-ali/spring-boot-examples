package org.spring.boot.examples.properties.internal.configuration.properties;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrefixExampleTest {

    @Autowired
    PrefixExample prefixExample;

    @Test
    public void propertiesTest() {

        Assertions.assertThat(prefixExample.getUrl()).isEqualTo("jdbc:postgresql:/localhost:5432/instance");
        Assertions.assertThat(prefixExample.getUserName()).isEqualTo("foo");
        Assertions.assertThat(prefixExample.getPassword()).isEqualTo("bar");
    }
}

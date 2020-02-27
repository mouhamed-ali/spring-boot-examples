package org.spring.boot.examples.properties.external.configuration.properties;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.boot.examples.properties.external.InitTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrefixExampleTest extends InitTest {

    @Autowired
    PrefixExample prefixExample;

    @Test
    public void propertiesTest() {

        Assertions.assertThat(prefixExample.getUrl()).isEqualTo("jdbc:postgresql:/localhost:5432/instance");
        Assertions.assertThat(prefixExample.getUserName()).isEqualTo("foo");
        Assertions.assertThat(prefixExample.getPassword()).isEqualTo("bar");
    }
}

package org.spring.boot.examples.properties.internal.env;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnvConfigPropertiesTest {

    @Autowired
    EnvConfigProperties configProperties;

    @Test
    public void propertiesTest() {

        Assertions.assertThat(configProperties.getUrl()).isEqualTo("jdbc:postgresql:/localhost:5432/instance");
        Assertions.assertThat(configProperties.getUserName()).isEqualTo("foo");
        Assertions.assertThat(configProperties.getPassword()).isEqualTo("bar");
        Assertions.assertThat(configProperties.getSecret()).isEqualTo("256p");
    }
}

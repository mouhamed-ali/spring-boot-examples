package org.spring.boot.examples.properties.internal.value;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValueConfigPropertiesTest {

    @Autowired
    ValueConfigProperties configProperties;

    @Test
    public void propertiesTest() {

        Assertions.assertThat(configProperties.getUrl()).isEqualTo("jdbc:postgresql:/localhost:5432/instance");
        Assertions.assertThat(configProperties.getUserName()).isEqualTo("foo");
        Assertions.assertThat(configProperties.getPassword()).isEqualTo("bar");
        Assertions.assertThat(configProperties.getSecret()).isEqualTo("foo");
        Assertions.assertThat(configProperties.getNotFound()).isEqualTo("404");
    }
}

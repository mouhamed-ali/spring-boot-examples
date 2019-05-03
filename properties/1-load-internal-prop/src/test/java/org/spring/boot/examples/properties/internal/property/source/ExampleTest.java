package org.spring.boot.examples.properties.internal.property.source;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExampleTest {

    @Autowired
    Example example;

    @Test
    public void propertiesTest() {

        Assertions.assertThat(example.getHostName()).isEqualTo("jhost@mail.com");
        Assertions.assertThat(example.getFrom()).isEqualTo("mailer@mail.com");
        Assertions.assertThat(example.getPort()).isEqualTo(9000);
    }
}

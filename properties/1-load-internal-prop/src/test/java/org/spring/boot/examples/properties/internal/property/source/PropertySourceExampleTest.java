package org.spring.boot.examples.properties.internal.property.source;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertySourceExampleTest {

    @Autowired
    PropertySourceExample propertySourceExample;

    @Test
    public void propertiesTest() {

        Assertions.assertThat(propertySourceExample.getHostName()).isEqualTo("host@mail.com");
        Assertions.assertThat(propertySourceExample.getFrom()).isEqualTo("mailer@mail.com");
        Assertions.assertThat(propertySourceExample.getPort()).isEqualTo(9000);
    }
}

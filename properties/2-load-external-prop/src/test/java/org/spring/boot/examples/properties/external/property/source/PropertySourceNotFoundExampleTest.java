package org.spring.boot.examples.properties.external.property.source;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.boot.examples.properties.external.InitTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertySourceNotFoundExampleTest extends InitTest {

    @Autowired
    PropertySourceNotFoundExample propertySourceNotFoundExample;

    @Test
    public void propertiesTest() {

        Assertions.assertThat(propertySourceNotFoundExample.getFrom()).isEqualTo("mailer@mail.com");
        Assertions.assertThat(propertySourceNotFoundExample.getUrl()).isEqualTo("not_found_url");
    }
}

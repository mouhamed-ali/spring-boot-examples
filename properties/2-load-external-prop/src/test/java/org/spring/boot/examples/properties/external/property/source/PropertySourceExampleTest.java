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
public class PropertySourceExampleTest extends InitTest {

    @Autowired
    PropertySourceExample propertySourceExample;

    @Test
    public void propertiesTest() {

        Assertions.assertThat(propertySourceExample.getHostName()).isEqualTo("host@mail.com");
        Assertions.assertThat(propertySourceExample.getVersion()).isEqualTo("1.0");
    }
}

package org.spring.boot.examples.properties.external.env;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.boot.examples.properties.external.InitTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnvConfigPropertiesTest extends InitTest {

    @Autowired
    EnvConfigProperties envConfigProperties;

    @Test
    public void propertiesTest() {

        Assertions.assertThat(envConfigProperties.getVersion()).isEqualTo("1.0");
        Assertions.assertThat(envConfigProperties.getName()).isEqualTo("TestApp");
        Assertions.assertThat(envConfigProperties.getDate()).isEqualTo("2016-11-12");
    }
}

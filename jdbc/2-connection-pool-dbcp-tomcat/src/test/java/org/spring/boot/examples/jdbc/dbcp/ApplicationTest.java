package org.spring.boot.examples.jdbc.dbcp;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Value("${spring.datasource.type}")
    private String dataSourceType;

    @Autowired
    private DataSource dataSource;

    @Test
    public void tomcatConnectionPoolIsConfigured() {
        Assertions.assertThat(dataSource.getClass().getName()).isEqualTo(dataSourceType);
    }
}

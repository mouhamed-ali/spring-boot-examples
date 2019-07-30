package org.spring.boot.examples.jdbc.dbcp.test;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScriptTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testRowsNumber() {

        Map<String, Object> rows = jdbcTemplate.queryForList("SELECT COUNT(*) AS ROWS FROM CUSTOMER").get(0);
        Assertions.assertThat(rows.get("ROWS")).isEqualTo(3L);
    }

    @Test
    public void testValidationTimeout() {

        // to test this behavior : add a debug point in the below instruction
        //after intercepting the code, you must shutdown the database and resume the code execution
        Map<String, Object> rows = null;
        // here we can test the 2 seconds timeout
        try {
            rows = jdbcTemplate.queryForList("SELECT COUNT(*) AS ROWS FROM CUSTOMER").get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //add a debug point in the code below and run the database
        System.out.println("Start database");
        rows = jdbcTemplate.queryForList("SELECT COUNT(*) AS ROWS FROM CUSTOMER").get(0);//TODO : this works ?
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // add an another debug point in the instruction below
        // here we can test 60 seconds of validation
        rows = jdbcTemplate.queryForList("SELECT COUNT(*) AS ROWS FROM CUSTOMER").get(0);
        Assertions.assertThat(rows.get("ROWS")).isEqualTo(3L);
    }

}

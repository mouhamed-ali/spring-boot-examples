package org.spring.boot.examples.testing.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * in this class we will test the h2 database, data base data will be loaded from data.sql and schema.sql
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class GithubDatabaseUserServiceTest {

    @Autowired
    public GithubDatabaseUserService githubDatabaseUserService;

    @Test
    @Ignore
    // TODO : check why the @DirtiesContext annotation does not work for this test
    public void findByUserNameTest() {

        Assertions.assertThat(githubDatabaseUserService.findAll().size()).isEqualTo(3);
    }
}

package org.spring.boot.examples.properties.external;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class InitTest {

    @BeforeClass
    public static void setup() {

        System.setProperty("APP_HOME", "D:/tmp/config-files");
    }

    @AfterClass
    public static void tearDown() {

        System.clearProperty("APP_HOME");
    }
}

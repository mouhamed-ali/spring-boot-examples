package org.spring.boot.examples.properties.external;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class InitTest {

    @BeforeClass
    public static void setup() {
        String currentConfigPath = System.getProperty("user.dir") + "/src/main/resources/configuration";
        System.out.printf("Current config path : %s %n", currentConfigPath);
        System.setProperty("APP_HOME", currentConfigPath);
    }

    @AfterClass
    public static void tearDown() {

        System.clearProperty("APP_HOME");
    }
}

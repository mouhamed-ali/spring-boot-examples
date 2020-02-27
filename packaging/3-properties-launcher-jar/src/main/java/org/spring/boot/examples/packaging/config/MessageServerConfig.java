package org.spring.boot.examples.packaging.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("file:smtp-config.properties")
public class MessageServerConfig implements InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageServerConfig.class);
    private Environment environment;

    public MessageServerConfig(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        LOGGER.info("#########################  Server configuration  #####");
        LOGGER.info("# from : {}", environment.getProperty("smtp.from"));
        LOGGER.info("# deliveryMethod : {}", environment.getProperty("smtp.deliveryMethod"));
        LOGGER.info("# host : {}", environment.getProperty("smtp.host"));
        LOGGER.info("# password : {}", environment.getProperty("smtp.password"));
        LOGGER.info("# userName : {}", environment.getProperty("smtp.userName"));
        LOGGER.info("# port : {}", environment.getProperty("smtp.port"));
        LOGGER.info("# EnableSsl : {}", environment.getProperty("smtp.EnableSsl"));
        LOGGER.info("#########################  Server configuration  #####");
    }
}

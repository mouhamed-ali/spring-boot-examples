package org.spring.boot.examples.profiles.runner;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.examples.profiles.config.DataBaseConfig;
import org.spring.boot.examples.profiles.service.MailSender;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final MailSender mailSender;
    private final DataBaseConfig databaseConfig;

    public AppRunner(MailSender mailSender, DataBaseConfig databaseConfig) {
        this.mailSender = mailSender;
        this.databaseConfig = databaseConfig;
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info("Load database configuration ...");
        logger.info(databaseConfig.toString());
        mailSender.send("info@gmail.com", "dummy test", "Hi, this is a dummy test");
    }
}

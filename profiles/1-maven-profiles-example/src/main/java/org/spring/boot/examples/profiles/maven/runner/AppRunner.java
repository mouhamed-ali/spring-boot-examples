package org.spring.boot.examples.profiles.maven.runner;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.examples.profiles.maven.config.DataBaseConfig;
import org.spring.boot.examples.profiles.maven.config.MailServerConfig;
import org.spring.boot.examples.profiles.maven.service.MailSender;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final MailSender mailSender;
    private final DataBaseConfig databaseConfig;
    private final MailServerConfig mailServerConfig;

    public AppRunner(MailSender mailSender, DataBaseConfig databaseConfig, MailServerConfig mailServerConfig) {
        this.mailSender = mailSender;
        this.databaseConfig = databaseConfig;
        this.mailServerConfig = mailServerConfig;
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info("Load database configuration ...");
        logger.info(databaseConfig.toString());
        logger.info("Load email server configuration ...");
        logger.info(mailServerConfig.toString());
        mailSender.send("info@gmail.com", "dummy test", "Hi, this is a dummy test");
    }

    /*
     * if you run the application without using the maven build config (pom.xml). you will have this error :
     * Parameter 0 of constructor in org.spring.boot.examples.profiles.maven.runner.AppRunner required a single bean, but 2 were found:
     *      - mockMailSender: defined in file [D:\github\boot-tutorial\profiles\1-maven-profiles-example\target\classes\org\spring\boot\examples\profiles\maven\service\MockMailSender.class]
     *      - smtpMailSender: defined in file [D:\github\boot-tutorial\profiles\1-maven-profiles-example\target\classes\org\spring\boot\examples\profiles\maven\service\SmtpMailSender.class]
     *
     * this means that spring found two implementations of the same type and he can't decide which one to use
     */
}

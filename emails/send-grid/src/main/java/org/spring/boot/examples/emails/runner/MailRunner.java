package org.spring.boot.examples.emails.runner;

import com.sendgrid.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.examples.emails.service.MailSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class MailRunner implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailRunner.class);
    private final MailSender mailSender;

    @Value("${to}")
    private String to;

    @Value("${from}")
    private String from;

    public MailRunner(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        LOGGER.info("Sending an email from {} to {}", from, to);
        Response response = this.mailSender.sendSimpleMessage(
                from,
                to,
                "Sending a dummy email via send grid",
                "Hello, \n I'm so happy to send you this email because it's my first using a spring boot application."
        );
        LOGGER.info("The email has been successfully sent");
        LOGGER.info("response status {}", response.getStatusCode());
    }
}

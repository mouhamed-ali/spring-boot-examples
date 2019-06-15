package org.spring.boot.examples.packaging;


import org.spring.boot.examples.packaging.service.MessageSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {

        String beanName = args[0];
        String to = args[1];
        String message = args[2];

        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        MessageSender sender = (MessageSender) context.getBean(beanName);
        sender.send(to, message);

        context.close();
    }
}

package org.spring.boot.examples.packaging;


import org.spring.boot.examples.packaging.service.MessageSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    /*
     * source : https://docs.spring.io/spring-boot/docs/current/reference/html/executable-jar.html
     * https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot-tools/spring-boot-loader/src/main/java/org/springframework/boot/loader/PropertiesLauncher.java
     * https://medium.com/saas-startup-factory/spring-boot-2-and-external-libs-with-the-propertieslauncher-fc49d2d93636
     */

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

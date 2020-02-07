# Send Email using Gmail

In this example, we will show you how to use Spring boot starter mail to send email.

reference : 

- https://www.baeldung.com/spring-email

We will send a simple 'Hello World' email. The smtp configuration of Gmail is in the `application.yml` file. For the sensible data like the used email
to send messages, the password and the receiver email gonna be system variables. so that you'll share them in you code.

After running this app, the run method from the `MailRunner.java` file will be triggered and send an email to the receiver using the declared configuration.
Check logs after running the app.

## Building

After cloning the project, you can build it from source with this command (from the project directory) :

```shell script
$ mvn clean package
```

And now you have to declare the app parameters :

    $ export EMAIL_USERNAME=you-email
    $ export EMAIL_PASSWORD=your-email-password
    $ export EMAIL_RECEIVER=your-email-receiver

## Running the application

you can run this application using java -jar, as shown in the following example:

```shell script
$ java -jar target/gmail-mail-sender.jar
```

or using the spring boot maven plugin :

```shell script
$ mvn spring-boot:run
```

output :
```log

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.4.RELEASE)

2020-02-07 16:31:52.533  INFO 11038 --- [           main] o.s.b.examples.emails.GmailApplication   : Starting GmailApplication on salto-Vostro-7590 with PID 11038 (/home/salto/tutorials/java/spring-boot-examples/emails/gmail/target/gmail-mail-sender.jar started by salto in /home/salto/tutorials/java/spring-boot-examples/emails/gmail)
2020-02-07 16:31:52.535  INFO 11038 --- [           main] o.s.b.examples.emails.GmailApplication   : No active profile set, falling back to default profiles: default
2020-02-07 16:31:53.060  INFO 11038 --- [           main] o.s.b.examples.emails.GmailApplication   : Started GmailApplication in 0.821 seconds (JVM running for 1.084)
2020-02-07 16:31:53.061  INFO 11038 --- [           main] o.s.b.examples.emails.runner.MailRunner  : Sending an email to xxxxxxxxxxxxxxxxx@gmail.com
2020-02-07 16:31:54.767  INFO 11038 --- [           main] o.s.b.examples.emails.runner.MailRunner  : The email has been successfully sent

```

## Test the app

Just check the receiver email to find the email.

![Selection_041](https://user-images.githubusercontent.com/16627692/74043242-4a2def80-49c9-11ea-85c4-48206ddd3055.png)

## Authors

* Mohamed Ali AMDOUNI

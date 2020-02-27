# Send Email using Send Grid

In this example, we will show you how to use Spring boot to send email via send grid.

Send Grid is a platform for transactional and marketing email. And you can use for free to send you email.

- https://sendgrid.com/

For this example we gonna use a send grid dependency to send emails. This is the github project :

- https://github.com/sendgrid/sendgrid-java

We will send a simple 'Hello World' email. For this example we gonna not use our mail username or password so we gonna expose our sensitive data to the public.
We'll create an api key in send grid and when we finish we can delete it.

In order to send email to users, you have to create a send grid account (if you don't have one). To create a free account, check this :

https://signup.sendgrid.com/

Then you have to create a new api key to be used in the app. Check this link to create a new one :

https://sendgrid.com/docs/ui/account-and-settings/api-keys/#creating-an-api-key

When creating this api key, choose Full Access as permission.

After generating it, use it in the `application.yml` file. Well it's just an example, but you can make it an environment variable if you want.
See how we are declaring the mail sender and receiver in the same file.

After running this app, the run method from the `MailRunner.java` file will be triggered and send an email to the receiver using the declared configuration.
Check logs after running the app.

## Building

After cloning the project, you can build it from source with this command (from the project directory) :

```shell script
$ mvn clean package
```

And now you have to declare the app parameters :

    $ export EMAIL_SENDER=no-reply@spring.boot.app.io
    $ export EMAIL_RECEIVER=your-email-receiver

## Running the application

you can run this application using java -jar, as shown in the following example:

```shell script
$ java -jar target/send-grid-sender.jar
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

2020-02-07 17:51:56.558  INFO 17064 --- [           main] o.s.b.e.emails.SendGridApplication       : Starting SendGridApplication on salto-Vostro-7590 with PID 17064 (/home/salto/tutorials/java/spring-boot-examples/emails/send-grid/target/send-grid-sender.jar started by salto in /home/salto/tutorials/java/spring-boot-examples/emails/send-grid)
2020-02-07 17:51:56.560  INFO 17064 --- [           main] o.s.b.e.emails.SendGridApplication       : No active profile set, falling back to default profiles: default
2020-02-07 17:51:57.156  INFO 17064 --- [           main] o.s.b.e.emails.SendGridApplication       : Started SendGridApplication in 0.872 seconds (JVM running for 1.104)
2020-02-07 17:51:57.157  INFO 17064 --- [           main] o.s.b.examples.emails.runner.MailRunner  : Sending an email from no-reply@my-app-simple.com to amdouni.mouhamed.ali.pro@gmail.com
2020-02-07 17:51:58.699  INFO 17064 --- [           main] o.s.b.examples.emails.runner.MailRunner  : The email has been successfully sent
2020-02-07 17:51:58.700  INFO 17064 --- [           main] o.s.b.examples.emails.runner.MailRunner  : response status 202
```

202 means that your email has been queued and gonna be delivered. Check code status here :

- https://sendgrid.com/docs/API_Reference/Web_API_v3/Mail/errors.html

## Test the app

Just check the receiver email to find the email.

If the mail has not been sent, check the activity area from your send grid account.

** PN ** : don't forget to delete the api key if you will share your code on the net.

## Authors

* Mohamed Ali AMDOUNI

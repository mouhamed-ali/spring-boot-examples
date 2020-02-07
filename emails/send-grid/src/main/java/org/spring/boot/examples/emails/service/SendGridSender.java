package org.spring.boot.examples.emails.service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGridAPI;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SendGridSender implements MailSender {

    private final SendGridAPI sendGridAPI;

    public SendGridSender(SendGridAPI sendGridAPI) {
        this.sendGridAPI = sendGridAPI;
    }

    public Response sendSimpleMessage(String from, String to, String subject, String text) throws IOException {

        Email fromAddress = new Email(from);
        Email toAddress = new Email(to);

        Content content = new Content("text/plain", text);
        Mail mail = new Mail(fromAddress, subject, toAddress, content);

        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());

        return sendGridAPI.api(request);
    }
}

package org.spring.boot.examples.web.soap.consumer.book.runner;

import com.extservice.book.GetBook;
import com.extservice.book.GetBookResponse;
import com.extservice.book.ObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

@Component
public class BookClient implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookClient.class);
    private static final String BOOK_ID = "A1249";
    private final WebServiceTemplate webServiceTemplate;

    public BookClient(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    @Override
    public void run(String... args) {

        ObjectFactory factory = new ObjectFactory();
        GetBook bookRequest = factory.createGetBook();
        bookRequest.setID(BOOK_ID);

        LOGGER.info("Client request : {}", bookRequest);

        GetBookResponse response = (GetBookResponse) this.webServiceTemplate.marshalSendAndReceive(bookRequest);

        LOGGER.info("Received response : {}", response);

    }
}

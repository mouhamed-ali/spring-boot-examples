package org.spring.boot.examples.web.soap.producer.book.resources;


import com.extservice.book.GetBook;
import com.extservice.book.GetBookResponse;
import com.extservice.book.ObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
/*
 * The HelloWorldEndpoint POJO is annotated with the @Endpoint annotation which registers the class with Spring WS as a potential
 * candidate for processing incoming SOAP messages.
 */
public class BookEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookEndpoint.class);

    @PayloadRoot(
            namespace = "http://www.cleverbuilder.com/BookService/",
            localPart = "GetBook")
    // you can get this informations from the wsdl file in the resources
    /*
     * To indicate what sort of messages a method can handle, it is annotated with the @PayloadRoot annotation that specifies a qualified
     * name that is defined by a namespace and a local name (=localPart). Whenever a message comes in which has this qualified name for
     * the payload root element, the method will be invoked.
     */
    @ResponsePayload
    /*
     * The @ResponsePayload annotation makes Spring WS map the returned value to the response payload
     * which in our example is the JAXB GetBookResponse object.
     */
    public GetBookResponse getBook(@RequestPayload GetBook book) {

        /*
         * The @RequestPayload annotation on this method parameter indicates that the incoming message will be mapped to the
         * method’s request parameter. In our case, this is the JAXB GetBook object.
         */

        LOGGER.info("Endpoint received a get book request , the book id is = {}", book.getID());
        ObjectFactory factory = new ObjectFactory();
        GetBookResponse response = factory.createGetBookResponse();
        response.setID(book.getID());

        LOGGER.info("Endpoint sending response='{}'", response);
        return response;
    }
}

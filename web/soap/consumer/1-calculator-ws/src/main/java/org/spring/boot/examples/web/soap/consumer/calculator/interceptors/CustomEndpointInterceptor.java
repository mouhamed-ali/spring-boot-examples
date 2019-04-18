package org.spring.boot.examples.web.soap.consumer.calculator.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class CustomEndpointInterceptor implements ClientInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomEndpointInterceptor.class);

    @Override
    public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException {
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext) throws WebServiceClientException {
        return true;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Exception e) throws WebServiceClientException {

        LOGGER.info("Execute code after completion");
        try {

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            messageContext.getRequest().writeTo(outputStream);
            LOGGER.info("Soap Request : {}", outputStream);
            outputStream.reset();
            messageContext.getResponse().writeTo(outputStream);
            LOGGER.info("Soap Response : {}", outputStream);
        } catch (IOException ignored) {
        }
    }
}

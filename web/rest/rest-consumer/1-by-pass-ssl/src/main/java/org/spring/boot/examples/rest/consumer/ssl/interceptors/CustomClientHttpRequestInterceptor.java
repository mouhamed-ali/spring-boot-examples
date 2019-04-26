package org.spring.boot.examples.rest.consumer.ssl.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class CustomClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomClientHttpRequestInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        logRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);

        //Add optional additional headers
        //response.getHeaders().add("headerName", "VALUE");

        return execution.execute(request, body);
    }

    private void logRequest(HttpRequest request, byte[] body) throws IOException {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("=========================== Request Begin ================================================");
            LOGGER.debug("URI         : {}", request.getURI());
            LOGGER.debug("Method      : {}", request.getMethod());
            LOGGER.debug("Headers     : {}", request.getHeaders());
            LOGGER.debug("Request body: {}", new String(body, "UTF-8"));
            LOGGER.debug("===========================  Request End  ================================================");
        }
    }

    private void logResponse(ClientHttpResponse response) throws IOException {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("============================ Response Begin ==========================================");
            LOGGER.debug("Status code  : {}", response.getStatusCode());
            LOGGER.debug("Status text  : {}", response.getStatusText());
            LOGGER.debug("Headers      : {}", response.getHeaders());
            LOGGER.debug("Response body: {}", StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
            LOGGER.debug("============================  Response End  =================================================");
        }
    }
}

package org.spring.boot.examples.web.soap.consumer.ssl.service;

import com.generate.aspsms.classes.CheckCredits;
import com.generate.aspsms.classes.CheckCreditsResponse;
import com.generate.aspsms.classes.ObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
public class CheckCreditsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckCreditsService.class);
    private final WebServiceTemplate webServiceTemplate;

    public CheckCreditsService(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public String checkDummyCredit() {

        /*
         *  I will just launch a technical test. just to be sure that the ssl by pass works
         */

        ObjectFactory objectFactory = new ObjectFactory();

        CheckCredits request = objectFactory.createCheckCredits();
        request.setUserKey("user");
        request.setPassword("password");

        // you can use soapui to get the soap action (you will find it in the request header)
        CheckCreditsResponse response = (CheckCreditsResponse) webServiceTemplate.marshalSendAndReceive(request, new SoapActionCallback("https://webservice.aspsms.com/aspsmsx2.asmx/CheckCredits"));

        LOGGER.info(response.toString());

        return response.getCheckCreditsResult();
    }
}

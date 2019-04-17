package org.spring.boot.examples.web.soap.consumer.calculator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.examples.web.soap.consumer.calculator.generated.Add;
import org.spring.boot.examples.web.soap.consumer.calculator.generated.AddResponse;
import org.spring.boot.examples.web.soap.consumer.calculator.generated.ObjectFactory;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
public class AddService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddService.class);
    private final WebServiceTemplate webServiceTemplate;

    public AddService(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public Integer add(Integer x, Integer y) {

        ObjectFactory objectFactory = new ObjectFactory();
        Add addRequest = objectFactory.createAdd();
        addRequest.setIntA(x);
        addRequest.setIntB(y);

        //you can find the soap action in the wsdl file under the <wsdl:binding>
        AddResponse response = (AddResponse) webServiceTemplate.marshalSendAndReceive(addRequest, new SoapActionCallback("http://tempuri.org/Add"));

        return response.getAddResult();
    }
}

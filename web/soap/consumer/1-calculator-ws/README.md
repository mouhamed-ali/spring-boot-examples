# Project Title

calculator soap web service consumer


### description

In this example we will learn how to consume a SOAP web services using spring boot soap client and auto client proxy class generation using JAXB maven plugin.
The WebServiceTemplate is the core class for client-side Web service access in Spring-WS. It contains methods for sending Source objects, and receiving response messages as either Source or Result. Additionally, it can marshal objects to XML before sending them across a transport, and unmarshal any response XML into an object again.
So the JAXB will be used to marshall/unmarshall our xml request/response.

In this example we will use a public soap web service used to do some basic calculation. you can find it at :
* http://www.dneonline.com/calculator.asmx?wsdl

I will download the wsdl ,save it in a file and then copy it in the resources of the project (it will be used bu jaxb).

package org.spring.boot.examples.web.soap.consumer.ssl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.http.HttpsUrlConnectionMessageSender;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;


@Configuration
/**
 * @since 2019/04/27
 */
public class WebServiceTemplateConfig {

    /**
     * our web service template configuration
     *
     * @return
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    @Bean
    public WebServiceTemplate webServiceTemplate() {

        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(jaxb2Marshaller());
        webServiceTemplate.setUnmarshaller(jaxb2Marshaller());

        //use -Djavax.net.debug=ssl,handshake to debug the ssl handshake
        //the url below is a free service that i found it on the net. it woks perfectly now (2019/04/27)
        webServiceTemplate.setDefaultUri("https://soap.aspsms.com/aspsmsx2.asmx");

        //by pass ssl configuration
        HttpsUrlConnectionMessageSender sender = new HttpsUrlConnectionMessageSender();
        sender.setTrustManagers(new TrustManager[]{new UnTrustworthyTrustManager()});
        webServiceTemplate.setMessageSender(sender);

        return webServiceTemplate;
    }

    /**
     * jaxb2 marshaller/unmarshaller configuration
     *
     * @return
     */
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in plugin section. see pom.xml
        marshaller.setContextPath("com.generate.aspsms.classes");
        return marshaller;
    }

    /**
     * by pass ssl configuration
     */
    class UnTrustworthyTrustManager implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }
}

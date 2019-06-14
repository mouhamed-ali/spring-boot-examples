package org.spring.boot.examples.web.soap.consumer.ssl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.http.HttpsUrlConnectionMessageSender;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Base64;


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

        //in the case you must pass by a basic authentication you can use this commented line
        //HttpsUrlConnectionMessageSender sender = new BasicAuthHttpsConnectionMessageSender("admin","admin");

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

    /**
     * basic authentication message sender
     */
    class BasicAuthHttpsConnectionMessageSender extends HttpsUrlConnectionMessageSender {

        private String base64Credentials;

        public BasicAuthHttpsConnectionMessageSender(String username, String password) {

            base64Credentials = Base64.getUrlEncoder().encodeToString((username + ":" + password).getBytes(StandardCharsets.UTF_8));
        }

        @Override
        protected void prepareConnection(HttpURLConnection connection) throws IOException {
            connection.setRequestProperty(HttpHeaders.AUTHORIZATION, String.format("Basic %s", base64Credentials));
            super.prepareConnection(connection);
        }
    }
}

package org.spring.boot.examples.http.ssl;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        // close the application context to shut down the custom ExecutorService
        SpringApplication.run(Application.class, args).close();

        /*
         * source : https://nakov.com/blog/2009/07/16/disable-certificate-validation-in-java-ssl-connections/
         *
         * if you want to run your jvm with an empty truststore this links will help you :
         * - https://javarevisited.blogspot.com/2012/09/difference-between-truststore-vs-keyStore-Java-SSL.html
         * - https://stackoverflow.com/questions/37994315/how-to-create-an-empty-java-trust-store
         * - https://docs.oracle.com/cd/E19509-01/820-3503/6nf1il6er/index.html
         * - https://doc.nuxeo.com/nxdoc/trust-store-and-key-store-configuration/
         * - if you want to download a certificate you can use openssl. this is an example of downloading the duckduckgo certificate :
         *      openssl s_client -connect duckduckgo.com:443 > ./duckduckgo.cert
         */
    }
}

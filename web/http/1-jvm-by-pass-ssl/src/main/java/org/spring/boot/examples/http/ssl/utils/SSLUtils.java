package org.spring.boot.examples.http.ssl.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

@Component
public class SSLUtils implements InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(SSLUtils.class);
    private HostnameVerifier fakeHostnameVerifier;
    private X509TrustManager fakeX509TrustManager;
    private boolean sslVerificationEnabled = true;

    @Override
    public void afterPropertiesSet() {

        if (fakeHostnameVerifier == null)
            fakeHostnameVerifier = new FakeHostNameVerifier();

        if (fakeX509TrustManager == null)
            fakeX509TrustManager = new FakeX509TrustManager();
    }

    /**
     * this method will disable the ssl verification and accepts all certificates
     */
    public void disableSSL() {

        try {

            sslVerificationEnabled = false;
            trustAllCertificates();
            trustAllHostNames();
        } catch (Exception e) {

            LOGGER.warn("Cannot by pass the ssl verification. {}", e);
            sslVerificationEnabled = true;
        }

    }

    /**
     * this method will return the ssl verification status
     *
     * @return true : the ssl verification is enables
     * false : the ssl verification is disabled
     */
    public boolean isSslVerificationEnabled() {

        return sslVerificationEnabled;
    }

    /**
     * this method will make jvm trust all servers certificates
     *
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    private void trustAllCertificates() throws NoSuchAlgorithmException, KeyManagementException {

        SSLContext sc = SSLContext.getInstance("TLS");
        /*
         * TLS is the new version of the standard that was previously called SSL, but the term SSL is still wildly used
         * so please check the protocol (SSL or TLS) using the open ssl for example or your browser. otherwise use this command :
         * SSLContext sc = SSLContext.getInstance("SSL")
         */
        sc.init(null, new TrustManager[]{fakeX509TrustManager}, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }

    /**
     * this method will make jvm trust all servers names
     */
    private void trustAllHostNames() {

        HttpsURLConnection.setDefaultHostnameVerifier(fakeHostnameVerifier);
    }

    /**
     * Create all-trusting host name verifier
     */
    public class FakeHostNameVerifier implements HostnameVerifier {

        @Override
        public boolean verify(String s, SSLSession sslSession) {

            return true;
        }
    }

    /**
     * Create a trust manager that does not validate certificate chains
     */
    public class FakeX509TrustManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

        }

        @Override
        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {

            return null;
        }
    }
}

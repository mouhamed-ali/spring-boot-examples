package org.spring.boot.examples.web.rest.producer.oauth2.config.authServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.inMemory()
                .withClient("client")
                //the user with whom we will identify in the server

                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
                //we specify  services that configure for the defined user, for 'client.' In our example, we will only use the password service.

                .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT", "USER")
                //specifies roles or groups contained by the service offered

                .scopes("read", "write")
                //is the scope of the service
                .autoApprove(true)

                .secret(passwordEncoder().encode("change_me"));
        //the password of the client

        //.accessTokenValiditySeconds(120)  //Access token is only valid for 2 minutes.
        //.refreshTokenValiditySeconds(600);//Refresh token is only valid for 10 minutes.
    }


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        endpoints
                .authenticationManager(authenticationManager)
                .tokenStore(tokenStore);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        //The encode function is annotated with the @Beantag because Spring, when we supply the password in an HTTP request,
        // will look for a  PasswordEncoderobject to check the validity of the delivered password.
        return new BCryptPasswordEncoder();
    }

    @Bean
    public TokenStore tokenStore() {

        //tokens will be stored in memory
        return new InMemoryTokenStore();
    }
}

package org.spring.boot.examples.web.rest.swagger.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(InfosApiConfig apiConfig) {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.spring.boot.examples.web.rest.swagger.api.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo(apiConfig));
    }

    private ApiInfo apiInfo(InfosApiConfig apiConfig) {
        return new ApiInfoBuilder()
                .title(apiConfig.getName())
                .description(apiConfig.getDescription())
                .version(apiConfig.getVersion())
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact("John Thompson", "https://springframework.guru/about/", "john@springfrmework.guru"))
                .build();
    }

    /*
     * use this configuration in production
     * it will hide the exposed test services in the swagger ui so user can just consult services but he can't run it
     */
    @Bean
    @Profile("production")
    UiConfiguration uiConfiguration() {

        return new UiConfiguration(null, UiConfiguration.Constants.NO_SUBMIT_METHODS);
    }
}

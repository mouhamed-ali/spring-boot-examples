package org.spring.boot.examples.properties.external.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.examples.properties.external.configuration.properties.*;
import org.spring.boot.examples.properties.external.env.EnvConfigProperties;
import org.spring.boot.examples.properties.external.property.source.PropertySourceExample;
import org.spring.boot.examples.properties.external.property.source.PropertySourceNotFoundExample;
import org.spring.boot.examples.properties.external.value.ValueConfigProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PropertiesRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesRunner.class);
    private final EnvConfigProperties envConfigProperties;
    private final ValueConfigProperties valueConfigProperties;
    private final PropertySourceExample propertySourceExample;
    private final PropertySourceNotFoundExample propertySourceNotFoundExample;
    private final ListExample listExample;
    private final MapExample mapExample;
    private final ObjectExample objectExample;
    private final PrefixExample prefixExample;
    private final ValidationExample validationExample;

    public PropertiesRunner(EnvConfigProperties envConfigProperties, ValueConfigProperties valueConfigProperties, PropertySourceExample propertySourceExample, PropertySourceNotFoundExample propertySourceNotFoundExample, ListExample listExample, MapExample mapExample, ObjectExample objectExample, PrefixExample prefixExample, ValidationExample validationExample) {
        this.envConfigProperties = envConfigProperties;
        this.valueConfigProperties = valueConfigProperties;
        this.propertySourceExample = propertySourceExample;
        this.propertySourceNotFoundExample = propertySourceNotFoundExample;
        this.listExample = listExample;
        this.mapExample = mapExample;
        this.objectExample = objectExample;
        this.prefixExample = prefixExample;
        this.validationExample = validationExample;
    }

    @Override
    public void run(String... args) throws Exception {


        LOGGER.info("environment example : {}", envConfigProperties);
        LOGGER.info("value example : {}", valueConfigProperties);
        LOGGER.info("property source example : {}", propertySourceExample);
        LOGGER.info("property source not found example : {}", propertySourceNotFoundExample);
        LOGGER.info("list example example : {}", listExample);
        LOGGER.info("map example example : {}", mapExample);
        LOGGER.info("object example example : {}", objectExample.getCredentials());
        LOGGER.info("prefix example : {}", prefixExample);
        LOGGER.info("validation example : {}", validationExample);
    }
}

package org.spring.boot.examples.web.rest.swagger.gen.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.spring.boot.examples.swagger.models.Pet;
import org.spring.boot.examples.swagger.models.User;

import java.io.IOException;

public class JSONUtils {

    private static Object convertJsonClass(String json, Class clazz) throws IOException {

        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        return mapper.readValue(json, clazz);
    }

    public static Pet getPetFromJson(String json) throws IOException {

        return (Pet) convertJsonClass(json, Pet.class);
    }

    public static User getUserFromJson(String json) throws IOException {

        return (User) convertJsonClass(json, User.class);
    }
}

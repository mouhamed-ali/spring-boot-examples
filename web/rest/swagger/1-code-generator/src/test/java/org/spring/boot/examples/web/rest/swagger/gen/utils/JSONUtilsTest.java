package org.spring.boot.examples.web.rest.swagger.gen.utils;

import org.junit.Test;
import org.spring.boot.examples.swagger.models.Category;
import org.spring.boot.examples.swagger.models.Pet;
import org.spring.boot.examples.swagger.models.Tag;
import org.spring.boot.examples.swagger.models.User;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class JSONUtilsTest {

    @Test
    public void petConversionTest() throws IOException {

        Pet expectedPet = new Pet();
        expectedPet.setId(99L);
        expectedPet.setName("doggie");
        expectedPet.setStatus(Pet.StatusEnum.AVAILABLE);

        Category category = new Category();
        category.setId(12L);
        category.setName("string");
        expectedPet.setCategory(category);

        expectedPet.setPhotoUrls(Arrays.asList("photo"));

        Tag tag = new Tag();
        tag.setId(0L);
        tag.setName("string");
        expectedPet.setTags(Arrays.asList(tag));

        //transform the json
        String petJson = getFile("pet.json");
        Pet actualPet = JSONUtils.getPetFromJson(petJson);

        assertThat(actualPet).isEqualTo(expectedPet);
    }

    @Test
    public void userConversionTest() throws IOException {

        User expectedUser = new User();
        expectedUser.setId(123L);
        expectedUser.setUsername("John");
        expectedUser.setFirstName("John");
        expectedUser.setLastName("snow");
        expectedUser.setBirthDate(LocalDate.of(2019, 4, 30));
        expectedUser.setEmail("john@snow.gmail");
        expectedUser.setPassword("p@ssord");
        expectedUser.setPhone("string");
        expectedUser.setUserStatus(0);

        //transform the json
        String userJson = getFile("user.json");
        User actualUser = JSONUtils.getUserFromJson(userJson);

        assertThat(actualUser).isEqualTo(expectedUser);
    }

    private String getFile(String filePath) throws IOException {

        String absolutePath = new ClassPathResource(filePath).getFile().getAbsolutePath();
        return new String(Files.readAllBytes(Paths.get(absolutePath)));
    }
}

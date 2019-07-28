package org.spring.boot.examples.testing.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.spring.boot.examples.entities.GithubUser;
import org.spring.boot.examples.testing.service.impl.GithubApiUserService;
import org.spring.boot.examples.testing.service.impl.GithubDatabaseUserService;
import org.spring.boot.examples.testing.test.data.controller.GetUserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.NestedServletException;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GithubUserControllerTest {

    public static final String GET_USER_URL = "/github/api/v1/users/%s";
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @MockBean       // create a mockito to mock the spring bean
    private GithubApiUserService githubApiUserService; // this will be used to mock all github rest service calls

    @Autowired      // inject the spring bean
    @InjectMocks    // inject all @MockBean in this spring bean
    private GithubUserController githubUserController;
    @Autowired
    private GithubDatabaseUserService databaseUserService;

    @Test
    public void getUserExistDataBaseTest() throws Exception {

        GithubUser expecteduser = GetUserController.getUserDataBase();
        mockMvc.perform(
                MockMvcRequestBuilders.get(String.format(GET_USER_URL, "pivotal")).accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(mapper.writeValueAsString(expecteduser)));
    }

    @Test
    public void getUserExistGithubTest() throws Exception {

        GithubUser expecteduser = GetUserController.getUserGithub("scala", 999L);
        Mockito.when(githubApiUserService.findByUserName(Mockito.anyString())).thenReturn(expecteduser);

        mockMvc.perform(
                MockMvcRequestBuilders.get(String.format(GET_USER_URL, "scala")).accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(mapper.writeValueAsString(expecteduser)));

        //in this case the use will be downloaded from github and saved in the database we will check this
        Assertions.assertThat(databaseUserService.findByUserName("scala")).isEqualTo(expecteduser);
    }

    @Test
    public void getUserNotExistTest() throws Exception {

        String userName = "anonymous";

        /*
         * the method throws HttpClientErrorException so normally we check for this example but i think that spring
         * intercept this exception and throws NestedServletException that's why we will check for it
         */
        exceptionRule.expect(NestedServletException.class);
        exceptionRule.expectMessage(String.format("Not found user , %s", userName));

        Mockito.when(githubApiUserService.findByUserName(Mockito.eq(userName))).thenThrow(
                new HttpClientErrorException(HttpStatus.NOT_FOUND, String.format("Not found user , %s", userName))
        );

        mockMvc.perform(
                MockMvcRequestBuilders.get(String.format(GET_USER_URL, userName)).accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test(expected = NestedServletException.class)//another way to do the same thing
    public void getUserNotExistTest2() throws Exception {

        String userName = "anonymous";

        Mockito.when(githubApiUserService.findByUserName(Mockito.eq(userName))).thenThrow(
                new HttpClientErrorException(HttpStatus.NOT_FOUND, String.format("Not found user , %s", userName))
        );

        mockMvc.perform(
                MockMvcRequestBuilders.get(String.format(GET_USER_URL, userName)).accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void getUserFormatExceptionTest() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.get(String.format(GET_USER_URL, "    ")).accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("id cannot be null"));
    }
}

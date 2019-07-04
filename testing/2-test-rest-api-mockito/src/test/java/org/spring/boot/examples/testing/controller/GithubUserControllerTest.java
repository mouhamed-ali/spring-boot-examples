package org.spring.boot.examples.testing.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.spring.boot.examples.entities.GithubUser;
import org.spring.boot.examples.testing.service.impl.GithubApiUserService;
import org.spring.boot.examples.testing.test.data.controller.GetUserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GithubUserControllerTest {

    public static final String GET_USER_URL = "/api/v1/users/%s";
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @MockBean       // create a mockito to mock the spring bean
    private GithubApiUserService githubApiUserService; // this will be used to mock all github rest service calls

    @Autowired      // inject the spring bean
    @InjectMocks    // inject all @MockBean in this spring bean
    private GithubUserController githubUserController;

    @Test
    public void getUserExistDataBaseTest() throws Exception {

        GithubUser expecteduser = GetUserController.getUser();
        mockMvc.perform(
                MockMvcRequestBuilders.get(String.format(GET_USER_URL, "pivotal")).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(mapper.writeValueAsString(expecteduser)));
    }

    @Test
    public void getUserExistGithubTest() throws Exception {

        String userName = "java";
        GithubUser expecteduser = GetUserController.getUserGithub(userName, 1521L);
        Mockito.when(githubApiUserService.findByUserName(Mockito.eq(userName))).thenReturn(expecteduser);

        mockMvc.perform(
                MockMvcRequestBuilders.get(String.format(GET_USER_URL, userName)).accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())   // print reqeust/response
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(mapper.writeValueAsString(expecteduser)));
    }

    @Test
    public void getUserNotExist() throws Exception {

        String userName = "anonymous";
        Mockito.when(githubApiUserService.findByUserName(Mockito.anyString())).thenReturn(null);
        mockMvc.perform(
                MockMvcRequestBuilders.get(String.format(GET_USER_URL, userName)).accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }


}

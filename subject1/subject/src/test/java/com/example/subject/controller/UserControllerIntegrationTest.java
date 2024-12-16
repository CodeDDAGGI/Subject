package com.example.subject.controller;

import com.subject.subject.SubjectApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = SubjectApplication.class)
@AutoConfigureMockMvc
@Slf4j
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testController() throws Exception {
        // Given
        String userJson = """
                {
                    "email":"example1@example.com",
                    "name":"testUser1",
                    "password" : "1234"
                }
                """;
        // When & Then
        ResultActions result = mockMvc.perform(post("/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().isCreated());

        String responsebody = result.andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();
        System.out.println(responsebody);
    }

    @Test
    void loginTest() throws Exception {
        String userJson = """
                {
                    "email":"example1@example.com",
                    "password" : "1234"
                }""";
        ResultActions mvcResult = mockMvc.perform(post("/users/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().isOk());

        String responsebody = mvcResult.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        System.out.println(responsebody);

    }
}

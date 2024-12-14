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
public class MovieControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void MovieControllerTest() throws Exception {

        String movieJson = """
                {
                    "title":"testMovie",
                    "director":"testDirector",
                    "genre":"testGenre",
                    "releaseDate" : "2020-01-01"
                }
                """;

        ResultActions result = mockMvc.perform(post("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(movieJson))
                .andExpect(status().isCreated());
        System.out.println("결과" + result);
        String responsebody = result.andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();
        System.out.println("리스폰스 값" + responsebody);
    }

}

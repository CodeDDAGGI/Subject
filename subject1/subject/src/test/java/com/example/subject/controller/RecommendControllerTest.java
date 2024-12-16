package com.example.subject.controller;

import com.subject.subject.SubjectApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = SubjectApplication.class)
@AutoConfigureMockMvc
public class RecommendControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void populerMovieTest() throws Exception {
        ResultActions result = mockMvc.perform(get("/movies/recomendations/popular"))
                .andExpect(status().isOk());
        System.out.println("결과" + result);
        String responsebody = result.andReturn().getResponse().getContentAsString();
        System.out.println("GET 요청 결과: " + responsebody);
    }

    @Test
    void LatestMoivesTest() throws Exception {
        ResultActions result = mockMvc.perform(get("/movies/recomendations/latest"))
                .andExpect(status().isOk());
        System.out.println("결과" + result);
        String responsebody = result.andReturn().getResponse().getContentAsString();
        System.out.println("GET 요청 결과: " + responsebody);
    }
}

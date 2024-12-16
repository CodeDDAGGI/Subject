package com.example.subject.controller;

import com.subject.subject.SubjectApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = SubjectApplication.class)
@AutoConfigureMockMvc
public class ReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void ReviewControllerTest() throws Exception {

        String Json = """
                {
                    "userId":5,
                    "content":"testContent",
                    "rating":4.5
                }
                """;
        ResultActions actions = mockMvc.perform(post("/movies/1/reviews")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Json))
                .andExpect(status().isCreated());
        System.out.println("결과" + actions);
        String responsebody = actions.andReturn().getResponse().getContentAsString();
        System.out.println("리스폰스 값" + responsebody);
    }

    @Test
    void ReviewFindTest () throws Exception{
        ResultActions actions = mockMvc.perform(get("/movies/1/reviews"))
                .andExpect(status().isOk());
        System.out.println("결과" + actions);
        String responsebody = actions.andReturn().getResponse().getContentAsString();
        System.out.println("GET 요청 결과: " + responsebody);
    }
}

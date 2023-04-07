package com.youtube.analyze.youtubecommentanalyzeapi.domain.youtube.comment.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class YoutubeEmotionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("전역 테스트 YoutubeEmotionControllerTest")
    void getEmotionAnalyzeResult() throws Exception {
        //given
        // GET http://localhost:8080/api/v1/youtube/comment/emotion/{{analyzeType}}/{{videoId}}
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/youtube/comment/emotion/analyze/NAVER/5xM02nR_Yd8")
                )
                .andDo(print())
                .andExpect(status().isOk());

        //when
        //then
    }
}
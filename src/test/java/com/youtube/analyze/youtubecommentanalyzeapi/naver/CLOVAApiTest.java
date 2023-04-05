package com.youtube.analyze.youtubecommentanalyzeapi.naver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.naver.NaverCLOVA;
import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.naver.NaverEmotionRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@SpringBootTest
class CLOVAApiTest {
    @Autowired
    private NaverCLOVA naverCLOVA;

    /*@Test
    @DisplayName("네이버 클로바 API 테스트")
    void emotionAPITest() throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();
        Map result = restTemplate.postForObject(naverCLOVA.getEmotionApiUrl(),
                naverCLOVA.getHttpEntity(new NaverEmotionRequestDto("안녕하세요").toJson()),
                Map.class);
        System.out.println(result);
    }*/
}

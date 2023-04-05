package com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.naver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.youtube.analyze.youtubecommentanalyzeapi.global.utils.ObjectMapperSingleton;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

public class NaverEmotionRequestDto {
    private final String content;
    public NaverEmotionRequestDto(String content) {
        this.content = content;
    }

    public String toJson() throws JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        map.put("content", content);
        return ObjectMapperSingleton.getObjectMapper().writeValueAsString(map);
    }
}

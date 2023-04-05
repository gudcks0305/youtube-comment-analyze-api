package com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.naver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.EmotionAnalyze;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class NaverEmotionAnalyze implements EmotionAnalyze<NaverEmotionResponseDto>{
    private final NaverCLOVA naverCLOVA;
    @Override
    public NaverEmotionResponseDto analyze(String text, Class<NaverEmotionResponseDto> type)  {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(naverCLOVA.getEmotionApiUrl(),
                naverCLOVA.getHttpEntity(new NaverEmotionRequestDto(text)),
                NaverEmotionResponseDto.class);
    }

}

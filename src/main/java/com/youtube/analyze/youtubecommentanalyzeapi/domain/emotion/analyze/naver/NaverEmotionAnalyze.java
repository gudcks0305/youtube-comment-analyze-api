package com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.naver;

import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.AnalyzeType;
import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.EmotionAnalyze;
import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.EmotionRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class NaverEmotionAnalyze implements EmotionAnalyze {
    private final NaverCLOVA naverCLOVA;

    @Override
    public NaverEmotionResponseDto analyze(String text) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(naverCLOVA.getEmotionApiUrl(),
                naverCLOVA.getHttpEntity(new EmotionRequestDto(text)),
                NaverEmotionResponseDto.class);
    }

}

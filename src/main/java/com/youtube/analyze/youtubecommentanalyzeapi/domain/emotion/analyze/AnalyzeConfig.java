package com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze;

import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.naver.NaverCLOVA;
import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.naver.NaverEmotionAnalyze;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AnalyzeConfig {
    private final NaverCLOVA naverCLOVA;


    @Bean
    public EmotionAnalyze emotionAnalyzer() {
        return new NaverEmotionAnalyze(naverCLOVA);
    }
}

package com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.naver;

import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.EmotionAnalyze;
import org.springframework.stereotype.Component;

@Component
public class NaverEmotionAnalyze implements EmotionAnalyze<NaverEmotionResponseDto>{
    @Override
    public NaverEmotionResponseDto analyze(String text, Class<NaverEmotionResponseDto> type) {
        return null;
    }

}

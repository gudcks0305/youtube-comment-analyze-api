package com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze;

import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.naver.NaverEmotionAnalyze;
import lombok.Getter;

public enum AnalyzeType {
    NAVER(NaverEmotionAnalyze.class.getSimpleName()),
    // TODO : Google emotion analyze
    GOOGLE("googleEmotionAnalyze");

    AnalyzeType(String type) {
        this.type = type;
    }
    @Getter
    private final String type;
}

package com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface EmotionAnalyze<T> {
    T analyze(String text , Class<T> type);
}

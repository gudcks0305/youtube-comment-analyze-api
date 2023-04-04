package com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze;

public interface EmotionAnalyze<T> {
    T analyze(String text , Class<T> type);
}

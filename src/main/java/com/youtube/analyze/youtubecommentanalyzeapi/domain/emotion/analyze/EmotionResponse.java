package com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze;

public abstract class EmotionResponse {
    public abstract String getContent();

    public abstract String getSentiment();

    public abstract Confidence getConfidence();
}

package com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.event;

import java.util.Map;

public abstract class EmotionResponse {
    public abstract String getContent();

    public abstract String getSentiment();

    public abstract Map<String, Double> getConfidence();
}

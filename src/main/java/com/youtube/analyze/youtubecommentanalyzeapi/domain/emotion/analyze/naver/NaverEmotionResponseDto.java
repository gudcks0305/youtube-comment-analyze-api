package com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.naver;

import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.event.EmotionResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
@Getter
@NoArgsConstructor
public class NaverEmotionResponseDto extends EmotionResponse {
    // TODO response field add
    @Setter
    private String content;
    private Document document;

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getSentiment() {
        return document.getSentiment();
    }

    @Override
    public Map<String, Double> getConfidence() {
        return document.getConfidence();
    }


    @Getter
    public static class Document {
        private String sentiment;
        private Map<String, Double> confidence;
    }


}

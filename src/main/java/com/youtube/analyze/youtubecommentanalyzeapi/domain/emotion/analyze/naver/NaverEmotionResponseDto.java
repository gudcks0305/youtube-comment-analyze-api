package com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.naver;

import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.event.Confidence;
import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.event.EmotionResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
    public Confidence getConfidence() {
        return document.getConfidence();
    }


    @Getter
    @AllArgsConstructor
    public static class Document {
        private String sentiment;
        private Confidence confidence;
    }


}

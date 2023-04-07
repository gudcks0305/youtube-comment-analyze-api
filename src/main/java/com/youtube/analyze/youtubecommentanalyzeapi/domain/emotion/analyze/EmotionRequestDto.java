package com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze;

public class EmotionRequestDto {
    private final String content;
    public EmotionRequestDto(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

}

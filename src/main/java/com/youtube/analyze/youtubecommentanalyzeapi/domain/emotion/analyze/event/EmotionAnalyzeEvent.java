package com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.event;

import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.AnalyzeType;
import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.EmotionRequestDto;
import org.springframework.context.ApplicationEvent;

import java.util.List;

public class EmotionAnalyzeEvent extends ApplicationEvent {
    private final List<EmotionRequestDto> emotionRequestDto;
    private final AnalyzeType analyzeType;

    public EmotionAnalyzeEvent(Object source, List<EmotionRequestDto> emotionRequestDto, AnalyzeType analyzeType) {
        super(source);
        this.emotionRequestDto = emotionRequestDto;
        this.analyzeType = analyzeType;
    }

    public List<EmotionRequestDto> getEmotionRequestDto() {
        return emotionRequestDto;
    }

    public AnalyzeType getAnalyzeType() {
        return analyzeType;
    }
}

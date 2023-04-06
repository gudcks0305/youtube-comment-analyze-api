package com.youtube.analyze.youtubecommentanalyzeapi.domain.youtube.comment.service;

import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.AnalyzeType;
import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.EmotionAnalyze;
import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.EmotionRequestDto;
import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.event.EmotionAnalyzeEvent;
import com.youtube.analyze.youtubecommentanalyzeapi.domain.youtube.YouTubeAPIRequester;
import com.youtube.analyze.youtubecommentanalyzeapi.domain.youtube.comment.dto.CommentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class YoutubeAnalyzeService {
    private final YouTubeAPIRequester youTubeAPIRequester;
    private final ApplicationEventPublisher applicationEventPublisher;

    public void analyze(String analyzeType, String videoId) {
        List<EmotionRequestDto> commentResponseDtos = getCommentThreads(videoId);
        // findBy bean name
        // String anlyzeType 로 시작하는 analyzeType bean 을 찾아서 사용
        AnalyzeType analyze = Arrays.stream(AnalyzeType.values())
                .filter(analyzeType1 -> analyzeType1.getType().startsWith(analyzeType))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not found emotion analyze bean"));
        applicationEventPublisher.publishEvent(new EmotionAnalyzeEvent(this, commentResponseDtos, analyze));
    }

    private List<EmotionRequestDto> getCommentThreads(String videoId) {
        return new ArrayList<>(youTubeAPIRequester.getCommentThreads(videoId));
    }
}

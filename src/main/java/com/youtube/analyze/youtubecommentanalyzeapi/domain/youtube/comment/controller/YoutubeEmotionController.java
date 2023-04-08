package com.youtube.analyze.youtubecommentanalyzeapi.domain.youtube.comment.controller;

import com.youtube.analyze.youtubecommentanalyzeapi.domain.youtube.comment.service.YoutubeAnalyzeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/youtube/comment/emotion")
public class YoutubeEmotionController {
    private final YoutubeAnalyzeService youtubeAnalyzeService;
    @GetMapping("/{analyzeType}/{videoId}")
    public ResponseEntity getEmotionAnalyzeResult(@PathVariable String analyzeType, @PathVariable String videoId) {
        youtubeAnalyzeService.analyze(analyzeType, videoId);
        return ResponseEntity.ok().build();
    }
}

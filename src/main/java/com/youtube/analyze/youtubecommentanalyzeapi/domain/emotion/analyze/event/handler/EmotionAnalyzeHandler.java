package com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.event.handler;

import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.EmotionAnalyze;
import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.event.EmotionAnalyzeEvent;
import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.event.EmotionResponse;
import com.youtube.analyze.youtubecommentanalyzeapi.domain.excel.MakeExcelUtil;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
public class EmotionAnalyzeHandler {
    private final List<EmotionAnalyze> emotionAnalyzes;

    @EventListener
    public void handle(EmotionAnalyzeEvent emotionAnalyzeEvent) {
        // findBy bean name
        EmotionAnalyze emotionAnalyze = emotionAnalyzes.stream()
                .filter(analyze -> analyze.getClass().getSimpleName().startsWith(emotionAnalyzeEvent.getAnalyzeType().getType()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not found emotion analyze bean"));
        // 비동기 future CompletableFuture 사용
        List<CompletableFuture<EmotionResponse>> emotionAsync = new ArrayList<>();
        emotionAnalyzeEvent.getEmotionRequestDto().forEach(emotionRequestDto -> {
            CompletableFuture<EmotionResponse> future = CompletableFuture.supplyAsync(() -> (EmotionResponse) emotionAnalyze.analyze(emotionRequestDto.getContent()));
            emotionAsync.add(future);
        });
        // TODO  : Processing OUTPUT example : excel, csv, json, etc...
        SXSSFWorkbook sxssfWorkbook = MakeExcelUtil.makeExcel(emotionAsync.get(0).join());
        for (CompletableFuture<EmotionResponse> emotionResponseCompletableFuture : emotionAsync) {
            MakeExcelUtil.writeExcel(sxssfWorkbook, emotionResponseCompletableFuture.join());
        }
        MakeExcelUtil.fileUpload(sxssfWorkbook);

    }
}

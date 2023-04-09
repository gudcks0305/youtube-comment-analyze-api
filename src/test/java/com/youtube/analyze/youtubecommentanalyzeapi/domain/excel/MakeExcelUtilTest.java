package com.youtube.analyze.youtubecommentanalyzeapi.domain.excel;

import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.event.Confidence;
import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.event.EmotionResponse;
import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.naver.NaverEmotionResponseDto;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MakeExcelUtilTest {

    @Test
    void makeExcel() {
        List<EmotionResponse> emotionResponseDtoList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            emotionResponseDtoList.add(
                    new NaverEmotionResponseDto(
                            "content" + i,
                            new NaverEmotionResponseDto.Document(
                                    "sentiment" + i,
                                    new Confidence(0.1, 0.2, 0.3)
                            )
                    )
            );
        }
        SXSSFWorkbook sxssfWorkbook = MakeExcelUtil.makeExcel(emotionResponseDtoList.get(0));
        for (EmotionResponse emotionResponse : emotionResponseDtoList) {
            MakeExcelUtil.writeExcel(sxssfWorkbook, emotionResponse);
        }
        MakeExcelUtil.fileUpload(sxssfWorkbook);

    }
}
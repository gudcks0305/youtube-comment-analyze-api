package com.youtube.analyze.youtubecommentanalyzeapi.domain.excel;

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
       /* List<EmotionResponse> emotionResponseDtoList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            emotionResponseDtoList.add(
                    new NaverEmotionResponseDto("가슴에 화살이 날아와 꽃힌다...", "negative", Map.of("negative", 0.9999, "positive", 0.0001)
                    ));
        }
        SXSSFWorkbook sxssfWorkbook = MakeExcelUtil.makeExcel(emotionResponseDtoList.get(0));
        for (int i = 1; i < emotionResponseDtoList.size(); i++) {
            MakeExcelUtil.writeExcel(sxssfWorkbook, emotionResponseDtoList.get(i));
        }
        MakeExcelUtil.fileUpload(sxssfWorkbook);*/

    }
}
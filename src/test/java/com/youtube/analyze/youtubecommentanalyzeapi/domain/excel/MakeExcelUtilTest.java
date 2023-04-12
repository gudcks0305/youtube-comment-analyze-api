package com.youtube.analyze.youtubecommentanalyzeapi.domain.excel;

import com.youtube.analyze.youtubecommentanalyzeapi.domain.youtube.comment.dto.CommentResponseDto;
import com.youtube.analyze.youtubecommentanalyzeapi.domain.youtube.comment.dto.CommentSnippet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MakeExcelUtilTest {

    //@Test
    void makeExcel() {
        List<Object> emotionResponseDtoList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            emotionResponseDtoList.add(
                    new CommentResponseDto(
                            "content",
                            "id",
                            "kind",
                            new CommentSnippet(
                                    "authorDisplayName",
                                    "authorProfileImageUrl",
                                    1)
                    )
            );
        }
        SXSSFWorkbook sxssfWorkbook = MakeExcelUtil.makeExcel(emotionResponseDtoList.get(0));
        for (Object emotionResponse : emotionResponseDtoList) {
            MakeExcelUtil.writeExcel(sxssfWorkbook, emotionResponse);
        }
        MakeExcelUtil.fileUpload(sxssfWorkbook);

    }
}
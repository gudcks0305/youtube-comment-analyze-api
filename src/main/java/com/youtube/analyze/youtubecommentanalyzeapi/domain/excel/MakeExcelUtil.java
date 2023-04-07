package com.youtube.analyze.youtubecommentanalyzeapi.domain.excel;

import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.event.EmotionResponse;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MakeExcelUtil {
    public static SXSSFWorkbook makeExcel(EmotionResponse response) {
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        SXSSFSheet sheet = workbook.createSheet("sheet1");
        SXSSFRow row = sheet.createRow(0);
        SXSSFCell cell = row.createCell(0);
        cell.setCellValue("comment");
        cell = row.createCell(1);
        cell.setCellValue("sentiment");
        for (int i = 0; i < response.getConfidence().size(); i++) {
            cell = row.createCell(i + 2);
            cell.setCellValue(response.getConfidence().keySet().toArray()[i].toString());
        }
        return workbook;
    }

    public static void writeExcel(SXSSFWorkbook workbook, EmotionResponse emotionResponseDtoList) {
        SXSSFSheet sheet = workbook.getSheetAt(0);
        SXSSFRow row;
        SXSSFCell cell;
        row = sheet.createRow(sheet.getLastRowNum() + 1);
        cell = row.createCell(0);
        cell.setCellValue(emotionResponseDtoList.getContent());
        cell = row.createCell(1);
        cell.setCellValue(emotionResponseDtoList.getSentiment());
        for (int j = 0; j < emotionResponseDtoList.getConfidence().size(); j++) {
            cell = row.createCell(j + 2);
            cell.setCellValue(emotionResponseDtoList.getConfidence().values().toArray()[j].toString());
        }
    }

    public static void fileUpload(SXSSFWorkbook sxssfWorkbook) {
        // TODO : file upload
        File file = new File("excel/" + LocalDate.now() + UUID.randomUUID() + ".xlsx");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            sxssfWorkbook.write(fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert fileOutputStream != null;
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

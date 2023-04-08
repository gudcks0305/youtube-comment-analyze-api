package com.youtube.analyze.youtubecommentanalyzeapi.domain.excel;

import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.event.EmotionResponse;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.time.LocalDate;
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
        for (Field field : response.getConfidence().getClass().getDeclaredFields()) {
            cell = row.createCell(row.getLastCellNum());
            cell.setCellValue(field.getName());
        }
        return workbook;
    }

    public static void writeExcel(SXSSFWorkbook workbook, EmotionResponse response) {
        SXSSFSheet sheet = workbook.getSheetAt(0);
        SXSSFRow row;
        SXSSFCell cell;
        row = sheet.createRow(sheet.getLastRowNum() + 1);
        cell = row.createCell(0);
        cell.setCellValue(response.getContent());
        cell = row.createCell(row.getLastCellNum());
        cell.setCellValue(response.getSentiment());
        Field[] fields = response.getConfidence().getClass().getDeclaredFields();
        for (Field field : fields) {
            cell = row.createCell(row.getLastCellNum());
            try {
                field.setAccessible(true);
                cell.setCellValue((Double) field.get(response.getConfidence()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
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

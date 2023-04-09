package com.youtube.analyze.youtubecommentanalyzeapi.domain.excel;

import com.youtube.analyze.youtubecommentanalyzeapi.global.utils.ReflectionUtils;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MakeExcelUtil {
    public static SXSSFWorkbook makeExcel(Object response) {
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        SXSSFSheet sheet = workbook.createSheet("sheet1");
        SXSSFRow row = sheet.createRow(0);
        List<String> fieldNames = new ArrayList<>();
        ReflectionUtils.recursiveGetFieldNamesWithOutObject(fieldNames, response.getClass());
        for (int i = 0; i < fieldNames.size(); i++) {
            SXSSFCell cell = row.createCell(i);
            cell.setCellValue(fieldNames.get(i));
        }

        return workbook;
    }

    // TODO : 계속 field name을 찾아야함 o(n^2) -> o(n)으로 변경할 필요 있음
    public static void writeExcel(SXSSFWorkbook workbook, Object response) {
        SXSSFSheet sheet = workbook.getSheetAt(0);
        SXSSFRow row;
        SXSSFCell cell;
        row = sheet.createRow(sheet.getLastRowNum() + 1);

        List<String> fieldNames = new ArrayList<>();
        ReflectionUtils.recursiveGetFieldNamesWithOutObject(fieldNames, response.getClass());
        Map<String, String> fieldNamesMap = fieldNames.stream().collect(Collectors.toMap(Function.identity(), Function.identity()));
        ReflectionUtils.recursiveSetValueByFieldNames(response, fieldNamesMap);
        for (String fieldName : fieldNames) {
            cell = row.createCell(row.getLastCellNum() == -1 ? 0 : row.getLastCellNum());
            cell.setCellValue(fieldNamesMap.get(fieldName));
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

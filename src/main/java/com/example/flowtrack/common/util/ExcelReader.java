package com.example.flowtrack.common.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExcelReader {

    public List<String> readSeoulAreaNames(String excelPath) throws Exception {
        return readColumnByName(excelPath, "AREA_NM");
    }

    public List<String> readSeoulRoadLinkIds(String excelPath) throws Exception {
        return readColumnByName(excelPath, "서비스링크");
    }

    // 엑셀에서 지정한 컬럼명의 모든 값들을 리스트로 반환
    public List<String> readColumnByName(String excelPath, String columnName) throws Exception {
        List<String> values = new ArrayList<>();

        try (InputStream fis = new FileInputStream(excelPath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            int targetCol = findColumnIndex(sheet, columnName);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // 헤더 스킵
                Cell cell = row.getCell(targetCol, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                if (cell == null) continue;

                String value = getCellValueAsString(cell);
                if (value != null && !value.isEmpty()) {
                    values.add(value);
                }
            }
        }
        return values;
    }

    // 엑셀 헤더에서 특정 컬럼명의 인덱스 번호를 찾아서 반환
    private int findColumnIndex(Sheet sheet, String columnName) {
        Row header = sheet.getRow(0);
        if (header == null) throw new RuntimeException("헤더 행 없음");

        for (Cell cell : header) {
            if (cell != null && cell.getCellType() == CellType.STRING) {
                String name = cell.getStringCellValue().trim();
                if (name.contains(columnName)) {  // contains로 해서 "서비스링크" 같은 경우도 처리
                    return cell.getColumnIndex();
                }
            }
        }
        throw new RuntimeException(columnName + " 열을 찾을 수 없음");
    }

    // 엑셀 셀의 값을 타입에 관계없이 문자열로 변환해서 반환
    private String getCellValueAsString(Cell cell) {
        if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf((long) cell.getNumericCellValue());
        } else if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue().trim();
        } else {
            return cell.toString().replace(".0", "").trim();
        }
    }
}
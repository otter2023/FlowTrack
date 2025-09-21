package com.example.flowtrack.seoulroad.ingest;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExcelReader {

    // 필요하면 외부에서 경로 넘겨서 쓰면 됨
    public List<String> readLinkIds(String excelPath) throws Exception {
        List<String> linkIds = new ArrayList<>();

        try (InputStream fis = new FileInputStream(excelPath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            int linkIdCol = -1;

            Row header = sheet.getRow(0);
            if (header == null) throw new RuntimeException("헤더 행 없음");

            for (Cell cell : header) {
                if (cell != null && cell.getCellType() == CellType.STRING) {
                    String name = cell.getStringCellValue().trim();
                    if (name.contains("서비스링크")) {
                        linkIdCol = cell.getColumnIndex();
                        break;
                    }
                }
            }
            if (linkIdCol == -1) throw new RuntimeException("서비스링크 열을 찾을 수 없음");

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // 헤더 스킵
                Cell cell = row.getCell(linkIdCol, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                if (cell == null) continue;

                String linkId = null;
                if (cell.getCellType() == CellType.NUMERIC) {
                    linkId = String.valueOf((long) cell.getNumericCellValue());
                } else if (cell.getCellType() == CellType.STRING) {
                    linkId = cell.getStringCellValue().trim();
                } else {
                    linkId = cell.toString().replace(".0","").trim();
                }

                if (linkId != null && !linkId.isEmpty()) linkIds.add(linkId);
            }
        }
        return linkIds;
    }
}

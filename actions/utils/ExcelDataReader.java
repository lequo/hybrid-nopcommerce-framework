package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

// Utility class
public class ExcelDataReader {
    public static Object[][] readExcel(String filePath, String sheetName) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet(sheetName);

        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i + 1); // Bỏ qua header
            for (int j = 0; j < colCount; j++) {
                data[i][j] = row.getCell(j).toString();
            }
        }
        workbook.close();
        return data;
    }
}
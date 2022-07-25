package org.ReqRes.Util;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

static XSSFWorkbook workbook;
static XSSFSheet sheet;

    public ExcelUtils(String excelPath,String sheetName) {
        try {
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            System.out.println("exception message" + e.getMessage());
        }
    }
    public static Object getCellData(int rowNum, int colNum) {

        DataFormatter formatter = new DataFormatter();

        Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));

        return value;

    }
    public static int getRowcount()
    {
        int rowCount=sheet.getPhysicalNumberOfRows();

        return rowCount;
    }


}

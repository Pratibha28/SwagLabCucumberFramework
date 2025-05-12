package utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary {

	static String path = "G:\\eclipse-workplace2025\\NewSwagLabsCucumbers\\src\\test\\java\\resources\\TestData.xlsx";
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;

	public ExcelLibrary() {
		ExcelLibrary.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int getRowCount(String sheetName) {

		int index = workbook.getSheetIndex(sheetName);

		if (index == -1) {
			return 0;
		} else {

			sheet = workbook.getSheetAt(index);
			int rowCount = sheet.getLastRowNum() + 1;
			return rowCount;
		}

	}

	public int getColumnCount(String sheetName) {

		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);

		if (row == null) {
			return -1;
		}

		return row.getLastCellNum();

	}

	public int getColumnCount1(String sheetName) {

		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);

		if (row == null) {
			return -1;
		}

		return row.getLastCellNum();

	}

	public String getCellData(String sheeName, int colNum, int rowNum) {
		try {

			if (rowNum < 0) {
				return " ";
			}

			int index = workbook.getSheetIndex(sheeName);

			if (index == -1) {
				return "";
			}

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null) {
				return "";
			}

			cell = row.getCell(colNum);
			return cell.getStringCellValue();

		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist in xls";
		}

	}

}

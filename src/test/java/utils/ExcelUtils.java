package utils;

import java.io.IOException;

import org.apache.poi.ss.format.CellDateFormatter;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static XSSFWorkbook workBook;
	static XSSFSheet sheet;

	public ExcelUtils(String excelPath, String sheetName) {
		try {

			workBook = new XSSFWorkbook(excelPath);
			sheet = workBook.getSheet(sheetName);

		} catch (Exception exp) {
			// TODO Auto-generated catch block
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}


	public static String  getCellData(int rowNum, int colNum) {

		DataFormatter formatter = new DataFormatter();
		Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));

		String val_1 = (String) value; 
		System.out.println(value);
		return val_1;

	}

	public static void getRowCount() {

		/*
		 * String projectDirector = System.getProperty("user.dir"); String excelPath =
		 * projectDirector+"./data/DataDrivenUsingExcel.xlsx";
		 */
		// IN case if this path is not working then try this way

		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("No of Rows: " + rowCount);

	}
}

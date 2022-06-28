package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	XSSFSheet s;

	public ExcelRead() throws IOException {
		FileInputStream f = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\ExcelFile\\Book1.xlsx");
		XSSFWorkbook w = new XSSFWorkbook(f);
		s = w.getSheet("Sheet1");
	}

	public void read() {
		for (Row r : s) {
			for (Cell c : r) {
				System.out.print(c + " ");
			}
			System.out.println();
		}

	}

	public String getStringValueFromExcel(int i, int j) {
		Row r = s.getRow(i);
		Cell c = r.getCell(j);
		int type = c.getCellType();
		switch (type) {
		case Cell.CELL_TYPE_NUMERIC:
			double k = c.getNumericCellValue();
			return String.valueOf(k);

		case Cell.CELL_TYPE_STRING:
			String u = c.getStringCellValue();
			return u;
		default:
			return null;

		}

	}
}

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	
	public ArrayList<String> getData(String testcaseName) throws IOException {
ArrayList<String>    a= new ArrayList<String>();
		
		//FileInput Stream agrument
		FileInputStream fis = new FileInputStream("C:\\Users\\Kiran J\\OneDrive\\Desktop\\demodata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				//Identify Testcases column by scanning the entire 1st row
				Iterator<Row> rows = sheet.iterator();// sheet is collection of rows
				Row firstRow = rows.next();   //Row is collection of cells
				Iterator<Cell> cells = firstRow.cellIterator();
				int k = 0;
				int column = 0;
				while (cells.hasNext()) {
					
					Cell value = cells.next();

					if (value.getStringCellValue().equalsIgnoreCase(testcaseName)) {
						column = k;
					}
					k++;
				}

				System.out.println(column);
				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)) {
						Iterator<Cell> cv = r.cellIterator();
						while(cv.hasNext()) {
						Cell	c=cv.next();
						if (c.getCellType()==CellType.STRING) {
							
					a.add(c.getStringCellValue());		
						}
						else {
							a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
						}
							;
						}
					}

				}
			}
		}


		
		return a;
		
	}

	public static void main(String[] args) throws IOException {
		
		
		
			}

}

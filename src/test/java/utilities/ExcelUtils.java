package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public Sheet sheet;
	public Row row;
	public Cell cell;

	public int getRowCount(String sheetName) throws IOException
	{
		int rowCount = 0;
		fis = new FileInputStream(IframeConstant.ExcelFilePath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		rowCount = sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowCount;
		
	}
	
	
	public int getCellCount(String sheetName,int rowNumber) throws IOException
	{
		fis = new FileInputStream(IframeConstant.ExcelFilePath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNumber);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fis.close();
		return cellCount;
	}
	
	public String getCellData(String sheetName, int rowNumber, int columnNumber) throws IOException
	{
		fis = new FileInputStream(IframeConstant.ExcelFilePath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNumber);
		cell = row.getCell(columnNumber);
		String cellData;
		DataFormatter formatData = new DataFormatter();
		try {
			cellData = formatData.formatCellValue(cell);
		}
		catch(Exception e)
		{
			cellData = "";
		}
		workbook.close();
		fis.close();
		return cellData;
		
	}
}

package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	private String filePath;
	
    public ExcelUtils(String filePath, String sheetName) throws IOException {
        this.filePath = filePath;
        try (FileInputStream fis = new FileInputStream(filePath)) {
            this.workbook = new XSSFWorkbook(fis);
            this.sheet = this.workbook.getSheet(sheetName);
            if (this.sheet == null) {
                throw new IllegalArgumentException("Sheet " + sheetName + " does not exist in the Excel file.");
            }
        } catch (IOException e) {
            System.out.println("Error initializing Excel file: " + e.getMessage());
            throw e;
        }
    }
	public int getRowCount(String sheetName) throws IOException
	{
		int rowCount = 0;
		fis = new FileInputStream(filePath);
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
		System.out.println("SheetName: "+sheetName);
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

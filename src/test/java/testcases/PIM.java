package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.PIMPage;
import utilities.ExcelUtils;
import utilities.IframeConstant;

public class PIM extends BaseTest{

	PIMPage pim_page = new PIMPage();
	LoginPage login = new LoginPage();
	
	@Test
	public void TC001_add_employee() throws Exception
	{
		ExcelUtils excel_utils = new ExcelUtils(IframeConstant.ExcelFilePath,"add_employee");
		pim_page.add_employee(excel_utils.getCellData("add_employee", 1, 0),
				excel_utils.getCellData("add_employee", 1, 1),
				excel_utils.getCellData("add_employee", 1, 2).toString());
	}
	
	@Test	
	public void TC002_search_employee() throws InterruptedException, IOException {
		ExcelUtils excel_utils = new ExcelUtils(IframeConstant.ExcelFilePath,"add_employee");
		pim_page.search_employee(excel_utils.getCellData("add_employee", 1, 0),
				excel_utils.getCellData("add_employee", 1, 1));
	}
	
}

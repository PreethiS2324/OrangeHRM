package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtils;
import utilities.IframeConstant;

public class Login extends BaseTest{

	public WebDriver driver;

	LoginPage login = new LoginPage();
	
	@Test
	public void login_to_application() throws IOException
	{
		ExcelUtils excel_utils = new ExcelUtils(IframeConstant.ExcelFilePath, "login");
		login.login_method(excel_utils.getCellData("login",1,0),excel_utils.getCellData("login",1,1));
	}
	
	@Test
	public void logout_from_application() throws InterruptedException
	
	{
		
		login.logout_method();
	}

}

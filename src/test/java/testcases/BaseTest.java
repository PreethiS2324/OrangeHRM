package testcases;


import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import utilities.DriverInit;
import utilities.FileUtils;

public class BaseTest {

	FileUtils file_utils = new FileUtils();
	 @BeforeSuite
	    public void setUpSuite() throws IOException {
		    DriverInit.getDriver().manage().window().maximize();
	        DriverInit.getDriver().get(file_utils.readData("URL"));
	         
	    }
	 
	    @AfterSuite
	    public void tearDownSuite() {
	        DriverInit.quitDriver();
	    }
}
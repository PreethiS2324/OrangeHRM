package utilities;

import org.openqa.selenium.WebDriver;


public class BaseClass {
	
		public WebDriver driver;	
	    public BaseClass() {
	        this.driver = DriverInit.getDriver();
	    }
     
}

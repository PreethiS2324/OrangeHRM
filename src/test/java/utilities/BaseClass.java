package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public WebDriver driver;	
	public static WebDriver staticdriver;
	JavaUtils java_utils = new JavaUtils();
	FileUtils file_utils = new FileUtils();
	WebDriverUtils webdriver_utils = new WebDriverUtils();

   @BeforeClass
	public void initializeBrowser(String browserName) throws IOException {
        switch (browserName.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                webdriver_utils.WaitForPageLoad(driver, 10);
                webdriver_utils.maximize_window(driver);
                staticdriver = driver;
                driver.get(file_utils.readData("URL"));
                break;

            case "firefox":
                driver = new FirefoxDriver();
                webdriver_utils.WaitForPageLoad(driver, 10);
                webdriver_utils.maximize_window(driver);
                staticdriver = driver;
                driver.get(file_utils.readData("URL"));
                break;

            case "edge":
                driver = new EdgeDriver();
                webdriver_utils.WaitForPageLoad(driver, 10);
                webdriver_utils.maximize_window(driver);
                staticdriver = driver;
                driver.get(file_utils.readData("URL"));
                break;

            default:
                throw new IllegalArgumentException("Browser not supported: " + browserName);
        }
}
   
   public void login()
   {
	   
   }
    
    
    
}
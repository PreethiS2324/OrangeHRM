package utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class WebDriverUtils {

	public static String takescreenshot(WebDriver driver,String screenshotName) throws IOException
	{
	
		JavaUtils ju = new JavaUtils();
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		String path = "./Screenshot/"+screenshotName+" "+ju.getSystemDate()+".jpg";
		File dest = new File(path);
		String screenshotPath = dest.getAbsolutePath();
		//Files.copy(src, dest);
		FileUtils.copyFile(src, dest);
		return screenshotPath;	
	}
	
	public void WaitForPageLoad(WebDriver driver,int seconds)
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
	}
	
	public void maximize_window(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
}

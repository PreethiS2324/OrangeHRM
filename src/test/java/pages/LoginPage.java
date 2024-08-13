package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BaseClass;
import utilities.WebDriverUtils;

public class LoginPage extends BaseClass{

	 public LoginPage() {
	        super();
	    }
	By username = By.name("username");
	By password = By.name("password");
	By login_button = By.xpath("//button[@type='submit']");
	By user_dropdown = By.xpath("//p[contains(@class, 'name')]/following-sibling::i");
	By logout = By.xpath("//a[contains(text(),'Logout')]");
	
	public void login_method(String user_name,String pwd) throws IOException
	{
		WebElement user = WebDriverUtils.waitForElementToBePresent(driver, username, Duration.ofSeconds(10));
		user.sendKeys(user_name);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(login_button).click();
	}
	
	public void logout_method() throws InterruptedException
	{
		WebElement user = WebDriverUtils.waitForElementToBePresent(driver, user_dropdown, Duration.ofSeconds(10));
		Thread.sleep(2000);
		user.click();
		driver.findElement(logout).click();
	}
}

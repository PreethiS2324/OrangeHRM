package pages;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BaseClass;
import utilities.WebDriverUtils;

public class PIMPage extends BaseClass{
	
	 public PIMPage() {
	        super();
	    }
	 
	By PIM_menu = By.xpath("//ul[@class='oxd-main-menu']/li[2]");
	By Add_employee = By.xpath("//i[contains(@class,'plus')]/parent::button");
	By FirstName = By.name("firstName");
	By LastName = By.name("lastName");
	By EmployeeID= By.xpath("//div/label[contains(text(),'Employee Id')]/following::div/input");
	By save_button = By.xpath("//button[@type='submit']");
	By emp_info = By.xpath("//div[@class='oxd-table-filter-header']/div[2]//i");
	By emp_down_arrow = By.xpath("//i[@class='oxd-icon bi-caret-down-fill']");
	By emp_up_arrow = By.xpath("//i[@class='oxd-icon bi-caret-up-fill']");
	By emp_name = By.xpath("//label[contains(text(),'Employee Name')]/following::div[1]//input");
	By search_button = By.xpath("//button[@type='submit']");
	By record = By.xpath("//*[@class='oxd-table-card --mobile']");
	By added_emp_name = By.xpath("//div[@class='orangehrm-edit-employee-name']/h6");
	By emp_fname = By.xpath("//div[contains(text(),'First (& Middle) Name')]/following-sibling::div");
	By emp_lname = By.xpath("//div[contains(text(),'Last Name')]/following-sibling::div");
	
	public void click_PIM_menu()
	{
		WebElement PIM_MENU = WebDriverUtils.waitForElementToBePresent(driver, PIM_menu, Duration.ofSeconds(10));
		PIM_MENU.click();
	}
	
	
	public void add_employee(String firstname, String lastname, String emp_ID) throws InterruptedException
	{

		click_PIM_menu();
		WebElement Add_button = WebDriverUtils.waitForElementToBePresent(driver, Add_employee, Duration.ofSeconds(10));
		Add_button.click();
		WebElement fname = WebDriverUtils.waitForElementToBePresent(driver, FirstName, Duration.ofSeconds(10));
		fname.sendKeys(firstname);
		driver.findElement(LastName).sendKeys(lastname);
		driver.findElement(EmployeeID).clear();
		Thread.sleep(2000);
		driver.findElement(EmployeeID).sendKeys(emp_ID);
		driver.findElement(save_button).click();
	
	}
	
	public void search_employee(String firstname, String lastname) throws InterruptedException
	{
		click_PIM_menu();
		WebElement emp_information = WebDriverUtils.waitForElementToBePresent(driver, emp_info, Duration.ofSeconds(10));
		String emp_info_class=driver.findElement(emp_info).getAttribute("class");
		if(emp_info_class.contains("down"))
			emp_information.click();
		String fullname = firstname + " " +lastname;
		driver.findElement(emp_name).sendKeys(fullname);
		driver.findElement(search_button).click();
		Thread.sleep(2000);
		try{
			emp_information.click();
			Thread.sleep(2000);
			WebElement emp_firstname = WebDriverUtils.waitForElementToBePresent(driver, emp_fname, Duration.ofSeconds(10));
			String fname = emp_firstname.getText();
			WebElement emp_lastname = WebDriverUtils.waitForElementToBePresent(driver, emp_lname, Duration.ofSeconds(10));
			String lname = emp_lastname.getText();
			Thread.sleep(2000);
			System.out.println("Record added");
			assertTrue((fname.equals(firstname) && lname.equals(lastname)), "Record added");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}
}

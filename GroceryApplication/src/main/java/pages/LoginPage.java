package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	
	public WebDriver driver;
	WaitUtility waitutilityref = new WaitUtility();
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//input[@placeholder='Username']")WebElement username;
	@FindBy(xpath = "//input[@placeholder='Password']")WebElement password;
	@FindBy(xpath = "//button[@type='submit']")WebElement submit;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")WebElement rmart;
	@FindBy(linkText="Dashboard")WebElement dashboard;

	
	 public LoginPage enterUsername(String loginUsername) {
			username.sendKeys(loginUsername);
			return this;
			
		}
	 public LoginPage enterPassword(String loginPassword) {
		 password.sendKeys(loginPassword);
		 return this;
	 }
	 public HomePage enterSubmit() {
		 waitutilityref.waitUntilElementToBeClickable(driver, submit);
		 submit.click();
		 return new HomePage(driver);
		 
	 }
	 
     public String getName() {
		 String name= rmart.getText();
		 return name ;
		 
	 }
	 public boolean verifyWhetherDashboardDisplayed() {
		// TODO Auto-generated method stub
		return dashboard.isDisplayed();
	 }
	
	
	

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUserPage {
	
	public WebDriver driver;
	PageUtility pageutilityref = new PageUtility();
	
	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//New 
			@FindBy(xpath ="//a[@class='btn btn-rounded btn-danger']")WebElement newUser;
			@FindBy(id="username")WebElement username;
			@FindBy(id="password")WebElement password;
			@FindBy(xpath="//button[@name='Create']")WebElement save;
			@FindBy(id="user_type")WebElement userType;
			@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertbox;
			
			//Search
			@FindBy(xpath= "//a[text()=' Search']")WebElement search;
			@FindBy(id= "un")WebElement searchUsername;
			@FindBy(id= "ut")WebElement searchUserType;
			@FindBy(xpath="//button[@name='Search']")WebElement searchButton;
			
			//table 
			@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")WebElement searchresult;
			
			 public void clickNewUser() {
				 newUser.click();
					
				}
			 public void enterUsername(String adminUsername) {
				 username.sendKeys(adminUsername);
					
				}
			 public void enterPassword(String adminPassword) {
				 password.sendKeys(adminPassword);
					
				}
			 
			 public void enterUserType() {
					/*
					 * Select sc = new Select(userType); sc.selectByValue("staff");
					 */
				 pageutilityref.selectDragDropWithValue(userType, "staff");
			 }
			 
			 public void enterSave() {
				 save.click();
					
				} 
			 
			 public void clickSearch() {
				 search.click();
				 
			 }
			 public void enterSearchUsername(String searchUname) {
				 searchUsername.sendKeys(searchUname);
			 }
			 
			 public void enterSearchType() {
					/*
					 * Select sc = new Select(searchUserType); sc.selectByValue("staff");
					 */
				 pageutilityref.selectDragDropWithValue(userType, "staff");
				 
			 }
			 
			 public void enterSearchButton() {
				 searchButton.click();
			 }
			 
			 public Boolean alertBoxDisplayed() {
				 return alertbox.isDisplayed();
				 
				 
			 }
			 
			 public String getSearchResult() {
				 String searchResultName = searchresult.getText();
				return searchResultName;
				 
			 }
	

}

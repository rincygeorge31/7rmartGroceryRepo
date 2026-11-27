package pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePage {
	
	public WebDriver driver;
	
	public ManagePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);	
		
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement addNewPage;
	@FindBy(id="title")WebElement pageTitle;
	@FindBy(xpath="//div[@class='note-editable card-block']")WebElement newpageDescription;
	@FindBy(id="page")WebElement newPage;
	@FindBy(id="main_img")WebElement imageFile;
	@FindBy(xpath="//button[text()='Save']")WebElement saveButton;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement search;
	@FindBy(xpath="//input[@name='un']")WebElement searchTitle;
	@FindBy(xpath="//button[@name='Search']")WebElement searchButton;
	
	//table finding 
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td")WebElement pageDetails;
	
	public void clickAddNewPage() {
		addNewPage.click();
		
	}
	
	public void enterTitle(String titleName) {
		pageTitle.sendKeys(titleName);
	}
	
	public void enterDescription(String pageDescription) {
		newpageDescription.sendKeys(pageDescription);
	}
	
	public void enterPage(String page) {
		newPage.sendKeys(page);
	}
	
	public void enterImage(String image) {
		imageFile.sendKeys(image);
	}
	
	
	public void scrollToSave() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// js.executeScript("window.scrollBy(0,350)", "");
		js.executeScript("arguments[0].click();", saveButton);
	}

	public String getURL() {
		
		return driver.getCurrentUrl();
		
	}
	
	
	public void clickSearch() {
		search.click();
		
	}
	
	public void enterSearchTitle(String searchTitles) {
		searchTitle.sendKeys(searchTitles);
	}
	
	public void clickSearchButton() {
		searchButton.click();
		
	}

	public String getDetails() {
		return pageDetails.getText();

	}
	
		

}

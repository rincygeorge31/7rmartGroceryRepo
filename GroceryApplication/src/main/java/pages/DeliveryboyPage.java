package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveryboyPage {
	public WebDriver driver;

	public DeliveryboyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//i[@class='fas fa-edit']//preceding::a[text()=' New']")WebElement newDeliveryboy;
	@FindBy(id = "name")WebElement deliveryboyName;
	@FindBy(id = "email")WebElement deliveryboyEmail;
	@FindBy(id = "phone")WebElement deliveryboyPhone;
	@FindBy(id = "address")WebElement deliveryboyAddress;
	@FindBy(id = "username")WebElement deliveryboyUsername;
	@FindBy(id = "password")WebElement deliveryboyPassword;
	@FindBy(xpath = "//button[@name='create']")WebElement deliverySaveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement deliveryBoyAlert;

	@FindBy(xpath = "//a[text()=' Search']")WebElement deliverysearch;
	@FindBy(id = "un")WebElement searchDeliveryboyName;
	@FindBy(id = "ut")WebElement searchDeliveryboyEmail;
	@FindBy(id= "ph")WebElement searchDeliveryboyPhonenumber;
	@FindBy(xpath = "//button[@name='Search']")WebElement deliveryboySearchButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")WebElement deliveryboySearchresult;
	
	public void clickNewDeliveryboy() {
		newDeliveryboy.click();

	}

	public void enterDeliveryboyName(String deliveryBoyName) {
		deliveryboyName.sendKeys(deliveryBoyName);

	}

	public void enterDeliveryboyEmail(String deliveryBoyEmail) {
		deliveryboyEmail.sendKeys(deliveryBoyEmail);

	}

	public void enterDeliveryboyPhonenumber(String deliveryBoyPhoneNumber) {
		deliveryboyPhone.sendKeys(deliveryBoyPhoneNumber);

	}

	public void enterDeliveryboyAddress(String deliveryBoyAddress) {
		deliveryboyAddress.sendKeys(deliveryBoyAddress);

	}

	public void enterDeliveryboyUsername(String deliveryBoyUsername) {
		deliveryboyUsername.sendKeys(deliveryBoyUsername);

	}

	public void enterDeliveryboyPassword(String deliveryBoyPassword) {
		deliveryboyPassword.sendKeys(deliveryBoyPassword);

	}

	public void clickSave() {
		deliverySaveButton.click();

	}

	public void scrollToSave() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", deliverySaveButton);

		js.executeScript("window.scrollBy(0,350)", "");
	}

	public Boolean alertBoxDisplayed() {
		return deliveryBoyAlert.isDisplayed();

	}

	public void clickDeliveryboySearch() {
		deliverysearch.click();

	}

	public void enterSearchDeliveryBoyName(String deliveryboySearchName) {
		searchDeliveryboyName.sendKeys(deliveryboySearchName);
	}

	public void enterSearchDeliveryBoyEmail(String deliveryboySearchEmail) {
		searchDeliveryboyEmail.sendKeys(deliveryboySearchEmail);
	}

	public void enterSearchDeliveryBoyPhoneNumber(String deliveryboySearchPhone) {
		searchDeliveryboyPhonenumber.sendKeys(deliveryboySearchPhone);
	}

	public void enterSearchButton() {
		deliveryboySearchButton.click();
	}

	public String getSearchResult() {
		String searchResultName = deliveryboySearchresult.getText();
		return searchResultName;

	}

}

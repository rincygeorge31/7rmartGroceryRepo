package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Logout
	@FindBy(linkText = "Admin")WebElement admin;
	@FindBy(linkText = "Logout")WebElement logout;
	// @FindBy(xpath ="//a[text()='More info ']//following::i[@class=' fa fa-users widget-stat-icon']")WebElement moreInfo;
	@FindBy(xpath = "//div[@class='inner']//p[text()='Admin Users']/../following-sibling::a")WebElement moreInfoAdmin;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div[8]/div/a")WebElement manageDeliveryMoreInfo;
	@FindBy(xpath="//div[@class='content-wrapper']//following::p[text()='Manage Pages']//parent::div//parent::div[@class='small-box bg-info']//child::a[text()='More info ']")WebElement managPageMoreInfo;

	public HomePage clickAdmin() {
		admin.click();
		return this;

	}

	public LoginPage clickLogout() {
		logout.click();
		return new LoginPage(driver);

	}

	public void clickMoreInfo() {
		moreInfoAdmin.click();

	}

	public void clickmanageDeliveryMoreInfo() {
		manageDeliveryMoreInfo.click();

	}
	
	public void clickmanagPageMoreInfo() {
		managPageMoreInfo.click();
	}

}

package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import mainProject.Base;
import pages.DeliveryboyPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class DeliveryBoyTest extends Base {
	
	
	@Test(description="Admin is adding new delivery user details")
	public void addNewDeliverBoyDetails() throws IOException {

		LoginPage loginPage = new LoginPage(driver);
		
		String loginUsername = ExcelUtility.readStringData(0, 0, "loginData");
		String loginPassword = ExcelUtility.readStringData(0, 1, "loginData");

		loginPage.enterUsername(loginUsername);
		loginPage.enterPassword(loginPassword);
		loginPage.enterSubmit();
		
		HomePage home = new HomePage(driver);
		home.clickmanageDeliveryMoreInfo();
		
		DeliveryboyPage delivery = new DeliveryboyPage(driver);
		
		
		String deliveryName = ExcelUtility.readStringData(0, 0, "deliveryboyDetails");
		String deliveryEmail = ExcelUtility.readStringData(0, 1, "deliveryboyDetails");
		String deliveryPhonenumber = ExcelUtility.readIntegerData(0, 2, "deliveryboyDetails");
		String deliveryAddress = ExcelUtility.readStringData(0, 3, "deliveryboyDetails");
		String deliveryUsername = ExcelUtility.readStringData(0, 4, "deliveryboyDetails");
		String deliveryPassword = ExcelUtility.readStringData(0, 5, "deliveryboyDetails");
		
		
		delivery.clickNewDeliveryboy();
		delivery.enterDeliveryboyName(deliveryName);
		delivery.enterDeliveryboyEmail(deliveryEmail);
		delivery.enterDeliveryboyPhonenumber(deliveryPhonenumber);
		delivery.enterDeliveryboyAddress(deliveryAddress);
		delivery.enterDeliveryboyUsername(deliveryUsername);
		delivery.enterDeliveryboyPassword(deliveryPassword);
		
		delivery.scrollToSave();
		
		boolean alertStatus =delivery.alertBoxDisplayed();
		
		Assert.assertTrue(alertStatus, "Unable to create new delivery boy details");
		
		
		

}
	
	@Test(description=" Admin is searching the deliveryboy details")
	public void searchUser() throws IOException {

		LoginPage loginPage = new LoginPage(driver);

		String loginUsername = ExcelUtility.readStringData(0, 0, "loginData");
		String loginPassword = ExcelUtility.readStringData(0, 1, "loginData");

		loginPage.enterUsername(loginUsername);
		loginPage.enterPassword(loginPassword);
		loginPage.enterSubmit();
		
		HomePage home = new HomePage(driver);
		home.clickmanageDeliveryMoreInfo();
		
		DeliveryboyPage dp= new DeliveryboyPage(driver);
		String deliveryName = ExcelUtility.readStringData(0, 0, "deliveryboyDetails");
		String deliveryEmail = ExcelUtility.readStringData(0, 1, "deliveryboyDetails");
		String deliveryPhonenumber = ExcelUtility.readIntegerData(0, 2, "deliveryboyDetails");
		
		dp.clickDeliveryboySearch();
		dp.enterSearchDeliveryBoyName(deliveryName);
		dp.enterSearchDeliveryBoyEmail(deliveryEmail);
		dp.enterSearchDeliveryBoyPhoneNumber(deliveryPhonenumber);
		dp.enterSearchButton();
		
		String searchResult = dp.getSearchResult();
		Assert.assertEquals(searchResult, deliveryName,"Admin is unable to search the delivery boy ");
		
	}
	
}
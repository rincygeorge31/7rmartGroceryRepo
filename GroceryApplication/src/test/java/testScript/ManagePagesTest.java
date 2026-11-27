package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import mainProject.Base;
import pages.HomePage;
import pages.ManagePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class ManagePagesTest extends Base {
	
	@Test
	public void addNewManagePage() throws IOException {
		

		LoginPage loginPage = new LoginPage(driver);
		
		String loginUsername= ExcelUtility.readStringData(0, 0, "loginData");
		String loginPassword = ExcelUtility.readStringData(0, 1, "loginData");
		
		loginPage.enterUsername(loginUsername);
		loginPage.enterPassword(loginPassword);
		loginPage.enterSubmit();
		
		HomePage home = new HomePage(driver);
		home.clickmanagPageMoreInfo();
		
		ManagePage lp = new ManagePage(driver);
		lp.clickAddNewPage();
		
		String title = ExcelUtility.readStringData(0, 0, "managePage");
		String description = ExcelUtility.readStringData(0, 1, "managePage");
		String page = ExcelUtility.readStringData(0, 2, "managePage");
		String image= "C:\\Users\\HP\\eclipse-workspace\\GroceryApplication\\src\\test\\resources\\image1.jpg";
		lp.enterTitle(title);
		lp.enterDescription(description);
		lp.enterImage(image);
		lp.enterPage(page);
		lp.scrollToSave();
		String actualbrowsertitle = lp.getURL();
		String expectedtitle="https://groceryapp.uniqassosiates.com/admin/page/add";
		Assert.assertEquals(actualbrowsertitle,expectedtitle, "ManagePage is not working");
		
		
		
	}
	
	@Test
	public void searchManagePage() throws IOException {
			
	
			LoginPage loginPage = new LoginPage(driver);
			
			String loginUsername= ExcelUtility.readStringData(0, 0, "loginData");
			String loginPassword = ExcelUtility.readStringData(0, 1, "loginData");
			
			loginPage.enterUsername(loginUsername);
			loginPage.enterPassword(loginPassword);
			loginPage.enterSubmit();
			
			HomePage home = new HomePage(driver);
			home.clickmanagPageMoreInfo();
			
			String title = ExcelUtility.readStringData(0, 0, "managePage");
			
			ManagePage lp = new ManagePage(driver);
			lp.clickSearch();
			lp.enterSearchTitle(title);
			lp.clickSearchButton();
		    
			String actualdetails= lp.getDetails();
			
			Assert.assertEquals(actualdetails, title,"Manage page search is not working");
			
	
	}
}

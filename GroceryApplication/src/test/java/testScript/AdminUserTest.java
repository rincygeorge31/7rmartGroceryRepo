package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import mainProject.Base;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUserTest extends Base {
	
@Test(description="Admin is able to add new admin user")
	
	public void addNewUser() throws IOException {

		LoginPage loginPage = new LoginPage(driver);
		
		RandomDataUtility rd= new RandomDataUtility();

		String loginUsername = ExcelUtility.readStringData(0, 0, "loginData");
		String loginPassword = ExcelUtility.readStringData(0, 1, "loginData");

		loginPage.enterUsername(loginUsername);
		loginPage.enterPassword(loginPassword);
		loginPage.enterSubmit();
		
		HomePage home = new HomePage(driver);
		home.clickMoreInfo();
		
		AdminUserPage adminPage = new AdminUserPage(driver);
        String adminUsername=rd.generateRandomUsername();
        String adminPassword=rd.generateRandomPassword();
        
        
        adminPage.clickNewUser();
        adminPage.enterUsername(adminUsername);
        adminPage.enterPassword(adminPassword);
        adminPage.enterUserType();
        adminPage.enterSave();
        
        Boolean displayedStaus = adminPage.alertBoxDisplayed();
        Assert.assertTrue(displayedStaus,"unable to create the new user");
        
        

    }
	
	@Test(description="Admin is able to search the admin user")
	public void searchUser() throws IOException {

		LoginPage loginPage = new LoginPage(driver);

		String loginUsername = ExcelUtility.readStringData(0, 0, "loginData");
		String loginPassword = ExcelUtility.readStringData(0, 1, "loginData");

		loginPage.enterUsername(loginUsername);
		loginPage.enterPassword(loginPassword);
		loginPage.enterSubmit();
		
		HomePage home = new HomePage(driver);
		home.clickMoreInfo();
		AdminUserPage adminPage = new AdminUserPage(driver);
		
        String searchUsername=ExcelUtility.readStringData(0, 0, "UserData");
        
        adminPage.clickSearch();
        adminPage.enterSearchUsername(searchUsername);
        adminPage.enterSearchType();
        adminPage.enterSearchButton();
        
        
        String actualSearchResult = adminPage.getSearchResult();
        
        Assert.assertEquals(actualSearchResult,searchUsername,"Search is not working properly");
        

    }

}

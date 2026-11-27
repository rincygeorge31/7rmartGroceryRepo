package testScript;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import mainProject.Base;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{
	
	HomePage home;
	
	@Test(priority=1 , description="User is trying to login with valid credentials",groups= {"smoke"})
	public void validCredentials() throws IOException {
		
		LoginPage loginPage = new LoginPage(driver);
		
		String loginUsername= ExcelUtility.readStringData(0, 0, "loginData");
		String loginPassword = ExcelUtility.readStringData(0, 1, "loginData");
		
		loginPage.enterUsername(loginUsername).enterPassword(loginPassword);
		
		home=loginPage.enterSubmit();
		
		boolean dashboardDisplay = loginPage.verifyWhetherDashboardDisplayed();
		Assert.assertTrue(dashboardDisplay, Constant.ERROR_MESSAGE1);
		
		
	}
	
	@Test(priority=2,description="User is trying to login with invalid credentials",groups= {"smoke"})
	public void invalidCredentials() throws IOException {
			
			LoginPage loginPage = new LoginPage(driver);
			
			String loginUsername= ExcelUtility.readStringData(1, 0, "loginData");
			String loginPassword = ExcelUtility.readStringData(1, 1, "loginData");
			
			loginPage.enterUsername(loginUsername).enterPassword(loginPassword).enterSubmit();
			
			String actualName =  loginPage.getName() ;
			String expectedName = "7rmart supermarket";
			
			Assert.assertEquals(actualName, expectedName, "User is able to login with invalid credentials");
			
			
			
	}
	
	@Test(priority=3,description="User is trying to login with invalid username",dataProvider = "LoginData")
	public void invalidusernameCredentials(String loginUsername, String loginPassword) throws IOException {
		
		LoginPage loginPage = new LoginPage(driver);
		
		/*
		 * String loginUsername= ExcelUtility.readStringData(2, 0, "loginData"); String
		 * loginPassword = ExcelUtility.readStringData(2, 1, "loginData");
		 */
		loginPage.enterUsername(loginUsername).enterPassword(loginPassword).enterSubmit();
		
		String actualName =  loginPage.getName() ;
		String expectedName = "7rmart supermarket";
		
		Assert.assertEquals(actualName, expectedName, "User is able to login with invalid username");
		
		
	}
	
	@Test(priority=4,description="User is trying to login with invalid password",retryAnalyzer=retry.Retry.class)
	
	public void invalidPasswordCredentials() throws IOException {
			
			LoginPage loginPage = new LoginPage(driver);
			
			
			  String loginUsername= ExcelUtility.readStringData(3, 0, "loginData"); String
			  loginPassword = ExcelUtility.readStringData(3, 1, "loginData");
			 
			
			loginPage.enterUsername(loginUsername).enterPassword(loginPassword).enterSubmit();
			
			String actualName =  loginPage.getName() ;
			String expectedName = "7rmart supermarket";
			Assert.assertEquals(actualName, expectedName, "User is able to login with invalid password");
			
	}
	
	@DataProvider(name = "LoginData")
	public Object[][] getDataFromDataProvider(){
		
		return new Object[][] { new Object[] {"invalid","admin"},new Object[] {"Test","admin"}};
		
	}
 
}

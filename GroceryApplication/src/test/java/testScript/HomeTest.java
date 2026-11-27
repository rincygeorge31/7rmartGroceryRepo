package testScript;

import java.io.IOException;


import org.testng.annotations.Test;

import mainProject.Base;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest  extends Base {

	@Test
	public void verifyWhetherTheUserAbleToSuccessfullyLogout() throws IOException {

			LoginPage loginPage = new LoginPage(driver);
	
			String loginUsername = ExcelUtility.readStringData(0, 0, "loginData");
			String loginPassword = ExcelUtility.readStringData(0, 1, "loginData");
	
			loginPage.enterUsername(loginUsername).enterPassword(loginPassword);
			loginPage.enterSubmit();
			
			HomePage home = new HomePage(driver);
			home.clickAdmin();
			home.clickLogout();
			
		   

	}
	
	
	
	
}

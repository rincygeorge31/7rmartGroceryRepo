package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {
	                                                   //methodname 
	public void getScreenshot(WebDriver driver, String failedTestCase) throws IOException {
                                      //interface  
			TakesScreenshot scrShot = (TakesScreenshot) driver;
			File screenShot = scrShot.getScreenshotAs(OutputType.FILE);
                                   //class
			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
                              //to get the local path of project //creating a folder OutputScreenShot  
			File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");// create file in directory
			if (!f1.exists()) {
             
			// repeating the above steps if f1 not exist 
			f1.mkdirs();
			}
			
			String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
			+ ".png";
			// String destination = f1.getPath() + "//" + failedTestCase + timeStamp +
			// ".png";

			File finalDestination = new File(destination);
			//adding the image to the finalDestintion
			FileHandler.copy(screenShot, finalDestination);
			}

}

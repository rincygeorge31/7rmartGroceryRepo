package utilities;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public WebDriver driver;

	public void selectDragDropWithValue(WebElement element, String value) {

		Select object = new Select(element);

		object.selectByValue(value);

	}

	public void selectDragDropWithIndex(WebElement element, int value) {

		Select object = new Select(element);

		object.selectByIndex(value);

	}

	public void selectDragDropWithVisibleText(WebElement element, String value) {

		Select object = new Select(element);

		object.selectByVisibleText(value);

	}

	// javscript excutor methods
	public void scrollToSave(WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,350)", "");
		js.executeScript("arguments[0].click();", element);
	}

	public void clickFunction(WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	// mouse actions
	public void verifyRightClick(WebElement element) {

		Actions actionRightClick = new Actions(driver);
		actionRightClick.contextClick(element).build().perform();
	}

	public void verifyMouseHover(WebElement element) {

		Actions actionMouseHover = new Actions(driver);
		actionMouseHover.moveToElement(element).build().perform();

	}

	public void verifyDoubleClick(WebElement element) {

		Actions actionDoubleClick = new Actions(driver);
		actionDoubleClick.doubleClick(element).build().perform();

	}

	public void dragAndDrop(WebElement dragelement, WebElement dropelement) {

		Actions draganddropref = new Actions(driver);
		draganddropref.dragAndDrop(dragelement, dropelement).build().perform();

	}

}

package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralaUtilities {

	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public void clickButton(WebElement element) {
		element.click();
	}

	public void actionsOperations(WebElement element, WebDriver driver) {
		Actions obj = new Actions(driver);
		obj.moveToElement(element).perform();
	}

	public String backgroundColor(WebElement element, String font) {
		return element.getCssValue(font);

	}

	public String alertBoxText(WebDriver driver) {
		return driver.switchTo().alert().getText();

	}

	public void accepingAlertBox(WebDriver driver) {
		driver.switchTo().alert().accept();

	}

	public String getAttributeValue(WebElement element, String type) {

		return element.getAttribute(type);
	}

	public boolean isSlelectedVerifycheckbox(WebElement element) {

		return element.isSelected();
	}

	public String getTitle(WebDriver driver) {

		return driver.getTitle();
	}

	public String getUrl(WebDriver driver) {

		return driver.getCurrentUrl();
	}

	public void sendKeys(WebElement element, String text) {

		element.sendKeys(text);
	}

	public void enterKeyPress(WebDriver driver) {
		Actions obj = new Actions(driver);
		obj.sendKeys(Keys.ENTER).perform();

	}

	public void fileUpload(WebDriver driver, WebElement element, String path) throws AWTException {
		Actions obj1 = new Actions(driver);
		obj1.moveToElement(element).click().perform();

		Robot obj = new Robot();
		StringSelection ss = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		obj.delay(1000);
		obj.keyPress(KeyEvent.VK_CONTROL);
		obj.keyPress(KeyEvent.VK_V);

		obj.keyRelease(KeyEvent.VK_CONTROL);
		obj.keyRelease(KeyEvent.VK_V);

		obj.delay(1000);
		obj.keyPress(KeyEvent.VK_ENTER);
		obj.keyRelease(KeyEvent.VK_ENTER);
	}

	public String tableDetails(WebDriver driver, String xpathValue, int i) {
		List<WebElement> record = driver.findElements(By.xpath(xpathValue));
		return record.get(i).getText();
	}

	public void javaScriptExecutorScroll(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,50000)");
	}

	public void javaScriptExecutorClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public String dropDown(WebElement element, int i) {
		Select obj = new Select(element);
		obj.selectByIndex(i);
		WebElement a = obj.getFirstSelectedOption();
		return a.getText();
	}

	public String toolTipValue(WebElement element, String type) {

		return element.getAttribute(type);
	}

	public int numberOfRecordsInTable(WebDriver driver, String locator) {

		List<WebElement> tableRecords = driver.findElements(By.xpath(locator));
		int count = 0;
		for (WebElement a : tableRecords) {
			count++;
		}
		return count;
	}

	public List<WebElement> listRecords(WebDriver driver, String locator) {
		return driver.findElements(By.xpath(locator));

	}

	public int CountOfRecords(List<WebElement> record) {
		return record.size();
	}

	public void generalSleep() throws InterruptedException {

		Thread.sleep(5000);
	}

	public boolean isPictureDisplayed(WebElement element) {

		return element.isDisplayed();
	}

	public String todaysDate() {
		DateFormat format = new SimpleDateFormat("dd/mm/yy");
		Date today = new Date();
		String completeDate = format.format(today);
		return completeDate.substring(0, 2);

	}

	public String checkBackgroundColorOfDates(WebDriver driver, String locator) {
		String color = "rgba(0, 94, 184, 1)";
		String date = null;
		List<WebElement> dates = driver.findElements(By.xpath(locator));
		for (WebElement a : dates) {
			if (color.equals(a.getCssValue("background-color"))) {
				date = a.getText();
				break;
			}
		}
		return date;

	}

}

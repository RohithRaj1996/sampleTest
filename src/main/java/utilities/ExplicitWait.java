package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	WebDriverWait w;
	public void waitAttributeContains(WebDriver driver,String locator, String type,String value)
	{
		w=new WebDriverWait(driver, Duration.ofSeconds(4));
		w.until(ExpectedConditions.attributeContains(By.xpath(locator), type, value));
	}
	
	public void waitPresenceOfElementLocated(WebDriver driver,String locator)
	{
		w=new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
	}
	
	public void waitAlertsPresent(WebDriver driver)
	{
		w=new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.alertIsPresent());
	}

}

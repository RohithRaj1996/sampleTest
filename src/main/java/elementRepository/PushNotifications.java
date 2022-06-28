package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralaUtilities;

public class PushNotifications {
	public PushNotifications(WebDriver driver) {
		 this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	WebDriver driver;
	GeneralaUtilities gu = new GeneralaUtilities();
	@FindBy(xpath = "//p[text()='Push Notifications']")
	WebElement pushNotification;
	@FindBy(id = "title")
	WebElement title;
	@FindBy(id = "description")
	WebElement descriptionField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement sendButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successMessage;

	public void clickPushNotifications() {
		gu.clickButton(pushNotification);
	}

	public void clickSendButton() {
		gu.clickButton(sendButton);
	}

	public void enterTitle(String name) {
		gu.sendKeys(title, name);
	}

	public void enterDescription(String description) {
		gu.sendKeys(descriptionField, description);
	}
	public String getTextOfSuccessMessage() {
		return gu.getElementText(successMessage);
	}

}

package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralaUtilities;

public class ManageDeliveryBoy {
	public ManageDeliveryBoy(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;
	GeneralaUtilities gu = new GeneralaUtilities();
	@FindBy(xpath = "//p[text()='Manage Delivery Boy']")
	WebElement manageDeliveryBoy;
	@FindBy(xpath = "(//i[@class='fas fa-edit'])[1]")
	WebElement newButton;
	@FindBy(id = "name")
	WebElement enterNameField;
	@FindBy(id = "email")
	WebElement enterEmailField;
	@FindBy(id = "phone")
	WebElement enterPhoneNumberField;
	@FindBy(id = "address")
	WebElement enterAddressField;
	@FindBy(id = "username")
	WebElement enterUsernameField;
	@FindBy(id = "password")
	WebElement enterPasswordField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tr[1]//td[1]")
	WebElement tableValue;
	@FindBy(xpath = "(//span[@aria-hidden='true'])[1]")
	WebElement nextButton;
	@FindBy(xpath = "//li[@class='page-item active']")
	WebElement activePage;
	

	public void clickManageDeliveryBoy() {
		gu.clickButton(manageDeliveryBoy);
	}

	public void clickNewButton() {
		gu.clickButton(newButton);
	}

	public void clickSaveButton() {
		// gu.javaScriptExecutorScroll(driver);
		// Actions obj=new Actions(driver);
		// obj.moveToElement(saveButton).click().perform();
		// gu.clickButton(saveButton);
		gu.javaScriptExecutorClick(driver, saveButton);
	}

	public void enterFields(String name, String mail, String phone, String address, String userName, String password) {
		gu.sendKeys(enterNameField, name);
		gu.sendKeys(enterEmailField, mail);
		gu.sendKeys(enterPhoneNumberField, phone);
		gu.sendKeys(enterAddressField, address);
		gu.sendKeys(enterUsernameField, userName);
		gu.sendKeys(enterPasswordField, password);
	}

	public String getNewDeliveryBoyName() {
		return gu.getElementText(tableValue);
	}
	public void clickNextButton() {
		gu.clickButton(nextButton);
	}
	public String getActivePageNumber() {
		return gu.getElementText(activePage);
	}

}

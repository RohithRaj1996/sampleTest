package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralaUtilities;

public class ManageUsers {
	public ManageUsers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	WebDriver driver;
	GeneralaUtilities gu = new GeneralaUtilities();
	@FindBy(xpath = "//p[text()='Manage Users']")
	WebElement manageUsers;
	@FindBy(xpath = "(//span[@class='badge bg-success'])[1]")
	WebElement activeButton;
	@FindBy(xpath = "(//i[@class='fa fa-unlock'])[1]")
	WebElement unlock;
	@FindBy(xpath = "(//i[@class='fa fa-lock'])[1]")
	WebElement lock;
	@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-success btncss'])[1]")
	WebElement unlockButton;
	@FindBy(xpath = "(//a[@class='btn btn-sm btn-danger btn-rounded'])[1]")
	WebElement lockButton;
	@FindBy(xpath = "(//span[@class='badge bg-warning'])[1]")
	WebElement inactiveButton;
	@FindBy(xpath = "(//i[@class='fa fa-angle-double-down'])[1]")
	WebElement showDetails;
	@FindBy(xpath = "(//span[text()='admin'])[1]")
	WebElement password;
	
			
	public void clickManageUsers() {
		gu.clickButton(manageUsers);
	}
	public void clickInactive() {
		gu.clickButton(inactiveButton);
	}
	public void clickActiveButton() {
		gu.clickButton(activeButton);
	}

	public String backGroundColorLock() {

		return gu.backgroundColor(lockButton, "background-color");
		
	}
	public String backGroundColorUnlock() {

		return gu.backgroundColor(unlockButton, "background-color");
		
	}
	public String attributeValueOfUnlock() {

		return gu.getAttributeValue(unlock, "class");
	}
	public String attributeValueOfLock() {

		return gu.getAttributeValue(lock, "class");
	
	}
	public void clickShowDetails() {
		gu.clickButton(showDetails);
	}
	public String getPasswordOfUser() {
		return gu.getElementText(password);
	}

}



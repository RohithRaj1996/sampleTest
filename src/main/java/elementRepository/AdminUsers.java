package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralaUtilities;

public class AdminUsers {
	public AdminUsers(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	WebDriver driver;
	GeneralaUtilities gu = new GeneralaUtilities();
	ExplicitWait gw;
	@FindBy(xpath = "//p[text()='Admin Users']")
	WebElement adminUsers;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/user/status?id=962&st=inactive&page_ad=1'])[1]")
	WebElement active;
	@FindBy(xpath = "(//span[@class='badge bg-warning'])[1]")
	WebElement inactive;

	public void clickAdminUsers() {
		gu.clickButton(adminUsers);
	}

	public void clickActiveStatus() {
		gu.clickButton(active);
	}

	public void clickInactiveStatus() {
		gu.clickButton(inactive);
	}

	public String backgroundColorActive() {
		return gu.backgroundColor(active, "background-color");
	}

	public String backgroundColorInactive() {
		return gu.backgroundColor(inactive, "background-color");
	}

}

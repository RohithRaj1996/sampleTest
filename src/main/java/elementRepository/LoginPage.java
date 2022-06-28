package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralaUtilities;

public class LoginPage {

	GeneralaUtilities gu = new GeneralaUtilities();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	WebDriver driver;

	@FindBy(xpath = "//input[@type='text']")
	WebElement userName;
	@FindBy(xpath = "//input[@type='password']")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInButton;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement errorMsg;
	@FindBy(xpath = "//label[@for='remember']")
	WebElement remember;
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement isSelect;
	@FindBy(xpath = "(//a[@class='nav-link'])[2]")
	WebElement accountName;

	public String textOfSigninButton() {
		return gu.getElementText(signInButton);
	}

	public void loginUser(String userName1, String password1) {
		userName.sendKeys(userName1);
		password.sendKeys(password1);
		gu.clickButton(signInButton);
	}

	public void clickRemember() {
		gu.clickButton(remember);

	}

	public String invalidCredentialsErrorMsg() {
		return gu.getElementText(errorMsg);
	}

	public boolean rememberMeCheckbox() {

		return gu.isSlelectedVerifycheckbox(isSelect);

	}

	public String getTextOfAccountName() {
		return gu.getElementText(accountName);
	}

}

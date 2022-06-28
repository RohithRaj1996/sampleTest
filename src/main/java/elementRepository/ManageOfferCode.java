package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralaUtilities;

public class ManageOfferCode {
	public ManageOfferCode(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;
	GeneralaUtilities gu = new GeneralaUtilities();
	@FindBy(xpath = "//p[text()='Manage Offer Code']")
	WebElement manageOfferCode;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//button[@class='note-btn btn btn-light btn-sm note-btn-underline']")
	WebElement underLine;

	public void clickManageOfferCode() {
		gu.clickButton(manageOfferCode);
	}

	public void clickNewButton() {
		gu.clickButton(newButton);
	}

	public String getToolTipValueUnderline() {

		return gu.toolTipValue(underLine, "data-original-title");

	}

}

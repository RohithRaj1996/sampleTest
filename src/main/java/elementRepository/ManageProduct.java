package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralaUtilities;

public class ManageProduct {
	public ManageProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	WebDriver driver;
	GeneralaUtilities gu = new GeneralaUtilities();
	ExplicitWait gw;
	@FindBy(xpath = "//p[text()='Manage Product']")
	WebElement manageProduct;
	@FindBy(xpath = "(//i[@class='fas fa-trash-alt'])[1]")
	WebElement deleteIcon;
	@FindBy(xpath = "//a[@class='active nav-link']")
	WebElement highlight;
	@FindBy(xpath = "(//i[@class='fas fa-edit'])[1]")
	WebElement newButton;
	@FindBy(xpath = "(//input[@type='file'])[2]")
	WebElement uploadImage;
	@FindBy(xpath = "//div[@id='imagePreview']")
	WebElement imageView;
	@FindBy(id = "cat_id")
	WebElement category;
	@FindBy(xpath = "//input[@name='title']")
	WebElement titleField;

	public void clickManageProduct() {
		gu.clickButton(manageProduct);
	}

	public void clickDeleteButton() {
		gu.clickButton(deleteIcon);
	}

	public String getTextofAlertBox() {

		return gu.alertBoxText(driver);

	}

	public void clickOkAlertBox() {

		gu.accepingAlertBox(driver);

	}

	public String highlightAfterClick() {

		return gu.getAttributeValue(highlight, "class");
	}

	public void clickNewButton() {
		gu.clickButton(newButton);
	}

	public boolean isUploadImageWorking() throws InterruptedException, AWTException {
		gw = new ExplicitWait();
		gu.javaScriptExecutorScroll(driver);
		// gw.waitPresenceOfElementLocated(driver, "(//input[@type='file'])[2]");
		gu.generalSleep();
		gu.fileUpload(driver, uploadImage,
				System.getProperty("user.dir") + "\\src\\main\\resources\\UploadFiles\\apple.jfif");
		return gu.isPictureDisplayed(imageView);

	}

	public String selectCategoryFromDropDown() {

		return gu.dropDown(category, 2);
	}

	public String getWaterMarkText() {

		return gu.getAttributeValue(titleField, "placeholder");
	}
}

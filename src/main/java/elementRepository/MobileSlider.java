package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralaUtilities;

public class MobileSlider {
	public MobileSlider(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	WebDriver driver;
	GeneralaUtilities gu = new GeneralaUtilities();
	@FindBy(xpath = "//p[text()='Mobile Slider']")
	WebElement mobileSlider;
	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	WebElement mainTitle;
	@FindBy(xpath = "//li[text()='List Mobile Sliders']")
	WebElement activeTitle;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	WebElement category;
	@FindBy(id = "main_img")
	WebElement imageUpload;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successMsg;
	

	public void clickMobileSlider() {
		gu.clickButton(mobileSlider);
	}
	public void clickMobileSliderNewButton() {
		gu.clickButton(newButton);
	}
	public void selectCategory() {
		gu.dropDown(category, 1);
	}
	public void uploadImage() throws AWTException {
		gu.fileUpload(driver, imageUpload, System.getProperty("user.dir") + "\\src\\main\\resources\\UploadFiles\\apple.jfif");
	}
	public void clickSaveButton() {
		gu.clickButton(saveButton);
	}
	public String GetSuccessMsgText() {
		return gu.getElementText(successMsg);
	}

	public String titleOfMobileSlider() {

		return gu.getTitle(driver);
		
	}

	public String urlOfMobileSlider() {

		return gu.getUrl(driver);
		
	}
	public String getMainTitle() {

		return gu.getElementText(mainTitle);
		
	}
	public String getActiveTitle() {

		return gu.getElementText(activeTitle);
		
	}

}

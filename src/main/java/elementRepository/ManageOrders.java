package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralaUtilities;

public class ManageOrders {
	public ManageOrders(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;
	GeneralaUtilities gu = new GeneralaUtilities();
	@FindBy(xpath = "//p[text()='Manage Orders']")
	WebElement manageOrders;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement search;
	@FindBy(id = "od")
	WebElement useridField;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tr//td[2]")
	WebElement userDetails;
	@FindBy(xpath = "(//a[text()='Change Delivery Date'])[1]")
	WebElement chageDeliveryDate;
	@FindBy(xpath = "(//input[@type='date'])[3]")
	WebElement deliveryDate;
	@FindBy(xpath = "(//button[@name='Update_st'])[2]")
	WebElement update;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successMessage;
	@FindBy(xpath = "//table[@class='jquery-datepicker__table']//tr//td")
	WebElement calendervalues;

	public void clickManageOrders() {
		gu.clickButton(manageOrders);
	}

	public void clickSearchButton() {
		gu.clickButton(search);
	}

	public void clickChangeDeliveryDate() {
		gu.clickButton(chageDeliveryDate);
	}

	public void clickUpdateButton() {
		gu.clickButton(update);
	}

	public void enterUserid(String id) {
		gu.sendKeys(useridField, id);
	}

	public void searchUser() {
		gu.enterKeyPress(driver);
	}

	public String fetchUserDetails() {
		return gu.getElementText(userDetails);
	}

	public String getTableRcordValue(int i) {
		return gu.tableDetails(driver, "//table[@class='table table-bordered table-hover table-sm']//tr[5]//td", i);
	}

	public void addingDate() {
		gu.sendKeys(deliveryDate, "19-05-2022");

	}

	public String checkSuccessMessage() {
		return gu.getElementText(successMessage);

	}

	public List<WebElement> listRecordsTable() {
		return gu.listRecords(driver, "//table[@class='table table-bordered table-hover table-sm']//tbody//tr");
		//return gu.numberOfRecordsInTable(driver,"//table[@class='table table-bordered table-hover table-sm']//tbody//tr");

	}
	
	public int getCountOfRecords() {
		return gu.CountOfRecords(listRecordsTable());

	}
	public String getTodaysDate() {
		return gu.todaysDate();

	}

	public String getDisplayedDate() {
		return gu.checkBackgroundColorOfDates(driver, "//table[@class='jquery-datepicker__table']//tr//td");

	}

}

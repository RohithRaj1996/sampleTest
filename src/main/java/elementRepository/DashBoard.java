package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralaUtilities;

public class DashBoard {
	GeneralaUtilities gu = new GeneralaUtilities();

	public DashBoard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	WebDriver driver;
	@FindBy(xpath = ("(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'])[2]"))
	WebElement Category;
	@FindBy(xpath = ("//h1[@class='m-0 text-dark']"))
	WebElement titleCategory;
	@FindBy(xpath = ("//a[@class='d-block']"))
	WebElement adminLink;
	@FindBy(xpath = ("//a[@class='active nav-link']"))
	WebElement dashboard;
	

	public List<WebElement> listTilesDashBoard() {
		return gu.listRecords(driver, "//div[@class='col-lg-3 col-6']");
	}

	public int getNumberofModulesDashBoard() {
		return gu.CountOfRecords(listTilesDashBoard());
	}

	public void clickCategory() {
		gu.clickButton(Category);
	}
	public void clickAdminLink() {
		gu.clickButton(adminLink);
	}
	public String getTitleCategory() {
		return gu.getElementText(titleCategory);
	}
	public String TextOfactivePage() {
		return gu.getElementText(dashboard);
	}
	

}

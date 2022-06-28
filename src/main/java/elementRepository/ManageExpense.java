package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralaUtilities;

public class ManageExpense {
	public ManageExpense(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	WebDriver driver;
	GeneralaUtilities gu = new GeneralaUtilities();
	@FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column']//li[@class='nav-item has-treeview']//a[@class='nav-link']")
	WebElement manageExpense;
	@FindBy(xpath = "//p[text()='Expense Category']")
	WebElement expenseCategory;
	@FindBy(id = "sidebar-overlay")
	WebElement searchButton;

	public void clickManageExpense() {
		gu.clickButton(manageExpense);
	}

	public void clickExpenseCategory() {
		gu.clickButton(expenseCategory);
	}

	public String backgroundColorSearchButton() {

		return gu.backgroundColor(searchButton, "background-color");
	}

	public String colorExpenseCategoryBeforeMouseHover() {

		return gu.backgroundColor(expenseCategory, "color");
	}

	public String colorExpenseCategoryAfterMouseHover() {
		gu.actionsOperations(expenseCategory, driver);
		return gu.backgroundColor(expenseCategory, "color");
	}

}

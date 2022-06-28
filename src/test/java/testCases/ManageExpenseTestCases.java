package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageExpense;

public class ManageExpenseTestCases extends BaseClass {
	ManageExpense me;
	LoginPage lp;

	@Test(groups = { "critical" })
	public void BackgroundcolorOfSearchButton() {
		lp = new LoginPage(driver);
		lp.loginUser("admin", "admin");
		me = new ManageExpense(driver);
		me.clickManageExpense();
		me.clickExpenseCategory();
		String expBackgroundColor = Constant.expColorSearchButton;
		String actBackgroundColor = me.backgroundColorSearchButton();
		Assert.assertEquals(expBackgroundColor, actBackgroundColor, "Not Matching");
	}

	@Test
	public void VerifyColorBeforeAndAfterMouseHover() {
		lp = new LoginPage(driver);
		lp.loginUser("admin", "admin");
		me = new ManageExpense(driver);
		me.clickManageExpense();
		String before = me.colorExpenseCategoryBeforeMouseHover();
		System.out.println(before);
		String after = me.colorExpenseCategoryAfterMouseHover();
		System.out.println(after);
		Assert.assertFalse(before.equals(after), "color not changed");
	}
}

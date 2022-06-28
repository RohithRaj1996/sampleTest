package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import utilities.ExcelRead;

public class LoginPageTestCases extends BaseClass {
	LoginPage lp;
	ExcelRead er;

	@Test(groups = { "critical" })
	public void verifyLoginButtonText() {
		lp = new LoginPage(driver);
		String expText = Constant.expUserName;
		String actText = lp.textOfSigninButton();
		Assert.assertEquals(actText, expText, "Text not matching");

	}

	@Test
	public void verifyErrorMsg() throws IOException {
		lp = new LoginPage(driver);
		er = new ExcelRead();
		lp.loginUser(er.getStringValueFromExcel(2, 1), er.getStringValueFromExcel(1, 1));
		String expText = Constant.expErrorMsg;
		String actText = lp.invalidCredentialsErrorMsg();
		Assert.assertEquals(actText, expText, "Text not matching");

	}

	@Test(groups = { "critical" })
	public void verifyCheckBox() {
		lp = new LoginPage(driver);
		lp.clickRemember();
		boolean act = lp.rememberMeCheckbox();
		Assert.assertTrue(act);

	}

	@Test
	public void verifyValidLogin() throws IOException {
		lp = new LoginPage(driver);
		er = new ExcelRead();
		lp.loginUser(er.getStringValueFromExcel(0, 1), er.getStringValueFromExcel(1, 1));
		String expAccountName = Constant.expAccountName;
		String actAccountName = lp.getTextOfAccountName();
		Assert.assertEquals(actAccountName, expAccountName, "Not Matching");
	}

}

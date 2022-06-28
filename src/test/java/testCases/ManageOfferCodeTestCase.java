package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageOfferCode;
import utilities.ExcelRead;

public class ManageOfferCodeTestCase extends BaseClass {
	LoginPage lp;
	ExcelRead er;
	ManageOfferCode fc;

	@Test
	public void verifyToolTipValueUnderLine() throws IOException {
		lp = new LoginPage(driver);
		er = new ExcelRead();
		fc = new ManageOfferCode(driver);
		lp.loginUser(er.getStringValueFromExcel(0, 1), er.getStringValueFromExcel(1, 1));
		fc.clickManageOfferCode();
		fc.clickNewButton();
		String expTooltipValue = Constant.expTooltipUnderline;
		String actTooltipValue = fc.getToolTipValueUnderline();
		Assert.assertEquals(actTooltipValue, expTooltipValue, "Not Matching");

	}
}

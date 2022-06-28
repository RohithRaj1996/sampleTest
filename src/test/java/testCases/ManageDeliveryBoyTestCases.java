package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageDeliveryBoy;
import utilities.ExcelRead;

public class ManageDeliveryBoyTestCases extends BaseClass {
	ManageDeliveryBoy md;
	LoginPage lp;
	ExcelRead er;

	@Test
	public void VerifyNewlyEnteredDeliveryBoy() throws IOException {
		md = new ManageDeliveryBoy(driver);
		lp = new LoginPage(driver);
		er = new ExcelRead();
		lp.loginUser(er.getStringValueFromExcel(0, 1), er.getStringValueFromExcel(1, 1));
		md.clickManageDeliveryBoy();
		md.clickNewButton();
		md.enterFields("Tester", "test@gmail.com", "1234567", "abc house\n" + "Mumbai\n" + "India", "newTester123",
				"test123");
		md.clickSaveButton();
		String expName = Constant.expName;
		String actName = md.getNewDeliveryBoyName();
		Assert.assertEquals(actName, expName, "Details of new Delivery boy is not added");

	}
	@Test
	public void VerifyNextPages() throws IOException {
		md = new ManageDeliveryBoy(driver);
		lp = new LoginPage(driver);
		er = new ExcelRead();
		lp.loginUser(er.getStringValueFromExcel(0, 1), er.getStringValueFromExcel(1, 1));
		md.clickManageDeliveryBoy();
		md.clickNextButton();
		String expPageNo=Constant.expPageNumber;
		String actPageNo=md.getActivePageNumber();
		Assert.assertEquals(actPageNo, expPageNo,"Couldn't navigate to the Next Page");
		
	}
}

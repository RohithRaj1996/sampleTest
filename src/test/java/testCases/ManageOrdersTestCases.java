package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageOrders;
import utilities.ExcelRead;

public class ManageOrdersTestCases extends BaseClass {
	ManageOrders mo;
	LoginPage lp;
	ExcelRead er;

	@Test
	public void VerifyUserDetails() {
		mo = new ManageOrders(driver);
		lp = new LoginPage(driver);
		lp.loginUser("admin", "admin");
		mo.clickManageOrders();
		mo.clickSearchButton();
		mo.enterUserid("617");
		mo.searchUser();
		String expDetails = Constant.expUserDetails;
		String actDetails = mo.fetchUserDetails();
		Assert.assertEquals(expDetails, actDetails, "Not matching");
	}

	@Test
	public void VerifyTableRecordValue() {
		mo = new ManageOrders(driver);
		lp = new LoginPage(driver);

		lp.loginUser("admin", "admin");
		mo.clickManageOrders();
		String exp = Constant.expCellValue;
		String act = mo.getTableRcordValue(2);
		Assert.assertEquals(exp, act, "Not matching");
	}

	@Test
	public void verifyChangedDeliveryDate() throws IOException {
		mo = new ManageOrders(driver);
		lp = new LoginPage(driver);
		er = new ExcelRead();
		lp.loginUser(er.getStringValueFromExcel(0, 1), er.getStringValueFromExcel(1, 1));
		mo.clickManageOrders();
		mo.clickChangeDeliveryDate();
		mo.addingDate();
		mo.clickUpdateButton();
		String expSuccessMessage = Constant.expSuccessMessage;
		String actSuccessMessage = mo.checkSuccessMessage();
		Assert.assertEquals(actSuccessMessage, expSuccessMessage, "Not matching");

	}

	@Test
	public void verifyNumberOfRecordsInTable() throws IOException {
		mo = new ManageOrders(driver);
		lp = new LoginPage(driver);
		er = new ExcelRead();
		lp.loginUser(er.getStringValueFromExcel(0, 1), er.getStringValueFromExcel(1, 1));
		mo.clickManageOrders();
		mo.listRecordsTable();
		int expNumber = Constant.expNumberOfRecords;
		int actNumber = mo.getCountOfRecords();
		Assert.assertEquals(actNumber, expNumber, "Not Matching");

	}

	@Test
	public void verifyTodaysDate() throws IOException {
		mo = new ManageOrders(driver);
		lp = new LoginPage(driver);
		er = new ExcelRead();
		lp.loginUser(er.getStringValueFromExcel(0, 1), er.getStringValueFromExcel(1, 1));
		mo.clickManageOrders();
		String expDate = mo.getTodaysDate();
		String actDate = mo.getDisplayedDate();
		Assert.assertEquals(actDate, expDate, "Date is wrong");

	}
}

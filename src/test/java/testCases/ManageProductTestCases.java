package testCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageProduct;

public class ManageProductTestCases extends BaseClass {
	LoginPage lp;
	ManageProduct mp;

	@Test(groups = { "critical" })
	public void VerifyTextOfAlertBox() throws InterruptedException {
		lp = new LoginPage(driver);
		mp = new ManageProduct(driver);
		lp.loginUser("admin", "admin");
		mp.clickManageProduct();
		mp.clickDeleteButton();
		String expAlertText = Constant.expAlertText;
		String actAlertText = mp.getTextofAlertBox();
		mp.clickOkAlertBox();
		Thread.sleep(3000);
		Assert.assertEquals(expAlertText, actAlertText, "Not Matching");

	}

	@Test
	public void VerifyAttributevalueAfterClick() {
		lp = new LoginPage(driver);
		mp = new ManageProduct(driver);
		lp.loginUser("admin", "admin");
		mp.clickManageProduct();
		String expAttriText = Constant.expAttributeValue;
		String actATTriText = mp.highlightAfterClick();
		Assert.assertEquals(expAttriText, actATTriText, "Not Matching");

	}

	@Test
	public void uploadImageTest() throws AWTException, InterruptedException {
		lp = new LoginPage(driver);
		mp = new ManageProduct(driver);
		lp.loginUser("admin", "admin");
		mp.clickManageProduct();
		mp.clickNewButton();
		mp.isUploadImageWorking();
		Assert.assertTrue(mp.isUploadImageWorking(), "image not uploaded");
	}

	@Test(groups = { "critical" })
	public void verifyDropdownCategory() {
		lp = new LoginPage(driver);
		mp = new ManageProduct(driver);
		lp.loginUser("admin", "admin");
		mp.clickManageProduct();
		mp.clickNewButton();
		String expCategory = Constant.expCategoryValue;
		String actCategory = mp.selectCategoryFromDropDown();
		Assert.assertEquals(expCategory, actCategory, "Not Matching");

	}
	@Test(groups = { "critical" })
	public void verifyWaterMarkText() {
		lp = new LoginPage(driver);
		mp = new ManageProduct(driver);
		lp.loginUser("admin", "admin");
		mp.clickManageProduct();
		mp.clickNewButton();
		String expText=Constant.expWaterMarkTitle;
		String actText=mp.getWaterMarkText();
		Assert.assertEquals(actText, expText,"Water Mark Text is not matching");
	}
}

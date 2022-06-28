package testCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.MobileSlider;


public class MobileSliderTestCases extends BaseClass {

	LoginPage lp;
	MobileSlider ms;
	@Test(groups= {"critical"})
	public void VerifyTitleMobileSlider() {
		lp = new LoginPage(driver);
		ms = new MobileSlider(driver);
		lp.loginUser("admin", "admin");
		ms.clickMobileSlider();
		String expTitle = Constant.expTitlePage;
		String actTitle = ms.titleOfMobileSlider();
		Assert.assertEquals(expTitle, actTitle, "Not Matching");

	}

	@Test(groups= {"critical"})
	public void VerifyUrlMobileSlider() {
		lp = new LoginPage(driver);
		ms = new MobileSlider(driver);
		lp.loginUser("admin", "admin");
		ms.clickMobileSlider();
		String expUrl = Constant.expUrlPage;
		String actUrl = ms.urlOfMobileSlider();
		Assert.assertEquals(expUrl, actUrl, "Not Matching");
	}
	@Test
	public void VerifyBothActiveAndMainTitle() {
		lp = new LoginPage(driver);
		ms = new MobileSlider(driver);
		lp.loginUser("admin", "admin");
		ms.clickMobileSlider();
		String active=ms.getActiveTitle();
		String main=ms.getMainTitle();
		Assert.assertEquals(main, active,"Active and main title are different");
	}
	
	@Test
	public void VerifyNewMobileSliderCreateOption() throws AWTException {
		lp = new LoginPage(driver);
		ms = new MobileSlider(driver);
		lp.loginUser("admin", "admin");
		ms.clickMobileSlider();
		ms.clickMobileSliderNewButton();
		ms.selectCategory();
		ms.uploadImage();
		ms.clickSaveButton();
		String actMessage=ms.GetSuccessMsgText().substring(9);
		String expMessage=Constant.expSuccessMessageMobileSlider;
		Assert.assertEquals(actMessage, expMessage,"Success Message not matching");
	}
}

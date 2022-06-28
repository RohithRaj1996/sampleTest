package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.PushNotifications;


public class PushNotificationTestCases extends BaseClass {
	PushNotifications pn;	
	LoginPage lp;
	
  @Test
  public void VerifySuccessMessage() {
	  lp=new LoginPage(driver);
	  lp.loginUser("admin", "admin");
	  pn=new PushNotifications(driver);
	  pn.clickPushNotifications();
	  pn.enterTitle("Apple");
	  pn.enterDescription("Fruits&Vegetables");
	  pn.clickSendButton();
	  String expMessgae=Constant.successMessage;
	  String ActMessage=pn.getTextOfSuccessMessage();
	  Assert.assertEquals(ActMessage, expMessgae,"Didn't send Notification");
  }
}

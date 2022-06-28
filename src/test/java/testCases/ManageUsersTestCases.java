package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageUsers;


public class ManageUsersTestCases extends BaseClass {
	LoginPage lp;
	ManageUsers mu;

	@Test
	public void verifyChageAfterClickingActiveStatus() {
		lp = new LoginPage(driver);
		mu = new ManageUsers(driver);
		lp.loginUser("admin", "admin");
		mu.clickManageUsers();
		String beforeColor=mu.backGroundColorUnlock();
		String beforeAttribute=mu.attributeValueOfUnlock();
		mu.clickActiveButton();
		String afterColor=mu.backGroundColorLock();
		String afterAttribute=mu.attributeValueOfLock();
		Assert.assertFalse(beforeColor.equals(afterColor),"Color not changed automatically");
		Assert.assertFalse(beforeAttribute.equals(afterAttribute),"Didn't change the Lock position");
		mu.clickInactive();
	}
	@Test
	public void verifyPasswordTextOfUser() {
		lp = new LoginPage(driver);
		mu = new ManageUsers(driver);
		lp.loginUser("admin", "admin");
		mu.clickManageUsers();
		mu.clickShowDetails();
		String expPassword=Constant.expPasswordUser;
		String actPassword=mu.getPasswordOfUser();
		Assert.assertEquals(actPassword, expPassword,"Password not matching");
	}
}

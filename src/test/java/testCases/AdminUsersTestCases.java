package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.AdminUsers;
import elementRepository.LoginPage;
import utilities.ExcelRead;

public class AdminUsersTestCases extends BaseClass {
	
	LoginPage lp;
	AdminUsers au;
	ExcelRead er;
  @Test
  public void verifyChangingBackgroundcolor() throws IOException {
	  lp=new LoginPage(driver);
	  au=new AdminUsers(driver);
	  er=new ExcelRead();
	  lp.loginUser(er.getStringValueFromExcel(0, 1), er.getStringValueFromExcel(1, 1));
	  au.clickAdminUsers();
	  String before = au.backgroundColorActive();
	  au.clickActiveStatus();
	  String after=au.backgroundColorInactive();
	  Assert.assertFalse(before.equals(after));
	  au.clickInactiveStatus();
  }
}

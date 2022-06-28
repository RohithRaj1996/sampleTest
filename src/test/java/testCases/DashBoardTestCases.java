package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.DashBoard;
import elementRepository.LoginPage;
import utilities.ExcelRead;

public class DashBoardTestCases extends BaseClass {
	LoginPage lp;
	ExcelRead er;
	DashBoard db;

	@Test
	public void VerifyNumOfTileModulesDashBoard() throws IOException {
		lp = new LoginPage(driver);
		er = new ExcelRead();
		db = new DashBoard(driver);
		lp.loginUser(er.getStringValueFromExcel(0, 1), er.getStringValueFromExcel(1, 1));
		db.listTilesDashBoard();
		int expNumber = Constant.expNumberofTileModules;
		int actNumber = db.getNumberofModulesDashBoard();
		Assert.assertEquals(actNumber, expNumber, "Expected number of Tile modules not present");
	}
	@Test
	public void verifyCategoryPageFromDashBoard() throws IOException { 
		lp = new LoginPage(driver);
		er = new ExcelRead();
		db = new DashBoard(driver);
		lp.loginUser(er.getStringValueFromExcel(0, 1), er.getStringValueFromExcel(1, 1));
		db.clickCategory();
		String expText=Constant.expCategoryTitle;
		String actText=db.getTitleCategory();
		Assert.assertEquals(actText, expText,"Title not matching");
	}
	@Test
	public void VerifyTextOfActivePageCliCkingAdminLink() throws IOException { 
		lp = new LoginPage(driver);
		er = new ExcelRead();
		db = new DashBoard(driver);
		lp.loginUser(er.getStringValueFromExcel(0, 1), er.getStringValueFromExcel(1, 1));
		db.clickAdminLink();
		String actText=db.TextOfactivePage();
		String expText=Constant.expActivePageText;
		Assert.assertEquals(actText, expText,"Text not matching");
	}
}
	

package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;
import com.actitime.generic.WaitStatementLib;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;

public class LoginTest extends BaseLib{
	@Test(priority=2)
	public void loginTest(){
		LoginPage lp=new LoginPage(driver);
		String username = ExcelUtilities.readData("Sheet1", 1, 1);
		String password = ExcelUtilities.readData("Sheet1", 1, 2);
		lp.login(username, password);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		EnterTimeTrackPage ettp=new EnterTimeTrackPage();
		ettp.verifyHPTitle(driver);
		ettp.verifyHPUrl(driver);		
	}
	@Test(priority=1)
	public void invalidLoginTest()
	{
		LoginPage lp=new LoginPage(driver);
		lp.login(ExcelUtilities.readData("sheet1", 2, 1), ExcelUtilities.readData("sheet1", 2, 2));

		WaitStatementLib.implicitWaitForSeconds(driver, 20);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//might get error check codes
		lp.verifyInvalidLoginMsg();
	}

}

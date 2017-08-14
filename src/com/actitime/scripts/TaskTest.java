package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;
import com.actitime.pageobjects.ActiveprojAndCustPage;
import com.actitime.pageobjects.CreateNewCustomerPage;
import com.actitime.pageobjects.LoginPage;
import com.actitime.pageobjects.OpenTasksPage;

public class TaskTest extends BaseLib{
	@Test
	public void createCustomerTest()
	{
		LoginPage lp=new LoginPage(driver);
		lp.login(ExcelUtilities.readData("sheet1", 3, 1),ExcelUtilities.readData("sheet1", 3, 2));

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		OpenTasksPage otp=new OpenTasksPage(driver);
		otp.clickOnTasks();
		otp.clickOnProjAndCustLink();
		ActiveprojAndCustPage ancp=new ActiveprojAndCustPage(driver);
		ancp.clickOnCreateNewCustBtn();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CreateNewCustomerPage cncp= new CreateNewCustomerPage(driver);
		cncp.createNewCustomer(ExcelUtilities.readData("sheet1", 3, 3));
	}
}



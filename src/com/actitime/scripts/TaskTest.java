package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;
import com.actitime.generic.WaitStatementLib;
import com.actitime.pageobjects.ActiveprojAndCustPage;
import com.actitime.pageobjects.CreateNewCustomerPage;
import com.actitime.pageobjects.LoginPage;
import com.actitime.pageobjects.OpenTasksPage;

public class TaskTest extends BaseLib{
	@Test
	public void createCustomerTest()
	{
		//Login page object
		LoginPage lp=new LoginPage(driver);
		lp.login(ExcelUtilities.readData("sheet1", 3, 1),ExcelUtilities.readData("sheet1", 3, 2));

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Open tasks page object
		OpenTasksPage otp=new OpenTasksPage(driver);
		otp.clickOnTasks();
		otp.clickOnProjAndCustLink();
		//Active proj and customer page
		ActiveprojAndCustPage ancp=new ActiveprojAndCustPage(driver);
		ancp.clickOnCreateNewCustBtn();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//create new customer page
		CreateNewCustomerPage cncp= new CreateNewCustomerPage(driver);
		cncp.createNewCustomer(ExcelUtilities.readData("sheet1", 3, 3));
	}
	
	@Test
	public void deleteCustomerTest()
	{
		//Login page object
		LoginPage lp= new LoginPage(driver);
		lp.login(ExcelUtilities.readData("sheet1", 4, 1),ExcelUtilities.readData("sheet1", 4, 2));
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//Open tasks page object
		OpenTasksPage otp = new OpenTasksPage(driver);
		otp.clickOnTasks();
		otp.clickOnProjAndCustLink();
		WaitStatementLib.implicitWaitForMinutes(driver, 20);
		//Active proj and cust page
		ActiveprojAndCustPage apcp=new ActiveprojAndCustPage(driver);
		apcp.showCustomer(ExcelUtilities.readData("sheet1", 4, 3), driver);
		//write Edit cust info page 
		
		//active proj and cust verified delete customer msg  and clicks on logout
		apcp.verifyDeleteCustMsg();
		apcp.clickOnLogoutLink();
		
	}
}



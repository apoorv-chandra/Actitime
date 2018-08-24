package com.actitime.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class ActiveprojAndCustPage extends BasePage{

	@FindBy(css="input[@value='Create New Customer']")
	private WebElement createNewCustBtn;
	@FindBy(className="successMsg")
	private WebElement successMsg;
	@FindBy(name="selectedCustomer")
	private WebElement selcustDropDown;
	@FindBy(xpath="//input[contains(@value,'Show')]")
	private WebElement custShowBtn;

	public ActiveprojAndCustPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	public void clickOnCreateNewCustBtn()
	{
		createNewCustBtn.click();
	}
	public void showCustomer(String customerName, WebDriver driver)
	{
		Select sel=new Select(selcustDropDown);
		sel.deselectByVisibleText(customerName);
		custShowBtn.click();
		driver.findElement(By.xpath("//a[text()='"+customerName+"']")).click();
	}

	public void verifyCreateMsg()
	{
		Assert.assertTrue(successMsg.isDisplayed(), "create customer msg not displayed");
		Reporter.log(successMsg.getText(),true);
	}

	public void verifyDeleteCustMsg()
	{
		String expMsg = "Customer has been successfully deleted";
		String actMsg=successMsg.getText();
		Assert.assertEquals(actMsg, expMsg, "Delete cust msg not verified");
		Reporter.log("Delete Cust msg is verified", true);
	}
}

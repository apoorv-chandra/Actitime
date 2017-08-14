package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class ActiveprojAndCustPage extends BasePage{

	@FindBy(css="input[@value='Create New Customer']")
	private WebElement createNewCustBtn;
	@FindBy(className="successMsg")
	private WebElement successMsg;

	public ActiveprojAndCustPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	public void clickOnCreateNewCustBtn()
	{
		createNewCustBtn.click();
	}
	public void verifyCreateMsg()
	{
		Assert.assertTrue(successMsg.isDisplayed(), "create customer msg not displayed");
		Reporter.log(successMsg.getText(),true);
	}
}

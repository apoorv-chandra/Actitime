package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenTasksPage extends BasePage{
	@FindBy(linkText="Projects & Customers")
	private WebElement projectAndCustomerLink;

	public OpenTasksPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	public void clickOnProjAndCustLink()
	{
		projectAndCustomerLink.click();
	}

}

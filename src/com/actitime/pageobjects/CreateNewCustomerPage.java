package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCustomerPage {
	@FindBy(name="name")
	private WebElement custNameTxtBx;
	@FindBy(name="createCustomerSubmit")
	private WebElement createCutomerSubmitBtn;

	public CreateNewCustomerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void createNewCustomer(String customerName)
	{
		custNameTxtBx.sendKeys(customerName);
		createCutomerSubmitBtn.click();
	}
}


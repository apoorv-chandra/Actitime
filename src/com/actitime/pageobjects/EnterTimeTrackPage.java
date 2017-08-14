package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class EnterTimeTrackPage {
	public void verifyHPTitle(WebDriver driver){
		String actTitle = driver.getTitle();
		String expTitle="actiTIME - Enter Time-Track";
		Assert.assertEquals(actTitle, expTitle,
				"Home page title is not verified");
		Reporter.log("Home page title is verified", true);
	}
	public void verifyHPUrl(WebDriver driver){
		String actUrl = driver.getCurrentUrl();
		String expUrl="http://desktop-07c3hrb:1500/user/submit_tt.do";
		Assert.assertEquals(actUrl, expUrl,
				"Home page turl is not verified");
		Reporter.log("Home page url is verified", true);
	}
}

package com.actitime.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseLib {
	public WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public void preCondition(String browserName){
		if (browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			Reporter.log("Firefox launched", true);
		}
		else if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", 
					".\\exefiles\\chromedriver.exe");
			driver=new ChromeDriver();
			Reporter.log("chrome launched", true);
		}
		else if(browserName.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", 
					".\\exefiles\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			Reporter.log("IE launched", true);
		}
		driver.manage().window().maximize();
		driver.get(GetPropertyValues.getPropertyValue
				(".\\config.properties", "testURL"));
		Reporter.log("Navigating to test url", true);
	}
	@AfterMethod
	public void postCondition(ITestResult result){
		if (result.isSuccess()) {
			Reporter.log("Script passed", true);
		}
		else{
			String fileName = result.getMethod().getMethodName();
			ScreenshotLib sLib=new ScreenshotLib();
			sLib.getScreenshot(driver, fileName);
			Reporter.log("Screenshot is taken", true);
		}
		driver.close();
		Reporter.log("Browser closed", true);
	}
}








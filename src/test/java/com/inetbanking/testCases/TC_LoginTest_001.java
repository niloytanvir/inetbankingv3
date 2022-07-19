package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	

	@Test
	public void loginTest() throws IOException
	{
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");

		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		ExtentTest test1 = extent.createTest("Login test 001","Log into the website");
		test1 .log(Status.INFO, "Starting the test");
		driver.get(baseURL);
		test1.pass("Url is opened");
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		test1.pass("Entered Username");
		logger.info("Entered Username");
		
		
		lp.setPassword(password);
		test1.pass("Entered password");
		logger.info("Entered password");
		
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			test1.info("login test passed");
			logger.info("Login test passed");
			
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			test1.info("test failed");
			logger.info("Login test failed");
		}
		
		extent.flush();
	}

}

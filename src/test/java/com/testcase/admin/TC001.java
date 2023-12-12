package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class TC001 extends AdminSuit{
	
	public void verifyReviewBord() throws InterruptedException {
		log.info("1) Testing Review Bord Page");
		
		//ExtentTestManager.startTest("Verify Review Bord Page is Displayed");
		WaitForPageLoad();
		home.clickReviewBord();
		String url = driver.getCurrentUrl();
		assertEquals(url, "https://s3po-demo.speridian.com/oratordemoadmin/reviewBoar");
		
	}
}

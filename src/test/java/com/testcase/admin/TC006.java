package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC006 extends AdminSuit{
	
	@Test(priority=6)
	public void searchCreatedUser() throws InterruptedException {
		log.info("6) Verify Search Works");
		ExtentTestManager.startTest("6) Verify Search Works");
		home.clickUserManagement();
		WaitForElementToBeVisible(home.L_newuser);
		WaitForElementToBeVisible(userManage.L_search);
		userManage.enterSearch("Ramesh");
		WaitForElementToBeVisible(userManage.L_clicksearch);
		userManage.clickSearch();
		Thread.sleep(2000);
		assertEquals(userManage.getCellData(), "Ramesh");
	}
	
}

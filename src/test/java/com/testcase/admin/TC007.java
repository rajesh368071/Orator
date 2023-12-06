package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC007 extends AdminSuit {
	
	@Test(priority = 7)
	public void changeStatus() throws InterruptedException {
		log.info("7) Verify Status can able to change");
		ExtentTestManager.startTest("7) Verify Status can able to change");
		home.clickUserManagement();
		WaitForElementToBeVisible(home.L_newuser);
		userManage.enterSearch("Ramesh");
		WaitForElementToBeVisible(userManage.L_clicksearch);
		userManage.clickSearch();
		Thread.sleep(2000);
		userManage.clickStatus();
		userManage.clickAccept();
		if(isChecked(userManage.L_cell_status)) {
			Thread.sleep(3000);
			WaitForElementToBeVisible(home.L_newuser);
			userManage.enterSearch("Ramesh");
			WaitForElementToBeVisible(userManage.L_clicksearch);
			userManage.clickSearch();
			Thread.sleep(3000);
			assertEquals(isChecked(userManage.L_cell_status), true);
		} else {
			Thread.sleep(3000);
			WaitForElementToBeVisible(home.L_newuser);
			userManage.enterSearch("Ramesh");
			WaitForElementToBeVisible(userManage.L_clicksearch);
			userManage.clickSearch();
			Thread.sleep(3000);
			assertEquals(isChecked(userManage.L_cell_status), false);
		}
	}
	
}

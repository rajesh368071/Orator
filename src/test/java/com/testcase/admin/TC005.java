package com.testcase.admin;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC005 extends AdminSuit {
	
	@Test
	public void createNewUser() throws InterruptedException {
		log.info("5) Verify New User is Created");
		ExtentTestManager.startTest("Verify New User is Created");
		home.clickUserManagement();
		WaitForElementToBeVisible(home.L_newuser);
		userManage.clickNewUser();
		userManage.enterFirstname(fakedata.getFirstName());
		userManage.enterlastName(fakedata.getLastname());
		userManage.enterEmail(fakedata.getEmail());
		userManage.selectRole();
		userManage.enterPhone(fakedata.getPhone());
		userManage.selectGroup();
		userManage.selectBusinessHour();
		userManage.selectHolidayGroup();
		//userManage.clickSubmit();
		userManage.clickCancel();
	}
	
}

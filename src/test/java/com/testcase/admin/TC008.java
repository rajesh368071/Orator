package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC008 extends AdminSuit{
	
	public void common() throws AWTException, IOException, InterruptedException {
		openNewTab();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> alltabs = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<String>(alltabs);
		
		
		driver.switchTo().window(tabs.get(1));
		
		
		driver.get(configloader().getProperty("Admin_URL"));
		
		login.enterUsername("rameshc@yopmail.com");
		login.enterPassword("6Y%JDWMC");
		login.enterCaptcha();
		login.clickSignin();
		
		Thread.sleep(2000);
		assertEquals(driver.getCurrentUrl(), "https://s3po-demo.speridian.com/oratordemoadmin/auth/login");
		
		driver.close();
		
		driver.switchTo().window(parent);
		
	}
	
	public void checkInactiveUserLogin() throws AWTException, IOException, InterruptedException {
		log.info("8) Verify inActive user is able to login to Application");
		//ExtentTestManager.startTest("8) Verify inActive user is able to login to Application");
		home.clickUserManagement();
		WaitForElementToBeVisible(home.L_newuser);
		userManage.enterSearch("Ramesh");
		WaitForElementToBeVisible(userManage.L_clicksearch);
		userManage.clickSearch();
		
		/*userManage.enterSearch("Ramesh");
		WaitForElementToBeVisible(userManage.L_clicksearch);
		userManage.clickSearch();*/
		
		Thread.sleep(2000);
		if(isChecked(userManage.L_cell_status)) {
			userManage.clickStatus();
			userManage.clickAccept();
			common();
		}
		else {
			common();
			
		}
		
	}
	
}

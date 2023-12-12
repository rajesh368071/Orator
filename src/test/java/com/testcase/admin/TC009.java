package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;
 
public class TC009 extends AdminSuit {
	
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
		
		By msgXpath = By.xpath("//div[@role='alertdialog']");
		WaitForElementToBeVisible(msgXpath);
		String message = driver.findElement(msgXpath).getText();
		
		
		Thread.sleep(2000);
		System.out.println(message);
		
		if(message.equals("The user has been disabled.. Please contact admin,.")) {
			assertEquals(message, "The user has been disabled.. Please contact admin,.");
		}else {
			ExtentErrorMessage("Message is not displayed as expected"+ message);
		}
		
		
		driver.close();
		
		driver.switchTo().window(parent);
		
	}
	
	public void checkInactiveUserLogin() throws AWTException, IOException, InterruptedException {
		log.info("9) Verify Proper Error Message Shows to User for in active user login");
		//ExtentTestManager.startTest("9) Verify Proper Error Message Shows to User for in active user login");
		WaitForPageLoad();
		home.clickUserManagement();
		WaitForElementToBeVisible(home.L_newuser);
		userManage.enterSearch("Ramesh");
		WaitForElementToBeVisible(userManage.L_clicksearch);
		userManage.clickSearch();
		
		userManage.enterSearch("Ramesh");
		WaitForElementToBeVisible(userManage.L_clicksearch);
		userManage.clickSearch();
		
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

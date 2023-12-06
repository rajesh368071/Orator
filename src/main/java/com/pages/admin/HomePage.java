package com.pages.admin;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class HomePage extends Base_Class{
	
	public By L_reviewbord = By.xpath("//span[contains(.,'Review Board')]");
	public By L_usermanagement = By.xpath("//span[contains(.,'User Management')]");
	public By L_settings = By.xpath("//span[contains(.,'Settings')]");
	public By L_chat = By.xpath("//div[@class='mat-list-item-content']/span[contains(., 'Chat')]");
	public By L_newuser = By.xpath("//span[text()='New User']");
	
	public void clickReviewBord() throws InterruptedException {
		try {
			click(L_reviewbord);
			ExtentTestManager.getTest().log(Status.PASS, "Review Bord Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Review Bord Button not Clicked");
		}
		
	}
	
	public void clickUserManagement() throws InterruptedException {
		try {
			click(L_usermanagement);
			ExtentTestManager.getTest().log(Status.PASS, "User Management Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "User Management Button not Clicked");
		}
	}
	
	public void clickSettings() throws InterruptedException {
		try {
			click(L_settings);
			ExtentTestManager.getTest().log(Status.PASS, "Settings Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Setting Button not Clicked");
		}
	}

}

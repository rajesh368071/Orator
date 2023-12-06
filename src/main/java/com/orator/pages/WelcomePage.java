package com.orator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class WelcomePage extends Base_Class{
	
	public By L_username = By.xpath("//div[@class='user__name']");
	public By L_profile = By.xpath("//button[normalize-space()='Profile']");
	public By L_changepassword = By.xpath("//button[normalize-space()='Change Password']");
	public By L_isavailable = By.xpath("//input[@id='mat-slide-toggle-1-input']");
	public By L_availabletoggle = By.xpath("//input[@id='mat-slide-toggle-1-input']/..");
	

	public void clickUsername() throws InterruptedException {
		try {
			driver.findElement(L_username).click();
			ExtentTestManager.getTest().log(Status.PASS, "Username Dropdown Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Username Dropdown Not Clicked");
		}
	}
	
	public void clickProfile( ) throws InterruptedException {
		try {
			jsClick(L_profile);
			ExtentTestManager.getTest().log(Status.PASS, "Successfully Clicked Profile Option");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Not Clicked Profile Option");
		}
	}
	
	public void clickChangePassword() {
		
		try {
			jsClick(L_changepassword);
			ExtentTestManager.getTest().log(Status.PASS, "Successfully Clicked CHange Password Option");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Not Clicked CHange Password Option");
		}
		
	}
	
	public boolean clickAvailable() {
		
		try {
			jsClick(L_availabletoggle);
			ExtentTestManager.getTest().log(Status.PASS, "Successfully CLicked Available toggle Option");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Not CLicked Available toggle Option");
		}
		if(driver.findElement(L_isavailable).isSelected()) {
			return true;
		}
		return false;
	}
}

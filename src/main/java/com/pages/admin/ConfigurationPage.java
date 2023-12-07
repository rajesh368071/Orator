package com.pages.admin;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class ConfigurationPage extends Base_Class {
	
	//identifier
	public By L_chat = By.xpath("//span[.='Chat']");
	public By L_configuration_option = By.xpath("(//span[.='Configuration'])[2]");
	public By L_configuration_title = By.xpath("(//div[.=' Configuration '])[1]");
	
	public void clickConfiguration( ) throws InterruptedException {
		try {
			click(L_configuration_option);
			ExtentTestManager.getTest().log(Status.PASS, "Configuration Successfully Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Configuration Button Not Clicked");
		}
		
	}
	
	public By L_emoji_enable = By.xpath("(//td[contains(text(), 'Emoji')]/..//td)[2]");
	public void clickEmojiEnable() throws InterruptedException {
		try {
			click(L_emoji_enable);
			ExtentTestManager.getTest().log(Status.PASS, "Emoji toggle Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Emoji toggle Not Clicked");
		}
		
	}
	
	public By L_emoji_update = By.xpath("(//td[contains(text(), 'Emoji')]/..//td)[3]/div");
	public void clickEmojiUpdate() throws InterruptedException {
		try {
			click(L_emoji_update);
			ExtentTestManager.getTest().log(Status.PASS, "Emoji Update Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Emoji Update Not Clicked");
		}
	}

}

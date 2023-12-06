package com.pages.admin;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class ChatFeedbackPage extends Base_Class {
	
	//identifier
	public By L_page_title = By.xpath("//div[@class='mat-tooltip-trigger widget__head box__margin-top']");
	public By L_chatfeedback_option = By.xpath("//span[.='Chat Feedback']");
	
	public void clickChatFeedback( ) throws InterruptedException {
		try {
			click(L_chatfeedback_option);
			ExtentTestManager.getTest().log(Status.PASS, "Chat Feedback Successfully Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Chat Feedback Button Not Clicked");
		}
		
	}

}

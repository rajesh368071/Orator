package com.pages.agent;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class AgentReviewBordPage extends Base_Class{
	
	public By L_CXMetrics = By.xpath("//span[.='CX Metrics']");
	public By L_chatAnalist = By.xpath("//span[.='Chat Analytics']");
	
	//Identifier
	public By L_chatResolutionTime = By.xpath("//span[.='Avg. Chat Resolution Time']");
	public By L_CSATscore = By.xpath("//span[.='CSAT Score']");
	public By L_feedbackreview = By.xpath("//div[.='Feedback Recieved']/following-sibling::div//span");
	
	public void clickChatAnalist() {
		try {
			click(L_chatAnalist);
			ExtentTestManager.getTest().log(Status.PASS, "Chat Analystics Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Chat Analystics Button not Clicked");
		}
	}
	
	public void clickCXMatrics() {
		try {
			click(L_CXMetrics);
			ExtentTestManager.getTest().log(Status.PASS, "CX Metrics Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "CX Metrics Button not Clicked");
		}
	}
	
}

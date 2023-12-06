package com.pages.admin;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class QuickReplyPage extends Base_Class{
	
	public By L_quickreply = By.xpath("//span[.='Quick Replies']");
	public By L_newQucikReply = By.xpath("//span[contains(.,'New Quick Reply')]");
	public By L_cancel = By.xpath("//div[contains(@class,'btn btn__decline')]");
	public By L_modelBox = By.xpath("//mat-dialog-container");
	public By L_quickReplyField = By.xpath("//input[@data-placeholder='Quick Reply']");
	public By L_shortNameField = By.xpath("//input[@placeholder='eg : #short']");
	public By L_submit = By.xpath("//div[contains(text(),'Submit')]");
	public By L_alert = By.xpath("//div[contains(text(),'Quick Reply Created')]");

	
	
	public By L_popupcreate = By.xpath("//div[@role='alertdialog' or .='Quick Reply Created']");
	public By L_popupupdate = By.xpath("//div[@role='alertdialog' or .='Quick Reply Updated']");
	
	
	public void clickQuickReplies() {
		try {
			click(L_quickreply);
			ExtentTestManager.getTest().log(Status.PASS, "Quick Reply Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Quick Reply Button not Clicked");
		}
	}
	
	public void clickNewQuickReplies() {
		try {
			click(L_newQucikReply);
			ExtentTestManager.getTest().log(Status.PASS, "New Quick Reply Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "New Quick Reply Button not Clicked");
		}
	}
	
	public void clickCancelBtn() {
		try {
			click(L_cancel);
			ExtentTestManager.getTest().log(Status.PASS, "Cancel Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Cancel Button not Clicked");
		}
	}

	
	public void enterQuickReply(String quickreply) throws InterruptedException {
		input(L_quickReplyField, quickreply);
	}
	
	public void enterShortCut(int words) throws InterruptedException {
		for(int count=0; count < words; count++) {
			String value = "#"+gandomWordGenerate();
			input(L_shortNameField, value);
			input(L_shortNameField, ",");
			Thread.sleep(2000);
		}
		
	}
	
	public void clickSubmit() throws InterruptedException {
		try {
			click(L_submit);
			ExtentTestManager.getTest().log(Status.PASS, "Submit Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Submit Button not Clicked");
		}
	}
	
	public By L_edit = By.xpath("(//i[.='edit'])[1]");
	public void clickEdit() throws InterruptedException {
		try {
			click(L_edit);
			ExtentTestManager.getTest().log(Status.PASS, "Edit Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Edit Button not Clicked");
		}
	}
	
}

package com.pages.agent;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class SupervisorPage extends Base_Class{
	
	//identifier
	public By L_username = By.xpath("//div[@class='chat__topBox box__padding-normal']//div[@class='chat__userName']");

	public By LS_chat_open = By.xpath("//div[@class='escalated__wrapper ng-star-inserted']//mat-icon[.='select_all']");
	public void clickOpenIcon() {
		try {
			click(LS_chat_open);
			ExtentTestManager.getTest().log(Status.PASS, "Open Icon clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Open Icon not clicked");
		}
	}
	
	public By L_toTransferAgent = By.xpath("//div[contains(@class,'group__wrapper') and .='rajesh ganeshagent']");
	public void clickTransferChatTo() {
		try {
			click(L_toTransferAgent);
			ExtentTestManager.getTest().log(Status.PASS, "Clicked on Specific Agent");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Not Clicked on Specific Agent");
		}
	}
	
	public By L_3all = By.xpath("(//div[@class='mat-tab-labels']//mat-icon[.='keyboard_arrow_down'])[last()]");
	public void click3All() {
		try {
			click(L_3all);
			ExtentTestManager.getTest().log(Status.PASS, "clicked all tab successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Not Clicked all tab");
		}
	}
	
	public By L_inprogress = By.xpath("//div[@id='mat-menu-panel-3']//button[.='Inprogress']");
	public void clickInprogress() {
		try {
			click(L_inprogress);
			ExtentTestManager.getTest().log(Status.PASS, "clicked inprogress successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Not Clicked on in progress");
		}
	}
	
	public By L_closed_chat = By.xpath("//div[@id='mat-menu-panel-3']//button[.='Closed']");
	public void clickClosedChat() {
		try {
			click(L_closed_chat);
			ExtentTestManager.getTest().log(Status.PASS, "clicked Closed successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Not Clicked Closed Button");
		}
	}
	
	public void clickInProgressChat(String name) {
		try {
			String ppath = "//div[contains(text(),normalize-space('"+name+"'))]/../../../..//mat-icon";
			Log.info(ppath);
			WaitForElementToBeVisible(By.xpath(ppath));
			click(By.xpath(ppath));
			ExtentTestManager.getTest().log(Status.PASS, "clicked inprogress successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Not Clicked on in progress");
		}
		
	}
	
	
	public By L_breakin = By.xpath("//span[.='Break In']");
	public void clickBreakIn() {
		try {
			click(L_breakin);
			ExtentTestManager.getTest().log(Status.PASS, "clicked Break In successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Not Clicked on Break In");
		}
	}
	
	
	
}

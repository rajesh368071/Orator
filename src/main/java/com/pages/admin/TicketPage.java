package com.pages.admin;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class TicketPage extends Base_Class {
	
	public By L_general = By.xpath("//span[.='General']");
	public By L_ticket = By.xpath("//span[.='Tickets']");
	
	//identifiers
	public By L_ticket_title = By.xpath("(//div[.=' Tickets'])[3]");
	
	
	public void clickGeneral() {
		try {
			click(L_general);
			ExtentTestManager.getTest().log(Status.PASS, "General Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "General Button not Clicked");
		}
	}
	
	
	public void clickTicket() {
		try {
			click(L_ticket);
			ExtentTestManager.getTest().log(Status.PASS, "Ticket Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Ticket Button not Clicked");
		}
	}
	
	
	

}

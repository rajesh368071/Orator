package com.testcase.agent;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC015 extends AgentSuit {
	
	
	public void verifychatrequest() throws InterruptedException, AWTException, IOException {
		log.info("Verify Chat Request Transfred to other Agent");
		
		//ExtentTestManager.startTest("(15) Verify Chat Request Transfred to Other Agent");
		routedchat.clickRoutedChat();
		
		openNewTab();
		Thread.sleep(1000);
		String parent = driver.getWindowHandle();
		SwitchtoTab(1);
		driver.get(configloader().getProperty("EndUser_URL"));
		chatbed.clickChatButton();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		chatbed.clickChatwithus();
		String name = fakedata.getFirstName();
		chatbed.enterFirstName(name);
		chatbed.enterEmail(fakedata.getEmail());
		chatbed.clickSubmit();
		Thread.sleep(5000);
		driver.switchTo().window(parent);
		
		refreshBrowser();
		routedchat.clickandenterSearch(name);
		Thread.sleep(3000);
		
		WebElement draggable = driver.findElement(routedchat.L_usernamecontact);
		draggable.click();
		routedchat.clickandenterSearchMyChat(name);
		routedchat.clickOpenChatArrow();
		
		//login as another agent
		openNewTab();
		SwitchtoTab(2);
		driver.get(configloader().getProperty("Admin_URL"));
		login.enterUsername(configloader().getProperty("AgentUN1"));
		login.enterPassword(configloader().getProperty("AgentPWD1"));
		login.enterCaptcha();
		login.clickSignin();
		
		
		//chat Transfring from agent 1 to 2
		driver.switchTo().window(parent);
		Thread.sleep(3000);
		routedchat.clickTransferChat();
		routedchat.clickTransferChatTo();
		
		
		//checking transfred chat in received to 2 agent
		SwitchtoTab(2);
		routedchat.clickandenterSearchMyChat(name);
		Thread.sleep(2000);
		String contact = driver.findElement(routedchat.L_usernamecontactmychat).getText();
		
		if(name.equals(contact)) {
        	assertEquals(contact, name);
        	log.info(contact+" "+ name);
			ExtentSuccessMessage("Chat Transfred");
        }
		
	}

}

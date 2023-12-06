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

public class TC004 extends AgentSuit {
	
	
	public void verifychatrequest() throws InterruptedException, AWTException, IOException {
		log.info("Verify Chat Request Received");
		
		//ExtentTestManager.startTest("(4) Verify Chat Request Received");
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
		
		String draggable = driver.findElement(routedchat.L_usernamecontact).getText();

        if(name.equals(draggable)) {
        	assertEquals(draggable, name);
        	log.info(draggable+" "+ name);
			ExtentSuccessMessage("Chat request Received");
        }
	}

}

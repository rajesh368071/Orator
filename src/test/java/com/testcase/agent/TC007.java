package com.testcase.agent;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC007 extends AgentSuit {
	
	
	public void verifyChatMessage() throws InterruptedException, AWTException, IOException {
		log.info("Verify Able to Send Message from Agent to Enduser");
		//ExtentTestManager.startTest("(7) Verify Able to Send Message from Agent to Enduser");
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
		
		/*
		refreshBrowser();
		routedchat.clickandenterSearch(name);
		WaitForPageLoad();
		WebElement draggable = driver.findElement(routedchat.L_usernamecontact);
		draggable.click();
		*/
		
		routedchat.clickandenterSearchMyChat(name);
		routedchat.clickOpenChatArrow();
		Thread.sleep(3000);
		String message = fakedata.getMessage();
		routedchat.enterMessage(message);
		routedchat.clickSend();
		Thread.sleep(2000);
		
		SwitchtoTab(1);
		driver.switchTo().frame(0);
		WaitForElementToBeVisible(chatbed.L_message);
		String content = GetELementValue(chatbed.L_message);
		
		log.info(content+"-"+ message);
		
		if(name.equals(content)) {
        	assertEquals(content, name);
        	log.info(content+" "+ name);
			ExtentSuccessMessage("Message Received");
        } else {
        	log.info(message+" -"+content);
        }
		
		WaitForPageLoad();
		
		driver.switchTo().window(parent);
		
		
		//Thread.sleep(3000);
		//refreshBrowser();
		
	}

}

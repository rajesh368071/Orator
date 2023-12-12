package com.testcase.agent;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC025 extends AgentSuit {
	

	public void verifyChatBoxOpen() throws InterruptedException, AWTException, IOException {
		log.info("Verify Closed Chat Displayed");
		//ExtentTestManager.startTest("(25) Verify Closed Chat Displayed");
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
		
		/*refreshBrowser();
		routedchat.clickandenterSearch(name);
		WaitForPageLoad();
		
		WebElement draggable = driver.findElement(routedchat.L_usernamecontact);
		draggable.click();*/
		
		routedchat.clickQuickAction(name);
		routedchat.clickandenterSearchMyChat(name);
		routedchat.clickOpenChatArrow();
		Thread.sleep(3000);
		String message = fakedata.getMessage();
		routedchat.enterMessage(message);
		routedchat.clickSend();
		Thread.sleep(2000);
		
		routedchat.clickClose();
		routedchat.selectCategory();
		routedchat.selectSubCategory();
		routedchat.enterComment("Closing Chat");
		routedchat.clickSubmit();
		
		openNewTab();
		Thread.sleep(1000);
		SwitchtoTab(2);
		driver.get(configloader().getProperty("Admin_URL"));
		login.enterUsername(configloader().getProperty("SupervisorUN1"));
		login.enterPassword(configloader().getProperty("SupervisorPWD"));
		login.enterCaptcha();
		login.clickSignin();
		Thread.sleep(5000);
		WaitForElementToBeVisible(L_usernamedropdown);
		
		supervisor.click3All();
		supervisor.clickClosedChat();
		supervisor.clickInProgressChat(name);
		
		Thread.sleep(3000);
		
		String username = GetELementValue(supervisor.L_username);
		
		if(username.equals(name)) {
        	assertEquals(username, name);
        	log.info(username+"-"+name);
			ExtentSuccessMessage("Closed Chat Displayed");
        }else {
        	assertEquals(username, name);
        	log.info(username+"-"+name);
        	ExtentErrorMessage("Closed Chat Not Displayed");
        }
		
		Thread.sleep(4000);
		driver.switchTo().window(parent);
		
		
	}
	
}

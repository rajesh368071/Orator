package com.testcase.agent;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC021 extends AgentSuit {
	
	
	public void verifyChatBoxOpen() throws InterruptedException, AWTException, IOException {
		log.info("Verify Supervisor Able to Send message to Enduser");
		//ExtentTestManager.startTest("(21) Verify Supervisor Able to Send message to Enduser");
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
		WaitForPageLoad();
		
		WebElement draggable = driver.findElement(routedchat.L_usernamecontact);
		draggable.click();
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
		
		openNewTab();
		Thread.sleep(1000);
		SwitchtoTab(2);
		driver.get(configloader().getProperty("Admin_URL"));
		login.enterUsername(configloader().getProperty("SupervisorUN1"));
		login.enterPassword(configloader().getProperty("SupervisorPWD"));
		login.enterCaptcha();
		login.clickSignin();
		
		driver.switchTo().window(parent);
		routedchat.clickEscalate();
		routedchat.selectEscalateChooseSupervisor("nuon arunmeanith");
		routedchat.selectEscalateCategory("General");
		routedchat.selectEscalateSubCategory("Category 1");
		WaitForElementToBeVisible(routedchat.L_escalate_comment);
		routedchat.enterComment(message);
		routedchat.clickSubmit();
		
		SwitchtoTab(2);
		Thread.sleep(2000);
		
		
		supervisor.clickOpenIcon();
		Thread.sleep(2000);
		String superuser_message = fakedata.getMessage();
		routedchat.enterMessage(superuser_message);
		routedchat.clickSend();
		
		SwitchtoTab(1);
		driver.switchTo().frame(0);
		ScrollUntilElementVisible(chatbed.L_message);
		WaitForElementToBeVisible(chatbed.L_message);
		Thread.sleep(2000);
		String content = GetELementValue(chatbed.L_message);
		
		//log.info(content+"-"+ superuser_message);
		if(true) {
        	assertEquals(content, superuser_message);
        	log.info(content+" "+ superuser_message);
			ExtentSuccessMessage("Message Received");
		}
		WaitForPageLoad();
		
	
		
		Thread.sleep(1000);
		driver.switchTo().window(parent);
		
		
		
		
		
	}
	
}

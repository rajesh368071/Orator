package com.testcase.agent;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC024 extends AgentSuit {
	

	public void verifyChatBoxOpen() throws InterruptedException, AWTException, IOException {
		log.info("Verify able to Break In Chat");
	//	ExtentTestManager.startTest("(24) Verify able to Break In Chat");
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
		
		/*SwitchtoTab(1);
		driver.switchTo().frame(0);
		WaitForElementToBeVisible(chatbed.L_message);*/
		
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
		supervisor.clickInprogress();
		Thread.sleep(2000);
		supervisor.clickInProgressChat(name);
		supervisor.clickBreakIn();
		
		routedchat.enterMessage("Hi I am Supervisor");
		routedchat.clickSend();
		
		boolean isDisplayed = ElementDisplayed(routedchat.L_box_chat_input);
		
		if(isDisplayed) {
        	assertEquals(isDisplayed, true);
        	log.info(isDisplayed+"-"+true);
			ExtentSuccessMessage("Brake In done Successfully");
        }else {
        	log.info(isDisplayed+"-"+true);
        	ExtentErrorMessage("Brake In Not done Successfully");
        }
		
		Thread.sleep(4000);
		driver.switchTo().window(parent);
		
		
	}
	
}

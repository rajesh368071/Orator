package com.testcase.agent;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC008 extends AgentSuit {
	

	public void verifyChatBoxOpen() throws InterruptedException, AWTException, IOException {
		log.info("Verify able to Close the Chat");
		//ExtentTestManager.startTest("(8) Verify able to Close the Chat");
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
		
		driver.switchTo().window(parent);
		routedchat.clickClose();
		routedchat.selectCategory();
		routedchat.selectSubCategory();
		routedchat.enterComment("Chat Closed");
		routedchat.clickSubmit();
		
		boolean isPopUpDisplayed = ElementDisplayed(routedchat.L_popup);
		
		if(true) {
        	assertEquals(isPopUpDisplayed, true);
			ExtentSuccessMessage("Chat Closed Successfully");
        }
		
		
		Thread.sleep(3000);
		//refreshBrowser();
		
	}
	
}

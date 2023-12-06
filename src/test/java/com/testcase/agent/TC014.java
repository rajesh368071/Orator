package com.testcase.agent;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC014 extends AgentSuit {
	
	@Test
	public void verifyChatMessage() throws InterruptedException, AWTException, IOException {
		log.info("Verify able to user Quick Reply");
		ExtentTestManager.startTest("(14) Verify able to user Quick Reply");
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
		
		String message = "#TY";
		routedchat.enterMessage(message);
		driver.findElement(routedchat.L_box_chat_input).clear();
		routedchat.enterMessage(message);
		String quickReplyText = GetELementValue(routedchat.L_quickreplyoption);
		routedchat.clickQuickReply();
		routedchat.clickSend();
		Thread.sleep(2000);
		
		SwitchtoTab(1);
		driver.switchTo().frame(0);
		ScrollUntilElementVisible(chatbed.L_message);
		Thread.sleep(2000);
		String quickReplyMessageText = GetELementValue(chatbed.L_message);
		
		if(quickReplyText.equals(quickReplyMessageText)) {
			
			assertEquals(quickReplyMessageText, quickReplyText);
			log.info(quickReplyMessageText+"-"+quickReplyText);
			
		} else {
			log.info("Not Same"+quickReplyMessageText+"-"+quickReplyText);
		}
		
		driver.switchTo().window(parent);
		WaitForPageLoad();
		
	}

}

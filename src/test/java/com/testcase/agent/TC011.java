package com.testcase.agent;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC011 extends AgentSuit {
	
	
	public void verifyChatBoxOpen() throws InterruptedException, AWTException, IOException {
		log.info("Verify able to send Chat Transcription");
		//ExtentTestManager.startTest("(11) Verify able to send Chat Transcription");
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
		draggable.click();
		*/
		
		routedchat.clickQuickAction(name);
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
		
		routedchat.clickandenterSearchMyChatHistory(name);
		routedchat.clickMailIcon();
		Thread.sleep(1000);
		routedchat.clickShare();
		routedchat.enterEmailID(fakedata.getEmail());
		routedchat.clickSubmit();
		
		boolean isTranscriptionMailSent = ElementDisplayed(routedchat.L_mailpopup);
		
		if(isTranscriptionMailSent == true) {
        	assertEquals(isTranscriptionMailSent, true);
			ExtentSuccessMessage("Chat Transcription Mail Sent");
        }
		
		
		Thread.sleep(3000);
		//refreshBrowser();
		
	}
	
}

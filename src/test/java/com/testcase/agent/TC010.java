package com.testcase.agent;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC010 extends AgentSuit {
	
	@Test
	public void verifyChatBoxOpen() throws InterruptedException, AWTException, IOException {
		log.info("Verify Preview Chat");
		ExtentTestManager.startTest("(10) Verify Preview Chat");
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
		
		SwitchtoTab(1);
		driver.switchTo().frame(0);
		String message = fakedata.getMessage();
		chatbed.enterMessage(message);
		
		driver.switchTo().window(parent);
		routedchat.clickPreview();
		Thread.sleep(2000);
		String contact = GetELementValue(routedchat.L_previewmessage);
		
		log.info(contact+"-"+ message);
		
		if(message.equals(contact)) {
        	assertEquals(contact, message);
        	log.info(contact+" "+ message);
			ExtentSuccessMessage("Entered Message is Displayed in preview Section");
        }
		
	}
	
}

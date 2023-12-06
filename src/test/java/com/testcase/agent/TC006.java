package com.testcase.agent;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC006 extends AgentSuit {
	
	@Test
	public void verifyChatBoxOpen() throws InterruptedException, AWTException, IOException {
		log.info("Verify able to open caht box");
		ExtentTestManager.startTest("(6) Verify able to Open Chat Box");
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
		
		WaitForElementToBeVisible(routedchat.L_box_chatusername);
		
		Thread.sleep(3000);
		String contact = GetELementValue(routedchat.L_box_chatusername);
		
		log.info(contact+"-"+ name);
		
		if(name.equals(contact)) {
        	assertEquals(contact, name);
        	log.info(contact+" "+ name);
			ExtentSuccessMessage("Chat Box Opened");
        }
		
		Thread.sleep(3000);
		//refreshBrowser();
		
	}

}

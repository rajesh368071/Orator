package com.testcase.agent;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC016 extends AgentSuit {
	
	public String name = null;
	
	public void common() throws InterruptedException {
		name = fakedata.getFirstName();
		chatbed.clickChatwithus();
		chatbed.enterFirstName(name);
		chatbed.enterEmail(fakedata.getEmail());
		chatbed.clickSubmit();
		Thread.sleep(5000);
	}
	
	public void check() {
		routedchat.clickandenterSearch(name);
		WaitForPageLoad();
		
		WebElement draggable = driver.findElement(routedchat.L_usernamecontact);
		draggable.click();
	}
	
	
	public void verifyChatMessage() throws InterruptedException, AWTException, IOException {
		log.info("Verify Card View");
		//ExtentTestManager.startTest("(16) Verify Able to Create Ticket");
		routedchat.clickRoutedChat();
		
		openNewTab();
		Thread.sleep(1000);
		String parent = driver.getWindowHandle();
		SwitchtoTab(1);
		driver.get(configloader().getProperty("EndUser_URL"));
		chatbed.clickChatButton();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		//
		common();
		//
		driver.switchTo().window(parent);
		refreshBrowser();
		//
		check();
		//
		
		SwitchtoTab(1);
		driver.switchTo().frame(0);
		chatbed.clickHome();
		//
		common();
		//
		driver.switchTo().window(parent);
		refreshBrowser();
		//
		check();
		//
		routedchat.clickCardView();
		
		boolean isCardViewDisplayed = ElementDisplayed(routedchat.L_card_view_chat);
		
		if(isCardViewDisplayed) {
        	assertEquals(isCardViewDisplayed, true);
        	log.info("Card View Displayed");
			ExtentSuccessMessage("Card View Displayed");
        } else {
        	log.info("Card View Not Displayed");
        }
		Thread.sleep(2000);
		WaitForPageLoad();
		
	}

}

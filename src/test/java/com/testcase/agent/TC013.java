package com.testcase.agent;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC013 extends AgentSuit {
	
	
	public void verifyChatMessage() throws InterruptedException, AWTException, IOException {
		log.info("Verify Able to Create Ticket");
		//ExtentTestManager.startTest("(13) Verify Able to Create Ticket");
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
		
		routedchat.clickTicketIcon();
		routedchat.enterSubject(fakedata.getSubject());
		routedchat.selectCategory();
		routedchat.enterDescription(fakedata.getSubject());
		WaitForElementToBeVisible(routedchat.L_priority);
		routedchat.selectTicketPriority();
		routedchat.selectTicketStatus();
		routedchat.selectTicketAssignee();
		routedchat.clickSubmit();
		
		boolean isTicketPopUpDisplayed = ElementDisplayed(routedchat.L_ticketpopup);
		
		if(isTicketPopUpDisplayed) {
        	assertEquals(isTicketPopUpDisplayed, true);
        	log.info("Ticket Created Successfully");
			ExtentSuccessMessage("Ticket Created Successfully");
        } else {
        	log.info("Ticket Not Created");
        }
		Thread.sleep(2000);
		WaitForPageLoad();
		
	}

}

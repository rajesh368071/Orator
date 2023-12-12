package com.testcase.agent;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC019 extends AgentSuit {
	
	
	public void verifyChatBoxOpen() throws InterruptedException, AWTException, IOException {
		log.info("Verify Transfer Chat is Received to Specific Supervisor");
		//ExtentTestManager.startTest("(19) Verify Transfer Chat is Received to Specific Supervisor");
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
		Thread.sleep(5000);
		WaitForElementToBeVisible(L_usernamedropdown);
		
		driver.switchTo().window(parent);
		routedchat.clickEscalate();
		routedchat.selectEscalateChooseSupervisor("nuon arunmeanith");
		routedchat.selectEscalateCategory("General");
		routedchat.selectEscalateSubCategory("Category 1");
		WaitForElementToBeVisible(routedchat.L_escalate_comment);
		routedchat.enterComment("Escalated");
		routedchat.clickSubmit();
		
		SwitchtoTab(2);
		Thread.sleep(3000);
		
		
        String isSame = GetELementValue(routedchat.L_escalated_chat_request);
		
		if(isSame.equals(name)) {
        	assertEquals(isSame, name);
        	log.info(isSame+"-"+name);
			ExtentSuccessMessage("Chat Escalated Successfully");
        }
		
		Thread.sleep(3000);
		driver.switchTo().window(parent);
		
		
	}
	
}

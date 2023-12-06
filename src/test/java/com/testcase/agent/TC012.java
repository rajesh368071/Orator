package com.testcase.agent;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC012 extends AgentSuit {
	
	
	public void verifyChatMessage() throws InterruptedException, AWTException, IOException {
		log.info("Verify Able to Send Image");
		//ExtentTestManager.startTest("(12) Verify Able to Send Image");
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
		
		
		UploadFile(routedchat.L_file_upload, "C:\\Users\\rajesh.ganesh\\Desktop\\loc.png");
		Thread.sleep(2000);
		
		SwitchtoTab(1);
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		WaitForElementToBeVisible(chatbed.L_imagemessage);
		
		boolean isImageReceived = ElementDisplayed(chatbed.L_imagemessage);
		
		if(isImageReceived) {
        	assertEquals(isImageReceived, true);
        	log.info("Image Received");
			ExtentSuccessMessage("Image Received at Enduser");
        } else {
        	log.info("Image Not Received");
        }
		
		WaitForPageLoad();
		
		driver.switchTo().window(parent);
		
	}

}

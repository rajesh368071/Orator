package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;

import com.Utility.Log;
import com.pages.agent.*;

public class TC047 extends AdminSuit {
	
	//public String title = "Kindly provide your valuable feedback by responding to the questions below.";
	
	public void verifyChatFeedbackPage() throws InterruptedException, IOException, AWTException {
		
		
		
		WaitForPageLoad();
		Thread.sleep(3000);
		home.clickSettings();
		formwelcome.clickGeneral();
		formwelcome.clickForms();
		chatfeedback.clickChatFeedback();
		if(!isEnabled(chatfeedback.L_default_questions)) {
			chatfeedback.clickDefaultQuestion();
		}
		Thread.sleep(2000);
		chatfeedback.clickSubmit();
	
		openNewTab();
		Thread.sleep(1000);
		String parent = driver.getWindowHandle();
		SwitchtoTab(1);
		driver.get(configloader().getProperty("Admin_URL"));
		login.enterUsername(configloader().getProperty("AgentUN"));
		login.enterPassword(configloader().getProperty("AgentPWD"));
		login.enterCaptcha();
		login.clickSignin();
		Thread.sleep(5000);
		WaitForElementToBeVisible(L_usernamedropdown);
		
		openNewTab();
		Thread.sleep(1000);
		SwitchtoTab(2);
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
		
		SwitchtoTab(1);
		routedchat.clickQuickAction(name);
		
		routedchat.clickandenterSearchMyChat(name);
		routedchat.clickOpenChatArrow();
		Thread.sleep(3000);
		String message = fakedata.getMessage();
		routedchat.enterMessage(message);
		routedchat.clickClose();
		routedchat.selectCategory();
		routedchat.selectSubCategory();
		routedchat.enterComment("Chat Closed");
		routedchat.clickSubmit();
		
		SwitchtoTab(2);
		driver.switchTo().frame(0);
		
		List<String> value = chatfeedback.checkAllQuestions();
		for(String v : value) {
			By element = By.xpath("//p[contains(normalize-space(),'"+value+"')]");
			assertEquals(ElementDisplayed(element), true);
			Log.info(v);
			Thread.sleep(2000);
		}
		
		driver.switchTo().window(parent);
		Thread.sleep(5000);
	
	}

}

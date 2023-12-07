package com.pages.endusers;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;
import com.orator.pages.LoginPage;

public class ChatbedPage extends Base_Class{
	
	public By L_chat = By.xpath("//button[@class='openChatBtn']");
	public By L_home = By.xpath("//i[@title='Main menu']");
	public By L_iframe = By.cssSelector(".openChat>iframe");
	public By L_chatwithus = By.xpath("//button[contains(., 'Chat with an agent')]");
	
	public By L_faq = By.xpath("//button[contains(., 'FAQs')]");
	public By L_faq_queries = By.xpath("//div[@class='service-wrap btnviewsec ng-tns-c0-0 ng-star-inserted']");
	
	public By L_chatinpt = By.xpath("//textarea[@class='chat-input-text']");
	public By L_send = By.xpath("//i[@title='Send']");
	
	//fqa selection
	public By L_faqoption = By.xpath("(//div[@class='service-wrap btnviewsec ng-tns-c0-0 ng-star-inserted']//button)[1]");
	public By L_faqreply = By.xpath("(//div[@class='normal-msg ng-tns-c0-0 ng-star-inserted'])[1]");
	
	//chat with us form
	public By L_firstname = By.xpath("//input[@placeholder='First Name']");
	public By L_email = By.xpath("//input[@placeholder='Email']");
	public By L_submit = By.xpath("//button[.='Submit']");
	public By L_addedField = By.id("enduserLocation");
	public By L_goAnynomousenduser = By.xpath("//input[@id='goAnonymousCheckBox-input']");
	public By L_acceptAggrementenduser = By.xpath("//input[@id='clickWrapCheckBox-input']");
	public By L_message = By.xpath("(//div[@class='normal-msg ng-tns-c0-0 ng-star-inserted'])[1]");
	public By L_imagemessage = By.xpath("(//div[contains(@class,'chat-message-text')])[1]//img");
	
	//verify chat button is displayed
	public boolean verifyChatBtnDisplayed() throws InterruptedException {
		return ElementDisplayed(L_chat);
	}
	
	//click on chat button
	/*public void clickChatButton() throws InterruptedException {
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(L_chat); 
		act.doubleClick(ele).perform();
	}*/
	
	public void clickChatButton() throws InterruptedException {
		try {
			click(L_chat);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Chat Button Not Clicked");
		}
	}
	
	public void clickFQA() throws InterruptedException {
		click(L_faq);
	}
	
	public void clickQuery() throws InterruptedException {
		jsClick(L_faqoption);
	}
	
	public void clickChatwithus() throws InterruptedException {
		click(L_chatwithus);
	}
	
	public void enterFirstName(String name) {
		try {
			input(L_firstname, name);
			ExtentTestManager.getTest().log(Status.PASS, "Entered First Name");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "First Name Not Entered");
		}
	}
	
	public void enterEmail(String email) {
		try {
			input(L_email, email);
			ExtentTestManager.getTest().log(Status.PASS, "Entered email");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "email Not Entered");
		}
	}
	
	public void clickSubmit() {
		try {
			click(L_submit);
			ExtentTestManager.getTest().log(Status.PASS, "Submit button clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "submit button not clicked");
		}
	}
	
	public void enterMessage(String message) {
		try {
			input(L_chatinpt, message);
			ExtentTestManager.getTest().log(Status.PASS, "Submit button clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "submit button not clicked");
		}
	}
	
	public void clickSend() {
		try {
			click(L_send);
			ExtentTestManager.getTest().log(Status.PASS, "Send button clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Send button not clicked");
		}
	}
	
	public void clickHome() {
		try {
			click(L_home);
			ExtentTestManager.getTest().log(Status.PASS, "Home button clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Home button not clicked");
		}
	}
	
	public By L_feedback_emoji = By.xpath("//mat-icon[contains(normalize-space(),'sentiment_very_satisfied')]");
	public void clickEmoji() {
		try {
			 List<WebElement> total = driver.findElements(L_feedback_emoji);
			for(WebElement ele : total) {
				ele.click();
				Thread.sleep(2000);
			}
			ExtentTestManager.getTest().log(Status.PASS, "Emoji button clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Emoji button not clicked");
		}
	}
	
	
	public By L_feedback_submit = By.xpath("(//button[.='Submit'])[1]");
	public By L_feedback_submission_greeting = By.xpath("(//div[@class='normal-msg ng-tns-c0-0 ng-star-inserted'])[2]");
	public void clickFeedbackSubmit() {
		try {
			click(L_feedback_submit);
			ExtentTestManager.getTest().log(Status.PASS, "Feedback Submit button clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Feedback Submit button not clicked");
		}
	}
	
	
	
}

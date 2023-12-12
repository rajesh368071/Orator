package com.pages.admin;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class ChatFeedbackPage extends Base_Class {
	
	//identifier
	public By L_page_title = By.xpath("//div[@class='mat-tooltip-trigger widget__head box__margin-top']");
	public By L_chatfeedback_option = By.xpath("//span[.='Chat Feedback']");
	
	public void clickChatFeedback( ) throws InterruptedException {
		try {
			click(L_chatfeedback_option);
			ExtentTestManager.getTest().log(Status.PASS, "Chat Feedback Successfully Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Chat Feedback Button Not Clicked");
		}
	}
	
	public By L_openingmessage = By.xpath("(//div[@class='ck ck-editor__main'])[1]");
	public void enterOpeningMessage(String opening_message) throws InterruptedException {
		try {
			jsInput(L_openingmessage, opening_message);
			ExtentTestManager.getTest().log(Status.PASS, "Chat Feedback Opening Message Successfully Entered");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Chat Feedback Opening Message Successfully Not Entered");
		}
	}
	
	public By L_default_questions = By.xpath("//span[contains(text(),normalize-space('Add Default Questions'))]");
	public void clickDefaultQuestion() throws InterruptedException {
		try {
			click(L_default_questions);
			ExtentTestManager.getTest().log(Status.PASS, "Chat Feedback Default Question Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Chat Feedback Default Question Not Clicked");
		}
	}
	
	public By L_form_question = By.xpath("//span[contains(text(),normalize-space('Form Questions'))]");
	public void clickFormQuestion() throws InterruptedException {
		try {
			click(L_form_question);
			ExtentTestManager.getTest().log(Status.PASS, "Chat Feedback Form Question Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Chat Feedback Form Question Not Clicked");
		}
	}
	
	
	public By L_add_new_icon = By.xpath("(//img[@src='assets/images/add.svg'])[last()]");
	public void clickAddNew() throws InterruptedException {
		try {
			click(L_add_new_icon);
			ExtentTestManager.getTest().log(Status.PASS, "Chat Feedback Form New Question Entered");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Chat Feedback Form New Question Not Entered");
		}
	}
	
	public By L_form_new_question = By.xpath("(//div[@class='datacapture__container']//input)[last()]");
	public void clickNewFormQuestion(String question) throws InterruptedException {
		try {
			input(L_form_new_question, question);
			ExtentTestManager.getTest().log(Status.PASS, "Chat Feedback Form New Question Entered");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Chat Feedback Form New Question Not Entered");
		}
	}
	
	public By L_submit = By.xpath("(//div[.='Submit'])[1]");
	public void clickSubmit() throws InterruptedException {
		try {
			click(L_submit);
			ExtentTestManager.getTest().log(Status.PASS, "Clicked Submit Button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Not Clicked Submit Button");
		}
	}
	
	public By L_default_allqustion = By.xpath("//div[@class='feedback__container']//div[@class='feedback__qtn']");
	public  List<String> checkAllQuestions() throws InterruptedException {
		List<WebElement> ele = driver.findElements(L_default_allqustion);
		Thread.sleep(2000);
		List<String> elementText = new ArrayList<String>();
		for(WebElement element : ele) {
			elementText.add(element.getText());
			Thread.sleep(3000);
		}
		return elementText;
	}
}

package com.orator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;

public class ChatbedPage extends Base_Class{
	
	public By L_chat = By.xpath("//button[@class='openChatBtn']");
	public By L_home = By.xpath("//i[@title='Main menu']");
	public By L_iframe = By.cssSelector(".openChat>iframe");
	public By L_chatwithus = By.xpath("//button[contains(., 'Chat with an agent')]");
	public By L_faq = By.xpath("//button[contains(., 'FAQs')]");
	
	//verify chat button is displayed
	public boolean verifyChatBtnDisplayed() throws InterruptedException {
		return ElementDisplayed(L_chat);
	}
	
	//click on chat button
	public void clickChatButton() {
		try {
			driver.findElement(L_chat).click();
			driver.switchTo().frame(driver.findElement(L_chat));
		} catch (Exception e) {
			ExtentErrorMessage("Chat Button Is Not Displayed");
		}
		
	}
	
	public void clickChatwithus() {
		//driver.switchTo().frame(0);
		driver.findElement(L_chatwithus).click();
	}
	
}

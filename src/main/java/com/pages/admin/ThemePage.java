package com.pages.admin;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class ThemePage  extends Base_Class {
	
	//identifiers
	public By L_theme_title = By.xpath("//section/div[normalize-space()='Theme']");
	public By L_preview_page = By.xpath("//mat-dialog-container//app-themepreview");
	public By L_preview_popup = By.xpath("//div[@class='toast-top-right toast-container'][contains(normalize-space(),'Theme updated successfully. Kindly refresh page.')]");
	public By L_notification = By.xpath("(//div[@class='notification__count'])[1]");
	public By L_header_logo = By.xpath("//div[normalize-space()='Header logo']");
	public By L_brand_logo = By.xpath("//div[normalize-space()='Brand logo']");
	public By L_first_theme = By.xpath("//input[@id='theme1-input']");
	public By L_second_theme = By.xpath("//input[@id='theme2-input']");
	
	public By L_system = By.xpath("//span[contains(., 'System')]");
	public void clickSystem( ) throws InterruptedException {
		try {
			click(L_system);
			ExtentTestManager.getTest().log(Status.PASS, "System Button Successfully CLicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "System Button Not Clicked");
		}
		
	}
	
	public By L_theme = By.xpath("//span[contains(., 'Theme')]");
	public void clickTheme( ) throws InterruptedException {
		try {
			click(L_theme);
			ExtentTestManager.getTest().log(Status.PASS, "Theme Button Successfully CLicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Theme Button Not Clicked");
		}
		
	}
	
	
	public void clickThemeRadio(int value) throws InterruptedException {
		By L_theme_radio = By.xpath("(//mat-radio-button)["+value+"]");
		try {
			click(L_theme_radio);
			ExtentTestManager.getTest().log(Status.PASS, "Theme Radio Button Successfully CLicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Theme Radio Button Not Clicked");
		}
		
	}
	
	
	public void clickPreview(int value) throws InterruptedException {
		try {
			By L_theme_preview = By.xpath("(//img[@src='assets/images/eye.svg'])["+value+"]");
			click(L_theme_preview);
			ExtentTestManager.getTest().log(Status.PASS, "Preview Icon Button Successfully CLicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Preview Icon Button Not Clicked");
		}
	}

	public By L_apply_theme = By.xpath("//div[.='Apply Theme']");
	public void clickApplyTheme() throws InterruptedException {
		try {
			jsClick(L_apply_theme);
			ExtentTestManager.getTest().log(Status.PASS, "Apply Theme Button Successfully CLicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Apply Theme Button Not Clicked");
		}
	}
	
	public By L_livechat_tab = By.xpath("//span[.='Live chat console']");
	public void clickLiveChatConsole() throws InterruptedException {
		try {
			click(L_livechat_tab);
			ExtentTestManager.getTest().log(Status.PASS, "Live Chat Console Tab Button Successfully CLicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Live Chat Console Tab Button Not Clicked");
		}
	}
	
	public By L_chat_widget_tab = By.xpath("(//span[.='Chat Widget'])[2]");
	public void clickChatWidget() throws InterruptedException {
		try {
			click(L_chat_widget_tab);
			ExtentTestManager.getTest().log(Status.PASS, "Chat Widget Tab Button Successfully CLicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Chat Widget Tab Button Not Clicked");
		}
	}
	
}

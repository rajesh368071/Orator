package com.orator.pages;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;

public class LoginPage extends Base_Class{
	
	public static By L_username = By.xpath("//input[@id='mat-input-0']");
	public static By L_password = By.xpath("//input[@id='mat-input-1']");
	public static By L_captcha_value = By.xpath("//span[contains(@class, 'captcha-text')]");
	public static By L_captcha = By.xpath("//input[@id='mat-input-2']");
	public static By L_SignIn = By.xpath("//span[contains(., 'Login')]");
	
	public void enterUsername(String username) throws InterruptedException {
		input(L_username, username);
	}
	
	public void enterPassword(String password) throws InterruptedException {
		input(L_password, password);
	}
	
	public void enterCaptcha() throws InterruptedException {
		input(L_captcha, driver.findElement(L_captcha_value).getText());
	}
	
	public void clickSignin() throws InterruptedException {
		click(L_SignIn);
	}
	
}

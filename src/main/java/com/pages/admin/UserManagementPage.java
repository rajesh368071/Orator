package com.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.BasePackage.Base_Class;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentTestInterruptedException;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;

public class UserManagementPage extends Base_Class{
	
	public By L_newuser = By.xpath("//span[text()='New User']");
	public By L_firstname = By.xpath("//input[@formcontrolname='firstName']");
	public By L_lastname = By.xpath("//input[@formcontrolname='lastName']");
	public By L_email = By.xpath("//input[@formcontrolname='email']");
	
	public By L_role = By.xpath("//mat-select[@formcontrolname='role']");
	public By L_role_supervisor = By.xpath("//span[contains(normalize-space(),'Supervisor')]");
	
	public By L_phone = By.xpath("//input[@id='phone']");
	
	public By L_group = By.xpath("//mat-select[@formcontrolname='group']");
	public By L_group_csg = By.xpath("//span[contains(.,'CSG')]/..");
	
	public By L_businesshours = By.xpath("//mat-select[@formcontrolname='businessHour']");
	public By L_businesshours_ist = By.xpath("//mat-option/span[contains(.,'IST')]");
	
	public By L_holidayGroup = By.xpath("//mat-select[@formcontrolname='holidayGroup']");
	public By L_holidayGroup_holidayTest = By.xpath("//mat-option/span[contains(.,'Holiday_Test')]");
	
	public By L_cancel = By.xpath("//div[.='Cancel']");
	public By L_submit = By.xpath("//div[.='Submit']");
	
	public By L_search = By.xpath("//input[@placeholder='Search']");
	public By L_clicksearch = By.xpath("//button[contains(@class,'btn btn__search')]");
	
	public By L_cell_firstname = By.xpath("(//td[@class='mat-cell cdk-cell cdk-column-fname mat-column-fname ng-star-inserted'])[1]");
	
	public By L_cell_status = By.xpath("(//td[contains(@class,'mat-cell cdk-cell cdk-column-status mat-column-status ng-star-inserted mat-table-sticky mat-table-sticky-border-elem-right')]//input[@type='checkbox'])[1]");
	public By L_status_accept = By.xpath("//div[@class='btn btn__accept']");
	
	public void clickNewUser() {
		driver.findElement(L_newuser).click();
	}
	
	public void enterFirstname(String firstname) throws InterruptedException {
		input(L_firstname, firstname);
	}
	
	public void enterlastName(String lastName) throws InterruptedException {
		input(L_lastname, lastName);
	}
	
	public void enterEmail(String email) throws InterruptedException {
		input(L_email, email);
	}
	
	public void selectRole() {
		driver.findElement(L_role).click();
		WaitForElementToBeVisible(L_role_supervisor);
		driver.findElement(L_role_supervisor).click();
	}
	
	
	public void enterPhone(String phone) throws InterruptedException {
		input(L_phone, phone);
	}
	
	public void selectGroup() {
		try {
			driver.findElement(L_group).click();
			WaitForElementToBeVisible(L_group_csg);
			driver.findElement(L_group_csg).click();
			ExtentTestManager.getTest().log(Status.PASS, "Group Selected Successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Group Not Selected");
		}
		
	}
	
	public void selectBusinessHour() {
		try {
			driver.findElement(L_businesshours).click();
			WaitForElementToBeVisible(L_businesshours_ist);
			driver.findElement(L_businesshours_ist).click();
			ExtentTestManager.getTest().log(Status.PASS, "Bussiness Hours Selected Successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Bussiness Hours not Selected");
		}
		
	}
	
	public void selectHolidayGroup() {
		try {
			driver.findElement(L_holidayGroup).click();
			WaitForElementToBeVisible(L_holidayGroup_holidayTest);
			driver.findElement(L_holidayGroup_holidayTest).click();
			ExtentTestManager.getTest().log(Status.PASS, "Holiday Group Selected Successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Holiday Group Not Selected");
		}
		
	}
	
	
	public void clickCancel() throws InterruptedException {
		try {
			click(L_cancel);
			ExtentTestManager.getTest().log(Status.PASS, "Successfully CLicked Canceled Button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.PASS, "Canceled Button Not Clicked");
		}
		
	}
	
	public void clickSubmit() {
		try {
			driver.findElement(L_submit).click();
			ExtentTestManager.getTest().log(Status.PASS, "Successfully clicked on Submit");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Submit Button not Clicked");
		}
	}
	
	public void enterSearch(String searchKey) throws InterruptedException {
		driver.findElement(L_search).sendKeys(Keys.CONTROL+"a");
		driver.findElement(L_search).sendKeys(Keys.DELETE);
		input(L_search, searchKey);
	}
	
	public void clickSearch() throws InterruptedException {
		jsClick(L_clicksearch);
	}
	
	public String getCellData() {
		String s = driver.findElement(L_cell_firstname).getText();
		return s;
	}
	
	public void clickStatus() {
		jsClick(L_cell_status);
	}
	
	public void clickAccept( ) {
		jsClick(L_status_accept);
	}
	
}

package com.pages.admin;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class HolidayGroupPage extends Base_Class {
	
	public By L_group = By.xpath("//span[.='General']");
	public By L_holiday = By.xpath("//span[.='Holiday']");
	public By L_addNew = By.xpath("//span[.='New']");
	public By L_name = By.xpath("//input[@formcontrolname='name']");
	
	
	
	public By L_choose_role = By.xpath("//mat-label[.='Choose Role']");
	public By L_role_option = By.xpath("//span[contains(normalize-space(),'Agent')]");
	public By L_holidaygroupmodalbox = By.xpath("(//h3[normalize-space()='Add Holiday Group'])[1]");
	
	public By L_submit = By.xpath("//div[.='Submit']");
	public By L_cancel = By.xpath("//div[.='Cancel']");
	
	public By L_edit = By.xpath("(//i[.='edit'])[1]");
	
	
	//identifiers
	public By L_holidayPageTitle = By.xpath("(//div[.=' Holiday Group'])[position()=1]");
	public By L_popupcreate = By.xpath("//div[@class='toast-top-right toast-container'][contains(.,'Holiday Group Created')]");
	public By L_popupupdate = By.xpath("//div[@class='toast-top-right toast-container'][contains(.,'Holiday Group Updated')]");
	
	
	public void clickGroup() {
		try {
			click(L_group);
			ExtentTestManager.getTest().log(Status.PASS, "General Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "General Button not Clicked");
		}
	}
	
	public void clickHoliday() {
		try {
			click(L_holiday);
			ExtentTestManager.getTest().log(Status.PASS, "Holiday Group Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Holiday Group Button not Clicked");
		}
	}
	
	public void clickAddNew() {
		try {
			click(L_addNew);
			ExtentTestManager.getTest().log(Status.PASS, "Add New Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Add New Button not Clicked");
		}
	}
	
	public void enterName(String name) {
		try {
			input(L_name, name);
			ExtentTestManager.getTest().log(Status.PASS, "Name Entered");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Name Not Entered");
		}
	}
	
	public void clickCancel() {
		try {
			click(L_cancel);
			ExtentTestManager.getTest().log(Status.PASS, "Cancel Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Cancel Button not Clicked");
		}
	}
	
	public void clickSubmit() {
		try {
			click(L_submit);
			ExtentTestManager.getTest().log(Status.PASS, "Submit Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Submit Button not Clicked");
		}
	}
	
	
	public By L_region = By.xpath("//mat-label[.='Region']");
	
	public void selectRegion(String option) {
		try {
			By L_region_option = By.xpath("//span[.="+option+"]");
			
			jsClick(L_region);
			jsClick(FindElementByText(option));
			KeyOperation("TAB");
			ExtentTestManager.getTest().log(Status.PASS, "Region Selected");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Region Not Selected");
		}
	}
	
	public void selectRole() {
		try {
			jsClick(L_choose_role);
			jsClick(L_role_option);
			KeyOperation("TAB");
			ExtentTestManager.getTest().log(Status.PASS, "Role Selected");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Role Not Selected");
		}
	}
	
	public void clickEdit() {
		try {
			click(L_edit);
			ExtentTestManager.getTest().log(Status.PASS, "Edit Click Successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Edit Not Click");
		}
	}
	

}

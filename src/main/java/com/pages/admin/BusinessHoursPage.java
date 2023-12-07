package com.pages.admin;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class BusinessHoursPage extends Base_Class {
	
	public By L_group = By.xpath("//span[.='General']");
	public By L_businesshours = By.xpath("//span[.='Business Hours']");
	
	public By L_addNew = By.xpath("//span[.='New Business Hours']");
	public By L_name = By.xpath("//input[@formcontrolname='name']");
	
	public By L_business_hours_field = By.xpath("//input[@data-placeholder='Enter Business Hour Group']");
	public By L_time_zone_field = By.xpath("(//mat-select)[position()=1]");
	public By L_time_zone_option_field = By.xpath("//span[.=' Pacific Standard Time ']");
	
	public By L_active_field = By.xpath("(//mat-select)[position()=2]");
	public By L_active_option_field = By.xpath("//span[@class='mat-option-text'][normalize-space()='Active']");
	
	public By L_from_field = By.xpath("(//mat-select)[position()=3]");
	public By L_from_option_field = By.xpath("//span[@class='mat-option-text'][normalize-space()='Sunday']");
	
	public By L_to_field = By.xpath("(//mat-select)[position()=4]");
	public By L_to_option_field = By.xpath("//span[@class='mat-option-text'][normalize-space()='Sunday']");
	
	public By L_starttime_field= By.xpath("//input[@placeholder='Start Time']");
	public By L_endtime_field = By.xpath("//input[@placeholder='End Time']");
	
	
	public By L_submit = By.xpath("//div[.='Submit']");
	public By L_cancel = By.xpath("//div[.='Cancel']");
	
	
	//identifiers
	public By L_business_hours = By.xpath("(//div[.=' Business Hours'])[position()=1]");
	public By L_popupcreate = By.xpath("//div[@class='toast-top-right toast-container'][contains(.,'Business Hours Created')]");
	public By L_popupupdate = By.xpath("//div[@class='toast-top-right toast-container'][contains(.,'Business Hours Updated')]");
	
	
	public void clickGroup() {
		try {
			click(L_group);
			ExtentTestManager.getTest().log(Status.PASS, "General Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "General Button not Clicked");
		}
	}
	
	public void clickBusinessHours() {
		try {
			click(L_businesshours);
			ExtentTestManager.getTest().log(Status.PASS, "Business Hours Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Business Hours Button not Clicked");
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
	
	public void enterBusinessHours(String businessGroupName) {
		try {
			input(L_business_hours_field, businessGroupName);
			ExtentTestManager.getTest().log(Status.PASS, "Business Hours Entered Successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Business Hours Not Entered");
		}
	}
	
	public void enterTimeZone() {
		try {
			click(L_time_zone_field);
			click(L_time_zone_option_field);
			ExtentTestManager.getTest().log(Status.PASS, "Time Zone Entered Successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Time Zone Not Entered");
		}
	}
	
	public void enterStatus() {
		try {
			click(L_active_field);
			click(L_active_option_field);
			ExtentTestManager.getTest().log(Status.PASS, "Status Entered Successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Status Not Entered");
		}
	}
	
	public void enterFrom() {
		try {
			click(L_from_field);
			click(L_from_option_field);
			ExtentTestManager.getTest().log(Status.PASS, "From Entered Successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "From Not Entered");
		}
	}
	
	public void enterTo() {
		try {
			click(L_to_field);
			click(L_to_option_field);
			ExtentTestManager.getTest().log(Status.PASS, "To Entered Successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "To Not Entered");
		}
	}
	
	
	
	
	public void enterStarttime(String starttime) {
		try {
			input(L_starttime_field, starttime);
			ExtentTestManager.getTest().log(Status.PASS, "Starting Time Entered Successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "STarting Time Not Entered");
		}
	}
	
	public void enterEndtime(String endtime) {
		try {
			input(L_endtime_field, endtime);
			ExtentTestManager.getTest().log(Status.PASS, "End Time Entered Successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "End Time Not Entered");
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
	
	public By L_edit = By.xpath("(//i[.='edit'])[1]");
	public void clickEdit() {
		try {
			click(L_edit);
			ExtentTestManager.getTest().log(Status.PASS, "Submit Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Submit Button not Clicked");
		}
	}
	

}

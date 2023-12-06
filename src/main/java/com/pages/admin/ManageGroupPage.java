package com.pages.admin;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class ManageGroupPage extends Base_Class {
	
	public By L_general = By.xpath("//span[.='General']");
	public By L_managegroup = By.xpath("//span[.='Manage Groups']");
	
	public By L_addNew = By.xpath("//span[.='New Group']");
	public By L_search = By.xpath("//input[@placeholder='Search by Name']");
	public By L_searchButton = By.xpath("//img[@src='assets/images/icon-search.svg']");
	
	public By L_group_name = By.xpath("//input[@data-placeholder='Group Name']");
	public By L_submit = By.xpath("//div[.='Submit']");
	public By L_cancel = By.xpath("//div[.='Cancel']");
	
	
	//identifiers
	public By L_manage_group_title = By.xpath("(//div[.=' Groups'])[2]");
	public By L_table_data = By.xpath("(//tr/td)[1]");
	public By L_popupmanagecreate = By.xpath("//div[@role='alertdialog' or .='Created successfully']");
	
	
	
	public void clickGeneral() {
		try {
			click(L_general);
			ExtentTestManager.getTest().log(Status.PASS, "General Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "General Button not Clicked");
		}
	}
	
	public void clickManageGroup() {
		try {
			click(L_managegroup);
			ExtentTestManager.getTest().log(Status.PASS, "Manage Group Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Manage Group Button not Clicked");
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
	
	public void enterGroupName(String groupname) {
		try {
			input(L_group_name, groupname);
			ExtentTestManager.getTest().log(Status.PASS, "Group Name Entered Successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Group Name not Entered");
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
	
	public void enterSearch(String search) {
		try {
			input(L_search, search);
			ExtentTestManager.getTest().log(Status.PASS, "Search Data Entered Successfuly");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Search Data Not Entered");
		}
	}
	
	public void clickSearch() {
		try {
			click(L_searchButton);
			ExtentTestManager.getTest().log(Status.PASS, "Search Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Search Button not Clicked");
		}
	}
	

}

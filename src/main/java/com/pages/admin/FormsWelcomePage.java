package com.pages.admin;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class FormsWelcomePage extends Base_Class {
	
	public By L_general = By.xpath("//span[contains(., 'General')]");
	public By L_forms = By.xpath("//span[contains(., 'Forms')]");
	public By L_welocmepage = By.xpath("//span[contains(., 'Welcome Page')]");
	public By L_faqcheckbox = By.xpath("//mat-checkbox[@id='mat-checkbox-1']");
	public By L_addField = By.xpath("(//img[@src='assets/images/add.svg'])[last()]");
	public By L_newEmptyTextField = By.xpath("(//tbody//input[@placeholder='Text'])[last()]");
	public By L_newEmptyDataTypeField = By.xpath("(//tbody//mat-select)[last()]");
	public By L_datatype_option = By.xpath("(//mat-option)[position()=1]");
	public By L_deleteIcon = By.xpath("(//img[@src='assets/images/delete.svg'])[last()]");
	public By L_data_capture_form = By.xpath("//mat-checkbox//span[contains(.,'Display data capture form')]");
	public By L_goAnynomous = By.xpath("//mat-checkbox//span[contains(.,'Enable Go Anonymous option')]");
	public By L_wrampupAggrement = By.xpath("//mat-checkbox//span[contains(.,'Include clickwrap agreement')]");
	
	public By L_popupupdate = By.xpath("//div[@class='toast-top-right toast-container'][contains(.,'Data updated successfully.')]");
	
	
	//check visibility
	public By L_webwidget = By.xpath("//span[contains(., 'Web Widget')]");
	public By L_faq = By.xpath("//mat-checkbox[@id='mat-checkbox-1']//input[@id='mat-checkbox-1-input']");
	public By L_submit = By.xpath("//div[@class='btn btn__accept']");
	public By L_opening_msg = By.xpath("(//div[@class='ck ck-editor__main'])[1]");
	public By L_data_capture_form_checkbox = By.xpath("//input[@id='mat-checkbox-2-input']");
	public By L_goAnynomousCheckBox = By.xpath("//input[@id='mat-checkbox-4-input']");
	public By L_wrampupAggrementCheckBox = By.xpath("//input[@id='mat-checkbox-5-input']");
	
	public void clickGeneral( ) throws InterruptedException {
		try {
			click(L_general);
			ExtentTestManager.getTest().log(Status.PASS, "General Button Successfully CLicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "General Button Not Clicked");
		}
		
	}
	
	public void clickForms() throws InterruptedException {
		try {
			click(L_forms);
			ExtentTestManager.getTest().log(Status.PASS, "Forms Option CLicked SUccessfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Forms Option Not Clicked ");
		}
		
	}
	
	public void clickWelcomepage() throws InterruptedException {
		try {
			click(L_welocmepage);
			ExtentTestManager.getTest().log(Status.PASS, "Welcome Page Option CLicked SUccessfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Welcome Page Option Not Clicked ");
		}
	}
	
	public void clickFAQ() throws InterruptedException {
		try {
			click(L_faqcheckbox);
			ExtentTestManager.getTest().log(Status.PASS, "FAQs CHeckBox Clicked SUccessfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "FAQs Check Box Not Clicked ");
		}
	}
	
	public void enterOpeningMessage(String openingMessage) {
		try {
			jsInput(L_opening_msg, openingMessage);
			ExtentTestManager.getTest().log(Status.PASS, "Opening Message Entered SUccessfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Opening Message Not Entered");
		}
	}
	
	public void clickSubmit() {
		try {
			jsClick(L_submit);
			ExtentTestManager.getTest().log(Status.PASS, "Submit Button CLicked SUccessfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.PASS, "Submit Button Not Clicked");
		}
	}
	
	public void clickDataCaptureForm() throws InterruptedException {
		try {
			click(L_data_capture_form);
			ExtentTestManager.getTest().log(Status.PASS, "Data Capture Form Checkbox Clicked SUccessfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Data Capture Form Check Box Not Clicked ");
		}
	}
	
	public void clickaddField() throws InterruptedException {
		try {
			click(L_addField);
			ExtentTestManager.getTest().log(Status.PASS, "Add Icon Clicked Successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, e);
		}
	}
	
	public void enterFieldName(String name) {
		try {
			input(L_newEmptyTextField, name);
			ExtentTestManager.getTest().log(Status.PASS, "Entered Field Name successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, e);
		}
	}
	
	public void selectDataType() {
		try {
			click(L_newEmptyDataTypeField);
			click(L_datatype_option);
			ExtentTestManager.getTest().log(Status.PASS, "successfully selected datatype");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, e);
		}
	}
	
	public void clickDeleteIcon() {
		try {
			click(L_deleteIcon);
			ExtentTestManager.getTest().log(Status.PASS, "Successfully Field Deleted");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, e);
		}
	}
	
	public void clickGoAnynomous() throws InterruptedException {
		try {
			click(L_goAnynomous);
			ExtentTestManager.getTest().log(Status.PASS, "Go Anonymous CheckBox Clicked SUccessfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Go Anonymous Check Box Not Clicked ");
		}
	}
	
	public void clickwrampupAggrement() {
		try {
			click(L_wrampupAggrement);
			ExtentTestManager.getTest().log(Status.PASS, "Wramp Up Aggrement CheckBox Clicked SUccessfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Wramp Up Aggrement Check Box Not Clicked ");
		}
		
	}
	
	
	
}

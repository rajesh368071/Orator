package com.pages.admin;

import java.util.ArrayList;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class ChatCategoriesPage extends Base_Class{
	
	public By L_chat = By.xpath("//span[.='Chat']");
	public By L_categories = By.xpath("//span[.='Categories']");
	public By L_newCategory = By.xpath("//span[.='New Category']");
	public By L_category_name= By.xpath("//input[@formcontrolname='name']");
	public By L_category_sub_ctg = By.xpath("//input[@class='mat-chip-input mat-input-element']");
	public By L_submit = By.xpath("//div[.='Submit']");
	public By L_cancel = By.xpath("//div[.='Cancel']");
	
	public By L_popupcreate = By.xpath("//div[@role='alertdialog' or .='Category Created']");
	public By L_popupupdate = By.xpath("//div[@role='alertdialog' or .='Category Updated']");
	public By L_editIcon = By.xpath("(//i[.='edit'])[position()=1]");
	
	public By L_cell_category = By.xpath("(//td[@class='mat-cell cdk-cell cdk-column-name mat-column-name ng-star-inserted'])[1]//div/span");
	
	public void clickChat() {
		try {
			click(L_chat);
			ExtentTestManager.getTest().log(Status.PASS, "Chat Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Chat Button not Clicked");
		}
	}
	
	public void clickCategories() {
		try {
			click(L_categories);
			ExtentTestManager.getTest().log(Status.PASS, "Categories Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Categories Button not Clicked");
		}
	}
	
	public void clickNewCategory() {
		try {
			click(L_newCategory);
			ExtentTestManager.getTest().log(Status.PASS, "Category Model Box Displayed");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Category Model Box Not Displated");
		}
	}
	
	public void enterCategoryName(String categoryName) {
		try {
			input(L_category_name, categoryName);
			ExtentTestManager.getTest().log(Status.PASS, "Entered Category Name");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Category Name Not Entered into the Category");
		}
	}
	
	public void enterSubCategory(ArrayList<String> string) {
		try {
			for(String obj : string) {
				input(L_category_sub_ctg, obj);
				input(L_category_sub_ctg, ",");
				Thread.sleep(500);
			}
			ExtentTestManager.getTest().log(Status.PASS, "Sub Category Entered into the field");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Sub Category Not Entered into the field");
		}
	}
	
	public void clickSubmit() {
		try {
			click(L_submit);
			ExtentTestManager.getTest().log(Status.PASS, "Successfully clicked Submit Button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Submit Button Not CLicked");
		}
	}
	
	public void clickCancel() {
		try {
			click(L_cancel);
			ExtentTestManager.getTest().log(Status.PASS, "Successfully clicked Cancel Button");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Cancel Button Not CLicked");
		}
	}
	
	public void clickeditIcon() {
		try {
			click(L_editIcon);
			ExtentTestManager.getTest().log(Status.PASS, "Successfully clicked Edit Icon");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Edit Icon Button Not CLicked");
		}
	}
	
	
	
	
 }

package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class TC011 extends AdminSuit{
	
	@Test(priority = 11)
	public void verifyFieldsDisplayed() throws InterruptedException {
		log.info("Verify Components are displayed in Category Model Box");
		ExtentTestManager.startTest("11) Verify Components are displayed in Category Model Box");
		refreshBrowser();
		home.clickSettings();
		category.clickChat();
		category.clickCategories();
		WaitForElementToBeVisible(category.L_newCategory);
		category.clickNewCategory();
		boolean categoryNameele = ElementDisplayed(category.L_category_name);
		
		//verify Category Name field Element is displayed
		if(categoryNameele) {
			assertEquals(categoryNameele, true);
			ExtentSuccessMessage("Category Name Field is Displayed");
		} else {
			ExtentErrorMessage("Category Name Field is not Displayed");
		}
		category.clickCancel();
	}
	
}

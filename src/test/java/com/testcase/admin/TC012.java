package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC012 extends AdminSuit {
	
	@Test(priority = 12)
	public void createCategory() throws InterruptedException {
		log.info("Verify Able to Create Category");
		ExtentTestManager.startTest("12) Verify Able to Create Category");
		refreshBrowser();
		home.clickSettings();
		category.clickChat();
		category.clickCategories();
		WaitForElementToBeVisible(category.L_newCategory);
		category.clickNewCategory();
		WaitForElementToBeVisible(category.L_category_name);
		String randomword = fakedata.getRandom();
		category.enterCategoryName(randomword);
		ArrayList<String> subCategory = new ArrayList<String>();
		subCategory.add(fakedata.getRandom());
		subCategory.add(fakedata.getRandom());
		subCategory.add(fakedata.getRandom());
		subCategory.add(fakedata.getRandom());
		category.enterSubCategory(subCategory);
		category.clickSubmit();
		
		boolean isCreated = ElementDisplayed(category.L_popupcreate);
		
		
		if(isCreated) {
			assertEquals(isCreated, true);
			ExtentSuccessMessage("Successfullt Category Created");
		}else {
			ExtentErrorMessage("Category is not Created");
		}
		Thread.sleep(5000);
	}
}

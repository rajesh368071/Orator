package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC013 extends AdminSuit {
	
	
	public void createCategory() throws InterruptedException {
		log.info("Verify able to Update Category");
		//ExtentTestManager.startTest("13) Verify able to Update Category");
		WaitForPageLoad();
		home.clickSettings();
		category.clickChat();
		category.clickCategories();
		WaitForElementToBeVisible(category.L_newCategory);
		category.clickeditIcon();
		WaitForElementToBeVisible(category.L_category_name);
		String randomword = fakedata.getRandom();
		category.enterCategoryName(randomword);
		ArrayList<String> subCategory = new ArrayList<String>();
		subCategory.add(fakedata.getRandom());
		category.enterSubCategory(subCategory);
		category.clickSubmit();
		
		boolean isCreated = ElementDisplayed(category.L_popupupdate);
		
		
		if(isCreated) {
			assertEquals(isCreated, true);
			ExtentSuccessMessage("Successfullt Category Updated");
		}else {
			ExtentErrorMessage("Category is not Updated");
		}
		Thread.sleep(5000);
	}
}

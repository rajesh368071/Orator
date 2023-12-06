package com.IVOS.NavigateAllTabs;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.BasePackage.Base_Class;
import com.Utility.Log;


public class WC_Tabs extends Base_Class {
	// Maintain all the locators for each tabs under WC module
	// Create methods for navigating to tabs and loading and scrolling methods
	private static By IFrame_Apportionment_Tab = By.id("608");
	private static By IFrame_CEP_Tab = By.id("539");
	private static By IFrame_Claim_Tab = By.id("612");
	private static By IFrame_Commutation_Tab = By.id("638");
	private static By IFrame_Contacts_Tab = By.id("630");
	private static By IFrame_Content_Tab = By.id("647");
	private static By IFrame_Correspondence_Tab = By.id("623");
	private static By IFrame_Dependents_Tab = By.id("637");
	
	
	
	
	
	public static By L_TimeTrackingFrame = By.id("644");
	public static By L_PaymentFrame = By.id("626");
	public static By L_MedicareFrame = By.id("618");
	public static By L_NotepadFrame = By.id("607");
	public static By L_PackageFrame = By.id("648");
	public static By L_PredictFrame = By.id("939");
	public static By L_ReserveFrame = By.id("625");
	public static By L_ScheduledPaymentFrame = By.id("627");
	public static By L_SIUFrame = By.id("619");
	public static By L_StickyNoteFrame = By.id("624");
	public static By L_SubrogationFrame = By.id("634");

	private static String MainMenu = "//*[text()='%s']";
	private static String SubMenu = "//*[contains(@item-label,'%s')]";
	private static String MenuItem = "//li[contains(text(),'%s')]";
	private static By L_ClaimantSearchTab = By.id("Claimant Search");
	private static By iFrameClaimantFrame = By.id("542");
	private static By L_InsuredField = By.id("insured_name1");
	private static By L_ClaimNumberField = By.id("claim_number");
	private static By L_InsuranceType = By.id("dropdownlistContentsearch_insurance_type");
	private static By L_SearchButton = By.id("search");
	private static By L_ClaimTabResetButton = By.id("reset");
	private static By L_MailFrame = By.id("608");

	
	// Asif Navigation
	public void NavigateAnyTab(String SubMenu,String TabName) throws InterruptedException {
		NavigatetoMenu("Tabs", SubMenu,TabName);
		WaitForPageLoad();
		WaitForAJAX_ToLoad();
		WaitForLoadAnimationDisappear();
		ExtentSuccessMessage("Successfully Navigated to "+TabName+" tab");		
	}
		

	@Override
	public void NavigatetoMenu(String mainMenu, String subMenu, String menuItem) throws InterruptedException {
		
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath(String.format(MainMenu, mainMenu)))).build().perform();
			Thread.sleep(1000);
			action.moveToElement(driver.findElement(By.xpath(String.format(SubMenu, subMenu)))).build().perform();
			Thread.sleep(1000);
			try {
				click(By.xpath(String.format(MenuItem, menuItem)));
			} catch (NoSuchElementException e) {
				e.printStackTrace();
			}
			if (driver.getWindowHandles().size() > 1) {
				String parent = driver.getWindowHandle();
				Set<String> Winhandles = driver.getWindowHandles();
				for (String hndl : Winhandles) {
					driver.switchTo().window(hndl);
//				driver.close();
//				Thread.sleep(1000);
//				Log.info("Successfully closed the browser");
//				Thread.sleep(2000);
//				Base_Class.KeyOperation("ENTER");
				}
			}
	}

	// Navigate to Claimant Search Tab
	public void NavigateToClaimantSearchTab() throws InterruptedException {
		click(L_ClaimantSearchTab);
		ExtentSuccessMessage("Successfully click 'Claimant Search' Tab");
		Thread.sleep(3000);
		SwitchToFrame(iFrameClaimantFrame);
	}

	// Claimant search verification
	public void SearchClaim(String ClaimNumber, String Insured, String InsuranceType) throws InterruptedException {
		driver.switchTo().defaultContent();
		SwitchToFrame(iFrameClaimantFrame);
		input(L_ClaimNumberField, ClaimNumber);
		ExtentSuccessMessage("Successfully enter claim number into the claim filed :" + ClaimNumber);
		input(L_InsuredField, Insured);
		ExtentSuccessMessage("Successfully enter Insured into the Insured field:" + Insured);
		SelectDropDownValue(L_InsuranceType, InsuranceType);

		click(L_SearchButton);
		ExtentSuccessMessage("Successfully click on 'Search' button on claimant search page.");
		Thread.sleep(5000);
	}

	// Claimant search verification
	public void SearchClaim(String ClaimNumber) throws InterruptedException {
		click(L_ClaimTabResetButton);
		ExtentSuccessMessage("Successfully click 'Reset' button on claimant search page");
		input(L_ClaimNumberField, ClaimNumber);
		ExtentSuccessMessage("Successfully enter claim number into the claim filed :" + ClaimNumber);
		click(L_SearchButton);
		ExtentSuccessMessage("Successfully click on 'Search' button on claimant search page.");
		Thread.sleep(3000);
	}

	// Select Claim From Results grid
	public void SelectClaimFromTable(String ClaimNumber) {

		String LeftXpath = "//div[text()='" + ClaimNumber + "']";
		try {
			click(By.xpath(LeftXpath));
			DoubleClick(By.xpath(LeftXpath));
			ExtentSuccessMessage(
					"Successfully double clik on the searched claim list for the claimnumber :" + ClaimNumber);

		} catch (InterruptedException e) {
			ExtentErrorMessage(
					"Not able to double clik on the searched claim list for the claimnumber :" + ClaimNumber);
			e.printStackTrace();
		}
	}
}
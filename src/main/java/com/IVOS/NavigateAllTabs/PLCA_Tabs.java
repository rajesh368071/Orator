package com.IVOS.NavigateAllTabs;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.BasePackage.Base_Class;

public class PLCA_Tabs extends Base_Class {
	// Maintain all the locators for each tabs under WC module
	// Create methods for navigating to tabs and loading and scrolling methods
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
	public static By L_AlertFrame = By.id("535");
	public static By L_ClaimantFrame = By.id("611");
	public static By L_ClaimantDashboardFrame = By.id("613");
	public static By L_ContactsFrame = By.id("630");
	public static By L_ContentFrame = By.id("647");
	public static By L_CorrespondenceFrame = By.id("623");
	public static By L_DiaryFrame = By.id("606");
	public static By L_EFormFrame = By.id("841");
	public static By L_IncidentFrame = By.id("610");
	public static By L_ISOClaimSearchFrame = By.id("632");
	public static By L_LitigationFrame = By.id("628");

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

	// Alert Navigation
	public void NavigateToAlertTab() throws InterruptedException {
		NavigatetoMenu("Tabs", "A - L", "Alert");

		SwitchToFrameByID(L_AlertFrame);
		ExtentSuccessMessage("Successfully Navigated to Alert tab");
		// SwitchToParentFrame();
	}

	// Claimant Navigation
	public void NavigateToClaimantTab() throws InterruptedException {
		NavigatetoMenu("Tabs", "A - L", "Claimant (Alt+7)");

		SwitchToFrameByID(L_ClaimantFrame);
		ExtentSuccessMessage("Successfully Navigated to Claimant tab");
		// SwitchToParentFrame();
	}

	// Claimant Dashboard Navigation
	public void NavigateToClaimantDashboardTab() throws InterruptedException {
		NavigatetoMenu("Tabs", "A - L", "Claimant Dashboard");

		SwitchToFrameByID(L_ClaimantDashboardFrame);
		ExtentSuccessMessage("Successfully Navigated to Claimant Dashboard tab");
		// SwitchToParentFrame();
	}

	// Contacts Navigation
	public void NavigateToContactsTab() throws InterruptedException {
		NavigatetoMenu("Tabs", "A - L", "Contacts");

		SwitchToFrameByID(L_ContactsFrame);
		WaitForPageLoad();
		WaitForAJAX_ToLoad();
		WaitForLoadAnimationDisappear();
		ExtentSuccessMessage("Successfully Navigated to Contacts tab");
		// SwitchToParentFrame();
	}

	// Content Navigation
	public void NavigateToContentTab() throws InterruptedException {
		NavigatetoMenu("Tabs", "A - L", "Content");

		SwitchToFrameByID(L_ContentFrame);
		ExtentSuccessMessage("Successfully Navigated to Content tab");
		// SwitchToParentFrame();
	}

	// Correspondence Navigation
	public void NavigateToCorrespondenceTab() throws InterruptedException {
		NavigatetoMenu("Tabs", "A - L", "Correspondence");
		SwitchToFrameByID(L_CorrespondenceFrame);
		ExtentSuccessMessage("Successfully Navigated to Correspondence tab");
		// SwitchToParentFrame();
	}

	// Diary Navigation
	public void NavigateToDiaryTab() throws InterruptedException {
		NavigatetoMenu("Tabs", "A - L", "Diary (Alt+U)");
		SwitchToFrameByID(L_DiaryFrame);
		ExtentSuccessMessage("Successfully Navigated to Diary tab");

	}

	// EForm Navigation
	public void NavigateToEFormTab() throws InterruptedException {
		NavigatetoMenu("Tabs", "A - L", "EForm");
		SwitchToFrameByID(L_EFormFrame);
		ExtentSuccessMessage("Successfully Navigated to EForm tab");
		// SwitchToParentFrame();
	}

	// Incident Navigation
	public void NavigateToIncidentTab() throws InterruptedException {
		NavigatetoMenu("Tabs", "A - L", "Incident");
		SwitchToFrameByID(L_IncidentFrame);
		ExtentSuccessMessage("Successfully Navigated to Incident tab");
		// SwitchToParentFrame();
	}

	// ISOClaimSearch Navigation
	public void NavigateToISOClaimSearchTab() throws InterruptedException {
		NavigatetoMenu("Tabs", "A - L", "ISO ClaimSearch");
		SwitchToFrameByID(L_ISOClaimSearchFrame);
		WaitForPageLoad();
		WaitForAJAX_ToLoad();
		WaitForLoadAnimationDisappear();
		ExtentSuccessMessage("Successfully Navigated to ISOClaimSearch tab");
		// SwitchToParentFrame();
	}

	// Litigation Navigation
	public void NavigateToLitigationTab() throws InterruptedException {
		NavigatetoMenu("Tabs", "A - L", "Litigation");
		SwitchToFrameByID(L_LitigationFrame);
		WaitForPageLoad();
		WaitForAJAX_ToLoad();
		WaitForLoadAnimationDisappear();
		ExtentSuccessMessage("Successfully Navigated to Litigation tab");
		// SwitchToParentFrame();
	}

	// Time Tracking Navigation
	public void NavigateToTimeTrackingTab() throws InterruptedException {
		NavigatetoMenu("Tabs", "M - Z", "Time Tracking");

		SwitchToFrameByID(L_TimeTrackingFrame);
		ExtentSuccessMessage("Successfully Navigated to TimeTracking tab");
		// SwitchToParentFrame();
	}

	// Payment Navigation
	public void NavigateToPaymentTab() throws InterruptedException {
		NavigatetoMenu("Tabs", "M - Z", "Payment");

		SwitchToFrameByID(L_PaymentFrame);
		WaitForPageLoad();
		WaitForAJAX_ToLoad();
		WaitForLoadAnimationDisappear();
		ExtentSuccessMessage("Successfully Navigated to Payment tab");
	}

	// Package Navigation
	public void NavigateToPackageTab() throws InterruptedException {
		NavigatetoMenu("Tabs", "M - Z", "Package");

		SwitchToFrameByID(L_PackageFrame);
		WaitForPageLoad();
		WaitForAJAX_ToLoad();
		WaitForLoadAnimationDisappear();
		ExtentSuccessMessage("Successfully Navigated to Package tab");
		// SwitchToParentFrame();
	}

	// Medicare Navigation
	public void NavigateToMedicareTab() throws InterruptedException {
		NavigatetoMenu("Tabs", "M - Z", "Medicare");

		SwitchToFrameByID(L_MedicareFrame);
		WaitForPageLoad();
		WaitForAJAX_ToLoad();
		WaitForLoadAnimationDisappear();
		ExtentSuccessMessage("Successfully Navigated to Medicare tab");
		// SwitchToParentFrame();
	}

	// Notepad Navigation
	public void NavigateToNotepadTab() throws InterruptedException {
		NavigatetoMenu("Tabs", "M - Z", "Notepad");

		SwitchToFrameByID(L_NotepadFrame);
		WaitForPageLoad();
		WaitForAJAX_ToLoad();
		WaitForLoadAnimationDisappear();
		ExtentSuccessMessage("Successfully Navigated to Notepad tab");
		// SwitchToParentFrame();
	}

	// Mail Navigation
	public void NavigateMailTab() throws InterruptedException {
		NavigatetoMenu("Tabs", "M - Z", "Mail");

		SwitchToFrameByID(L_MailFrame);
		WaitForPageLoad();
		WaitForAJAX_ToLoad();
		WaitForLoadAnimationDisappear();
		ExtentSuccessMessage("Successfully Navigated to Mail tab");
		// SwitchToParentFrame();
	}

	// Predict Navigation
	public void NavigatePredictTab() throws InterruptedException {
		NavigatetoMenu("Tabs", "M - Z", "Predict");

		SwitchToFrameByID(L_PredictFrame);
		WaitForPageLoad();
		WaitForAJAX_ToLoad();
		WaitForLoadAnimationDisappear();
		ExtentSuccessMessage("Successfully Navigated to Predict tab");
		// SwitchToParentFrame();
	}

	// Reserve Navigation
	public void NavigateReserveTab() throws InterruptedException {
		NavigatetoMenu("Tabs", "M - Z", "Reserve");

		SwitchToFrameByID(L_ReserveFrame);
		WaitForPageLoad();
		WaitForAJAX_ToLoad();
		WaitForLoadAnimationDisappear();
		ExtentSuccessMessage("Successfully Navigated to Reserve tab");
		// SwitchToParentFrame();
	}

	// Scheduled Payment Navigation
	public void NavigateScheduledPaymentTab() throws InterruptedException {
		NavigatetoMenu("Tabs", "M - Z", "Scheduled Payment");

		SwitchToFrameByID(L_ScheduledPaymentFrame);
		WaitForPageLoad();
		WaitForAJAX_ToLoad();
		WaitForLoadAnimationDisappear();
		ExtentSuccessMessage("Successfully Navigated to Scheduled Payment tab");
	}

	// SIU Navigation
	public void NavigateSIUTab() throws InterruptedException {
		NavigatetoMenu("Tabs", "M - Z", "SIU");

		SwitchToFrameByID(L_SIUFrame);
		WaitForPageLoad();
		WaitForAJAX_ToLoad();
		WaitForLoadAnimationDisappear();
		ExtentSuccessMessage("Successfully Navigated to SIU tab");
		// SwitchToParentFrame();
	}

	// Sticky Note Navigation
	public void NavigateStickyNoteTab() throws InterruptedException {
		NavigatetoMenu("Tabs", "M - Z", "Sticky Note");

		SwitchToFrameByID(L_StickyNoteFrame);
		WaitForPageLoad();
		WaitForAJAX_ToLoad();
		WaitForLoadAnimationDisappear();
		ExtentSuccessMessage("Successfully Navigated to Sticky Note tab");
		// SwitchToParentFrame();
	}

	// Subrogation Navigation
	public void NavigateSubrogationTab() throws InterruptedException, AWTException {
		NavigatetoMenu("Tabs", "M - Z", "Subrogation");

		SwitchToFrameByID(L_SubrogationFrame);
		WaitForPageLoad();
		WaitForAJAX_ToLoad();
		WaitForLoadAnimationDisappear();
		// HandleSplitterBar();
		Zoomout();
		ExtentSuccessMessage("Successfully Navigated to Subrogation tab");

		// SwitchToParentFrame();
	}

	@Override
	public void NavigatetoMenu(String mainMenu, String subMenu, String menuItem) throws InterruptedException {
		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath(String.format(MainMenu, mainMenu)))).build().perform();
		// .moveToElement(driver.findElement(By.xpath(String.format(SubMenu,
		// subMenu)))).build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath(String.format(SubMenu, subMenu)))).build().perform();
		Thread.sleep(1000);
		click(By.xpath(String.format(MenuItem, menuItem)));
		if (driver.getWindowHandles().size() > 1) {
			String parent = driver.getWindowHandle();
			Set<String> Winhandles = driver.getWindowHandles();
			for (String hndl : Winhandles) {
				driver.switchTo().window(hndl);
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

	/// Zoom Out code: To Zoom Out 2 Times
	public void Zoomout() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		for (int i = 0; i < 2; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
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

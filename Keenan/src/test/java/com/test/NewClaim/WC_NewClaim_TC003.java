package com.test.NewClaim;

import java.awt.AWTException;

import com.pages_Claim.ClaimantSearch;
import com.pages_Claim.NavigateNewClaim;

public class WC_NewClaim_TC003 extends NewClaim_AllScenarios {

	ClaimantSearch ClaimantSearch = new ClaimantSearch();
	NavigateNewClaim NewClaim = new NavigateNewClaim();

	/*
	 * TestCase Description : EnterDOIDateOfInjuryPickTreaty
	 * 
	 * Author : Asif Alam Last Modify :
	 */
	public void EnterDOIDateOfInjuryPickTreaty(String TestScenario, String InsuranceType, String IncidentDate,
			String InsuredName, String PolicyNumber, String Grosswage) throws InterruptedException, AWTException {
		// Click on File
		// Click on OPen File
		NewClaim.NavigateToNewclaim();
		// Select InsuranceType
		// Incident Date
		// Close Duplicate Claim Window
		// Click on Search
		NewClaim.SearchClaimCovrage(InsuranceType, IncidentDate, InsuredName);
		// Select the Policy From The Table
		NewClaim.SelectInsurerFromTable(PolicyNumber);
		// Switch the windows
		Base_Class.SwitchToBrowser("child");
		switchToWindowByTitle("Work Comp Claim");
		Thread.sleep(20000);
		NewClaim.DOIDateOfInjury1(Grosswage);

	}
}

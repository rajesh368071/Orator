package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC035 extends AdminSuit {
	
	@Test
	public void verifySameWelcomeMessage() throws InterruptedException {
		log.info("Verify Ticket Page Displayed");
		refreshBrowser();
		ExtentTestManager.startTest("35) Verify Ticket Page Displayed");
		home.clickSettings();
		ticket.clickGeneral();
		ticket.clickTicket();
		boolean isTicketPageDisplayed = ElementDisplayed(ticket.L_ticket_title);
		if(isTicketPageDisplayed) {
			assertEquals(isTicketPageDisplayed, true);
			ExtentSuccessMessage("Ticket Page Displayed Successfully");
		}
	}

}

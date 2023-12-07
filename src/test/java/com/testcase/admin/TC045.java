package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

public class TC045  extends AdminSuit {

	public void verifyHolidayGroupUpdate() throws InterruptedException, AWTException, IOException {
		String value = new TC029().verifySameWelcomeMessage();
		holidaygroup.clickEdit();
		holidaygroup.clickSubmit();
		boolean assertActualValue = ElementDisplayed(holidaygroup.L_popupupdate);
		assertEquals(assertActualValue, true);
	}
 }

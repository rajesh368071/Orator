package com.textcase.all;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.BasePackage.Base_Class;
import com.Utility.FakeData;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;
import com.orator.pages.WelcomePage;
import com.pages.endusers.ChatbedPage;

public class TC001 extends AllTestcases{
	
	
	@Test
	public void verifyEndUserLaunched() throws InterruptedException {
		ExtentTestManager.startTest("Verify the Recipient is able to  launch the end user url successfully");
		boolean isdisplayed = ElementDisplayed(chatbed.L_chat);
		if(isdisplayed) {
			assertEquals(isdisplayed, true);
		} else {
			assertEquals(isdisplayed, false);
		}
	}

}


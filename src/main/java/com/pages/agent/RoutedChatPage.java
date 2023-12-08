package com.pages.agent;

import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.BasePackage.Base_Class;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class RoutedChatPage extends Base_Class {

	public By L_routedChat = By.xpath("//span[.='Routed Chat']");
	public By L_reviewBord = By.xpath("//span[.='Review Board']");
	
	public By L_search = By.xpath("(//button[@aria-label='Search'])[1]");
	public By L_search3 = By.xpath("(//button[@aria-label='Search'])[3]");
	public By L_search4 = By.xpath("(//button[@aria-label='Search'])[4]");
	public By L_searchinput = By.xpath("(//input[@class='search__input'])[1]");
	public By L_searchinput3 = By.xpath("(//input[@class='search__input'])[3]");
	public By L_searchinput4 = By.xpath("(//input[@class='search__input'])[4]");
	
	public By L_routechatcontact = By.xpath("((//div[@class='chat__boxChat'])[1]/div)[1]");
	public By L_mychat = By.xpath("(//div[@class='cdk-drop-list chat__wrapper'])[2]");
	
	public By L_box_openChat = By.xpath("//mat-icon[.='subdirectory_arrow_right']");
	public By L_box_chatusername = By.xpath("//div[contains(@class,'chat__fullName')]");
	public By L_box_chat_input = By.xpath("//input[@placeholder='Enter your chat']");
	public By L_box_send_btn = By.xpath("//img[@src='assets/images/send_icon.svg']");
	public By L_file_upload = By .xpath("//input[@type='file']");
	
	
	//Identifier
	public By L_reviewbordtitle = By.xpath("//span[.='Chat Analytics']");
	public By L_usernamecontact = By.xpath("((//div[@class='chat__boxChat'])[1]/div)[1]//div[@class='chat__userName']");
	public By L_usernamecontactmychat = By.xpath("((//div[@class='chat__boxChat'])[3]/div)[1]//div[@class='chat__userName']");
	public By L_usernamecontactchathistory = By.xpath("((//div[@class='chat__boxChat'])[4]/div)[1]//div[@class='chat__userName']");
	public By L_popup = By.xpath("//div[@class='toast-top-right toast-container'][contains(.,'Chat closed successfully...')]");
	public By L_previewmessage = By.xpath("//div[@class='quickrpl__container']/div");
	public By L_mailpopup = By.xpath("//div[@role='alertdialog' or normalize-space()='Chat transcript sent successfully!']");
	public By L_ticketpopup = By.xpath("//div[@role='alertdialog' or normalize-space()='Ticket created successfully']"); 
	public By L_card_view_chat = By.xpath("//h2[contains(normalize-space(),'Card View Chats')]");
	public By L_escalatepopup = By.xpath("//div[@class='toast-top-right toast-container'][contains(.,'Chat escalated successfully...')]");
	public By L_escalated_chat_request = By.xpath("//div[@class='escalated__wrapper ng-star-inserted']//div[@class='chat__userName']");
	
	public void clickReviewBord() {
		try {
			click(L_reviewBord);
			ExtentTestManager.getTest().log(Status.PASS, "Review Bord Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Review Bord not Clicked");
		}
	}
	
	public void clickRoutedChat() {
		try {
			click(L_routedChat);
			ExtentTestManager.getTest().log(Status.PASS, "Routed Chat Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Routed Chat Button not Clicked");
		}
	}
	
	public void clickandenterSearch(String name) {
		try {
			click(L_search);
			input(L_searchinput, name);
			ExtentTestManager.getTest().log(Status.PASS, "Routed Chat Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Routed Chat Button not Clicked");
		}
	}
	
	public void clickandenterSearchMyChat(String name) {
		try {
			click(L_search3);
			input(L_searchinput3, name);
			ExtentTestManager.getTest().log(Status.PASS, "Routed Chat Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Routed Chat Button not Clicked");
		}
	}
	
	public void clickandenterSearchMyChatHistory(String name) {
		try {
			click(L_search4);
			input(L_searchinput4, name);
			ExtentTestManager.getTest().log(Status.PASS, "Routed Chat Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Routed Chat Button not Clicked");
		}
	}
	
	public void clickOpenChatArrow() {
		try {
			click(L_box_openChat);
			ExtentTestManager.getTest().log(Status.PASS, "Chat Open Arrow Icon Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Chat Open Arrow Icon Not Clicked");
		}
	}
	
	public void enterMessage(String message) {
		try {
			input(L_box_chat_input, message);
			ExtentTestManager.getTest().log(Status.PASS, "Message Entered Successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Message Not Entered");
		}
	}
	
	public void clickSend() {
		try {
			jsClick(L_box_send_btn);
			ExtentTestManager.getTest().log(Status.PASS, "Send Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Send Button Not Clicked");
		}
	}
	
	public By L_actions = By.xpath("//span[.='Actions']");
	public By L_close = By.xpath("//button[.='Close']");
	public void clickClose() {
		try {
			jsClick(L_actions);
			click(L_close);
			ExtentTestManager.getTest().log(Status.PASS, "Close Option Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Close Option Not clicked");
		}
	}
	
	
	public By L_cancel = By.xpath("//div[.='Cancel']");
	public void clickCancel() {
		try {
			click(L_cancel);
			ExtentTestManager.getTest().log(Status.PASS, "Model Cancel Button clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Model Cancel Button Not clicked");
		}
	}
	
	public By L_chooseCategory = By.xpath("(//mat-select)[position()=1]");
	public By L_categoryOption = By.xpath("//span[@class='mat-option-text'][normalize-space()='General']");
	public void selectCategory() {
		try {
			click(L_chooseCategory);
			click(L_categoryOption);
			ExtentTestManager.getTest().log(Status.PASS, "Category Selected");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Category Not Selected");
		}
	}
	
	public By L_chooseSubCategory = By.xpath("(//mat-select)[position()=2]");
	public By L_subCategoryOption = By.xpath("//span[@class='mat-option-text'][normalize-space()='Category 1']");
	public void selectSubCategory() {
		try {
			click(L_chooseSubCategory);
			click(L_subCategoryOption);
			ExtentTestManager.getTest().log(Status.PASS, "Sub Category Selected");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Sub Category Not Selected");
		}
	}
	
	public By L_comment = By.xpath("//textarea[@data-placeholder='Ex. It makes me feel...']");
	public void enterComment(String comment) {
		try {
			input(L_comment, comment);
			ExtentTestManager.getTest().log(Status.PASS, "Comment Entered");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Comment Not Entered");
		}
	}
	
	public By L_submit = By.xpath("//div[.='Submit']");
	public void clickSubmit() {
		try {
			click(L_submit);
			ExtentTestManager.getTest().log(Status.PASS, "Submit Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "submit Button Not Clicked");
		}
	}
	
	
	public By L_preview = By.xpath("//mat-icon[.='sms']");
	public void clickPreview() {
		try {
			click(L_preview);
			ExtentTestManager.getTest().log(Status.PASS, "Preview Icon Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Preview Icon Not Clicked");
		}
	}
	
	
	public By L_mail = By.xpath("(//mat-icon[.=' mail_outline'])[1]");
	public void clickMailIcon() {
		try {
			click(L_mail);
			ExtentTestManager.getTest().log(Status.PASS, "Mail Icon Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Mail Icon Not Clicked");
		}
	}
	
	
	public By L_share = By.xpath("//span[.='Share']");
	public void clickShare() {
		try {
			click(L_share);
			ExtentTestManager.getTest().log(Status.PASS, "Share Icon Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Share Icon Not Clicked");
		}
	}
	
	public By L_mail_id = By.xpath("//textarea[@data-placeholder='Add semicolon to use multiple Email']");
	public void enterEmailID(String mailid) {
		try {
			input(L_mail_id, mailid);
			ExtentTestManager.getTest().log(Status.PASS, "Email ID Entered");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Email ID Not Entered");
		}
	}
	
	public By L_ticket_icon = By.xpath("//mat-icon[.='edit']");
	public void clickTicketIcon() {
		try {
			click(L_ticket_icon);
			ExtentTestManager.getTest().log(Status.PASS, "Ticket Icon Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Ticket Icon Not Clicked");
		}
	}
	
	//Ticket Create paths
	public By L_subject_field = By.xpath("//textarea[@data-placeholder='Ex. It makes me feel...']");
	public void enterSubject(String subject) {
		try {
			input(L_subject_field, subject);
			ExtentTestManager.getTest().log(Status.PASS, "Subject Entered");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Subject Not Entered");
		}
	}
	
	public By L_description_field = By.xpath("//textarea[@data-placeholder='Description']");
	public void enterDescription(String description) {
		try {
			input(L_description_field, description);
			ExtentTestManager.getTest().log(Status.PASS, "Description Entered");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Description Not Entered");
		}
	}
	
	public By L_category = By.xpath("//mat-label[.='Category']");
	public By L_category_option = By.xpath("//mat-option/span[.='General2']");
	public void selectTicketCategory() {
		try {
			click(L_category);
			click(L_category_option);
			ExtentTestManager.getTest().log(Status.PASS, "Category Selected");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Category Not Selected");
		}
	}
	
	public By L_priority = By.xpath("(//mat-select)[2]");
	public By L_priority_option = By.xpath("//mat-option/span[.='High']");
	public void selectTicketPriority() {
		try {
			click(L_priority);
			click(L_priority_option);
			ExtentTestManager.getTest().log(Status.PASS, "Priority Selected");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Priority Not Selected");
		}
	}
	
	public By L_status = By.xpath("(//mat-select)[3]");
	public By L_status_option = By.xpath("//mat-option/span[.='Active']");
	public void selectTicketStatus() {
		try {
			click(L_status);
			click(L_status_option);
			ExtentTestManager.getTest().log(Status.PASS, "Status Selected");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Status Not Selected");
		}
	}
	
	public By L_assignee = By.xpath("(//mat-select)[4]");
	public By L_assignee_option = By.xpath("//mat-option//span[@class='agent__name'][contains(text(), 'rajesh ganeshsupervisor')]");
	public void selectTicketAssignee() {
		try {
			click(L_assignee);
			click(L_assignee_option);
			ExtentTestManager.getTest().log(Status.PASS, "Assignee Selected");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Assignee Not Selected");
		}
	}
	
	public By L_quickreplyoption = By.xpath("(//div[contains(@class,'btn quickrpl__elements ng-star-inserted')])[1]");
	public void clickQuickReply() {
		try {
			click(L_quickreplyoption);
			ExtentTestManager.getTest().log(Status.PASS, "Quick Reply Selected");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Quick Reply Not Selected");
		}
	}
	
	
	public By L_transfer_icon = By.xpath("//mat-icon[contains(., 'call_made')]");
	public void clickTransferChat() {
		try {
			click(L_transfer_icon);
			ExtentTestManager.getTest().log(Status.PASS, "Chat Transfer Icon Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Chat Transfer Icon Not Clicked");
		}
	}
	
	public By L_toTransferAgent = By.xpath("//div[contains(@class,'group__wrapper') and .='Vijay Antony']");
	public void clickTransferChatTo() {
		try {
			click(L_toTransferAgent);
			ExtentTestManager.getTest().log(Status.PASS, "Clicked on Specific Agent");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Not Clicked on Specific Agent");
		}
	}
	
	
	public By L_card_view = By.xpath("//span[contains(normalize-space(),'Card view')]");
	public void clickCardView() {
		try {
			click(L_card_view);
			ExtentTestManager.getTest().log(Status.PASS, "Card View Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Card View Button Not Clicked");
		}
	}
	
	public By L_escalate_btn = By.xpath("//button[.='Escalate']");
	public void clickEscalate() {
		try {
			jsClick(L_actions);
			click(L_escalate_btn);
			ExtentTestManager.getTest().log(Status.PASS, "Escalate Button Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Escalate Button Not Clicked");
		}
	}
	
	public By L_escalate_choose_supervisor = By.xpath("(//mat-select)[1]");
	public void selectEscalateChooseSupervisor(String supervisor) {
		By L_escalate_choose_supervisor_option = By.xpath("//mat-option//span[@class='mat-option-text'][contains(text(), '"+supervisor+"')]");
		try {
			click(L_escalate_choose_supervisor);
			click(L_escalate_choose_supervisor_option);
			ExtentTestManager.getTest().log(Status.PASS, "Escalate Supervisor Name Selected");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Escalate Supervisor Name Not Selected");
		}
	}
	
	public By L_escalate_category = By.xpath("(//mat-select)[2]");
	public void selectEscalateCategory(String category) {
		By L_escalate_category_option = By.xpath("//mat-option//span[@class='mat-option-text'][contains(text(), '"+category+"')]");
		try {
			click(L_escalate_category);
			click(L_escalate_category_option);
			ExtentTestManager.getTest().log(Status.PASS, "Category Selected");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Category Not Selected");
		}
	}
	
	public By L_escalate_sub_category = By.xpath("(//mat-select)[3]");
	
	public void selectEscalateSubCategory(String subcategory) {
		By L_escalate_sub_category_option = By.xpath("//mat-option//span[@class='mat-option-text'][contains(text(), '"+subcategory+"')]");
		try {
			click(L_escalate_sub_category);
			click(L_escalate_sub_category_option);
			ExtentTestManager.getTest().log(Status.PASS, "Sub Category Selected");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Sub Category Not Selected");
		}
	}
	
	public By L_escalate_comment = By.xpath("//textarea");
	public void selectEscalateComment(String comment) {
		try {
			input(L_escalate_comment, comment);
			ExtentTestManager.getTest().log(Status.PASS, "Comment Entered");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Comment Not Entered");
		}
	}

	
	
}

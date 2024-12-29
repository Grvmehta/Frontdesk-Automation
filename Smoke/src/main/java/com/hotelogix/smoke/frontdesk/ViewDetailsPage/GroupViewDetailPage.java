package com.hotelogix.smoke.frontdesk.ViewDetailsPage;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class GroupViewDetailPage {
	
	
	
@FindBy(xpath="//input[@value='Enable Editing']")
public WebElement Btn_EnableEditing;


//@FindBy(xpath="//span[@class='panel-link']")
@FindBy(xpath="//i[@class='fa-regular fa-pen-to-square soft-edit']")
public WebElement Link_AddEditDetail;

@FindBy(xpath="//input[@id='srTxtFirstName']")
public WebElement TxtBx_Fname;


@FindBy(xpath="//input[@id='srTxtLastName']")
public WebElement TxtBx_LastName;


@FindBy(xpath="//input[@id='chkVipGst']")
public WebElement CB_markVipGuest;

@FindBy(xpath="//input[@id='chkBlGst']")
public WebElement CB_markBlackListed;


@FindBy(xpath="//input[@id='btnSave']")
public WebElement Btn_Save;

@FindBy(xpath="//img[@title='Black Listed']")
public WebElement Img_forBlackListedGuest;

@FindBy(xpath="//span[@title='VIP']")
public WebElement Lable_guestAsVIP;

@FindBy(xpath="//strong[@style='color:red;']")
public WebElement Txt_GuestIdForGroup;

@FindBy(xpath="//span[@class='colorblue']")
public WebElement Txt_groupOwnerName;



public ArrayList<String> guestFirstnLastname=new ArrayList<String> ();

public String fname;
public String lname;
public String gOwnerNameBeforeChange;
public String gOwnerNameAfterChange;











public GroupEnableEditingPage fn_clickOnEnableEditingBtn() throws Exception{
try{

GenericMethods.clickElement(Btn_EnableEditing);
}
catch(Exception e){
throw e;
}

GroupEnableEditingPage GEEP=PageFactory.initElements(GenericMethods.driver, GroupEnableEditingPage.class);

return GEEP;
}
	
	
	

public void fn_AddEditDetails() throws Exception{
try{
	gOwnerNameBeforeChange=GenericMethods.getText(Txt_groupOwnerName);
	Thread.sleep(2000);
	fname=GenericMethods.generateRandomString();
	lname=GenericMethods.generateRandomString();
GenericMethods.clickElement(Link_AddEditDetail);
Thread.sleep(2000);
GenericMethods.sendKeys(TxtBx_Fname, fname);
Thread.sleep(1000);
GenericMethods.sendKeys(TxtBx_LastName, lname);
GenericMethods.clickElement(CB_markVipGuest);
GenericMethods.clickElement(CB_markBlackListed);
GenericMethods.ActionOnAlert("Accept");
GenericMethods.clickElement(Btn_Save);
}
catch(Exception e){
throw e;
}
	
}



public ArrayList<String> fn_getEditedFirstNamenLastName(String nameString) throws Exception{
	try{
		
		String [] name=nameString.split("\\s+");
		String fname=name[1];
		String lname=name[2];
		guestFirstnLastname.add(fname);
		guestFirstnLastname.add(lname);
		
		
	}
	catch(Exception e){
		throw e;
	}
	return guestFirstnLastname;
	
}




	
}

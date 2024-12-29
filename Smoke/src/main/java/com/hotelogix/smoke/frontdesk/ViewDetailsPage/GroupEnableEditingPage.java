package com.hotelogix.smoke.frontdesk.ViewDetailsPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.frontdesk.FrontdeskHome.CheckinCard;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.FrontdeskLandingPage;
import com.hotelogix.smoke.frontdesk.Payment.AccountStatementLandingPage;
import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;
import com.itextpdf.text.log.SysoCounter;

public class GroupEnableEditingPage {
	
	
	ArrayList<String> al=new ArrayList<String> ();
	public ArrayList<String> gues1Detail=new ArrayList<String>(Arrays.asList("ab", "cd", "123"));
	public ArrayList<String> gues2Detail=new ArrayList<String>(Arrays.asList("ef", "gh", "456"));
	public ArrayList<String> guestName=new ArrayList<String> ();

	public float groupTotalrate;
	public String roomTypeToGroup;
	public String noOfAdultToGroup;
	public String headerEarlyCheckIn;
	public String alertForEarlyCheckin;
	public String noOfRoomsToGroup;
	public String noShowPopUpText;
	public String noShowPopUpHeader;
	public String noShowReason;
	public String HeaderTextInGRDis;
	public String unitPrice;
	public String discAmt;	
	
	
	
@FindBy(xpath="//table[@id='roomGrTableId']/tbody/tr")
public List<WebElement> AllGroupResRooms;

@FindBy(xpath="//table[@id='roomGrTableId']/tbody/tr[1]")
public WebElement AllGroupResRoomFirst;

@FindBy(xpath="(//div[@class='bc-heading']/h2)[5]")
public WebElement heading;

@FindBy(xpath="//fieldset[@id='fldGrpFinalAmount']")
public WebElement Text_TotalGroupPrice;

@FindBy(xpath="//input[@id='btnGrpSave']")
public WebElement Btn_saveGroupBooking;


@FindBy(xpath="//fieldset[starts-with(@id,'fldAttGstStr_')]")
public WebElement Link_AddGuestDetail;

@FindBy(xpath="//select[contains(@id,'txtSalutionAtG_')]")
public WebElement DD_Title;

@FindBy(xpath="//input[contains(@id,'txtFname')]")
public WebElement TxtBx_Fname;



@FindBy(xpath="//input[starts-with(@id,'txtLname')]")
public WebElement TxtBx_Lname;

@FindBy(xpath="//input[contains(@id,'txtPh')]")
public WebElement TxtBx_PhNum;

@FindBy(xpath="//input[contains(@id,'btnAttOk')]")
public WebElement Btn_Ok;

@FindBy(xpath="//table[@id='roomGrTableId']/tbody/tr[2]/td[6]/table/tbody/tr/td[1]")
public WebElement Text_guestName;

@FindBy(xpath="//input[@id='grAddNewRoom']")
public WebElement Btn_AddNewRoomToGroup;

@FindBy(xpath="//div[@id='PanelGrpNewRoom_h']/table/tbody/tr/td[1]")
public WebElement Header_AddNewRoom;

@FindBy(xpath="//select[@id='SelPnRmType']")
public WebElement DD_RoomType_AddNewRoom;

@FindBy(xpath="//select[@id='selAdultANR']")
public WebElement DD_Adult_AddNewRoom;

@FindBy(xpath="//select[@id='SelPnNoOfRm']")
public WebElement DD_Rooms_AddNewRoom;

@FindBy(xpath="//button[@id='pnBtnSave-button']")
public WebElement Btn_Add_AddnewRoom;


@FindBy(xpath="//input[starts-with(@id,'chkboxRes_')]")
public List<WebElement> CB_numberOfResPerRoom;


@FindBy(xpath="//input[@id='grCheckinRoom']")
public WebElement Btn_CheckInSelectedGroupRes;

@FindBy(xpath="//i[@class='fa-regular fa-trash-can small-edit']")
public WebElement Icon_deleteGroupRoom;

@FindBy(xpath="//input[@id='grEarlyCheckinRoom']")
public WebElement Btn_EarlyCheckInSelected;


@FindBy(xpath="//div[@id='PanelEarlyCheckinGRP_h']")
public WebElement Header_EarlyCheckIn;

@FindBy(xpath="//input[@id='selCnclReason']")
public WebElement TxtBx_ReasonToEarlyCheckIn;

@FindBy(xpath="//input[@id='txtCnclCharge']")
public WebElement TxtBx_ChargeForEarlyCheckIn;

@FindBy(xpath="//textarea[@id='txtCnclDesc']")
public WebElement TxtBx_DescriptionForEarlyCheckIn;

@FindBy(xpath="//button[@id='btnResCanSave-button']")
public WebElement Btn_SaveEarlyCheckIn;

@FindBy(xpath="//input[@id='grCancelNoShowSelected']")
public WebElement Btn_noShowSelected;

@FindBy(xpath="//input[@id='grCancelNoShowSelected']")
public WebElement Btn_cancelSelected;

@FindBy(xpath="//a[contains(text(),'Show Cancelled')]")
public WebElement Link_showCancelled;

@FindBy(xpath="//div[@id='PanelGroupCancelReservationSelected_h']")
public WebElement Header_NoShow;

@FindBy(xpath="//select[@id='selCnclReason']")
public WebElement DD_ReasonForNoShow_Cancel;

@FindBy(xpath="//input[@id='txtCnclCharge']")
public WebElement TxtBx_ChargeForNoShow_cancel;

@FindBy(xpath="//textarea[@id='txtCnclDesc']")
public WebElement TxtBx_DescriptionForNoShow_cancel;

@FindBy(xpath="//button[@id='btnGrpCanSave-button']")
public WebElement Btn_CancelNoShowReserv;

@FindBy(xpath="//input[@id='btnGrpBack']")
public WebElement Btn_Back;

@FindBy(xpath="//input[@id='BtnPaymentsCloseGrp']")
public WebElement Btn_CloseforGroup;

@FindBy(xpath="(//div[contains(text(),'Rs')])[1]//input")
public WebElement Link_RateInRateTypeForGroup;

@FindBy(xpath="//div[@id='PanelStandardRatesGR_h']")
public WebElement Header_StandardRatesForGroup;

@FindBy(xpath="(//td[@class='rite']//input)[1]")
public WebElement Text_UnitPriceForStandardRatesForGR;

@FindBy(xpath="//input[contains(@id,'srdTxtDiscount')]")
public WebElement TextBx_DiscountBox;

@FindBy(xpath="//input[contains(@id,'displayAmount')]")
public WebElement Text_AmountAfterDiscountAndTotalAmt;

@FindBy(xpath="//input[@value='PV']")
public WebElement RB_PercentageDiscountStandardRatesGR;

@FindBy(xpath="//input[@value='FV']")
public WebElement RB_FixDiscountStandardRatesGR;

@FindBy(xpath="//button[@id='srdBtnSave-button']")
public WebElement Btn_SaveDiscount;

@FindBy(xpath="//fieldset[@id='fldGrpDisc']")
public WebElement Text_givenDiscount;


@FindBy(xpath="//div[@id='sr-calContainerPopup']/table/tbody/tr/td/a")
public List<WebElement> Link_AllActiveDateTillCheckOut;



@FindBy(xpath="//table[@id='sr-calContainerPopup_t']/tbody/tr")
public List<WebElement> CurrentWeek;

@FindBy(xpath="//fieldset[@id='changeLink']")
public WebElement Link_ChangePayTerms;


@FindBy(xpath="(//div[@class='bc-heading']//h2)[7]")
public WebElement heading_Payterms;

@FindBy(xpath="//select[@id='paidTypeGr']")
public WebElement DD_PayTerms;

@FindBy(xpath="//fieldset[@id='changeLink']")
public WebElement Text_PayTerm;

@FindBy(xpath="//input[@id='btnGrpPayments']")
public WebElement Btn_GroupPayment;


@FindBy(xpath="//input[@id='btnGrpCheckIn']")
public WebElement Btn_GroupCheckIn;


public CheckinCard fn_ClickOnGroupCheckInBtn() throws Exception{
try{
GenericMethods.clickElement(Btn_GroupCheckIn);
GenericMethods.ActionOnAlert("Accept");
GenericMethods.ActionOnAlert("Accept");
	
}
catch(Exception e){
throw e;
}
CheckinCard CC=PageFactory.initElements(GenericMethods.driver, CheckinCard.class);
return CC;
}





public AccountStatementLandingPage fn_ClickOnGroupPayment() throws Exception{
	try{
		
		
		GenericMethods.clickElement(Btn_GroupPayment);
	}
	catch(Exception e){
		throw e;
	}
	
	AccountStatementLandingPage ASL=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
	return ASL;
	
}
public FrontdeskLandingPage fn_ChangePayTerms(int iTestCaseRow) throws Exception{
try{
	Thread.sleep(2000);
	GenericMethods.javascriptScroll(heading_Payterms);
	String pt=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PayTerms));
	Thread.sleep(2000);
    GenericMethods.clickElement(Link_ChangePayTerms);	
	Thread.sleep(2000);
	GenericMethods.selectElement(DD_PayTerms, pt);
	Thread.sleep(2000);
	GenericMethods.clickElement(Btn_saveGroupBooking);

}
catch(Exception e){
throw e;
}
FrontdeskLandingPage FLP=PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
return FLP;
}


	public void fn_ChangeCheckOutDate(String ResId,int checkOutDayBefore) throws Exception{
	   try{
		   GenericMethods.javascriptScroll(AllGroupResRoomFirst);
		int roomCount=AllGroupResRooms.size();
		for(int i=2;i<=roomCount;i++){
		Thread.sleep(2000);
		String resID=GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[3]")).getText().trim();
		if(resID.equals(ResId))	{
			Thread.sleep(2000);
		//	GenericMethods.javascriptScroll(GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[8]/span[2]")));
			GenericMethods.scrollUp("250");
			GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[8]/span[2]")).click();
			int l=Link_AllActiveDateTillCheckOut.size();
		    Link_AllActiveDateTillCheckOut.get((0)).click();
			System.out.println(Link_AllActiveDateTillCheckOut.get((0)));
			
			//WebElement we=GenericMethods.driver.findElement(By.xpath("//div[@id='sr-calContainerPopup']/table/tbody/tr[3]/td[2]"));
            //we.click();
		    Thread.sleep(2000);
		    break;
	     }
		 }
	     }catch(Exception e){
		    throw e;
		}
	}



	public void fn_ChangeCheckInDate(String ResID,int CheckinDayLtr) throws Exception{
	 try{
		int roomCount=AllGroupResRooms.size();
		System.out.println(roomCount);
		for(int i=2;i<=roomCount;i++){
		Thread.sleep(2000);
		String resID=GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[3]")).getText().trim();
		System.out.println("Get text res id is:"+resID);
		if(resID.equals(ResID))	{
			System.out.println("In IF");
			GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[8]/span[1]")).click();
			int l=Link_AllActiveDateTillCheckOut.size();
			System.out.println(l);
			
		
			    //WebElement we=GenericMethods.driver.findElement(By.xpath("//div[@id='sr-calContainerPopup']/table/tbody/tr[3]/td[2]"));
                //we.click();
			    
	     for(int j=0;i<=l-1;j++ ){
			if(j==CheckinDayLtr){
			String b=Link_AllActiveDateTillCheckOut.get(j).getText();
			System.out.println("CheckIn for:" + b + " Date ");
			GenericMethods.javascriptScroll(Link_AllActiveDateTillCheckOut.get(j));
			Link_AllActiveDateTillCheckOut.get(j).click();
			GenericMethods.javascriptScroll(GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr[2]/td[3]")));
			break;
	       }
			else{
				System.out.println("Date is:" + Link_AllActiveDateTillCheckOut.get(j).getText());		}
		}
		}
	        break;
		}
		}catch(Exception e){
		     throw e;
		}
		}



	public String fn_getCheckInCheckOutDates(String ResID) throws Exception{
		String stayDateRange=null;
	    try{
		int roomCount=AllGroupResRooms.size();
		for(int i=2;i<=roomCount;i++){
		Thread.sleep(2000);
		String resID=GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[3]")).getText().trim();
		System.out.println("PASS");
		Thread.sleep(2000);
		if(resID.equals(ResID)){
			stayDateRange=GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[8]")).getText().trim();
		break;
		}
		}
		}
		catch(Exception e){
		throw e;
		}
		return stayDateRange;
		}





public void fn_GiveDiscountInStandardRateForGR() throws Exception{
	 discAmt="1";
try{

HeaderTextInGRDis=GenericMethods.getText(Header_StandardRatesForGroup).trim();
unitPrice=GenericMethods.GetWebElementAttributeValue(Text_UnitPriceForStandardRatesForGR, "value");
GenericMethods.clickElement(RB_FixDiscountStandardRatesGR);
GenericMethods.sendKeys(TextBx_DiscountBox, discAmt+Keys.chord(Keys.ENTER));
Thread.sleep(2000);
GenericMethods.clickElement(Btn_SaveDiscount);
Thread.sleep(1000);
}
catch(Exception e){
throw e;
}
}



public FrontdeskLandingPage fn_cancelAndNoShowRes(String resvId) throws Exception{
try{
int roomCount=AllGroupResRooms.size();
for(int i=2;i<=roomCount;i++){
Thread.sleep(2000);
String resID=GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[3]")).getText().trim();
if(resID.equals(resvId)){
	GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[2]/input")).click();
	break;
}
}
}
catch(NoSuchElementException e){
throw e;
}
try{
GenericMethods.clickElement(Btn_noShowSelected);
GenericMethods.ActionOnAlert("Accept");
noShowPopUpText=GenericMethods.value;
}
catch(NoSuchElementException e){
	GenericMethods.clickElement(Btn_cancelSelected);
	GenericMethods.ActionOnAlert("Accept");
	noShowPopUpText=GenericMethods.value;
}
try{
noShowPopUpHeader=GenericMethods.getText(Header_NoShow).trim();
noShowReason=GenericMethods.selectValueFromDropdownUsingIndex(DD_ReasonForNoShow_Cancel, 1);
GenericMethods.sendKeys(TxtBx_ChargeForNoShow_cancel, "0");
GenericMethods.sendKeys(TxtBx_DescriptionForNoShow_cancel, "No show for some reason");
GenericMethods.clickElement(Btn_CancelNoShowReserv);
Thread.sleep(4000);
GenericMethods.javascriptScroll(GenericMethods.driver.findElement(By.xpath("//input[@id='BtnPaymentsCloseGrp']")));
Thread.sleep(3000);
GenericMethods.driver.findElement(By.xpath("//input[@id='BtnPaymentsCloseGrp']")).click();
}
catch(Exception e){
throw e;
}
FrontdeskLandingPage FP=PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
return FP;
}



public void fn_addNewRoomToGroup() throws Exception{
try{
roomTypeToGroup=GenericMethods.selectValueFromDropdownUsingIndex(DD_RoomType_AddNewRoom, 1);
Thread.sleep(2000);
noOfAdultToGroup=GenericMethods.selectValueFromDropdownUsingIndex(DD_Adult_AddNewRoom, 1);
Thread.sleep(2000);
noOfRoomsToGroup=GenericMethods.selectValueFromDropdownUsingIndex(DD_Rooms_AddNewRoom, 1);
Thread.sleep(2000);
GenericMethods.clickElement(Btn_Add_AddnewRoom);
}
catch(Exception e){
throw e;
}
}

public FrontdeskLandingPage fn_CheckInSelectedGroupRes(String resId) throws Exception{
try{
	int roomCount=AllGroupResRooms.size();
	for(int i=2;i<=roomCount;i++){
	Thread.sleep(2000);
	String resID=GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[3]")).getText().trim();
	if(resID.equals(resId)){
		 GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[2]/input")).click();
		 GenericMethods.clickElement(Btn_CheckInSelectedGroupRes);
		 Thread.sleep(1000);
		 GenericMethods.ActionOnAlert("Accept");
		 Thread.sleep(1000);
		 GenericMethods.ActionOnAlert("Accept");
         break;
}
}
}
catch(Exception e){
throw e;
}
FrontdeskLandingPage FP=PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
return FP;
}







public String fn_getResStatus(String id) throws Exception{
String stat="";
System.out.println("id::::::::"+id);
try{
	int roomCount=AllGroupResRooms.size();
	System.out.println("roomCount:::::::::"+roomCount);
	for(int i=2;i<=roomCount;i++){
	Thread.sleep(2000);
	String resId=GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[3]")).getText().trim();
	System.out.println("resid::::"+resId);
	if(resId.endsWith(id)){
		 stat=GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[9]")).getText().trim();
			System.out.println("stat::::"+stat);
		 break;
	}
}
}
catch(Exception e){
	throw e;
}
return stat;
}




public ArrayList<String> fn_getGuestFirstNLastName(String nameString) throws Exception{
try{
		
	String [] name=nameString.split("\\s+");
	String fname=name[1];
	String lname=name[2];
	guestName.add(fname);
	guestName.add(lname);
}
catch(Exception e){
throw e;
}
return guestName;
	
}



public String fn_getGuestName(String resevId) throws Exception{
	String gname=null;
try{

	int roomCount=AllGroupResRooms.size();
	for(int i=2;i<=roomCount;i++){
	Thread.sleep(3000);
	String resId=GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[3]")).getText().trim();
	if(resId.equals(resevId)){
		Thread.sleep(3000);
		 gname=GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[6]/table/tbody/tr/td[1]")).getText().trim();
	     break;
	}
	
}
}
catch(Exception e){
	throw e;
}
return gname;
}


	public void fn_addGuestDetails(String resvId,ArrayList<String> guestDetail) throws Exception{
		try{
		int roomCount=AllGroupResRooms.size();
		for(int i=2;i<=roomCount;i++){
		Thread.sleep(7000);
		String resId=GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[3]")).getText().trim();
		if(resId.equals(resvId)){
			GenericMethods.javascriptScroll(GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[6]/fieldset[2]")));
			GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[6]/fieldset[2]")).click();
			Thread.sleep(5000);
			GenericMethods.selectElementByIndex(DD_Title, 1);
			Thread.sleep(1000);
		//	GenericMethods.js_Sendkey(TxtBx_Fname, guestDetail.get(0).toString());
			String name=guestDetail.get(0).toString();
			
			JavascriptExecutor myExecutor = ((JavascriptExecutor) GenericMethods.driver);
		    myExecutor.executeScript("document.getElementById('txtFname0').value= '"+name+"';");
			Thread.sleep(3000);
			GenericMethods.js_Sendkey(TxtBx_Lname, guestDetail.get(1).toString());
			Thread.sleep(3000);
			GenericMethods.js_Sendkey(TxtBx_PhNum, guestDetail.get(2).toString());
			Thread.sleep(3000);
			GenericMethods.driver.findElement(By.xpath("//input[contains(@value,'OK')]")).click();
		
			Thread.sleep(3000);
			break;
		}
		}
		}
		catch(Exception e){
			throw e;
		}
	}

	public void fn_addGuestDetails1(String resvId,ArrayList<String> guestDetail) throws Exception{
		try{
		int roomCount=AllGroupResRooms.size();
		for(int i=2;i<=roomCount;i++){
		Thread.sleep(4000);
		String resId=GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[3]")).getText().trim();
		if(resId.equals(resvId)){
			
			GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[6]/fieldset[2]")).click();
			Thread.sleep(5000);
			GenericMethods.selectElementByIndex(DD_Title, 1);
			Thread.sleep(4000);
		//	GenericMethods.js_Sendkey(TxtBx_Fname, guestDetail.get(0).toString());
			String name=guestDetail.get(0).toString();
			
			JavascriptExecutor myExecutor = ((JavascriptExecutor) GenericMethods.driver);
		    myExecutor.executeScript("document.getElementById('txtFname1').value= '"+name+"';");
			Thread.sleep(3000);
			GenericMethods.js_Sendkey(TxtBx_Lname, guestDetail.get(1).toString());
			Thread.sleep(3000);
			GenericMethods.js_Sendkey(TxtBx_PhNum, guestDetail.get(2).toString());
			Thread.sleep(3000);
			GenericMethods.driver.findElement(By.xpath("//input[contains(@value,'OK')]")).click();
		
			Thread.sleep(6000);
			break;
		}
		}
		}
		catch(Exception e){
			throw e;
		}
	}



public FrontdeskLandingPage fn_clickOnSaveBtn() throws Exception{
	try{
	GenericMethods.clickElement(Btn_saveGroupBooking);		
	}
	catch(Exception e){
	throw e;
	}
	FrontdeskLandingPage FLP=PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
	return FLP;
}
	

public  ArrayList<String> getGroupResIds() throws Exception{
	
	ArrayList<String> al=new ArrayList<String> ();
try{
	Thread.sleep(3000);
int roomCount=AllGroupResRooms.size();
System.out.println("roomCount::::::::"+roomCount);
roomCount=roomCount;
for(int i=2;i<=roomCount;i++){
Thread.sleep(4000);
//GenericMethods.javascriptScroll(GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[3]")));
GenericMethods.javascriptScroll(heading);
String resId=GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[3]")).getText().trim();
Thread.sleep(2000);
al.add(resId);
}
Thread.sleep(2000);
groupTotalrate=GenericMethods.fn_getRateFromRateString(GenericMethods.getText(Text_TotalGroupPrice).trim());

}

catch(Exception e){
throw e;
}
return al;
}


public float getTotalPrice() throws Exception{
try{
	String rs=GenericMethods.getText(Text_TotalGroupPrice).trim();
	Thread.sleep(2000);
    groupTotalrate=GenericMethods.fn_getRateFromRateString(rs);	
}
catch(Exception e){
throw e;
}
return groupTotalrate;
}

	
	
public GroupToSingleReservationPage fn_moveFromGroupToSingle(String resId) throws Exception{
try{
	int roomCount=AllGroupResRooms.size();
	System.out.println("roomcount::::"+roomCount);
	
	for(int i=2;i<=roomCount;i++){
	Thread.sleep(2000);
	String resid=GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[3]")).getText().trim();
	if(resId.equals(resid)){
System.out.println("in if");
		WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[3]"));
		GenericMethods.js_Click(ele);
		System.out.println("clickedddddd");
		break;
	}
}
}
catch(Exception e){
throw e;
}

GroupToSingleReservationPage GTS=PageFactory.initElements(GenericMethods.driver, GroupToSingleReservationPage.class);
return GTS;
}

	public void fn_earlyCheckInSelected(String resId) throws Exception {
	 try{
		int roomCount=AllGroupResRooms.size();
		for(int i=2;i<=roomCount;i++){
		Thread.sleep(2000);
		String resID=GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[3]")).getText().trim();
		if(resID.equals(resId)){
			 GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[2]/input")).click();
			 GenericMethods.clickElement(Btn_EarlyCheckInSelected);
			 Thread.sleep(1000);
			 headerEarlyCheckIn=GenericMethods.getText(Header_EarlyCheckIn);
			 GenericMethods.sendKeys(TxtBx_ReasonToEarlyCheckIn, "Early reach");
			 Thread.sleep(1000);
			 GenericMethods.sendKeys(TxtBx_ChargeForEarlyCheckIn, "0");
			 Thread.sleep(1000);
			 GenericMethods.sendKeys(TxtBx_DescriptionForEarlyCheckIn, "Due to the early reach");
			 Thread.sleep(1000);
			 GenericMethods.clickElement(Btn_SaveEarlyCheckIn);
			 GenericMethods.ActionOnAlert("Accept");
			 GenericMethods.AcceptAlertAfterValidate();
			 alertForEarlyCheckin=GenericMethods.value;
	         break;
		}
		}	
		}
		catch(Exception e){
			throw e;
		}
		
	}



	



	
	
	

}

package com.hotelogix.smoke.frontdesk.ViewDetailsPage;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.internal.EventFiringKeyboard;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.hotelogix.smoke.frontdesk.FrontdeskHome.CheckinCard;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.FrontdeskLandingPage;
import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;
import com.itextpdf.awt.geom.misc.RenderingHints.Key;




public class EnableEditingPage {
	
	
	
	

ArrayList<Double>  TaxPer= new ArrayList<Double>();
public static double TaxExBal;

static double sum=0;
static double totalTaxPercent=0;
static double totalamt1=0;
public  static String frmMonth;
public static String frmYear;
public static String frmDate;


@FindBy(xpath="//fieldset[text()='Room Tax(es)']")
public static WebElement RoomTaxes;

@FindBy(xpath="//div[starts-with(text(),'Standard')]")
public static WebElement stdRateGrp_Title;

@FindBy(xpath="//select[@id='taxExmptReson']")
public static WebElement TaxExemptDropdown;

@FindBy(xpath="//table[@class='pnl_rates']//input[@type='checkbox']")
public static List<WebElement> AllTaxesToExempt;


@FindBy(xpath="//table[@class='pnl_rates']//tr")
public static List<WebElement> AllTheTaxes;

@FindBy(xpath="//fieldset[@id='resLblRoomTariff']")
public static WebElement RoomRate;

@FindBy(xpath="//fieldset[@id='resLblBalance']")
public static WebElement TotalBalance;


@FindBy(xpath="//select[@id='SelPnRmType']")
public static WebElement AddNewRoomTypeForGroupDropdown;

@FindBy(xpath="//input[@id='grAddNewRoom']")
public static WebElement AddNewRoomG;

@FindBy(xpath="//select[@id='SelPnNoOfRm']")
public static WebElement RoomsDropdownInAddNewRoom;

@FindBy(xpath="//button[@id='pnBtnSave-button']")
public static WebElement AddBtn;

@FindBy(xpath="//select[@id='selAdultANR']")
public static WebElement AdultSelectionDD;


@FindBy(xpath="//input[@type='checkbox']")
public static List<WebElement> AllAddedRoom;


@FindBy(xpath="//input[@id='grEarlyCheckinRoom']")
public static WebElement EarlyCheckInSelectedBtn;


@FindBy(xpath="//div[text()='Early Checkin']")
public static WebElement EarlyCheckInTitle;

@FindBy(xpath="//input[@id='selCnclReason']")
public static WebElement ReasonForEarlyCheckIn;

@FindBy(xpath="//button[@id='btnResCanSave-button']")
public static WebElement EarlyCheckinBtn;

@FindBy(xpath="//input[@id='txtCnclCharge']")
public static WebElement txtbox_EarlyCheckinCharge;

@FindBy(xpath="//fieldset[@id='dvStrRsvStatus_0']")
public static WebElement StatusForGroupReservation;


@FindBy(xpath="//select[@id='selRsvStgr0']")
public static WebElement SelectReservationStatus;


@FindBy(xpath="//input[@id='grCancelNoShowSelected']")
public static WebElement NoShowSelected;

@FindBy(xpath="//div[text()='Cancel/No-Show Selected Reservation']")
public static WebElement NoShowPopUpTitle;

@FindBy(xpath="//select[@id='selCnclReason']")
public static WebElement NoShowReasonDropDown;


@FindBy(xpath="//textarea[@id='txtCnclDesc']")
public static WebElement  NoShowDescription;

@FindBy(xpath="//button[@id='btnGrpCanSave-button']")
public static WebElement NoShowButton;

@FindBy(xpath="//td[@class='rite panel-link']//input[@id='linkStandardRateGR']")
public static WebElement PriceLink;

@FindBy(xpath="//input[@id='srdTxtDiscount0']")
public static WebElement DiscountTextBox;

@FindBy(xpath="//button[@id='srdBtnSave-button']")
public static WebElement DiscountDoneBtn;

@FindBy(xpath="//input[@id='btnGrpSave']")
public static WebElement SaveReservationBtn;

@FindBy(xpath="//a[text()='Manage Sharer(s) ']")
public static WebElement ManageSharerLink;

@FindBy(xpath="//table[@class='table-cellspacing-patch']//tbody//tr")
public static List<WebElement> Sharers;

@FindBy(xpath="//button[@id='rsBtnSave-button']")
public static WebElement SaveBtnForManageSharer;

@FindBy(xpath="//div[@class='calheader']//a[2]")
public static WebElement ChooseMonYear ;

@FindBy(xpath="//div[@class='yui-cal-nav']/div/select")
public static WebElement select_FrmMnth;

@FindBy(xpath="//div[@class='yui-cal-nav']//div/input")
public static WebElement enterFrmYear;

@FindBy(xpath="//div[@class='yui-cal-nav']//div/span/button[text()='Ok']")
public static WebElement okButton_Frmcalander;

@FindBy(xpath="//table[@id='sr-calContainerPopup_t']/tbody")
public static WebElement chartfrom;

@FindBy(xpath="//table[@id='roomGrTableId']/tbody/tr[2]/td[8]")
public static WebElement CheckInCheckOut;

@FindBy(xpath="//table[@id='roomGrTableId']/tbody/tr[2]/td[8]/span[1]")
public static WebElement CheckInDate;

@FindBy(xpath="//fieldset[@id='changeLink']")
public static WebElement ChangePayTerm;

@FindBy(xpath="//select[@id='paidTypeGr']")
public static WebElement PayTermDropDown;

@FindBy(xpath="//input[@name='btnRsvSave']")
public static WebElement Save_Btn;

@FindBy(xpath="//fieldset[@id='resLblDiscount']")
public static WebElement actualDisc;

@FindBy(xpath="//button[@id='srdBtnSave-button']")
public static WebElement doneBtn;

@FindBy(xpath="//input[@id='btnGrpSave']")
public static WebElement SaveChangesBtn;

@FindBy(xpath="//button[@id='grpTaxExempt-button']")
public static WebElement GroupTaxExempt;

@FindBy(xpath="//div[@class='frn_inclusions']//i")
public static WebElement addedIncl_txt;

@FindBy(xpath="//fieldset[@id='resLblInclusions']")
public static WebElement added_inclPrice;

@FindBy(xpath="//a[contains(@onclick,'RatesPackagesDate_Click')]")
public static WebElement date_lnk;

@FindBy(xpath="//input[contains(@ondblclick,'appPanels.StandardRates_Click')]")
public static WebElement beforeSplitPrice;

@FindBy(xpath="//table[@class='frn_ratestbl']//tr[2]//td[3]/input")
public static WebElement afterSplitPrice;

@FindBy(xpath="//table[@id='sr-calContainerPopup_t']//tr[5]//td[5]//a")
public static WebElement splitDate;

@FindBy(xpath="//span[@id='singleGuestEditSpan']")
public static WebElement addEditDetails;

@FindBy(xpath="//div[@id='PanelGuestDetails_h']")
public static WebElement detailForm_title;

@FindBy(xpath="//input[@name='srTxtFirstName']")
public static WebElement frstName;

@FindBy(xpath="//input[@name='srTxtLastName']")
public static WebElement lastName;

@FindBy(xpath="//input[@id='phoneNo']")
public static WebElement phone;

@FindBy(xpath="//button[@id='btnSave-button']")
public static WebElement saveBtn;

@FindBy(xpath="//td[@class='lineheight size13']//span[2]")
public static WebElement editedName;

@FindBy(xpath="//select[@name='extraBeds']")
public static WebElement extraBed;

@FindBy(xpath="//table[@class='pnl_rates']//tr[2]//td[5]//input[@id='srdTxtDiscount0']")
// @FindBy(xpath="//input[@name='srdTxtDiscount0']c
 public static WebElement discount;

@FindBy(xpath="//span[text()='Rack Rate']")
public static WebElement RackRate;

@FindBy(xpath="//input[@name='displayAmount0']")
public static WebElement amount;

@FindBy(xpath="//table[@id='roomGrTableId']//tr[2]//td[6]//table//td[1]")
public static WebElement guestName;

@FindBy(xpath="//table[@id='roomGrTableId']//tr")
public static List<WebElement> rowcount;

@FindBy(xpath="//input[@value='Check-In Selected']")
public static WebElement checkinSelected;

@FindBy(xpath="//input[@value='Add New Room(s)']")
public static WebElement addNewRoombtn;

@FindBy(xpath="//div[@id='PanelGrpNewRoom_h']//tr//td")
public static WebElement addNewRoomTitle;

@FindBy(xpath="//a[@class='container-close']")
public static WebElement closeBtn;

@FindBy(xpath="//input[@name='btnGrpSave']")
public static WebElement grpSave;

@FindBy(xpath="//table[@id='roomGrTableId']//tr[2]//td[2]//input")
public static WebElement checkboxTE;

@FindBy(xpath="//table[@id='roomGrTableId']//tr")
public static List<WebElement> chkboxCount;

@FindBy(xpath="//select[@name='SelPnRmType']")
public static WebElement roomTypeDD;

@FindBy(xpath="//select[@name='selAdultANR']")
public static WebElement adultDD;

@FindBy(xpath="//select[@name='selChildANR']")
public static WebElement childDD;

@FindBy(xpath="//select[@name='SelPnNoOfRm']")
public static WebElement roomsDD;

@FindBy(xpath="//button[@id='pnBtnSave-button']")
public static WebElement addBtn;

@FindBy(xpath="//button[@id='grpTaxExempt-button']")
public static WebElement taxExempt;

@FindBy(xpath="//div[@id='PanelTaxExemptGR_h']//td[1]")
public static WebElement taxEexemptTitle;

@FindBy(xpath="//table[@id='roomGrTableId']//tr[2]//td[3]")
public static WebElement RoomReservationID;

@FindBy(xpath="//div[text()='Select Add-ons']")
public static WebElement InclusionAddOns_TitleTAB;

@FindBy(xpath="//select[@id='availIncId']//option")
public static WebElement inclusionname;

@FindBy(xpath="//input[@type='button']")
public static WebElement RightArrow_BT;



@FindBy(xpath="//fieldset[@id='fldGrpRateAndPkg']//i")
public static WebElement InclusionName_besideAddInclu;


@FindBy(xpath="//table[@id='roomGrTableId']//tr[2]//td[11]//input")
public static WebElement SingleGuestPrice_ED;

@FindBy(xpath="//td[text()='Preferences']")
public static WebElement BlackClick;

@FindBy(xpath="//table[@id='roomGrTableId']//tr[2]//td[5]")
public static WebElement AddGuestDetails_Link;

@FindBy(xpath="//table[@id='roomGrTableId']//tr[2]//td[6]")
public static WebElement GuestName_TX;

@FindBy(xpath="//div[@class='clear-yell-img']")
public static WebElement Clear_Link;

@FindBy(xpath="//table[@id='roomGrTableId']//tr[2]//td[9]//fieldset[2]")
public static WebElement Status_Link;


@FindBy(xpath="//table[@id='roomGrTableId']//tr[2]//td[8]//span[2]")
public static WebElement FirstGuestCheckoutDate_Link;

@FindBy(xpath="//table[@id='sr-calContainerPopup_t']//tr//td//a")
public static WebElement FirstGuestCheckoutDate_InCal;

@FindBy(xpath="//table[@id='roomGrTableId']//tr[3]//td[8]//span[2]")
public static WebElement SecondGuestCheckoutDate_Link;

@FindBy(xpath="//table[@id='sr-calContainerPopup_t']//tr[2]//td//a")
public static WebElement SecondGuestCheckoutDate_InCal;

@FindBy(xpath="//table[@id='sr-calContainerPopup_t']//tr[2]//td[2]//a")
public static WebElement PreviousCheckoutDate_InCal;

@FindBy(xpath="//table[@id='roomGrTableId']//tr[2]//td[2]/input")
public static WebElement FirstGuestCheckBox_CB;

@FindBy(xpath="//button[@id='grpTaxExempt-button']")
public static WebElement TaxExampt_BT;

@FindBy(xpath="//div[@id='PanelTaxExemptGR_h']//tr//td")
public static WebElement TaxExamptPopUp_Box;

@FindBy(xpath="//select[@id='taxExmptReson']")
public static WebElement TaxExemptReason_DD;

@FindBy(xpath="//button[@id='txExmptBtnSave-button']")
public static WebElement TaxExemptOKBT_InPopUp;

@FindBy(xpath="//div[@id='grImgCal1']")
public static WebElement CalIconz;

@FindBy(xpath="//table[@id='roomGrTableId']/tbody/tr")
public static List<WebElement> RoomsInGroup;

@FindBy(xpath="//input[@id='grCancelNoShowSelected']")
public static WebElement NoShowSelect;

@FindBy(xpath="//select[@id='selCnclReason']")
public static WebElement NoShowReason;

@FindBy(xpath="//textarea[@id='txtCnclDesc']")
public static WebElement NoShowDesc;

@FindBy(xpath="//button[@id='btnGrpCanSave-button']")
public static WebElement NoShowReservationBtn;

@FindBy(xpath="//span[@class='tname']")
public static WebElement TabTitle;

@FindBy(xpath="//input[@id='btnRsvSave']")
public static WebElement  resrvBtn;

@FindBy(xpath="//input[@id='fNameGr']")
public static WebElement fnameGrp;

@FindBy(xpath="//input[@id='lNameGr']")
public static WebElement lnameGrp;

@FindBy(xpath="//input[@id='phoneNoGr']")
public static WebElement phGrp;

@FindBy(xpath="//select[@id='groupOwner']")
public static WebElement grpOwner;

@FindBy(xpath="//input[@id='travelAgent']")
public static WebElement taName;

@FindBy(xpath="//input[@id='cNameGr']")
public static WebElement compName;

@FindBy(xpath="//select[@id='salutationGr']")
public static WebElement salutation;

@FindBy(xpath="//table[@class='pnl_rates']//tr[2]//td[4]//span")
public static WebElement chkbox_TEValue;

@FindBy(xpath="//fieldset[@id='fldGrpTax']")
public static WebElement txt_Tax;

@FindBy(xpath="//input[@id='discountTypeP0']")
public static WebElement rb_disc;

@FindBy(xpath="//span[contains(@onclick,'changeDateGR_Click')]")
public static WebElement date_ChkInRoom;

@FindBy(xpath="//a[@id='link-selectInclusions']")
public WebElement Link_InclusionAddOns;

//------------------------------------------------------------------------------------------------




@FindBy(xpath="//select[@name='extraBeds']")
public WebElement DD_extraBed;

@FindBy(xpath="//input[@name='btnCheckIn']")
public WebElement Btn_CheckIn;

//@FindBy(xpath="//div[@class='frn_inclusions']/span/i")
@FindBy(xpath="//div[@class='frn_inclusions']//span//span")
public WebElement Txt_AddedAddon;

//@FindBy(xpath="//span[@id='singleGuestEditSpan']")
@FindBy(xpath="//i[@id='singleGuestEditSpan']")
public WebElement Link_GuestEditDetailforSingleRes;

@FindBy(xpath="//input[@id='srTxtFirstName']")
public WebElement TxtbxguestInfo_fName;

@FindBy(xpath="//input[@id='srTxtLastName']")
public WebElement TxtbxguestInfo_lName;

@FindBy(xpath="//button[@id='btnSave-button']")
public WebElement BtnguestInfo_Save;

@FindBy(xpath="//input[@id='btnRsvSave']")
public WebElement BtnEnableEditing_SaveSingleRes;

//@FindBy(xpath="//table[@class='frn_ratestbl']/tbody/tr/td/a")
@FindBy(xpath="//a[@id='linkRatesPackagesDate']")
public WebElement Link_ToDateForSplit;

@FindBy(xpath="//table[@id='sr-calContainerPopup_t']/tbody/tr/td/a")
public WebElement Link_ActiveSplitDate;

//@FindBy(xpath="//table[@class='frn_ratestbl']/tbody/tr/td/fieldset")
@FindBy(xpath="//fieldset[@id='ratesPackage']//div[@class='rate-type-2n5 ']")
public List<WebElement> Txt_SplitedDays;

@FindBy(xpath="//input[@id='link-standardRates']")
public List<WebElement> Txt_StandardPriceforSplitedDays;

@FindBy(xpath="//input[@id='link-standardRates']")
public WebElement Text_stdRate;

@FindBy(xpath="//a[contains(@id,'guestPrefrenceView')]")
public WebElement link_View;

@FindBy(xpath="//fieldset[@id='srPaymentDetailsSection']/table//tbody//tr[2]/td/table/tbody/tr[8]/td[2]/fieldset")
public WebElement Text_DiscountAmt;


@FindBy(xpath="//table[@class='frn_ratestbl']/tbody/tr/th[1]")
public WebElement Click_OnFreeSpace;

@FindBy(xpath="//a[@id='link-roomSharers']")
public WebElement Link_ManageSharer;

@FindBy(xpath="//select[@id='srSelTitle2']")
public WebElement DD_SecondaryGuestSalutation;

@FindBy(xpath="//input[@id='fName2']")
public WebElement Txtbx_SecondaryGuestFname;

@FindBy(xpath="//input[@id='lName2']")
public WebElement Txtbx_SecondaryGuestLname;

@FindBy(xpath="//input[@id='phoneNo2']")
public WebElement Txtbx_SecondaryGuestPhNum;

@FindBy(xpath="//button[@id='rsBtnSave-button']")
public WebElement Btn_SaveGuestDetail;

@FindBy(xpath="//input[@id='chargeSharer2']")
public WebElement CB_sChargeSharer;

//@FindBy(xpath="//div[@class='padd-left']/i")
@FindBy(xpath="//div[@class='rate-addons-2n5']/i[2]")
public WebElement Text_AddOnInclusion;

@FindBy(xpath="//div[@id='PanelSelectInclusionsGR_h']")
public WebElement Header_SelectAddOn;

@FindBy(xpath="//select[@id='availIncId']")
public WebElement SelectBx_avlAddOns;

@FindBy(xpath="//select[@id='incId']")
public WebElement SelectBx_placedAddOns;

@FindBy(xpath="//input[contains(@value,'>>')]")
public WebElement Btn_moveToPlacedAddOns;

@FindBy(xpath="//input[contains(@value,'<<')]")
public WebElement Btn_moveToAvlAddOns;

@FindBy(xpath="//button[@id='inclusionSave-button']")
public  WebElement Btn_saveInclusion;

//@FindBy(xpath="//fieldset[@id='fldGrpRateAndPkg']/table/tbody/tr[2]/td[4]/input")
@FindBy(xpath="(//input[@class='form-control form-control-sm rate-price-input'])[1]")
public WebElement Link_GroupStdRate;

@FindBy(xpath="//em[text()='Front Desk']")
public WebElement tab_Frontdesk;












public  String text;
public String rateBeforeDisc;
ArrayList<String> al=new ArrayList<String>();

public String sfname;
public String slname;
public String sphNum;
public String selectedAddOns;
public float newRate;
public float newRateAfterSaving;
public String selectedBed;







public void fn_changeBookingRate(int iTestCaseRow) throws Exception{
try{
	 Thread.sleep(1000);
	 newRate=Float.parseFloat(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_GivenDiscount)));
	 System.out.println("newRate:::"+newRate);
	 String Disc_amt= ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_GivenDiscount));
	 System.out.println("Disc_amt:::"+Disc_amt);
	 rateBeforeDisc=GenericMethods.GetWebElementAttributeValue(Link_GroupStdRate, "value");
	 System.out.println("rateBeforeDisc::"+rateBeforeDisc);
	 Float rateBeforeDisc1=Float.parseFloat(rateBeforeDisc);
	 System.out.println("rateBeforeDisc1:::"+rateBeforeDisc1);
	 float discountRate=rateBeforeDisc1-newRate;
	 String rateToinp=String.valueOf(discountRate);
	 System.out.println("discountRate::"+discountRate);
	 Thread.sleep(7000);
	 System.out.println("Performing click");
	 GenericMethods.js_Click(Link_GroupStdRate);
	 Thread.sleep(2000);
	// Link_GroupStdRate.clear();
	// Link_GroupStdRate.sendKeys(Disc_amt);
	// GenericMethods.fn_ActionsSendkeys(we, value);
	 GenericMethods.js_Sendkey(Link_GroupStdRate, Disc_amt);
     //Link_GroupStdRate.sendKeys(Keys.chord(Keys.CONTROL,"a")+Disc_amt);
     Thread.sleep(2000);
	 newRateAfterSaving=Float.parseFloat(GenericMethods.GetWebElementAttributeValue(Link_GroupStdRate, "value").trim());
	 System.out.println("newRateAfterSaving::"+newRateAfterSaving);
}
catch(Exception e){
throw e;
}
}



public String fn_getAddOn(String addOnString){
	String addOn=null;
try{
	addOn=addOnString.substring(0,addOnString.indexOf("-"));
}
catch(Exception e){
}
return addOn;
}


public void fn_setAddOnsToReservation() throws Exception{
try{
	Thread.sleep(2000);
selectedAddOns=GenericMethods.selectValueFromDropdownUsingIndex(SelectBx_avlAddOns, 0);
Thread.sleep(1000);
GenericMethods.clickElement(Btn_moveToPlacedAddOns);
Thread.sleep(1000);
GenericMethods.clickElement(Btn_saveInclusion);
Thread.sleep(1000);
}
catch(Exception e){

throw e;
}
}

public String getAddOn(String s) throws Exception{
	
	String str=null;
try{
	
 str=s.substring(s.indexOf(":")+1, s.length()).trim();
System.out.println(s);
	
}
catch(Exception e){
throw e;
}
return str;
}


public FrontdeskLandingPage AddSecondaryGuestDetail() throws Exception{
try{
GenericMethods.clickElement(Link_ManageSharer);
sfname=GenericMethods.generateRandomString();
slname=GenericMethods.generateRandomString();	
sphNum=GenericMethods.generateRandomString();
GenericMethods.selectElement(DD_SecondaryGuestSalutation, "Mr.");
Thread.sleep(2000);
GenericMethods.sendKeys(Txtbx_SecondaryGuestFname, sfname);
Thread.sleep(2000);
GenericMethods.sendKeys(Txtbx_SecondaryGuestLname, slname);
Thread.sleep(2000);
GenericMethods.sendKeys(Txtbx_SecondaryGuestPhNum, sphNum);
Thread.sleep(2000);
      if(CB_sChargeSharer.isSelected()==true){
Reporter.log("Secondary suest selected as a Charge Sharer", true);
     }
      else{
	        CB_sChargeSharer.click();
}
      Thread.sleep(2000);
GenericMethods.clickElement(Btn_SaveGuestDetail);

}
catch(Exception e){
	throw e;
}
Thread.sleep(2000);


GenericMethods.clickElement(BtnEnableEditing_SaveSingleRes);
Thread.sleep(1000);
FrontdeskLandingPage FLP=PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
return FLP;
}


public String fn_newDisct(int iTestCaseRow) throws NumberFormatException, Exception{
	try{
//	float Disc_amt1=Float.parseFloat(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_GivenDiscount)));
//	System.out.println(Disc_amt1);
//	String Disc_amt= ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_GivenDiscount));
//	System.out.println(Disc_amt);
//	rateBeforeDisc=GenericMethods.GetWebElementAttributeValue(Text_stdRate, "value");
//	System.out.println(rateBeforeDisc);
//	Float rateBeforeDisc1=Float.parseFloat(rateBeforeDisc);
//	System.out.println(rateBeforeDisc1);
//	Float rate=rateBeforeDisc1-Disc_amt1;
//	Integer aa=rate.intValue();
//	text=aa.toString();
	
	
	
	/*String rateToinp=String.valueOf(rate);
	System.out.println();
	Thread.sleep(1000);*/
	
/*	JavascriptExecutor js = (JavascriptExecutor) GenericMethods.driver;
	js.executeScript("document.getElementById('link-standardRates').setAttribute('value', "+rateToinp+")");
*/	
		
	Actions actobj=new Actions(GenericMethods.driver);
	actobj.click(Text_stdRate).build().perform();
	Keys.chord(Keys.CONTROL, "a");
	Thread.sleep(100);
	//Text_stdRate.clear();
	String val="1000";
	Keys.chord(Keys.CONTROL, "a");
	  for (int i = 0; i < val.length(); i++){
          char c = val.charAt(i);
          String s = new StringBuilder().append(c).toString();
          Thread.sleep(100);
          Text_stdRate.sendKeys(s);
      }       
	//actobj.sendKeys("1000").build().perform();
//	GenericMethods.js_Click(Text_stdRate);
//	//Thread.sleep(2000);
//	//GenericMethods.js_Sendkey(Text_stdRate,rateToinp Keys.ENTER);
//	Text_stdRate.clear();
//	Thread.sleep(2000);
//	GenericMethods.js_Click(Text_stdRate);
//	GenericMethods.fn_ActionsSendkeys(Text_stdRate, text+".00");
	//GenericMethods.TypeInField(Text_stdRate, val+".00");
	
	System.out.println("1000");
	}catch(Exception e){
		throw e;
	}
	
	return text;
}


public FrontdeskLandingPage fn_switchToFDTab() throws Exception{
	GenericMethods.clickElement(tab_Frontdesk);
	
	FrontdeskLandingPage FLP=PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
	return FLP;
	
}



public void fn_saveChangedDisct(String givenDisc) throws Exception{
	
	//GenericMethods.clickElement(tab_Frontdesk);
	
	String s=GenericMethods.getText(Text_DiscountAmt).trim();
	String s1=s.substring(2, s.length());
	System.out.println(s1);
	Thread.sleep(2000);
	Assert.assertEquals(givenDisc, s1.trim());
	Reporter.log("Tax verified", true);
	
	GenericMethods.clickElement(resrvBtn);
}







public String giveDiscount(int iTestCaseRow) throws Exception {
	try{
	Robot robot = new Robot();
	float Disc_amt1=Float.parseFloat(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_GivenDiscount)));
	System.out.println(Disc_amt1);
	String Disc_amt= ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_GivenDiscount));
	System.out.println(Disc_amt);
	rateBeforeDisc=GenericMethods.GetWebElementAttributeValue(Text_stdRate, "value");
	System.out.println(rateBeforeDisc);
	Float rateBeforeDisc1=Float.parseFloat(rateBeforeDisc);
	System.out.println(rateBeforeDisc1);
	Float rate=rateBeforeDisc1-Disc_amt1;
	Integer aa=rate.intValue();
	String val=aa.toString();
	
	
	String rateToinp=String.valueOf(rate);
	System.out.println();
	Thread.sleep(1000);
	
/*	JavascriptExecutor js = (JavascriptExecutor) GenericMethods.driver;
	js.executeScript("document.getElementById('link-standardRates').setAttribute('value', "+rateToinp+")");
*/	
	
	
	//GenericMethods.js_Click(Text_stdRate);
	new Actions(GenericMethods.driver).clickAndHold().sendKeys(val).build().perform();
	Thread.sleep(2000);
	//GenericMethods.js_Sendkey(Text_stdRate,rateToinp Keys.ENTER);
	/*Text_stdRate.clear();
	GenericMethods.fn_ActionsSendkeys(Text_stdRate, val+".00");*/
	//GenericMethods.TypeInField(Text_stdRate, val+".00");
	
    Actions act=new Actions(GenericMethods.driver);
	act.keyDown(Keys.CONTROL).build().perform();
    act.click(link_View);
	act.keyDown(Keys.CONTROL).build().perform();
   //Thread.sleep(2000);
    robot.keyPress(KeyEvent.VK_TAB);	
//  robot.keyRelease(KeyEvent.VK_ENTER);
	System.out.println("DISC AMT :"+Disc_amt);
	Thread.sleep(2000);
	
	//GenericMethods.clickElement(resrvBtn);
	
	System.out.println("DISC AMT1"+GenericMethods.getText(Text_DiscountAmt).trim());
	String s=GenericMethods.getText(Text_DiscountAmt).trim();
	String s1=s.substring(2, s.length());
	System.out.println(s1);
	Thread.sleep(2000);
	Assert.assertEquals(Disc_amt, s1.trim());
	Reporter.log("Tax verified", true);
	}
	catch(Exception e){
		throw e;
	}
	
	return text;
	
}

	public void splitBookingDays() throws Throwable{
	try{
		int size=Txt_SplitedDays.size();
		System.out.println("size is"+size);
		GenericMethods.js_Click(Link_ToDateForSplit);
		Thread.sleep(2000);
		GenericMethods.js_Click(Link_ActiveSplitDate);
		Thread.sleep(3000);
		int size1=Txt_SplitedDays.size();
		System.out.println("size1 is"+size1);
		Thread.sleep(2000);
		Assert.assertFalse(size==size1);
		Reporter.log("Split successfull", true);
	}
	catch(Exception e){
		throw e;
	}catch(Throwable e){
		throw e;
	}
		
	}
	
	public void verifySplittedPrice(String stdPrice) throws Throwable{
		try{
		int size=Txt_StandardPriceforSplitedDays.size();
		for(int i=0;i<=size-1;i++){
		String stdPrice1=Txt_StandardPriceforSplitedDays.get(i).getAttribute("value");
		System.out.println(stdPrice1);
		Assert.assertTrue(stdPrice1.contains(stdPrice));		
		}
		}catch(Exception e){
			Thread.sleep(3000);
			int size=Txt_StandardPriceforSplitedDays.size();
			for(int i=0;i<=size-1;i++){
			String stdPrice1=Txt_StandardPriceforSplitedDays.get(i).getAttribute("value");
			System.out.println(stdPrice1);
			Assert.assertTrue(stdPrice1.contains(stdPrice));		
			}
		}catch(Throwable e){
			throw e;
		}
	}



public FrontdeskLandingPage ClickOnSaveBtnOverEnableEditing() throws Exception{
try{
GenericMethods.clickElement(BtnEnableEditing_SaveSingleRes);		
}
catch(Exception e){

throw e;
}
FrontdeskLandingPage FLP=PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
return FLP;
}



public void ClickOnAddEditDetails() throws Exception{
try{
GenericMethods.clickElement(Link_GuestEditDetailforSingleRes);
	
}
catch(Exception e){
	
throw e;
}
}



public ArrayList<String> getDetails() throws Exception{
try{
String fname=GenericMethods.GetWebElementAttributeValue(TxtbxguestInfo_fName, "value");
Thread.sleep(1000);
String lname=GenericMethods.GetWebElementAttributeValue(TxtbxguestInfo_lName, "value");
al.add(fname);
Thread.sleep(1000);
al.add(lname);

}
catch(Exception e){
	
throw e;
}
return al;
}


public ArrayList<String> setDetails() throws Exception{
try{
String fname=GenericMethods.generateRandomString();
String lname=GenericMethods.generateRandomString();
GenericMethods.sendKeys(TxtbxguestInfo_fName, fname);
GenericMethods.sendKeys(TxtbxguestInfo_lName, lname);
al.add(fname);
Thread.sleep(1000);
al.add(lname);
Thread.sleep(1000);
GenericMethods.clickElement(BtnguestInfo_Save);
}
catch(Exception e){

throw e;
}
return al;	
}




	public FrontdeskLandingPage CheckInSingleRes() throws Exception{
	 try{
		GenericMethods.clickElement(Btn_CheckIn);
		GenericMethods.ActionOnAlert("Accept");
		GenericMethods.AcceptAlertAfterValidate();
		Thread.sleep(4000);
	 }catch(Exception e){
		    throw e;
		}
		FrontdeskLandingPage FLP=PageFactory.initElements(GenericMethods.driver,FrontdeskLandingPage.class);
		return FLP;
		
	}










public void verify_addedInclusion() throws Exception
{
	try
	{
	 String actual_txt=GenericMethods.getText(addedIncl_txt);
	 Assert.assertTrue(text.contains(actual_txt));
	 String actual_inclPrice=GenericMethods.getText(added_inclPrice);
	 System.out.println(actual_inclPrice);
	}
	catch(AssertionError e)
	{
		throw e;
	}
	catch(Exception e)
	{
		throw e;
	}
}



public void ClickOnRoomTaxes() throws Exception
{
	try
	{
	GenericMethods.clickElement(RoomTaxes);
	}
	catch(NoSuchElementException e)
	{
		Thread.sleep(3000);
		GenericMethods.js_Click(RoomTaxes);
	}
	catch(Exception e)
	{
		throw e;
	}

}





	public void ExemptTheTax() throws InterruptedException
	{
	int size=AllTaxesToExempt.size()+1;
	Select s1=new Select(TaxExemptDropdown);
	s1.selectByIndex(1);
	for(int i=2;i<=size;i++){
	String str=GenericMethods.driver.findElement(By.xpath("//table[@class='pnl_rates']//tr["+i+"]//td[3]//table//tr//td")).getText();
	String s2=str.substring(0, str.lastIndexOf("%"));
	if(s2.equals("5"))
	{
	GenericMethods.driver.findElement(By.xpath("//table[@class='pnl_rates']//tr["+i+"]//td[4]//input")).click();
	GenericMethods.driver.findElement(By.xpath("//button[@id='txBtnSave-button']")).click();
	Thread.sleep(2000);
	DoTaxExempt(s2);
	break;
	}
	else if(s2.equals("7"))
	{
	GenericMethods.driver.findElement(By.xpath("//table[@class='pnl_rates']//tr["+i+"]//td[4]//input")).click();
	GenericMethods.driver.findElement(By.xpath("//button[@id='txBtnSave-button']")).click();
	Thread.sleep(2000);
	DoTaxExempt(s2);
	break;
	}
	else
	{
	System.out.println("No Applicable Tax ");
	}

	}

	}


public void DoTaxExempt(String taxper) throws InterruptedException
{
if(taxper.equals("7")){
String s=RoomRate.getText().trim();
String f=s.substring(1, s.length());
double am=Double.parseDouble(f);
double amt=(am*5)/100;
double totalamt1=am+amt;
String a=Double.toString(totalamt1);
String rate=a.substring(0, a.indexOf(".")).trim();
Thread.sleep(2000);
String bal=GenericMethods.getText(TotalBalance).trim();
String Bal=bal.substring(1,bal.length()).trim();
Thread.sleep(2000);
Assert.assertEquals(rate,Bal);
}
else if(taxper.equals("5")){
String s=RoomRate.getText().trim();
String f=s.substring(1, s.length());
double am=Double.parseDouble(f);
double amt=(am*7)/100;
double totalamt1=am+amt;
String a=Double.toString(totalamt1);
String rate=a.substring(0, a.indexOf(".")).trim();
Thread.sleep(2000);
String bal=GenericMethods.getText(TotalBalance).trim();
String Bal=bal.substring(1,bal.length()).trim();
Thread.sleep(2000);
Assert.assertEquals(rate,Bal);
}
}

public static int roomPrice;
public static int tax1;

public int fn_clkTaxExemptBtn() throws Exception
{
	try
	{
	 GenericMethods.js_Click(FirstGuestCheckBox_CB);
	 String b=SingleGuestPrice_ED.getAttribute("value").split("\\.")[0];

	 roomPrice=Integer.parseInt(b);
	 String c=GenericMethods.getText(txt_Tax).split(" ")[1];
	 String taxValue=c.split("\\.")[0];
	 tax1=Integer.parseInt(taxValue);
     GenericMethods.js_Click(taxExempt);
     return roomPrice;
	}
	catch(Exception e)
	{
		throw e;
	}


}


public void verify_TETitle() throws Exception
{
	try
	{
	String text=GenericMethods.getText(taxEexemptTitle);
	Assert.assertTrue(text.contains("Tax Exempt Group ID#"));
	}
	catch(AssertionError e)
	{
		throw e;
	}
	catch(Exception e)
	{
		throw e;
	}
	
}

public static int TEValue;
public int fn_selectTaxExempt() throws Exception
{

	try
	{
	GenericMethods.selectElementByIndex(TaxExemptReason_DD, 1);
	GenericMethods.clickElement(chkbox_TEValue);
	String str=GenericMethods.driver.findElement(By.xpath("//table[@class='pnl_rates']//tr[2]//td[3]")).getText().split("\\.")[0];
	TEValue=Integer.parseInt(str);
	GenericMethods.clickElement(TaxExemptOKBT_InPopUp);
	return TEValue;
	}
	catch(Exception e)
	{
		throw e;
	}


}


public void fn_CalcTaxExempt() throws Exception
{
	try
	{
	String tax=GenericMethods.getText(txt_Tax);
	Integer expTax=(roomPrice*TEValue)/100;
	Integer a=tax1-expTax;
    String expected=a.toString();
	Assert.assertTrue(tax.contains(expected));
	}
	catch(Exception e)
	{
		throw e;
	}
	catch(AssertionError e)
	{
		throw e;
	}
}







public void AddNewRoomToG() throws Exception
{
	try
	{
	GenericMethods.clickElement(AddNewRoomG);
	String msg=GenericMethods.getText(addNewRoomTitle);
	Assert.assertEquals(msg, "Add New Room");
	Select s=new Select(AddNewRoomTypeForGroupDropdown);

	//s.selectByVisibleText("Semi-Deluxe");
	s.selectByIndex(2);
	Thread.sleep(1000);
	Select s2=new Select(AdultSelectionDD);
	s2.selectByVisibleText("1");
	Thread.sleep(1000);
	Select s1=new Select(RoomsDropdownInAddNewRoom);
	s1.selectByVisibleText("1");
	Thread.sleep(1000);
	GenericMethods.clickElement(AddBtn);
	}
	catch(Exception e)
	{
		throw e;
	}
	catch(AssertionError e)
	{
		throw e;
	}
}


public void VerifyDeleteAlertAddedRoom(String alert) throws Exception
{
	try
	{
	int size=GenericMethods.tr_count(AllAddedRoom)+1;
	Thread.sleep(2000);
	for(int i=2;i<=size;i++)
	{
		Thread.sleep(2000);
		String stat=GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']//tbody//tr["+i+"]//td[9]")).getText();
		if(stat.equals("Reserved"))
		{
			GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']//tbody//tr["+i+"]//td[10]/div")).click();
			GenericMethods.ActionOnAlert(alert);
			Assert.assertEquals(GenericMethods.value, "Do you wish to delete selected room(s)?");
			break;
        }
    }
	}
	catch(Exception e)
	{
		throw e;
	}
}

public void VerifyDeletedRoom() throws Exception
{
	try
	{
	int size=GenericMethods.tr_count(AllAddedRoom)-48;
	System.out.println(size);
	Thread.sleep(2000);
	for(int i=2;i<=size;i++)
	{
		Thread.sleep(2000);
		String stat=GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']//tbody//tr["+i+"]//td[9]")).getText();
		if(stat.equals("Reserved"))
		{

			break;

        }
    }
	}
	catch(Exception e)
	{
		throw e;
	}
}

public void VerifyEarlyCheckInAlert() throws Exception
{
	GenericMethods.driver.findElement(By.xpath("//input[@name='chkboxRes_0']")).click();
	GenericMethods.clickElement(EarlyCheckInSelectedBtn);
	Assert.assertEquals(GenericMethods.getText(EarlyCheckInTitle),"Early Checkin");
}




public CheckinCard VerifyEarlyCheckInPopUp() throws Exception
{
	try
	{
	//GenericMethods.driver.findElement(By.xpath("//input[@name='chkboxRes_0']")).click();
	//GenericMethods.clickElement(EarlyCheckInSelectedBtn);
	GenericMethods.sendKeys(ReasonForEarlyCheckIn,"Early flight arrival");
	txtbox_EarlyCheckinCharge.clear();
	GenericMethods.sendKeys(txtbox_EarlyCheckinCharge, "100");
	GenericMethods.clickElement(EarlyCheckinBtn);
	String msg=GenericMethods.Alert_Accept();
	Assert.assertEquals(msg,"Do you wish to early check-in the Selected Reservation?");
	CheckinCard CC=PageFactory.initElements(GenericMethods.driver, CheckinCard.class);
	return CC;
	}
	catch(Exception e)
	{
		throw e;
	}
	catch(AssertionError e)
	{
		throw e;
	}

}



public void CheckInReservationAndVerifyCheckIn() throws Exception
{

	GenericMethods.clickElement(StatusForGroupReservation);
	Thread.sleep(2000);
	Select s=new Select(SelectReservationStatus);
	Thread.sleep(2000);
	s.selectByVisibleText("Checked-In");
	Thread.sleep(2000);
	GenericMethods.ActionOnAlert("Accept");
	//String stat=s.getFirstSelectedOption().getText();
	String stat1=GenericMethods.getText(StatusForGroupReservation);
	Thread.sleep(2000);
	Assert.assertEquals(stat1, "Checked In");
	Thread.sleep(2000);
}


public void VerifyNoShowPopUpAlert() throws Exception
{
	GenericMethods.driver.findElement(By.xpath("//input[@name='chkboxRes_0']")).click();
	GenericMethods.clickElement(NoShowSelected);
	GenericMethods.ActionOnAlert("Dismiss");
	Assert.assertEquals(GenericMethods.value,"Do you wish to cancel / No-Show selected reservation(s)?");
}



public void VerifyNoShowPopUpTitle() throws Exception
{
	try
	{
	GenericMethods.driver.findElement(By.xpath("//input[@name='chkboxRes_0']")).click();
	GenericMethods.clickElement(NoShowSelected);
	String str=GenericMethods.Alert_Accept();
	Assert.assertEquals(str,"Do you wish to cancel / No-Show selected reservation(s)?");
	}
	catch(Exception e)
	{
		throw e;
	}
	catch(AssertionError e)
	{
		throw e;
	}
}

public void verify_NoShowTitle() throws Exception
{
	try
	{
    String text=GenericMethods.getText(NoShowPopUpTitle);
    Assert.assertEquals(text,"Cancel/No-Show Selected Reservation");
	}
	catch(Exception e)
	{
		throw e;
	}
	catch(AssertionError e)
	{
		throw e;
	}
}


public void VerifyNoShowForReservation() throws Exception
{
	try
	{
//	GenericMethods.driver.findElement(By.xpath("//input[@name='chkboxRes_0']")).click();
//	GenericMethods.clickElement(NoShowSelected);
//	GenericMethods.ActionOnAlert("Accept");
	Select s=new Select(NoShowReasonDropDown);
	s.selectByIndex(0);
	GenericMethods.sendKeys(NoShowDescription,"Not able to come");
	Assert.assertEquals(GenericMethods.getText(NoShowPopUpTitle),"Cancel/No-Show Selected Reservation");
	boolean res=NoShowButton.isEnabled();
	Assert.assertEquals(res, true);
	GenericMethods.driver.findElement(By.xpath("//button[@id='btnGrpCanClose-button']")).click();
	}
	catch(Exception e)
	{
		throw e;
	}
	catch(AssertionError e)
	{
		throw e;
	}

}


public void VerifyRateDetailPopUp() throws Exception
{

	try
	{
Actions action = new Actions(GenericMethods.driver);
action.moveToElement(GenericMethods.driver.findElement(By.xpath("//td[@class='rite panel-link']//input[@id='linkStandardRateGR']"))).doubleClick().perform();
//Assert.assertEquals(GenericMethods.driver.findElement(By.xpath("//div[text()='Standard Rate Details - Res ID# 0228121']")).getText(), "Standard Rate Details - Res ID# 0228121");
String text=GenericMethods.getText(stdRateGrp_Title);
Assert.assertTrue(text.contains("Standard Rate Details"));
	}
	catch(Exception e)
	{
		throw e;
	}
	catch(AssertionError e)
	{
		throw e;
	}
}

public void GiveDiscountAndVerifyDiscount() throws Exception
{
	String Damt="10.00";
Actions action = new Actions(GenericMethods.driver);
action.moveToElement(GenericMethods.driver.findElement(By.xpath("//td[@class='rite panel-link']//input[@id='linkStandardRateGR']"))).doubleClick().perform();
String ex=Keys.chord(Keys.CONTROL,"a");
GenericMethods.sendKeys(DiscountTextBox, ex);
DiscountTextBox.sendKeys(Damt);
Thread.sleep(2000);
GenericMethods.clickElement(DiscountDoneBtn);
Thread.sleep(2000);
String dis=GenericMethods.driver.findElement(By.xpath("//fieldset[@id='fldGrpDisc']")).getText();
String damt=dis.substring(3, dis.length()).trim();
System.out.println(Damt);
System.out.println(damt);
Assert.assertEquals(damt, Damt);
}

public static String Damt;
public void fn_applyDiscount() throws Exception
{
	try
	{
	 Damt="1.00";
//	Actions action = new Actions(GenericMethods.driver);
//	action.moveToElement(GenericMethods.driver.findElement(By.xpath("//td[@class='rite panel-link']//input[@id='linkStandardRateGR']"))).doubleClick().perform();
	String ex=Keys.chord(Keys.CONTROL,"a");
	GenericMethods.sendKeys(DiscountTextBox, ex);
	DiscountTextBox.sendKeys(Damt);
	Thread.sleep(2000);
	GenericMethods.clickElement(DiscountDoneBtn);
	Thread.sleep(4000);
	GenericMethods.clickElement(SaveReservationBtn);
	Thread.sleep(2000);
//	new FrontdeskLandingPage().fn_rightclkViewDetailsSingle(GenericMethods.driver.findElement(By.xpath("//div[@resrvid='4235470' and @title='78. romio juliet(G) ']")));
//	new ViewDetailsPage().ClickToEnableEditingBtn();
	Thread.sleep(2000);

	}
	catch(Exception e)
	{
		throw e;
	}

}


public void verify_DiscountAfterSave() throws Exception
{
	try
	{
	Thread.sleep(3000);
	String dis=GenericMethods.driver.findElement(By.xpath("//fieldset[@id='fldGrpDisc']")).getText();
	String damt=dis.substring(3, dis.length()).trim();
	Assert.assertEquals(Damt, damt);
	}
	catch(Exception e)
	{
		throw e;
	}
    catch(AssertionError e)
	{
    	throw e;
	}
}




public void VerifyManageSharerPopUp() throws Exception
{
	GenericMethods.clickElement(GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr[2]/td[10]")));
	GenericMethods.clickElement(ManageSharerLink);
	Assert.assertEquals(GenericMethods.driver.findElement(By.xpath("//div[text()='Manage Sharer(s)']")).getText().trim(), "Manage Sharer(s)");
}


public void VerifyChargeSharerStatus() throws Exception
{
	GenericMethods.clickElement(GenericMethods.driver.findElement(By.xpath("//td[text()='Mr.  Deep  Tha ']")));
	GenericMethods.clickElement(ManageSharerLink);
	//GenericMethods.driver.findElement(By.xpath("//table[@class='table-cellspacing-patch']//tr[2]//td[7]//input")).click();

	if(GenericMethods.driver.findElement(By.xpath("//table[@class='table-cellspacing-patch']//tr[2]//td[7]//input")).isSelected()) {

		String s=GenericMethods.getText(GenericMethods.driver.findElement(By.xpath("//table[@class='table-cellspacing-patch']//tr[2]//td[7]")));
		GenericMethods.clickElement(SaveBtnForManageSharer);

	String s1=GenericMethods.getText(GenericMethods.driver.findElement(By.xpath("//table[@id='tblRoomSharers']/tbody/tr[2]/td[6]")));
	Assert.assertEquals(s,s1);
}
else
{

GenericMethods.driver.findElement(By.xpath("//table[@class='table-cellspacing-patch']//tr[2]//td[7]//input")).click();
String s=GenericMethods.getText(GenericMethods.driver.findElement(By.xpath("//table[@class='table-cellspacing-patch']//tr[2]//td[7]")));
GenericMethods.clickElement(SaveBtnForManageSharer);
String s1=GenericMethods.getText(GenericMethods.driver.findElement(By.xpath("//table[@id='tblRoomSharers']/tbody/tr[3]/td[6]")));
Assert.assertEquals(s,s1);
}


}

public void VerifySharerStatusforOtherRooms(int index) throws Exception
{
	GenericMethods.clickElement(GenericMethods.driver.findElement(By.xpath("//fieldset[@id='dvStrRtype_0']")));
	Select s1=new Select(GenericMethods.driver.findElement(By.xpath("//select[@id='selGrpRsvAssRoom']")));
	s1.selectByIndex(index);
	GenericMethods.clickElement(GenericMethods.driver.findElement(By.xpath("//td[text()='Mr.  Deep  Tha ']")));
	GenericMethods.clickElement(ManageSharerLink);
	//GenericMethods.driver.findElement(By.xpath("//input[@id='chargeSharer2']")).click();

	if(GenericMethods.driver.findElement(By.xpath("//table[@class='table-cellspacing-patch']//tr[2]//td[7]//input")).isSelected())
	{

		String s=GenericMethods.getText(GenericMethods.driver.findElement(By.xpath("//table[@class='table-cellspacing-patch']//tbody//tr[2]//td[7]")));
		GenericMethods.clickElement(SaveBtnForManageSharer);

	    String s2=GenericMethods.getText(GenericMethods.driver.findElement(By.xpath("//table[@id='tblRoomSharers']/tbody/tr[2]/td[6]")));
	    Thread.sleep(2000);
	    Assert.assertEquals(s,s2);
    }
   else
   {
	   GenericMethods.driver.findElement(By.xpath("//table[@class='table-cellspacing-patch']//tr[2]//td[7]//input")).click();
       String s=GenericMethods.getText(GenericMethods.driver.findElement(By.xpath("//table[@class='table-cellspacing-patch']//tbody//tr[2]//td[7]")));
       GenericMethods.clickElement(SaveBtnForManageSharer);
       String s3=GenericMethods.getText(GenericMethods.driver.findElement(By.xpath("//table[@id='tblRoomSharers']/tbody/tr[2]/td[6]")));
       Assert.assertEquals(s3,"No");
   }

}


public  void fn_SelectDateFrmDatePicker(WebElement calIcon, String month, String year, String date1) throws Exception
{
	try
	{

	 frmMonth=month;
	 frmYear=year;
	 frmDate=date1;



	GenericMethods.clickElement(calIcon);
	GenericMethods.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	GenericMethods.clickElement(ChooseMonYear);

    //GenericMethods.selectElement(select_FrmMnth, frmMonth);
    Select sel1=new Select(select_FrmMnth);
    sel1.selectByVisibleText(frmMonth);
    Thread.sleep(700);
    //String mon=sel1.getFirstSelectedOption().getText();

    GenericMethods.clickElement(enterFrmYear);
    enterFrmYear.clear();
    GenericMethods.sendKeys(enterFrmYear, frmYear);

    String a=frmMonth+" "+"0"+frmDate;

    GenericMethods.clickElement(okButton_Frmcalander);
    Thread.sleep(3000);

    String classname = chartfrom.getAttribute("class");

    WebElement abc=  GenericMethods.driver.findElement(By.xpath("//table[@id='sr-calContainerPopup_t']//tbody//tr//td//a[contains(text(),('" + frmDate + "') )]"));
	abc.click();
	Thread.sleep(2000);
//     GenericMethods.Alert_Accept();
     Thread.sleep(2000);
	Assert.assertEquals(GenericMethods.getText(CheckInDate), a);
	}
	catch(Exception e)
	{
		throw e;
	}
	catch(AssertionError e)
	{
		throw e;
	}

}




public GroupToSingleReservationPage ClickToRoomOrGuest() throws Exception
{

	try
	{
GenericMethods.clickElement(GenericMethods.driver.findElement(By.xpath("//fieldset[@id='dvStrRtype_0']")));
GroupToSingleReservationPage GSR=PageFactory.initElements(GenericMethods.driver, GroupToSingleReservationPage.class);
return GSR;
	}
	catch(Exception e)
	{
		throw e;
	}
	catch(AssertionError e)
	{
		throw e;
	}

}



//public void DoTaxExemptForARoom() throws Exception
//{
//	try
//	{
//	GenericMethods.driver.findElement(By.xpath("//input[@id='chkboxRes_0']")).click();
//	GenericMethods.clickElement(GroupTaxExempt);
//	}
//	catch(Exception e)
//	{
//		throw e;
//	}
//	catch(AssertionError e)
//	{
//		throw e;
//	}
//
//}


public void fn_addDate() throws Exception
{
	try
	{
	 String text=beforeSplitPrice.getAttribute("value");
	 float f=Float.parseFloat(text);
	 float b=f/2;
	 GenericMethods.clickElement(date_lnk);
	 Thread.sleep(3000);
	 GenericMethods.clickElement(splitDate);
	 Thread.sleep(3000);
	 String text1=afterSplitPrice.getAttribute("value");
	 float f1=Float.parseFloat(text1);
	 //float c=f1/2;
	 Assert.assertEquals(b, f1);
	}
	catch(AssertionError e)
	{
		throw e;
	}
	catch(Exception e)
	{
		throw e;
	}
	
}


public void fn_addeditDetails() throws Exception
{
	try
	{
	 GenericMethods.clickElement(addEditDetails);
	 String str=GenericMethods.getText(detailForm_title);
	 Assert.assertEquals(str, "Guest Information");
	}
	catch(AssertionError e)
	{
		throw e;
	}
	catch(Exception e)
	{
		throw e;
	}
	
}


public void fn_clkAddEditDetail() throws Exception
{
	try
	{
	 GenericMethods.clickElement(addEditDetails);
	}
	catch(NoSuchElementException e)
	{
		Thread.sleep(3000);
		GenericMethods.js_Click(addEditDetails);
	}
	catch(Exception e)
	{
		throw e;
	}
}


public static String fName;
public static String lName;


public void fn_editGuestDetail() throws Exception
{
	 fName=GenericMethods.generateRandomString();
	 frstName.clear();
	 GenericMethods.sendKeys(frstName, fName);
	 lName=GenericMethods.generateRandomString();
	 lastName.clear();
	 GenericMethods.sendKeys(lastName, lName);
	 GenericMethods.clickElement(saveBtn);
	 Thread.sleep(3000);

	 String actualText=GenericMethods.getText(editedName);
	 String[] a=actualText.split(" ");
     String actual1=a[1];
     String actual2=a[2];
     Assert.assertTrue(actual1.equalsIgnoreCase(fName));
     Assert.assertTrue(actual2.equalsIgnoreCase(lName));

}

public FrontdeskLandingPage fn_addGuestDetailSingle() throws Exception
{

	 fName=GenericMethods.generateRandomString();
	 //frstName.clear();
	 GenericMethods.sendKeys(frstName, fName);
	 lName=GenericMethods.generateRandomString();
	 //lastName.clear();
	 GenericMethods.sendKeys(lastName, lName);
	 Thread.sleep(3000);
	 GenericMethods.sendKeys(phone,"234566");
	 GenericMethods.clickElement(resrvBtn);
	 Thread.sleep(6000);

//	 String actualText=GenericMethods.getText(editedName);
//	 String[] a=actualText.split(" ");
//     String actual1=a[1];
//     String actual2=a[2];
//     Assert.assertTrue(actual1.equalsIgnoreCase(fName));
//     Assert.assertTrue(actual2.equalsIgnoreCase(lName));\
	 FrontdeskLandingPage AHO = PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
	 return AHO;


}

public FrontdeskLandingPage fn_addGuestDetailGroup() throws Exception
{




	 fName=GenericMethods.generateRandomString();
	 //frstName.clear();
	 GenericMethods.sendKeys(fnameGrp, fName);
	 lName=GenericMethods.generateRandomString();
	 //lastName.clear();
	 GenericMethods.sendKeys(lnameGrp, lName);
	 Thread.sleep(3000);
	 GenericMethods.sendKeys(phGrp, "34567");
	 GenericMethods.clickElement(SaveChangesBtn);
	 Thread.sleep(6000);

//	 String actualText=GenericMethods.getText(editedName);
//	 String[] a=actualText.split(" ");
//     String actual1=a[1];
//     String actual2=a[2];
//     Assert.assertTrue(actual1.equalsIgnoreCase(fName));
//     Assert.assertTrue(actual2.equalsIgnoreCase(lName));\
	 FrontdeskLandingPage AHO = PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
	 return AHO;


}



public FrontdeskLandingPage fn_addGuestDetailAgCorp() throws Exception
{
	GenericMethods.selectElementByIndex(grpOwner, 0);
	GenericMethods.sendKeys(taName, GenericMethods.generateRandomString());
	Thread.sleep(2000);
	GenericMethods.sendKeys(compName, "AK Comp");
	GenericMethods.selectElementByIndex(salutation, 1);
	Thread.sleep(2000);
	 fName=GenericMethods.generateRandomString();
	 //frstName.clear();
	 GenericMethods.sendKeys(fnameGrp, fName);
	 lName=GenericMethods.generateRandomString();
	 //lastName.clear();
	 GenericMethods.sendKeys(lnameGrp, lName);
	 Thread.sleep(3000);
	 GenericMethods.sendKeys(phGrp, "34567");
	 GenericMethods.clickElement(SaveChangesBtn);
	 Thread.sleep(6000);

//	 String actualText=GenericMethods.getText(editedName);
//	 String[] a=actualText.split(" ");
//     String actual1=a[1];
//     String actual2=a[2];
//     Assert.assertTrue(actual1.equalsIgnoreCase(fName));
//     Assert.assertTrue(actual2.equalsIgnoreCase(lName));\
	 FrontdeskLandingPage AHO = PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
	 return AHO;


}



public void fn_addExtraBed() throws Exception
{
	try
	{
	 Select sel=new Select(extraBed);
	 sel.selectByValue("1");
	 String text=sel.getFirstSelectedOption().getText();
	 Assert.assertEquals(text, "1 Bed");
	}
	catch(AssertionError e)
	{
		throw e;
	}
	catch(Exception e)
	{
		throw e;
	}
}

public FrontdeskLandingPage fn_addExtraBeds(String beds) throws Exception
{
	try
	{
	 Select sel=new Select(DD_extraBed);
	 sel.selectByVisibleText(beds);
	 Thread.sleep(2000);
	 selectedBed=sel.getFirstSelectedOption().getText();
	 GenericMethods.js_Click(Save_Btn);
	 Thread.sleep(1000);
	
	}
	catch(AssertionError e)
	{
		throw e;
	}
	catch(Exception e)
	{
		throw e;
	}
	
	FrontdeskLandingPage FLP=PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
	return FLP;
}
public FrontdeskLandingPage fn_clkSaveBtn() throws Exception
{
	try
	{
	 GenericMethods.clickElement(Save_Btn);
	}
	catch(NoSuchElementException e)
	{
		Thread.sleep(1000);
		GenericMethods.js_Click(Save_Btn);
	}
	catch(Exception e)
	{
		throw e;
	}
	 FrontdeskLandingPage AHO = PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
	 return AHO;
}


public FrontdeskLandingPage fn_clkAmtForDisc() throws Exception
{
	try
	{
	String text=beforeSplitPrice.getAttribute("value");
	 float f=Float.parseFloat(text);
	 String i="50";
   Actions acobj= new Actions(GenericMethods.driver);
   acobj.doubleClick(beforeSplitPrice).build().perform();


   if(rb_disc.isSelected())
   {
	   Assert.assertEquals(rb_disc.isSelected(), true);
	   System.out.println("Disc radio button is selected");
   }
   else
   {
	   rb_disc.click();
   }
   acobj.moveToElement(discount).click().perform();

	acobj.sendKeys(discount, Keys.chord(Keys.CONTROL, "a"), i).build().perform() ;
 
	Robot rb=new Robot();

	rb.keyPress(java.awt.event.KeyEvent.VK_ENTER);
	rb.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
	Thread.sleep(3000);
  
   String Percentage=discount.getAttribute("value");

   float j=Float.parseFloat(Percentage);
   float discPrice=(float)((j*f)/100);
   GenericMethods.clickElement(doneBtn);
   Thread.sleep(3000);

   String disc=GenericMethods.getText(actualDisc);
   String[] str=disc.split(" ");
   String str1=str[1];
   String[] str2=str1.split(",");
   String st=str2[0]+str2[1];
   float f2=Float.parseFloat(st);
   Assert.assertEquals(discPrice, f2);
   FrontdeskLandingPage AHO = PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
	 return AHO;
	}
	catch(AssertionError e)
	{
		throw e;
	}
	catch(Exception e)
	{
		throw e;
	}
}


public static String gname;

public GroupToSingleReservationPage fn_clkGuestName() throws Exception
{
	try
	{
	 gname=GenericMethods.getText(guestName);
	 GenericMethods.clickElement(guestName);
	 GroupToSingleReservationPage GSP=PageFactory.initElements(GenericMethods.driver, GroupToSingleReservationPage.class);
	 return GSP;
	}
	catch(Exception e)
	{
		throw e;
	}
}


public GroupToSingleReservationPage fn_clkSingleGuest() throws Exception
{
	try
	{
	 int gcount=GenericMethods.tr_count(rowcount);
	 for(int i=2;i<=gcount;i++)
	 {
		 Thread.sleep(2000);
		 String text=GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']//tr["+i+"]//td[9]//fieldset[2]")).getText();
		 if(text.equals("Checked In"))
		 {
			 WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']//tr["+i+"]//td[9]"));
			 GenericMethods.js_Click(ele);
			 break;
		 }
	 }
	}
	catch(Exception e)
	{
		throw e;
	}
	Thread.sleep(4000);
	 GroupToSingleReservationPage GSP=PageFactory.initElements(GenericMethods.driver, GroupToSingleReservationPage.class);
	 return GSP;

}

public FrontdeskLandingPage fn_clkGrpSave() throws Exception
{
	try
	{
		Thread.sleep(4000);
	 GenericMethods.clickElement(grpSave);
	 FrontdeskLandingPage AHO = PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
	 return AHO;
	}
	catch(Exception e)
	{
		throw e;
	}
}


public void fn_verifyCancelledCheckin() throws Exception
{
	try
	{
	 int gcount=GenericMethods.tr_count(rowcount);
	 for(int i=2;i<=gcount;i++)
	 {
		 String text=GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']//tr["+i+"]//td[9]//fieldset[2]")).getText();
		 if(text.equals("Reserved"))
		 {
			 System.out.println("Checked-in reservation has been successfully cancelled.");
			 break;
		 }
	 }
	}
	catch(Exception e)
	{
		throw e;
	}
}

public void fn_clkCheckinSelected() throws Exception
{
	 GenericMethods.clickElement(checkboxTE);
	 GenericMethods.clickElement(checkinSelected);
	 String text=GenericMethods.ActionOnAlert("Dismiss");
	 Assert.assertEquals(text, "Do you wish to check-in selected reservation?");
}



public CheckinCard fn_AcceptCheckinSelected() throws Exception
{
	try
	{
	 GenericMethods.clickElement(checkboxTE);
	 gname=GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']//tr[2]//td[6]//table//td[1]")).getText();
	 GenericMethods.clickElement(checkinSelected);
	 Thread.sleep(3000);
	 String text=GenericMethods.ActionOnAlert("Accept");
	 Assert.assertEquals(text, "Do you wish to check-in selected reservation?");
	 //GenericMethods.ActionOnAlert("Accept");
	 CheckinCard CC=PageFactory.initElements(GenericMethods.driver, CheckinCard.class);
    return CC;
	}
	catch(Exception e)
	{
		throw e;
	}
	catch(AssertionError e)
	{
		throw e;
	}
}


public void fn_clkAddNewRoom() throws Exception
{
	 GenericMethods.clickElement(addNewRoombtn);

}

public FrontdeskLandingPage fn_verifyAddNewRoom() throws Exception
{
	 String msg=GenericMethods.getText(addNewRoomTitle);
	 Assert.assertEquals(msg, "Add New Room");
	 GenericMethods.clickElement(closeBtn);
	 GenericMethods.clickElement(grpSave);
	 FrontdeskLandingPage AHO = PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
	 return AHO;

}

int size;
public void fn_getCheckboxSize()
{
	int a=GenericMethods.tr_count(chkboxCount);
	size=a-2;

}



public void fn_addNewRoomDetail() throws Exception
{
	Select sel=new Select(roomTypeDD);
	sel.selectByIndex(1);
	Thread.sleep(4000);
    //GenericMethods.selectElement(roomTypeDD, "HMS");
	Select sel1=new Select(adultDD);
	sel1.selectByIndex(1);
	Thread.sleep(3000);
    //GenericMethods.selectElement(adultDD, "1");
	Select sel2=new Select(childDD);
	sel2.selectByIndex(0);
    //GenericMethods.selectElement(childDD, "0");
	Select sel3=new Select(roomsDD);
	sel3.selectByIndex(1);
	Thread.sleep(3000);
    //GenericMethods.selectElement(roomsDD, "1");
    GenericMethods.clickElement(addBtn);
    Thread.sleep(3000);

}


public void fn_verifyAddedRoom()
{
    int b=size;
    Assert.assertEquals(b, 3);
}


public GroupToSingleReservationPage fn_ClickRoomReservationID() throws Exception
{

  	 try
  	 {
  		GenericMethods.clickElement(RoomReservationID);
  		GroupToSingleReservationPage GTS=PageFactory.initElements(GenericMethods.driver, GroupToSingleReservationPage.class);
  		return GTS;
  	 }
  	 catch(Exception e)
  	 {
  		 throw e;
  	 }

}


public void fn_ValidateInclusionAddOns_Link() throws Exception
{

  	 try
  	 {
  		//GenericMethods.clickElement(InclusionAddOns_Link);
  		String str=GenericMethods.getText(InclusionAddOns_TitleTAB);
  		System.out.println(str);
  		Assert.assertEquals(str,"Select Add-ons");

  	 }
  	 catch(Exception e)
  	 {
  		 throw e;
  	 }

}





public void fn_ValidateSelectedIncluAddons() throws Exception
{

  	 try
  	 {
  		//GenericMethods.clickElement(InclusionAddOns_Link);
  		GenericMethods.clickElement(inclusionname);
  		String str=GenericMethods.getText(inclusionname);
  		GenericMethods.clickElement(RightArrow_BT);
  		//GenericMethods.clickElement(Done_BT);

  		Thread.sleep(4000);
  		String obj=GenericMethods.getText(InclusionName_besideAddInclu);

  		Assert.assertTrue(str.contains(obj));

  	 }
  	 catch(Exception e)
  	 {
  		 throw e;
  	 }
  	 catch(AssertionError e)
  	 {
  		 throw e;
  	 }

}

public static String price;
public void fn_ChangePrice() throws Exception
{

  	 try
  	 {

  		Actions actobj1=new Actions(GenericMethods.driver);
  		actobj1.click(SingleGuestPrice_ED).build().perform();
  		price=GenericMethods.generateRandomnum();
  		actobj1.moveToElement(SingleGuestPrice_ED);
  		GenericMethods.js_Sendkey(SingleGuestPrice_ED, price);
  		//.sendKeys(SingleGuestPrice_ED, Keys.chord(Keys.CONTROL, "a"), price).build().perform();
  		//GenericMethods.js_Sendkey(SingleGuestPrice_ED, price);
  		Thread.sleep(5000);
  		GenericMethods.selectElementByIndex(AdultSelectionDD, 1);
  		Thread.sleep(10000);
  		//GenericMethods.clickElement(SaveChangesBtn);
  		actobj1.click(SaveChangesBtn).build().perform();
  		Thread.sleep(4000);
  	 }
  	 catch(Exception e)
  	 {
  		 throw e;
  	 }

}

public void fn_verifyChangedPrice() throws Exception
{

	try
	{
	String str=SingleGuestPrice_ED.getAttribute("value");
	Assert.assertTrue(str.contains(price));
	}
	catch(AssertionError e)
	{
		throw e;
	}
	catch(Exception e)
	{
		throw e;
	}
}


public void fn_ClickSave() throws Exception
{

  	 try
  	 {

  	 GenericMethods.clickElement(saveBtn);
  	 }
  	 catch(Exception e)
  	 {
  		 throw e;
  	 }

}


public GroupToSingleReservationPage fn_ClickAddGuestDetails_Link() throws Exception{

  	 try{
//  		String str=AddGuestDetails_Link.getText();
//  		 if(str.equalsIgnoreCase("")){
//
//  		 }
  	 GenericMethods.clickElement(AddGuestDetails_Link);
  	  GroupToSingleReservationPage GTS=PageFactory.initElements(GenericMethods.driver, GroupToSingleReservationPage.class);
		return GTS;
  	 }
  	 catch(Exception e)
  	 {
  		 throw e;
  	 }
    }





public void fn_ClickClearAndVerify_IMG(String Name) throws Exception
{

  	 try
  	 {

  		String str= GenericMethods.getText(GuestName_TX);
  		Assert.assertTrue(str.contains(Name));
  		GenericMethods.clickElement(Clear_Link);
  	 }
  	 catch(Exception e)
  	 {
  		 throw e;
  	 }
  	 catch(AssertionError e)
  	 {
  		 throw e;
  	 }

}



public GroupToSingleReservationPage fn_ClickOnStatusLink() throws Exception
{

  	 try
  	 {
  		String str= GenericMethods.getText(Status_Link);
  		Assert.assertTrue(str.contains("Checked In"));
  		GenericMethods.clickElement(Status_Link);
  		GroupToSingleReservationPage GTSP=PageFactory.initElements(GenericMethods.driver, GroupToSingleReservationPage.class);
  	    return GTSP;
  	 }
  	 catch(Exception e)
  	 {
  		 throw e;
  	 }

}


public void fn_ValidateOneDayBeforeCheckOut() throws Exception{

    try{

       GenericMethods.clickElement(SecondGuestCheckoutDate_Link);
       Thread.sleep(2000);
       GenericMethods.clickElement(SecondGuestCheckoutDate_InCal);
       Thread.sleep(6000);
       String str=GenericMethods.getText(SecondGuestCheckoutDate_Link);
       Assert.assertTrue(str.contains("3"));
    }catch(Exception e){
        throw e;
    }
    }



public void fn_ValidateTaxExamptPopUp_Box() throws Exception
{

  	 try
  	 {
  	 String str=GenericMethods.getText(TaxExamptPopUp_Box);
  	 Assert.assertTrue(str.contains("Tax Exempt Group"));
  	 }
  	 catch(Exception e)
  	 {
  		 throw e;
  	 }

}
	public void fn_ValidateTaxExampt() throws Exception
	{

  	 try
  	 {
  		GenericMethods.clickElement(FirstGuestCheckBox_CB);
  		GenericMethods.clickElement(TaxExampt_BT);
  	 }
  	 catch(Exception e)
  	 {
  		 throw e;
  	 }

	}


	public void fn_SelectTaxExempt() throws Exception
	{

	   	 try
	   	 {
	   		Select sobj=new Select(TaxExemptReason_DD);
	   		//sobj.selectByVisibleText("Reason1");
	   		sobj.selectByIndex(1);

	   		GenericMethods.clickElement(TaxExemptOKBT_InPopUp);
	   	 }
	   	 catch(Exception e)
	   	 {
	   		 throw e;
	   	 }

	}

	public String ChangePayTerm(int index) throws Exception
	{
		try
		{
		GenericMethods.clickElement(ChangePayTerm);
		Thread.sleep(2000);
		Select s=new Select(PayTermDropDown);
		s.selectByIndex(0);
		Thread.sleep(2000);
	String	payee=s.getFirstSelectedOption().getText();
		GenericMethods.clickElement(SaveChangesBtn);
		Thread.sleep(2000);
		return payee;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	 public void VerifyPayTerm(String payee) throws Exception
	 {
		 try
		 {
		 String actual=GenericMethods.driver.findElement(By.xpath("//fieldset[@id='changeLink']")).getText().trim();
			Thread.sleep(1000);
			Assert.assertEquals(actual, payee);
		 }
		 catch(Exception e)
		 {
			 throw e;
		 }
		 catch(AssertionError e)
		 {
			 throw e;
		 }
	 }



	 public int CountRoomInGroup(){
			int count=0;
		int counts=	GenericMethods.tr_count(RoomsInGroup);
		for(int i=2;i<=counts;i++){
			if(GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']//tr["+i+"]//td[2]/input")).isEnabled()){
				 count++;
				 System.out.println(count);




			}
			else
			{
				break;
			}
		}
		return count;

		}

	 public void AddRoomToGroup(String roomType,String adults,String roomNum) throws Exception
	 {
			GenericMethods.clickElement(AddNewRoomG);
			Thread.sleep(1000);
			Select s=new Select(AddNewRoomTypeForGroupDropdown);
			s.selectByVisibleText(roomType);
			Thread.sleep(1000);

			Select s2=new Select(AdultSelectionDD);
			s2.selectByVisibleText(adults);
			Thread.sleep(1000);
			Select s1=new Select(RoomsDropdownInAddNewRoom);
			s1.selectByVisibleText(roomNum);
			Thread.sleep(1000);
			GenericMethods.clickElement(AddBtn);
			Thread.sleep(2000);
			GenericMethods.clickElement(SaveChangesBtn);
		}



	 public void DeleteAddedRoomFromGroup(String id) throws Exception{
			int counts=	GenericMethods.tr_count(RoomsInGroup);
			for(int i=2;i<=counts;i++){
				if(GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']//tr["+i+"]//td[2]/input")).isEnabled()){

				if(GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[3]")).getText().trim().equals(id)){


					i=i+1;

					GenericMethods.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[2]/input")).click();
					GenericMethods.clickElement(NoShowSelect);
					GenericMethods.ActionOnAlert("Accept");
					Select s=new Select(NoShowReason);
					s.selectByIndex(2);
					GenericMethods.sendKeys(NoShowDesc, "Goin To No show");
					GenericMethods.clickElement(NoShowReservationBtn);
					break;
				}






				}
				else
				{
					break;
				}
		}
		}


	 public void fn_verifySingleTab() throws Exception
	 {
		 try
		 {
		 String a=GenericMethods.getText(TabTitle);
		 Assert.assertEquals(a, "Single Reservation");
		 }
		 catch(Exception e)
		 {
			 throw e;
		 }
		 catch(AssertionError e)
		 {
			 throw e;
		 }
	 }



	 public void fn_verifyGroupTab() throws Exception
	 {
		 try
		 {
		 String a=GenericMethods.getText(TabTitle);
		 Assert.assertEquals(a, "Group Reservation");
		 }
		 catch(Exception e)
		 {
			 throw e;
		 }
		 catch(AssertionError e)
		 {
			 throw e;
		 }
	 }


	 public void fn_SetPreviousCheckOutDate()
	 {
	        try{
	            String str=GenericMethods.getText(SecondGuestCheckoutDate_Link);
	               Assert.assertTrue(str.contains("3"));
	               Thread.sleep(6000);
	               GenericMethods.clickElement(SecondGuestCheckoutDate_Link);
	               Thread.sleep(2000);
	               GenericMethods.clickElement(PreviousCheckoutDate_InCal);
	               Thread.sleep(6000);
	        }catch(Exception e){

	        }
	        catch(AssertionError e)
	        {
	        	throw e;
	        }
	    }

	 

	 

	 
	 
	 
	 
	 
	 
	 

}

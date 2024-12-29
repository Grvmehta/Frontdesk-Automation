package com.hotelogix.smoke.FrontdeskTest;


import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Set;

import javax.media.rtp.rtcp.Report;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotelogix.smoke.frontdesk.ViewDetailsPage.EnableEditingPage;
import com.hotelogix.smoke.frontdesk.ViewDetailsPage.GroupToSingleReservationPage;
import com.hotelogix.smoke.frontdesk.ViewDetailsPage.ViewDetailsPage;
import com.hotelogix.smoke.frontdesk.WebReservation.AddOnsPage;
import com.hotelogix.smoke.frontdesk.WebReservation.WebAddMoreRoomPage;
import com.hotelogix.smoke.frontdesk.WebReservation.WebConfirmReservationPage;
import com.hotelogix.smoke.frontdesk.WebReservation.WebConfirmReservationPrintPage;
import com.hotelogix.smoke.frontdesk.WebReservation.WebMoreDetailsPage;
import com.hotelogix.smoke.frontdesk.WebReservation.WebReservationHomePage;
import com.hotelogix.smoke.frontdesk.WebReservation.WebSelectRoomPage;
import com.hotelogix.smoke.frontdesk.WebReservation.GuestConsole.WebGuestAddMoreRoomPage;
import com.hotelogix.smoke.frontdesk.WebReservation.GuestConsole.WebGuestConfirmReservationPage;
import com.hotelogix.smoke.frontdesk.WebReservation.GuestConsole.WebGuestConfirmReservationPrintPage;
import com.hotelogix.smoke.frontdesk.WebReservation.GuestConsole.WebGuestConsoleLandingPage;
import com.hotelogix.smoke.frontdesk.WebReservation.GuestConsole.WebGuestSelectRoomPage;
import com.hotelogix.smoke.frontdesk.WebReservation.GuestConsole.WebGuestStayDetailsPage;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.hotelogix.smoke.admin.BaseClass.AdmineHome;
import com.hotelogix.smoke.admin.PriceManager.FrontDeskPackageDetailPage;
import com.hotelogix.smoke.admin.PriceManager.FrontdeskPackagesListPage;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesFrontdesk;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesPage;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesWeb;
import com.hotelogix.smoke.admin.PriceManager.PackageDetailsWeb;
import com.hotelogix.smoke.admin.PriceManager.RoomPricesLandingPage;
import com.hotelogix.smoke.admin.roommanager.RoomsLandingPage;
import com.hotelogix.smoke.admin.roommanager.AddRoomsPage;
import com.hotelogix.smoke.emailaccount.EmailHomePage;
import com.hotelogix.smoke.emailaccount.InboxMailPage;
import com.hotelogix.smoke.frontdesk.Accounts.AccountsLandingPage;
//import com.hotelogix.smoke.admin.WebBookingEngine.SelectRoom_Packages;
//import com.hotelogix.smoke.admin.WebBookingEngine.WebReservationConsole;
import com.hotelogix.smoke.frontdesk.CashCounter.CashCounterPage;
import com.hotelogix.smoke.frontdesk.CashCounter.NightAuditPdfPage;
import com.hotelogix.smoke.frontdesk.CashCounter.NightAuditVideoPage;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.AddQuickReservationForm;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.CheckinCard;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.FrontdeskLandingPage;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.GroupReservationPage;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.NightAuditLandingPage;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.SingleReservationPage;
import com.hotelogix.smoke.frontdesk.FrontdeskTrialPage.FrontdeskContinueTrialPage;
import com.hotelogix.smoke.frontdesk.NightAudit.ContinueNightAuditPage;
import com.hotelogix.smoke.frontdesk.NightAudit.IgnoreCounterNightAuditPage;
import com.hotelogix.smoke.frontdesk.NightAudit.NightAuditSummaryPage;
import com.hotelogix.smoke.frontdesk.Payment.AccountStatementLandingPage;
import com.hotelogix.smoke.frontdesk.Payment.ReservationFolioPage;
import com.hotelogix.smoke.frontdesk.Report.CashierReportPage;
import com.hotelogix.smoke.frontdesk.Report.DailySalesReportPage;
import com.hotelogix.smoke.frontdesk.Report.DiscountAllowanceReportPage;
import com.hotelogix.smoke.frontdesk.Report.FRMonthlySummeryReport;
import com.hotelogix.smoke.frontdesk.Report.LiveSupportLandingWindow;
import com.hotelogix.smoke.frontdesk.Report.NoShowReportPage;
import com.hotelogix.smoke.frontdesk.Report.ORHouseCountReport;
import com.hotelogix.smoke.frontdesk.Report.ReportLandingPage;
import com.hotelogix.smoke.frontdesk.ReservationSearchResult.ReservationSearchResultLandingPage;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.ConfirmOrderPage;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.ConfirmOrderPage1;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.OrderFolioPage;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.OrderFromNewTab;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.SampleRestaurantPage;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.TransactionListPage;
import com.hotelogix.smoke.genericandbase.BasePage;
import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;
import com.hotelogix.smoke.login.AdminLoginPage;
import com.hotelogix.smoke.login.EmailAccountLoginPage;
import com.hotelogix.smoke.login.FrontdeskLoginPage;
import com.hotelogix.smoke.login.WebGuestConsoleLoginPage;




public class FrontdeskTest {
	
	public WebDriver driver;
	private  String sTestCaseName;
	private int iTestCaseRow;
	public static ArrayList<String> a1=new ArrayList<String>();
	public static ArrayList<String> gd=new ArrayList<String>();
	public static String Discount="SP Discount(10.00%)";


FrontdeskContinueTrialPage FCT=new FrontdeskContinueTrialPage();


@BeforeMethod
//@org.testng.annotations.Parameters("browser")
public void LaunchApp() throws Exception{
	
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	String br=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Browser));
try
{
FrontdeskLoginPage AL = GenericMethods.fn_OpenFrontdesk(br, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AppURL)));
//AL.Frontdesklogin_12725();
}catch(Exception e){
    Thread.sleep(4000);
	System.out.println("System is showing problem during login");
	FrontdeskLoginPage AL = GenericMethods.fn_OpenFrontdesk(br, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AppURL)));
	}
}



@Test(priority=1)
public void TC_14() throws Exception
{
	try
	{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		  AL.FrontDeskLogin(iTestCaseRow);
		Thread.sleep(3000);
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		String str=GenericMethods.GetCurrentWindowID();
		SampleRestaurantPage SRP=FP.ClickToSampleRestaurant();
		Thread.sleep(3000);
		GenericMethods.windowHandle(str);
		Assert.assertEquals(SRP.fn_VerifySampleRestaurantPage(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		Thread.sleep(3000);
		SRP.fn_VerifyGroupGenerateAndConfirmOrderPage();
		Thread.sleep(3000);
		SRP.fn_TransferToRoomButton();
		GenericMethods.Switch_Parent_Window(str);
        System.out.println("TC_14 Executed");
	}
	 catch(Exception e)
	   {

	    throw e;
	   }
}


//@Test(priority=2)
public void TC_15() throws Exception
{
	try
	{
   sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		  AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	FP.fn_ClickCancelButton();
    String str=GenericMethods.GetCurrentWindowID();
	LiveSupportLandingWindow LSL=FP.fn_ClickLiveSupportButton();
	GenericMethods.windowHandle(str);
	String title=LSL.fn_ValidateTitle();
	Thread.sleep(2000);
	Assert.assertEquals(title, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	LSL.fn_ValidateAllLeaveaMessageElements();
	GenericMethods.Switch_Parent_Window(str);
    System.out.println("TC_15 Executed");
	}
	 catch(Exception e)
	   {
	
	    throw e;
	   }
}



/*

@Test(priority=3)
public void TC_23() throws Exception
{
try{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		  AL.FrontDeskLogin(iTestCaseRow);
		CashCounterPage CCP=FCT.fn_ClickCountinueWithTrail_BT();
		String act=CCP.YesOpenNewCounter();
		Assert.assertEquals(act, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	    System.out.println("TC_23 Executed");
	    Reporter.log("TC_23: When 'Continue' button is clicked on Cash Counter Page,system displays a pop-up with message as:\n"
	    		+"'Please Select Counter'.",true);
	}

catch(Exception e)
 {
	 throw e;
 }
	}


@Test(priority=4)
public void TC_24() throws Exception
{

try{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		  AL.FrontDeskLogin(iTestCaseRow);
		CashCounterPage CCP=FCT.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
	Thread.sleep(4000);
		Assert.assertEquals(GenericMethods.driver.getTitle(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	    System.out.println("TC_24 Executed");
	    Reporter.log("TC_24: When 'Default Counter(Open)' is selected from dropdown and 'Continue' button is clicked on Cash Counter Page,system redirects user to Frontdesk landing page.",true);
	}
catch(Exception e)
 {

  throw e;
 }	}



@Test(priority=5)
public void TC_25() throws Exception
{
	try{

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
        AL.FrontDeskLogin(iTestCaseRow);
		CashCounterPage CCP=FCT.fn_ClickCountinueWithTrail_BT();
		String a=GenericMethods.GetCurrentWindowID();
		NightAuditVideoPage  NAV=CCP.ClickOnNightAuditVideoLink();
		GenericMethods.windowHandle(a);
		Thread.sleep(2000);
		String act=NAV.VerifyPage();
		Assert.assertEquals(act,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		GenericMethods.driver.close();
		GenericMethods.Switch_Parent_Window(a);
        System.out.println("TC_25 Executed");
        Reporter.log("TC_25: On clicking 'How to Perform Night Audit Video!' link on Cash Counter Page,system displays a new window for Night Audit Video.",true);
	}
	 catch(Exception e)
	   {
	   
	    throw e;
	   }


	}




//-----------Need to discuss-----------
@Test(priority=6)
public void TC_26() throws Exception
{
	try
	{ 
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
        AL.FrontDeskLogin(iTestCaseRow);
	    CashCounterPage CCP=FCT.fn_ClickCountinueWithTrail_BT();
	    String a=GenericMethods.GetCurrentWindowID();
	    NightAuditPdfPage NAP=CCP.ClickOnHowToUseLink();
	    GenericMethods.windowHandle(a);
	   String act= NAP.VerifyPage();
	   Thread.sleep(2000);
	   Assert.assertEquals(act, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	   Thread.sleep(2000);
	    GenericMethods.Switch_Parent_Window(a);
	    System.out.println("TC_26 Executed");
	    Reporter.log("TC_26: On clicking 'How to use?' link on Cash Counter Page,system starts downloading process of pdf file.",true);

	}
	 catch(Exception e)
	   {
	   
	   throw e;
	   }
}


@Test(priority=7)
public void TC_27() throws Exception
{
	try
	{

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
        AL.FrontDeskLogin(iTestCaseRow);
	    CashCounterPage CCP=FCT.fn_ClickCountinueWithTrail_BT();
	    String act= CCP.YesOpenNewCounter();
	    Assert.assertEquals(act,  ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	    Thread.sleep(3000);
	    Reporter.log("No Counter to Select", true);
	    System.out.println("TC_27 Executed");
	    Reporter.log("TC_27: When 'Yes' radio button is clicked for 'Open New Cash Counter?' message,system does not display any counter in 'Select Your Counter' dropdown list.",true);
	}

	 catch(Exception e)
	   {
	   e.getMessage();
	   throw e;
	   
	   }
}



@Test(priority=8)
public void TC_28_29_30() throws Exception
{
	try
	{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
        AL.FrontDeskLogin(iTestCaseRow);
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		String str=CCP.verify_pageHeader();
		Assert.assertEquals(str, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));

		Reporter.log("TC_28: Once a user enters login credential and clicks on 'Login' button,user gets redirected to Cash Counter Page in order to select cash counter.",true);

		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		String str1=FP.verifyTitle();
		Assert.assertEquals(str1, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));

        Reporter.log("TC_29: On selecting 'Default Counter(Open)' and clicking 'Continue' button,user gets redirected to Frontdesk page wherein a panel to 'Perform Night Audit' apear.",true);

		String str2=FP.fn_ClickCancelButton();
		Assert.assertEquals(str1, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
	    System.out.println("TC_28_29_30 Executed");

	    Reporter.log(" TC_30: When 'Cancel' button for 'Perform Night Audit' panel is clicked,system displays an alert with message as:\n"
	    		+"'Do you wish to continue', wherein accepting that alert displays Frontdesk page (Tapechart).",true);
	}
	 catch(Exception e)
	   {
	 
	   throw e;
	   }
}


@Test(priority=9)
public void TC_42_43_44_45_46() throws Exception
{
	try
	{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
        AL.FrontDeskLogin(iTestCaseRow);
        FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	FP.fn_ClickCancelButton();
	String str=GenericMethods.GetCurrentWindowID();
	SampleRestaurantPage SRP=FP.ClickToSampleRestaurant();
	GenericMethods.windowHandle(str);
	Thread.sleep(3000);
	String act=SRP.fn_VerifySampleRestaurantPage();
Assert.assertEquals(act, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	Reporter.log("TC_42: When 'Hlx_Restaurant' button on Frontdesk page,system redirects user to Hlx_Restaurant page.",true);

	OrderFromNewTab OFNT=SRP.ClickOnNewTab();
	String act1=OFNT.fn_verifynewTabTitle();
	Assert.assertEquals(act1, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
	Reporter.log("TC_43: When new tab on 'Hlx_Restaurant' page is clicked,system opens a new 'Order' tab.",true);

	String act2=OFNT.SelectAndGetProduct();
	Assert.assertEquals(act2, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));

	Reporter.log("TC_44: On entering an inclusion name in provided field,system displays the entered inclusion text.",true);

	OFNT.SelectRoomNumberandGuestname();
	OFNT.fn_getGuestName();

	Reporter.log("TC_45: When a Room no. is selected from 'Room#' dropdown,its respective guest name gets displayed in 'Select Guest' dropdown.",true);

	OrderFolioPage OFP=OFNT.fn_clkTransferToRoom();
	OFP.getFolioNumber();
	OFP.fn_verifyTransactionCloseButton();

	GenericMethods.Switch_Parent_Window(str);
	System.out.println("TC_42_43_44_45_46 Executed");

	Reporter.log("TC_46: On clicking 'Transfer To Room' button,a Folio# gets generated with folio no.",true);

	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }

}
@Test(priority=10)
 public void TC_47() throws Exception
 {
     try
     {
    	 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
 		ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
 		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
 		FrontdeskLoginPage AL=new FrontdeskLoginPage();
        AL.FrontDeskLogin(iTestCaseRow);
        FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
    	 Thread.sleep(4000);
    	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
    	 Thread.sleep(4000);
    	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
    	 Thread.sleep(4000);
    	 FP.fn_ClickCancelButton();
    	 String cwid=GenericMethods.GetCurrentWindowID();
    	 
    	 BasePage AH= FP.fn_NavigateAdmineConsole();
    	 GenericMethods.windowHandle(cwid);
    	 RoomsLandingPage  RLP=AH.roomsPageNavigate();
    	 AddRoomsPage ARP= RLP.click_AddRoom();
      
         ARP.AddRoomName(iTestCaseRow,Constant.File_livestableFrontdeskTestData);
         GenericMethods.Switch_Parent_Window(cwid);
 		 GenericMethods.driver.navigate().refresh();
 		 Thread.sleep(2000);
 		 FP.fn_ClickCancelButton();
         FP.fn_clickCurrentLnk();
         FP.getCountOfRooms1();
         FP.WindowScroll();
         FP.fn_SingleResrvTwoRoomNT();
         
         AddQuickReservationForm  AQRP= FP.fn_ChkinResrv1NT(iTestCaseRow);
         FP=AQRP.FillQuickResForm(iTestCaseRow, Constant.File_livestableFrontdeskTestData);
         FP.fn_verifyReservation();
         ViewDetailsPage VDP=FP.ClickOnViewlink();
         EnableEditingPage  EEP= VDP.ClickToEnableEditingBtn();
         
        ReservationSearchResultLandingPage RSP=FP.fn_SearchReservationID("042223");
    	 Thread.sleep(4000);
    	 ViewDetailsPage VDP1=RSP.fn_ClickOnSearchedRecord();
    	 Thread.sleep(4000);
    	 AccountStatementLandingPage ASP=VDP1.ClickToPayment();
    	 Thread.sleep(4000);
    	 ASP.AddOtherCharge();
    	 Thread.sleep(2000);
    	 ASP.fn_consolidateAcc();
    	 System.out.println("TC_47 Executed");

    	 Reporter.log("TC_47: When 'Consolidate Account' button is clicked on Account Statement page,Booking balance remains same.",true);
	 }
     catch(Exception e)
	   {
    	 throw e;
	   }

 }


@Test(priority=11)
public void TC_51() throws Exception
{
     try
     {
	 FrontdeskLoginPage FL=new FrontdeskLoginPage();
	 FrontdeskContinueTrialPage CP=FL.Frontdesklogin_20819();
	 Thread.sleep(4000);
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(4000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(4000);
	 FP.fn_ClickCancelButton();
	 Thread.sleep(4000);
	 ReservationSearchResultLandingPage RSP=FP.fn_SearchReservationID("042224");
	 Thread.sleep(4000);
	 ViewDetailsPage VDP=RSP.fn_ClickOnSearchedRecord();
	 Thread.sleep(4000);
	 EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
     Thread.sleep(4000);
     EEP.fn_clkAddOn();
     Thread.sleep(4000);
     EEP.verify_addedInclusion();
     System.out.println("TC_51 Executed");

     Reporter.log("TC_51: On clicking 'Inclusions/Add-ons' link under 'Rates/Packages' section on 'Enable Editing' page,system displays 'Select Add-ons' pop-up \n"
    		 +"wherein when an inclusion is selected and 'Done' button",true);
     }
     catch(Exception e)
	   {
	   e.getMessage();
	   }
}



//@Test(priority=12)
public void TC_52() throws Exception
{

     try
     {
	 FrontdeskLoginPage FL=new FrontdeskLoginPage();
	 FL.Frontdesklogin_20819();
	 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(4000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(4000);
	 FP.fn_ClickCancelButton();
	 Thread.sleep(4000);
	 ReservationSearchResultLandingPage RSP=FP.fn_SearchReservationID("042224");
	 Thread.sleep(4000);
	 ViewDetailsPage VDP=RSP.fn_ClickOnSearchedRecord();
	 Thread.sleep(4000);
	 EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
     Thread.sleep(6000);
     EEP.fn_addDate();
     System.out.println("TC_52 Executed");

     Reporter.log("TC_52: When active date link cooresponding to rate type under 'Rates/Packages' is clicked,breakup gets created on per night basis.",true);
     }
     catch(Exception e)
	   {
	   e.getMessage();
	   }
}





//@Test(priority=13)
public void TC_53_54() throws Exception
{
     try
     {

	 FrontdeskLoginPage FL=new FrontdeskLoginPage();
	 FL.Frontdesklogin_20819();
	 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(4000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(4000);
	 FP.fn_ClickCancelButton();
	 Thread.sleep(4000);
	 ReservationSearchResultLandingPage RSP=FP.fn_SearchReservationID("042224");
	 Thread.sleep(4000);
	 ViewDetailsPage VDP=RSP.fn_ClickOnSearchedRecord();
	 Thread.sleep(4000);
	 EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
     Thread.sleep(4000);
     EEP.fn_addeditDetails();
     Thread.sleep(4000);
     EEP.fn_editGuestDetail();
     System.out.println("TC_53_54 Executed");

     Reporter.log("TC_53: On clicking 'Add/Edit Detail' in a reservation,system displays a new form with title 'Guest Information' for editing details. \n"
    		 +"TC_54: When any of the guest detail like First Name and Last Name is changed and 'Save' button is clicked,reservation gets saved with new edited details.",true);
     }
     catch(Exception e)
	   {
	   e.getMessage();
	   }

}




//@Test(priority=14)
public void TC_55_56_57_58() throws Exception
{
     try
     {
	 FrontdeskLoginPage FL=new FrontdeskLoginPage();
	 FrontdeskContinueTrialPage CP=FL.Frontdesklogin_20819();
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(4000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(4000);
	 FP.fn_ClickCancelButton();
	 Thread.sleep(4000);
	 FP.fn_clickCurrentLnk();
	 Thread.sleep(7000);
	 FP.fn_verifyCheckinPopup();
	 String a=GenericMethods.GetCurrentWindowID();
	 CheckinCard CC=FP.fn_clkCheckin();
	 GenericMethods.windowHandle(a);
	 Thread.sleep(5000);
	 CC.fn_clkCloseBtn();
	 GenericMethods.Switch_Parent_Window(a);
	 FP.fn_verifyCnclCheckinPopup();
	 Thread.sleep(3000);
	 FP.fn_acceptCnclCheckinPopup();
	 
	 System.out.println("TC_55_56_57_58 Executed");
	 
	 Reporter.log("TC_55: On clicking 'Checkin' for a reservation on Frontdesk tapechart,system displays a pop-up for Checkin card. \n"
			 +"TC_56: When check-in pop-up is accepted,Check-in card gets displayed wherein when 'Close' button is clicked,reservation gets checked-in. \n"
			 +"TC_57: When 'Cancel Checkin' is clicked for a checked in reservation o frontdesk tapechart,system displays a pop-up with message as: \n"
			 +"'Do you wish to Unassign the reservation?' with an 'OK' and 'Cancel' butons. \n"
			 +"TC_58: When 'OK' button of 'Cancel Checkin' pop-up is clicked,system unassigns the reservation.",true);
	 }
     catch(Exception e)
	   {
	   e.getMessage();
	   }
}






//@Test(priority=15)
public void TC_59_60() throws Exception
{
     try
     {
	 FrontdeskLoginPage FL=new FrontdeskLoginPage();
	 FrontdeskContinueTrialPage CP=FL.Frontdesklogin_20819();
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(4000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(4000);
	 FP.fn_ClickCancelButton();
	 Thread.sleep(4000);
	 FP.fn_clickCurrentLnk();
	 Thread.sleep(7000);
	 FP.fn_verifyCheckinPopup();
	 String a=GenericMethods.GetCurrentWindowID();
	 CheckinCard CC=FP.fn_clkCheckin();
	 GenericMethods.windowHandle(a);
	 Thread.sleep(5000);
	 CC.fn_clkCloseBtn();
	 GenericMethods.Switch_Parent_Window(a);
	 Thread.sleep(4000);
	 FP.fn_cancelCheckin();
	 System.out.println("TC_59_60 Executed");

	 Reporter.log("TC_59: On clicking 'Checkin' for a reservation on Frontdesk tapechart,system displays a pop-up for Checkin card. \n"
	 		+ "TC_56: When check-in pop-up is accepted,Check-in card gets displayed wherein when 'Close' button is clicked,reservation gets checked-in. \n",true);
	 }
     catch(Exception e)
	   {
	   e.getMessage();
	   }

}



//@Test(priority=16)
public void TC_62() throws Exception
{
     try
     {
	 FrontdeskLoginPage FL=new FrontdeskLoginPage();
	 FrontdeskContinueTrialPage CP=FL.Frontdesklogin_20819();
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(4000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(4000);
	 FP.fn_ClickCancelButton();
	 Thread.sleep(4000);
	 FP.fn_clickCurrentLnk();
	 Thread.sleep(7000);
	 ReservationSearchResultLandingPage RSP=FP.fn_SearchReservationID("042526");
	 Thread.sleep(4000);
	 ViewDetailsPage VDP=RSP.fn_ClickOnSearchedRecord();
	 Thread.sleep(4000);
	 EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
     Thread.sleep(6000);
     EEP.fn_addExtraBed();
     Thread.sleep(5000);
     EEP.fn_clkSaveBtn();
     System.out.println("TC_62 Executed");

     Reporter.log("TC_62: When no. of extra beds say '1' is selected from 'Extra Bed' dropdown under 'Stay Details' section of a reservation and saved,reservation gets saved with one extra bed.",true);
     }
     catch(Exception e)
	   {
	   e.getMessage();
	   }
}


//@Test(priority=17)
public void TC_63() throws Exception
{

try
{
	 FrontdeskLoginPage FL=new FrontdeskLoginPage();
	 FrontdeskContinueTrialPage CP=FL.Frontdesklogin_20819();
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(4000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(4000);
	 FP.fn_ClickCancelButton();
	 Thread.sleep(4000);
	 FP.fn_clickCurrentLnk();
	 Thread.sleep(7000);
	 ReservationSearchResultLandingPage RSP=FP.fn_SearchReservationID("042223");
	 Thread.sleep(4000);
	 ViewDetailsPage VDP=RSP.fn_ClickOnSearchedRecord();
	 Thread.sleep(4000);
	 EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
     Thread.sleep(6000);
     EEP.fn_clkAmtForDisc();
     
     System.out.println("TC_63 Executed");

}
catch(Exception e)
 {
 e.getMessage();
 }
}





//@Test(priority=18)
public void TC_64_65_66() throws Exception
{
     try
     {
	 FrontdeskLoginPage FL=new FrontdeskLoginPage();
	 FrontdeskContinueTrialPage CP=FL.Frontdesklogin_20819();
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(4000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(4000);
	 FP.fn_ClickCancelButton();
	 Thread.sleep(4000);
	 FP.fn_clickCurrentLnk();
	 Thread.sleep(7000);
	 ViewDetailsPage VDP=FP.fn_rightclkViewDetailsGrp();
	 Thread.sleep(4000);
	 EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
     Thread.sleep(5000);
     GroupToSingleReservationPage GSP=EEP.fn_clkGuestName();
     Thread.sleep(4000);
     GSP.fn_verifyGuestName();
     GSP.fn_clkManageSharerLnk();
     Thread.sleep(4000);
     GSP.fn_verifyManageSharerTitle();
     //GSP.fn_clkManageSharerLnk();
     GSP.fn_checkSharerGuest();
     Thread.sleep(4000);
     GSP.fn_verifyManagerSharerYes();
     
     System.out.println("TC_64_65_66 Executed");
     }
     catch(Exception e)
	   {
	   e.getMessage();
	   }

}



//@Test(priority=19)
public void TC_67() throws Exception
{
    try
    {
    	FrontdeskLoginPage AL=new FrontdeskLoginPage();
    	FrontdeskContinueTrialPage CP=AL.FrontDesklogin_20787();
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		FP.fn_ClickCancelButton();
		//String str=GenericMethods.GetCurrentWindowID();
		ViewDetailsPage VDP=FP.fn_RightclkSingle(FrontdeskLandingPage.UNcheckinReserveID_G,FrontdeskLandingPage.rightClk_viewDetails);
		Thread.sleep(5000);
		EnableEditingPage EP=VDP.ClickToEnableEditingBtn();
		Thread.sleep(3000);
		GroupToSingleReservationPage GSP=EP.fn_ClickRoomReservationID();
		Thread.sleep(2000);
		GSP.fn_ClickAfterCheckInFirstGuest_Link();
		Thread.sleep(2000);
		GSP.fn_ClickBeforeCheckOut_Link();
		
        System.out.println("TC_67 Executed");
    }
    catch(Exception e)
	   {
	   e.getMessage();
	   }
}



//@Test(priority=20)
public void TC_68_69() throws Exception
{
    try
    {
    	FrontdeskLoginPage AL=new FrontdeskLoginPage();
    	Thread.sleep(5000);
    	AL.Frontdesklogin_20803();
    	Thread.sleep(5000);
    	CashCounterPage CCP=FCT.fn_ClickCountinueWithTrail_BT();
    	Thread.sleep(5000);
    	FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
    	Thread.sleep(5000);
    	FLP.fn_ClickCancelButton();
    	Thread.sleep(5000);
    	ReservationSearchResultLandingPage  RSR=FLP.fn_SearchReservationID("04239");
    	Thread.sleep(5000);
    	//used res#0222110 earlier
    	ViewDetailsPage VDP= RSR.fn_ClickOnSearchedRecord();
    	Thread.sleep(5000);
    	EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
    	Thread.sleep(5000);
    	EEP.fn_clkTaxExemptBtn();
    	EEP.verify_TETitle();
    	EEP.fn_selectTaxExempt();
    	Thread.sleep(5000);
    	EEP.fn_CalcTaxExempt();
        System.out.println("TC_68_69 Executed");
    }
    catch(Exception e)
	   {
	   e.getMessage();
	   }
}




//@Test(priority=21)
public void TC_71_72_73_74_75_76_77_78_79() throws Exception
{
    try
    {
    	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	    AL.FrontDesklogin_20787();
	    Thread.sleep(3000);
    	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
    	Thread.sleep(3000);
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		String str=GenericMethods.GetCurrentWindowID();
		SampleRestaurantPage SRP=FP.ClickToSampleRestaurant();
		Thread.sleep(3000);
		GenericMethods.windowHandle(str);
		SRP.fn_VerifySampleRestaurantPage();
		Thread.sleep(3000);
		ConfirmOrderPage COP=SRP.fn_GenerateOrder();
		Thread.sleep(5000);
		ConfirmOrderPage1 COP1=COP.ConfirmOrder();
		Thread.sleep(5000);
		COP1.fn_verifyConfirmedOrder();
		OrderFolioPage OFP=COP1.BillTransferToRoom("105");
		OFP.fn_TransferToRoomButton();
		Thread.sleep(5000);
		OFP.fn_verifyTransactionCloseButton();
		Thread.sleep(5000);
		GenericMethods.driver.close();
		Thread.sleep(4000);
		GenericMethods.Switch_Parent_Window(str);
		Thread.sleep(4000);
		AccountStatementLandingPage ASP=FP.fn_NavigatePayment1();
		Thread.sleep(6000);
		ASP.VerifyPaymentPage();
		ASP.verifyAlert_ConsolidateBtnAccept();
		Thread.sleep(6000);
        ASP.VerifyTransferedItem(OFP.folioId.trim(),OFP.folioTax);


	    System.out.println("TC_71_72_73_74_75_76_77_78_79 Executed");
	}
    catch(Exception e)
	   {
	   e.getMessage();
	   }

}




//@Test(priority=22)
public void TC_80_81() throws Exception
{
   try
   {
   FrontdeskLoginPage AL=new FrontdeskLoginPage();
   AL.Frontdesklogin_20819();
   FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
   CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
   Thread.sleep(4000);
   FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
   Thread.sleep(4000);
   FP.fn_ClickCancelButton();
   Thread.sleep(4000);
   String str=GenericMethods.GetCurrentWindowID();
   SampleRestaurantPage SRP=FP.ClickToSampleRestaurant();
   Thread.sleep(10000);
   GenericMethods.windowHandle(str);
   //SRP.fn_VerifySampleRestaurantPage();
   //SRP.fn_VerifyGenerateAndConfirmOrderPage();
   SRP.fn_GenerateOrder();
   Thread.sleep(4000);
   ConfirmOrderPage COP=new ConfirmOrderPage();
   COP.ConfirmOrder();
   Thread.sleep(4000);
   ConfirmOrderPage1 COP1=new ConfirmOrderPage1();
   COP1.fn_VerifyPayNowButton();
   Thread.sleep(7000);
   COP1.fn_verifyTransactionCloseButton();
   GenericMethods.driver.close();
   GenericMethods.Switch_Parent_Window(str);
   System.out.println("TC_80_81 Executed");
   }
   catch(Exception e)
	   {
	   e.getMessage();
	   }
}





//@Test(priority=23)
public void TC_82_83() throws Exception
{
    try
    {
    	FrontdeskLoginPage AL=new FrontdeskLoginPage();
    	Thread.sleep(5000);
    	AL.Frontdesklogin_20803();
    	Thread.sleep(5000);
    	CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
    	Thread.sleep(5000);
    	FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
    	Thread.sleep(5000);
    	FLP.fn_ClickCancelButton();
    	Thread.sleep(5000);
    	String a = GenericMethods.GetCurrentWindowID();
    	Thread.sleep(5000);
    	SampleRestaurantPage SRP = FLP.ClickToSampleRestaurant();
    	Thread.sleep(5000);
    	GenericMethods.windowHandle(a);
    	Thread.sleep(5000);
    	ConfirmOrderPage COP = SRP.GenrateOrder();
    	Thread.sleep(5000);
    	ConfirmOrderPage1 COP1 = COP.ConfirmOrder();
    	Thread.sleep(5000);
    	OrderFolioPage OFP=COP1.BillTransferToRoom("101");
		OFP.fn_TransferToRoomButton();
		Thread.sleep(5000);
		OFP.fn_verifyTransactionCloseButton();
		Thread.sleep(5000);
		GenericMethods.driver.close();
		Thread.sleep(4000);
		GenericMethods.Switch_Parent_Window(a);
		Thread.sleep(4000);
    	AccountStatementLandingPage ASL=FLP.fn_NavigatePayment();
//    	ReservationSearchResultLandingPage RSR = FLP.fn_SearchReservationID("042167");
//    	Thread.sleep(5000);
//    	ViewDetailsPage VDP = RSR.fn_ClickOnSearchedRecord();
//    	Thread.sleep(5000);
//    	AccountStatementLandingPage ASL = VDP.ClickToPayment();
    	Thread.sleep(5000);
    	ASL.verifyAlert_ConsolidateBtnAccept();
    	Thread.sleep(4000);
    	ASL.VerifyTransferedItem(OFP.folioId.trim(),OFP.folioTax);
    	Thread.sleep(2000);
	    System.out.println("TC_82_83 Executed");
	}
    catch(Exception e)
	   {
	   e.getMessage();
	   }

}





//@Test(priority=24)
public void TC_84_85() throws Exception
{
    try
    {
    	FrontdeskLoginPage AL=new FrontdeskLoginPage();
    	Thread.sleep(5000);
    	AL.Frontdesklogin_20803();
    	Thread.sleep(5000);
    	CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
    	Thread.sleep(5000);
    	FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
    	Thread.sleep(5000);
    	FLP.fn_ClickCancelButton();
    	Thread.sleep(5000);
    	ReservationSearchResultLandingPage RSR = FLP.fn_SearchReservationID("042168");
    	Thread.sleep(5000);
    	ViewDetailsPage VDP = RSR.fn_ClickOnSearchedRecord();
    	Thread.sleep(5000);
    	AccountStatementLandingPage ASL = VDP.ClickToPayment();
    	Thread.sleep(5000);
    	ASL.scroll_windowDown();
    	ASL.ClickToCustomCharge();
    	Thread.sleep(4000);
    	ASL.AddCustomCharge();
    	Thread.sleep(5000);
    	ASL.verifyAddedCustomCharge();
	    System.out.println("TC_84_85 Executed");
	}
    catch(Exception e)
	   {
	   e.getMessage();
	   }

}



//@Test(priority=25)
public void TC_86_87() throws Exception
{
	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		Thread.sleep(5000);
		AL.Frontdesklogin_20803();
		Thread.sleep(5000);
		CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(5000);
		FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
		Thread.sleep(5000);
		FLP.fn_ClickCancelButton();
		Thread.sleep(5000);
		ReservationSearchResultLandingPage RSR = FLP.fn_SearchReservationID("042169");
		Thread.sleep(5000);
		ViewDetailsPage VDP = RSR.fn_ClickOnSearchedRecord();
		Thread.sleep(5000);
		AccountStatementLandingPage ASL = VDP.ClickToPayment();
		Thread.sleep(5000);
		ASL.scroll_windowDown();
		ASL.VerifyOtherChargesPopUp();
		Thread.sleep(3000);
		ASL.AddOtherCharge();
		Thread.sleep(5000);
		ASL.VerifyOtherCharges();
	    System.out.println("TC_86_87 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }

}




//@Test(priority=26)
public void TC_88_89_90() throws Exception
{
	try
	{
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.Frontdesklogin_20819();
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(4000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
    Thread.sleep(4000);
    FP.fn_ClickCancelButton();
    Thread.sleep(4000);
    FP.fn_clickCurrentLnk();
    Thread.sleep(7000);
    FP.fn_NavigateAccountStmt();
    Thread.sleep(5000);
    AccountStatementLandingPage ASP=new  AccountStatementLandingPage();
    ASP.fn_DeletePerformaInvoice();
    System.out.println("TC_88_89_90 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }

}



//@Test(priority=27)
public void TC_92_93() throws Exception
{
	try
	{
	FrontdeskLoginPage FL=new FrontdeskLoginPage();
	FL.Frontdesklogin_20819();
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(4000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
    Thread.sleep(4000);
    FP.fn_ClickCancelButton();
    Thread.sleep(4000);
    FP.fn_clickCurrentLnk();
    Thread.sleep(7000);
    FP.fn_NavigateAccountStmt();
    Thread.sleep(3000);
    AccountStatementLandingPage ASP=new  AccountStatementLandingPage();
    ASP.fn_addOtherCharge();
    Thread.sleep(4000);
    ASP.fn_addCustomCharges();
    Thread.sleep(4000);
    ASP.fn_CustomChargetoNewFolio();
    Thread.sleep(4000);
    ASP.fn_verifyRouteToNewFolio();
    ASP.fn_selectGuestIDToNewFolio();
    Thread.sleep(4000);
    ASP.fn_getPICustomCharge();
    Thread.sleep(4000);
    ASP.windowScrollUp();
    ASP.fn_verifyRoutedFolio();
    //ASP.fn_routeToNewFolio();
    System.out.println("TC_92_93 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }

}




//@Test(priority=28)
public void TC_94_95() throws Exception
{
	try
	{
	FrontdeskLoginPage FL=new FrontdeskLoginPage();
	FL.Frontdesklogin_20819();
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(4000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
    Thread.sleep(4000);
    FP.fn_ClickCancelButton();
    Thread.sleep(4000);
    FP.fn_clickCurrentLnk();
    Thread.sleep(7000);
    FP.fn_NavigateAccountStmt();
    Thread.sleep(3000);
    AccountStatementLandingPage ASP=new  AccountStatementLandingPage();
    ASP.fn_addOtherCharge();
    Thread.sleep(4000);
    ASP.fn_addCustomCharges();
    Thread.sleep(3000);
    ASP.fn_CustomChargetoNewFolio();
    Thread.sleep(4000);
    ASP.fn_selectGuestIDToNewFolio();
    Thread.sleep(3000);
    //ASP.fn_getPICustomCharge();
    ASP.fn_RouteCharges();
    Thread.sleep(4000);
    ASP.fn_verifyRouteCharges();
   // ASP.fn_selectGuestIDRouteCharge1();
    ASP.fn_selectGuest2RouteCharge();
    Thread.sleep(4000);
    ASP.windowScrollUp();
    ASP.fn_verifyRoutedCustmChrgeG2();
    Thread.sleep(4000);
    ReservationFolioPage RFP=new ReservationFolioPage();
    RFP.fn_verifyRoutedCustomChrgTxt();
    System.out.println("TC_94_95 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
}



//@Test(priority=29)
public void TC_96_97() throws Exception
{
	try
	{
	FrontdeskLoginPage FL=new FrontdeskLoginPage();
	FL.Frontdesklogin_20819();
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(4000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
    Thread.sleep(4000);
    FP.fn_ClickCancelButton();
    Thread.sleep(4000);
    FP.fn_clickCurrentLnk();
    Thread.sleep(7000);
    FP.fn_NavigateAccountStmt();
    Thread.sleep(3000);
    AccountStatementLandingPage ASP=new  AccountStatementLandingPage();
    ASP.fn_addOtherCharge();
    Thread.sleep(4000);
    ASP.fn_addCustomCharges();
    Thread.sleep(4000);
    ASP.fn_CustomChargetoNewFolio1();
    Thread.sleep(4000);
    ASP.fn_selectGuestIDToNewFolio();
    Thread.sleep(4000);
    ASP.fn_clkPayNow();
    Thread.sleep(4000);
   // Thread.sleep(3000);
    ASP.fn_clkRoutePayment1();
    Thread.sleep(4000);
    ASP.fn_verifyRoutePaymentTitle();
    ASP.fn_selectGuest2RoutePayment();
    Thread.sleep(4000);
    ASP.windowScrollUp();
    ASP.fn_verifyRoutedPaymentChrgeG2();
    Thread.sleep(4000);
    ReservationFolioPage RSP=new ReservationFolioPage();
    RSP.fn_verifyRoutedPaymentTxt();
   // ASP.fn_clkRoutePayment1();
    //ASP.fn_routePaymentSave();
    System.out.println("TC_96_97 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
}




//@Test(priority=30)
public void TC_98_99() throws Exception
{
	try
	{
	FrontdeskLoginPage FL=new FrontdeskLoginPage();
	FL.Frontdesklogin_20819();
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(4000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
    Thread.sleep(4000);
    FP.fn_ClickCancelButton();
    Thread.sleep(4000);
    FP.fn_clickCurrentLnk();
    Thread.sleep(7000);
    FP.fn_NavigateAccountStmt();
    Thread.sleep(4000);
    AccountStatementLandingPage ASP=new  AccountStatementLandingPage();
    ASP.fn_addOtherCharge();
    Thread.sleep(4000);
    ASP.fn_addCustomCharges();
    Thread.sleep(4000);
    ASP.fn_clkRefundBtn();
    Thread.sleep(4000);
    ASP.fn_verifyRefundTitle();
    ASP.fn_clkRefund();
    Thread.sleep(4000);
    ASP.fn_verifyRefund();
    System.out.println("TC_98_99 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
}



//@Test(priority=31)
public void TC_100_101_102_103_104() throws Exception
{
	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
	    AL.Frontdesklogin_20857();
		Thread.sleep(3000);
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
//		ReservationSearchResultLandingPage RSL=FP.fn_SearchReservationID("042948");
//		Thread.sleep(3000);
//		ViewDetailsPage VDP=RSL.fn_ClickOnSearchedRecord();
//		Thread.sleep(3000);
//		AccountStatementLandingPage ASL=VDP.ClickToPayment();
//		Thread.sleep(3000);
		AccountStatementLandingPage ASL=FP.fn_NavigatePayment2();
		Thread.sleep(4000);
		ASL.fn_addOtherCharge();
		Thread.sleep(4000);
		ASL.fn_clkGenerateFolio();
		Thread.sleep(3000);
//		ASL.fn_ValidatePaidAMTby_Checqe();
//		Thread.sleep(3000);
		ASL.fn_getPINum();
		Thread.sleep(1000);
		ASL.fn_makeFullPayment();
		Thread.sleep(3000);
		ASL.fn_ClickSettleFolio_Accept();
		Thread.sleep(3000);
		//..............Need to modify this step.............//
	    //ASL.fn_ValidateLockFolio_IMG();
	    ASL.fn_LockFolio();
	   // ASL.fn_verifyLockFolioPopup();
	    ASL.fn_verifyLockedFolio();
		System.out.println("TC_100_101_102_103_104 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
}





//@Test(priority=32)
public void TC_115_116() throws Exception
{
	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
	    AL.FrontDesklogin_20787();
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		Thread.sleep(3000);
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
//		ReservationSearchResultLandingPage RSL=FP.fn_SearchReservationID("042515");
//		Thread.sleep(3000);
//		ViewDetailsPage VDP=RSL.fn_ClickOnSearchedRecord();
		ViewDetailsPage VDP=FP.fn_GrpAddOn();
		Thread.sleep(3000);
		EnableEditingPage EP=VDP.ClickToEnableEditingBtn();
		Thread.sleep(3000);
		EP.fn_ValidateInclusionAddOns_Link();
		EP.fn_ValidateSelectedIncluAddons();
        System.out.println("TC_115_116 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }

}




//@Test(priority=33)
public void TC_117() throws Exception
{
	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
	    AL.FrontDesklogin_20787();
		Thread.sleep(3000);
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		Thread.sleep(3000);
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		ViewDetailsPage VDP=FP.fn_RightclkforViewDetailsPage(FrontdeskLandingPage.GroupReservation_ID, FrontdeskLandingPage.rightClk_viewDetails);
        EnableEditingPage EP=VDP.ClickToEnableEditingBtn();
		Thread.sleep(3000);
		EP.fn_ChangePrice();
		Thread.sleep(5000);
		FP.fn_RightclkforViewDetailsPage(FrontdeskLandingPage.GroupReservation_ID, FrontdeskLandingPage.rightClk_viewDetails);
        VDP.ClickToEnableEditingBtn();
        Thread.sleep(3000);
        EP.fn_verifyChangedPrice();

        System.out.println("TC_117 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
}





//@Test(priority=34)
public void TC_118_119() throws Exception
{
	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
	    AL.FrontDesklogin_20787();
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		Thread.sleep(3000);
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		ViewDetailsPage VDP=FP.fn_RightclkforViewDetailsPage(FrontdeskLandingPage.GroupReservation_ID, FrontdeskLandingPage.rightClk_viewDetails);
		EnableEditingPage EP=VDP.ClickToEnableEditingBtn();
		Thread.sleep(2000);
		GroupToSingleReservationPage GRP=EP.fn_ClickRoomReservationID();
		Thread.sleep(3000);
		GRP.fn_ValidateExtraBed();
		Thread.sleep(3000);
		GRP.fn_ClickBackToGroup();
		Thread.sleep(3000);
		//EP.fn_clkGrpSave();
        System.out.println("TC_118_119 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
}




//@Test(priority=35)
public void TC_120() throws Exception
{
	try
	{
		 FrontdeskLoginPage AL=new FrontdeskLoginPage();
		 AL.FrontDesklogin_20787();
	     FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		 FP.fn_ClickCancelButton();
		 ViewDetailsPage VDP=FP.fn_RightclkforViewDetailsPage(FrontdeskLandingPage.GroupReservation_HarveshID, FrontdeskLandingPage.rightClk_viewDetails);
		 Thread.sleep(2000);
		 EnableEditingPage EP=VDP.ClickToEnableEditingBtn();
		 Thread.sleep(2000);
		 GroupToSingleReservationPage GRP=EP.fn_ClickAddGuestDetails_Link();
		 Thread.sleep(2000);
		 GRP.fn_FillGuestDetails();
		 Thread.sleep(2000);
		 GRP.fn_ClickBackToGroup();
		 Thread.sleep(2000);
		 EP.fn_ClickClearAndVerify_IMG(GRP.GuestName);
		 EP.fn_clkGrpSave();
         System.out.println("TC_120 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }

}




//@Test(priority=36)
public void TC_121_122() throws Exception
{
	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
	    AL.FrontDesklogin_20787();
	    Thread.sleep(2000);
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		Thread.sleep(2000);
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(2000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(2000);
		FP.fn_ClickCancelButton();
		Thread.sleep(2000);
		ViewDetailsPage VDP=FP.fn_RightclkforViewDetailsPage(FrontdeskLandingPage.GroupReservation_HarveshID, FrontdeskLandingPage.rightClk_viewDetails);
		Thread.sleep(2000);
		VDP.fn_ClickAddEditDetails_link();
		Thread.sleep(2000);
		VDP.fn_ChangeDetails();
        System.out.println("TC_121_122 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
}



//@Test(priority=37)
public void TC_123() throws Exception
{
	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		AL.FrontDesklogin_20787();
		Thread.sleep(4000);
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(4000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(4000);
		FP.fn_ClickCancelButton();
		Thread.sleep(4000);
		String str=GenericMethods.GetCurrentWindowID();
		FP.fn_RightclkforViewDetailsPage(FrontdeskLandingPage.GroupReservation_ForCheckIN, FrontdeskLandingPage.rightClk_CheckIN);
		Thread.sleep(5000);
		GenericMethods.windowHandle(str);
		GenericMethods.driver.close();
		GenericMethods.Switch_Parent_Window(str);
		Thread.sleep(4000);
		ViewDetailsPage VDP=FP.fn_RightclkforViewDetailsPage(FrontdeskLandingPage.GroupReservation_ForCheckIN, FrontdeskLandingPage.rightClk_viewDetails);
		Thread.sleep(2000);
		VDP.fn_ValidateCheckINstatus();
		Thread.sleep(4000);
		FP.fn_RightclkforViewDetailsPage(FrontdeskLandingPage.GroupReservation_ForCheckIN, FrontdeskLandingPage.rightClk_CancelCheckIN);
		GenericMethods.ActionOnAlert("Accept");
        System.out.println("TC_123 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
}





//@Test(priority=38)
public void TC_124_125_126() throws Exception
{
	try
	{
	FrontdeskLoginPage FL=new FrontdeskLoginPage();
	FL.Frontdesklogin_20819();
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(4000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
    Thread.sleep(4000);
    FP.fn_ClickCancelButton();
    Thread.sleep(4000);
    FP.fn_clickCurrentLnk();
    Thread.sleep(7000);
    FP.fn_rightClkGrpCheckin();
    Thread.sleep(4000);
    FP.fn_AcceptCancelCheckinGrp();
    Thread.sleep(4000);
    FP.fn_rightclkViewDetailsGrp1();
    Thread.sleep(4000);
    ViewDetailsPage VDP=new ViewDetailsPage();
    VDP.ClickToEnableEditingBtn();
    Thread.sleep(4000);
    EnableEditingPage EEP=new EnableEditingPage();
    EEP.fn_verifyCancelledCheckin();
    Thread.sleep(4000);
    EEP.fn_clkSingleGuest();
    Thread.sleep(4000);
    GroupToSingleReservationPage GSP=new GroupToSingleReservationPage();
    GSP.fn_clkCancelCheckinGrp();
    Thread.sleep(4000);
    EEP.fn_clkGrpSave();
    System.out.println("TC_124_125_126 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }

}





//@Test(priority=39)
public void TC_127_128() throws Exception
{
	try
	{
	FrontdeskLoginPage FL=new FrontdeskLoginPage();
	FL.Frontdesklogin_20819();
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(4000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
    Thread.sleep(4000);
    FP.fn_ClickCancelButton();
    Thread.sleep(4000);
    FP.fn_clickCurrentLnk();
    Thread.sleep(7000);
    FP.fn_rightclkViewDetailsGrp1();
    Thread.sleep(4000);
    ViewDetailsPage VDP=new ViewDetailsPage();
    VDP.ClickToEnableEditingBtn();
    Thread.sleep(4000);
    EnableEditingPage EEP=new EnableEditingPage();
    String a=GenericMethods.GetCurrentWindowID();
    EEP.fn_AcceptCheckinSelected();
    Thread.sleep(4000);
    CheckinCard CC=new CheckinCard();
    GenericMethods.windowHandle(a);
    CC.fn_verifyCheckedinGuest();
    GenericMethods.Switch_Parent_Window(a);
    Thread.sleep(4000);
    FP.fn_rightclkViewDetailsGrp1();
    Thread.sleep(4000);
    VDP.ClickToEnableEditingBtn();
    Thread.sleep(4000);
    EEP.fn_clkSingleGuest();
    Thread.sleep(4000);
    GroupToSingleReservationPage GSP=new GroupToSingleReservationPage();
    GSP.fn_clkCancelCheckinGrp();
    Thread.sleep(4000);
    EEP.fn_clkGrpSave();
    System.out.println("TC_127_128 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
}





//@Test(priority=40)
public void TC_129_130_131_132() throws Exception
{
	try
	{

		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		AL.Frontdesklogin_20803();
		CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
		FLP.fn_ClickCancelButton();
		ViewDetailsPage VDP=FLP.fn_GrpAddNewRoom();
		Thread.sleep(4000);
		 EnableEditingPage EEP= VDP.ClickToEnableEditingBtn();
		//FLP.fn_rightclkViewDetailsSingle(GenericMethods.driver.findElement(By.xpath("//div[@resrvid='4221090' and @title='73. Komal zINDAL(G)")));
		//GenericMethods.driver.findElement(By.xpath("//div[@resrvid='4221090' and @title='73. Komal zINDAL(G)"))
		Thread.sleep(3000);
		//new ViewDetailsPage().ClickToPayment();
		//Thread.sleep(5000);
		//EnableEditingPage EEP=new ViewDetailsPage().ClickToEnableEditingBtn();
		//Thread.sleep(3000);*
		EEP.AddNewRoomToG();
		Thread.sleep(2000);
		EEP.fn_addNewRoomDetail();
		Thread.sleep(3000);
		EEP.VerifyDeleteAlertAddedRoom("Accept");
		Thread.sleep(2000);
		EEP.VerifyDeletedRoom();
        System.out.println("TC_129_130_131_132 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
}




//@Test(priority=41)
public void TC_133_134_135() throws Exception
{
	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		AL.Frontdesklogin_20803();
		CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
		FLP.fn_ClickCancelButton();
		Thread.sleep(3000);
		ViewDetailsPage VDP=FLP.fn_GrpAddNewRoom();
		Thread.sleep(3000);
		EnableEditingPage EEP= VDP.ClickToEnableEditingBtn();
		Thread.sleep(3000);
		EEP.VerifyEarlyCheckInAlert();
		String a=GenericMethods.GetCurrentWindowID();
		CheckinCard CC=EEP.VerifyEarlyCheckInPopUp();
		//FLP.fn_rightclkViewDetailsSingle(GenericMethods.driver.findElement(By.xpath("//div[@resrvid='4230208' and @title='76. sougata mondal(G) ']")));
		//EnableEditingPage EEP=new ViewDetailsPage().ClickToEnableEditingBtn();
		GenericMethods.windowHandle(a);
		Thread.sleep(3000);
		CC.fn_clkCloseBtn();
		GenericMethods.Switch_Parent_Window(a);
		Thread.sleep(3000);
		//EEP.CheckInReservationAndVerifyCheckIn();
		FLP.fn_GrpAddNewRoom();
		Thread.sleep(2000);
		VDP.ClickToEnableEditingBtn();
		Thread.sleep(2000);
		GroupToSingleReservationPage GTSP=EEP.fn_clkSingleGuest();
		Thread.sleep(2000);
		GTSP.fn_clkCancelCheckinGrp();
		Thread.sleep(3000);
		EEP.fn_clkGrpSave();
        System.out.println("TC_133_134_135 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
}





//@Test(priority=42)
public void TC_136_137_138() throws Exception
{
	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		AL.Frontdesklogin_20803();
		CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
		FLP.fn_ClickCancelButton();
		ViewDetailsPage VDP=FLP.fn_GrpNoShow();
		Thread.sleep(3000);
		EnableEditingPage EEP= VDP.ClickToEnableEditingBtn();
		Thread.sleep(3000);
		EEP.VerifyNoShowPopUpTitle();
		Thread.sleep(2000);
		EEP.verify_NoShowTitle();
		//FLP.fn_rightclkViewDetailsSingle(GenericMethods.driver.findElement(By.xpath("//div[@resrvid='2315051' and @title='120. Hanshel Tiron(G) ']")));
		//EnableEditingPage EEP=new ViewDetailsPage().ClickToEnableEditingBtn();
		EEP.VerifyNoShowForReservation();
	    System.out.println("TC_136_137_138 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }

}




//@Test(priority=43)
public void TC_139_140_141() throws Exception
{
	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		AL.Frontdesklogin_20803();
		CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
		FLP.fn_ClickCancelButton();
		ViewDetailsPage VDP=FLP.fn_GrpDiscount();
		Thread.sleep(4000);
		EnableEditingPage EEP= VDP.ClickToEnableEditingBtn();
		Thread.sleep(2000);
		EEP.VerifyRateDetailPopUp();
		Thread.sleep(4000);
		//FLP.fn_rightclkViewDetailsSingle(GenericMethods.driver.findElement(By.xpath("//div[@resrvid='2315306' and @title='122. T pain(G)(A)']")));
		//EnableEditingPage EEP=new ViewDetailsPage().ClickToEnableEditingBtn();
		EEP.fn_applyDiscount();
		Thread.sleep(3000);
		FLP.fn_GrpDiscount();
		Thread.sleep(2000);
		VDP.ClickToEnableEditingBtn();
		Thread.sleep(2000);
		EEP.verify_DiscountAfterSave();
        System.out.println("TC_139_140_141 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
}



//@Test(priority=44)
public void TC_142_143_144() throws Exception
{
	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		AL.Frontdesklogin_20803();
		CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
		FLP.fn_ClickCancelButton();
		Thread.sleep(2000);
		ViewDetailsPage VDP=FLP.fn_GrpManageSharer();
		Thread.sleep(2000);
		EnableEditingPage EEP= VDP.ClickToEnableEditingBtn();
		Thread.sleep(3000);
	    GroupToSingleReservationPage GTSP=EEP.fn_ClickRoomReservationID();
	    Thread.sleep(3000);
	    GTSP.fn_clkManageSharerLnk();
	    Thread.sleep(3000);
	    GTSP.fn_verifyManageSharerTitle();
	    Thread.sleep(3000);
	    GTSP.fn_checkSharerGuest();
	    Thread.sleep(3000);
	    GTSP.fn_verifyManagerSharerYes();
	    Thread.sleep(3000);
	    GTSP.fn_ClickBackToGroup();
        System.out.println("TC_142_143_144 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
}



//@Test(priority=45)
public void TC_145_146() throws Exception
{
	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		AL.Frontdesklogin_20803();
		CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
		FLP.fn_ClickCancelButton();
		Thread.sleep(2000);
	    ViewDetailsPage VDP=FLP.fn_GrpManageSharer();
	    Thread.sleep(3000);
		EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
		Thread.sleep(3000);
		//FLP.fn_rightclkViewDetailsSingle(GenericMethods.driver.findElement(By.xpath("//div[@resrvid='2315442' and @title='127. deepak thayat(G)(A)']")));
		//new ViewDetailsPage().ClickToEnableEditingBtn();
		EEP.fn_SelectDateFrmDatePicker(EnableEditingPage.date_ChkInRoom, "Apr", "2016", "3");
		Thread.sleep(3000);
        //EEP.fn_clkGrpSave();
		System.out.println("TC_145_146 Executed");

	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
}




//@Test(priority=46)
public void TC_147_148() throws Exception
{
	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
	    AL.FrontDesklogin_20787();
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		ViewDetailsPage VDP=FP.fn_RightclkforViewDetailsPage(FrontdeskLandingPage.UNcheckinReserveID_G, FrontdeskLandingPage.rightClk_viewDetails);
		Thread.sleep(3000);
		EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
		Thread.sleep(3000);
		EEP.fn_ValidateOneDayBeforeCheckOut();
		Thread.sleep(5000);
		EEP.fn_clkGrpSave();
		Thread.sleep(5000);
		FP.fn_RightclkforViewDetailsPage(FrontdeskLandingPage.UNcheckinReserveID_G, FrontdeskLandingPage.rightClk_viewDetails);
		Thread.sleep(5000);
		VDP.ClickToEnableEditingBtn();
		Thread.sleep(5000);
		EEP.fn_SetPreviousCheckOutDate();
		Thread.sleep(3000);
		EEP.fn_clkGrpSave();
		//Thread.sleep(3000);
	    System.out.println("TC_147_148 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
}




//@Test(priority=47)
public void TC_149_150_151() throws Exception
{

	try
	{
		    FrontdeskLoginPage AL=new FrontdeskLoginPage();
		    AL.Frontdesklogin_20803();
			CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
			FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
			Thread.sleep(3000);
			FLP.fn_ClickCancelButton();
			Thread.sleep(2000);
			ReservationSearchResultLandingPage  RSR=FLP.fn_SearchReservationID("042614");
			Thread.sleep(2000);
			ViewDetailsPage VDP=RSR.fn_ClickOnSearchedRecord();
			Thread.sleep(3000);
			EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
			Thread.sleep(3000);
			GroupToSingleReservationPage GSR= EEP.ClickToRoomOrGuest();
			Thread.sleep(3000);
			GSR.fn_getRoomTax();
			Thread.sleep(2000);
			EEP.fn_clkTaxExemptBtn();
			Thread.sleep(3000);
			EEP.verify_TETitle();
			EEP.fn_selectTaxExempt();
			Thread.sleep(3000);
			EEP.ClickToRoomOrGuest();
			Thread.sleep(3000);
			GSR.fn_CalcTaxExemptGTS();
			Thread.sleep(3000);
			System.out.println("TC_149_150_151 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }

}



//@Test(priority=48)
public void TC_152() throws Exception
{

	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		AL.Frontdesklogin_20803();
		CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
		FLP.fn_ClickCancelButton();
		Thread.sleep(2000);
		ViewDetailsPage VDP=FLP.fn_GrpManageSharer();
		Thread.sleep(2000);
		//VDP.ClickToEnableEditingBtn();
		//ViewDetailsPage VDP=FLP.fn_rightclkViewDetailsSingle(GenericMethods.driver.findElement(By.xpath("//div[@resrvid='2315442' and @title='127. deepak thayat(G)(A)']")));
		EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
		Thread.sleep(2000);
		String payee=EEP.ChangePayTerm(1);
		Thread.sleep(2000);
		GenericMethods.driver.navigate().refresh();
		Thread.sleep(5000);
		FLP.fn_ClickCancelButton();
		Thread.sleep(2000);
		FLP.fn_GrpManageSharer();
		Thread.sleep(2000);
	    EnableEditingPage EEP1=VDP.ClickToEnableEditingBtn();
		EEP1.VerifyPayTerm(payee);
	    System.out.println("TC_152 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
}



//@Test(priority=49)
public void TC_153_154() throws Exception
{

	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		AL.Frontdesklogin_20803();
		CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
		FLP.fn_ClickCancelButton();
		Thread.sleep(2000);
		FLP.VerifyDNR();
	    System.out.println("TC_153_154 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
}




//@Test(priority=50)
public void TC_156_157() throws Exception
{

	try
	{
	  FrontdeskLoginPage AL=new FrontdeskLoginPage();
	  AL.Frontdesklogin_20819();
	  FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	  CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	  Thread.sleep(4000);
	  FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	  Thread.sleep(4000);
      FP.fn_ClickCancelButton();
      String str=GenericMethods.GetCurrentWindowID();
      SampleRestaurantPage SRP=FP.ClickToSampleRestaurant();
      GenericMethods.windowHandle(str);
      Thread.sleep(6000);
      //SRP.fn_VerifySampleRestaurantPage();
      SRP.fn_GenerateOrder();
      Thread.sleep(6000);
  	  ConfirmOrderPage COP=new ConfirmOrderPage();
  	  COP.fn_clkConfirmOrderGrp();
  	  Thread.sleep(6000);
  	  ConfirmOrderPage1 COP1=new ConfirmOrderPage1();
  	  Thread.sleep(3000);
      OrderFolioPage OFP=COP1.fn_clkTransferTotRoom();
      Thread.sleep(5000);
      OFP.fn_verifyTransactionCloseButton();
      Thread.sleep(4000);
      GenericMethods.Switch_Parent_Window(str);
      FP.WindowScroll();
      Thread.sleep(3000);
      AccountStatementLandingPage ASP=FP.fn_NavigateAccntstmtGenerateFolio();
      ASP.scroll_windowDown();
      Thread.sleep(4000);
      ASP.clk_ConsolidateBtn();
      Thread.sleep(4000);
      ASP.VerifyTransferedItem(OFP.folioId.trim(),OFP.folioTax);
      System.out.println("TC_156_157 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }

}




    //Auto Night Audit is being performed wherein postings needs to be checked manually


	//@Test(priority=51)
	public void TC_158_159_160_161() throws Exception
	{

		try
		{
			FrontdeskLoginPage AL=new FrontdeskLoginPage();
			AL.FrontDesklogin_20805();
			FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
			CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
			Thread.sleep(5000);
			FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
			Thread.sleep(5000);
			FP.fn_RefreshFrontdesk();
			Thread.sleep(5000);
			FP.fn_AutoNightAudit1();
			Thread.sleep(3000);
	        System.out.println("TC_158_159_160_161 Executed");
		}
		 catch(Exception e)
	 	   {
	 	   e.getMessage();
	 	   }
	}





//@Test(priority=52)
public void TC_162() throws Exception
{

      try
      {
	  FrontdeskLoginPage AL=new FrontdeskLoginPage();
	  AL.Frontdesklogin_20819();
	  FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	  CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	  Thread.sleep(4000);
	  FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	  Thread.sleep(4000);
      FP.fn_ClickCancelButton();
      String str=GenericMethods.GetCurrentWindowID();
      SampleRestaurantPage SRP=FP.ClickToSampleRestaurant();
      GenericMethods.windowHandle(str);
      Thread.sleep(6000);
      //SRP.fn_VerifySampleRestaurantPage();
      SRP.fn_GenerateOrder();
      Thread.sleep(6000);
  	  ConfirmOrderPage COP=new ConfirmOrderPage();
  	  COP.fn_clkConfirmOrderGrp();
  	  Thread.sleep(6000);
  	  ConfirmOrderPage1 COP1=new ConfirmOrderPage1();
  	  Thread.sleep(3000);
      OrderFolioPage OFP=COP1.fn_clkTransferTotRoom();
      Thread.sleep(5000);
      OFP.fn_verifyTransactionCloseButton();
      Thread.sleep(4000);
      GenericMethods.Switch_Parent_Window(str);
      FP.WindowScroll();
      Thread.sleep(3000);
      AccountStatementLandingPage ASP=FP.fn_NavigateAccntstmtGenerateFolio();
      ASP.scroll_windowDown();
      Thread.sleep(4000);
      ASP.clk_ConsolidateBtn();
      Thread.sleep(4000);
      ASP.VerifyTransferedItem(OFP.folioId.trim(),OFP.folioTax);
	  System.out.println("TC_162 Executed");
      }
      catch(Exception e)
	   {
	   e.getMessage();
	   }
}



	//@Test(priority=53)
	public void TC_163_164_165_166_167() throws Exception
	{

		try
		{
		  FrontdeskLoginPage FL=new FrontdeskLoginPage();
		  FL.Frontdesklogin_20819();
		  FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		  CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		  Thread.sleep(4000);
		  FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		  Thread.sleep(4000);
	      FP.fn_ClickCancelButton();
	      Thread.sleep(4000);
	      FP.fn_clickCurrentLnk();
	      Thread.sleep(7000);
          FP.fn_NavigateAccntstmtGenerateFolio();
          Thread.sleep(4000);
          AccountStatementLandingPage ASP=new  AccountStatementLandingPage();
          ASP.fn_addCustomChargesGrp();
          Thread.sleep(4000);
		  ASP.fn_addOtherChargeGFolio();
		  Thread.sleep(4000);
		  ASP.fn_clkGenerateFolio();
		  Thread.sleep(15000);
		  ASP.fn_verifyGeneratedFolio();
		  Thread.sleep(4000);
		  ASP.fn_clkGenerateFolio();
		  Thread.sleep(3000);
		  ASP.fn_clkTaxExemptBtn();
		  Thread.sleep(4000);
		  ASP.fn_saveTaxExempt();
		  Thread.sleep(4000);
		  ASP.fn_verifyTaxExempted();
		  Thread.sleep(4000);
		  ASP.fn_verifyGeneratedFolio();
		  System.out.println("TC_163_164_165_166_167 Executed");
		}
		 catch(Exception e)
	 	   {
	 	   e.getMessage();
	 	   }
	}




   //@Test(priority=54)
   public void TC_168_169() throws Exception
   {

	   try
	   {
	      FrontdeskLoginPage FL=new FrontdeskLoginPage();
		  FL.Frontdesklogin_20857();
	      FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		  CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		  Thread.sleep(4000);
		  FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		  Thread.sleep(4000);
	      FP.fn_ClickCancelButton();
	      Thread.sleep(4000);
	      FP.fn_clickCurrentLnk();
	      Thread.sleep(7000);
	      AccountStatementLandingPage ASP=FP.fn_NavigateAccntStmtGrp();
	      Thread.sleep(4000);
	      ASP.fn_addOtherChargeGrp();
          Thread.sleep(4000);
	      ASP.fn_RouteChargesGrp();
          Thread.sleep(3000);
          ASP.fn_verifyRCGrpTitle();
          Thread.sleep(2000);
	      ASP.fn_selectGuest2RouteChargeGrp();
	      Thread.sleep(5000);
	      ReservationFolioPage RSP=ASP.fn_verifyRoutedOtherChrgeG2Grp();
          Thread.sleep(3000);
          RSP.fn_verifyRoutedOtherChrgTxt();
          System.out.println("TC_168_169 Executed");
	   }
	   catch(Exception e)
 	   {
 	   e.getMessage();
 	   }
   }




    //@Test(priority=55)
    public void TC_170_171() throws Exception
    {

    	try
    	{
    	  FrontdeskLoginPage FL=new FrontdeskLoginPage();
   	      FL.Frontdesklogin_20857();
    	  FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		  CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		  Thread.sleep(4000);
		  FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		  Thread.sleep(4000);
	      FP.fn_ClickCancelButton();
	      Thread.sleep(4000);
	      FP.fn_clickCurrentLnk();
	      Thread.sleep(7000);
	      AccountStatementLandingPage ASP=FP.fn_NavigateAccntStmtGrp();
	      Thread.sleep(4000);
	      ASP.fn_addOtherChargeGrp();
	      Thread.sleep(4000);
	      ASP.fn_routeToNewFolioGrp();
	      Thread.sleep(3000);
	      ASP.fn_verifyRouteToNewFolioGrp();
	      Thread.sleep(2000);
	      ASP.fn_selectGuestIDToNewFolioGrp();
	      Thread.sleep(4000);
	      ASP.fn_getPINum();
	      Thread.sleep(4000);
	      ASP.fn_verifyRoutedFolio();
	      System.out.println("TC_170_171 Executed");
    	}
    	 catch(Exception e)
  	   {
  	   e.getMessage();
  	   }
    }




   //@Test(priority=56)
   public void TC_172_173() throws Exception
   {

	   try
	   {
	      FrontdeskLoginPage FL=new FrontdeskLoginPage();
	      FrontdeskContinueTrialPage CP=FL.Frontdesklogin_20857();
          Thread.sleep(3000);
		  CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		  Thread.sleep(4000);
		  FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		  Thread.sleep(4000);
	      FP.fn_ClickCancelButton();
	      Thread.sleep(4000);
	      FP.fn_clickCurrentLnk();
	      Thread.sleep(7000);
	      AccountStatementLandingPage ASP=FP.fn_NavigateAccntStmtGrp();
	      Thread.sleep(4000);
	      ASP.fn_clkPayNowGrp();
	      Thread.sleep(3000);
	      ASP.fn_verifyPaidAmt();
          Thread.sleep(3000);
	      ASP.fn_clkRoutePaymentGrp();
	      Thread.sleep(4000);
	      ASP.fn_routePaymentGrp();
	      Thread.sleep(4000);
	      ASP.fn_afterRoutePaymentPI();
	      Thread.sleep(4000);
	      ReservationFolioPage RFP=ASP.fn_clkFolio();
	      RFP.fn_verifyPaidAmt();
	      System.out.println("TC_172_173 Executed");
	   }
	   catch(Exception e)
 	   {
 	   e.getMessage();
 	   }
   }



    //@Test(priority=57)
    public void TC_174_175() throws Exception
    {

    	try
    	{
    	  FrontdeskLoginPage FL=new FrontdeskLoginPage();
   	      FL.Frontdesklogin_20857();
    	  FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		  CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		  Thread.sleep(4000);
		  FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		  Thread.sleep(4000);
	      FP.fn_ClickCancelButton();
	      Thread.sleep(4000);
	      FP.fn_clickCurrentLnk();
	      Thread.sleep(7000);
	      AccountStatementLandingPage ASP=FP.fn_NavigateAccntStmtGrp();
	      Thread.sleep(4000);
	      ASP.fn_addOtherChargeGrp();
	      Thread.sleep(4000);
	      ASP.fn_addCustomChargesGrp();
	      Thread.sleep(4000);
	      ASP.fn_clkRefundBtnGrp();
	      Thread.sleep(3000);
	      ASP.fn_verifyRefundTitle();
	      Thread.sleep(2000);
	      ASP.fn_clkRefund();
	      Thread.sleep(3000);
	      ASP.fn_verifyRefundGrp();
	      Thread.sleep(3000);
	      ASP.fn_payNowCheque();
	      Thread.sleep(4000);
	      ASP.fn_verifyPaidAmtChequeGrp();
	      System.out.println("TC_174_175 Executed");
    	}
    	 catch(Exception e)
  	   {
  	   e.getMessage();
  	   }
    }




    //@Test(priority=58)
    public void TC_176() throws Exception
    {

    	try
    	{
    	  FrontdeskLoginPage FL=new FrontdeskLoginPage();
   	      FL.Frontdesklogin_20857();
    	  FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		  CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		  Thread.sleep(4000);
		  FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		  Thread.sleep(4000);
	      FP.fn_ClickCancelButton();
	      Thread.sleep(4000);
	      FP.fn_clickCurrentLnk();
	      Thread.sleep(4000);
	      ViewDetailsPage VDP=FP.fn_rightClkViewDetailsGrp2();
	      Thread.sleep(4000);
	      EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
	      Thread.sleep(5000);
	      GroupToSingleReservationPage GSP=EEP.fn_clkGuestName();
	      Thread.sleep(4000);
	      AccountStatementLandingPage ASP=GSP.fn_clkPaymentSingleguest();
	      Thread.sleep(4000);
	      ASP.fn_payNowCheque();
	      Thread.sleep(4000);
	      ASP.fn_verifyPaidAmtChequeGrp();
	      System.out.println("TC_176 Executed");
    	}
    	 catch(Exception e)
  	   {
  	   e.getMessage();
  	   }
    }


   // @Test(priority=59)
    public void TC_177_178_179() throws Exception
    {

    	try
    	{
    	  FrontdeskLoginPage FL=new FrontdeskLoginPage();
   	      FL.Frontdesklogin_20858();
    	  FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		  CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		  Thread.sleep(4000);
		  FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		  Thread.sleep(4000);
	      FP.fn_ClickCancelButton();
	      Thread.sleep(4000);
	      FP.fn_clickCurrentLnk();
	      Thread.sleep(4000);
	      FP.fn_NavigateAccntStmtGrp1();
	      Thread.sleep(4000);
	      AccountStatementLandingPage ASP=new AccountStatementLandingPage();
          ASP.fn_addOtherChargeSetteFolio();
          Thread.sleep(4000);
          ASP.fn_clkGenerateFolio();
          Thread.sleep(15000);
          ASP.fn_clkSettleFolioAccept();
          Thread.sleep(4000);
          ASP.fn_getPINum();
          Thread.sleep(4000);
          ASP.fn_LockFolio();
          Thread.sleep(4000);
          ASP.fn_verifyLockFolioPopup();
          Thread.sleep(4000);
          ASP.fn_verifyLockedFolio();
          System.out.println("TC_177_178_179 Executed");
    	}
    	 catch(Exception e)
  	   {
  	   e.getMessage();
  	   }
    }




//@Test(priority=60)
public void TC_180_181_182_183_184_185_186_187_188() throws Exception
{

	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		Thread.sleep(2000);
		AL.Frontdesklogin_20803();
		Thread.sleep(2000);
		CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(2000);
		FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
		Thread.sleep(2000);
		FLP.fn_ClickCancelButton();
		Thread.sleep(2000);
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		Thread.sleep(2000);
		ExcelUtil.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Smoke1");
		Thread.sleep(2000);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		Thread.sleep(2000);
		String a=GenericMethods.GetCurrentWindowID();
		Thread.sleep(2000);
		WebReservationHomePage  WRH=FLP.ClickOnWebReservation();
		Thread.sleep(2000);
		GenericMethods.windowHandle(a);
		Thread.sleep(4000);
		WRH.fn_ValidateStaydetailsPage();
		Thread.sleep(4000);
		WebSelectRoomPage WSR= WRH.fn_CheckAvability();
		Thread.sleep(2000);
		WSR.fn_ValidateRoomPackagesSection();
		Thread.sleep(4000);
		WebAddMoreRoomPage WAM=WSR.SelectRoom();
		Thread.sleep(2000);
		WAM.fn_pageVerify();
		Thread.sleep(4000);
		WebConfirmReservationPage WCR=WAM.ClickOnConfirmBtn();
		Thread.sleep(2000);
		WCR.fn_ConfirmBookingPaymentPage();
		
		WebConfirmReservationPrintPage WCRP=WCR.ConfirmBooking(iTestCaseRow);
		Thread.sleep(2000);
		ArrayList<String> AmtDetails=WCRP.GetAmtDetails();
		Thread.sleep(2000);
		String rid=WCRP.GetReservationId();
		Thread.sleep(2000);
		WCRP.CloseWindow();
		Thread.sleep(2000);
		GenericMethods.Switch_Parent_Window(a);
//		Thread.sleep(2000);
//		GenericMethods.Alert_Accept();
//		Thread.sleep(2000);
//		GenericMethods.driver.close();
//		Thread.sleep(2000);
//		GenericMethods.fn_OpenFrontdesk("FF", "http://hotelogix.staygrid.com/frontdesk/login/login/");
//		Thread.sleep(2000);
//		FrontdeskLoginPage AL1=new FrontdeskLoginPage();
//		Thread.sleep(2000);
//		AL1.Frontdesklogin_20803();
//		Thread.sleep(2000);
//		CashCounterPage CCP1 = FCT.fn_ClickCountinueWithTrail_BT();
//		Thread.sleep(2000);
//		FrontdeskLandingPage FLP1 = CCP1.NoOpenNewcounter();
//		Thread.sleep(2000);
//		FLP1.fn_ClickOnCancelButton();
		Thread.sleep(2000);
		ReservationSearchResultLandingPage RSR= FLP.fn_SearchByReservationID(rid.trim());
		Thread.sleep(2000);
		ViewDetailsPage VDP= RSR.fn_ClickOnSearchedRecord();
		Thread.sleep(2000);
		ArrayList<String> amtDetails= VDP.GetAmtDetails();
		Thread.sleep(2000);
		Assert.assertEquals(AmtDetails, amtDetails);
		Thread.sleep(2000);
    System.out.println("TC_180_181_182_183_184_185_186_187_188 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }

}



//@Test(priority=61)
public void TC_189() throws Exception
{

	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
	    AL.FrontDesklogin_20787();
	    Thread.sleep(3000);
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	    CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	    Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		String str=GenericMethods.GetCurrentWindowID();
		WebReservationHomePage WRP =FP.fn_WebReservationLink();
		Thread.sleep(3000);
		GenericMethods.windowHandle(str);
		WebSelectRoomPage WSP=WRP.fn_CheckAvability();
		Thread.sleep(3000);
		WSP.pageVerify();
		Thread.sleep(3000);
		WSP.fn_SelectWebPackagesOnWeb();
	    GenericMethods.Switch_Parent_Window(str);
        System.out.println("TC_189 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
}




//@Test(priority=62)
public void TC_190() throws Exception
{

	try
	{
		    FrontdeskLoginPage AL=new FrontdeskLoginPage();
		    AL.FrontDesklogin_20787();
		    Thread.sleep(3000);
			FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
			CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
			Thread.sleep(3000);
			FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
			Thread.sleep(3000);
			FP.fn_ClickCancelButton();
		    Thread.sleep(3000);
		    String str=GenericMethods.GetCurrentWindowID();
		    BasePage BP=FP.fn_clkAdminLnk();
		    GenericMethods.windowHandle(str);
		    Thread.sleep(6000);
		    ListOfPackagesWeb LPW=BP.fn_navigateWebPkg();
		    Thread.sleep(6000);
		    PackageDetailsWeb PDW=LPW.clkEdit_1NPkg();
		    Thread.sleep(5000);
		    PDW.get_PkgName();
		    Thread.sleep(5000);
		    PDW.get_PublishedPkgPrice();
		    Thread.sleep(7000);
            PDW.clickOnSave_BT();
		    GenericMethods.driver.close();
		    GenericMethods.Switch_Parent_Window(str);
		    String str1=GenericMethods.GetCurrentWindowID();
			WebReservationHomePage WRP =FP.fn_WebReservationLink();
			GenericMethods.windowHandle(str1);
			Thread.sleep(3000);
			WebSelectRoomPage WSP=WRP.fn_CheckAvability();
			Thread.sleep(3000);
			WSP.verify_PublishedPkgPrice();
		    GenericMethods.Switch_Parent_Window(str1);
            System.out.println("TC_190 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }

}


//@Test(priority=63)
public void TC_191() throws Exception
{

	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
	    AL.FrontDesklogin_20787();
	    Thread.sleep(3000);
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	    CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	    Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		String str=GenericMethods.GetCurrentWindowID();
		BasePage BP=FP.fn_clkAdminLnk();
	    GenericMethods.windowHandle(str);
		Thread.sleep(6000);
		RoomPricesLandingPage RPL=BP.fn_navigatePriceManagerRP();
		Thread.sleep(4000);
        RPL.get_LastMinRate();
        RPL.clk_cancel();
	    Thread.sleep(7000);
	    GenericMethods.driver.close();
	    GenericMethods.Switch_Parent_Window(str);
		String str1=GenericMethods.GetCurrentWindowID();
		Thread.sleep(3000);
		WebReservationHomePage WRP =FP.fn_WebReservationLink();
		Thread.sleep(3000);
		GenericMethods.windowHandle(str1);
		Thread.sleep(4000);
		WebSelectRoomPage WSP=WRP.fn_CheckAvability();
		Thread.sleep(3000);
		WSP.verify_LastMinPrice();
	    GenericMethods.Switch_Parent_Window(str1);
        System.out.println("TC_191 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }

}


	//@Test(priority=64)
    public void TC_192_193() throws Exception
    {

		try
		{
			  FrontdeskLoginPage FL=new FrontdeskLoginPage();
	          FrontdeskContinueTrialPage CP = FL.FrontDesklogin_20787();
	          Thread.sleep(3000);
	          CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	          Thread.sleep(3000);
	          FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	          Thread.sleep(4000);
	          FP.fn_ClickCancelButton();
	          Thread.sleep(3000);
	          String str=GenericMethods.GetCurrentWindowID();
	          WebReservationHomePage WRP =FP.fn_WebReservationLink();
	          Thread.sleep(3000);
	          GenericMethods.windowHandle(str);
	          WebSelectRoomPage WSP=WRP.spclDisc_chkAvailability();
	          Thread.sleep(3000);
	          WSP.fn_getPkgPriceDisc();
	          Thread.sleep(3000);
	          WebMoreDetailsPage MDP=WSP.fn_clkMoreDetails();
	          Thread.sleep(3000);
	          MDP.fn_verifyPriceDisc();
	          Thread.sleep(3000);
              System.out.println("TC_192_193 Executed");
		}
		 catch(Exception e)
	 	   {
	 	   e.getMessage();
	 	   }
    }




    //@Test(priority=65)
    public void TC_194() throws Exception
    {

    	try
    	{
    		  FrontdeskLoginPage FL=new FrontdeskLoginPage();
	          FrontdeskContinueTrialPage CP = FL.FrontDesklogin_20787();
	          Thread.sleep(3000);
	          CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	          Thread.sleep(3000);
	          FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	          Thread.sleep(4000);
	          FP.fn_ClickCancelButton();
	          Thread.sleep(3000);
	          String str=GenericMethods.GetCurrentWindowID();
	          WebReservationHomePage WRP =FP.fn_WebReservationLink();
	          Thread.sleep(3000);
	          GenericMethods.windowHandle(str);
	          WebSelectRoomPage WSP= WRP.spclDisc_chkAvailability();
	          Thread.sleep(3000);
	          WebAddMoreRoomPage WAM= WSP.fn_SelectRoomandRate();
	          Thread.sleep(3000);
	          AddOnsPage AP=WAM.fn_ClickAddOnsLink();
	          Thread.sleep(3000);
	          AP.fn_SelectAddons();
	          Thread.sleep(3000);
	          WAM.fn_ValidateAddedAddOns();
              System.out.println("TC_194  Executed");
    	}
    	 catch(Exception e)
  	   {
  	   e.getMessage();
  	   }
    }



    //@Test(priority=66)
    public void TC_195_196() throws Exception
    {

    	try
    	{
    		FrontdeskLoginPage AL=new FrontdeskLoginPage();
    		Thread.sleep(2000);

    		AL.Frontdesklogin_20803();
    		Thread.sleep(2000);
    		CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
    		Thread.sleep(2000);
    		FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
    		Thread.sleep(2000);
    		FLP.fn_ClickCancelButton();
    		Thread.sleep(2000);
    		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
    		Thread.sleep(2000);
    		ExcelUtil.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Smoke1");
    		Thread.sleep(2000);
    		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
    		Thread.sleep(2000);
    		String a=GenericMethods.GetCurrentWindowID();
    		Thread.sleep(2000);
    		WebReservationHomePage  WRH=FLP.ClickOnWebReservation();
    		Thread.sleep(2000);
    		GenericMethods.windowHandle(a);
    		Thread.sleep(2000);
    		WebSelectRoomPage WSR= WRH.fn_CheckAvability();
    		Thread.sleep(2000);
    		WebAddMoreRoomPage WAM=WSR.SelectRoom();
    		Thread.sleep(2000);
    		WebConfirmReservationPage WCR=WAM.ClickOnConfirmBtn();
    		Thread.sleep(2000);
    		
    		WebConfirmReservationPrintPage WCRP=WCR.ConfirmBooking(iTestCaseRow);
    		Thread.sleep(2000);
    		String rid=WCRP.GetReservationId();
    		ArrayList<String> al2=WCRP.GetResrvDetails();
    		Thread.sleep(2000);
    		GenericMethods.driver.close();
    		GenericMethods.Switch_Parent_Window(a);
    		Thread.sleep(2000);
    		ReservationSearchResultLandingPage RSRP=FLP.fn_SearchByReservationID(rid.trim());
            RSRP.VerifyReservationById(rid.trim());
    		EmailAccountLoginPage EAL=GenericMethods.fn_OpenEmailBox("FF", "http://mail.stayezee.com/squirrelmail/src/login.php");
    		Thread.sleep(2000);

    		EmailHomePage EHP=EAL.DoSquirrelMailLogin();
    		Thread.sleep(2000);

    		EHP.GetAccountDetailsForGuest("Zara", "Web Booking confirmation for Reservation ID");
    		Thread.sleep(2000);
    		ArrayList <String>	a11=EHP.GetBookingAmtDetail();
    		Thread.sleep(2000);
    		Assert.assertEquals(al2, a11);
    		Thread.sleep(2000);
            System.out.println("TC_195_196 Executed");
    	}
    	 catch(Exception e)
  	   {
  	   e.getMessage();
  	   }
    }


   //@Test(priority=67)
   public void TC_197_198_199_200_201() throws Exception
   {

	   try
	   {
		   FrontdeskLoginPage AL=new FrontdeskLoginPage();
		   Thread.sleep(2000);
		   AL.Frontdesklogin_20803();
		   Thread.sleep(2000);
		   CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
		   Thread.sleep(2000);
		   FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
		   Thread.sleep(2000);
		   FLP.fn_ClickCancelButton();
		   Thread.sleep(2000);
		   sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		   Thread.sleep(2000);
		   ExcelUtil.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Smoke1");
		   Thread.sleep(2000);
		   iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		   Thread.sleep(2000);
		   String a=GenericMethods.GetCurrentWindowID();
		   Thread.sleep(2000);
		   WebReservationHomePage  WRH=FLP.ClickOnWebReservation();
		   Thread.sleep(2000);
		   GenericMethods.windowHandle(a);
		   Thread.sleep(2000);
		   WebSelectRoomPage WSR= WRH.fn_CheckAvability();
		   Thread.sleep(2000);
		   WebAddMoreRoomPage WAM=WSR.SelectRoom();
		   Thread.sleep(2000);
		   WebConfirmReservationPage WCR=WAM.ClickOnConfirmBtn();
		   Thread.sleep(2000);
		  
		   WebConfirmReservationPrintPage WCRP=WCR.ConfirmBooking(iTestCaseRow);
		   Thread.sleep(2000);
		   WCRP.CloseWindow();
		   Thread.sleep(2000);
		   GenericMethods.Switch_Parent_Window(a);
		   Thread.sleep(2000);
		   GenericMethods.driver.close();
		   Thread.sleep(2000);
		   EmailAccountLoginPage EAL=GenericMethods.fn_OpenEmailBox("FF", "http://mail.stayezee.com/squirrelmail/src/login.php");
		   Thread.sleep(2000);
		   EmailHomePage EHP=EAL.DoSquirrelMailLogin();
		   Thread.sleep(2000);
		   EHP.GetAccountDetailsForGuest("Zara", "Account Details");
		   Thread.sleep(2000);
		   gd=EHP.GetGuestLoginDetails();
		   Thread.sleep(2000);
		   GenericMethods.driver.close();
		   Thread.sleep(2000);
		   WebGuestConsoleLoginPage WGCL=GenericMethods.fn_OpenWebGuestConsolePage("FF", gd.get(0).toString());
		   Thread.sleep(2000);
   		   Assert.assertEquals("Web Reservation Login", GenericMethods.getText(GenericMethods.driver.findElement(By.xpath("//td[text()='Web Reservation Login']"))));
		   Thread.sleep(2000);
		   WebGuestConsoleLandingPage WGCLP=WGCL.DoLogin(gd.get(1).toString(),gd.get(2).toString(), gd.get(3).toString());
   	       Thread.sleep(2000);
   		   Assert.assertEquals("Reservation Details", GenericMethods.getText(WebGuestConsoleLandingPage.GuestReservationPageTitle).trim());
		   Thread.sleep(2000);
		   WebGuestStayDetailsPage WGS=WGCLP.ClickOnBookNow();
		   Thread.sleep(2000);
		   WGS.ValidateTitle();
		   WebGuestSelectRoomPage WGSR=WGS.fn_CheckAvability();
		   Thread.sleep(2000);
		   WebGuestAddMoreRoomPage WGAMR=WGSR.SelectRoom();
		   Thread.sleep(2000);
		   WebGuestConfirmReservationPage WGCRP=WGAMR.ClickOnConfirmBtn();
		   Thread.sleep(2000);
		   WGCRP.VerifyTitle();
		   WebGuestConfirmReservationPrintPage WCRPP=WGCRP.ConfirmBooking();
		   Thread.sleep(2000);
		   String rid=WCRPP.GetReservationId();
		   Thread.sleep(2000);
		   GenericMethods.driver.close();
		   Thread.sleep(2000);
		   FrontdeskLoginPage AL1 = GenericMethods.fn_OpenFrontdesk("FF", "http://hotelogix.staygrid.com/frontdesk/login/login/");
		   Thread.sleep(2000);
		   AL1.Frontdesklogin_20803();
		   Thread.sleep(2000);
		   CashCounterPage CCP1 = FCT.fn_ClickCountinueWithTrail_BT();
		   Thread.sleep(2000);
		   FrontdeskLandingPage FLP1 = CCP1.NoOpenNewcounter();
		   Thread.sleep(2000);
		   FLP1.fn_ClickOnCancelButton();
		   Thread.sleep(4000);
		   ReservationSearchResultLandingPage  RSR=FLP.fn_SearchByReservationID(rid.trim());
		   Thread.sleep(3000);
		   RSR.VerifyReservationById(rid.trim());

           System.out.println("TC_197_198_199_200_201 Executed");
	   }
	   catch(Exception e)
 	   {
 	   e.getMessage();
 	   }
   }




	//@Test(priority=68)
	public void TC_202_203_204_205() throws Exception
	{
		try
		{

		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		AL.FrontDesklogin_20805();
		Thread.sleep(3000);
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(5000);
		GenericMethods.driver.navigate().refresh();
		Thread.sleep(5000);
		FP.fn_AutoNightAudit1();
		Thread.sleep(3000);
		//FP.fn_ClickCancelButtonAlert();
		//Thread.sleep(3000);
		String str=GenericMethods.GetCurrentWindowID();
		AccountsLandingPage ALP=FP.fn_ClickAccounts_Link();
		Thread.sleep(5000);
		GenericMethods.windowHandle(str);
		Thread.sleep(3000);
		ALP.fn_ValidateAccountsPage();
		Thread.sleep(3000);
		ALP.fn_ClickHotel();
		Thread.sleep(3000);
		GenericMethods.Switch_Parent_Window(str);
	    System.out.println("TC_202_203_204_205 Executed");
		}
		 catch(Exception e)
	 	   {
	 	   e.getMessage();
	 	   }
	}



//@Test(priority=69)
public void TC_206_207_208() throws Exception
{

	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		AL.FrontDesklogin_20787();
		Thread.sleep(3000);
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		String str=GenericMethods.GetCurrentWindowID();
		ReportLandingPage RLP=FP.fn_ReportButton();
		Thread.sleep(3000);
		GenericMethods.windowHandle(str);
		Thread.sleep(3000);
		RLP.fn_VerifyReportPage();
		Thread.sleep(3000);
		RLP.fn_ClickOccupancyReport();
		Thread.sleep(3000);
		ORHouseCountReport HCR=RLP.fn_ClickHouseCountReport();
		Thread.sleep(3000);
		HCR.HouseCountReportSection();
		Thread.sleep(3000);
		HCR.fn_GetMonthlyReport();
		Thread.sleep(3000);
		HCR.fn_VerifySearchedDate();
	    GenericMethods.driver.close();
	    GenericMethods.Switch_Parent_Window(str);

        System.out.println("TC_206_207_208 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
}




//@Test(priority=70)
public void TC_209_210() throws Exception
{

	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
	    AL.FrontDesklogin_20787();
	    Thread.sleep(3000);
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		String str=GenericMethods.GetCurrentWindowID();
		ReportLandingPage RLP=FP.fn_ReportButton();
		Thread.sleep(3000);
		GenericMethods.windowHandle(str);
		Thread.sleep(3000);
		RLP.fn_ClickOFinancialReport();
		Thread.sleep(3000);
		FRMonthlySummeryReport MSR=RLP.fn_ClickMonthlySummaryReport_BT();
		Thread.sleep(3000);
		MSR.Fn_MonthlySummaryReportPage();
		MSR.fn_VerifyMonthlyReport("Jun", "2015");
		GenericMethods.driver.close();
	    GenericMethods.Switch_Parent_Window(str);
        System.out.println("TC_209_210 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
}


//@Test(priority=71)
public void TC_211_212() throws Exception
{

	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
	    AL.FrontDesklogin_20787();
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		String str=GenericMethods.GetCurrentWindowID();
		ReportLandingPage RLP=FP.fn_ReportButton();
		Thread.sleep(3000);
		GenericMethods.windowHandle(str);
		RLP.fn_ClickRevenueReport();
		Thread.sleep(3000);
		CashierReportPage MSR=RLP.fn_ClickCashierReport();
		Thread.sleep(3000);
		MSR.fn_InputDate("Default Counter", "-All POS Points/Frontdesk-");
		Thread.sleep(3000);
		MSR.fn_PrintWindowhandle();
		Thread.sleep(3000);
		MSR.DownloadNightAuditReportFile();
		Thread.sleep(3000);
		GenericMethods.driver.close();
	    GenericMethods.Switch_Parent_Window(str);
        System.out.println("TC_211_212 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
}



//@Test(priority=72)
public void TC_213_214() throws Exception
{

	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
	    AL.FrontDesklogin_20787();
		Thread.sleep(3000);
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		String str=GenericMethods.GetCurrentWindowID();
		ReportLandingPage RLP=FP.fn_ReportButton();
		Thread.sleep(3000);
		GenericMethods.windowHandle(str);
		RLP.fn_ReservationReport();
		Thread.sleep(3000);
		NoShowReportPage NSR=RLP.fn_NoShowReport_Link();
		Thread.sleep(3000);
		NSR.fn_InputDate();
		Thread.sleep(3000);
		NSR.fn_PrintWindowhandle();
		Thread.sleep(3000);
		NSR.DownloadNightAuditReportFile();
		GenericMethods.driver.close();
	    GenericMethods.Switch_Parent_Window(str);
        System.out.println("TC_213_214 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
}


//@Test(priority=73)
public void TC_215_216() throws Exception
{

	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
	    AL.FrontDesklogin_20787();
		Thread.sleep(3000);
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		Thread.sleep(3000);
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		String str=GenericMethods.GetCurrentWindowID();
		ReportLandingPage RLP=FP.fn_ReportButton();
		Thread.sleep(3000);
		GenericMethods.windowHandle(str);
		Thread.sleep(3000);
		RLP.fn_ClickOFinancialReport();
		Thread.sleep(2500);
		FRMonthlySummeryReport MSR=RLP.fn_ClickMonthlySummaryReport_BT();
		Thread.sleep(2500);
		MSR.fn_ClickPrintBT();
		Thread.sleep(5000);
		MSR.fn_PrintWindowhandle();
		Thread.sleep(3000);
		MSR.DownloadNightAuditReportFile();
		Thread.sleep(5000);
		GenericMethods.driver.close();
	    GenericMethods.Switch_Parent_Window(str);
        System.out.println("TC_215_216 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
}


//@Test(priority=74)
public void TC_217_218() throws Exception
{

	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
	    AL.FrontDesklogin_20787();
		Thread.sleep(3000);
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	    CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	    Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		String str=GenericMethods.GetCurrentWindowID();
		ReportLandingPage RLP=FP.fn_ReportButton();
		Thread.sleep(3000);
		GenericMethods.windowHandle(str);
		RLP.fn_DiscountReport();
		Thread.sleep(3000);
		DiscountAllowanceReportPage DARP=RLP.fn_DiscountAllowance_Link();
		Thread.sleep(3000);
		DARP.fn_InputDate("Default Counter", "-All POS Points/Frontdesk-");
		Thread.sleep(3000);
		DARP.fn_ClickPrintBT();
		Thread.sleep(5000);
		DARP.fn_PrintWindowhandle();
		Thread.sleep(3000);
		DARP.DownloadNightAuditReportFile();
		GenericMethods.driver.close();
	    GenericMethods.Switch_Parent_Window(str);
        System.out.println("TC_217_218 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
}




//@Test(priority=75)
public void TC_219_220() throws Exception
{

	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
	    AL.FrontDesklogin_20787();
		Thread.sleep(3000);
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		String str=GenericMethods.GetCurrentWindowID();
		ReportLandingPage RLP=FP.fn_ReportButton();
		Thread.sleep(3000);
		GenericMethods.windowHandle(str);
		RLP.fn_POSReport();
		Thread.sleep(3000);
	    DailySalesReportPage DSRP=RLP.fn_DailySalesReport_Link();
		Thread.sleep(3000);
		DSRP.fn_InputDate("Default Counter", "All POS Points");
		Thread.sleep(3000);
		DSRP.fn_ClickPrintBT();
		Thread.sleep(3000);
		DSRP.fn_PrintWindowhandle();
		Thread.sleep(3000);
		DSRP.DownloadNightAuditReportFile();
		GenericMethods.driver.close();
	    GenericMethods.Switch_Parent_Window(str);
        System.out.println("TC_219_220 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
}



   //@Test(priority=76)
	public void TC_221() throws Exception
   {

	   try
	   {
	    FrontdeskLoginPage AL=new FrontdeskLoginPage();
		AL.FrontDesklogin_20787();
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		FP.fn_ClickCancelButton();
		String str=GenericMethods.GetCurrentWindowID();
		ReportLandingPage RLP=FP.fn_ReportButton();
		GenericMethods.windowHandle(str);
		Thread.sleep(3000);
		RLP.fn_ClickOccupancyReport();
		ORHouseCountReport HCR=RLP.fn_ClickHouseCountReport();
		HCR.HouseCountReportSection();
		HCR.fn_GetMonthlyReport();
		GenericMethods.driver.close();
	    GenericMethods.Switch_Parent_Window(str);
	    System.out.println("TC_221 Executed");
	   }
	   catch(Exception e)
 	   {
 	   e.getMessage();
 	   }
	}



  // @Test(priority=77)
   public void TC_222() throws Exception
   {

   	try
   	{
   FrontdeskLoginPage AL=new FrontdeskLoginPage();
   AL.Frontdesklogin_20803();
   CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
   FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
   FLP.fn_ClickCancelButton();
   Thread.sleep(2000);
   ReservationSearchResultLandingPage  RSR=FLP.fn_SearchReservationID("042615");
   Thread.sleep(2000);
    ViewDetailsPage VDP=RSR.fn_ClickOnSearchedRecord();
   EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
   //ViewDetailsPage VDP=FLP.fn_rightclkViewDetailsSingle(GenericMethods.driver.findElement(By.xpath("//div[@resrvid='4250492' and @title='83. Tony Marle(G)(A)")));
   //EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
   int exp=EEP.CountRoomInGroup();
   EEP. AddRoomToGroup("King Suite","1","1");
   Thread.sleep(2000);
   GenericMethods.driver.navigate().refresh();
   FLP.fn_ClickCancelButton();
   Thread.sleep(2000);
   ReservationSearchResultLandingPage  RSR1=FLP.fn_SearchReservationID("042615");
   Thread.sleep(2000);
   ViewDetailsPage VDP1=RSR1.fn_ClickOnSearchedRecord();
   Thread.sleep(2000);
   EnableEditingPage EEP1=VDP1.ClickToEnableEditingBtn();
   //ViewDetailsPage VDP1=FLP.fn_rightclkViewDetailsSingle(GenericMethods.driver.findElement(By.xpath("//div[@resrvid='4250492' and @title='83. Tony Marle(G)(A)")));
   //EnableEditingPage EEP1=VDP1.ClickToEnableEditingBtn();
   int act=EEP1.CountRoomInGroup();
   Thread.sleep(2000);
   Assert.assertEquals(exp+1, act);
   Thread.sleep(2000);
   EEP1.DeleteAddedRoomFromGroup("042683");
   Thread.sleep(2000);
   System.out.println("TC_222 Executed");
   	}
    catch(Exception e)
	   {
	   e.getMessage();
	   }

   }
*/










/*@Test(priority=9)
public void TC_31_32_33() throws Exception{
try{
	
	 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	 ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	 iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
     AL.FrontDeskLogin(iTestCaseRow);
     FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	 Thread.sleep(4000);
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(4000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(4000);
	 FP.fn_ClickCancelButton();
	 String cwid=GenericMethods.GetCurrentWindowID();
	 
	 BasePage AH= FP.fn_NavigateAdmineConsole();
	 GenericMethods.windowHandle(cwid);
	 RoomsLandingPage  RLP=AH.roomsPageNavigate();
	 AddRoomsPage ARP= RLP.click_AddRoom();
 
     ARP.AddRoomName(iTestCaseRow,Constant.File_livestableFrontdeskTestData);
     GenericMethods.Switch_Parent_Window(cwid);
	 GenericMethods.driver.navigate().refresh();
	 Thread.sleep(2000);
	 FP.fn_ClickCancelButton();
     FP.fn_clickCurrentLnk();
     FP.WindowScroll();
     FP.SelectSingleAddedRoom(iTestCaseRow);
  
     AddQuickReservationForm AQRP  =FP.DragAndDrop();
 
 AddQuickReservationForm  AQRP1= FP.fn_ChkinResrv1NT(iTestCaseRow);
    FP=AQRP1.FillQuickResForm(iTestCaseRow);
    FP.fn_verifyReservation();
   
    
   
	 
	 
	 
	 
	 
	 
	 

	 System.out.println("TC_31_32_33 Executed");

	 Reporter.log("TC_31_32_33: Reservation created",true);
}
catch(Exception e)
  {
	
	 throw e;
  }	
	
		
	
}



@Test(priority=10)
public void TC_34() throws Exception{
	try{
	 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	 ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	 iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
     AL.FrontDeskLogin(iTestCaseRow);
     FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	 Thread.sleep(4000);
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(4000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(4000);
    FP.fn_ClickCancelButton();
    GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	 String cwid=GenericMethods.GetCurrentWindowID();
	 
	  BasePage AH= FP.fn_NavigateAdmineConsole();
	 GenericMethods.windowHandle(cwid);
	 RoomsLandingPage  RLP=AH.roomsPageNavigate();
	 AddRoomsPage ARP= RLP.click_AddRoom();
     ARP.saveAndDuplicate();
 
     GenericMethods.Switch_Parent_Window(cwid);
	 GenericMethods.driver.navigate().refresh();
	 Thread.sleep(2000);
     FP.fn_ClickCancelButton();
     FP.fn_clickCurrentLnk();
     FP.WindowScroll();
  
     AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
     FP=AQRP.FillQuickResForm(iTestCaseRow);
     
     Reporter.log("Reservation for 2 rooms created for 1 night", true);
	}
	catch(Exception e){
throw e;
}
	
}






@Test(priority=11)
public void TC_35_36() throws Exception{
try{
	 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	 ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	 iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
     AL.FrontDeskLogin(iTestCaseRow);
     FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	 Thread.sleep(4000);
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(4000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(4000);
     FP.fn_ClickCancelButton();
     GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	 String cwid=GenericMethods.GetCurrentWindowID();
	 
	  BasePage AH= FP.fn_NavigateAdmineConsole();
	 GenericMethods.windowHandle(cwid);
	 RoomsLandingPage  RLP=AH.roomsPageNavigate();
	 AddRoomsPage ARP= RLP.click_AddRoom();
     ARP.addRoomName();
 
     GenericMethods.Switch_Parent_Window(cwid);
	 GenericMethods.driver.navigate().refresh();
	 Thread.sleep(2000);
     FP.fn_ClickCancelButton();
     FP.fn_clickCurrentLnk();
     FP.WindowScroll();
     AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
     SingleReservationPage SRP= AQRP.FillQuickResvForm(iTestCaseRow);
     Thread.sleep(2000);
     Assert.assertEquals(GenericMethods.getText(SRP.title_SingleResPage).trim(),  ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
     FP=SRP.ClickOnReserve();
     FP.fn_verifyReservation();
    
     Reporter.log("Single Reservation page verified and Reserved.", true);
     
	
	
}
catch(Exception e){
throw e;
}
}






@Test(priority=12)
public void TC_37_38() throws Exception{
	try{
		 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		 ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
		 iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		 FrontdeskLoginPage AL=new FrontdeskLoginPage();
	     AL.FrontDeskLogin(iTestCaseRow);
	     FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		 Thread.sleep(4000);
		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		 Thread.sleep(4000);
		 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		 Thread.sleep(4000);
	     FP.fn_ClickCancelButton();
	     GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
		 String cwid=GenericMethods.GetCurrentWindowID();
		 BasePage AH= FP.fn_NavigateAdmineConsole();
		 GenericMethods.windowHandle(cwid);
		 RoomsLandingPage  RLP=AH.roomsPageNavigate();
		 AddRoomsPage ARP= RLP.click_AddRoom();
	     ARP.saveAndDuplicate();
	     GenericMethods.Switch_Parent_Window(cwid);
		 GenericMethods.driver.navigate().refresh();
		 Thread.sleep(2000);
	     FP.fn_ClickCancelButton();
	     FP.fn_clickCurrentLnk();
	     FP.WindowScroll();
	     AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
	    GroupReservationPage GRP= AQRP.FillQuickResvsForm(iTestCaseRow,AQRP.Link_GroupRes);
	     Thread.sleep(2000);
	     Assert.assertEquals(GenericMethods.getText(GRP.title_GroupResPage).trim(),  ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	     FP=GRP.ClickOnReserve();
	     FP.fn_verifyReservation();
	     Reporter.log("Group Reservation page verified and Reserved.", true);
}
catch(Exception e){
throw e;
}	
}

@Test(priority=13)
public void TC_37_1_39() throws Exception{
	try{
		 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		 ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
		 iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		 FrontdeskLoginPage AL=new FrontdeskLoginPage();
	     AL.FrontDeskLogin(iTestCaseRow);
	     FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		 Thread.sleep(4000);
		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		 Thread.sleep(4000);
		 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		 Thread.sleep(4000);
	     FP.fn_ClickCancelButton();
	     GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
		 String cwid=GenericMethods.GetCurrentWindowID();
		 BasePage AH= FP.fn_NavigateAdmineConsole();
		 GenericMethods.windowHandle(cwid);
		 RoomsLandingPage  RLP=AH.roomsPageNavigate();
		 AddRoomsPage ARP= RLP.click_AddRoom();
	     ARP.saveAndDuplicate();
	     GenericMethods.Switch_Parent_Window(cwid);
		 GenericMethods.driver.navigate().refresh();
		 Thread.sleep(2000);
	     FP.fn_ClickCancelButton();
	     FP.fn_clickCurrentLnk();
	     FP.WindowScroll();
	     AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
	     GroupReservationPage GRP= AQRP.FillQuickResvsForm(iTestCaseRow,AQRP.Link_AgentCorporate);
	     Thread.sleep(2000);
	     Assert.assertEquals(GenericMethods.getText(GRP.title_GroupResPage).trim(),  ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	     FP=GRP.ClickOnReserve();
	     FP.fn_verifyReservation();
	     Reporter.log("Group Reservation page verified and Reserved.", true);
}
catch(Exception e){
throw e;
}
}



@Test(priority=14)
public void TC_40() throws Exception{
try{
	 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	 ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	 iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
     AL.FrontDeskLogin(iTestCaseRow);
     FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	 Thread.sleep(4000);
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(4000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(4000);
     FP.fn_ClickCancelButton();
     GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	 String cwid=GenericMethods.GetCurrentWindowID();
	 BasePage AH= FP.fn_NavigateAdmineConsole();
	 GenericMethods.windowHandle(cwid);
	 RoomsLandingPage  RLP=AH.roomsPageNavigate();
	 AddRoomsPage ARP= RLP.click_AddRoom();
     ARP.addRoomName();
    GenericMethods.Switch_Parent_Window(cwid);
	 GenericMethods.driver.navigate().refresh();
	 Thread.sleep(2000);
    FP.fn_ClickCancelButton();
    FP.fn_clickCurrentLnk();
    FP.WindowScroll();
    AddQuickReservationForm AQRP  =FP.DragAndDropFor3N(ARP.rtype);
    FP=AQRP.FillQuickResForm(iTestCaseRow);
    Thread.sleep(2000);
    FP.fn_verifyReservation();
    Reporter.log("Single Reervation for 3 nights on Seasionals rate Verified and reservation is Reserved.", true);
	
		
}
catch(Exception e){
throw e;
}
}



@Test(priority=15)
public void TC_41() throws Exception{
try{
	 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	 ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	 iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
     AL.FrontDeskLogin(iTestCaseRow);
     FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	 Thread.sleep(4000);
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(4000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(4000);
     FP.fn_ClickCancelButton();
     GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	 String cwid=GenericMethods.GetCurrentWindowID();
	 BasePage BP= FP.fn_NavigateAdmineConsole();
	 GenericMethods.windowHandle(cwid);
	 RoomsLandingPage  RLP=BP.roomsPageNavigate();
	 AddRoomsPage ARP= RLP.click_AddRoom();
	 RLP= ARP.addRoomName();
	 BP=RLP.ClickOnLogo();
	 ListOfPackagesFrontdesk  FPL= BP.fn_navigateFrontDskPkg();
	 boolean res= FPL.VerifyPackage(iTestCaseRow);
	 FPL.CreatePackageAndAttachToFD(iTestCaseRow, res);
	String ti= GenericMethods.driver.getTitle();
	 GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	 GenericMethods.driver.navigate().refresh();
	 Thread.sleep(2000);
     FP.fn_ClickCancelButton();
     FP.fn_clickCurrentLnk();
     FP.WindowScroll();
     AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
     String selPak=AQRP.GetSelectedPackage(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)));
     String pkgPrice= AQRP.GetPrice();
     AQRP.FillQuickResvsFormBySelectingPak(iTestCaseRow,selPak);
     Thread.sleep(2000);
     GenericMethods.switchToWindowHandle(ti);
     FrontDeskPackageDetailPage FDP=FPL.clickOnPakEditlink(selPak);
     String rate=FDP.getPerNightPrice(ARP.rtype);
     Assert.assertEquals(rate.trim(), pkgPrice.trim());
     Reporter.log("Pakage Rate verify in the reservation", true);
   }
catch(Exception e){
		throw e;
}
}


@Test(priority=16)
public void TC_42_43_44_45_46_47() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
FrontdeskLoginPage AL=new FrontdeskLoginPage();
AL.FrontDeskLogin(iTestCaseRow);
FrontdeskContinueTrialPage FCT=new FrontdeskContinueTrialPage();
Thread.sleep(4000);
CashCounterPage CCP=FCT.fn_ClickCountinueWithTrail_BT();
Thread.sleep(4000);
FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
Thread.sleep(4000);
FP.fn_ClickCancelButton();
GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
String cwid=GenericMethods.GetCurrentWindowID();
BasePage BP= FP.fn_NavigateAdmineConsole();
GenericMethods.windowHandle(cwid);
RoomsLandingPage  RLP=BP.roomsPageNavigate();
AddRoomsPage ARP= RLP.click_AddRoom();
RLP= ARP.addRoomName();
GenericMethods.Switch_Parent_Window(cwid);
GenericMethods.driver.navigate().refresh();
Thread.sleep(2000);
FP.fn_ClickCancelButton();
FP.fn_clickCurrentLnk();
FP.WindowScroll();
AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
FP=AQRP.FillQuickResForm(iTestCaseRow);
FP.fn_verifyResFromDetailPage();
ViewDetailsPage VDP=FP.ClickOnViewlink();
String resId=VDP.GetResveration();
EnableEditingPage  EEP=VDP.ClickOnEnableEditing();
FP=EEP.CheckInSingleRes();
ReservationSearchResultLandingPage  RSR=FP.fn_SearchReservationID(resId);
VDP=RSR.fn_ClickOnSearchedRecord();
String resRoom=VDP.getRoomNum();
String tit=GenericMethods.driver.getTitle();
SampleRestaurantPage  SRP=VDP.ClickOnRestaurant();
Thread.sleep(2000);
GenericMethods.switchToWindowHandle("Sample Restaurant");
Thread.sleep(3000);
Assert.assertEquals(GenericMethods.driver.getTitle().trim(),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
Thread.sleep(2000);
OrderFromNewTab OFT=SRP.ClickOnNewTab();
Thread.sleep(2000);
Assert.assertEquals(GenericMethods.getText(OFT.Txt_OrderTab).trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
String addedProd=OFT.fn_addProduct();
OrderFolioPage  OFP=OFT.fn_transferOrderToRoom(resRoom);
System.out.println(OFT.guestName);
System.out.println(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Salutation))+" "+AQRP.fname+" "+AQRP.lname);
Assert.assertEquals(OFT.guestName.equalsIgnoreCase(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Salutation))+" "+AQRP.fname+" "+AQRP.lname),true);
TransactionListPage  TSL=OFP.fn_getFolioAndCloseTransaction();
String fnum=TSL.getFolioNumber(OFP.FNum);
Assert.assertTrue(fnum.equals(OFP.FNum));
GenericMethods.switchToWindowHandle(tit);
Thread.sleep(2000);
AccountStatementLandingPage  ASL=VDP.ClickToPayment();
String bRate=GenericMethods.getText(ASL.Txt_BookingTotal).trim();
ASL.fn_consolidateAccount("Accept");
Thread.sleep(2000);
String bRate1=GenericMethods.getText(ASL.Txt_BookingTotal).trim();
Thread.sleep(2000);
Assert.assertEquals(bRate, bRate1);
Reporter.log("Reservation made and pos transfer to room and booking total remains unchanged after consolidation", true);
}
catch(Exception e){
		throw e;
}
}


@Test(priority=17)
public void TC_48_49_51() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage FCT=new FrontdeskContinueTrialPage();
	Thread.sleep(4000);
	CashCounterPage CCP=FCT.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(4000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(4000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName();
	GenericMethods.Switch_Parent_Window(cwid);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	FP.WindowScroll();
	AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
	String Rackprice=AQRP.GetPrice();
	Thread.sleep(2000);
	Assert.assertEquals(AQRP.getAddQuickResTitle(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)).trim());
	Thread.sleep(2000);
	FP=AQRP.FillQuickResForm(iTestCaseRow);
	Thread.sleep(2000);
	
	
	FP.fn_verifyResFromDetailPage();
	ViewDetailsPage VDP=FP.ClickOnViewlink();
	String resId=VDP.GetResveration();
	EnableEditingPage EEP=VDP.ClickOnEnableEditing();
	EEP.fn_addingInclusionAddOn();
	System.out.println(EEP.text);
	System.out.println(GenericMethods.getText(EEP.Txt_AddedAddon));
	Assert.assertEquals(EEP.text.trim(), GenericMethods.getText(EEP.Txt_AddedAddon).trim());
	Reporter.log("Reservation has been made and addons added", true);
}
catch(Exception e){
	throw e;	
}
	
}




@Test(priority=18)
public void TC_50() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
FrontdeskLoginPage AL=new FrontdeskLoginPage();
AL.FrontDeskLogin(iTestCaseRow);
FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
Thread.sleep(4000);
CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
Thread.sleep(4000);
FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
Thread.sleep(4000);
FP.fn_ClickCancelButton();
GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
String cwid=GenericMethods.GetCurrentWindowID();
BasePage BP= FP.fn_NavigateAdmineConsole();
GenericMethods.windowHandle(cwid);
RoomsLandingPage  RLP=BP.roomsPageNavigate();
AddRoomsPage ARP= RLP.click_AddRoom();
RLP= ARP.saveAndDuplicate();
BP=RLP.ClickOnLogo();
ListOfPackagesFrontdesk  FPL= BP.fn_navigateFrontDskPkg();
boolean res= FPL.VerifyPackage(iTestCaseRow);
FPL.CreateAndAttachPackageToFD(iTestCaseRow, res);
String ti= GenericMethods.driver.getTitle();
GenericMethods.Switch_Parent_Window(cwid);
Thread.sleep(2000);
GenericMethods.driver.navigate().refresh();
Thread.sleep(2000);
FP.fn_ClickCancelButton();
FP.fn_clickCurrentLnk();
FP.WindowScroll();
AddQuickReservationForm AQRP  =FP.DragAndDropFor2N(ARP.rtype);
String selPak=AQRP.GetSelectedPackage(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)));
String pkgPrice= AQRP.GetPrice();
FrontdeskLandingPage  FLP=AQRP.FillQuickResvsFormBySelectingPak(iTestCaseRow,selPak);
FLP.fn_verifyReservation();
Reporter.log("Reservation made over Inclusive rate of package.", true);
	
}
catch(Exception e){
	throw e;
	
}
}



@Test(priority=19)
public void TC_55_56_57_58_59_60() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(4000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(4000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(4000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(3000);
	FP.WindowScroll();
	Thread.sleep(3000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor2N(ARP.rtype);
	FrontdeskLandingPage  FLP=AQRP.FillQuickResForm(iTestCaseRow);
	FLP.fn_verifyReservation();
	String tit=GenericMethods.GetTitle();
	FLP.fn_rightClickOnReservation(FLP.getWebElement(FLP.resvId));
	GenericMethods.clickElement(FLP.rightClk_CheckIN);
	Thread.sleep(2000);
	
	GenericMethods.ActionOnAlert("Accept");
	Thread.sleep(2000);
	GenericMethods.switchToWindowHandle("Room Reservation Check In");
	Thread.sleep(3000); 
    System.out.println(GenericMethods.GetTitle() +"Title here");
	Assert.assertEquals(GenericMethods.GetTitle().trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	GenericMethods.switchToWindowHandle(tit);
	String resStat=GenericMethods.GetWebElementAttributeValue(FLP.getWebElement(FLP.resvId),"rsvstatus");
	Thread.sleep(2000);
	Assert.assertEquals(resStat, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
	FLP.fn_rightClickOnReservation(FLP.getWebElement(FLP.resvId));
	GenericMethods.clickElement(FLP.rightClk_CancelCheckIN);
    GenericMethods.ActionOnAlert("Accept");
    Assert.assertEquals(GenericMethods.value.trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
	Thread.sleep(2000);
	String resStat1=GenericMethods.GetWebElementAttributeValue(FLP.getWebElement(FLP.resvId),"rsvstatus");
	Thread.sleep(3000);
	Assert.assertEquals(resStat1, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult4)));
	Thread.sleep(2000);
	FLP.fn_rightClickOnReservation(FLP.getWebElement(FLP.resvId));
	Thread.sleep(2000);
	GenericMethods.clickElement(FLP.rightClk_CheckIN);
	Reporter.log("Reservation made and checkin too.", true);
	GenericMethods.ActionOnAlert("Accept");
	Thread.sleep(2000);
	GenericMethods.switchToWindowHandle("Room Reservation Check In");
	Thread.sleep(3000);
	Assert.assertEquals(GenericMethods.GetTitle().trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	GenericMethods.switchToWindowHandle(tit);
	String resStat2=GenericMethods.GetWebElementAttributeValue(FLP.getWebElement(FLP.resvId),"rsvstatus");
	Thread.sleep(2000);
	Assert.assertEquals(resStat2, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
	}
catch(Exception e){
throw e;	
}
}



@Test(priority=20)
public void Tc_52_53_54() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(4000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(4000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(4000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(3000);
	FP.WindowScroll();
	Thread.sleep(3000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor2N(ARP.rtype);
	String tprice=AQRP.GetTotalPrice();
	String perNprice=AQRP.GetPrice().trim();
	System.out.println(perNprice);
	FrontdeskLandingPage  FLP=AQRP.FillQuickResForm(iTestCaseRow);
	a1.add(AQRP.fname);
	a1.add(AQRP.lname);
	 FLP.fn_verifyReservation();
	WebElement ele=FLP.getWebElement(FLP.resvId);
	GenericMethods.clickElement(ele);
	ViewDetailsPage VDP=FLP.ClickOnViewlink();
	EnableEditingPage EEP=VDP.ClickOnEnableEditing();
	EEP.ClickOnAddEditDetails();
	ArrayList<String> a2=EEP.getDetails();
	Thread.sleep(2000);
	Assert.assertTrue(a2.get(0).toString().equalsIgnoreCase(a1.get(0).toString()));
	Assert.assertTrue(a2.get(1).toString().equalsIgnoreCase(a1.get(1).toString()));
	ArrayList<String> a3=EEP.setDetails();
	Thread.sleep(2000);
	FLP=EEP.ClickOnSaveBtnOverEnableEditing();
	GenericMethods.clickElement(ele);
	VDP=FLP.ClickOnViewlink();
	EEP=VDP.ClickOnEnableEditing();
	EEP.ClickOnAddEditDetails();
	ArrayList<String> a4=EEP.getDetails();
	Thread.sleep(2000);
	Assert.assertTrue(a4.get(0).toString().equalsIgnoreCase(a3.get(2).toString()));
	Thread.sleep(2000);
	Assert.assertTrue(a4.get(1).toString().equalsIgnoreCase(a3.get(3).toString()));
	Reporter.log("Save details are verified", true);
	GenericMethods.clickElement(EEP.BtnguestInfo_Save);
	EEP.splitBookingDays();
	EEP.verifySplittedPrice(perNprice);
	Reporter.log("splited days price verified", true);
}
catch(Exception e){
throw e;
}
	
	
	
	
	
}



@Test(priority=21)
public void TC_61_62_63() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(4000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(4000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(4000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(3000);
	FP.WindowScroll();
	Thread.sleep(3000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor2N(ARP.rtype);
	AQRP.GetTotalPrice();
	String perNprice=AQRP.GetPrice().trim();
	System.out.println(perNprice);
	FrontdeskLandingPage  FLP=AQRP.FillQuickResForm(iTestCaseRow);
	String tprice=null;
    FLP.fn_verifyReservation();
	WebElement ele=FLP.getWebElement(FLP.resvId);
	GenericMethods.clickElement(ele);
	ViewDetailsPage VDP=FLP.ClickOnViewlink();
	EnableEditingPage EEP=VDP.ClickOnEnableEditing();
	EEP.giveDiscount(iTestCaseRow);
	Reporter.log("Discount is given to the guest and verified", true);
	}
catch(Exception e){
	throw e;
}
}


@Test(priority=22)
public void TC_71_72_73_74_75_76_77_78() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage FCT=new FrontdeskContinueTrialPage();
	Thread.sleep(4000);
	CashCounterPage CCP=FCT.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(4000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(4000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName();
	GenericMethods.Switch_Parent_Window(cwid);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	FP.WindowScroll();
	AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
	FP=AQRP.FillQuickResForm(iTestCaseRow);
	FP.fn_verifyResFromDetailPage();
	ViewDetailsPage VDP=FP.ClickOnViewlink();
	String resId=VDP.GetResveration();
	EnableEditingPage  EEP=VDP.ClickOnEnableEditing();
	FP=EEP.CheckInSingleRes();
	ReservationSearchResultLandingPage  RSR=FP.fn_SearchReservationID(resId);
	VDP=RSR.fn_ClickOnSearchedRecord();
	String resRoom=VDP.getRoomNum();
	String tit=GenericMethods.driver.getTitle();
	SampleRestaurantPage  SRP=VDP.ClickOnRestaurant();
	Thread.sleep(3000);
	GenericMethods.switchToWindowHandle("Sample Restaurant");
	Thread.sleep(3000);
	Assert.assertEquals(GenericMethods.driver.getTitle().trim(),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	Thread.sleep(2000);
	ConfirmOrderPage COP=SRP.generateOrder();
	Thread.sleep(2000);
	String orderTabText=GenericMethods.getText(COP.Text_OrderTab).trim();
	Thread.sleep(2000);
	Assert.assertEquals(orderTabText, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
	OrderFolioPage  OFP=COP.fn_transferOrderToRoom(resRoom);
	Thread.sleep(2000);
	TransactionListPage TLP=OFP.fn_getFolioAndCloseTransaction();
	Thread.sleep(2000);
	String fnum=TLP.getFolioNumber(OFP.FNum).trim();
	System.out.println(fnum);
	Thread.sleep(2000);
	GenericMethods.switchToWindowHandle("Frontdesk");
	AccountStatementLandingPage  ASL=VDP.ClickToPayment();
	Thread.sleep(2000);
	Assert.assertEquals(GenericMethods.getText(ASL.Text_AccountStatement).trim(), "ACCOUNT STATEMENT");
	ASL.fn_consolidateAccount("Accept");
	Thread.sleep(2000);
	Assert.assertEquals(GenericMethods.value, ASL.exp_msg);
	Thread.sleep(2000);
	ASL.getFolioNumberfromAccountNumber(fnum);
	Thread.sleep(2000);
	Reporter.log("Folio verified", true);
	Reporter.log("Reservation made and pos transfer to room and booking total remains unchanged after consolidation", true);
}
catch(Exception e){
	throw e;
}
}


*/

/*@Test(priority=23)
public void TC_79() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(4000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(4000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(4000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(3000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor2N(ARP.rtype);
	AQRP.GetTotalPrice();
	String perNprice=AQRP.GetPrice().trim();
	System.out.println(perNprice);
	FrontdeskLandingPage  FLP=AQRP.FillQuickResForm(iTestCaseRow);
	FLP.fn_verifyReservation();
	WebElement ele=FLP.getWebElement(FLP.resvId);
	GenericMethods.clickElement(ele);
	FLP.getRateFromViewPane();
	ViewDetailsPage VDP=FLP.ClickOnViewlink();
	
	
	String resId=VDP.GetResveration();
	EnableEditingPage  EEP=VDP.ClickOnEnableEditing();
	FP=EEP.CheckInSingleRes();
	ReservationSearchResultLandingPage  RSR=FP.fn_SearchReservationID(resId);
	VDP=RSR.fn_ClickOnSearchedRecord();
	String resRoom=VDP.getRoomNum();
	String tit=GenericMethods.driver.getTitle();
	
	SampleRestaurantPage  SRP=VDP.ClickOnRestaurant();
	Thread.sleep(2000);
	GenericMethods.switchToWindowHandle("Sample Restaurant");
	ConfirmOrderPage COP=SRP.generateOrder();
	Thread.sleep(2000);

	OrderFolioPage  OFP=COP.fn_transferOrderToRoom(resRoom);
	Thread.sleep(2000);
	TransactionListPage TLP=OFP.fn_getFolioAndCloseTransaction();
	Thread.sleep(2000);
	String fnum=TLP.getFolioNumber(OFP.FNum).trim();
	System.out.println(fnum);
	Thread.sleep(2000);
	GenericMethods.switchToWindowHandle("Frontdesk");
	AccountStatementLandingPage  ASL=VDP.ClickToPayment();
	Thread.sleep(2000);
    ASL.fn_consolidateAccount("Accept");
	Thread.sleep(2000);
	ASL.getFolioNumberfromAccountNumber(fnum);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	ContinueNightAuditPage  CNA=ASL.ClickOnPerformNightAudit();
	Thread.sleep(2000);
	IgnoreCounterNightAuditPage ICNA=CNA.ClickToContinueNightAudit();
	Thread.sleep(2000);
	NightAuditSummaryPage  NAS=ICNA.IgnoreCounterForNightAudit();
	Thread.sleep(2000);
	FP=NAS.clickOnContinueToWork();
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FLP.Btn_AutoNightAudit);
	Thread.sleep(2000);
	FP.fn_clickCurrentLnk();
	Thread.sleep(2000);
	//FP.WindowScroll();
	
	WebElement ele1=FLP.getWebElement(FLP.resvId);
	GenericMethods.clickElement(ele1);
	
 VDP=FLP.ClickOnViewlink();
 ASL=VDP.ClickToPayment();
 ASL.VerifyRoomRateAndTax("Seasonal Rate");
 String roomRate=GenericMethods.ExtractTheRate(ASL.postedRoomPrice);
 System.out.println("Room Rate:" + roomRate);
 String roomTax=GenericMethods.ExtractTheRate(ASL.postedRoomTax);
 System.out.println("Room TAx: "+ roomTax);
 System.out.println(AQRP.chargePerNight+ "per nyt from AQRP");
 Assert.assertEquals(Float.parseFloat(roomRate), AQRP.chargePerNight, 0.0f);
 
	
	float tax=(FLP.TotalCharge-AQRP.TotalCharge)/2;
	System.out.println("system calculated tax" +tax );
	
	Assert.assertEquals(Float.parseFloat(roomTax), tax, 0.0f);
	
	
	Reporter.log("Night audit performed",true);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
catch(Exception e){
throw e;
}
}*/


/*@Test(priority=0)
public void TC_80_81_82_83() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(4000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(4000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(4000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(3000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor2N(ARP.rtype);
	AQRP.GetTotalPrice();
	String perNprice=AQRP.GetPrice().trim();
	System.out.println(perNprice);
	FrontdeskLandingPage  FLP=AQRP.FillQuickResForm(iTestCaseRow);
	FLP.fn_verifyReservation();
	WebElement ele=FLP.getWebElement(FLP.resvId);
	GenericMethods.clickElement(ele);
	FLP.getRateFromViewPane();
	ViewDetailsPage VDP=FLP.ClickOnViewlink();
	String resId=VDP.GetResveration();
	EnableEditingPage  EEP=VDP.ClickOnEnableEditing();
	FP=EEP.CheckInSingleRes();
	ReservationSearchResultLandingPage  RSR=FP.fn_SearchReservationID(resId);
	VDP=RSR.fn_ClickOnSearchedRecord();
	String resRoom=VDP.getRoomNum();
	String tit=GenericMethods.driver.getTitle();
	SampleRestaurantPage  SRP=VDP.ClickOnRestaurant();
	Thread.sleep(2000);
	GenericMethods.switchToWindowHandle("Sample Restaurant");
	ConfirmOrderPage COP=SRP.generateOrder();
	Thread.sleep(2000);
    OrderFolioPage  OFP=COP.fn_transferOrderToRoom(resRoom);
	Thread.sleep(2000);
	TransactionListPage TLP=OFP.fn_getFolioAndCloseTransaction();
	Thread.sleep(2000);
	String fnum=TLP.getFolioNumber(OFP.FNum).trim();
	System.out.println(fnum);
	Thread.sleep(2000);
	GenericMethods.switchToWindowHandle("Frontdesk");
	AccountStatementLandingPage  ASL=VDP.ClickToPayment();
	Thread.sleep(2000);
    ASL.fn_consolidateAccount("Accept");
	Thread.sleep(2000);
	ASL.getFolioNumberfromAccountNumber(fnum);
	Reporter.log("Consolidate account successfully", true);
	
}
catch(Exception e){
	throw e;
}
}


@Test(priority=0)
public void TC_84_85_86_87() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(4000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(4000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(4000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(3000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
	FrontdeskLandingPage  FLP=AQRP.FillQuickResForm(iTestCaseRow);
	FLP.fn_verifyReservation();
	WebElement ele=FLP.getWebElement(FLP.resvId);
	FLP.fn_clkCheckin(ele);
	WebElement ele1=FLP.getWebElement(FLP.resvId);
	FLP.fn_rightClickOnReservation(ele1);
	AccountStatementLandingPage ASL=FLP.ClickOnPayment();
	GenericMethods.clickElement(ASL.Btn_CustomChargeBtn);
	Assert.assertEquals(GenericMethods.getText(ASL.Header_CustomChargeAllowance).trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	Reporter.log("Custom charge Allowances header verified", true);
	ASL.fn_addCustomCharges(iTestCaseRow);
	Thread.sleep(10000);
	String item=ASL.VerifyPostedCustomCharge(iTestCaseRow);
	Assert.assertEquals(item.trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Description)));
	Reporter.log("Posted cutom charge verified at account statement", true);
	GenericMethods.clickElement(ASL.Btn_OtherCharges);
	 Thread.sleep(2000);
	Assert.assertEquals(GenericMethods.getText(ASL.Header_OtherCharges).trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
    ASL.AddOtherCharge(iTestCaseRow);	
    Thread.sleep(2000);
    String itemOtherCharge=ASL.VerifyOtherCharges(ASL.selProduct);
    Thread.sleep(2000);
    System.out.println(itemOtherCharge);
    System.out.println(ASL.selProduct);
    Assert.assertEquals(itemOtherCharge.trim(), ASL.selProduct.trim());
    Reporter.log("Other charges posted and verify to Account statement ", true);
}
catch(Exception e){
throw e;
}
}



@Test(priority=0)
public void TC_88_89_90() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDeskLogin(iTestCaseRow);
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	Thread.sleep(4000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(4000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(4000);
	FP.fn_ClickCancelButton();
	GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
	String cwid=GenericMethods.GetCurrentWindowID();
	BasePage BP= FP.fn_NavigateAdmineConsole();
	GenericMethods.windowHandle(cwid);
	RoomsLandingPage  RLP=BP.roomsPageNavigate();
	AddRoomsPage ARP= RLP.click_AddRoom();
	RLP= ARP.addRoomName(); 
	GenericMethods.Switch_Parent_Window(cwid);
	Thread.sleep(2000);
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(2000);
	FP.fn_ClickCancelButton();
	FP.fn_clickCurrentLnk();
	Thread.sleep(3000);
	AddQuickReservationForm AQRP  =FP.DragAndDropFor1N(ARP.rtype);
	FrontdeskLandingPage  FLP=AQRP.FillQuickResForm(iTestCaseRow);
	FLP.fn_verifyReservation();
	WebElement ele=FLP.getWebElement(FLP.resvId);
	FLP.fn_clkCheckin(ele);
	WebElement ele1=FLP.getWebElement(FLP.resvId);
	FLP.fn_rightClickOnReservation(ele1);
	AccountStatementLandingPage ASL=FLP.ClickOnPayment();
	GenericMethods.clickElement(ASL.Btn_OtherCharges);
	ASL.AddOtherCharge(iTestCaseRow);	
    Thread.sleep(2000);
    GenericMethods.clickElement(ASL.Btn_GenerateFolio);
    Assert.assertEquals(ASL.Link_ToPerfomaInvoice.isDisplayed(),true);
    GenericMethods.clickElement(ASL.CB_PI);
    GenericMethods.clickElement(ASL.Btn_DeletePerfomaInvoice);
    GenericMethods.ActionOnAlert("Accept");
    Thread.sleep(2000);
    Assert.assertEquals(GenericMethods.value.trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
    Thread.sleep(2000);
    Assert.assertEquals(ASL.Text_NoFolioExist.isDisplayed(),true);
    Reporter.log("Folio created and deleted successfully", true);
}
catch(Exception e){
	throw e;
}
}
*/


//......................................................................//




































@AfterMethod
public void closeApp() throws Exception{
Set<String> handles = GenericMethods.driver.getWindowHandles();
for(String windowId: handles){
        GenericMethods.driver.switchTo().window(windowId);
        GenericMethods.driver.close();
}

}

}

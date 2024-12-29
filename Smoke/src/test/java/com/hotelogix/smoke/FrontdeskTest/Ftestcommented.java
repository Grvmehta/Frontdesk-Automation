package com.hotelogix.smoke.FrontdeskTest;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;

import com.hotelogix.smoke.admin.General.PayTypesPage;
import com.hotelogix.smoke.admin.General.TaxExemptListPage;
import com.hotelogix.smoke.admin.PosManager.POSPointsLandingPage;
import com.hotelogix.smoke.frontdesk.CashCounter.CashCounterPage;
import com.hotelogix.smoke.frontdesk.CashCounter.NightAuditPdfPage;
import com.hotelogix.smoke.frontdesk.CashCounter.NightAuditVideoPage;
import com.hotelogix.smoke.frontdesk.FrontdeskTrialPage.FrontdeskContinueTrialPage;
import com.hotelogix.smoke.genericandbase.BasePage;
import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;
import com.hotelogix.smoke.login.AdminLoginPage;
import com.hotelogix.smoke.login.FrontdeskLoginPage;

public class Ftestcommented {

	
	public WebDriver driver;
	private  String sTestCaseName;
	private int iTestCaseRow;
	public static ArrayList<String> a1=new ArrayList<String>();
	public static ArrayList<String> gd=new ArrayList<String>();
	FrontdeskContinueTrialPage FCT=new FrontdeskContinueTrialPage();


	//	<parameter name="browser" value="ch"/>
	@BeforeMethod
	public void LaunchApp() throws Throwable{

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		String br=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Browser));
		try
		{
			ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AppURL));
			GenericMethods.fn_OpenFrontdesk("br", ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AppURL)));
			//AL.Frontdesklogin_12725();
		}catch(Throwable e){
			Thread.sleep(4000);
			System.out.println("System is showing problem during login");
			GenericMethods.fn_OpenFrontdesk(br, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AppURL)));
		}
	}
	
	//	@Test()
	public void fn_addPrerequisites() throws Throwable{
		try{
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			FrontdeskLoginPage FL=new FrontdeskLoginPage();
			AdminLoginPage AL=FL.fn_verifyURL();
			BasePage BP=AL.adminlogin(iTestCaseRow);
			PayTypesPage PTP=BP.fn_NavigatePayTypes();
			PTP.fn_verifyPayTypeCount();
			TaxExemptListPage TEL=BP.fn_navigateToTaxExemptReason();
			TEL.fn_verifyTERCount(iTestCaseRow);
			POSPointsLandingPage POS=BP.fn_navigatePOSManagerPP();
			POS.fn_chkPOSTax();
		}catch(Throwable e){
			throw e;
		}
	}
	/*
	@Test(priority=1)
	public void TC_14() throws Throwable
	{
		try
		{
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			FrontdeskLoginPage AL=new FrontdeskLoginPage();
			 AL.FrontDeskLogin(iTestCaseRow)();
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
catch(Throwable e){
GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
		throw e;
}
}


	@Test(priority=2)
	public void TC_15() throws Throwable
	{
		try
		{
	   sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			FrontdeskLoginPage AL=new FrontdeskLoginPage();
			 AL.FrontDeskLogin(iTestCaseRow)();
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
		}catch(Throwable e){
		GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
		throw e;
		   }
	}

	

/*
	@Test(priority=3, description="When 'Continue' button is clicked on Cash Counter Page,system displays a pop-up with message as:\n"+"'Please Select Counter")
	public void  fn_verifyYesCounterPopUp() throws Throwable{ //TC_23()
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
			    //Thread.currentThread().getStackTrace()[1].getMethodName().
			}catch(Throwable e){
		GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
		throw e;
	}
	}
	
	
		@Test(priority=4, description="Select default counter and click continue button for landing frontdesk home page.")
		public void fn_verifyFrontdeskConsolePage() throws Throwable//TC_24
		{
		try{
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			FrontdeskLoginPage AL=new FrontdeskLoginPage();
			AL.FrontDeskLogin(iTestCaseRow);
			CashCounterPage CCP=FCT.fn_ClickCountinueWithTrail_BT();
			CCP.NoOpenNewcounter();
		    Thread.sleep(4000);
			Assert.assertEquals(GenericMethods.driver.getTitle(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		    System.out.println("TC_24 Executed");
		    Reporter.log("TC_24: When 'Default Counter(Open)' is selected from dropdown and 'Continue' button is clicked on Cash Counter Page,system redirects user to Frontdesk landing page.",true);
		}catch(Throwable e){
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}	
		}
	
	*/

	//@Test(priority=5, description="On clicking 'How to Perform Night Audit Video!' link on Cash Counter Page,system displays a new window for Night Audit Video.")
	public void fn_verifyNAVideoLinkCashCounterPage() throws Throwable{//TC_25
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
		}catch(Throwable e){
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	//
	//


	//@Test(priority=6, description="To verify PDF downloading page in cash counter page.")
	public void fn_verifyPDFDownloadingInCashCounterPage() throws Throwable//TC_26
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
		}catch(Throwable e){
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/*
	@Test(priority=7, description="Counter selected from dropdown.")
	public void fn_verifySelectYourCounterDropDown() throws Throwable//TC_27
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
		catch(Throwable e){
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
	}
	}*/
	/*
	@Test(priority=8, description="To verify land on frontdesk page.")
	public void fn_verifyTapeChartFDPage() throws Throwable//TC_28_29_30
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
	
			FP.fn_ClickCancelButton();
			Assert.assertEquals(str1, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
		    System.out.println("TC_28_29_30 Executed");
	
		    Reporter.log(" TC_30: When 'Cancel' button for 'Perform Night Audit' panel is clicked,system displays an alert with message as:\n"
		    		+"'Do you wish to continue', wherein accepting that alert displays Frontdesk page (Tapechart).",true);
		}catch(Throwable e){
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
	}
	}*/


/*	//   @Test(priority=8, description="To verify land on frontdesk page.")
	public void fn_CheckInButtonInQuickReservationForm() throws Exception{
		try{
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_livestableFrontdeskTestData,Constant.Sheet_Frontdesk2);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			FrontdeskLoginPage AL=new FrontdeskLoginPage();
			AL.FrontDeskLogin(iTestCaseRow);
			FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
			Thread.sleep(2000);
			CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
			Thread.sleep(2000);
			FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			String cwid=GenericMethods.GetCurrentWindowID();

			BasePage AH= FP.fn_NavigateAdmineConsole();
			GenericMethods.windowHandle(cwid);
			RoomsLandingPage  RLP=AH.roomsPageNavigate();
			AddRoomsPage ARP= RLP.click_AddRoom();

			String rtype=ARP.addRoomName(1);
			GenericMethods.Switch_Parent_Window(cwid);
			GenericMethods.driver.navigate().refresh();
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			FP.fn_clickCurrentLnk();
			AddQuickReservationForm AQRP  =FP.fn_createFDReserv(rtype,"3","4");

		}catch(Exception e){
			throw e;
		}
	}*/

	
	
}

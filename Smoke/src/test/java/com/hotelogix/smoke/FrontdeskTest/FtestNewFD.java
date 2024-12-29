package com.hotelogix.smoke.FrontdeskTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hotelogix.smoke.admin.PriceManager.FrontDeskPackageDetailPage;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesFrontdesk;
import com.hotelogix.smoke.admin.roommanager.RoomTaxesLandingPage;
import com.hotelogix.smoke.frontdesk.Accounts.AccountsLandingPage;
import com.hotelogix.smoke.frontdesk.Accounts.HotelLedgerLandingPage;
import com.hotelogix.smoke.frontdesk.Accounts.POSLedgerLandingPage;
import com.hotelogix.smoke.frontdesk.Accounts.POSPointLedgersListLandingPage;
import com.hotelogix.smoke.frontdesk.CashCounter.CashCounterPage;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.AddQuickReservationForm;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.FrontdeskLandingPage;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.GroupReservationPage;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.SingleReservationPage;
import com.hotelogix.smoke.frontdesk.FrontdeskTrialPage.FrontdeskContinueTrialPage;
import com.hotelogix.smoke.frontdesk.Payment.AccountStatementLandingPage;
import com.hotelogix.smoke.frontdesk.ReservationSearchResult.ReservationSearchResultLandingPage;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.ConfirmOrderPage;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.OrderFolioPage;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.OrderFromNewTab;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.SampleRestaurantPage;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.TransactionListPage;
import com.hotelogix.smoke.frontdesk.ViewDetailsPage.EnableEditingPage;
import com.hotelogix.smoke.frontdesk.ViewDetailsPage.ViewDetailsPage;
import com.hotelogix.smoke.genericandbase.BasePage;
import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;
import com.hotelogix.smoke.login.FrontdeskLoginPage;




public class FtestNewFD {
	
	private String rtype = "Deluxe";
	private String sTestCaseName;
	private int iTestCaseRow;
	public static ArrayList<String> a1 = new ArrayList<String>();
	public static ArrayList<String> gd = new ArrayList<String>();
	public static HashMap<String,Integer> hm=null;
	FrontdeskContinueTrialPage FCT = new FrontdeskContinueTrialPage();
	private FrontdeskLoginPage AL;
	private FrontdeskLandingPage FP;

	@BeforeTest
	public void LaunchApp() throws Throwable {
		

		sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
				Constant.Sheet_Frontdesk1);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
		//hm=ExcelUtil.creatingCollectionofTestcaseNames();
		//iTestCaseRow=hm.get(sTestCaseName);
		String br = ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Browser));
		try {
			ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AppURL));
			GenericMethods.fn_OpenFrontdesk(br,
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AppURL)));
			AL = new FrontdeskLoginPage();
			AL.FrontDeskLogin(iTestCaseRow);
			FrontdeskContinueTrialPage CP = new FrontdeskContinueTrialPage();
			Thread.sleep(2000);
			CashCounterPage CCP = CP.fn_ClickCountinueWithTrail_BT();
			Thread.sleep(5000);
			System.out.println("clicking continuebutton method");
			FP = CCP.fn_ClickContinueButton();

		} catch (Throwable e) {
			//Thread.sleep(4000);
			System.out.println("System is showing problem during login");
			e.printStackTrace();
			GenericMethods.fn_OpenFrontdesk(br,
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AppURL)));
			AL = new FrontdeskLoginPage();
			AL.FrontDeskLogin(iTestCaseRow);
			FrontdeskContinueTrialPage CP = new FrontdeskContinueTrialPage();
			Thread.sleep(2000);
			CashCounterPage CCP = CP.fn_ClickCountinueWithTrail_BT();
			Thread.sleep(2000);
			FP = CCP.fn_ClickContinueButton();
		}
	}
	
	@BeforeClass
	public void fn_creatingCollection() throws Throwable {// TC_31_32_33
		try {
			hm=ExcelUtil.creatingCollectionofTestcaseNames();
			String s1=LocalDate.now().toString();
			System.out.println(s1);
		}
		catch(Exception e)
		{
			throw e;
		}
		}

	
	@Test(priority = 1, description = "2 night single reservation created.")
	public void fn_create2NSingleReserv() throws Throwable {// TC_31_32_33
		try {

			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			//Assert.assertEquals(true, false);
			FP.fn_ClickCancelButton();
			Thread.sleep(6000);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "4");
			Thread.sleep(6000);
			FP = AQRP.FillQuickResForm(iTestCaseRow);
			FP.fn_verifyReservation();
			System.out.println("TC_31_32_33 Executed");
			Reporter.log("2 night single reservation created.", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

		@Test(priority = 2, description = "Reservation for 2 rooms created for 1 night")
	public void fn_create2Room1NReservation() throws Throwable {// TC_34
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			Thread.sleep(8000);
			FP.fn_ClickCancelButton();
			FP.fn_clickCurrentLnk();
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			Thread.sleep(6000);
			FP = AQRP.FillQuickResForm(iTestCaseRow);
			System.out.println("TC-34 Executed");
			Reporter.log("R  ed for 1 night", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
		
	@Test(priority = 3, description = "To create 1 room 1 night reservation & verify 'Single' link")
	public void fn_verify1Room1NSingleLnk() throws Throwable {// TC_35_36
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			FP.fn_ClickCancelButton();
			GenericMethods.js_Click(FrontdeskLandingPage.Current_Link);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			SingleReservationPage SRP = AQRP.FillQuickResvForm(iTestCaseRow);
			Thread.sleep(2000);
			Assert.assertEquals(GenericMethods.getText(SRP.title_SingleResPage).trim(),
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			FP = SRP.ClickOnReserve();
			FP.fn_verifyReservation();
			System.out.println("TC-35_36 Executed");
			Reporter.log("Single Reservation page verified and Reserved.", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 4, description = "To create 2 room 1 night reservation & verify 'Group' link")
	public void fn_verify2Room1NGroupLnk() throws Throwable {// TC_37_38
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			FP.fn_ClickCancelButton();
			GenericMethods.js_Click(FrontdeskLandingPage.Current_Link);
			Thread.sleep(2000);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			GroupReservationPage GRP = AQRP.FillQuickResvsForm(iTestCaseRow, AQRP.Link_GroupRes);
			Thread.sleep(2000);
			Assert.assertEquals(GenericMethods.getText(GRP.title_GroupResPage).trim(),
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Thread.sleep(2000);
			FP = GRP.ClickOnReserve();
			FP.fn_verifyReservation();
			System.out.println("TC-37_38 Executed");
			Reporter.log("Group Reservation page verified and Reserved.", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 5, description = "To create 1 room 1 night reservation & verify 'Agent/Corporate' link.")
	public void fn_verify2Room1NAgentCorpLnk() throws Throwable {// TC_37_1_39
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			FP.fn_ClickCancelButton();
			GenericMethods.js_Click(FrontdeskLandingPage.Current_Link);
			Thread.sleep(2000);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			GroupReservationPage GRP = AQRP.FillQuickResvsForm(iTestCaseRow, AQRP.Link_AgentCorporate);
			Thread.sleep(2000);
			Assert.assertEquals(GenericMethods.getText(GRP.title_GroupResPage).trim(),
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Thread.sleep(2000);
			FP = GRP.ClickOnReserve();
			FP.fn_verifyReservation();
			System.out.println("fn_verify2Room1NAgentCorpLnk Executed");
			Reporter.log("To create 1 room 1 night reservation & verify 'Agent/Corporate' link.", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 6, description = "To create 1 room 3 night reservation with rate as 'Seasonal Rate'.")
	public void fn_create1Room3NSeasonalRateReserv() throws Throwable {// TC_40
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			GenericMethods.js_Click(FrontdeskLandingPage.Current_Link);
			Thread.sleep(4000);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "5");
			FP = AQRP.FillQuickResForm(iTestCaseRow);
			Thread.sleep(2000);
			FP.fn_verifyReservation();
			System.out.println("TC-40 Executed");
			Reporter.log("To create 1 room 3 night reservation with rate as 'Seasonal Rate'.", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	/*//@Test(priority = 7, description = "To create 1 room 2 night reservation for Package with Inclusion as rate type.")
	public void 	() throws Throwable {// TC_41
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
			String cwid = GenericMethods.GetCurrentWindowID();
			BasePage BP = FP.fn_NavigateAdmineConsole();
			GenericMethods.windowHandle(cwid);
			//GenericMethods.windowHandle_admin();
			
			ListOfPackagesFrontdesk FPL = BP.fn_navigateFrontDskPkg();
			boolean res = FPL.VerifyPackage(iTestCaseRow);
			FPL.CreatePackageAndAttachToFD(iTestCaseRow, res);
			String ti = GenericMethods.driver.getTitle();
			GenericMethods.Switch_Parent_Window(cwid);
			Thread.sleep(2000);
			GenericMethods.driver.navigate().refresh();
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			FP.fn_clickCurrentLnk();
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "4");
			String selPak = AQRP.GetSelectedPackage(
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)));
			String pkgPrice = AQRP.GetPrice();
			AQRP.FillQuickResvsFormBySelectingPak(iTestCaseRow, selPak);
			Thread.sleep(2000);
			GenericMethods.switchToWindowHandle(ti);
			FrontDeskPackageDetailPage FDP = FPL.clickOnPakEditlink(selPak);
			String rate = FDP.getPerNightPrice(rtype);
			Assert.assertEquals(rate.trim(), pkgPrice.trim());
			GenericMethods.CloseWindow("Package");
			System.out.println("TC-41 Executed");
			Reporter.log("To create 1 room 2 night reservation for Package with Inclusion as rate type.", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}*/

	@Test(priority = 8, description = "To transfer POS order in reservation and verify 'Consolidate Account' button.")
	public void fn_verifyConsolidateAccAfterTransferToRMOrder() throws Throwable {// TC_42_43_44_45_46_47
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			Thread.sleep(2000);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			FP = AQRP.FillQuickResForm(iTestCaseRow);
			FP.fn_verifyResFromDetailPage();
			ViewDetailsPage VDP = FP.ClickOnViewlink();
			String resId = VDP.GetResveration();
			EnableEditingPage EEP = VDP.ClickOnEnableEditing();
			FP = EEP.CheckInSingleRes();
			ReservationSearchResultLandingPage RSR = FP.fn_SearchReservationID(resId);
			VDP = RSR.fn_ClickOnSearchedRecord();
			Thread.sleep(4000);
			String resRoom = VDP.getRoomNum();
			String tit = GenericMethods.driver.getTitle();
			SampleRestaurantPage SRP = VDP.ClickOnRestaurant();
			Thread.sleep(2000);
			GenericMethods.switchToWindowHandle("Sample Restaurant");
			Thread.sleep(3000);
			Assert.assertEquals(GenericMethods.driver.getTitle().trim().contains("Sample Restaurant"), true);
			Thread.sleep(2000);
			OrderFromNewTab OFT = SRP.ClickOnNewTab();
			Thread.sleep(2000);
			Assert.assertEquals(GenericMethods.getText(OFT.Txt_OrderTab).trim(),
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
			OFT.fn_addProduct();
			OrderFolioPage OFP = OFT.fn_transferOrderToRoom(resRoom);
			Assert.assertEquals(OFT.guestName.equalsIgnoreCase(
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Salutation)) + " "
							+ AQRP.fname + " " + AQRP.lname),
					true);
			TransactionListPage TSL = OFP.fn_getFolioAndCloseTransaction();
			String fnum = TSL.getFolioNumber(OFP.FNum);
			Assert.assertTrue(fnum.equals(OFP.FNum));
			GenericMethods.switchToWindowHandle(tit);
			Thread.sleep(2000);
			AccountStatementLandingPage ASL = VDP.ClickToPayment();
			String bRate = GenericMethods.getText(ASL.Txt_BookingTotal).trim();
			ASL.fn_consolidateAccount("Accept");
			Thread.sleep(2000);
			String bRate1 = GenericMethods.getText(ASL.Txt_BookingTotal).trim();
			Thread.sleep(2000);
			Assert.assertEquals(bRate1,bRate);
			System.out.println("TC-42_43_44_45_46_47 Executed");
			Reporter.log("To transfer POS order in reservation and verify 'Consolidate Account' button.", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 9, description = "To create 1 night reservation with rate type as 'Rack Rate' & verify addition of add-ons in reservation.")
	public void fn_create1NRackRateReservWithAddOns() throws Throwable {// TC_48_49_51
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			Thread.sleep(2000);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			AQRP.GetPrice();
			Thread.sleep(2000);
			Assert.assertEquals(AQRP.getAddQuickResTitle(),
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)).trim());
			Thread.sleep(2000);
			FP = AQRP.FillQuickResForm(iTestCaseRow);
			Thread.sleep(2000);
			FP.fn_verifyResFromDetailPage();
			ViewDetailsPage VDP = FP.ClickOnViewlink();
			VDP.GetResveration();
			EnableEditingPage EEP = VDP.ClickOnEnableEditing();
			GenericMethods.clickElement(EEP.Link_InclusionAddOns);
			EEP.fn_setAddOnsToReservation();
			Thread.sleep(2000);
			System.out.println("Selected addons is:::"+EEP.selectedAddOns);
			Assert.assertEquals(EEP.selectedAddOns.contains(GenericMethods.getText(EEP.Txt_AddedAddon).trim()), true);
			System.out.println("TC-48_49_51 Executed");
			Reporter.log(
					"To create 1 night reservation with rate type as 'Rack Rate' & verify addition of add-ons in reservation.",
					true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}

	}

	// @Test(priority=10, description="To create 1 room 2 night reservation with
	// rate type as Package (Inclusive of tax).")
	public void fn_create1R2NResevWithInclusiveOfTaxPkg() throws Throwable {// TC_50
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
			String cwid = GenericMethods.GetCurrentWindowID();
			BasePage BP = FP.fn_NavigateAdmineConsole();
			GenericMethods.windowHandle(cwid);
			RoomTaxesLandingPage RTLP = BP.roomTaxPageNavigate();
			// RTLP.fn_verifyTax()

			ListOfPackagesFrontdesk FPL = BP.fn_navigateFrontDskPkg();
			boolean res = FPL.VerifyPackage(iTestCaseRow);
			FPL.CreateAndAttachPackageToFD(iTestCaseRow, res);
			GenericMethods.driver.getTitle();
			GenericMethods.Switch_Parent_Window(cwid);
			Thread.sleep(2000);
			GenericMethods.driver.navigate().refresh();
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			FP.fn_clickCurrentLnk();
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "4");
			String selPak = AQRP.GetSelectedPackage(
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)));
			AQRP.GetPrice();
			FP = AQRP.FillQuickResvsFormBySelectingPak(iTestCaseRow, selPak);
			FP.fn_verifyReservation();
			GenericMethods.CloseWindow("Package");
			System.out.println("TC-50 Executed");
			Reporter.log("To create 1 room 2 night reservation with rate type as  Package (Inclusive of tax).", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 11, description = "To verify right click 'Check In' & 'Cancel Check In' in a single reservation.")
	public void fn_verifyRTClickCheckInAndCancelCheckIn() throws Throwable {// TC_55_56_57_58_59_60
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
		//	iTestCaseRow=22;
			Thread.sleep(3000);
			FP.fn_ClickCancelButton();
			Thread.sleep(3000);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "4");
			FP = AQRP.FillQuickResForm(iTestCaseRow);
			FP.fn_verifyReservation();
			String tit = GenericMethods.GetTitle();
			FP.fn_rightClickOnReservation(FP.getWebElement(FP.resvId));
			Thread.sleep(5000);
			FP.fn_RightClickCheckin();
			Thread.sleep(5000);
			GenericMethods.switchToWindowHandle("Room Reservation Check In");
			Thread.sleep(5000);
			// System.out.println(GenericMethods.GetTitle());
			// System.out.println(ExcelUtil.getCellData(iTestCaseRow,
			// ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Assert.assertEquals(GenericMethods.GetTitle().trim(),
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			GenericMethods.switchToWindowHandle(tit);
			String resStat = GenericMethods.GetWebElementAttributeValue(FP.getWebElement(FrontdeskLandingPage.resvId),
					"rsvstatus");
			Thread.sleep(3000);
			Assert.assertEquals(resStat,
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
			FP.fn_rightClickOnReservation(FP.getWebElement(FrontdeskLandingPage.resvId));
			GenericMethods.clickElement(FP.rightClk_CancelCheckIN);
			GenericMethods.ActionOnAlert("Accept");
			Assert.assertEquals(GenericMethods.value.trim(),
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
			Thread.sleep(2000);
			String resStat1 = GenericMethods.GetWebElementAttributeValue(FP.getWebElement(FrontdeskLandingPage.resvId),
					"rsvstatus");
			Thread.sleep(3000);
			Assert.assertEquals(resStat1,
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult4)));
			System.out.println("TC-55_56_57_58_59_60 Executed");
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 12, description = "To verify 'Add/Edit Detail' link & reservation price split per night basis.")
	public void fn_verifyAddEditGuestInfoAndPerNightPriceSplit() throws Throwable {// TC_52_53_54
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			GenericMethods.js_Click(FrontdeskLandingPage.Current_Link);
			Thread.sleep(2000);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "4");
			String perNprice = AQRP.GetPrice().trim();
			System.out.println(perNprice);
			FP = AQRP.FillQuickResForm(iTestCaseRow);
			a1.add(AQRP.fname);
			a1.add(AQRP.lname);
			FP.fn_verifyReservation();
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			GenericMethods.clickElement(ele);
			ViewDetailsPage VDP = FP.ClickOnViewlink();
			EnableEditingPage EEP = VDP.ClickOnEnableEditing();
			EEP.ClickOnAddEditDetails();
			ArrayList<String> a2 = EEP.getDetails();
			Thread.sleep(2000);
			Assert.assertTrue(a2.get(0).toString().equalsIgnoreCase(a1.get(0).toString()));
			Assert.assertTrue(a2.get(1).toString().equalsIgnoreCase(a1.get(1).toString()));
			ArrayList<String> a3 = EEP.setDetails();
			Thread.sleep(2000);
			FP = EEP.ClickOnSaveBtnOverEnableEditing();
			GenericMethods.clickElement(FP.getWebElement(FrontdeskLandingPage.resvId));
			VDP = FP.ClickOnViewlink();
			EEP = VDP.ClickOnEnableEditing();
			EEP.ClickOnAddEditDetails();
			ArrayList<String> a4 = EEP.getDetails();
			Thread.sleep(2000);
			Assert.assertTrue(a4.get(0).toString().equalsIgnoreCase(a3.get(2).toString()));
			Thread.sleep(2000);
			Assert.assertTrue(a4.get(1).toString().equalsIgnoreCase(a3.get(3).toString()));
			Reporter.log("Save details are verified", true);
			GenericMethods.clickElement(EEP.BtnguestInfo_Save);
			EEP.splitBookingDays();
			EEP.verifySplittedPrice(perNprice);
			System.out.println("TC-52_53_54 Executed");
			Reporter.log("To verify 'Add/Edit Detail' link & reservation price split per night basis.", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	@Test(priority = 16, description = "To verify 'Delete Performa Invoice' button in a single checked-in reservation.")
	public void fn_verifyDeletePerformaInvoicePopUp() throws Throwable {// TC_88_89_90
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			FP.fn_ClickCancelButton();
			GenericMethods.js_Click(FrontdeskLandingPage.Current_Link);
			Thread.sleep(2000);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			FP = AQRP.FillQuickResForm(iTestCaseRow);
			FP.fn_verifyReservation();
			Thread.sleep(2000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele);
			FP.fn_clkCheckin(ele);
			Thread.sleep(7000);
			WebElement ele1 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(5000);
			FP.fn_rightClickOnReservation(ele1);
			Thread.sleep(4000);
			AccountStatementLandingPage ASL = FP.ClickOnPayment();
			GenericMethods.clickElement(ASL.Btn_OtherCharges);
			ASL.AddOtherCharge(iTestCaseRow);
			Thread.sleep(2000);
			GenericMethods.clickElement(ASL.Btn_GenerateFolio);
			Assert.assertEquals(ASL.Link_ToPerfomaInvoice.isDisplayed(), true);
			GenericMethods.clickElement(ASL.CB_PI);
			GenericMethods.clickElement(ASL.Btn_DeletePerfomaInvoice);
			GenericMethods.ActionOnAlert("Accept");
			Thread.sleep(2000);
			Assert.assertEquals(GenericMethods.value.trim(),
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Thread.sleep(2000);
			Assert.assertEquals(ASL.Text_NoFolioExist.isDisplayed(), true);
			System.out.println("TC-88_89_90 Executed");
			Reporter.log("Folio created and deleted successfully", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	@Test(priority = 18, description = "To verify 'Refund' button in 1 night single checked-in reservation..")
	public void fn_verifyRefund() throws Throwable {// TC_98_99
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
		//	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			GenericMethods.js_Click(FrontdeskLandingPage.Current_Link);
			Thread.sleep(2000);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			FP = AQRP.FillQuickResForm(iTestCaseRow);
			FP.fn_verifyReservation();
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele);
			Thread.sleep(5000);
			FP.fn_clkCheckin(ele);
			Thread.sleep(2000);
			WebElement ele1 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele1);
			AccountStatementLandingPage ASL = FP.ClickOnPayment();
			GenericMethods.clickElement(ASL.Btn_CustomChargeBtn);
			ASL.fn_addCustomCharges(iTestCaseRow);
			Thread.sleep(2000);
			GenericMethods.clickElement(ASL.CB_AccountPostingMasterCB);
			Thread.sleep(2000);
			GenericMethods.clickElement(ASL.Btn_Refund);
			Assert.assertEquals(GenericMethods.getText(ASL.Header_refundTitle).trim(),
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)).trim());
			GenericMethods.clickElement(ASL.Btn_innerRefund);
			float p = ASL.fn_getChargeForPostedItem();
			Assert.assertEquals(p, 0.0f, 0.0f);
			System.out.println("TC-98_99 Executed");
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	@Test(priority = 21, description = "To create 2 room 1 night reservation with rate type as Package (with Inclusion).")
	public void fn_create2Room1NPkgWithInclusionReserv() throws Throwable {// TC_108
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			Thread.sleep(4000);
			FP.fn_ClickCancelButton();
			Thread.sleep(5000);
			GenericMethods.js_Click(FrontdeskLandingPage.Current_Link);
			String cwid = GenericMethods.GetCurrentWindowID();
			BasePage BP = FP.fn_NavigateAdmineConsole();
			GenericMethods.windowHandle(cwid);
			ListOfPackagesFrontdesk FPL = BP.fn_navigateFrontDskPkg();
			boolean res = FPL.VerifyPackage(iTestCaseRow);
			Thread.sleep(12000);
			FPL.CreateInclusionPackageAndAttachToFD(iTestCaseRow, res);
			String ti = GenericMethods.driver.getTitle();
			GenericMethods.Switch_Parent_Window(cwid);
			Thread.sleep(2000);
			GenericMethods.driver.navigate().refresh();
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			FP.fn_clickCurrentLnk();
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			String selPak = AQRP.GetSelectedPackage(
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)));
			String pkgPrice = AQRP.GetPrice();
			AQRP.FillQuickResvsFormBySelectingPak(iTestCaseRow, selPak);
			Thread.sleep(2000);
			GenericMethods.switchToWindowHandle(ti);
			FrontDeskPackageDetailPage FDP = FPL.clickOnPakEditlink(selPak);
			String rate = FDP.getPerNightPrice(rtype);
			System.out.println("pkgPrice came as::::"+pkgPrice);
			System.out.println("Rate came as::::"+rate);
		    String rateFinal[]=	rate.split("\\.");
		    System.out.println("rateFinal.length::::::"+rateFinal.length);
		    
		    for(int i=0;i<=rateFinal.length-1;i++)
		    {
		    	System.out.println("rateFinal array:"+rateFinal[i]);
		    }
		    
		    String pkgPriceFinal[]=pkgPrice.split("\\.");
		    System.out.println("pkgprice.length:::::"+pkgPriceFinal.length);
		    for(int i=0;i<=pkgPriceFinal.length-1;i++)
		    {
		    	System.out.println("pkgPriceFinal array:"+pkgPriceFinal[i]);
		    }
		    
			Assert.assertEquals(rate, pkgPrice);
			GenericMethods.CloseWindow("Package");
			System.out.println("TC-108 Executed");
			Reporter.log("Pakage Rate verify in the reservation", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	@Test(priority = 22, description = "To verify creation of 1 night 2 room group reservation with rate type as Package (with Inclusion) & right click 'Group Check In link.")
	public void fn_verify1N2RoomGrpCheckInForPkgWithInclusion() throws Throwable {// TC_109
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
		//	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			GenericMethods.js_Click(FrontdeskLandingPage.Current_Link);
			String cwid = GenericMethods.GetCurrentWindowID();
			BasePage BP = FP.fn_NavigateAdmineConsole();
			GenericMethods.windowHandle(cwid);
			ListOfPackagesFrontdesk FPL = BP.fn_navigateFrontDskPkg();
			boolean res = FPL.VerifyPackage(iTestCaseRow);
			String inclusion = FPL.fn_getInclusionFromPackageNamesection(FPL.incName).trim();
			FPL.CreateInclusionPackageAndAttachToFD(iTestCaseRow, res);
			GenericMethods.driver.getTitle();
			GenericMethods.Switch_Parent_Window(cwid);
			Thread.sleep(2000);
			GenericMethods.driver.navigate().refresh();
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			FP.fn_clickCurrentLnk();
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			String selPak = AQRP.GetSelectedPackage(
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)));
			AQRP.FillQuickResvsFormBySelectingPak(iTestCaseRow, selPak);
			FP.fn_verifyReservation();
			Thread.sleep(4000);
			String resStatus = FP.getWebElement(FrontdeskLandingPage.resvId).getAttribute("rsvstatus");
			Thread.sleep(4000);
			Assert.assertEquals(resStatus,
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Thread.sleep(4000);
			WebElement ele1 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(4000);
			FP.fn_rightClickOnReservation(ele1);
			Thread.sleep(5000);
			GenericMethods.clickElement(FP.Link_GroupCheckIn);
			GenericMethods.AcceptAlertAfterValidate();
			Thread.sleep(3000);
			String resStatus1 = FP.getWebElement(FrontdeskLandingPage.resvId).getAttribute("rsvstatus");
			Thread.sleep(3000);
			Assert.assertEquals(resStatus1,
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
			Thread.sleep(2000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele);
			ViewDetailsPage VDP = FP.ClickOnViewDetailsLink();
			EnableEditingPage EEP = VDP.ClickOnEnableEditing();
			String s = GenericMethods.getText(EEP.Text_AddOnInclusion);
			String inc = EEP.getAddOn(s).trim();
			Thread.sleep(2000);
			Assert.assertEquals(inc, inclusion);
			GenericMethods.CloseWindow("Package");
			System.out.println("TC-109 Executed");
			Reporter.log("Group reservation has been made and Inclusion verified along with successfull checkIn", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	@Test(priority = 23, description = "To verify posting in 'Accounts' after performing 'Auto Night Audit' for 1 room 1 night reservation.")
	public void fn_verifyPostingInAccAfterAutoNAuditIn1R1NResvForPkgWithInclusion() throws Throwable {
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			GenericMethods.js_Click(FrontdeskLandingPage.Current_Link);
			String cwid = GenericMethods.GetCurrentWindowID();
			BasePage BP = FP.fn_NavigateAdmineConsole();
			GenericMethods.windowHandle(cwid);
			ListOfPackagesFrontdesk FPL = BP.fn_navigateFrontDskPkg();
			boolean res = FPL.VerifyPackage(iTestCaseRow);
			FPL.CreateInclusionPackageAndAttachToFD(iTestCaseRow, res);
			GenericMethods.driver.getTitle();
			GenericMethods.Switch_Parent_Window(cwid);
			Thread.sleep(2000);
			GenericMethods.driver.navigate().refresh();
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			FP.fn_clickCurrentLnk();
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			String selPak = AQRP.GetSelectedPackage(
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)));
			AQRP.FillQuickResvsFormBySelectingPak(iTestCaseRow, selPak);
			FP.fn_verifyReservation();
			Thread.sleep(2000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(4000);
			FP.fn_rightClickOnReservation(ele);
			FP.fn_clkCheckin(ele);
			Thread.sleep(4000);
			WebElement ele1 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(4000);
			FP.fn_rightClickOnReservation(ele1);
			Thread.sleep(4000);
			ViewDetailsPage VDP = FP.ClickOnViewDetailsLink();
			String room = VDP.getRoomNum();
			String vdp = GenericMethods.driver.getTitle();
			SampleRestaurantPage SRP = VDP.ClickOnRestaurant();
			GenericMethods.switchToWindowHandle("Sample Restaurant");
			ConfirmOrderPage COP = SRP.generateOrder();
			Thread.sleep(2000);
			OrderFolioPage OFP = COP.fn_transferOrderToRoom(room);
			Thread.sleep(2000);
			TransactionListPage TLP = OFP.fn_getFolioAndCloseTransaction();
			String fnum = TLP.getFolioNumber(OFP.FNum).trim();
			System.out.println(fnum);
			Thread.sleep(2000);
			GenericMethods.switchToWindowHandle(vdp);
			AccountStatementLandingPage ASL = VDP.ClickToPayment();
			Thread.sleep(2000);
			ASL.fn_consolidateAccount("Accept");
			Thread.sleep(2000);
			ASL.getFolioNumberfromAccountNumber(fnum);
			Thread.sleep(2000);
			GenericMethods.driver.navigate().refresh();
			Assert.assertEquals(GenericMethods.getText(FP.Header_NightAuditPopUp).trim(),
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			GenericMethods.clickElement(FP.Btn_AutoNightAudit);
			Thread.sleep(2000);
			FP.fn_clickCurrentLnk();
			Thread.sleep(2000);
			WebElement ele2 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			ele2.getAttribute("rsvstatus");
			GenericMethods.clickElement(FP.getWebElement(FrontdeskLandingPage.resvId));
			VDP = FP.ClickOnViewlink();
			ASL = VDP.ClickToPayment();
			ASL.VerifyRoomRateAndTax(
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)));
			ASL.doPayment("Cash");
			Thread.sleep(2000);
			GenericMethods.clickElement(ASL.Btn_GenerateFolio);
			Thread.sleep(2000);
			GenericMethods.clickElement(ASL.Btn_settleFolio);
			Thread.sleep(2000);
			GenericMethods.ActionOnAlert("Accept");
			Thread.sleep(2000);
			GenericMethods.clickElement(ASL.Btn_FolioLock);
			Thread.sleep(2000);
			GenericMethods.ActionOnAlert("Accept");
			Thread.sleep(2000);
			String INV = GenericMethods.getText(ASL.Link_InvoiceNumber).trim();
			Thread.sleep(2000);
			GenericMethods.driver.navigate().refresh();
			GenericMethods.clickElement(FP.Btn_AutoNightAudit);
			Thread.sleep(2000);
			FP.fn_clickCurrentLnk();
			Thread.sleep(2000);
			WebElement ele3 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			String resStatAfterNightAudit = ele3.getAttribute("rsvstatus").trim();
			Thread.sleep(2000);
			Assert.assertEquals(resStatAfterNightAudit,
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)).trim());
			AccountsLandingPage ALP = FP.fn_clickOnAccountsLink();
			GenericMethods.switchToWindowHandle("Accounts");
			ALP.fn_ValidateAccountsPage();
			HotelLedgerLandingPage HLLP = ALP.fn_ClickHotel();
			String inv = HLLP.fn_getInv(INV);
			Thread.sleep(2000);
			//Assert.assertEquals(inv, INV);
			//Thread.sleep(2000);
			POSPointLedgersListLandingPage PPL = HLLP.fn_ClickOnPOS();
			POSLedgerLandingPage PLL = PPL.fn_ClickOnLedgerLinkForThePOS("Restaurant");
			Reporter.log("INV matched in Accounts of hotel", true);
			String posfolio = PLL.fn_VerifyPOSInvoice(fnum);
			Thread.sleep(2000);
			Assert.assertEquals(posfolio, fnum);
			GenericMethods.CloseWindow("Package");
			System.out.println("TC-110_111_112_113_158_159_160_202_203_204_205 Executed");
			Reporter.log("Invoices verified at ledgers of hotel ", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 24, description = "To verify creation of 2 room 2 night reservation with rate type as Package (weekly posted rate) & addition of add-ons in it.")
	public void fn_create2R2NResvForWeeklyPostedPkgWithAddOns() throws Throwable {// TC_114_115_116
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			GenericMethods.js_Click(FrontdeskLandingPage.Current_Link);
			String cwid = GenericMethods.GetCurrentWindowID();
			BasePage BP = FP.fn_NavigateAdmineConsole();
			GenericMethods.windowHandle(cwid);
			ListOfPackagesFrontdesk FPL = BP.fn_navigateFrontDskPkg();
			boolean res = FPL.VerifyPackage(iTestCaseRow);
			Thread.sleep(12000);
			FPL.CreateWeeklyPackageAndAttachToFD(iTestCaseRow, res);
			GenericMethods.driver.getTitle();
			GenericMethods.Switch_Parent_Window(cwid);
			Thread.sleep(2000);
			GenericMethods.driver.navigate().refresh();
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			FP.fn_clickCurrentLnk();
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "4");
			String selPak = AQRP.GetSelectedPackage(
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)));
			FP = AQRP.FillQuickResvsFormBySelectingPak(iTestCaseRow, selPak);
			Thread.sleep(2000);
			FP.fn_verifyReservation();
			Thread.sleep(2000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele);
			ViewDetailsPage VDP = FP.ClickOnViewDetailsLink();
			EnableEditingPage EEP = VDP.ClickOnEnableEditing();
			GenericMethods.clickElement(EEP.Link_InclusionAddOns);
			Thread.sleep(2000);
			Assert.assertEquals(GenericMethods.getText(EEP.Header_SelectAddOn),
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Thread.sleep(2000);
			EEP.fn_setAddOnsToReservation();
			String addOn = EEP.fn_getAddOn(EEP.selectedAddOns);
			System.out.println("Expected" + addOn);
			Thread.sleep(2000);
			System.out.println("Added actual " + GenericMethods.getText(EEP.Text_AddOnInclusion).trim());
			Assert.assertTrue(addOn.trim().contains(GenericMethods.getText(EEP.Text_AddOnInclusion).trim()));
			GenericMethods.CloseWindow("Package");
			System.out.println("TC-114_115_116 Executed");
			Reporter.log("For group reservation add On Added", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;

		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void closeApp() throws Throwable {
		try {
			Set<String> setHndlValColls = GenericMethods.driver.getWindowHandles();
			Iterator<String> itHandleColls = setHndlValColls.iterator();
			while (itHandleColls.hasNext() == true) {
				String hndlval = itHandleColls.next();
				GenericMethods.driver.switchTo().window(hndlval);
				if (GenericMethods.driver.getTitle().contains("Frontdesk") == false) {
					GenericMethods.driver.close();
				}
			}
			GenericMethods.switchToWindowHandle("Frontdesk");
			GenericMethods.driver.navigate().refresh();
		} catch (Exception e) {
			Thread.sleep(10000);
			Set<String> setHndlValColls = GenericMethods.driver.getWindowHandles();
			Iterator<String> itHandleColls = setHndlValColls.iterator();
			while (itHandleColls.hasNext() == true) {
				String hndlval = itHandleColls.next();
				GenericMethods.driver.switchTo().window(hndlval);
				if (GenericMethods.driver.getTitle().contains("Frontdesk") == false) {
					GenericMethods.driver.close();
				}
			}

			GenericMethods.switchToWindowHandle("Frontdesk");
			GenericMethods.driver.navigate().refresh();
		}

	}


}

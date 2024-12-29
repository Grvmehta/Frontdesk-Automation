package com.hotelogix.smoke.FrontdeskTest;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.internal.EventFiringKeyboard;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hotelogix.smoke.admin.BaseClass.AdmineHome;
import com.hotelogix.smoke.admin.General.PayTypesPage;
import com.hotelogix.smoke.admin.General.TaxExemptListPage;
import com.hotelogix.smoke.admin.PosManager.POSPointsLandingPage;
import com.hotelogix.smoke.admin.PriceManager.FrontDeskPackageDetailPage;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesFrontdesk;
import com.hotelogix.smoke.admin.roommanager.AddRoomsPage;
import com.hotelogix.smoke.admin.roommanager.RoomTaxesLandingPage;
import com.hotelogix.smoke.admin.roommanager.RoomsLandingPage;
import com.hotelogix.smoke.frontdesk.Accounts.AccountsLandingPage;
import com.hotelogix.smoke.frontdesk.Accounts.HotelLedgerLandingPage;
import com.hotelogix.smoke.frontdesk.Accounts.POSLedgerLandingPage;
import com.hotelogix.smoke.frontdesk.Accounts.POSPointLedgersListLandingPage;
import com.hotelogix.smoke.frontdesk.CashCounter.CashCounterPage;
import com.hotelogix.smoke.frontdesk.CashCounter.CloseCashCounterPage;
import com.hotelogix.smoke.frontdesk.CashCounter.NightAuditPdfPage;
import com.hotelogix.smoke.frontdesk.CashCounter.NightAuditVideoPage;
import com.hotelogix.smoke.frontdesk.CashCounter.OpenCashCounter;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.AddQuickReservationForm;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.FrontdeskLandingPage;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.GroupReservationPage;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.SingleReservationPage;
import com.hotelogix.smoke.frontdesk.FrontdeskTrialPage.FrontdeskContinueTrialPage;
import com.hotelogix.smoke.frontdesk.Payment.AccountStatementLandingPage;
import com.hotelogix.smoke.frontdesk.Payment.ReservationFolioPage;
import com.hotelogix.smoke.frontdesk.ReservationSearchResult.ReservationSearchResultLandingPage;
import com.hotelogix.smoke.frontdesk.RoomOperations.TempRoomList;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.ConfirmOrderPage;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.OrderFolioPage;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.OrderFromNewTab;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.SampleRestaurantPage;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.TransactionListPage;
import com.hotelogix.smoke.frontdesk.ViewDetailsPage.EnableEditingPage;
import com.hotelogix.smoke.frontdesk.ViewDetailsPage.GroupEnableEditingPage;
import com.hotelogix.smoke.frontdesk.ViewDetailsPage.GroupToSingleReservationPage;
import com.hotelogix.smoke.frontdesk.ViewDetailsPage.GroupViewDetailPage;
import com.hotelogix.smoke.frontdesk.ViewDetailsPage.ViewDetailsPage;
import com.hotelogix.smoke.genericandbase.BasePage;
import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;
import com.hotelogix.smoke.login.AdminLoginPage;
import com.hotelogix.smoke.login.FrontdeskLoginPage;
import com.itextpdf.text.log.SysoCounter;

public class Ftest {

	private String rtype = "Deluxe";
	public static String sTestCaseName;
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

	//@Test(priority = 7, description = "To create 1 room 2 night reservation for Package with Inclusion as rate type.")
	public void abc	() throws Throwable {// TC_41
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
	}

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
			GenericMethods.javascriptScroll(ASL.CB_AccountPostingMasterCB);
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
		    rate.trim();
		    pkgPrice.trim();
			Assert.assertEquals(rate,pkgPrice);
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
			Thread.sleep(8000);
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


	// Check manually
	// @Test(priority=21, description="To verify change in room tariff on
	// allowing extra bed and also verify given discount in price.")
	public void fn_verify1Room1NReservWithExtraBedAndDiscInPrice() throws Throwable {// TC_61_62_63
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			FrontdeskLoginPage AL = new FrontdeskLoginPage();
			AL.FrontDeskLogin(iTestCaseRow);
			FrontdeskContinueTrialPage CP = new FrontdeskContinueTrialPage();
			Thread.sleep(2000);
			CashCounterPage CCP = CP.fn_ClickCountinueWithTrail_BT();
			Thread.sleep(2000);
			FrontdeskLandingPage FP = CCP.fn_ClickContinueButton();
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			GenericMethods.js_Click(FrontdeskLandingPage.Current_Link);
			String cwid = GenericMethods.GetCurrentWindowID();
			BasePage BP = FP.fn_NavigateAdmineConsole();
			GenericMethods.windowHandle(cwid);
			RoomsLandingPage RLP = BP.roomsPageNavigate();
			AddRoomsPage ARP = RLP.click_AddRoom();
			String rtype = ARP.addRoomName(1);
			GenericMethods.Switch_Parent_Window(cwid);
			Thread.sleep(2000);
			GenericMethods.driver.navigate().refresh();
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			FP.fn_clickCurrentLnk();
			Thread.sleep(2000);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "4");
			AQRP.GetTotalPrice();
			String perNprice = AQRP.GetPrice().trim();
			System.out.println(perNprice);
			FP = AQRP.FillQuickResForm(iTestCaseRow);
			FP.fn_verifyReservation();
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			GenericMethods.clickElement(ele);
			ViewDetailsPage VDP = FP.ClickOnViewlink();
			EnableEditingPage EEP = VDP.ClickOnEnableEditing();
			// FP=EEP.fn_addExtraBeds("1 Bed");
			// Thread.sleep(3000);
			// WebElement ele1=FP.getWebElement(FrontdeskLandingPage.resvId);
			// Thread.sleep(2000);
			// GenericMethods.clickElement(ele1);
			// VDP=FP.ClickOnViewlink();
			// EEP=VDP.ClickOnEnableEditing();
			// Assert.assertEquals(GenericMethods.getSelectedValueFromDropdown(EEP.DD_extraBed),
			// "1 Bed");
			// Reporter.log("Extra Bed addition verified",true);
			// EEP.giveDiscount(iTestCaseRow);
			String text = EEP.fn_newDisct(iTestCaseRow);
			EEP.fn_switchToFDTab();
			// WebElement ele3=FP.getWebElement(FP.title);
			// FP.fn_RightclkforViewDetailsPage(ID, Link)

			WebElement ele3 = FP.getWebElement(FrontdeskLandingPage.resvId);
			GenericMethods.clickElement(ele3);
			FP.ClickOnViewlink();
			EEP.fn_saveChangedDisct(text);
			System.out.println("TC-61_62_63 Executed");
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 13, description = "To verify posting of price & tax of  transferred POS order to room in single reservation.")
	public void fn_verifyPOSOrderTransferToRoomAndConsolidateAcc() throws Throwable {// TC_71_72_73_74_75_76_77_78_79_82_83
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			FP.fn_ClickCancelButton();
			GenericMethods.js_Click(FrontdeskLandingPage.Current_Link);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			FP = AQRP.FillQuickResForm(iTestCaseRow);
			FP.fn_verifyResFromDetailPage();
			ViewDetailsPage VDP = FP.ClickOnViewlink();
			String resId = VDP.GetResveration();
			EnableEditingPage EEP = VDP.ClickOnEnableEditing();
			FP = EEP.CheckInSingleRes();
			ReservationSearchResultLandingPage RSR = FP.fn_SearchReservationID(resId);
			VDP = RSR.fn_ClickOnSearchedRecord();
			Thread.sleep(5000);
			String resRoom = VDP.getRoomNum();
			Thread.sleep(5000);
			GenericMethods.driver.getTitle();
			SampleRestaurantPage SRP = VDP.ClickOnRestaurant();
			Thread.sleep(3000);
			GenericMethods.switchToWindowHandle("Sample Restaurant");
			Thread.sleep(2000);
			String title = GenericMethods.driver.getTitle().trim();
			String Expected = ExcelUtil.getCellData(iTestCaseRow,
					ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1));
			Assert.assertEquals(title.contains(Expected), true);
			Thread.sleep(2000);
			ConfirmOrderPage COP = SRP.generateOrder();
			Thread.sleep(2000);
			String orderTabText = GenericMethods.getText(COP.Text_OrderTab).trim();
			Thread.sleep(2000);
			Assert.assertEquals(orderTabText,
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
			OrderFolioPage OFP = COP.fn_transferOrderToRoom(resRoom);
			Thread.sleep(2000);
			TransactionListPage TLP = OFP.fn_getFolioAndCloseTransaction();
			Thread.sleep(2000);
			String fnum = TLP.getFolioNumber(OFP.FNum).trim();
			System.out.println(fnum);
			Thread.sleep(2000);
			GenericMethods.switchToWindowHandle("Frontdesk");
			AccountStatementLandingPage ASL = VDP.ClickToPayment();
			Thread.sleep(5000);
			Assert.assertEquals(GenericMethods.getText(ASL.Text_AccountStatement).trim(), "ACCOUNT STATEMENT");
			ASL.fn_consolidateAccount("Accept");
			Thread.sleep(2000);
			Assert.assertEquals(GenericMethods.value, ASL.exp_msg);
			Thread.sleep(2000);
			ASL.getFolioNumberfromAccountNumber(fnum);
			Thread.sleep(2000);
			System.out.println("TC-71_72_73_74_75_76_77_78_79_82_83 Executed");
			Reporter.log("Folio verified", true);
			Reporter.log(
					"Reservation made and pos transfer to room and booking total remains unchanged after consolidation",
					true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 14, description = "To verify 'Pay Now' button in POS point (Sample Restaurant).")
	public void fn_verifyPayNowBtnInSampleRestaurant() throws Throwable {// TC_80_81
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
			AQRP.GetTotalPrice();
			String perNprice = AQRP.GetPrice().trim();
			System.out.println(perNprice);
			FP = AQRP.FillQuickResForm(iTestCaseRow);
			FP.fn_verifyReservation();
			Thread.sleep(2000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			GenericMethods.clickElement(ele);
			FP.getRateFromViewPane();
			ViewDetailsPage VDP = FP.ClickOnViewlink();
			String resId = VDP.GetResveration();
			EnableEditingPage EEP = VDP.ClickOnEnableEditing();
			FP = EEP.CheckInSingleRes();
			Thread.sleep(2000);
			ReservationSearchResultLandingPage RSR = FP.fn_SearchReservationID(resId);
			Thread.sleep(5000);
			VDP = RSR.fn_ClickOnSearchedRecord();
			Thread.sleep(5000);
			String resRoom = VDP.getRoomNum();
			Thread.sleep(5000);
			GenericMethods.driver.getTitle();
			SampleRestaurantPage SRP = VDP.ClickOnRestaurant();
			Thread.sleep(2000);
			GenericMethods.switchToWindowHandle("Sample Restaurant");
			ConfirmOrderPage COP = SRP.generateOrder();
			Thread.sleep(2000);
			OrderFolioPage OFP = COP.fn_transferOrderToRoom(resRoom);
			Thread.sleep(2000);
			TransactionListPage TLP = OFP.fn_getFolioAndCloseTransaction();
			Thread.sleep(2000);
			String fnum = TLP.getFolioNumber(OFP.FNum).trim();
			System.out.println(fnum);
			Thread.sleep(2000);
			GenericMethods.switchToWindowHandle("Frontdesk");
			AccountStatementLandingPage ASL = VDP.ClickToPayment();
			Thread.sleep(2000);
			ASL.fn_consolidateAccount("Accept");
			Thread.sleep(2000);
			ASL.getFolioNumberfromAccountNumber(fnum);
			System.out.println("TC-80_81 Executed");
			Reporter.log("Consolidate account successfully", true);

		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 15, description = "To verify 'Custom Charge/Allowance' & 'Other Charge' button in single reservation.")
	public void fn_verifyCustomChargeAndOtherCharge() throws Throwable {// TC_84_85_86_87
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
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			FP = AQRP.FillQuickResForm(iTestCaseRow);
			FP.fn_verifyReservation();
			Thread.sleep(2000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele);
			Thread.sleep(3000);
			FP.fn_clkCheckin(ele);
			Thread.sleep(6000);
			WebElement ele1 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele1);
			AccountStatementLandingPage ASL = FP.ClickOnPayment();
			GenericMethods.clickElement(ASL.Btn_CustomChargeBtn);
			Assert.assertEquals(GenericMethods.getText(ASL.Header_CustomChargeAllowance).trim(),
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Reporter.log("Custom charge Allowances header verified", true);
			ASL.fn_addCustomCharges(iTestCaseRow);
			Thread.sleep(10000);
			String item = ASL.VerifyPostedCustomCharge(iTestCaseRow);
			Assert.assertEquals(item.trim(),
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Description)));
			Reporter.log("Posted cutom charge verified at account statement", true);
			GenericMethods.clickElement(ASL.Btn_OtherCharges);
			Thread.sleep(2000);
			Assert.assertEquals(GenericMethods.getText(ASL.Header_OtherCharges).trim(),
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
			ASL.AddOtherCharge(iTestCaseRow);
			Thread.sleep(2000);
			String itemOtherCharge = ASL.VerifyOtherCharges(ASL.selProduct);
			Thread.sleep(2000);
			System.out.println(itemOtherCharge);
			System.out.println(ASL.selProduct);
			Assert.assertEquals(itemOtherCharge.trim(), ASL.selProduct.trim());
			System.out.println("TC-84_85_86_87 Executed");
			Reporter.log("Other charges posted and verify to Account statement ", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}


	@Test(priority = 17, description = "To verify 'Route To New Folio' ,'Route Charge' & 'Route Payment' in 1 night single checked-in reservation with '2' adult.")
	public void fn_verifyRouteToNewFolioRouteChargeAndRoutePayment() throws Throwable {// TC_92_93_94_95_96_97
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
				iTestCaseRow=	hm.get(sTestCaseName);
			//iTestCaseRow=30;
			Thread.sleep(2000);
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
			Thread.sleep(5000);
			WebElement ele1 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(4000);
			FP.fn_rightClickOnReservation(ele1);
			Thread.sleep(4000);
			ViewDetailsPage VDP = FP.ClickOnViewDetailsLink();
			Thread.sleep(5000);
			EnableEditingPage EEP = VDP.ClickToEnableEditingBtn();
			FP = EEP.AddSecondaryGuestDetail();
			System.out.println(FrontdeskLandingPage.resvId);
			GenericMethods.driver.navigate().refresh();
			FP.fn_ClickCancelButton();
			FP.fn_clickCurrentLnk();
			System.out.println(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			WebElement ele2 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(4000);
			FP.fn_rightClickOnReservation(ele2);
			AccountStatementLandingPage ASL = FP.ClickOnPayment();
			Thread.sleep(3000);
			GenericMethods.javascriptScroll(ASL.Btn_CustomChargeBtn);
			GenericMethods.clickElement(ASL.Btn_CustomChargeBtn);
			ASL.fn_addCustomCharges(iTestCaseRow);
			Thread.sleep(2000);
			GenericMethods.clickElement(ASL.Btn_GenerateFolio);
			Thread.sleep(2000);
			GenericMethods.ActionOnAlert("Accept");
			Thread.sleep(2000);
			int size = ASL.CB_GeneratedFolio.size();
			System.out.println(size);
			GenericMethods.clickElement(ASL.CB_AccountPostingMasterCB);
			Thread.sleep(2000);
			GenericMethods.clickElement(ASL.Btn_RouteToNewFolio);
			Assert.assertEquals(GenericMethods.getText(ASL.HeaderTxt_CreateNewFolio).trim(),
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Reporter.log("Create new folio pop up header text verified.", true);
			ASL.fn_createNewFolio(1);
			Thread.sleep(8000);
			System.out.println("ACTUAL::" + ASL.CB_GeneratedFolio.size());
			int exp=size-1;
			System.out.println("EXPECTED::" + exp);
			Assert.assertEquals(ASL.CB_GeneratedFolio.size(), exp);
			float res = ASL.fn_getTotalPostedItemRatefromAccountStatement();
			System.out.println("Value of res came as::::"+res);
			GenericMethods.clickElement(ASL.CB_AccountPostingMasterCB);
			GenericMethods.clickElement(ASL.Btn_RouteCharges);
			Assert.assertEquals(GenericMethods.getText(ASL.Header_routeChargesTitle).trim(),
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
			String guest = ASL.fn_routeCharges(1);
			String pi = ASL.fn_getPI(guest);
			Thread.sleep(2000);
			float rate = ASL.VerifyRoutedCharge(pi);
			Thread.sleep(2000);
			Assert.assertEquals(res, rate, 0.0f);
			Reporter.log("Yeah route charge verified", true);
			ASL.doPayment("Cash");
			ASL.fn_routePayment(iTestCaseRow, 1, "single");
			Thread.sleep(10000);
			float rate1 = ASL.fn_getTotalAmountfromAccountStatementP17();
			String pi1 = ASL.fn_getPI(ASL.selValue);
			float rate2 = ASL.fn_verifyRoutedPayment(pi1);
			//Assert.assertTrue(rate1 == rate2);
		//	System.out.println(guest);
			System.out.println("TC-92_93_94_95_96_97 Executed");
			Reporter.log("Route to new folio ,Route charge and Route Payment verified", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	
	@Test(priority = 58, description = "To verify 'Settle Folio' button & Performa Invoice lock image in 1 night single checked-in reservation.")
	public void fn_verifySettleFolioAndPILockAlert() throws Throwable {// TC_100_101_102_103_104
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			//iTestCaseRow=32;
			Thread.sleep(2000);
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
			Thread.sleep(2000);
			GenericMethods.driver.navigate().refresh();
			Thread.sleep(2000);
			GenericMethods.clickElement(FP.Btn_AutoNightAudit);
			Thread.sleep(9000);
			FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(FP.getWebElement(FrontdeskLandingPage.resvId));
			Thread.sleep(9000);
			AccountStatementLandingPage ASL = FP.ClickOnPayment();
			GenericMethods.clickElement(ASL.Btn_GenerateFolio);
			Thread.sleep(5000);
			float rate = GenericMethods.fn_getRateFromRateString(ASL.Text_BalanceAmtInAcc.getText());
			System.out.println("rate::"+rate);
			ASL.fn_doPaymentUsingCheque(iTestCaseRow);
			Thread.sleep(5000);
			float rate1 = GenericMethods.fn_getRateFromRateString(ASL.Text_BalanceAmtInAcc.getText());
			Thread.sleep(2000);
			System.out.println("rate1::"+rate1);
			Assert.assertNotEquals(rate, rate1, 0.0f);
			Thread.sleep(2000);
			String s = GenericMethods.getText(ASL.Text_BalanceAmtInFolio).trim();
			System.out.println("s is" + s);
			GenericMethods.clickElement(ASL.Btn_settleFolio);
			GenericMethods.ActionOnAlert("Accept");
			Thread.sleep(2000);
			Assert.assertEquals(GenericMethods.value.trim(),
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Thread.sleep(2000);
			String s1 = GenericMethods.getText(ASL.Text_BalanceAmtInFolio).trim();
			System.out.println("s1 is" + s1);
			Thread.sleep(2000);
			Assert.assertNotEquals(s, s1);
			Thread.sleep(2000);
			String atr = GenericMethods.GetWebElementAttributeValue(ASL.Btn_FolioLock, "class");
			GenericMethods.clickElement(ASL.Btn_FolioLock);
			System.out.println("hi");
			GenericMethods.ActionOnAlert("Accept");
			Thread.sleep(2000);
			String atr1 = GenericMethods.GetWebElementAttributeValue(ASL.Btn_FolioLocked, "class").trim();
			Assert.assertNotSame(atr, atr1);
			Thread.sleep(2000);
			Assert.assertEquals(GenericMethods.value,
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
			Thread.sleep(2000);
			GenericMethods.clickElement(ASL.Btn_FolioLocked);
			Thread.sleep(4000);
			String atr2 = GenericMethods.GetWebElementAttributeValue(ASL.Btn_FolioLocked, "class").trim();
			Thread.sleep(2000);
			System.out.println("atr2::::::::::::::"+atr2);
			System.out.println("atr1::::::::::::::"+atr1);
			Assert.assertEquals(atr2, atr1);
			System.out.println("TC-100_101_102_103_104 Executed");
			Reporter.log(
					"Folio creted along with payment done and settlement and unlock not possible for the lock folio",
					true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 20, description = "To create 2 room 4 night reservation with rate type as 'Seasonal Rate'..")
	public void fn_create3Room4NSeasonalReserv() throws Throwable {// TC_105_106_107
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
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "6");
			FP = AQRP.FillQuickResForm(iTestCaseRow);
			FP.fn_verifyReservation();
			System.out.println("TC-105_106_107 Executed");
			Reporter.log("4 night group booking has been made", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	
	
	
	@Test(priority = 25, description = "To verify change in price of  a room in group reservation. ")
	public void fn_verifyPriceChangeInGrpReservRoom() throws Throwable {// TC_117
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
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			GroupReservationPage GRP = AQRP.FillQuickResvsForm(iTestCaseRow, AQRP.Link_GroupRes);
			FP = GRP.ClickOnReserve();
			FP.fn_verifyReservation();
			Thread.sleep(2000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele);
			ViewDetailsPage VDP = FP.ClickOnViewDetailsLink();
			Thread.sleep(2000);
			EnableEditingPage EEP = VDP.ClickOnEnableEditing();
			EEP.fn_changeBookingRate(iTestCaseRow);
			Thread.sleep(2000);
			System.out.println(EEP.newRateAfterSaving + "Actual");
			System.out.println(EEP.newRate + "Expected");
			Thread.sleep(2000);
			Assert.assertEquals(EEP.newRateAfterSaving, EEP.newRate);
			System.out.println("TC-117 Executed");
			Reporter.log("New rate verified after changing the rate for the group reservation", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 26, description = "To verify change in room tariff when extra bed is allowed in a group reservation.")
	public void fn_verifyChangeInRoomTariffForExtraBedInGrpResv() throws Throwable {// TC_118_119
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
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			GroupReservationPage GRP = AQRP.FillQuickResvsForm(iTestCaseRow, AQRP.Link_GroupRes);
			FP = GRP.ClickOnReserve();
			FP.fn_verifyReservation();
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(FP.getWebElement(FrontdeskLandingPage.resvId));
			GroupViewDetailPage GVD = FP.fn_clickOnViewDetailLink();
			GroupEnableEditingPage GEED = GVD.fn_clickOnEnableEditingBtn();
			ArrayList<String> al = GEED.getGroupResIds();
			GroupToSingleReservationPage GTS = GEED.fn_moveFromGroupToSingle(al.get(0).toString());
			GTS.fn_setExtraBed("1 Bed");
			Thread.sleep(2000);
			Assert.assertEquals(GTS.selectedBed1.trim(), "1 Bed");
			Reporter.log("Extra bed selected", true);
			GroupEnableEditingPage GEE = GTS.fn_clickOnBackToGroupBtn();
			FP = GEE.fn_clickOnSaveBtn();
			Thread.sleep(2000);
			WebElement ele1 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele1);
			GVD = FP.fn_clickOnViewDetailLink();
			GEED = GVD.fn_clickOnEnableEditingBtn();
			Thread.sleep(3000);
			GTS = GEED.fn_moveFromGroupToSingle(al.get(0).toString());
			String selBed = GenericMethods.fn_getDropdownSelectedValue(GTS.DD_ExtraBed);
			Thread.sleep(2000);
			Assert.assertEquals(selBed, "1 Bed");
			System.out.println("TC-118_119 Executed");
			Reporter.log("selected number of bed found", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 27, description = "To verify 'Add Guest Detail' link in a group reservation.")
	public void fn_verifyAddGuestDetailsInGrpReserv() throws Throwable {// TC_120
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
		//	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			//iTestCaseRow=40;
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			GenericMethods.js_Click(FrontdeskLandingPage.Current_Link);
			Thread.sleep(2000);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "4");
			GroupReservationPage GRP = AQRP.FillQuickResvsForm(iTestCaseRow, AQRP.Link_GroupRes);
			FP = GRP.ClickOnReserve();
			FP.fn_verifyReservation();
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(FP.getWebElement(FrontdeskLandingPage.resvId));
			Thread.sleep(2000);
			GroupViewDetailPage GVD = FP.fn_clickOnViewDetailLink();
			GroupEnableEditingPage GEED = GVD.fn_clickOnEnableEditingBtn();
			ArrayList<String> al = GEED.getGroupResIds();
			GEED.fn_addGuestDetails(al.get(0), GEED.gues1Detail);
			Thread.sleep(2000);
			GEED.fn_addGuestDetails1(al.get(1), GEED.gues2Detail);
			FP = GEED.fn_clickOnSaveBtn();
			Thread.sleep(2000);
			System.out.println(FrontdeskLandingPage.resvId);
			WebElement ele1 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele1);
			Thread.sleep(2000);
			GVD = FP.fn_clickOnViewDetailLink();
			GEED = GVD.fn_clickOnEnableEditingBtn();
			Thread.sleep(2000);
			String name = GEED.fn_getGuestName(al.get(0));
			Thread.sleep(2000);
			ArrayList<String> g1Name = GEED.fn_getGuestFirstNLastName(name);
			Thread.sleep(2000);
			String name1 = GEED.fn_getGuestName(al.get(1));
			ArrayList<String> g2Name = GEED.fn_getGuestFirstNLastName(name1);
			Thread.sleep(2000);
			Assert.assertTrue(g1Name.get(0).toString().equalsIgnoreCase(GEED.gues1Detail.get(0).toString()));
			Thread.sleep(2000);
			Assert.assertTrue(g1Name.get(1).toString().equalsIgnoreCase(GEED.gues1Detail.get(1).toString()));
			Thread.sleep(2000);
			Assert.assertTrue(g2Name.get(2).toString().equalsIgnoreCase(GEED.gues2Detail.get(0).toString()));
			Thread.sleep(2000);
			Assert.assertTrue(g2Name.get(3).toString().equalsIgnoreCase(GEED.gues2Detail.get(1).toString()));
			Thread.sleep(2000);
			System.out.println("TC-120 Executed");
			Reporter.log("Guest Detail verified", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 28, description = "To verify 'Add/Edit Details' link in a group reservation.")
	public void fn_verifyAddEditDetailsInGrpReserv() throws Throwable {// TC_121_122
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
			GroupReservationPage GRP = AQRP.FillQuickResvsForm(iTestCaseRow, AQRP.Link_GroupRes);
			FP = GRP.ClickOnReserve();
			FP.fn_verifyReservation();
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(FP.getWebElement(FrontdeskLandingPage.resvId));
			Thread.sleep(2000);
			GroupViewDetailPage GVD = FP.fn_clickOnViewDetailLink();
			GVD.fn_AddEditDetails();
			Thread.sleep(2000);
			ArrayList<String> editedName = GVD
					.fn_getEditedFirstNamenLastName(GenericMethods.getText(GVD.Txt_groupOwnerName));
			Thread.sleep(2000);
			Assert.assertTrue(editedName.get(0).toString().equalsIgnoreCase(GVD.fname));
			Thread.sleep(2000);
			Assert.assertTrue(editedName.get(1).toString().equalsIgnoreCase(GVD.lname));
			Thread.sleep(2000);
			Assert.assertTrue(GVD.Img_forBlackListedGuest.isDisplayed());
			Thread.sleep(2000);
			Assert.assertTrue(GVD.Lable_guestAsVIP.isDisplayed());
			Reporter.log("Guest detail edited and black listed and VIP mark feature verified", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 29, description = "To verify right click 'Check In' link in group reservation.")
	public void fn_verifyRTClickCheckinForGrpReserv() throws Throwable {// TC_123
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
			GroupReservationPage GRP = AQRP.FillQuickResvsForm(iTestCaseRow, AQRP.Link_GroupRes);
			FP = GRP.ClickOnReserve();
			Thread.sleep(5000);
			FP.fn_verifyReservation();
			Thread.sleep(4000);
			String resId = GenericMethods.fn_getResNumber(FP.title);
			FP.fn_rightClickOnReservation(FP.getWebElement(FrontdeskLandingPage.resvId));
			FP.fn_clkCheckin(FP.getWebElement(FrontdeskLandingPage.resvId));
			FP.fn_rightClickOnReservation(FP.getWebElement(FrontdeskLandingPage.resvId));
			GroupViewDetailPage GVD = FP.fn_clickOnViewDetailLink();
			GroupEnableEditingPage GEED = GVD.fn_clickOnEnableEditingBtn();
			Thread.sleep(2000);
			String resStat = GEED.fn_getResStatus(resId);
			Assert.assertEquals(resStat,
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Reporter.log("Group single reservation checked IN", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 30, description = "To verify right 'Group Check In' & 'Cancel Check In' link in group reservation.")
	public void fn_verifyRTClickGrpCheckinAndCancelCheckinInGrpReserv() throws Throwable {// TC_124_125_126
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			//iTestCaseRow=43;
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			GenericMethods.js_Click(FrontdeskLandingPage.Current_Link);
			Thread.sleep(2000);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "4");
			GroupReservationPage GRP = AQRP.FillQuickResvsForm(iTestCaseRow, AQRP.Link_GroupRes);
			FP = GRP.ClickOnReserve();
			Thread.sleep(5000);
			FP.fn_verifyReservation();
			Thread.sleep(4000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(4000);
			FP.fn_rightClickOnReservation(ele);
			Thread.sleep(4000);
			FP.fn_groupCheckIn();
			Thread.sleep(4000);
			WebElement ele1 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			String resStat = GenericMethods.GetWebElementAttributeValue(ele1, "groupstatus");
			Thread.sleep(2000);
			Assert.assertEquals(resStat,
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Thread.sleep(2000);
			WebElement ele2 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele2);
			GenericMethods.clickElement(FP.Link_CancelCheckIn);
			GenericMethods.ActionOnAlert("Accept");
			Thread.sleep(2000);
			Assert.assertEquals(GenericMethods.value.trim(),
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
			WebElement ele3 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			String resStat1 = GenericMethods.GetWebElementAttributeValue(ele3, "rsvstatus");
			Thread.sleep(2000);
			Assert.assertEquals(resStat1,
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
			Reporter.log("Group reservation checkin and check out verified", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 31, description = "To verify 'Check-in Selected' button in group reservation.")
	public void fn_verifyCheckinSelectedBtnInGrpResv() throws Throwable {// TC_127_128
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			//iTestCaseRow=	44;
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			GenericMethods.js_Click(FrontdeskLandingPage.Current_Link);
			Thread.sleep(2000);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			GroupReservationPage GRP = AQRP.FillQuickResvsForm(iTestCaseRow, AQRP.Link_GroupRes);
			FP = GRP.ClickOnReserve();
			Thread.sleep(5000);
			FP.fn_verifyReservation();
			Thread.sleep(4000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(4000);
			FP.fn_rightClickOnReservation(ele);
			Thread.sleep(4000);
			GroupViewDetailPage GVD = FP.fn_clickOnViewDetailLink();
			GroupEnableEditingPage GEED = GVD.fn_clickOnEnableEditingBtn();
			ArrayList<String> al = GEED.getGroupResIds();
			FP = GEED.fn_CheckInSelectedGroupRes(al.get(0).toString());
			Thread.sleep(2000);
			WebElement ele1 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(8000);
			FP.fn_rightClickOnReservation(ele1);
			Thread.sleep(2000);
			GVD = FP.fn_clickOnViewDetailLink();
			GEED = GVD.fn_clickOnEnableEditingBtn();
			Thread.sleep(3000);
			String RoomStat = GEED.fn_getResStatus(al.get(0).toString());
			Thread.sleep(2000);
			Assert.assertEquals(RoomStat,
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
			Reporter.log("CheckIn verified selected group reservation ", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 32, description = "To verify 'Add New Room(s)' button & 'Delete' image alert in group reservation.")
	public void fn_verifyAddNewRoomAndDeleteActionInGrpReserv() throws Throwable {// TC_129_130_131_132
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			//iTestCaseRow=45;
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			GenericMethods.js_Click(FrontdeskLandingPage.Current_Link);
			Thread.sleep(2000);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			GroupReservationPage GRP = AQRP.FillQuickResvsForm(iTestCaseRow, AQRP.Link_GroupRes);
			FP = GRP.ClickOnReserve();
			FP.fn_verifyReservation();
			Thread.sleep(2000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele);
			Thread.sleep(2000);
			GroupViewDetailPage GVD = FP.fn_clickOnViewDetailLink();
			GroupEnableEditingPage GEEP = GVD.fn_clickOnEnableEditingBtn();
			int noOfRoomBeforeadd = GEEP.CB_numberOfResPerRoom.size();
			GenericMethods.clickElement(GEEP.Btn_AddNewRoomToGroup);
			Thread.sleep(2000);
			Assert.assertEquals(GenericMethods.getText(GEEP.Header_AddNewRoom).trim(),
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Thread.sleep(2000);
			GEEP.fn_addNewRoomToGroup();
			Thread.sleep(2000);
			int noOfRoomAfteradd = GEEP.CB_numberOfResPerRoom.size();
			Thread.sleep(2000);
			Assert.assertFalse(noOfRoomBeforeadd == noOfRoomAfteradd);
			GenericMethods.clickElement(GEEP.Icon_deleteGroupRoom);
			Thread.sleep(2000);
			GenericMethods.ActionOnAlert("Accept");
			Thread.sleep(2000);
			Assert.assertEquals(GenericMethods.value.trim(),
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
			int noOfRoomAfterDeletion = GEEP.CB_numberOfResPerRoom.size();
			Assert.assertTrue(noOfRoomBeforeadd == noOfRoomAfterDeletion);
			Reporter.log("Room addition and deletion verified at group reservation", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;

		}
	}

	@Test(priority = 33, description = "To verify 'Early Check-in Selected' button in group reservation.")
	public void fn_verifyEarlyCheckinSelectedBtnInGrpReserv() throws Throwable {// TC_133_134_135
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
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			GroupReservationPage GRP = AQRP.FillQuickResvsForm(iTestCaseRow, AQRP.Link_GroupRes);
			FP = GRP.ClickOnReserve();
			FP.fn_verifyReservation();
			Thread.sleep(2000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele);
			Thread.sleep(2000);
			GroupViewDetailPage GVD = FP.fn_clickOnViewDetailLink();
			GroupEnableEditingPage GEEP = GVD.fn_clickOnEnableEditingBtn();
			Thread.sleep(2000);
			ArrayList<String> al = GEEP.getGroupResIds();
			GEEP.fn_earlyCheckInSelected(al.get(0).toString());
			Thread.sleep(2000);
			Assert.assertEquals(GEEP.headerEarlyCheckIn.trim(),
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Thread.sleep(2000);
			// Assert.assertEquals(GEEP.alertForEarlyCheckin.trim(),
			// ExcelUtil.getCellData(iTestCaseRow,
			// ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
			Thread.sleep(2000);
			WebElement ele1 = FP.getWebElement(FrontdeskLandingPage.resvId);
			FP.fn_rightClickOnReservation(ele1);
			GVD = FP.fn_clickOnViewDetailLink();
			GEEP = GVD.fn_clickOnEnableEditingBtn();
			Thread.sleep(2000);
			String stat = GEEP.fn_getResStatus(al.get(0).toString());
			Thread.sleep(2000);
			Assert.assertEquals(stat,
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
			Reporter.log("EarlyCheckIn successfull for the group to single reservation", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 59, description = "To verify 'No-Show Selected' button in group reservation.")
	public void fn_verifyNoShowSelectedInGrpReserv() throws Throwable {// TC_136_137_138
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
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			GroupReservationPage GRP = AQRP.FillQuickResvsForm(iTestCaseRow, AQRP.Link_GroupRes);
			FP = GRP.ClickOnReserve();
			FP.fn_verifyReservation();
			Thread.sleep(2000);
			String ti = GenericMethods.fn_getResNumber(FP.title).trim(); // title
			int id = Integer.parseInt(ti) + 1;
			String ti1 = String.valueOf(id);
			System.out.println(ti1 + " group another res ID");
			Thread.sleep(2000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			String click = ele.getAttribute("title");
			System.out.println(click + " 1st tym web click and title");
			FP.fn_rightClickOnReservation(ele);
			GroupViewDetailPage GVD = FP.fn_clickOnViewDetailLink();
			GroupEnableEditingPage GEEP = GVD.fn_clickOnEnableEditingBtn();
			ArrayList<String> al = GEEP.getGroupResIds();
			GEEP.fn_cancelAndNoShowRes(al.get(0).toString());
			Thread.sleep(2000);
			WebElement eles = GenericMethods.fn_getWebElementForGroup(ti1);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(eles);
			GVD = FP.fn_clickOnViewDetailLink();
			GEEP = GVD.fn_clickOnEnableEditingBtn();
			Thread.sleep(2000);
			Assert.assertTrue(GEEP.Link_showCancelled.isDisplayed());
			Reporter.log("No show or cancellation of reservation has been done successfully", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 35, description = "Given Discount verified in Rate detail section after saving the discount and reservation.")
	public void fn_verifyAmountChangeInGrpReserv() throws Throwable {// TC_139_140_141
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
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			GroupReservationPage GRP = AQRP.FillQuickResvsForm(iTestCaseRow, AQRP.Link_GroupRes);
			FP = GRP.ClickOnReserve();
			FP.fn_verifyReservation();
			Thread.sleep(2000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele);
			GroupViewDetailPage GVD = FP.fn_clickOnViewDetailLink();
			GroupEnableEditingPage GEEP = GVD.fn_clickOnEnableEditingBtn();
			Thread.sleep(4000);
			//GenericMethods.fn_ActionsClick(GEEP.Link_RateInRateTypeForGroup);
			GenericMethods.fn_DoubleClickOnWebElement(GEEP.Link_RateInRateTypeForGroup);
			GEEP.fn_GiveDiscountInStandardRateForGR();
			float givenDiscount = GenericMethods
					.fn_getRateFromRateString(GenericMethods.getText(GEEP.Text_givenDiscount));
			float expDisc = Float.parseFloat(GEEP.discAmt);
			Assert.assertEquals(givenDiscount, expDisc, 0.0f);
			Reporter.log("Given Discount verified in Rate detail section.", true);
			FP = GEEP.fn_clickOnSaveBtn();
			Thread.sleep(2000);
			WebElement ele1 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele1);
			GVD = FP.fn_clickOnViewDetailLink();
			GEEP = GVD.fn_clickOnEnableEditingBtn();
			float givenDiscount1 = GenericMethods
					.fn_getRateFromRateString(GenericMethods.getText(GEEP.Text_givenDiscount));
			Assert.assertEquals(givenDiscount1, expDisc, 0.0f);
			Reporter.log("Given Discount verified in Rate detail section after saving the discount and reservation.",
					true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 36, description = "To verify 'Manage Sharer(s)' in group reservation.")
	public void fn_verifyManageSharerInGrpReserv() throws Throwable {// TC_142_143_144_64_65_66
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
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			GroupReservationPage GRP = AQRP.FillQuickResvsForm(iTestCaseRow, AQRP.Link_GroupRes);
			FP = GRP.ClickOnReserve();
			FP.fn_verifyReservation();
			Thread.sleep(2000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele);
			Thread.sleep(2000);
			GroupViewDetailPage GVD = FP.fn_clickOnViewDetailLink();
			GroupEnableEditingPage GEED = GVD.fn_clickOnEnableEditingBtn();
			ArrayList<String> al = GEED.getGroupResIds();
			GEED.fn_addGuestDetails(al.get(0).toString(), GEED.gues1Detail);
			GEED.fn_addGuestDetails1(al.get(1).toString(), GEED.gues2Detail);
			GroupToSingleReservationPage GTSRP = GEED.fn_moveFromGroupToSingle(al.get(0).toString());
			GenericMethods.clickElement(GTSRP.Link_ManageSharer);
			GTSRP.fn_addGuestDetail(GTSRP.al, "yes");
			Thread.sleep(5000);
			GTSRP.fn_getGuestAllDetail();
			ArrayList<String> gname = GTSRP.fn_getGuestFirstNLastName(GTSRP.guestFullName);
			Thread.sleep(2000);
			System.out.println("gname came as:::::::"+gname.get(0).toString());
			System.out.println("GTSRP came as:::::::"+GTSRP.al.get(0).toString());
			
			Assert.assertTrue(gname.get(0).toString().equalsIgnoreCase(GTSRP.al.get(0).toString()));
			Thread.sleep(2000);
			Assert.assertTrue(gname.get(1).toString().equalsIgnoreCase(GTSRP.al.get(1).toString()));
			Thread.sleep(2000);
			Assert.assertTrue(GTSRP.chargeSharerGuest.equalsIgnoreCase("1"));
			GEED = GTSRP.fn_clickOnBackToGroupBtn();
			String gnam = GEED.fn_getGuestName(al.get(0).toString());
			ArrayList<String> name = GEED.fn_getGuestFirstNLastName(gnam);
			Assert.assertTrue(name.get(0).toString().equalsIgnoreCase(GEED.gues1Detail.get(0).toString()));
			Thread.sleep(2000);
			Assert.assertTrue(name.get(1).toString().equalsIgnoreCase(GEED.gues1Detail.get(1).toString()));
			Reporter.log("Guest detail filled and verified along with charge sharer", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 60, description = "CheckIn and checkout date changed successfully.")
	public void fn_verifyChangeInCheckInAndCheckOutDateInGrpResv() throws Throwable {// TC_145_146_147_148_67
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
		//	iTestCaseRow=	50;
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			GenericMethods.js_Click(FrontdeskLandingPage.Current_Link);
			Thread.sleep(2000);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "4");
			GroupReservationPage GRP = AQRP.FillQuickResvsForm(iTestCaseRow, AQRP.Link_GroupRes);
			FP = GRP.ClickOnReserve();
			FP.fn_verifyReservation();
			Thread.sleep(2000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele);
			Thread.sleep(2000);
			GroupViewDetailPage GVD = FP.fn_clickOnViewDetailLink();
			GroupEnableEditingPage GEED = GVD.fn_clickOnEnableEditingBtn();
			ArrayList<String> al = GEED.getGroupResIds();
			String dateRange = GEED.fn_getCheckInCheckOutDates(al.get(0).toString());
			System.out.println(dateRange);
			Thread.sleep(2000);
			String dateRange1 = GEED.fn_getCheckInCheckOutDates(al.get(1).toString());
			System.out.println(dateRange1);
			System.out.println("Reservation id passed in method:" + al.get(0).toString());
			GEED.fn_ChangeCheckInDate(al.get(0).toString(), 1);
			Thread.sleep(4000);
			//GenericMethods.scrollUp("250");
			GEED.fn_ChangeCheckOutDate(al.get(1).toString(), 1);
			Thread.sleep(2000);

			FP = GEED.fn_clickOnSaveBtn();
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(FP.getWebElement(FrontdeskLandingPage.resvId));
			GVD = FP.fn_clickOnViewDetailLink();
			GEED = GVD.fn_clickOnEnableEditingBtn();
			Thread.sleep(2000);

			String ChangedateRange = GEED.fn_getCheckInCheckOutDates(al.get(0).toString());
			String ChangedateRange1 = GEED.fn_getCheckInCheckOutDates(al.get(1).toString());
			Thread.sleep(2000);
			Assert.assertFalse(dateRange.equals(ChangedateRange));
			Thread.sleep(2000);
			Assert.assertFalse(dateRange1.equals(ChangedateRange1));
			Reporter.log("CheckIn and checkout date changed successfully.", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 38, description = "To verify 'Pay Terms' in group reservation.")
	public void fn_verifyPayTermInGrpReserv() throws Throwable {// TC_152
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
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			GroupReservationPage GRP = AQRP.FillQuickResvsForm(iTestCaseRow, AQRP.Link_GroupRes);
			FP = GRP.ClickOnReserve();
			FP.fn_verifyReservation();
			Thread.sleep(2000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele);
			GroupViewDetailPage GVD = FP.fn_clickOnViewDetailLink();
			GroupEnableEditingPage GEED = GVD.fn_clickOnEnableEditingBtn();
			GEED.fn_ChangePayTerms(iTestCaseRow);
			Thread.sleep(2000);
			WebElement ele1 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele1);
			GVD = FP.fn_clickOnViewDetailLink();
			GEED = GVD.fn_clickOnEnableEditingBtn();
			Thread.sleep(2000);
			Assert.assertTrue(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PayTerms))
					.equalsIgnoreCase(GenericMethods.getText(GEED.Text_PayTerm).trim()));
			Reporter.log("PayTerms Verified ", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 39, description = "To verify whether selected room is marked as DNR or not.")
	public void fn_verifyDNRForSelectedRoom() throws Throwable {// TC_153_154
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			Thread.sleep(2000);
			System.out.println("clicking cancel");
			FP.fn_ClickCancelButton();
			GenericMethods.js_Click(FrontdeskLandingPage.Current_Link);
			String cwid = GenericMethods.GetCurrentWindowID();
			System.out.println("parent id initially:"+cwid);
			BasePage BP = FP.fn_NavigateAdmineConsole();
			GenericMethods.windowHandle(cwid);
			Thread.sleep(8000);
		//String s1=	GenericMethods.windowHandle_admin();
		//System.out.println("child window id came as:"+s1);
			
			RoomsLandingPage RLP = BP.roomsPageNavigate();
			AddRoomsPage ARP = RLP.click_AddRoom();
			ARP.addRoomName(1);
			System.out.println("parent id after addding room:"+cwid);
			GenericMethods.Switch_Parent_Window(cwid);
			Thread.sleep(2000);
			GenericMethods.driver.navigate().refresh();
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			FP.fn_clickCurrentLnk();
			Thread.sleep(2000);
			WebElement ele = FP.fn_selectRoomForDNR(AddRoomsPage.roomNumber.trim());
			Thread.sleep(2000);
			String str = GenericMethods.generateRandomString();
			FP.fn_ApplyDNRToRoom(ele, str.trim());
			Thread.sleep(2000);
			String DNRStat = FP.fn_verifyRoomDNR(str.trim());
			System.out.println(DNRStat);
			Thread.sleep(2000);
			Assert.assertEquals(DNRStat,
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
			Reporter.log("DNR applied to the room", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 40, description = "Room addition functionality verified after saving group reservation.")
	public void fn_verifyAddNewRoomInGrpResv() throws Throwable {
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
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			GroupReservationPage GRP = AQRP.FillQuickResvsForm(iTestCaseRow, AQRP.Link_GroupRes);
			FP = GRP.ClickOnReserve();
			FP.fn_verifyReservation();
			Thread.sleep(2000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele);
			GroupViewDetailPage GVD = FP.fn_clickOnViewDetailLink();
			GroupEnableEditingPage GEEP = GVD.fn_clickOnEnableEditingBtn();
			GEEP.CB_numberOfResPerRoom.size();
			GenericMethods.clickElement(GEEP.Btn_AddNewRoomToGroup);
			Thread.sleep(2000);
			GEEP.fn_addNewRoomToGroup();
			Thread.sleep(2000);
			int noOfRoomAfteradd = GEEP.CB_numberOfResPerRoom.size();
			Thread.sleep(2000);
			GEEP.fn_clickOnSaveBtn();
			Thread.sleep(2000);
			WebElement ele1 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele1);
			GVD = FP.fn_clickOnViewDetailLink();
			GEEP = GVD.fn_clickOnEnableEditingBtn();
			int numberOfRoomAfterSaving = GEEP.CB_numberOfResPerRoom.size();
			Thread.sleep(2000);
			Assert.assertTrue(noOfRoomAfteradd == numberOfRoomAfterSaving);
			Reporter.log("Room addition functionality verified after saving group reservation.", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;

		}
	}

	@Test(priority = 41, description = "To Verify Transfer to Room In Group Reservation. ")
	public void fn_verifyTransferToRoomInGrpReserv() throws Throwable {// TC_156_157
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
			GroupReservationPage GRP = AQRP.FillQuickResvsForm(iTestCaseRow, AQRP.Link_GroupRes);
			FP = GRP.ClickOnReserve();
			FP.fn_verifyReservation();
			Thread.sleep(2000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			FP.fn_rightClickOnReservation(ele);
			FP.fn_clkCheckin(ele);
			Thread.sleep(2000);
			WebElement ele1 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele1);
			Thread.sleep(2000);
			GroupViewDetailPage GVD = FP.fn_clickOnViewDetailLink();
			GroupEnableEditingPage GEEP = GVD.fn_clickOnEnableEditingBtn();
			Thread.sleep(2000);
			ArrayList<String> al = GEEP.getGroupResIds();
			
			GEEP.fn_addGuestDetails(al.get(0).toString(), GEEP.gues1Detail);
			Thread.sleep(4000);
			GroupToSingleReservationPage GSRP = GEEP.fn_moveFromGroupToSingle(al.get(0).toString());
			String resRoom = GSRP.fn_getReservedRoom();
			AccountStatementLandingPage ASL = GSRP.fn_clickOnPayment();

			String fd = GenericMethods.driver.getTitle();
			SampleRestaurantPage SRP = GSRP.fn_ClickOnRestaurant();
			GenericMethods.switchToWindowHandle("Sample Restaurant");
			ConfirmOrderPage COP = SRP.generateOrder();
			Thread.sleep(2000);
			OrderFolioPage OFP = COP.fn_transferOrderToRoom(resRoom);
			Thread.sleep(2000);
			TransactionListPage TLP = OFP.fn_getFolioAndCloseTransaction();
			String fnum = TLP.getFolioNumber(OFP.FNum).trim();
			System.out.println(fnum);
			Thread.sleep(2000);
			GenericMethods.switchToWindowHandle(fd);
			Thread.sleep(6000);
			ASL.fn_consolidateAccount("Accept");
			Thread.sleep(2000);
			ASL.getFolioNumberfromAccountNumber(fnum);
			Reporter.log("Pos item posted to the group and verified during consolidation process", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 61, description = "All the POS and  Room rent posted to the Account statement.")
	public void fn_verifyPOSItemthroughTRFtoroomAfterAutoNightAuditinAcc() throws Throwable {// TC_161
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			//iTestCaseRow=55;
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			GenericMethods.js_Click(FrontdeskLandingPage.Current_Link);
			Thread.sleep(2000);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			GroupReservationPage GRP = AQRP.FillQuickResvsForm(iTestCaseRow, AQRP.Link_GroupRes);
			FP = GRP.ClickOnReserve();
			FP.fn_verifyReservation();
			Thread.sleep(2000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele);
			FP.fn_clkCheckin(ele);
			Thread.sleep(2000);
			WebElement ele1 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele1);
			Thread.sleep(2000);
			GroupViewDetailPage GVD = FP.fn_clickOnViewDetailLink();
			GroupEnableEditingPage GEEP = GVD.fn_clickOnEnableEditingBtn();
			Thread.sleep(2000);
			ArrayList<String> al = GEEP.getGroupResIds();
			GEEP.fn_addGuestDetails(al.get(0).toString(), GEEP.gues1Detail);
			GroupToSingleReservationPage GSRP = GEEP.fn_moveFromGroupToSingle(al.get(0).toString());
			String resRoom = GSRP.fn_getReservedRoom();
			//String fd = GenericMethods.driver.getTitle();
			AccountStatementLandingPage ASL = GSRP.fn_clickOnPayment();
			String fd = GenericMethods.driver.getTitle();

			SampleRestaurantPage SRP = GSRP.fn_ClickOnRestaurant();
			GenericMethods.switchToWindowHandle("Sample Restaurant");
			ConfirmOrderPage COP = SRP.generateOrder();
			Thread.sleep(2000);
			OrderFolioPage OFP = COP.fn_transferOrderToRoom(resRoom);
			Thread.sleep(2000);
			TransactionListPage TLP = OFP.fn_getFolioAndCloseTransaction();
			String fnum = TLP.getFolioNumber(OFP.FNum).trim();
			System.out.println(fnum);
			Thread.sleep(2000);
			GenericMethods.switchToWindowHandle(fd);
		//	AccountStatementLandingPage ASL = GSRP.fn_clickOnPayment();
			Thread.sleep(6000);
			ASL.fn_consolidateAccount("Accept");
			Thread.sleep(2000);
			String af = ASL.getFolioNumberfromAccountNumber(fnum);
			Assert.assertEquals(af.trim(), fnum.trim());
			GenericMethods.driver.navigate().refresh();
			Thread.sleep(8000);
			GenericMethods.clickElement(FP.Btn_AutoNightAudit);
			Thread.sleep(30000);
			GenericMethods.driver.navigate().refresh();
			Thread.sleep(2000);
			GenericMethods.clickElement(FP.Btn_AutoNightAudit);
			Thread.sleep(10000);
			WebElement ele2 = FP.getWebElement(FrontdeskLandingPage.resvId);
			System.out.println("ele 2 came as::::::::::"+ele2.getText());
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele2);
			System.out.println("hi");
			ASL = FP.ClickOnPayment();
			Thread.sleep(2000);
			ASL.fn_verifyFolioAndRateType(af,
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ResRateType)));
			Reporter.log("All the POS and  Room rent posted to the Account statement.", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			System.out.println("hi");
			ExcelUtil.CloseAllExcelReferences();

			Robot robj = new Robot();
			robj.keyPress(KeyEvent.VK_TAB);
			throw e;
		}
	}

	@Test(priority = 43, description = "POS folio number verified after night audit in Account Statement")
	public void fn_verifyConsolidateAccountInNightAuditedGrpReserv() throws Throwable {// TC_162
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
			GroupReservationPage GRP = AQRP.FillQuickResvsForm(iTestCaseRow, AQRP.Link_GroupRes);
			FP = GRP.ClickOnReserve();
			FP.fn_verifyReservation();
			Thread.sleep(2000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			FP.fn_rightClickOnReservation(ele);
			FP.fn_clkCheckin(ele);
			Thread.sleep(2000);
			WebElement ele1 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele1);
			Thread.sleep(2000);
			GroupViewDetailPage GVD = FP.fn_clickOnViewDetailLink();
			GroupEnableEditingPage GEEP = GVD.fn_clickOnEnableEditingBtn();
			ArrayList<String> al = GEEP.getGroupResIds();
			GEEP.fn_addGuestDetails(al.get(0).toString(), GEEP.gues1Detail);
			GroupToSingleReservationPage GSRP = GEEP.fn_moveFromGroupToSingle(al.get(0).toString());
			Thread.sleep(3000);
			String resRoom = GSRP.fn_getReservedRoom();
			String fd = GenericMethods.driver.getTitle();
			SampleRestaurantPage SRP = GSRP.fn_ClickOnRestaurant();
			GenericMethods.switchToWindowHandle("Restaurant");
			ConfirmOrderPage COP = SRP.generateOrder();
			Thread.sleep(2000);
			OrderFolioPage OFP = COP.fn_transferOrderToRoom(resRoom);
			Thread.sleep(2000);
			TransactionListPage TLP = OFP.fn_getFolioAndCloseTransaction();
			String fnum = TLP.getFolioNumber(OFP.FNum).trim();
			System.out.println("Fnum is::::"+fnum);
			Thread.sleep(2000);
			GenericMethods.switchToWindowHandle(fd);
			GenericMethods.driver.navigate().refresh();
			Thread.sleep(10000);
			FP.fn_ClickOnAutoNightAudit();
			Thread.sleep(3000);
			FP.fn_rightClickOnReservation(FP.getWebElement(FrontdeskLandingPage.resvId));
			AccountStatementLandingPage ASL = FP.ClickOnPayment();
			WebElement ele3 = ASL.fn_checkPosFolio(fnum);
			Assert.assertTrue(ele3.isDisplayed());
			Reporter.log("POS folio number verified after night audit in Account Statement", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;

		}
	}

	@Test(priority = 44, description = "To Verify Tax exempt for Group Reservation ")
	public void fn_verifyTaxExemptforGrpreservation() throws Throwable {// TC_163_164_165_166_167_68_69
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
		//	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
		//	iTestCaseRow=57;
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			GenericMethods.js_Click(FrontdeskLandingPage.Current_Link);
			String cwid = GenericMethods.GetCurrentWindowID();
			BasePage BP = FP.fn_NavigateAdmineConsole();
			GenericMethods.windowHandle(cwid);
			TaxExemptListPage TELP = BP.fn_navigateToTaxExemptReason();
			TELP.fn_verifyTaxExemptReason(iTestCaseRow);
			GenericMethods.Switch_Parent_Window(cwid);
			Thread.sleep(2000);
			GenericMethods.driver.navigate().refresh();
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			FP.fn_clickCurrentLnk();
			Thread.sleep(2000);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			GroupReservationPage GRP = AQRP.FillQuickResvsForm(iTestCaseRow, AQRP.Link_GroupRes);
			FP = GRP.ClickOnReserve();
			FP.fn_verifyReservation();
			Thread.sleep(2000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			FP.fn_rightClickOnReservation(ele);
			FP.fn_clkCheckin(ele);
			Thread.sleep(2000);
			WebElement ele1 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele1);
			GroupViewDetailPage GVDP = FP.fn_clickOnViewDetailLink();
			GroupEnableEditingPage GEEP = GVDP.fn_clickOnEnableEditingBtn();
			ArrayList<String> resId = GEEP.getGroupResIds();
			GEEP.fn_addGuestDetails(resId.get(0).toString(), GEEP.gues1Detail);
			AccountStatementLandingPage ASL = GEEP.fn_ClickOnGroupPayment();
			GenericMethods.clickElement(ASL.Btn_GroupCustomCharge);
			Reporter.log("Custom charge Allowances header verified", true);
			ASL.fn_AddCustomCharges(iTestCaseRow);
			Thread.sleep(10000);
			ASL.VerifyPostedCustomCharge(iTestCaseRow);
			Reporter.log("Posted cutom charge verified at account statement", true);
			GenericMethods.clickElement(ASL.Btn_GroupOtherCharges);
			Thread.sleep(6000);
			ASL.fn_addOtherCharge(iTestCaseRow);
			System.out.println("Hey");
			Thread.sleep(2000);
			ASL.VerifyOtherCharges(ASL.selProduct);
			Thread.sleep(2000);
			GenericMethods.clickElement(ASL.Btn_GenerateFolio);
			GenericMethods.ActionOnAlert("Accept");
			Thread.sleep(2000);
			Assert.assertEquals(ASL.Link_ToPerfomaInvoice.isDisplayed(), true);
			ArrayList<String> allPI = ASL.fn_getAllPI();
			ReservationFolioPage RFP = ASL.fn_clickOnFolio(allPI.get(0).toString());
			float tamt = RFP.fn_getTaxAmt();
			System.out.println(tamt);
			RFP.fn_TaxExempt();
			Thread.sleep(2000);
			float tamt1 = RFP.fn_getTaxAmt();
			System.out.println(tamt1);
			Thread.sleep(2000);
			Assert.assertNotEquals(tamt, tamt1);
			Reporter.log("Tax Exempted from the reservation", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 62, description = "To Verify Route charge, Route to new Folio Route Payment in Account Statement ")
	public void fn_verifyRouteChargeRouteToNewFolioRoutePayment() throws Throwable {// TC_168_169_170_171_172_173
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
			GroupReservationPage GRP = AQRP.FillQuickResvsForm(iTestCaseRow, AQRP.Link_GroupRes);
			FP = GRP.ClickOnReserve();
			FP.fn_verifyReservation();
			Thread.sleep(2000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			FP.fn_rightClickOnReservation(ele);
			FP.fn_clkCheckin(ele);
			Thread.sleep(2000);
			WebElement ele1 = FP.getWebElement(FrontdeskLandingPage.resvId);
			FP.fn_rightClickOnReservation(ele1);
			GroupViewDetailPage GVDP = FP.fn_clickOnViewDetailLink();
			GroupEnableEditingPage GEEP = GVDP.fn_clickOnEnableEditingBtn();
			ArrayList<String> resId = GEEP.getGroupResIds();
			GEEP.fn_addGuestDetails(resId.get(0).toString(), GEEP.gues1Detail);
			GroupToSingleReservationPage GTSRP = GEEP.fn_moveFromGroupToSingle(resId.get(0).toString());
			GenericMethods.clickElement(GTSRP.Link_ManageSharer);
			GTSRP.fn_addGuestDetail(GTSRP.al, "yes");
			Thread.sleep(2000);
			GEEP = GTSRP.fn_clickOnBackToGroupBtn();
			Thread.sleep(2000);
			FP = GEEP.fn_clickOnSaveBtn();
			Thread.sleep(2000);
			FP = FP.fn_refreshFrontdesk();
			FP = FP.fn_performAutoNightAudit();
			Thread.sleep(2000);
			WebElement ele2 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele2);
			AccountStatementLandingPage ASL = FP.ClickOnPayment();
			Reporter.log("Clicked over payment", true);
			GenericMethods.clickElement(ASL.Btn_GenerateFolio);
			Thread.sleep(2000);
			GenericMethods.ActionOnAlert("Accept");
			Thread.sleep(2000);
			int size = ASL.CB_GeneratedFolio.size();
			System.out.println(size);
			GenericMethods.clickElement(ASL.CB_AccountPostingMasterCB);
			Thread.sleep(2000);
			GenericMethods.clickElement(ASL.Btn_RouteToNewFolio);
			Thread.sleep(2000);
			Assert.assertEquals(GenericMethods.getText(ASL.HeaderTxt_CreateNewFolioforGrp).trim(),
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Reporter.log("Create new folio pop up header text verified.", true);
			ASL.fn_createNewFolio(2);
			Thread.sleep(8000);
			System.out.println("ACTUAL:::::::::::::::::::" + ASL.CB_GeneratedFolio.size());
			int ex=ASL.CB_GeneratedFolio.size();
			int exp=size-1;
			System.out.println("EXPECTED::" + exp);
			Assert.assertEquals(ASL.CB_GeneratedFolio.size(), exp);
			float res = ASL.fn_getTotalPostedItemRatefromAccountStatement();
			System.out.println(res);
			GenericMethods.clickElement(ASL.CB_AccountPostingMasterCB);
			GenericMethods.clickElement(ASL.Btn_RouteCharges);
			Thread.sleep(2000);
			Assert.assertEquals(GenericMethods.getText(ASL.Header_routeChargesTitleforGrp).trim(),
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
			String guest = ASL.fn_routeCharges(1);
			String pi = ASL.fn_getPI(guest);
			Thread.sleep(2000);
			float rate = ASL.VerifyRoutedCharge(pi);
			Thread.sleep(2000);
			Assert.assertEquals(res, rate, 0.0f);
			Reporter.log("Route charge verified", true);
			ASL.doPayment("Cash");
			ASL.fn_routePayment(iTestCaseRow, 1, "group");
			Thread.sleep(3000);
			float rate1 = ASL.fn_getTotalAmountfromAccountStatement();
			Thread.sleep(2000);
			System.out.println("ASL.selValue::::"+ASL.selValue);
			String pi1 = ASL.fn_getPI(ASL.selValue);
			Thread.sleep(2000);
			float rate2 = ASL.fn_verifyRoutedPayment(pi1);
			Thread.sleep(2000);
			//Assert.assertTrue(rate1 == rate2);
			Reporter.log("Routed payment verified", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 46, description = "To Verify Refund Functionality for Group Reservation")
	public void fn_verifyRefundfunctionalityforGroupResv() throws Throwable {// TC_174_175
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			//iTestCaseRow=	59;
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			GenericMethods.js_Click(FrontdeskLandingPage.Current_Link);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			GroupReservationPage GRP = AQRP.FillQuickResvsForm(iTestCaseRow, AQRP.Link_GroupRes);
			FP = GRP.ClickOnReserve();
			FP.fn_verifyReservation();
			Thread.sleep(2000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			FP.fn_rightClickOnReservation(ele);
			FP.fn_clkCheckin(ele);
			Thread.sleep(2000);
			WebElement ele1 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele1);
			GroupViewDetailPage GVDP = FP.fn_clickOnViewDetailLink();
			GroupEnableEditingPage GEEP = GVDP.fn_clickOnEnableEditingBtn();
			ArrayList<String> resId = GEEP.getGroupResIds();
			GEEP.fn_addGuestDetails(resId.get(0).toString(), GEEP.gues1Detail);
			GEEP.fn_clickOnSaveBtn();
			Thread.sleep(2000);
			WebElement ele2 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele2);
			AccountStatementLandingPage ASL = FP.ClickOnPayment();
			GenericMethods.clickElement(ASL.Btn_GroupCustomCharge);
			Reporter.log("Custom charge Allowances header verified", true);
			ASL.fn_AddCustomCharges(iTestCaseRow);
			Reporter.log("Posted cutom charge verified at account statement", true);
			GenericMethods.clickElement(ASL.Btn_GroupOtherCharges);
			Thread.sleep(2000);
			ASL.fn_addOtherCharge(iTestCaseRow);
			Thread.sleep(2000);
			ASL.fn_selectAddedCustCharge(iTestCaseRow);
			String text = ASL.fn_clkRefundGrp();
			Thread.sleep(2000);
			Assert.assertEquals(text.trim(),
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)).trim());
			Thread.sleep(2000);
			float p = ASL.fn_getChargeForPostedItem();
			Thread.sleep(2000);
			Assert.assertEquals(p, 0.0f, 0.0f);
			Reporter.log("Refund functionality working fine.", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 47, description = "Payment for group reservation has been done through cheque pay mode")
	public void fn_verifyChequePayNowInGrpReservThroughRTClkPayment() throws Throwable {// TC_176
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
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			GroupReservationPage GRP = AQRP.FillQuickResvsForm(iTestCaseRow, AQRP.Link_GroupRes);
			FP = GRP.ClickOnReserve();
			FP.fn_verifyReservation();
			Thread.sleep(4000);
			FP.fn_rightClickOnReservation(FP.getWebElement(FrontdeskLandingPage.resvId));
			Thread.sleep(4000);
			FP.fn_clkCheckin(FP.getWebElement(FrontdeskLandingPage.resvId));
			Thread.sleep(2000);
			FP = FP.fn_refreshFrontdesk();
			FP = FP.fn_performAutoNightAudit();
			Thread.sleep(3000);
			FP.fn_rightClickOnReservation(FP.getWebElement(FrontdeskLandingPage.resvId));
			AccountStatementLandingPage ASL = FP.ClickOnPayment();
			ASL.fn_GetBalanceAmt();
			Thread.sleep(2000);
			ASL.fn_doPaymentUsingCheque(iTestCaseRow);
			Thread.sleep(2000);
			float afterPaid = ASL.fn_GetBalanceAmt();
			Thread.sleep(2000);
			Assert.assertEquals(afterPaid, 0.0, 0.0);
			Reporter.log("Payment for group reservation has been done through cheque pay mode", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 48, description = "To verify Settlr folio and lock folio in Group Reservation")
	public void fn_verifySettleFolioAndLockFolioAlertAcceptInGrpResv() throws Throwable {// TC_177_178_179
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			//iTestCaseRow=61;
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			GenericMethods.js_Click(FrontdeskLandingPage.Current_Link);
			Thread.sleep(2000);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			GroupReservationPage GRP = AQRP.FillQuickResvsForm(iTestCaseRow, AQRP.Link_GroupRes);
			FP = GRP.ClickOnReserve();
			FP.fn_verifyReservation();
			Thread.sleep(2000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			FP.fn_rightClickOnReservation(ele);
			FP.fn_clkCheckin(ele);
			Thread.sleep(2000);
			WebElement ele1 = FP.getWebElement(FrontdeskLandingPage.resvId);
			FP.fn_rightClickOnReservation(ele1);
			GroupViewDetailPage GVD = FP.fn_clickOnViewDetailLink();
			GroupEnableEditingPage GEEP = GVD.fn_clickOnEnableEditingBtn();
			ArrayList<String> resId = GEEP.getGroupResIds();
			GEEP.fn_addGuestDetails(resId.get(0).toString(), GEEP.gues1Detail);
			Thread.sleep(2000);
			FP = GEEP.fn_clickOnSaveBtn();
			Thread.sleep(2000);
			FP = FP.fn_refreshFrontdesk();
			Thread.sleep(2000);
			FP = FP.fn_performAutoNightAudit();
			Thread.sleep(2000);
			WebElement ele2 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele2);
			AccountStatementLandingPage ASL = FP.ClickOnPayment();
			GenericMethods.js_Click(ASL.CB_AccountPostingMasterCB);
			GenericMethods.js_Click(ASL.Btn_GenerateFolio);
			GenericMethods.ActionOnAlert("Accept");
			ASL.fn_getAllPI();
			Thread.sleep(2000);
			ASL.fn_doPaymentUsingCheque(iTestCaseRow);
			Thread.sleep(2000);
		//	ASL.invoiceText.getText();
			GenericMethods.clickElement(ASL.Btn_settleFolio);
			Thread.sleep(2000);
			GenericMethods.ActionOnAlert("Accept");
			Reporter.log("Settle folio pop text verified.", true);
			Thread.sleep(2000);
			GenericMethods.clickElement(ASL.Btn_LockFolio);
			Thread.sleep(2000);
			GenericMethods.ActionOnAlert("Accept");
			Thread.sleep(2000);
			Assert.assertTrue(GenericMethods.value.trim().contains(
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))));
			Thread.sleep(2000);
			Assert.assertTrue(ASL.Link_InvoiceNumber.isDisplayed());
			Reporter.log("PI Changed to the INV", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 49, description = "Group reservation successfully checkedIn through check In button of reservation after right click.")
	public void fn_groupCheckInThroughRightClickOption() throws Throwable {
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			//iTestCaseRow=	62;
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			GenericMethods.js_Click(FrontdeskLandingPage.Current_Link);
			Thread.sleep(2000);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			FP = AQRP.FillQuickResForm(iTestCaseRow);
			FP.fn_verifyReservation();
			Thread.sleep(4000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			String resStat = ele.getAttribute("groupstatus");
			FP.fn_rightClickOnReservation(ele);
			FP.fn_GroupCheckIn();
			Thread.sleep(4000);
			WebElement ele1 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			String resStat1 = ele1.getAttribute("groupstatus");
			Thread.sleep(2000);
			Assert.assertFalse(resStat.equals(resStat1));
			Reporter.log(
					"Group reservation successfully checkedIn through check In button of reservation after right click.",
					true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 50, description = "Group reservation successfully checkedIn through check In button of Enable Editing Page.")
	public void fn_groupCheckInThroughEnableEditingPage() throws Throwable {
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			//iTestCaseRow=	63;
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			GenericMethods.js_Click(FrontdeskLandingPage.Current_Link);
			Thread.sleep(2000);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			FP = AQRP.FillQuickResForm(iTestCaseRow);
			FP.fn_verifyReservation();
			Thread.sleep(2000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			String resStat = ele.getAttribute("groupstatus");
			FP.fn_rightClickOnReservation(ele);
			GroupViewDetailPage GVDP = FP.fn_clickOnViewDetailLink();
			GroupEnableEditingPage GEEP = GVDP.fn_clickOnEnableEditingBtn();
			GEEP.fn_ClickOnGroupCheckInBtn();
			Thread.sleep(4000);
			WebElement ele1 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			String resStat1 = ele1.getAttribute("groupstatus");
			Thread.sleep(2000);
			Assert.assertFalse(resStat.equals(resStat1));
			Reporter.log("Group reservation successfully checkedIn through check In button of Enable Editing Page.",
					true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 51, description = "Single reservation successfully checkedIn through check In button avilable at right click option of reservation")
	public void fn_SingleReservationCheckInThroughRightClickOption() throws Throwable {
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			
			iTestCaseRow=	hm.get(sTestCaseName);
			//iTestCaseRow=	64;
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			GenericMethods.js_Click(FrontdeskLandingPage.Current_Link);
			Thread.sleep(2000);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			FP = AQRP.FillQuickResForm(iTestCaseRow);
			FP.fn_verifyReservation();
			Thread.sleep(2000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			ele.getAttribute("rsvstatus");
			FP.fn_rightClickOnReservation(ele);
			FP.fn_clkCheckin(ele);
			GenericMethods.ActionOnAlert("Accept");
			Thread.sleep(2000);
			WebElement ele1 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			String resStat1 = ele1.getAttribute("rsvstatus");
			Thread.sleep(2000);
			Assert.assertEquals(resStat1, "CHECKIN");
			Reporter.log(
					"Single reservation successfully checkedIn through check In button avilable at right click option of reservation.",
					true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 52, description = "Single reservation successfully checkedIn through check In button avilable on Enable editing page.")
	public void fn_SingleReservationCheckInThroughEnableEditingPage() throws Throwable {
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
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			FP = AQRP.FillQuickResForm(iTestCaseRow);
			FP.fn_verifyReservation();
			Thread.sleep(2000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			ele.getAttribute("rsvstatus");
			FP.fn_rightClickOnReservation(ele);
			ViewDetailsPage VDP = FP.fn_ClickOnViewDetailLink();
			EnableEditingPage EEP = VDP.ClickOnEnableEditing();
			FP = EEP.CheckInSingleRes();
			Thread.sleep(3000);
			WebElement ele1 = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			String resStat1 = ele1.getAttribute("rsvstatus");
			Thread.sleep(2000);
			Assert.assertEquals(resStat1, "CHECKIN");
			Reporter.log(
					"Single reservation successfully checkedIn through check In button avilable on Enable editing page.",
					true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 53, description = "To Verify Split Reservation using right click split reservation link of Single Reservation")
	public void fn_splitReservationUsingSplitButtonOnRightclickOptionofReservation() throws Throwable {
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
			FP = AQRP.FillQuickResForm(iTestCaseRow);
			FP.fn_verifyReservation();
			Thread.sleep(2000);
			WebElement ele = FP.getWebElement(FrontdeskLandingPage.resvId);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele);
			int dayz = FP.fn_splitReservation();
			Assert.assertEquals(dayz, 4);
			Reporter.log("Single reservation of 2 days splitted successfully.", true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 54, description = "To verify whether user gets logged into the system or not when 'Yes' radio button for opening the cash counter is selected.")
	public void fn_verifyCashCounterForYesOption() throws Throwable {
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			CloseCashCounterPage CCP = FP.fn_clkCloseCashCounter();
			CashCounterPage CP = CCP.fn_clkCloseWithdrawBtn();
			OpenCashCounter OCC = CP.fn_selectYesRB("Default Counter (Close)");
			OCC.fn_clkEnter();
			FP.fn_ClickCancelButton();
			Assert.assertEquals(GenericMethods.driver.getTitle().contains(
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 55, description = "Create 1R2N reservation & verify 'Temp Reserve' button on Add Quick Reservation form.")
	public void fn_verifyTempReservBtnInSingleReserv() throws Throwable {
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			Thread.sleep(4000);
			FP.fn_ClickCancelButton();
			Thread.sleep(4000);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "4");
			Thread.sleep(2000);
			// String fname=GenericMethods.generateRandomString();
			AQRP.FillQuickResvsForm(iTestCaseRow, FP.btn_TempReserve);
			// System.out.println("The First name is:" +fname);
			Thread.sleep(6000);
			// TempRoomList
			// TRL=FP.fn_verifyTempReserve(ExcelUtil.getCellData(iTestCaseRow,
			// ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			FP.fn_verifyTempReserve(AQRP.fname);
			// TRL.fn_verifyTempResv(AQRP.fname+" "+AQRP.lname);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 56, description = "Create 1R2N reservation & verify 'Assign' checkbox on Add Quick Reservation form.")
	public void fn_verifyAssignChkbxInSingleTempResv() throws Throwable {
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			//iTestCaseRow=69;
			Thread.sleep(8000);
			FP.fn_ClickCancelButton();
			Thread.sleep(4000);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "4");
			Thread.sleep(2000);
			// String fname=GenericMethods.generateRandomString();
			AQRP.FillQuickResvsFormAssign(iTestCaseRow, FP.btn_TempReserve);
			Thread.sleep(6000);
			// TempRoomList
			// TRL=FP.fn_verifyTempReserve(ExcelUtil.getCellData(iTestCaseRow,
			// ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			FP.fn_verifyTempReserve(AQRP.fname);
			// TRL.fn_verifyTempResv(AQRP.fname+" "+AQRP.lname);
		} catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 63, description = "Create 1R2N reservation & verify 'Hold Till' checkbox on Add Quick Reservation form.")
	public void fn_verifyHoldTillChkbxInSingleTempResv() throws Throwable {
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk1);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
		//	iTestCaseRow=	70;
			Thread.sleep(4000);
			FP.fn_ClickCancelButton();
			Thread.sleep(4000);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "4");
			Thread.sleep(2000);
			// String fname=GenericMethods.generateRandomString();
			AQRP.FillQuickResvsFormHoldTill(iTestCaseRow, FP.btn_TempReserve);
			AQRP.fn_selectHoldTillDate();
			System.out.println("Hey Hold Till Called Successfully");
			FP.fn_verifyTempReserve(AQRP.fname);
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
// @AfterClass
/*
 * public void ExitFromWebdriverInstance() { //GenericMethods.driver.quit(); }
 */

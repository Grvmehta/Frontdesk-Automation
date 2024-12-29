package com.hotelogix.smoke.FrontdeskTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotelogix.smoke.admin.BaseClass.AdmineHome;
import com.hotelogix.smoke.admin.PriceManager.AddEditPackage;
import com.hotelogix.smoke.admin.PriceManager.AddMoreInclusions;
import com.hotelogix.smoke.admin.PriceManager.AddonLandingPage;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesFrontdesk;
import com.hotelogix.smoke.admin.PriceManager.ListofPackagesInPackageMaster;
import com.hotelogix.smoke.admin.PriceManager.attachPackages;
import com.hotelogix.smoke.admin.roommanager.RoomsLandingPage;
import com.hotelogix.smoke.admin.roommanager.AddRoomsPage;
import com.hotelogix.smoke.frontdesk.CashCounter.CashCounterPage;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.CheckinCard;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.FrontdeskLandingPage;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.NightAuditLandingPage;
import com.hotelogix.smoke.frontdesk.FrontdeskTrialPage.FrontdeskContinueTrialPage;
import com.hotelogix.smoke.frontdesk.Payment.AccountStatementLandingPage;
import com.hotelogix.smoke.frontdesk.ReservationSearchResult.ReservationSearchResultLandingPage;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.ConfirmOrderPage;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.ConfirmOrderPage1;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.OrderFolioPage;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.SampleRestaurantPage;
import com.hotelogix.smoke.frontdesk.ViewDetailsPage.EnableEditingPage;
import com.hotelogix.smoke.frontdesk.ViewDetailsPage.ViewDetailsPage;
import com.hotelogix.smoke.genericandbase.BasePage;
import com.hotelogix.smoke.genericandbase.GenericMethods;
import com.hotelogix.smoke.login.FrontdeskLoginPage;

public class TapeChartTest
{
	private static BasePage BP;

	@BeforeMethod
	public void Login() throws Exception

	{
	try{
	FrontdeskLoginPage AL = GenericMethods.fn_OpenFrontdesk("FF", "http://hotelogix.stayezee.com/frontdesk/login/login/");
	//AL.Frontdesklogin_12725();
	AdmineHome.bResult = true;
	}catch(Exception e){
	    throw e;
	}

	Thread.sleep(2000);

	}

/*
  @Test(priority=1)
     public void TC_31() throws Exception
     {
    	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
 		 AL.Frontdesklogin_11744();
 		 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
 		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
 		 FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_NavigateAdminConsole();
         RoomsLandingPage RLP=BP.roomsPageNavigate();
         RLP.click_AddRoom();
         AddRoomsPage SRP=new AddRoomsPage();
         //SRP.AddRoomName();
        // RoomsLandingPage RLP=new RoomsLandingPage();
         RLP.fn_NavigateFrontdesk();
 		 GenericMethods.driver.navigate().refresh();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.getCountOfRooms1();
         FLP.WindowScroll();
         FLP.fn_SingleResrvTwoRoomNT();
         FLP.fn_verifyAddQuickResrvTitle();
         //FLP.fn_fillAddQuickResrv();
         //Thread.sleep(20000);
         System.out.println("TC_31 Executed");

     }


     @Test(priority=2)




     @Test(priority=3)
     public void TC_33() throws Exception
     {
    	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
 		 AL.Frontdesklogin_11744();
 		 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
 		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
 		 FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_NavigateAdminConsole();
         RoomsLandingPage RLP=BP.roomsPageNavigate();
         RLP.click_AddRoom();
         SaveRoomsPage SRP=new SaveRoomsPage();
         SRP.AddRoomTypeName();
         //RoomsLandingPage RLP=new RoomsLandingPage();
         RLP.fn_NavigateFrontdesk();
 		 GenericMethods.driver.navigate().refresh();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.getCountOfRooms1();
         FLP.WindowScroll();
         FLP.fn_SingleResrvTwoRoomNT();
         FLP.fn_fillAddQuickResrv();
         FLP.fn_verifyReservation();
         System.out.println("TC_33 Executed");
     }


     @Test(priority=4)
     public void TC_34() throws Exception
     {
    	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
 		 AL.Frontdesklogin_11744();
 		 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
 		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
 		 FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_NavigateAdminConsole();
         RoomsLandingPage RLP=BP.roomsPageNavigate();
         RLP.click_AddRoom();
         SaveRoomsPage SRP=new SaveRoomsPage();
         SaveRoomsPage.fn_SaveAndDuplicateMultpl2RM();
         //RoomsLandingPage RLP=new RoomsLandingPage();
         RLP.fn_NavigateFrontdesk();
 		 GenericMethods.driver.navigate().refresh();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_clk2Rooms();
         FLP.WindowScroll();
         FLP.fn_SingleResrvTwoRoomNT();
         FLP.fn_fillAddQuickResrv2RM();
         FLP.fn_verifyReservation();
         System.out.println("TC_34 Executed");
     }


     @Test(priority=5)
     public void TC_35() throws Exception
     {
    	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
 		 AL.Frontdesklogin_11744();
 		 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
 		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
 		 FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_NavigateAdminConsole();
         RoomsLandingPage RLP=BP.roomsPageNavigate();
         RLP.click_AddRoom();
         SaveRoomsPage SRP=new SaveRoomsPage();
         SRP.AddRoomTypeName();
         //RoomsLandingPage RLP=new RoomsLandingPage();
         RLP.fn_NavigateFrontdesk();
 		 GenericMethods.driver.navigate().refresh();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.getCountOfRooms1();
         FLP.WindowScroll();
         FLP.fn_SingleResrvTwoRoomNT();
         EnableEditingPage EEP=FLP.fn_fillAddQuickSingleLnk();
         EEP.fn_verifySingleTab();
         System.out.println("TC_35 Executed");

     }


     @Test(priority=6)
     public void TC_36() throws Exception
     {
    	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
 		 AL.Frontdesklogin_11744();
 		 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
 		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
 		 FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_NavigateAdminConsole();
         RoomsLandingPage RLP=BP.roomsPageNavigate();
         RLP.click_AddRoom();
         SaveRoomsPage SRP=new SaveRoomsPage();
         SRP.AddRoomTypeName();
         //RoomsLandingPage RLP=new RoomsLandingPage();
         RLP.fn_NavigateFrontdesk();
 		 GenericMethods.driver.navigate().refresh();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.getCountOfRooms1();
         FLP.WindowScroll();
         FLP.fn_SingleResrvTwoRoomNT();
         EnableEditingPage EEP=FLP.fn_clkSingleLnk();
         EEP.fn_addGuestDetailSingle();
         FLP.fn_verifyReservation();
         System.out.println("TC_36 Executed");

     }

     @Test(priority=7)
     public void TC_37() throws Exception
     {

    	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
 		 AL.Frontdesklogin_11744();
 		 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
 		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
 		 FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_NavigateAdminConsole();
         RoomsLandingPage RLP=BP.roomsPageNavigate();
         RLP.click_AddRoom();
         SaveRoomsPage SRP=new SaveRoomsPage();
         SaveRoomsPage.fn_SaveAndDuplicateMultpl2RM();
         //RoomsLandingPage RLP=new RoomsLandingPage();
         RLP.fn_NavigateFrontdesk();
 		 GenericMethods.driver.navigate().refresh();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_clk2Rooms();
         FLP.WindowScroll();
         FLP.fn_SingleResrvTwoRoomNT();
         EnableEditingPage EEP=FLP.fn_fillAddQuickGroupLnk();
         EEP.fn_verifyGroupTab();
         System.out.println("TC_37 Executed");
     }


     @Test(priority=8)
     public void TC_38() throws Exception
     {
    	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
 		 AL.Frontdesklogin_11744();
 		 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
 		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
 		 FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_NavigateAdminConsole();
         RoomsLandingPage RLP=BP.roomsPageNavigate();
         RLP.click_AddRoom();
         SaveRoomsPage SRP=new SaveRoomsPage();
         SaveRoomsPage.fn_SaveAndDuplicateMultpl2RM();
         //RoomsLandingPage RLP=new RoomsLandingPage();
         RLP.fn_NavigateFrontdesk();
 		 GenericMethods.driver.navigate().refresh();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_clk2Rooms();
         FLP.WindowScroll();
         FLP.fn_SingleResrvTwoRoomNT();
         EnableEditingPage EEP=FLP.fn_clkGroupLnk();
         EEP.fn_addGuestDetailGroup();
         FLP.fn_verifyReservation();
         System.out.println("TC_38 Executed");

     }

     @Test(priority=9)
     public void TC_37_1() throws Exception
     {
    	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
 		 AL.Frontdesklogin_11744();
 		 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
 		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
 		 FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_NavigateAdminConsole();
         RoomsLandingPage RLP=BP.roomsPageNavigate();
         RLP.click_AddRoom();
         SaveRoomsPage SRP=new SaveRoomsPage();
         SaveRoomsPage.fn_SaveAndDuplicateMultpl2RM();
         //RoomsLandingPage RLP=new RoomsLandingPage();
         RLP.fn_NavigateFrontdesk();
 		 GenericMethods.driver.navigate().refresh();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_clk2Rooms();
         FLP.WindowScroll();
         FLP.fn_SingleResrvTwoRoomNT();
         EnableEditingPage EEP=FLP.fn_fillAddQuickAgntCorpLnk();
         EEP.fn_verifyGroupTab();
         System.out.println("TC_37_1 Executed");
     }


     @Test(priority=10)
     public void TC_39() throws Exception
     {
    	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
 		 AL.Frontdesklogin_11744();
 		 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
 		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
 		 FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_NavigateAdminConsole();
         RoomsLandingPage RLP=BP.roomsPageNavigate();
         RLP.click_AddRoom();
         SaveRoomsPage SRP=new SaveRoomsPage();
         SRP.AddRoomTypeName();
         //RoomsLandingPage RLP=new RoomsLandingPage();
         RLP.fn_NavigateFrontdesk();
 		 GenericMethods.driver.navigate().refresh();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.getCountOfRooms1();
         FLP.WindowScroll();
         FLP.fn_SingleResrvTwoRoomNT();
         EnableEditingPage EEP=FLP.fn_clkAgntCorpLnk();
         EEP.fn_addGuestDetailAgCorp();
         FLP.fn_verifyReservation();
         System.out.println("TC_39 Executed");
     }


     @Test(priority=11)
     public void TC_40() throws Exception
     {
    	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
 		 AL.Frontdesklogin_11744();
 		 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
 		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
 		 FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_NavigateAdminConsole();
         RoomsLandingPage RLP=BP.roomsPageNavigate();
         RLP.click_AddRoom();
         SaveRoomsPage SRP=new SaveRoomsPage();
         SRP.AddRoomTypeName();
         //RoomsLandingPage RLP=new RoomsLandingPage();
         RLP.fn_NavigateFrontdesk();
 		 GenericMethods.driver.navigate().refresh();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.getCountOfRooms1();
         FLP.WindowScroll();
         FLP.fn_SingleResrv_ThreeRoomNT();
         FLP.fn_fillAddQuickSeasonR();
         FLP.fn_verifyReservation();
         System.out.println("TC_40 Executed");
     }



     @Test(priority=12)
     public void TC_41() throws Exception
     {
    	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
 		 AL.Frontdesklogin_11744();
 		 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
 		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
 		 FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         RoomsLandingPage RLP=BP.roomsPageNavigate();
         RLP.click_AddRoom();
         SaveRoomsPage SRP=new SaveRoomsPage();
         SRP.AddRoomTypeName();
         AddonLandingPage AOP=BP.addonsLandingPage();
         AOP.fn_chkInclChocBarPA();
         GenericMethods.driver.navigate().refresh();
         FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.getCountOfRooms1();
         FLP.WindowScroll();
         FLP.fn_SingleResrvTwoRoomNT();
         FLP.fn_fillAddQuickChocBarPA();
         FLP.fn_verifyReservation();
         System.out.println("TC_41 Executed");

     }




     @Test(priority=13)
     public void TC_48() throws Exception
     {
    	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
 		 AL.Frontdesklogin_11744();
 		 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
 		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
 		 FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_NavigateAdminConsole();
         RoomsLandingPage RLP=BP.roomsPageNavigate();
         RLP.click_AddRoom();
         AddRoomsPage SRP=new AddRoomsPage();
        // SRP.AddRoomName();
         //RoomsLandingPage RLP=new RoomsLandingPage();
         RLP.fn_NavigateFrontdesk();
 		 GenericMethods.driver.navigate().refresh();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.getCountOfRooms1();
         FLP.WindowScroll();
         FLP.fn_SingleResrvOneNT();
         FLP.fn_verifyAddQuickResrvTitle();
         //Thread.sleep(20000);
         System.out.println("TC_48 Executed");

     }



     @Test(priority=14)
     public void TC_49() throws Exception
     {
    	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
 		 AL.Frontdesklogin_11744();
 		 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
 		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
 		 FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_NavigateAdminConsole();
         RoomsLandingPage RLP=BP.roomsPageNavigate();
         RLP.click_AddRoom();
         SaveRoomsPage SRP=new SaveRoomsPage();
         SRP.AddRoomTypeName();
         //RoomsLandingPage RLP=new RoomsLandingPage();
         RLP.fn_NavigateFrontdesk();
 		 GenericMethods.driver.navigate().refresh();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.getCountOfRooms1();
         FLP.WindowScroll();
         FLP.fn_SingleResrvOneNT();
         FLP.fn_fillAddQuickRackR();
         FLP.fn_verifyReservation();
         System.out.println("TC_49 Executed");
     }
*/

//
//     @Test(priority=15)
//     public void TC_50() throws Exception
//     {
//    	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
// 		 AL.Frontdesklogin_11744();
// 		 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
// 		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
// 		 FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
// 		 FLP.fn_ClickCancelButton();
//         FLP.fn_clickCurrentLnk();
//         FLP.fn_NavigateAdminConsole();
//         RoomsLandingPage RLP=BP.roomsPageNavigate();
//         RLP.click_AddRoom();
//         AddRoomsPage SRP=new AddRoomsPage();
//         //SRP.AddRoomTypeName();
//         ListofPackagesInPackageMaster LPM=BP.fn_navigatePackageMaster();
//         LPM.viewAll();
//         LPM.fn_chkTaxInclusivePkg();
//         GenericMethods.driver.navigate().refresh();
// 		 FLP.fn_ClickCancelButton();
//         FLP.fn_clickCurrentLnk();
//         FLP.getCountOfRooms1();
//         FLP.WindowScroll();
//         FLP.fn_SingleResrvTwoRoomNT();
//         FLP.fn_fillAddQuickTaxPkg();
//         FLP.fn_verifyReservation();
//         System.out.println("TC_50 Executed");
//     }

/*
     @Test(priority=16)
     public void TC_61() throws Exception
     {
    	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
 		 AL.Frontdesklogin_11744();
 		 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
 		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
 		 FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_NavigateAdminConsole();
         RoomsLandingPage RLP=BP.roomsPageNavigate();
         RLP.click_AddRoom();
         SaveRoomsPage SRP=new SaveRoomsPage();
         SRP.AddRoomTypeName();
         //RoomsLandingPage RLP=new RoomsLandingPage();
         RLP.fn_NavigateFrontdesk();
 		 GenericMethods.driver.navigate().refresh();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.getCountOfRooms1();
         FLP.WindowScroll();
         FLP.fn_SingleResrvTwoRoomNT();
         FLP.fn_fillAddQuickSeasonR();
         FLP.fn_verifyReservation();
         System.out.println("TC_61 Executed");
     }

     @Test(priority=17)
     public void TC_105() throws Exception
     {
    	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
 		 AL.Frontdesklogin_11744();
 		 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
 		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
 		 FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_NavigateAdminConsole();
         RoomsLandingPage RLP=BP.roomsPageNavigate();
         RLP.click_AddRoom();
         SaveRoomsPage SRP=new SaveRoomsPage();
         SRP.AddRoomTypeName();
         //RoomsLandingPage RLP=new RoomsLandingPage();
         RLP.fn_NavigateFrontdesk();
 		 GenericMethods.driver.navigate().refresh();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.getCountOfRooms1();
         FLP.WindowScroll();
         FLP.fn_SingleResrv_FourNT();
         FLP.fn_verifyAddQuickResrvTitle();
         System.out.println("TC_105 Executed");
     }


     @Test(priority=18)
     public void TC_106() throws Exception
     {
    	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
 		 AL.Frontdesklogin_11744();
 		 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
 		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
 		 FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_NavigateAdminConsole();
         RoomsLandingPage RLP=BP.roomsPageNavigate();
         RLP.click_AddRoom();
         SaveRoomsPage SRP=new SaveRoomsPage();
         //RoomsLandingPage RLP=SRP.fn_SaveAndDuplicateMultpl3RM();
         RLP.fn_NavigateFrontdesk();
 		 GenericMethods.driver.navigate().refresh();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_clk3Rooms();
         FLP.WindowScroll();
         FLP.fn_SingleResrv_FourNT();
         FLP.fn_fillAddQuickResrv3RM();
         FLP.fn_verifyReservation();
         System.out.println("TC_106 Executed");

     }

     @Test(priority=19)
     public void TC_107() throws Exception
     {
    	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
 		 AL.Frontdesklogin_11744();
 		 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
 		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
 		 FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_NavigateAdminConsole();
         RoomsLandingPage RLP=BP.roomsPageNavigate();
         RLP.click_AddRoom();
         SaveRoomsPage SRP=new SaveRoomsPage();
         //RoomsLandingPage RLP=SRP.fn_SaveAndDuplicateMultpl3RM();
         RLP.fn_NavigateFrontdesk();
 		 GenericMethods.driver.navigate().refresh();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_clk3Rooms();
         FLP.WindowScroll();
         FLP.fn_SingleResrv_FourNT();
         FLP.fn_fillAddQuick3RMSeasonR();
         FLP.fn_verifyReservation();
         System.out.println("TC_107 Executed");

     }


     @Test(priority=20)
     public void TC_108() throws Exception
     {
    	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
 		 AL.Frontdesklogin_11744();
 		 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
 		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
 		 FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_NavigateAdminConsole();
         RoomsLandingPage RLP=BP.roomsPageNavigate();
         RLP.click_AddRoom();
         SaveRoomsPage SRP=new SaveRoomsPage();
         SRP.fn_SaveAndDuplicateMultpl2RM();
         ListofPackagesInPackageMaster LPM=BP.fn_navigatePackageMaster();
         LPM.viewAll();
         LPM.fn_chkInclChocBarPkg();
         GenericMethods.driver.navigate().refresh();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_clk2Rooms();
         FLP.WindowScroll();
         FLP.fn_SingleResrvOneNT();
         FLP.fn_fillAddQuickChocBarPkg();
         FLP.fn_verifyReservation();
         System.out.println("TC_108 Executed");
     }


     @Test(priority=21)
     public void TC_109() throws Exception
     {
    	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
 		 AL.Frontdesklogin_11744();
 		 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
 		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
 		 FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_NavigateAdminConsole();
         RoomsLandingPage RLP=BP.roomsPageNavigate();
         RLP.click_AddRoom();
         SaveRoomsPage SRP=new SaveRoomsPage();
         SRP.fn_SaveAndDuplicateMultpl2RM();
         AddonLandingPage AOP=BP.addonsLandingPage();
         AOP.fn_chkInclChocBarPA();
         GenericMethods.driver.navigate().refresh();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_clk2Rooms();
         FLP.WindowScroll();
         FLP.fn_SingleResrvOneNT();
         FLP.fn_fillAddQuickChocBarPA();
         String a=GenericMethods.GetCurrentWindowID();
         CheckinCard CC=FLP.fn_verifyReservAndCheckin();
         GenericMethods.windowHandle(a);
         Thread.sleep(5000);
         CC.fn_clkCloseBtn();
         Thread.sleep(3000);
         GenericMethods.Switch_Parent_Window(a);
         System.out.println("TC_109 Executed");

     }


     @Test(priority=22)
     public void TC_110() throws Exception
     {
    	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
 		 AL.Frontdesklogin_11744();
 		 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
 		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
 		 FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_NavigateAdminConsole();
         RoomsLandingPage RLP=BP.roomsPageNavigate();
         RLP.click_AddRoom();
         SaveRoomsPage SRP=new SaveRoomsPage();
         SRP.fn_SaveAndDuplicateMultpl2RM();
         AddonLandingPage AOP=BP.addonsLandingPage();
         AOP.fn_chkInclChocBarPA();
         GenericMethods.driver.navigate().refresh();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_clk2Rooms();
         FLP.WindowScroll();
         FLP.fn_SingleResrvOneNT();
         FLP.fn_fillAddQuickChocBarPA();
         String a=GenericMethods.GetCurrentWindowID();
         CheckinCard CC=FLP.fn_verifyReservAndCheckin();
         GenericMethods.windowHandle(a);
         Thread.sleep(5000);
         CC.fn_getIDRoomNum();
         Thread.sleep(3000);
         GenericMethods.Switch_Parent_Window(a);
         String b=GenericMethods.GetCurrentWindowID();
         SampleRestaurantPage SP=FLP.ClickToSampleRestaurant();
         GenericMethods.windowHandle(b);
         Thread.sleep(10000);
         ConfirmOrderPage COP=SP.fn_selectChocBar();
         ConfirmOrderPage1 COP1=COP.ConfirmOrder();
         OrderFolioPage OFP=COP1.fn_selectRoomGrp();
         OFP.CloseTransaction();
         GenericMethods.Switch_Parent_Window(b);
         ReservationSearchResultLandingPage RSP=FLP.fn_SearchByReservationID(CC.ID);
         ViewDetailsPage VDP=RSP.fn_ClickOnSearchedRecord();
         AccountStatementLandingPage ASP=VDP.ClickToPayment();
         ASP.VerifyTransferedItem(OFP.folioId,OFP.folioTax);
         System.out.println("TC_110 Executed");
     }


     @Test(priority=23)
     public void TC_111() throws Exception
     {
    	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
 		 AL.Frontdesklogin_11744();
 		 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
 		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
 		 FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_NavigateAdminConsole();
         RoomsLandingPage RLP=BP.roomsPageNavigate();
         RLP.click_AddRoom();
         SaveRoomsPage SRP=new SaveRoomsPage();
         SRP.fn_SaveAndDuplicateMultpl2RM();
         AddonLandingPage AOP=BP.addonsLandingPage();
         AOP.fn_chkInclChocBarPA();
         GenericMethods.driver.navigate().refresh();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_clk2Rooms();
         FLP.WindowScroll();
         FLP.fn_SingleResrvOneNT();
         FLP.fn_fillAddQuickChocBarPA();
         String a=GenericMethods.GetCurrentWindowID();
         CheckinCard CC=FLP.fn_verifyReservAndCheckin();
         GenericMethods.windowHandle(a);
         Thread.sleep(5000);
         CC.fn_getIDRoomNum();
         Thread.sleep(3000);
         GenericMethods.Switch_Parent_Window(a);
         String b=GenericMethods.GetCurrentWindowID();
         SampleRestaurantPage SP=FLP.ClickToSampleRestaurant();
         GenericMethods.windowHandle(b);
         Thread.sleep(10000);
         ConfirmOrderPage COP=SP.fn_selectChocBar();
         ConfirmOrderPage1 COP1=COP.ConfirmOrder();
         OrderFolioPage OFP=COP1.fn_selectRoomGrp();
         OFP.CloseTransaction();
         GenericMethods.Switch_Parent_Window(b);
         ReservationSearchResultLandingPage RSP=FLP.fn_SearchByReservationID(CC.ID);
         ViewDetailsPage VDP=RSP.fn_ClickOnSearchedRecord();
         AccountStatementLandingPage ASP=VDP.ClickToPayment();
         ASP.fn_clkConsolidateBtn();
         GenericMethods.driver.navigate().refresh();
         Thread.sleep(9000);
         FLP.fn_verifyNightAuditAlert();
         System.out.println("TC_111 Executed");
     }


     @Test(priority=24)
     public void TC_112() throws Exception
     {
    	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
 		 AL.Frontdesklogin_11744();
 		 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
 		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
 		 FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_NavigateAdminConsole();
         RoomsLandingPage RLP=BP.roomsPageNavigate();
         RLP.click_AddRoom();
         SaveRoomsPage SRP=new SaveRoomsPage();
         SRP.fn_SaveAndDuplicateMultpl2RM();
         AddonLandingPage AOP=BP.addonsLandingPage();
         AOP.fn_chkInclChocBarPA();
         GenericMethods.driver.navigate().refresh();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_clk2Rooms();
         FLP.WindowScroll();
         FLP.fn_SingleResrvOneNT();
         FLP.fn_fillAddQuickChocBarPA();
         String a=GenericMethods.GetCurrentWindowID();
         CheckinCard CC=FLP.fn_verifyReservAndCheckin();
         GenericMethods.windowHandle(a);
         Thread.sleep(5000);
         CC.fn_getIDRoomNum();
         Thread.sleep(3000);
         GenericMethods.Switch_Parent_Window(a);
         String b=GenericMethods.GetCurrentWindowID();
         SampleRestaurantPage SP=FLP.ClickToSampleRestaurant();
         GenericMethods.windowHandle(b);
         Thread.sleep(10000);
         ConfirmOrderPage COP=SP.fn_selectChocBar();
         ConfirmOrderPage1 COP1=COP.ConfirmOrder();
         OrderFolioPage OFP=COP1.fn_selectRoomGrp();
         OFP.CloseTransaction();
         GenericMethods.Switch_Parent_Window(b);
         ReservationSearchResultLandingPage RSP=FLP.fn_SearchByReservationID(CC.ID);
         ViewDetailsPage VDP=RSP.fn_ClickOnSearchedRecord();
         AccountStatementLandingPage ASP=VDP.ClickToPayment();
         ASP.fn_clkConsolidateBtn();
         GenericMethods.driver.navigate().refresh();
         Thread.sleep(9000);
         NightAuditLandingPage NAP=FLP.fn_AutoNightAudit();
//         NAP.fn_ContinueNightAudit();
//         Thread.sleep(5000);
//         FLP.fn_ClickCancelButton();
         System.out.println("TC_112 Executed");
     }



     @Test(priority=25)
     public void TC_113() throws Exception
     {
    	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
 		 AL.Frontdesklogin_11744();
 		 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
 		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
 		 FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_NavigateAdminConsole();
         RoomsLandingPage RLP=BP.roomsPageNavigate();
         RLP.click_AddRoom();
         SaveRoomsPage SRP=new SaveRoomsPage();
         SRP.fn_SaveAndDuplicateMultpl2RM();
         AddonLandingPage AOP=BP.addonsLandingPage();
         AOP.fn_chkInclChocBarPA();
         GenericMethods.driver.navigate().refresh();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_clk2Rooms();
         FLP.WindowScroll();
         FLP.fn_SingleResrvOneNT();
         FLP.fn_fillAddQuickChocBarPA();
         String a=GenericMethods.GetCurrentWindowID();
         CheckinCard CC=FLP.fn_verifyReservAndCheckin();
         GenericMethods.windowHandle(a);
         Thread.sleep(5000);
         CC.fn_getIDRoomNum();
         Thread.sleep(3000);
         GenericMethods.Switch_Parent_Window(a);
         String b=GenericMethods.GetCurrentWindowID();
         SampleRestaurantPage SP=FLP.ClickToSampleRestaurant();
         GenericMethods.windowHandle(b);
         Thread.sleep(10000);
         ConfirmOrderPage COP=SP.fn_selectChocBar();
         ConfirmOrderPage1 COP1=COP.ConfirmOrder();
         OrderFolioPage OFP=COP1.fn_selectRoomGrp();
         OFP.CloseTransaction();
         GenericMethods.Switch_Parent_Window(b);
         ReservationSearchResultLandingPage RSP=FLP.fn_SearchByReservationID(CC.ID);
         ViewDetailsPage VDP=RSP.fn_ClickOnSearchedRecord();
         AccountStatementLandingPage ASP=VDP.ClickToPayment();
         ASP.fn_clkConsolidateBtn();
         GenericMethods.driver.navigate().refresh();
         Thread.sleep(9000);
         NightAuditLandingPage NAP=FLP.fn_AutoNightAudit();
         FLP.fn_SearchByReservationID(CC.ID);
         RSP.fn_ClickOnSearchedRecord();
         VDP.ClickToPayment();
         ASP.VerifyPaymentPage();
         System.out.println("TC_113 Executed");

     }



     @Test(priority=26)
     public void TC_114() throws Exception
     {
    	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
 		 AL.Frontdesklogin_11744();
 		 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
 		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
 		 FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_NavigateAdminConsole();
         RoomsLandingPage RLP=BP.roomsPageNavigate();
         SaveRoomsPage SRP=new SaveRoomsPage();
         SRP.fn_SaveAndDuplicateMultpl2RM();
         ListofPackagesInPackageMaster LPM=BP.fn_navigatePackageMaster();
         LPM.fn_chkWeeklyRatePkg();
         GenericMethods.driver.navigate().refresh();
 		 FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
         FLP.fn_clk2Rooms();
         FLP.WindowScroll();
         FLP.fn_SingleResrvTwoRoomNT();
         FLP.fn_fillAddQuickResrvWeekPkg();
         String a=GenericMethods.GetCurrentWindowID();
         CheckinCard CC=FLP.fn_verifyReservAndCheckin();
         GenericMethods.windowHandle(a);
         Thread.sleep(5000);
         CC.fn_clkCloseBtn();
         Thread.sleep(3000);
         GenericMethods.Switch_Parent_Window(a);
         System.out.println("TC_114 Executed");



     }
*/
//     public void TC_32() throws Exception
//     {
//    	 FrontdeskLoginPage AL=new FrontdeskLoginPage();
// 		 AL.Frontdesklogin_11744();
// 		 FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
// 		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
// 		 FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
// 		 FLP.fn_ClickCancelButton();
//         FLP.fn_clickCurrentLnk();
//         FLP.fn_NavigateAdminConsole();
//         RoomsLandingPage RLP= BP.roomsPageNavigate();
//         RLP.click_AddRoom();
//         AddRoomsPage SRP=new AddRoomsPage();
//        // SRP.AddRoomTypeName();
//         //RoomsLandingPage RLP=new RoomsLandingPage();
//         RLP.fn_NavigateFrontdesk();
// 		 GenericMethods.driver.navigate().refresh();
// 		 FLP.fn_ClickCancelButton();
//         FLP.fn_clickCurrentLnk();
//         FLP.getCountOfRooms1();
//         FLP.WindowScroll();
//         FLP.fn_SingleResrvTwoRoomNT();
//         //FLP.fn_fillAddQuickResrv();
//         FLP.fn_verifyAddQuickResrvTitle();
//         //Thread.sleep(20000);
//         System.out.println("TC_32 Executed");
//
//     }	

@AfterMethod
	public void closeApp() throws Exception
	{
		 //GenericMethods.driver.close();

			try{

		        Thread.sleep(2800);
				GenericMethods.driver.quit();
		}catch(Exception e){
			Thread.sleep(2000);
			System.out.println("Came in catch block of quit");

			try{
				Thread.sleep(2000);
			GenericMethods.driver.quit();
			}catch(Exception e1){
				Thread.sleep(3000);
				System.out.println("Again came in catch block of quit");
				GenericMethods.driver.quit();
			}
		}
	}



}

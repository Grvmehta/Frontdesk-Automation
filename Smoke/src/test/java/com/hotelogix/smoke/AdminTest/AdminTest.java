package com.hotelogix.smoke.AdminTest;

import java.util.ArrayList;
import java.util.List;



import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.hotelogix.smoke.admin.BaseClass.AdmineHome;
import com.hotelogix.smoke.admin.CompanyInfo.HotelInformationPage;
import com.hotelogix.smoke.admin.Console.AddEditCorporate;
import com.hotelogix.smoke.admin.Console.AddTravelAgentPage;
import com.hotelogix.smoke.admin.Console.ListOfRegisteredCorporateLP;
import com.hotelogix.smoke.admin.Console.ListOfRegisteredTravelAgentLP;
import com.hotelogix.smoke.admin.Console.RegisteredTravelAgentPage;
import com.hotelogix.smoke.admin.General.AddBookingPolicyPage;
import com.hotelogix.smoke.admin.General.AddEditPayType;
import com.hotelogix.smoke.admin.General.BookingPolicyPage;
import com.hotelogix.smoke.admin.General.DefaultSettingLandingPage;
import com.hotelogix.smoke.admin.General.PayTypesPage;
import com.hotelogix.smoke.admin.PosManager.AddEditPOSCategory;
import com.hotelogix.smoke.admin.PosManager.AddEditPOSPoint;
import com.hotelogix.smoke.admin.PosManager.AddPOSProduct;
import com.hotelogix.smoke.admin.PosManager.AddPOSTax;
import com.hotelogix.smoke.admin.PosManager.POSCategories;
import com.hotelogix.smoke.admin.PosManager.POSPointsLandingPage;
import com.hotelogix.smoke.admin.PosManager.POSProductsList;
import com.hotelogix.smoke.admin.PosManager.POSTaxListPage;
import com.hotelogix.smoke.admin.PriceManager.AddActivationDate;
import com.hotelogix.smoke.admin.PriceManager.AddActivationDateCR;
import com.hotelogix.smoke.admin.PriceManager.AddActivationDateFD;
import com.hotelogix.smoke.admin.PriceManager.AddActivationDateTA;
import com.hotelogix.smoke.admin.PriceManager.AddActivationDateWeb;
import com.hotelogix.smoke.admin.PriceManager.AddEditGroupPage;
import com.hotelogix.smoke.admin.PriceManager.AddEditGroupTaxPage;
import com.hotelogix.smoke.admin.PriceManager.AddEditPackage;
import com.hotelogix.smoke.admin.PriceManager.AddEditPackagePage;
import com.hotelogix.smoke.admin.PriceManager.AddMoreInclusions;
import com.hotelogix.smoke.admin.PriceManager.AddSeasonPage;
import com.hotelogix.smoke.admin.PriceManager.AddSpecialPeriodPage;
import com.hotelogix.smoke.admin.PriceManager.AddonLandingPage;
import com.hotelogix.smoke.admin.PriceManager.AttachPackagePage;
import com.hotelogix.smoke.admin.PriceManager.AttachPackagePage1;
import com.hotelogix.smoke.admin.PriceManager.AttachPackagesPage;
import com.hotelogix.smoke.admin.PriceManager.CenteralizePackageLandingPage;
import com.hotelogix.smoke.admin.PriceManager.DefinePackageCentralizedRate;
import com.hotelogix.smoke.admin.PriceManager.EditPackageDetail;
import com.hotelogix.smoke.admin.PriceManager.FrontDeskPackageDetailPage;
import com.hotelogix.smoke.admin.PriceManager.FrontdeskPackagesListPage;
import com.hotelogix.smoke.admin.PriceManager.GroupBookingSource;
import com.hotelogix.smoke.admin.PriceManager.GroupTaxListPage;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackageCentralizedRate;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesCorporate;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesCorporate1;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesFrontdesk;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesPage;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesTravelAgent;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesTravelAgent1;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesWeb;
import com.hotelogix.smoke.admin.PriceManager.ListofPackagesInPackageMaster;
import com.hotelogix.smoke.admin.PriceManager.ManageSource;
import com.hotelogix.smoke.admin.PriceManager.PackageDetailsCentralisedRate;
import com.hotelogix.smoke.admin.PriceManager.PackageDetailsFrontDesk;
import com.hotelogix.smoke.admin.PriceManager.PackageDetailsTravelAgent;
import com.hotelogix.smoke.admin.PriceManager.PackageDetailsWeb;
import com.hotelogix.smoke.admin.PriceManager.RoomPricesLandingPage;
import com.hotelogix.smoke.admin.PriceManager.SaveAddonsPage;
import com.hotelogix.smoke.admin.PriceManager.SeasonsLandingPage;
import com.hotelogix.smoke.admin.PriceManager.SpecialPeriodLandingPage;
import com.hotelogix.smoke.admin.PriceManager.TravelAgentPackagesLandingPage;
import com.hotelogix.smoke.admin.PriceManager.attachPackages;
import com.hotelogix.smoke.admin.Report.NightAuditPage;
import com.hotelogix.smoke.admin.Report.NightAuditReportPage;
import com.hotelogix.smoke.admin.UserManager.AddEditUser;
import com.hotelogix.smoke.admin.UserManager.AddEditUserLevelPage;
import com.hotelogix.smoke.admin.UserManager.SetReportPermission;
import com.hotelogix.smoke.admin.UserManager.UsersLevelList;
import com.hotelogix.smoke.admin.UserManager.UsersListLandingPage;
import com.hotelogix.smoke.admin.WebManager.WebReservationSettingPage;
import com.hotelogix.smoke.admin.WebTravelAgent.TAReservationHomePage;
import com.hotelogix.smoke.admin.WebTravelAgent.TASelectRoomPage;
import com.hotelogix.smoke.admin.WebTravelAgent.TravleAgent_LoginPage;
//import com.hotelogix.smoke.admin.WebTravelAgent.WebReservationHomePageTA;
import com.hotelogix.smoke.admin.roommanager.AddEditAmenity;
import com.hotelogix.smoke.admin.roommanager.AmenitiesLandingPage;
import com.hotelogix.smoke.admin.roommanager.RoomTaxesLandingPage;
import com.hotelogix.smoke.admin.roommanager.RoomTypesLandingPage;
import com.hotelogix.smoke.admin.roommanager.RoomsLandingPage;
import com.hotelogix.smoke.admin.roommanager.SaveRoomTaxesPage;
import com.hotelogix.smoke.admin.roommanager.SaveRoomTypesPage;
import com.hotelogix.smoke.admin.roommanager.AddRoomsPage;
import com.hotelogix.smoke.emailaccount.EmailHomePage;
import com.hotelogix.smoke.frontdesk.WebReservation.WebAddMoreRoomPage;
import com.hotelogix.smoke.frontdesk.WebReservation.WebReservationHomePage;
import com.hotelogix.smoke.frontdesk.WebReservation.WebSelectRoomPage;
import com.hotelogix.smoke.genericandbase.BasePage;
import com.hotelogix.smoke.genericandbase.GenericMethods;
import com.hotelogix.smoke.login.AdminLoginPage;
import com.hotelogix.smoke.login.EmailAccountLoginPage;


public class AdminTest {


    private static BasePage BP;



@BeforeMethod
public void Login() throws Exception
{

	try{
	//AdminLoginPage AL = GenericMethods.fn_OpenAdmin("FF", "http://hotelogix.stayezee.com/admine/login/login/");
	AdminLoginPage AL = GenericMethods.fn_OpenAdmin("FF", "http://hotelogix.net/admine/login/login/");
	//AdminLoginPage AL = GenericMethods.fn_OpenAdmin("FF", "https://hotelogix.staygrid.com/admine/login/login/");
    BP=AL.adminlogin_20819();

    AdmineHome.bResult = true;
	}catch(Exception e){
        Thread.sleep(1000);
		System.out.println("System is showing problem during login");
		//AdminLoginPage AL = GenericMethods.fn_OpenAdmin("FF", "http://hotelogix.stayezee.com/admine/login/login/");
		//AdminLoginPage AL = GenericMethods.fn_OpenAdmin("FF", "https://hotelogix.staygrid.com/admine/login/login/");
		AdminLoginPage AL = GenericMethods.fn_OpenAdmin("FF", "http://hotelogix.net/admine/login/login/");
		BP=AL.adminlogin_20819();

	}

Thread.sleep(2000);
}

//static int reTryCount=0;

/*
//TC_01 User should be logged into Admine Console
@Test(priority=1)
public void TC_01() throws Exception
{
	   try
	   {
	   BP.verify_PageTitle();
	   //..Log Message
	   Reporter.log("User gets redirected to homepage of Admine Console after login.",true);
	   
	   System.out.println("TC_01 Executed");
	    
	   //BaseClass.bResult = true;

	   }

       catch(Exception e)
	   {
    	   e.getMessage();
	   }


}


    //TC_02   User should be directed to the 'Amenities List' page.
	//TC_03 Save Amenity
	@Test(priority=2)
	public void TC_02_03() throws Exception
	{
		try
		{
		AmenitiesLandingPage ALP=BP.amenitiesPageNevigation();
		ALP.verify_pageTitle();
		AddEditAmenity AEA=ALP.addAmenity();
		AEA.save_amenity();
		ALP.verify_savedmsg();
		ALP.verify_amenity();
		//..Navigates to RoomTypesLandingPage to check for added amenity
		RoomTypesLandingPage RTLP=BP.roomTypesNavigate();
		SaveRoomTypesPage SRTP=RTLP.clickEdit();
		SRTP.chkamenity();
		//..Log Message
		
		Reporter.log("Added amenity gets displayed on 'Amenities List' page and is also displayed on 'Add a Room Type' page under 'Select Amenities' >> 'Available Amenities'",true);
		
		System.out.println("TC_02_03 Executed");
		}
		 catch(Exception e)
		   {
	    	   e.getMessage();
		   }

}

	//TC_04  User should be directed to 'Rooms List' page. 
	//TC_05 Save Rooms
	@Test(priority=3)
	public void TC_04_05() throws Exception
	{
		try
		{
		RoomsLandingPage RLP=BP.roomsPageNavigate();
		String str=GenericMethods.driver.getTitle();
		Assert.assertEquals(str, "Room List");
		SaveRoomsPage SRP=RLP.click_AddRoom();		
		SRP.saveRooms();
		RLP.verify_savedroom();
		//..Log Message
		Reporter.log("Added Room is displayed on 'Rooms List' page with sattus as active(green tick)",true);
		System.out.println("TC_04_05 Executed");
		}
		 catch(Exception e)
		   {
	    	   e.getMessage();
		   }

}






	//TC_06: Save and Duplicate Room
	@Test(priority=4)
	public void TC_06() throws Exception
	{
		try
		{
		RoomsLandingPage RLP=BP.roomsPageNavigate();
		SaveRoomsPage SRP=RLP.click_AddRoom();
		SRP.saveAndDuplicate();
		RLP.verifyroom_savedupl();
		//..Log Message
		Reporter.log("On clicking 'Save and Duplicate' button on 'Add/Edit a Room',all the rooms of the same room type are displayed in ",true);
		System.out.println("TC_06 Executed");
		}
		 catch(Exception e)
		   {
	    	   e.getMessage();
		   }

	}


	//TC_07: Navigate to Room Tax Page
	//TC_08: Save Room Taxes
	//TC_09: User should be directed to 'Rooms Types List' page.
	//TC_10: Taxes should be attached to the Room Type and saved successfully.
	@Test(priority=5)
	public void TC_07_08_09_10() throws Exception
	{
		try
		{
		RoomTaxesLandingPage RTLP=BP.roomTaxPageNavigate();
		Assert.assertEquals(GenericMethods.driver.getTitle(), "Room Tax List");
		SaveRoomTaxesPage SRTP=RTLP.clickAddRoomTaxes();
		SRTP.saveRoomTaxes();
		String str=RTLP.verify_roomtax();
		Assert.assertEquals(str.contains(SaveRoomTaxesPage.taxName), true);
		RTLP.chk_taxstatus();
		RoomTypesLandingPage RLP=BP.roomTypesNavigate();
		Assert.assertEquals(GenericMethods.driver.getTitle(), "Room Type List");
		SaveRoomTypesPage SRP=RLP.addroomtax();
		SRP.verify_roomtax();
		SRP.fn_clkRoomTypeList();
		RLP.clickEdit();
		//SRP.clickCheckBox();
		SRP.saveRoomType();
		Thread.sleep(9000);
		RLP.verify_roomtype();
		
		System.out.println("TC_07_08_09_10 Executed");
		}
		 catch(Exception e)
		   {
	    	   e.getMessage();
		   }

	}
	
	    //TC_11 User should be directed to 'Add-Ons List' page.
		//TC_12: The Add-Ons should be saved successfully.
		@Test(priority=6)
		public void TC_11_12() throws Exception
		{
			try
			{
			
			AddonLandingPage AOLP=BP.addonsLandingPage();
			Assert.assertEquals(GenericMethods.driver.getTitle(), "Add-ons List");
			SaveAddonsPage SAP=AOLP.clickAddAddons();
			SAP.saveAddon();
			String msg=AOLP.verify_saveMsg();
			Assert.assertEquals(msg.contains(SAP.AddonName),true);
			AOLP.viewAll();
			AOLP.verify_savedAddOn();
			ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
			AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
			String a=GenericMethods.GetCurrentWindowID();
			AddMoreInclusions AMI=AEP.checkadded_addon();
			GenericMethods.windowHandle(a);
			AMI.search_addon();
			GenericMethods.driver.close();
			GenericMethods.Switch_Parent_Window(a);
			
			System.out.println("TC_11_12 Executed");
			}
			 catch(Exception e)
			   {
		    	   e.getMessage();
			   }
		}

		
		
   @Test(priority=7)
   public void TC_13_14_15() throws Exception
   {
	   try
	   {
		ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
		Assert.assertEquals(GenericMethods.driver.getTitle(), "List of Packages");
		AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
		AEP.fillPkgDetails("1");
	    AddEditPackage.edit_defaultrate();
	    String a=GenericMethods.GetCurrentWindowID();
	    AEP.checkadded_addon();
	    GenericMethods.windowHandle(a);
	    Assert.assertEquals(GenericMethods.driver.getTitle(), "Add Inclusions");
	    AddMoreInclusions.select_inclusion();
	    GenericMethods.Switch_Parent_Window(a);
	    AddEditPackage.verify_addedIncl();
	    AEP.clickOnSave();
	    ListofPackagesInPackageMaster.viewAll();
	    ListofPackagesInPackageMaster.verifysavedpkg();
	    ListOfPackagesFrontdesk LOPF=BP.fn_navigateFrontDskPkg();
	    String b = GenericMethods.GetCurrentWindowID();
	    LOPF.attachPackage();
	    GenericMethods.windowHandle(b);
	    attachPackages.search_pkg();
	    GenericMethods.Switch_Parent_Window(b);
	    BP.fn_navigateWebPkg();
	    String c = GenericMethods.GetCurrentWindowID();
	    ListOfPackagesWeb.attachPackage();
	    GenericMethods.windowHandle(c);
	    attachPackages.search_pkg();
	    GenericMethods.Switch_Parent_Window(c);
	    BasePage.fn_navigateCorporatePkg();
	    ListOfPackagesCorporate.click_addviewpkg();
	    String d = GenericMethods.GetCurrentWindowID();
	    ListOfPackagesCorporate1.click_attackPkgbtn();
	    GenericMethods.windowHandle(d);
	    attachPackages.search_pkg();
	    GenericMethods.Switch_Parent_Window(d);
	    BasePage.fn_navigatePriceManagerTAP1();
	    ListOfPackagesTravelAgent.click_addviewpkg();
	    String e = GenericMethods.GetCurrentWindowID();
	    ListOfPackagesTravelAgent1.click_attackPkgbtn();
	    GenericMethods.windowHandle(e);
	    attachPackages.search_pkg();
	    GenericMethods.Switch_Parent_Window(e);
	    BP.fn_navigateFrontDskPkg();
	    System.out.println("TC_13_14_15 Executed");
	   }
	   catch(Exception e)
	   {
    	   e.getMessage();
	   }
   }




 @Test(priority=8)
 public void TC_16_17_18_19_20_21() throws Exception
 {
	 try
	 {
		 
	  ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();	 
	  AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
	  AEP.fillPkgDetails("1");
	  AEP.clickOnSave();
	  ListOfPackagesFrontdesk LOPF=BP.fn_navigateFrontDskPkg();
      Assert.assertEquals(GenericMethods.driver.getTitle(), "List of Packages (Frontdesk)");
     // ListOfPackagesFrontdesk.viewAll();
	 // ListOfPackagesFrontdesk.getPkgID1();
	  String a=GenericMethods.GetCurrentWindowID();
	  attachPackages AP=LOPF.attachPackage();
	  GenericMethods.windowHandle(a);
	  Assert.assertEquals(GenericMethods.driver.getTitle(), "Attach Package");
	  String PName=AP.getPkgName1(AddEditPackage.pkgName);
	  GenericMethods.Switch_Parent_Window(a);
	  String text=LOPF.verify_pkgSavedMsg();
	  Assert.assertEquals(text, "- Package(s) attached successfully");
	  LOPF.viewAll();
	  //ListOfPackagesFrontdesk.getPkgID2();
	  LOPF.verify_savedPkg();
	  PackageDetailsFrontDesk PDF=LOPF.confgr_attachedPkgFD();
	  PDF.clickOnSave_BT();
	  LOPF.viewAll();
	  String b=GenericMethods.GetCurrentWindowID();
	  ListOfPackagesFrontdesk.verifyAddActivationDate_linkFD();
	  AddActivationDateFD AADF=LOPF.AddActivationDateFD_click1();
	  GenericMethods.windowHandle(b);
	  AADF.activateForeverPackateFD();
	  GenericMethods.Switch_Parent_Window(b);
	  Thread.sleep(3000);
	  ListOfPackagesFrontdesk.verifyActivatedForeverFD_text();
	  
	  System.out.println("TC_16_17_18_19_20_21 Executed");
	 }
	 catch(Exception e)
	   {
  	   e.getMessage();
	   }
 }




@Test(priority=9)
public void TC_22_23_24_25_26_27() throws Exception
{

try
{

	 ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();	 
	 AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
	 AEP.fillPkgDetails("1");
	 AEP.clickOnSave();
	 ListOfPackagesWeb LOPW=BP.fn_navigateWebPkg();
	 Assert.assertEquals(GenericMethods.driver.getTitle(), "List of Packages (Web)");
	// LOPW.view_All();
	// ListOfPackagesWeb.getPkgID1();
	 String windowID=GenericMethods.GetCurrentWindowID();
	 attachPackages AP=LOPW.attachPackage();
     GenericMethods.windowHandle(windowID);
     Assert.assertEquals(GenericMethods.driver.getTitle(), "Attach Package");
     AP.getPkgName1(AddEditPackage.pkgName);
	 GenericMethods.Switch_Parent_Window(windowID);
	 String text=LOPW.verify_pageMsg();
	 Assert.assertEquals(text, "- Package(s) attached successfully");
	 LOPW.view_All();
	 //ListOfPackagesWeb.getPkgID2();
	 LOPW.verifyPackage_name();
	 PackageDetailsWeb PDW=LOPW.confgr_attachedPkgWeb();
	 PDW.clickOnSave_BT();
	 Thread.sleep(3000);
	// LOPW.view_All();
	 LOPW.verifyAddActivationDate_linkWeb();
	 String a=GenericMethods.GetCurrentWindowID();
	 AddActivationDateWeb AADW=LOPW.NavTo_ActivationDateWeb();
     GenericMethods.windowHandle(a);
     Thread.sleep(2000);
	 AADW.activateForeverPackateWeb();
	 GenericMethods.Switch_Parent_Window(a);
	 Thread.sleep(3000);
	 LOPW.verifyActivatedForever_textWeb();
	 
	 System.out.println("TC_22_23_24_25_26_27 Executed");
}
catch(Exception e)
{
  e.getMessage();
}
}



 @Test(priority=10)
 public void TC_28_29_30_31_32() throws Exception
 {
	 try
	 {
		 ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();	 
		 AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
		 AEP.fillPkgDetails("1");
		 AEP.clickOnSave();
		 ListOfPackagesFrontdesk LOPF=BP.fn_navigateFrontDskPkg();		 
		  //LOPF.viewAll();
		// LOPF.getPkgID1();
	     String windowID=GenericMethods.GetCurrentWindowID();
	     attachPackages AP=LOPF.attachPackage();
         GenericMethods.windowHandle(windowID);
         AP.getPkgName1(AddEditPackage.pkgName);
	     GenericMethods.Switch_Parent_Window(windowID);
	     LOPF.viewAll();
	     // LOPF.getPkgID2();
	     //LOPF.verify_savedPkg();
	     PackageDetailsFrontDesk PDF= LOPF.confgr_attachedPkgFD();
	     PDF.clickOnSave_BT();
	     //LOPF.viewAll();
	     String a=GenericMethods.GetCurrentWindowID();
	     AddActivationDateFD AADF=LOPF.AddActivationDateFD_click1();
         GenericMethods.windowHandle(a);
         AADF.activateForeverPackateFD();
	     GenericMethods.Switch_Parent_Window(a);
	     Thread.sleep(2000);
	     //LOPF.viewAll();
	     LOPF.click_EditLink();
	     Assert.assertEquals(GenericMethods.driver.getTitle(), "Edit Package Details (Frontdesk)");
         String msg1=PDF.accept_ToGrid();
         Assert.assertEquals(msg1, PackageDetailsFrontDesk.exp_msg);
         PDF.verify_savemsg();
	     String msg2=PDF.accept_SaveGrid();
	     Assert.assertEquals(msg2, PackageDetailsFrontDesk.Grid_msg);
	     PDF.clk_PkgFrontdeskLnk();
	     //LOPF.viewAll();
	     LOPF.verify_GridPkg();
	     System.out.println("TC_28_29_30_31_32 Executed");
	 }
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
 }


 
@Test(priority=11)
public void TC_33_34_35_36_37() throws Exception
{
	try
	{
	
	 ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();	 
	 AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
	 AEP.fillPkgDetails("1");
	 AEP.clickOnSave();
	 ListOfPackagesWeb LOPW=BP.fn_navigateWebPkg();
	 //LOPW.view_All();
	// ListOfPackagesWeb.getPkgID1();
	 String windowID=GenericMethods.GetCurrentWindowID();
	 attachPackages AP=LOPW.attachPackage();
     GenericMethods.windowHandle(windowID);
	 AP.getPkgName1(AddEditPackage.pkgName);
	 GenericMethods.Switch_Parent_Window(windowID);
	 LOPW.view_All();
	 //ListOfPackagesWeb.getPkgID2();
	 PackageDetailsWeb PDW=LOPW.confgr_attachedPkgWeb();
	 PDW.clickOnSave_BT();
	// LOPW.view_All();
	 String a=GenericMethods.GetCurrentWindowID();
	 AddActivationDateWeb AADW=LOPW.NavTo_ActivationDateWeb();
     GenericMethods.windowHandle(a);
     AADW.activateForeverPackateWeb();
	 GenericMethods.Switch_Parent_Window(a);
	 //LOPW.view_All();
	 LOPW.click_EditLinkWebPkg();
	 Assert.assertEquals(GenericMethods.driver.getTitle(), "Edit Package Details (Web)");
	 String msg1=PDW.accept_ToGridWeb();
	 Assert.assertEquals(msg1, PackageDetailsWeb.exp_msgWeb);
	 PDW.verify_savemsgWeb();
	 String msg2=PDW.accept_SaveGridWeb();
	 Assert.assertEquals(msg2, PackageDetailsWeb.Grid_msgWeb);
	 PDW.clk_PkgWebLink();
	 //LOPW.view_All();
	 LOPW.verify_GridPkgWeb();
	 
	 System.out.println("TC_33_34_35_36_37 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
}


 @Test(priority=12)
 public void TC_38_39_40_41_42() throws Exception
 {
	 try
	 {
	   DefaultSettingLandingPage DSP= BP.fn_DefaultSettingsNavigate();
	   Assert.assertEquals(GenericMethods.driver.getTitle(), "Edit Default Setting");
	   DSP.change_nightAudit();
	   DSP.change_checkinTime();
	   DSP.change_checkoutTime();
	   DSP.change_earlyCheckoutCharge();
	   DSP.fn_verifyEarlyChkoutCharge();
	   DSP.verify_pgeMsg();
	   System.out.println("TC_38_39_40_41_42 Executed");
	 }
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
 }



  @Test(priority=13)
  public void TC_43_44() throws Exception
  {
	  try
	  {
 	 PayTypesPage PTP= BP.fn_NavigatePayTypes();
 	 Assert.assertEquals(GenericMethods.driver.getTitle(), "Pay Types");
     AddEditPayType APT= PTP.fn_clkAddPayType();
     APT.fn_addPayTypeDetail();
     PTP.fn_verifySaveMsg();
     PTP.view_all();
     PTP.fn_verifyAddedPayType();
     System.out.println("TC_43_44 Executed");
	  }
		 catch(Exception e)
	   {
 	   e.getMessage();
	   }
  }



	@Test(priority=14)
	public void TC_45_46() throws Exception
	{
		try
		{
		BookingPolicyPage BPPA = BP.fn_NavigateBookingPolicy();
		String ParentID=GenericMethods.GetCurrentWindowID();
		AddBookingPolicyPage ABPP=BPPA.add_booking_policy();
		GenericMethods.windowHandle_admin(ParentID);
		AddBookingPolicyPage.fn_addBookingPolicy();
		//String a=ABPP.fn_addBookPoli_Det();
		ABPP.Booking_Policy_Save();
		GenericMethods.Switch_Parent_Window(ParentID);
		BPPA.fn_verifyBookingP();

  	    Reporter.log("After entering all mandatory details of Booking Policy, when user clicks on Save button Booking policy is saved Successfully",true);


		System.out.println("TC_45_46 Executed");
		}
		 catch(Exception e)
		   {
	  	   e.getMessage();
		   }
	}

	
    @Test(priority=15)
	public void TC_47_48_49() throws Exception
	{
	  try
	  {
	    SeasonsLandingPage SELP=BP.fn_NavigateSeasons();
	    Assert.assertEquals(GenericMethods.driver.getTitle(), "Season List");
	    String a=GenericMethods.GetCurrentWindowID();
		AddSeasonPage ASP=SELP.Add_Season();
		GenericMethods.windowHandle_admin(a);
		Assert.assertEquals(GenericMethods.driver.getTitle(), "Add a Season");
		ASP.fn_EnterMandatoryFields();
		//ASP.Seasons_save();
		GenericMethods.Switch_Parent_Window(a);
		Thread.sleep(3000);
		SELP.fn_verifySeasonLP();
        SELP.fn_deleteSeason();
        SELP.fn_clkDeleteSeasonBtn();
        
		Reporter.log("Added Season saved and appeared successfully in Seasons list as well as gets reflected in Room Prices(only if Room Prices is switched to seasons)",true);

		System.out.println("TC_47_48_49 Executed");
	  }
		 catch(Exception e)
	   {
 	   e.getMessage();
	   }
	}


	@Test(priority=15)
	public void TC_50_51_52() throws Exception
	{
		try
		{
		SpecialPeriodLandingPage SPLP=BP.fn_NavigatePriceManagerSP();
		Assert.assertEquals(GenericMethods.driver.getTitle(), "Special Period List");
		String ParentID=GenericMethods.GetCurrentWindowID();
	    AddSpecialPeriodPage ASPP=SPLP.add_special_period();
		GenericMethods.windowHandle_admin(ParentID);
		Assert.assertEquals(GenericMethods.driver.getTitle(),"Add Special Period");
		ASPP.fn_SPMandatory();
		GenericMethods.Switch_Parent_Window(ParentID);
		Thread.sleep(3000);
		SPLP.fn_viewAll();
		SPLP.fn_verifySpecialP();
        SPLP.fn_selectSP();
        SPLP.fn_clkDeleteSP();
        
		Reporter.log("Added Special Period gets saved successfully with 'Active' status in 'Special Period List' page and gets reflected in 'Room Prices List' page(only if Room Price is switched to season mode)",true);

		System.out.println("TC_50_51_52 Executed");
		}
		 catch(Exception e)
		   {
	  	   e.getMessage();
		   }
	}


	@Test(priority=16)
	public void TC_53_54_55_56() throws Exception
	{
		try
		{
		RoomPricesLandingPage RPLP=BP.fn_navigatePriceManagerRP();
		Assert.assertEquals(GenericMethods.driver.getTitle(), "Room Prices List");
		String abcd=RPLP.SpecialPeriod_Price();
		RPLP.fn_saveSPPrice();
		Assert.assertEquals(abcd, RoomPricesLandingPage.SBOP.getAttribute("value"));		
		String price=RPLP.lastminrate();
		RPLP.lastmin_save();
		Assert.assertEquals(price, RoomPricesLandingPage.LMBase.getAttribute("value"));
		String webprice=RPLP.webrate();
		RPLP.webrate_save();
        Assert.assertEquals(webprice, RoomPricesLandingPage.WRBase.getAttribute("value"));
		
		Reporter.log("When Seasons/Special Period price,Last Min Rate and Web Rate is changed for a room type and floppy sign corresponding to that room type is clicked, prices for that room type gets saved successfully.",true);

		System.out.println("TC-53_54_55_56 Executed");
		}
		 catch(Exception e)
		   {
	  	   e.getMessage();
		   }
	}



	@Test(priority=17)
    public void TC_57_58() throws Exception
	{
		try
		{
		POSTaxListPage PTL=BP.fn_navigatePOSManagerPT();
		Assert.assertEquals(GenericMethods.driver.getTitle(), "POS Tax List");
		AddPOSTax APT=PTL.AddTax();
		APT.AddPTax();
		POSTaxListPage POTLP=APT.SaveTax();
		POTLP.fn_verifyPOST();
        POSPointsLandingPage PPL=BP.fn_navigatePOSManagerPP();
        AddEditPOSPoint AEPP=PPL.AddEditPOSPoint();
        AEPP.fn_verifyPOSTax();
        
        
		Reporter.log("Added POS Tax gets saved successfully in 'POS Tax List' with status as 'Active' as well as gets reflected in 'Add/Edit POS Point' page.",true);

		System.out.println("TC-57_58 Executed");
		}
		 catch(Exception e)
		   {
	  	   e.getMessage();
		   }
	}



    @Test(priority=18)
	public void TC_59_60() throws Exception
	{
	  try
	  {
  	    POSPointsLandingPage PPLP=BP.fn_navigatePOSManagerPP();
  	    Assert.assertEquals(GenericMethods.driver.getTitle(), "POS Point");
		AddEditPOSPoint APPP=PPLP.AddEditPOSPoint();
		APPP.fillDetails();
		APPP.clk_saveBtn();
		String text=PPLP.verify_PgeMsg();
		Assert.assertEquals(text, "POS Point "+'`'+AddEditPOSPoint.POSPointName+'`'+" saved successfully");
		PPLP.view_all();
		PPLP.verify_POSPoint();

		Reporter.log("Added POS Point gets saved suucessfully in 'POS Points List' with Active status.",true);

		System.out.println("TC-59_60 Executed");
	  }
	  catch(Exception e)
	   {
 	   e.getMessage();
	   }
	}

	
	@Test(priority=19)
    public void TC_61_62_63() throws Exception
  {
        try
        {
		POSPointsLandingPage PPL=BP.fn_navigatePOSManagerPP();
		AddEditPOSPoint AEPP=PPL.AddEditPOSPoint();
		AEPP.fillDetails();
	    AEPP.clk_saveBtn();
	    PPL.view_all();
	    PPL.clickOnSpecificEdit(AddEditPOSPoint.POSPointName);
	    AEPP.clk_ProductRequiredChkbox();
	    Thread.sleep(1000);
	    AEPP.clk_saveBtn();
	    Thread.sleep(3000);
	    PPL.verify_AddNewPdtLnk();
	    AddEditPOSCategory AEPC=PPL.clk_AddNewCategory(AddEditPOSPoint.POSPointName);
	    POSCategories POSC=AEPC.fn_addPOSCategory();
	    POSC.fn_viewAll();
	    POSC.verify_addedPOSCategory();
	    Thread.sleep(3000);
	    POSC.clk_lnkPOSPoint();
	    AddPOSProduct APP=PPL.clk_addNewPOSPdtLnk();
	    List<String> ar=APP.verifyPOSCategory();
	    Assert.assertEquals(ar.contains(AddEditPOSCategory.name), true);
	    POSProductsList POPL=APP.fn_addPOSProduct();
	    POPL.verify_addedPOSProduct();
	    
	    System.out.println("TC_61_62_63 Executed");
        }
        catch(Exception e)
		   {
	  	   e.getMessage();
		   }
	}



@Test(priority=20)
public void TC_64_65() throws Exception
{
	try
	{
	HotelInformationPage HP=BP.fn_navigateCompanyInfo();
	Assert.assertEquals(GenericMethods.driver.getTitle(), "Hotel Information");
	HP.fn_EnterHotelInformation("*\\Images\\download (5).jpg");
	HP.fn_verifyHotelSave();
	
	System.out.println("TC-64_65 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
}




	@Test(priority=21)
    public void TC_66_67() throws Exception
	{
		try
		{
		UsersLevelList ULL=BP.fn_navigateUserManager_UserLevels();
		Assert.assertEquals(GenericMethods.driver.getTitle(), "User Levels List");
		AddEditUserLevelPage AULP=ULL.AddNew_UserLevel();
		String abc= AULP.fn_EnterUserLevel();
		AULP.UserLevel_SaveChanges();
		ULL.verify_UserLevel();
		UsersListLandingPage ULLP=BP.fn_navigateUserManager_UsersList();
		AddEditUser AEU=ULLP.fn_navigateToAddEditUser();
		List<String> l1=AEU.verify_UserLevel();
		Assert.assertEquals(l1.contains(abc), true);
		
		System.out.println("TC-66_67 Executed");
		}
		 catch(Exception e)
		   {
	  	   e.getMessage();
		   }
	}


        @Test(priority=22)
	    public void TC_68_69_70() throws Exception
	    {
    	  try
    	  {
    	   UsersListLandingPage ULP=BP.fn_navigateUserManager_UsersList();
		   Assert.assertEquals(GenericMethods.driver.getTitle(), "Users List");
		  AddEditUser AEU=ULP.fn_navigateToAddEditUser();
		  AEU.fillUserDetails();
		  String a=GenericMethods.GetCurrentWindowID();
		  SetReportPermission SRP=AEU.fn_NavigateSetReportPermsn();
		  GenericMethods.windowHandle(a);
		  Thread.sleep(5000);
		  String title=SRP.verifyPage();
		  Assert.assertEquals(title, "Set Report Permission");
		  SRP.selectAllReport();
		  Thread.sleep(4000);
		  GenericMethods.Switch_Parent_Window(a);
		  AEU.clickOnSave_BT();
		  ULP.view_all();
		  ULP.fn_verifyAddedUser(AddEditUser.userFname);
		  
		  System.out.println("TC-68_69_70 Executed");
    	  }
    	  catch(Exception e)
		   {
	  	   e.getMessage();
		   }
	    }


		@Test(priority=23)
		public void TC_71_72() throws Exception
		{
			try
			{
				ListOfRegisteredCorporateLP LORC=BP.fn_navigateToRegCorporateConsole();
				Assert.assertEquals(GenericMethods.driver.getTitle(), "List of Registered Corporate");
				AddEditCorporate AEC=LORC.fn_NavigateToAddEditCorporate();
		        AEC.fn_fillForm();
		        LORC.view_all();
		        LORC.fn_verifyRegCorporate();
		        
		        System.out.println("TC-71_72 Executed");
		}
			 catch(Exception e)
			   {
		  	   e.getMessage();
			   }
		}



@Test(priority=24)
public void TC_73_74() throws Exception
{
    try
    {
	ListOfRegisteredTravelAgentLP LTA=BP.fn_NavigateRegisteredTravelAgent();
	Assert.assertEquals(GenericMethods.driver.getTitle(), "List of Registered Travel Agent");
    AddTravelAgentPage ATA=LTA.AddTravelAgent_Btn();
    ATA.AddTravelAgent();
    LTA.view_all();
    LTA.fn_verifyRegisteredTA();
    
	System.out.println("TC-73_74 Executed");
    }
	 catch(Exception e)
	   {
	   e.getMessage();
	   }
}


@Test(priority=25)
public void TC_75_76_77() throws Exception
{
	try
	{
	NightAuditReportPage NAR=BP.fn_NavigateNightAuditReport();
	Assert.assertEquals(GenericMethods.driver.getTitle(), "Night Audit Report");
	NightAuditPage NA=NAR.ViewReport_link();
	NA.VerifyHeaders();
	NA.DownloadNightAuditReportFile();
	
	System.out.println("TC-75_76_77 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }

}


@Test(priority=26)
public void TC_78_79() throws Exception
{
	try
	{
		WebReservationSettingPage WRS=BP.fn_NavigateWebSetting();
		Assert.assertEquals(GenericMethods.driver.getTitle(), "Web Reservation Settings");
		String txt=WRS.VerifySavedSettings();
		Assert.assertEquals(txt, "Web Reservation Settings Saved Successfully");
		
		System.out.println("TC-78_79 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }

}



@Test(priority=27)
public void TC_80_81_82_83_84_85() throws Exception
{


try
{
  ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();	 
  AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
  AEP.fillPkgDetails("1");
  AEP.clickOnSave();
  ListOfPackageCentralizedRate LCP=BP.fn_NavigatePriceManager();
  Assert.assertEquals(GenericMethods.driver.getTitle(), "List of Packages (Centralized Rate)");
  //LCP.view();
 //LCP.getPkgID1();
  String a=GenericMethods.GetCurrentWindowID();
  attachPackages AP=LCP.attachPackage();
  GenericMethods.windowHandle(a);
  Thread.sleep(3000);
  Assert.assertEquals(GenericMethods.driver.getTitle(), "Attach Package");
  AP.selectPkgForCentralisedRate(AddEditPackage.pkgName);
  GenericMethods.Switch_Parent_Window(a);
  String txt=LCP.verify_pkgSavedMsg();
  Assert.assertEquals(txt, "- Package(s) attached successfully");
  LCP.view();
 //LCP.getPkgID2();
  LCP.verifyPackage_name();
  PackageDetailsCentralisedRate PDCR=LCP.confgr_attachedPkgCR();
  PDCR.clickOnSave();
 //LCP.view();
  String b=GenericMethods.GetCurrentWindowID();
  LCP.verifyAddActivationDate_linkCR();
  AddActivationDateCR AADC=LCP.NavTo_ActivationDateCR();
  GenericMethods.windowHandle(b);
  AADC.activateForeverPackateCR();
  Thread.sleep(2000);
  GenericMethods.Switch_Parent_Window(b);
// LCP.view();
  LCP.verifyActivatedForever_textCR();
 
  System.out.println("TC-80_81_82_83_84_85 Executed");
}
catch(Exception e)
{
e.getMessage();
}

}
*/


//@Test(priority=28)
public void TC_86_87_88_89_90_91()
{
	
}


/*
@Test(priority=29)
public void TC_92_93() throws Exception
{
        try
        {
		GroupTaxListPage GTL=BP.fn_NavigateGroupTax();
		Assert.assertEquals(GenericMethods.driver.getTitle(), "List Of Group Tax");
	    AddEditGroupTaxPage AEGT=GTL.AddGroupTax_Btn();
	    AEGT.AddingGroupTax();
	    GTL.fn_viewAll();
	    GTL.verify_savedGroupTax();
	    
	    System.out.println("TC-92_93 Executed");
        }
   	 catch(Exception e)
 	   {
 	   e.getMessage();
 	   }

}




@Test(priority=30)
public void TC_94_95_96() throws Exception
{
	try
	{
		ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
		AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
        AEP.makePackage("2");
        LOPM.viewAll();
        LOPM.verifysavedpkg();
        Thread.sleep(2000);
        ListOfPackagesFrontdesk LOPF=BP.fn_navigateFrontDskPkg();
        String a=GenericMethods.GetCurrentWindowID();
        attachPackages AP= LOPF.attachPackage();
        Thread.sleep(2000);
        GenericMethods.windowHandle(a);
        AP.selectPkgForFD(AddEditPackage.pkgName);
        GenericMethods.Switch_Parent_Window(a);
        LOPF.viewAll();
        PackageDetailsFrontDesk PDF=LOPF.confgr_attachedPkgFD();
        PDF.selectInclusiveTax();
        PDF.clickOnSave_BT();
        String b=GenericMethods.GetCurrentWindowID();
        AddActivationDateFD AAD=LOPF.AddActivationDateFD_click1();
        GenericMethods.windowHandle(b);
        AAD.activateForeverPackateFD();
        GenericMethods.Switch_Parent_Window(b);
        Thread.sleep(3000);
        LOPF.verifyActivatedForeverFD_text();
        
        System.out.println("TC-94_95_96 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }

   }




@Test(priority=31)
public void TC_97_98_99() throws Exception
{
	try
	{
		ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
		AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
		AEP.makePackage( "3");
		LOPM.viewAll();
        LOPM.verifysavedpkg();
        ListOfPackagesFrontdesk LOPF=BP.fn_navigateFrontDskPkg();
        String a=GenericMethods.GetCurrentWindowID();
        attachPackages AP= LOPF.attachPackage();
        Thread.sleep(2000);
        GenericMethods.windowHandle(a);
        AP.selectPkgForFD(AddEditPackage.pkgName);
        GenericMethods.Switch_Parent_Window(a);
        LOPF.viewAll();
        PackageDetailsFrontDesk PDF=LOPF.confgr_attachedPkgFD();
        PDF.changeRatesToPost("Week");
        PDF.clickOnSave_BT();
        LOPF.verifyAddActivationDate_linkFD();
        String b=GenericMethods.GetCurrentWindowID();
        AddActivationDateFD AAD= LOPF.AddActivationDateFD_click1();
        GenericMethods.windowHandle(b);
        Thread.sleep(2000);
        AAD.activateForeverPackateFD();
        GenericMethods.Switch_Parent_Window(b);
        Thread.sleep(2000);
        LOPF.verifyActivatedForeverFD_text();
        
        System.out.println("TC-97_98_99 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }

}



@Test(priority=32)
public void TC_100() throws Exception
{
	try

	{
		ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
		AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
		AEP.makePackage( "1");
		ListOfPackageCentralizedRate LCR=BP.fn_navigateCentralisedRate();
		String a=GenericMethods.GetCurrentWindowID();
		attachPackages AP= LCR.attachPackage();
		GenericMethods.windowHandle(a);
		AP.fn_selectPkgCR();
		GenericMethods.Switch_Parent_Window(a);
		LCR.view();
		PackageDetailsCentralisedRate PCR=LCR.confgr_attachedPkgCR();
		PCR.clickOnSave();
		String b=GenericMethods.GetCurrentWindowID();
		Thread.sleep(4000);
		AddActivationDateCR AAC=LCR.NavTo_ActivationDateCR();
		GenericMethods.windowHandle(b);
		Thread.sleep(4000);
		AAC.activateForeverPackateCR();
		GenericMethods.Switch_Parent_Window(b);
		Thread.sleep(3000);
		ListOfPackagesWeb LOPW=BP.fn_navigateWebPkg();
        String c=GenericMethods.GetCurrentWindowID();
        LOPW.attachPackage();
        GenericMethods.windowHandle(c);
        Thread.sleep(4000);
        AP.selectPkg_WEBfrmCR("Centralized Rate");
        GenericMethods.Switch_Parent_Window(a);
        Thread.sleep(4000);
        LOPW.view_All();
        LOPW.verifyCRPackage_name();
        Thread.sleep(3000);
        PackageDetailsWeb PDW=LOPW.confgr_CRattachedPkgWeb();
        PDW.clickOnSave_BT();
        String d=GenericMethods.GetCurrentWindowID();
        AddActivationDateWeb AAW=LOPW.NavTo_CRActivationDateWeb();
        GenericMethods.windowHandle(d);
        Thread.sleep(4000);
        AAW.activateForeverPackateWeb();
        GenericMethods.Switch_Parent_Window(d);
        Thread.sleep(3000);
        LOPW.CRverifyActivatedForever_textWeb();
        
        
        System.out.println("TC_100 Executed");

	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }

}




@Test(priority=33)
public void TC_101_102() throws Exception
{
	try
	{
		ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
		AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
		AEP.makePackage( "1");
		Thread.sleep(2000);
		ListOfPackageCentralizedRate LCR=BP.fn_navigateCentralisedRate();
		String a=GenericMethods.GetCurrentWindowID();
		attachPackages AP= LCR.attachPackage();
		GenericMethods.windowHandle(a);
		AP.fn_selectPkgCR();
		GenericMethods.Switch_Parent_Window(a);
		LCR.view();
		PackageDetailsCentralisedRate PCR=LCR.confgr_attachedPkgCR();
		PCR.clickOnSave();
		String b=GenericMethods.GetCurrentWindowID();
		Thread.sleep(4000);
		AddActivationDateCR AAC=LCR.NavTo_ActivationDateCR();
		GenericMethods.windowHandle(b);
		Thread.sleep(4000);
		AAC.activateForeverPackateCR();
		GenericMethods.Switch_Parent_Window(b);
		Thread.sleep(3000);
		TravelAgentPackagesLandingPage TALP=BP.fn_navigatePriceManagerTAP();
		ListOfPackagesTravelAgent1 LTA1=TALP.fn_NavigateTopackageListpageForTA();
		LTA1.view_All();
		String c=GenericMethods.GetCurrentWindowID();
		LTA1.click_attackPkgbtn();
		GenericMethods.windowHandle(c);
		Thread.sleep(4000);
		AP.selectPkg_TAfrmCR(AddEditPackage.pkgName);
		GenericMethods.Switch_Parent_Window(c);
		LTA1.verifyPkg_Relational();
		PackageDetailsTravelAgent PTA=LTA1.confgr_CRattachedPkgTA();
		PTA.clickOnSave_BT();
		String d=GenericMethods.GetCurrentWindowID();
		AddActivationDateTA AAD=LTA1.NavTo_ActivationDateTAfrmCR();
		GenericMethods.windowHandle(d);
		Thread.sleep(4000);
		AAD.activateForeverPackageTA();
		GenericMethods.Switch_Parent_Window(d);
		LTA1.verifyActivatedForever_textTAfrmCR();
		
        System.out.println("TC-101_102 Executed");
	}
	 catch(Exception e)
	   {
	   e.getMessage();
	   }

}


	    @Test(priority=34)
		public void TC_103_104_105_106_107() throws Exception
		{
		   try
		   {
			  
			    ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
				AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
				AEP.makePackage( "1");
				Thread.sleep(2000);
				ListOfPackageCentralizedRate LCR=BP.fn_navigateCentralisedRate();
				String a=GenericMethods.GetCurrentWindowID();
				attachPackages AP= LCR.attachPackage();
				GenericMethods.windowHandle(a);
				AP.fn_selectPkgCR();
				GenericMethods.Switch_Parent_Window(a);
				LCR.view();
				PackageDetailsCentralisedRate PCR=LCR.confgr_attachedPkgCR();
				PCR.getPkgName();
				PCR.clickOnView();
				String name=PCR.getRoomTypeName();
				String pkgPrice=PCR.getPackagePrice(name);				
				PCR.clickOnSave();
				String b=GenericMethods.GetCurrentWindowID();
				Thread.sleep(4000);
				AddActivationDateCR AAC=LCR.NavTo_ActivationDateCR();
				GenericMethods.windowHandle(b);
				Thread.sleep(4000);
				AAC.activateForeverPackateCR();
				GenericMethods.Switch_Parent_Window(b);
				Thread.sleep(6000);
				ListOfRegisteredTravelAgentLP RTA=BP.fn_navigateTravalAgentConsole();
			    AddTravelAgentPage ATA=RTA.AddTravelAgent_Btn();	    
			    String mailId=ATA.fn_fillTADetails();
			    ATA.clk_saveBtn();
			    Thread.sleep(4000);
			    RTA.fn_verifyRegisteredTA();
				TravelAgentPackagesLandingPage TALP=BP.fn_navigatePriceManagerTAP();
				ListOfPackagesTravelAgent1 LTA1=TALP.clkAddViewPkg_specificTA(AddTravelAgentPage.TaName);
				LTA1.view_All();
				String c=GenericMethods.GetCurrentWindowID();
				LTA1.click_attackPkgbtn();
				GenericMethods.windowHandle(c);
				Thread.sleep(4000);
				AP.selectPkg_TAfrmCR(AddEditPackage.pkgName);
				GenericMethods.Switch_Parent_Window(c);
				PackageDetailsTravelAgent PTA=LTA1.confgr_CRattachedPkgTA();
				PTA.clickOnSave_BT();
				String d=GenericMethods.GetCurrentWindowID();
				AddActivationDateTA AAD=LTA1.NavTo_ActivationDateTAfrmCR();
				GenericMethods.windowHandle(d);
				Thread.sleep(4000);
				AAD.activateForeverPackageTA();
				GenericMethods.Switch_Parent_Window(d);	
				BP.fn_navigateTravalAgentConsole();
		        RTA.fn_sendEmail();		    
    	    	
		        EmailAccountLoginPage EAL=GenericMethods.fn_OpenEmailBox("FF", "http://mail.stayezee.com/squirrelmail/src/login.php");
    		    Thread.sleep(2000);
    		
    		    EmailHomePage EHP=EAL.DoSquirrelMailLogin();
    	        Thread.sleep(2000);

    		
    	        EHP.GetAccountDetailsForGuest("SampleTestHotel", "Travel Agent Account Details");
                Thread.sleep(2000);
                ArrayList<String> al1=EHP.fn_getTALogin();
                TravleAgent_LoginPage TAL=GenericMethods.fn_OpenTAGuestConsolePage("FF", al1.get(0).toString());
                String txt=TAL.verify_pageHeader();
                Assert.assertEquals(txt, "Travel Agent Login");
                TAReservationHomePage TARP=TAL.DoLogin(al1.get(1).toString(),al1.get(2).toString(), al1.get(3).toString());
                String header1=TARP.verify_pageHeader();
                Assert.assertEquals(header1, "Stay Details");
                TASelectRoomPage TASP=TARP.fn_CheckAvability();
                String e=TASP.verify_pageHeader();
                Assert.assertEquals(e, "Select Rooms/Packages");
                TASP.packagePriceVerify(name, pkgPrice);
                
                
                System.out.println("TC-103_104_105_106_107 Executed");
		   }
			 catch(Exception e)
		   {
		   e.getMessage();
		   }

		}



        @Test(priority=35)
        public void TC_108_109_110() throws Exception
        {
          try
           {
        	ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
        	AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
    		AEP.makePackage("1");
    		Thread.sleep(2000);
    		ListOfPackageCentralizedRate LCR=BP.fn_navigateCentralisedRate();
    		String a=GenericMethods.GetCurrentWindowID();
    		attachPackages AP=LCR.attachPackage();
    		GenericMethods.windowHandle(a);
    		AP.fn_selectPkgCR();
    		GenericMethods.Switch_Parent_Window(a);
    		LCR.view();
    		PackageDetailsCentralisedRate PDC=LCR.confgr_attachedPkgCR();
		    PDC.getPkgName();
		    PDC.clickOnView();
			String name=PDC.getRoomTypeName();
			String pkgPrice=PDC.getPackagePrice(name);
			PDC.clickOnSave();
    		String b=GenericMethods.GetCurrentWindowID();
    		AddActivationDateCR AADC=LCR.NavTo_ActivationDateCR();
    		GenericMethods.windowHandle(b);
    		AADC.activateForeverPackateCR();
    		GenericMethods.Switch_Parent_Window(b);
    		Thread.sleep(4000);
    		ListOfPackagesWeb LOPW=BP.fn_navigateWebPkg();
            String c=GenericMethods.GetCurrentWindowID();
            LOPW.attachPackage();
            GenericMethods.windowHandle(c);
            Thread.sleep(4000);
            AP.selectPkg_WEBfrmCR("Centralized Rate");
            GenericMethods.Switch_Parent_Window(a);
            Thread.sleep(4000);
            LOPW.view_All();
            LOPW.verifyCRPackage_name();
            Thread.sleep(3000);
            PackageDetailsWeb PDW=LOPW.confgr_CRattachedPkgWeb();
            PDW.clickOnSave_BT();
            String d=GenericMethods.GetCurrentWindowID();
            AddActivationDateWeb AAW=LOPW.NavTo_CRActivationDateWeb();
            GenericMethods.windowHandle(d);
            Thread.sleep(4000);
            AAW.activateForeverPackateWeb();
            GenericMethods.Switch_Parent_Window(d);
            Thread.sleep(5000);
            LOPW.CRverifyActivatedForever_textWeb();
            WebReservationSettingPage WRSP=BP.fn_navigateWebSetting();
			WebReservationHomePage WRHP=WRSP.launchSecureCanvasURL();
			String txt=WRHP.fn_ValidateStaydetailsPage();
			Assert.assertEquals(txt.equals("Stay Details"), true);
			WebSelectRoomPage WSRP=WRHP.fn_CheckAvability();
			String header=WSRP.fn_ValidateRoomPackagesSection();
			Assert.assertEquals(header.equals("Select Rooms/Packages"), true);
			WSRP.packagePriceVerify(name, pkgPrice);
									
		    System.out.println("TC-108_109_110 Executed");
        }
   	 catch(Exception e)
 	   {
 	   e.getMessage();
 	   }

	}



		 @Test(priority=36)
		 public static void TC_111_112() throws Exception
		 {  
			 try{
				    ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
				    AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
				    AEP.makePackage( "1");
					ListOfPackageCentralizedRate LCR=BP.fn_navigateCentralisedRate();
					String a=GenericMethods.GetCurrentWindowID();
					attachPackages AP= LCR.attachPackage();
					GenericMethods.windowHandle(a);
					AP.fn_selectPkgCR();
					GenericMethods.Switch_Parent_Window(a);
					LCR.view();
		    		PackageDetailsCentralisedRate PDC=LCR.confgr_attachedPkgCR();
				    PDC.getPkgName();
				    PDC.clickOnView();
					String name=PDC.getRoomTypeName();
			        String price=PDC.fn_alterPkgPrice(name, "10500");
			        Thread.sleep(4000);
			        PDC.clickOnSave();
           		    Thread.sleep(3000);
					String b=GenericMethods.GetCurrentWindowID();
					AddActivationDateCR AADC=LCR.NavTo_ActivationDateCR();
		    		GenericMethods.windowHandle(b);
		    		AADC.activateForeverPackateCR();
		    		GenericMethods.Switch_Parent_Window(b);
		    		Thread.sleep(4000);
		    		ListOfPackagesWeb LOPW=BP.fn_navigateWebPkg();
		            String c=GenericMethods.GetCurrentWindowID();
		            LOPW.attachPackage();
		            GenericMethods.windowHandle(c);
		            Thread.sleep(4000);
		            AP.selectPkg_WEBfrmCR("Centralized Rate");
		            GenericMethods.Switch_Parent_Window(a);
		            Thread.sleep(4000);
		            LOPW.view_All();
		            LOPW.verifyCRPackage_name();
		            Thread.sleep(3000);
		            PackageDetailsWeb PDW=LOPW.confgr_CRattachedPkgWeb();
		            PDW.clickOnSave_BT();
		            String d=GenericMethods.GetCurrentWindowID();
		            AddActivationDateWeb AAW=LOPW.NavTo_CRActivationDateWeb();
		            GenericMethods.windowHandle(d);
		            Thread.sleep(4000);
		            AAW.activateForeverPackateWeb();
		            GenericMethods.Switch_Parent_Window(d);
		            Thread.sleep(5000);
		            WebReservationSettingPage WRSP=BP.fn_navigateWebSetting();
					WebReservationHomePage WRHP=WRSP.launchSecureCanvasURL();
					String txt=WRHP.fn_ValidateStaydetailsPage();
					Assert.assertEquals(txt.equals("Stay Details"), true);
					WebSelectRoomPage WSRP=WRHP.fn_CheckAvability();
					String header=WSRP.fn_ValidateRoomPackagesSection();
					Assert.assertEquals(header.equals("Select Rooms/Packages"), true);
					WSRP.packagePriceVerify(name, price);
					
					
				System.out.println("TC-111_112 Executed");
			 }

			 catch(Exception e)
			   {
			   e.getMessage();
			   }

	 }

		 
		 
	  	@Test(priority=37)

		 public static void TC_113() throws Exception
		 {
			 

			try{


				ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
			    AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
			    AEP.makePackage( "1");
				ListOfPackageCentralizedRate LCR=BP.fn_navigateCentralisedRate();
				String a=GenericMethods.GetCurrentWindowID();
				attachPackages AP= LCR.attachPackage();
				GenericMethods.windowHandle(a);
				AP.fn_selectPkgCR();
				GenericMethods.Switch_Parent_Window(a);
				LCR.view();
	    		PackageDetailsCentralisedRate PDC=LCR.confgr_attachedPkgCR();
			    PDC.getPkgName();
			    PDC.clickOnView();
				String name=PDC.getRoomTypeName();
		        String price=PDC.fn_alterPkgPrice(name, "10500");
		        Thread.sleep(4000);
		        PDC.clickOnSave();
       		    Thread.sleep(3000);
				String b=GenericMethods.GetCurrentWindowID();
				AddActivationDateCR AADC=LCR.NavTo_ActivationDateCR();
	    		GenericMethods.windowHandle(b);
	    		AADC.activateForeverPackateCR();
	    		GenericMethods.Switch_Parent_Window(b);
	    		Thread.sleep(4000);
	    		ListOfRegisteredTravelAgentLP RTA=BP.fn_navigateTravalAgentConsole();
			    AddTravelAgentPage ATA=RTA.AddTravelAgent_Btn();	    
			    String mailId=ATA.fn_fillTADetails();
			    ATA.clk_saveBtn();
			    Thread.sleep(4000);
				TravelAgentPackagesLandingPage TALP=BP.fn_navigatePriceManagerTAP();
				ListOfPackagesTravelAgent1 LTA1=TALP.clkAddViewPkg_specificTA(AddTravelAgentPage.TaName);
				LTA1.view_All();
				String c=GenericMethods.GetCurrentWindowID();
				LTA1.click_attackPkgbtn();
				GenericMethods.windowHandle(c);
				Thread.sleep(4000);
				AP.selectPkg_TAfrmCR(AddEditPackage.pkgName);
				GenericMethods.Switch_Parent_Window(c);
				PackageDetailsTravelAgent PTA=LTA1.confgr_CRattachedPkgTA();
				PTA.clickOnSave_BT();
				String d=GenericMethods.GetCurrentWindowID();
				AddActivationDateTA AAD=LTA1.NavTo_ActivationDateTAfrmCR();
				GenericMethods.windowHandle(d);
				Thread.sleep(4000);
				AAD.activateForeverPackageTA();
				GenericMethods.Switch_Parent_Window(d);	
				BP.fn_navigateTravalAgentConsole();
		        RTA.fn_sendEmail();		    
    	    	
		        EmailAccountLoginPage EAL=GenericMethods.fn_OpenEmailBox("FF", "http://mail.stayezee.com/squirrelmail/src/login.php");
    		    Thread.sleep(2000);
    		
    		    EmailHomePage EHP=EAL.DoSquirrelMailLogin();
    	        Thread.sleep(2000);
   		
    	        EHP.GetAccountDetailsForGuest("SampleTestHotel", "Travel Agent Account Details");
                Thread.sleep(2000);
                ArrayList<String> al1=EHP.fn_getTALogin();
                TravleAgent_LoginPage TAL=GenericMethods.fn_OpenTAGuestConsolePage("FF", al1.get(0).toString());              
                TAReservationHomePage TARP=TAL.DoLogin(al1.get(1).toString(),al1.get(2).toString(), al1.get(3).toString());
                TASelectRoomPage TASP=TARP.fn_CheckAvability();
                TASP.packagePriceVerify(name, price);
                
				System.out.println("TC-113 Executed");
			}
			 catch(Exception e)
			   {
			   e.getMessage();
			   }

			 }
*/



	  	
     @Test(priority=38)
     public void TC_114() throws Exception
     {int i = 0;
    	 try
    	 {
    		 
    		    ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
    			AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
    			AEP.makePackage( "1");
    			LOPM.viewAll();
    	        LOPM.verifysavedpkg();
    	        ListOfPackagesFrontdesk LOPF=BP.fn_navigateFrontDskPkg();
    	        String a=GenericMethods.GetCurrentWindowID();
    	        attachPackages AP= LOPF.attachPackage();
    	        Thread.sleep(2000);
    	        GenericMethods.windowHandle(a);
    	        AP.selectPkgForFD(AddEditPackage.pkgName);
    	        GenericMethods.Switch_Parent_Window(a);
    	        LOPF.viewAll();
    	        PackageDetailsFrontDesk PDF=LOPF.confgr_attachedPkgFD();
    	        PDF.clickOnSave_BT();
    	        String b=GenericMethods.GetCurrentWindowID();
    	        AddActivationDateFD AAD= LOPF.AddActivationDateFD_click1();
    	        GenericMethods.windowHandle(b);
    	        Thread.sleep(2000);
    	        AAD.activateForeverPackateFD();
    	        GenericMethods.Switch_Parent_Window(b);
    	        Thread.sleep(2000);
     		 
    		    ListOfPackagesWeb LOPW=BP.fn_navigateWebPkg();   
    	        String c=GenericMethods.GetCurrentWindowID();
    	        LOPW.attachPackage();
    	        GenericMethods.windowHandle(c);
    	        AP.selectSpecifiedPackage1("Frontdesk");
    	        AP.selectPkg_WebfrmFrontdesk(AddEditPackage.pkgName);
    	        GenericMethods.Switch_Parent_Window(c);
   	            String text=LOPW.verifyMsg_attachRelational();
   	            Assert.assertEquals(text.equals("- Package(s) copied successfully"), true);               
   	            LOPW.verifyPkg_Relational();
                
                System.out.println("TC-114 Executed");
    	 }
    	 catch(Exception e)
  	   {
  	   e.getMessage();
  	   }

     }

     /*
    @Test(priority=112)
    public void TC_115() throws Exception
    {int i = 0;
    	try
    	{
    	BasePage.fn_navigatePriceManagerTAP();
    	TravelAgentPackagesLandingPage.verify_title();
    	System.out.println("TC_115 Executed");
    	}
   	 catch(Exception e)
 	   {
 	   e.getMessage();
 	   }

    }




     @Test(priority=113)
     public void TC_116() throws Exception
     {int i = 0;
    	 try
    	 {
    	BasePage.fn_navigatePriceManagerTAP();
     	TravelAgentPackagesLandingPage.fn_NavigateTopackageListpageForTA();
     	//ListOfPackagesTravelAgent1
     	System.out.println("TC_116 Executed");
    	 }
    	 catch(Exception e)
  	   {
  	   e.getMessage();
  	   }

     }




     @Test(priority=114)
     public void TC_117() throws Exception
     {int i = 0;
    	 try
    	 {
    	BasePage.fn_navigatePriceManagerTAP();
        TravelAgentPackagesLandingPage.fn_NavigateTopackageListpageForTA();
        String a=GenericMethods.GetCurrentWindowID();
        ListOfPackagesTravelAgent1.click_attackPkgbtn();
        GenericMethods.windowHandle(a);
        attachPackages.verify_windowTitle();
        attachPackages.clk_closeButton();
        GenericMethods.Switch_Parent_Window(a);
        System.out.println("TC_117 Executed");
    	 }
    	 catch(Exception e)
  	   {
  	   e.getMessage();
  	   }

     }



    @Test(priority=115)
    public void TC_118() throws Exception
    {int i = 0;
    	try
    	{
    	BasePage.fn_navigatePriceManagerTAP();
        TravelAgentPackagesLandingPage.fn_NavigateTopackageListpageForTA();
        ListOfPackagesTravelAgent1.view_All();
        ListOfPackagesTravelAgent1.getPkgID1();
        String a=GenericMethods.GetCurrentWindowID();
        ListOfPackagesTravelAgent1.click_attackPkgbtn();
        GenericMethods.windowHandle(a);
        attachPackages.selectSpecifiedPackage1TA("Frontdesk");
        attachPackages.selectPkg1_attachTARelational();
        GenericMethods.Switch_Parent_Window(a);
        ListOfPackagesTravelAgent1.view_All();
        ListOfPackagesTravelAgent1.getPkgID2();
        ListOfPackagesTravelAgent1.verifyPkg_Relational();
        System.out.println("TC_118 Executed");
    	}
   	 catch(Exception e)
 	   {
 	   e.getMessage();
 	   }

    }


    @Test(priority=116)
    public void TC_119() throws Exception
    {int i = 0;
    	try
    	{
    	BasePage.fn_navigatePriceManagerTAP();
        TravelAgentPackagesLandingPage.fn_NavigateTopackageListpageForTA();
        ListOfPackagesTravelAgent1.view_All();
        ListOfPackagesTravelAgent1.getPkgID1();
        String a=GenericMethods.GetCurrentWindowID();
        ListOfPackagesTravelAgent1.click_attackPkgbtn();
        GenericMethods.windowHandle(a);
        attachPackages.selectSpecifiedPackage1TA("Frontdesk");
        attachPackages.selectPkg1_attachTARelational();
        GenericMethods.Switch_Parent_Window(a);
        ListOfPackagesTravelAgent1.view_All();
        ListOfPackagesTravelAgent1.getPkgID2();
        ListOfPackagesTravelAgent1.confgr_attachedPkgTA();
        PackageDetailsTravelAgent.clickOnSave_BT();
        ListOfPackagesTravelAgent1.verifyAddActivationDate_linkTA();
        System.out.println("TC_119 Executed");
    	}
   	 catch(Exception e)
 	   {
 	   e.getMessage();
 	   }

    }


    @Test(priority=117)
    public void TC_120() throws Exception
    {int i = 0;
    	try
    	{
    	BasePage.fn_navigatePriceManagerTAP();
        TravelAgentPackagesLandingPage.fn_NavigateTopackageListpageForTA();
        ListOfPackagesTravelAgent1.view_All();
        ListOfPackagesTravelAgent1.getPkgID1();
        String a=GenericMethods.GetCurrentWindowID();
        ListOfPackagesTravelAgent1.click_attackPkgbtn();
        GenericMethods.windowHandle(a);
        attachPackages.selectSpecifiedPackage1TA("Frontdesk");
        attachPackages.selectPkg1_attachTARelational();
        GenericMethods.Switch_Parent_Window(a);
        ListOfPackagesTravelAgent1.view_All();
        ListOfPackagesTravelAgent1.getPkgID2();
        ListOfPackagesTravelAgent1.confgr_attachedPkgTA();
        PackageDetailsTravelAgent.clickOnSave_BT();
        String b=GenericMethods.GetCurrentWindowID();
        ListOfPackagesTravelAgent1.NavTo_ActivationDateTA();
        GenericMethods.windowHandle(a);
        AddActivationDateTA.activateForeverPackageTA();
        GenericMethods.Switch_Parent_Window(a);
        System.out.println("TC_120 Executed");
    	}
   	 catch(Exception e)
 	   {
 	   e.getMessage();
 	   }

    }



    @Test(priority=118)
    public void TC_121() throws Exception
    {int i = 0;
    	try
    	{
    	BasePage.fn_navigatePriceManagerTAP();
        TravelAgentPackagesLandingPage.fn_NavigateTopackageListpageForTA();
        ListOfPackagesTravelAgent1.view_All();
        ListOfPackagesTravelAgent1.getPkgID1();
        String a=GenericMethods.GetCurrentWindowID();
        ListOfPackagesTravelAgent1.click_attackPkgbtn();
        GenericMethods.windowHandle(a);
        attachPackages.selectSpecifiedPackage1TA("Frontdesk");
        attachPackages.selectPkg1_attachTARelational();
        GenericMethods.Switch_Parent_Window(a);
        ListOfPackagesTravelAgent1.view_All();
        ListOfPackagesTravelAgent1.getPkgID2();
        ListOfPackagesTravelAgent1.confgr_attachedPkgTA();
        PackageDetailsTravelAgent.clickOnSave_BT();
        String b=GenericMethods.GetCurrentWindowID();
        ListOfPackagesTravelAgent1.NavTo_ActivationDateTA();
        GenericMethods.windowHandle(a);
        AddActivationDateTA.activateForeverPackageTA();
        GenericMethods.Switch_Parent_Window(a);
        ListOfPackagesTravelAgent1.verifyActivatedForever_textTA();
        System.out.println("TC_121 Executed");
    	}
   	 catch(Exception e)
 	   {
 	   e.getMessage();
 	   }


    }



    @Test(priority=119)
    public void TC_122() throws Exception
    {int i = 0;
    	try
    	{
    		BP.fn_navigateWebPkg();
    	ListOfPackagesWeb.view_All();
    	ListOfPackagesWeb.getPkgID1();
    	String a=GenericMethods.GetCurrentWindowID();
    	ListOfPackagesWeb.attachPackage();
    	GenericMethods.windowHandle(a);
    	attachPackages.selectSpecifiedPackage1("Frontdesk");
    	attachPackages.selectPkg1_attachWebRelational();
    	GenericMethods.Switch_Parent_Window(a);
    	ListOfPackagesWeb.view_All();
    	ListOfPackagesWeb.getPkgID2();
    	ListOfPackagesWeb.confgr_attachedPkgWeb();
    	PackageDetailsWeb.clickOnSave_BT();
    	String b=GenericMethods.GetCurrentWindowID();
    	ListOfPackagesWeb.NavTo_ActivationDateWeb();
    	GenericMethods.windowHandle(b);
    	AddActivationDateWeb.activateForeverPackateWeb();
    	GenericMethods.Switch_Parent_Window(b);
    	ListOfPackagesWeb.click_EditLinkWebPkg();
    	PackageDetailsWeb.add_relationalRateModifier();
    	PackageDetailsWeb.clickOnSave_BT();
    	ListOfPackagesWeb.verifyMsg_relationalEdit();
    	BP.fn_navigateFrontDskPkg();
    	ListOfPackagesFrontdesk.get_parentPkgPrice();
    	PackageDetailsFrontDesk.fn_packagePrice();
    	BP.fn_navigateWebPkg();
    	ListOfPackagesWeb.click_EditLinkWebPkg();
    	PackageDetailsWeb.fn_packagePriceWeb();
    	System.out.println("TC_122 Executed");
    	}
   	 catch(Exception e)
 	   {
 	   e.getMessage();
 	   }

    }



    @Test(priority=120)
    public void TC_123() throws Exception
    {int i = 0;
    	try
    	{
    	BP.fn_navigateFrontDskPkg();
    	Thread.sleep(4000);
    	ListOfPackagesFrontdesk.viewAll();
    	ListOfPackagesFrontdesk.getPkgID1();
    	String a=GenericMethods.GetCurrentWindowID();
    	ListOfPackagesFrontdesk.attachPackage();
    	Thread.sleep(4000);
    	GenericMethods.windowHandle(a);
    	Thread.sleep(4000);
    	attachPackages.selectPkg1_attachFD();
    	Thread.sleep(4000);
    	GenericMethods.Switch_Parent_Window(a);
    	Thread.sleep(4000);
    	ListOfPackagesFrontdesk.viewAll();
    	Thread.sleep(4000);
    	ListOfPackagesFrontdesk.getPkgID2();
    	ListOfPackagesFrontdesk.confgr_attachedPkgFD();
    	Thread.sleep(4000);
    	PackageDetailsFrontDesk.clickOnSave_BT();
    	Thread.sleep(4000);
    	String b=GenericMethods.GetCurrentWindowID();
    	ListOfPackagesFrontdesk.AddActivationDateFD_click1();
    	Thread.sleep(4000);
    	GenericMethods.windowHandle(b);
    	Thread.sleep(4000);
    	AddActivationDateFD.activateForeverPackateFD();
    	Thread.sleep(4000);
    	GenericMethods.Switch_Parent_Window(b);
    	ListOfPackagesFrontdesk.click_EditLink();
    	Thread.sleep(4000);
    	PackageDetailsFrontDesk.clk_publishToDailyRate();
    	System.out.println("TC_123 Executed");
    	}
    	 catch(Exception e)
  	   {
  	   e.getMessage();
  	   }
    }




    @Test(priority=121)
    public void TC_124() throws Exception
    {int i = 0;
    	try
    	{
    	BP.fn_navigateFrontDskPkg();
    	Thread.sleep(4000);
    	ListOfPackagesFrontdesk.viewAll();
    	ListOfPackagesFrontdesk.getPkgID1();
    	String a=GenericMethods.GetCurrentWindowID();
    	ListOfPackagesFrontdesk.attachPackage();
    	Thread.sleep(4000);
    	GenericMethods.windowHandle(a);
    	Thread.sleep(4000);
    	attachPackages.selectPkg1_attachFD();
    	GenericMethods.Switch_Parent_Window(a);
    	Thread.sleep(4000);
    	ListOfPackagesFrontdesk.viewAll();
    	ListOfPackagesFrontdesk.getPkgID2();
    	ListOfPackagesFrontdesk.confgr_attachedPkgFD();
    	Thread.sleep(4000);
    	PackageDetailsFrontDesk.clickOnSave_BT();
    	Thread.sleep(4000);
    	String b=GenericMethods.GetCurrentWindowID();
    	ListOfPackagesFrontdesk.AddActivationDateFD_click1();
    	GenericMethods.windowHandle(b);
    	Thread.sleep(4000);
    	AddActivationDateFD.activateForeverPackateFD();
    	GenericMethods.Switch_Parent_Window(b);
    	Thread.sleep(4000);
    	ListOfPackagesFrontdesk.click_EditLink();
    	Thread.sleep(4000);
    	PackageDetailsFrontDesk.accept_ToDailyRate();
    	Thread.sleep(4000);
    	PackageDetailsFrontDesk.verify_savemsg();
    	System.out.println("TC_124 Executed");
    	}
    	 catch(Exception e)
  	   {
  	   e.getMessage();
  	   }
    }


    @Test(priority=122)
    public void TC_125() throws Exception
    {int i = 0;
    	try
    	{
    	BP.fn_navigateFrontDskPkg();
    	Thread.sleep(4000);
    	ListOfPackagesFrontdesk.viewAll();
    	ListOfPackagesFrontdesk.getPkgID1();
    	String a=GenericMethods.GetCurrentWindowID();
    	ListOfPackagesFrontdesk.attachPackage();
    	Thread.sleep(4000);
    	GenericMethods.windowHandle(a);
    	Thread.sleep(4000);
    	attachPackages.selectPkg1_attachFD();
    	GenericMethods.Switch_Parent_Window(a);
    	Thread.sleep(4000);
    	ListOfPackagesFrontdesk.viewAll();
    	Thread.sleep(4000);
    	ListOfPackagesFrontdesk.getPkgID2();
    	ListOfPackagesFrontdesk.confgr_attachedPkgFD();
    	Thread.sleep(4000);
    	PackageDetailsFrontDesk.clickOnSave_BT();
    	Thread.sleep(4000);
    	String b=GenericMethods.GetCurrentWindowID();
    	ListOfPackagesFrontdesk.AddActivationDateFD_click1();
    	GenericMethods.windowHandle(b);
    	Thread.sleep(4000);
    	AddActivationDateFD.activateForeverPackateFD();
    	GenericMethods.Switch_Parent_Window(b);
    	Thread.sleep(4000);
    	ListOfPackagesFrontdesk.click_EditLink();
    	Thread.sleep(4000);
    	PackageDetailsFrontDesk.accept_ToDailyRate();
    	Thread.sleep(4000);
    	PackageDetailsFrontDesk.clk_SaveAsDailyRate();
    	System.out.println("TC_125 Executed");
    	}
    	 catch(Exception e)
  	   {
  	   e.getMessage();
  	   }
    }



    @Test(priority=123)
    public void TC_126() throws Exception
    {int i = 0;
    	try
    	{
    	BP.fn_navigateFrontDskPkg();
    	Thread.sleep(4000);
    	ListOfPackagesFrontdesk.viewAll();
    	ListOfPackagesFrontdesk.getPkgID1();
    	String a=GenericMethods.GetCurrentWindowID();
    	ListOfPackagesFrontdesk.attachPackage();
    	GenericMethods.windowHandle(a);
    	Thread.sleep(4000);
    	attachPackages.selectPkg1_attachFD();
    	Thread.sleep(4000);
    	GenericMethods.Switch_Parent_Window(a);
    	ListOfPackagesFrontdesk.viewAll();
    	Thread.sleep(4000);
    	ListOfPackagesFrontdesk.getPkgID2();
    	ListOfPackagesFrontdesk.confgr_attachedPkgFD();
    	Thread.sleep(4000);
    	PackageDetailsFrontDesk.clickOnSave_BT();
    	Thread.sleep(4000);
    	String b=GenericMethods.GetCurrentWindowID();
    	ListOfPackagesFrontdesk.AddActivationDateFD_click1();
    	GenericMethods.windowHandle(b);
    	Thread.sleep(4000);
    	AddActivationDateFD.activateForeverPackateFD();
    	GenericMethods.Switch_Parent_Window(b);
    	Thread.sleep(4000);
    	ListOfPackagesFrontdesk.click_EditLink();
    	Thread.sleep(4000);
    	PackageDetailsFrontDesk.accept_ToDailyRate();
    	Thread.sleep(4000);
    	PackageDetailsFrontDesk.accept_SaveDailyRate();
    	Thread.sleep(4000);
    	PackageDetailsFrontDesk.clk_PkgFrontdeskLnk();
    	Thread.sleep(4000);
    	ListOfPackagesFrontdesk.verify_DailyRatePkg();
    	System.out.println("TC_126 Executed");
    	}
    	 catch(Exception e)
  	   {
  	   e.getMessage();
  	   }
    }



*/


@AfterMethod
public void closeApp() throws Exception
{
try{
        GenericMethods.driver.close();
		GenericMethods.driver.quit();
}catch(Exception e){
	Thread.sleep(2000);
	System.out.println("Heyy I am in closeApp methpd catch");
	 GenericMethods.driver.close();
		GenericMethods.driver.quit();


}
}



}

package com.hotelogix.smoke.genericandbase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import com.hotelogix.smoke.admin.CompanyInfo.HotelInformationPage;
import com.hotelogix.smoke.admin.Console.ListOfRegisteredCorporateLP;
import com.hotelogix.smoke.admin.Console.ListOfRegisteredTravelAgentLP;
import com.hotelogix.smoke.admin.Console.RegisteredTravelAgentPage;
import com.hotelogix.smoke.admin.General.BookingPolicyPage;
import com.hotelogix.smoke.admin.General.DefaultSettingLandingPage;
import com.hotelogix.smoke.admin.General.PayTypesPage;
import com.hotelogix.smoke.admin.General.TaxExemptListPage;
import com.hotelogix.smoke.admin.PosManager.POSPointsLandingPage;
import com.hotelogix.smoke.admin.PosManager.POSTaxListPage;
import com.hotelogix.smoke.admin.PriceManager.AddonLandingPage;
import com.hotelogix.smoke.admin.PriceManager.CenteralizePackageLandingPage;
import com.hotelogix.smoke.admin.PriceManager.FrontdeskPackagesListPage;
import com.hotelogix.smoke.admin.PriceManager.GroupTaxListPage;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackageCentralizedRate;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesCorporate;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesFrontdesk;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesPage;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesTravelAgent;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesWeb;
import com.hotelogix.smoke.admin.PriceManager.ListofPackagesInPackageMaster;
import com.hotelogix.smoke.admin.PriceManager.RoomPricesLandingPage;
import com.hotelogix.smoke.admin.PriceManager.SeasonsLandingPage;
import com.hotelogix.smoke.admin.PriceManager.SpecialPeriodLandingPage;
import com.hotelogix.smoke.admin.PriceManager.TravelAgentPackagesLandingPage;
import com.hotelogix.smoke.admin.Report.NightAuditReportPage;
import com.hotelogix.smoke.admin.UserManager.UsersLevelList;
import com.hotelogix.smoke.admin.UserManager.UsersListLandingPage;
import com.hotelogix.smoke.admin.WebManager.WebReservationSettingPage;
import com.hotelogix.smoke.admin.roommanager.AmenitiesLandingPage;
import com.hotelogix.smoke.admin.roommanager.RoomTaxesLandingPage;
import com.hotelogix.smoke.admin.roommanager.RoomTypesLandingPage;
import com.hotelogix.smoke.admin.roommanager.RoomsLandingPage;






public class BasePage
{


	@FindBy(xpath="//td[@class='page-heading']")
	public static WebElement title;

	@FindBy(xpath="//a[text()='General']")
	public static WebElement General;

	@FindBy(xpath="//a[text()='Booking Policy']")
	public static WebElement Booking_Policy;

	@FindBy(xpath="//a[text()='Price Manager']")
	public static WebElement PriceManager;

	@FindBy(xpath="//a[text()='Seasons']")
	public static WebElement Seasons;

	@FindBy(xpath="//a[text()='Special Periods']")
	public static WebElement SpPeriods;

	@FindBy(xpath="//a[text()='Room Prices']")
	public static WebElement RoomPrices;


	@FindBy(xpath="//a[text()='Console']")
	public static WebElement Console;

	@FindBy(xpath="//a[text()='Registered Travel Agent']")
	public static WebElement RegisteredTravelAgent;

	@FindBy(xpath="//a[text()='Report']")
	public static WebElement Report;

	@FindBy(xpath="//a[text()='Night Audit Report']")
	public static WebElement NightAuditReport;


	@FindBy(xpath="//a[text()='Web Manager']")
	public static WebElement WebManager;

	@FindBy(xpath="//a[text()='Web Setting']")
	public static WebElement WebSetting;



	@FindBy(xpath="//a[text()='Centralized Rate']")
	public static WebElement CentralizedRate;



	@FindBy(xpath=" //a[text()='Group(Booking Source)']")
	public static WebElement GroupBookingSource;


	@FindBy(xpath="//a[text()='Group Tax']")
	public static WebElement GroupTax;


	@FindBy(xpath="//a[text()='Packages Master']")
	public static WebElement PackagesMaster;


	@FindBy(xpath="//a[text()='Web (Packages)']")
	public static WebElement WebPackages;

	/*@FindBy(xpath="//div[@id='all']//li/a[text()='Rooms Manager']")
	public static WebElement roommanager;*/
	
	@FindBy(xpath="//a[text()='Rooms Manager']")
	public static WebElement roommanager;

	@FindBy(xpath="//div[@id='all']//li/ul/li/a[text()='Amenities']")
	public static WebElement amenities;


	@FindBy(xpath="//a[text()='Frontdesk (Packages)']")
	public static WebElement FrontdeskPackages;

	@FindBy(xpath="//a[text()='Default Settings']")
	public static WebElement DefaultSetting;


	@FindBy(xpath="(//a[contains(text(),'Rooms')])[2]")
	public static WebElement rooms;

	@FindBy(xpath="//div[@id='nav-bg']//ul//li[3]//a[text()='Price Manager']")
	public static WebElement priceManager;

	@FindBy(xpath="//div[@id='nav-bg']//ul//li[3]//ul//li[5]//a[text()='Add-ons (Inclusions)']")
	public static WebElement adddons;

	@FindBy(xpath="//a[text()='Packages Master']")
	public static WebElement PackageMaster;

	@FindBy(xpath="//a[text()='Frontdesk (Packages)']")
	public static WebElement frontDeskPackage;

	@FindBy(xpath="//a[text()='Web (Packages)']")
	public static WebElement webPackage;

	@FindBy(xpath="//a[text()='Corporate (Packages)']")
	public static WebElement corporatePkg;

	@FindBy(xpath="//a[text()='Travel Agent (Packages)']")
	public static WebElement TravelAgentPackage;

	@FindBy(xpath="//a[text()='Pay Types']")
	public static WebElement payTpes;

	@FindBy(xpath="//a[text()='POS Manager']")
	public static WebElement POSManager;

	@FindBy(xpath="//a[text()='POS Taxes']")
	public static WebElement POSTaxes;

	@FindBy(xpath="//a[text()='POS Points ']")
	public static WebElement POSPoints;

	@FindBy(xpath="//a[text()='Company Info']")
	public static WebElement CompanyInfo;

	@FindBy(xpath="//a[text()='Hotel Information']")
	public static WebElement HotelInformation;

	@FindBy(xpath="//a[text()='User Manager']")
	public static WebElement UserManager;

	@FindBy(xpath="//a[text()='User Levels']")
	public static WebElement UserLevels;

	@FindBy(xpath="//a[text()='Users']")
	public static WebElement Users;

	@FindBy(xpath="//a[text()='Registered Corporate']")
	public static WebElement CorporateConsole;

	@FindBy(xpath="//a[text()='Centralized Rate']")
	public static WebElement CentralisedRate;

	@FindBy(xpath="//a[text()='Registered Travel Agent']")
	public static WebElement TravelAgentConsole;

	@FindBy(xpath="//a[text()='Web Manager']")
	public static WebElement webManager;

	@FindBy(xpath="//a[text()='Web Setting']")
	public static WebElement webSetting;

	@FindBy(xpath="//a[text()='Reasons for Tax-Exempt']")
	public WebElement Link_ReasonForTextExempt;




	/*    public BookingPolicyPage fn_NavigateBookingPolicy() throws Exception
     {

        GenericMethods.mouseOverElement(General);
        GenericMethods.clickElement(Booking_Policy);

        BookingPolicyPage BPP = PageFactory.initElements(GenericMethods.driver, BookingPolicyPage.class);
        return BPP;

     }


    public SeasonsLandingPage fn_NavigatePriceManager() throws Exception
    {
        GenericMethods.mouseOverElement(PriceManager);
        GenericMethods.clickElement(Seasons);

        SeasonsLandingPage SLP = PageFactory.initElements(GenericMethods.driver, SeasonsLandingPage.class);
        return SLP;

    }*/

	public  void verify_PageTitle() throws Exception
	{
		//..Method fetches page title and verifies it with the expected value
		try
		{
			String str=title.getText();
			Assert.assertEquals(str, "Administrator Console");
		}

		catch(Exception e)
		{
			throw e;
		}
	}

	public  AmenitiesLandingPage amenitiesPageNevigation() throws Exception
	{
		//..Method clicks on Amenities and navigates to AmenitiesLandingPage
		try
		{
			GenericMethods.mouseOverElement(roommanager);
			GenericMethods.clickElement(amenities);
			//..Initializing AmenitiesLandingPage
			AmenitiesLandingPage ALP = PageFactory.initElements(GenericMethods.driver, AmenitiesLandingPage.class);
			return ALP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public  ListofPackagesInPackageMaster fn_navigatePackageMaster() throws Exception
	{
		try
		{
			GenericMethods.mouseOverElement(PriceManager);
			GenericMethods.clickElement(PackageMaster);

			ListofPackagesInPackageMaster pageObj=PageFactory.initElements(GenericMethods.driver, ListofPackagesInPackageMaster.class);
			return pageObj;
		}
		catch(Exception e)
		{
			throw e;
		}
	}



	public  RoomPricesLandingPage fn_navigatePriceManagerRP() throws Exception
	{
		try
		{
			GenericMethods.mouseOverElement(PriceManager);
			GenericMethods.clickElement(RoomPrices);
			Thread.sleep(2000);
			RoomPricesLandingPage RPLP=PageFactory.initElements(GenericMethods.driver, RoomPricesLandingPage.class);
			return RPLP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public ListOfRegisteredTravelAgentLP fn_NavigateRegisteredTravelAgent() throws Exception {
		try
		{
			GenericMethods.mouseOverElement(Console);
			GenericMethods.clickElement(RegisteredTravelAgent);
			ListOfRegisteredTravelAgentLP LTA=PageFactory.initElements(GenericMethods.driver,ListOfRegisteredTravelAgentLP.class );
			return LTA;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public NightAuditReportPage fn_NavigateNightAuditReport() throws Exception{
		try
		{
			GenericMethods.mouseOverElement(Report);
			GenericMethods.clickElement(NightAuditReport);
			NightAuditReportPage NAR=PageFactory.initElements(GenericMethods.driver,NightAuditReportPage.class );
			return NAR;
		}
		catch(Exception e)
		{
			throw e;
		}
	}



	public WebReservationSettingPage fn_NavigateWebSetting() throws Exception{

		try
		{
			GenericMethods.mouseOverElement(WebManager);
			GenericMethods.clickElement(WebSetting);
			WebReservationSettingPage WRS=PageFactory.initElements(GenericMethods.driver,WebReservationSettingPage.class );
			return WRS;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public ListOfPackageCentralizedRate fn_NavigatePriceManager() throws Exception {

		try
		{

			GenericMethods.mouseOverElement(PriceManager);
			GenericMethods.clickElement(CentralizedRate);
			ListOfPackageCentralizedRate LCP=PageFactory.initElements(GenericMethods.driver,ListOfPackageCentralizedRate.class );
			return LCP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public com.hotelogix.smoke.admin.PriceManager.GroupBookingSource fn_NavigatePriceManager1() throws Exception{


		GenericMethods.mouseOverElement(PriceManager);
		GenericMethods.clickElement(GroupBookingSource);


		com.hotelogix.smoke.admin.PriceManager.GroupBookingSource GBS=PageFactory.initElements(GenericMethods.driver, com.hotelogix.smoke.admin.PriceManager.GroupBookingSource.class);

		return GBS;
	}

	public GroupTaxListPage fn_NavigateGroupTax() throws Exception{

		try
		{
			GenericMethods.mouseOverElement(PriceManager);
			GenericMethods.clickElement(GroupTax);
			GroupTaxListPage GTL=PageFactory.initElements(GenericMethods.driver, com.hotelogix.smoke.admin.PriceManager.GroupTaxListPage.class);
			return GTL;
		}
		catch(Exception e)
		{
			throw e;}
	}


	public ListOfPackagesPage fn_NavigatePackageMaster() throws Exception{
		GenericMethods.mouseOverElement(PriceManager);
		GenericMethods.clickElement(PackagesMaster);
		ListOfPackagesPage LOP=PageFactory.initElements(GenericMethods.driver, ListOfPackagesPage .class);
		return LOP;
	}


	public FrontdeskPackagesListPage fn_NavigateFrontdeskPackages() throws Exception{
		GenericMethods.mouseOverElement(PriceManager);
		GenericMethods.clickElement(FrontdeskPackages);
		FrontdeskPackagesListPage FPL=PageFactory.initElements(GenericMethods.driver, FrontdeskPackagesListPage.class);
		return FPL;
	}



	public DefaultSettingLandingPage fn_NavigateToDefaultSetting() throws Exception{
		GenericMethods.mouseOverElement(General);
		GenericMethods.clickElement(DefaultSetting);


		DefaultSettingLandingPage DSL=PageFactory.initElements(GenericMethods.driver,DefaultSettingLandingPage.class);
		return DSL;
	}



	//xpath for Room Types
	@FindBy(xpath="//a[text()='Room Types']")
	public static WebElement roomTypes;

	public  RoomTypesLandingPage roomTypesNavigate() throws Exception
	{
		//..Method navigates to Room Types page
		//..Initializing RoomTypesLandingPage
		try
		{
			GenericMethods.mouseOverElement(roommanager);
			GenericMethods.clickElement(roomTypes);

			RoomTypesLandingPage RTLP = PageFactory.initElements(GenericMethods.driver, RoomTypesLandingPage.class);
			return RTLP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}



	//Navigate to Rooms Page
	public RoomsLandingPage roomsPageNavigate() throws Exception{
		//..Method navigates to RoomsLandingPage on clicking Rooms under Rooms Manager menu tab
		try{
			Thread.sleep(3000);
			//System.out.println(GenericMethods.driver.getWindowHandle());
			GenericMethods.mouseOverElement(roommanager);
			GenericMethods.clickElement(rooms);
			RoomsLandingPage RLP = PageFactory.initElements(GenericMethods.driver, RoomsLandingPage.class);
			return RLP;
		}catch(Exception e){
			throw e;
		}
	}

	//Navigate to Room tax Page

	//Xpath for Room Tax
	@FindBy(xpath="//a[text()='Room Taxes']")
	public static WebElement roomTaxes;

	public  RoomTaxesLandingPage roomTaxPageNavigate() throws Exception
	{
		try
		{
			GenericMethods.mouseOverElement(roommanager);
			GenericMethods.clickElement(roomTaxes);

			RoomTaxesLandingPage RTLP = PageFactory.initElements(GenericMethods.driver, RoomTaxesLandingPage.class);
			return RTLP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public  AddonLandingPage addonsLandingPage() throws Exception
	{
		try
		{
			GenericMethods.mouseOverElement(priceManager);
			GenericMethods.clickElement(adddons);

			AddonLandingPage ALP = PageFactory.initElements(GenericMethods.driver, AddonLandingPage.class);
			return ALP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	public  ListOfPackagesFrontdesk fn_navigateFrontDskPkg() throws Exception
	{
		try
		{
			GenericMethods.mouseOverElement(PriceManager);
			GenericMethods.clickElement(frontDeskPackage);

			ListOfPackagesFrontdesk pageObj=PageFactory.initElements(GenericMethods.driver, ListOfPackagesFrontdesk.class);
			return pageObj;
		}
		catch(Exception e)
		{

			throw e;
		}
	}

	public  ListOfPackagesWeb fn_navigateWebPkg() throws Exception
	{
		GenericMethods.mouseOverElement(PriceManager);
		GenericMethods.clickElement(webPackage);
		ListOfPackagesWeb pageObj=PageFactory.initElements(GenericMethods.driver, ListOfPackagesWeb.class);
		return pageObj;
	}

	public static ListOfPackagesCorporate fn_navigateCorporatePkg() throws Exception
	{
		GenericMethods.mouseOverElement(PriceManager);
		GenericMethods.clickElement(corporatePkg);

		ListOfPackagesCorporate LPC=PageFactory.initElements(GenericMethods.driver, ListOfPackagesCorporate.class);
		return LPC;
	}

	public  TravelAgentPackagesLandingPage fn_navigatePriceManagerTAP() throws Exception
	{
		try
		{
			GenericMethods.mouseOverElement(PriceManager);
			GenericMethods.clickElement(TravelAgentPackage);

			TravelAgentPackagesLandingPage TAPLP=PageFactory.initElements(GenericMethods.driver, TravelAgentPackagesLandingPage.class);
			return TAPLP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public static ListOfPackagesTravelAgent fn_navigatePriceManagerTAP1() throws Exception
	{
		GenericMethods.mouseOverElement(PriceManager);
		GenericMethods.clickElement(TravelAgentPackage);

		ListOfPackagesTravelAgent LTA=PageFactory.initElements(GenericMethods.driver, ListOfPackagesTravelAgent.class);
		return LTA;
	}

	public  DefaultSettingLandingPage fn_DefaultSettingsNavigate() throws Exception
	{
		try
		{
			GenericMethods.mouseOverElement(General);
			GenericMethods.clickElement(DefaultSetting);
			DefaultSettingLandingPage DS=PageFactory.initElements(GenericMethods.driver, DefaultSettingLandingPage.class);
			return DS;
		}
		catch(Exception e)
		{
			throw e;

		}
	}


	public   PayTypesPage fn_NavigatePayTypes() throws Exception
	{
		try
		{
			GenericMethods.mouseOverElement(General);
			GenericMethods.clickElement(payTpes);

			PayTypesPage PTP = PageFactory.initElements(GenericMethods.driver, PayTypesPage.class);
			return PTP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public BookingPolicyPage fn_NavigateBookingPolicy() throws Exception
	{

		try
		{
			GenericMethods.mouseOverElement(General);
			GenericMethods.clickElement(Booking_Policy);

			BookingPolicyPage BPP = PageFactory.initElements(GenericMethods.driver, BookingPolicyPage.class);
			return BPP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public SeasonsLandingPage fn_NavigateSeasons() throws Exception
	{
		try
		{
			GenericMethods.mouseOverElement(PriceManager);
			GenericMethods.clickElement(Seasons);

			SeasonsLandingPage SLP = PageFactory.initElements(GenericMethods.driver, SeasonsLandingPage.class);
			return SLP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public SpecialPeriodLandingPage fn_NavigatePriceManagerSP() throws Exception
	{
		try
		{
			GenericMethods.mouseOverElement(PriceManager);
			GenericMethods.clickElement(SpPeriods);

			SpecialPeriodLandingPage SPL=PageFactory.initElements(GenericMethods.driver, SpecialPeriodLandingPage.class);
			return SPL;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public POSTaxListPage fn_navigatePOSManagerPT() throws Exception
	{
		try
		{
			GenericMethods.mouseOverElement(POSManager);
			GenericMethods.clickElement(POSTaxes);

			POSTaxListPage PTLP=PageFactory.initElements(GenericMethods.driver, POSTaxListPage.class);
			return PTLP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public POSPointsLandingPage fn_navigatePOSManagerPP() throws Exception
	{
		try
		{
			GenericMethods.mouseOverElement(POSManager);
			GenericMethods.clickElement(POSPoints);

			POSPointsLandingPage PPLP=PageFactory.initElements(GenericMethods.driver, POSPointsLandingPage.class);
			return PPLP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public HotelInformationPage fn_navigateCompanyInfo() throws Exception
	{
		try
		{
			GenericMethods.mouseOverElement(CompanyInfo);
			GenericMethods.clickElement(HotelInformation);

			HotelInformationPage HIPG=PageFactory.initElements(GenericMethods.driver, HotelInformationPage.class);
			return HIPG;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public UsersLevelList fn_navigateUserManager_UserLevels() throws Exception
	{
		try
		{
			GenericMethods.mouseOverElement(UserManager);
			GenericMethods.clickElement(UserLevels);

			UsersLevelList ULL = PageFactory.initElements(GenericMethods.driver, UsersLevelList.class);
			return ULL;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public UsersListLandingPage fn_navigateUserManager_UsersList() throws Exception
	{
		try
		{
			GenericMethods.mouseOverElement(UserManager);
			GenericMethods.clickElement(Users);

			UsersListLandingPage ULP=PageFactory.initElements(GenericMethods.driver, UsersListLandingPage.class);
			return ULP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public  ListOfRegisteredCorporateLP fn_navigateToRegCorporateConsole() throws Exception
	{
		try
		{
			GenericMethods.mouseOverElement(Console);
			GenericMethods.clickElement(CorporateConsole);

			ListOfRegisteredCorporateLP pageObj=PageFactory.initElements(GenericMethods.driver, ListOfRegisteredCorporateLP.class);
			return pageObj;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public  ListOfPackageCentralizedRate fn_navigateCentralisedRate() throws Exception
	{
		try
		{
			GenericMethods.mouseOverElement(PriceManager);
			GenericMethods.clickElement(CentralisedRate);

			ListOfPackageCentralizedRate pageObj=PageFactory.initElements(GenericMethods.driver, ListOfPackageCentralizedRate.class);
			return pageObj;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public  ListOfRegisteredTravelAgentLP fn_navigateTravalAgentConsole() throws Exception
	{
		try
		{
			GenericMethods.mouseOverElement(Console);
			GenericMethods.clickElement(TravelAgentConsole);

			ListOfRegisteredTravelAgentLP TAPLP=PageFactory.initElements(GenericMethods.driver, ListOfRegisteredTravelAgentLP.class);
			return TAPLP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public WebReservationSettingPage fn_navigateWebSetting() throws Exception
	{
		try
		{
			GenericMethods.mouseOverElement(webManager);
			GenericMethods.clickElement(webSetting);

			WebReservationSettingPage WMLP=PageFactory.initElements(GenericMethods.driver, WebReservationSettingPage.class);
			return WMLP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}



	public TaxExemptListPage fn_navigateToTaxExemptReason() throws Exception{
		try{
			GenericMethods.mouseOverElement(General);
			GenericMethods.clickElement(Link_ReasonForTextExempt);
		}
		catch(Exception e){
			throw e;
		}
		TaxExemptListPage TELP=PageFactory.initElements(GenericMethods.driver, TaxExemptListPage.class);
		return TELP;
	}

















}
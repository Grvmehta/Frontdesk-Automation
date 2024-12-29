package com.hotelogix.smoke.frontdesk.FrontdeskHome;




import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import com.hotelogix.smoke.admin.roommanager.AddRoomsPage;
import com.hotelogix.smoke.frontdesk.Accounts.AccountsLandingPage;
import com.hotelogix.smoke.frontdesk.CashCounter.CloseCashCounterPage;
import com.hotelogix.smoke.frontdesk.Payment.AccountStatementLandingPage;
import com.hotelogix.smoke.frontdesk.Report.LiveSupportLandingWindow;
import com.hotelogix.smoke.frontdesk.Report.ReportLandingPage;
import com.hotelogix.smoke.frontdesk.ReservationSearchResult.ReservationSearchResultLandingPage;
import com.hotelogix.smoke.frontdesk.RoomOperations.TempRoomList;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.SampleRestaurantPage;
import com.hotelogix.smoke.frontdesk.ViewDetailsPage.EnableEditingPage;
import com.hotelogix.smoke.frontdesk.ViewDetailsPage.GroupViewDetailPage;
import com.hotelogix.smoke.frontdesk.ViewDetailsPage.ViewDetailsPage;
import com.hotelogix.smoke.frontdesk.WebReservation.WebReservationHomePage;
import com.hotelogix.smoke.genericandbase.BasePage;
import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;
import com.hotelogix.smoke.login.AdminLoginPage;





public class FrontdeskLandingPage {


	public float TotalCharge;
	public String title;
	public String resTitle;
	public String headerDNR;
	public String expValue1;
    //WebDriver driver;

	@FindBy(xpath="//input[@value='Cancel']")
	public static WebElement Cancel_BT;

	@FindBy(xpath="//div[@title='209']")
	public static WebElement RoomsNumber_BT;

	//@FindBy(xpath="//input[@id='txtResFrndLookup']")
	@FindBy(xpath="//input[@id='txtResFrndLookupAll']")
	public static WebElement Search_ED;

	@FindBy(xpath="//span[text()='Fg Fgfg']")
	public static WebElement AutoSuggestion;

	//@FindBy(xpath="//input[@id='txtResFrndLookupAllChk']")
	@FindBy(xpath="//button[@id='txtResFrndLookupAllBtn']")
	public static WebElement Search_CB;

	@FindBy(xpath="//button[@id='txtResFrndLookupAllBtn-button']")
	public static WebElement SearchAll_BT;

	@FindBy(xpath="//button[@id='tc-current-view-btn']")
	public static WebElement Current_Link;

	@FindBy(xpath="//a[@class='yuimenubaritemlabel']")
	public static WebElement SampleRestaurant;

	@FindBy(xpath="//button[text()='Ok']")
	public static WebElement CancelDNR;

	@FindBy(xpath="//h4")
	public static WebElement checkinCard_title;

	/*@FindBy(xpath="//div[@resrvid='2314060' and contains(@title,'69. TFbHC NLGPH')]")
public static WebElement resrvId;*/


	@FindBy(xpath="//div[@id='contextmenu']//ul//li[9]/a")
	public static WebElement rightClk_viewDetails;

	@FindBy(xpath="//div[@title='131']")
	public static WebElement RoomForDNR;

	@FindBy(xpath="//div[@class='bd']//li[6]/a")
	public static WebElement DNROption;

	@FindBy(xpath="//span[text()='Close Counter: Default Counter']")
	public WebElement link_CloseCashCounter;

	//@FindBy(xpath="//div[@resrvid='2316560' and contains(@assignedroomid,'346997')]")
	//public static WebElement resrvId;

	@FindBy(xpath="//div[@resrvid='4222185']")
	public static WebElement resrvId;

	@FindBy(xpath="//div[@id='contextmenu']//ul//li[2]/a")
	public static WebElement rightClk_checkIn;

	@FindBy(xpath="//div[@id='contextmenu']//ul//li[1]/a")
	public static WebElement rightClk_cnclcheckin;

	@FindBy(xpath="//input[@value='Close']")
	public static WebElement checkinCard_closeBtn;

	@FindBy(xpath="//div[@resrvid='4213444' and contains(@title,'64. Din Dayaal')]")
	public static WebElement ReservID_dpk;

	@FindBy(xpath="//div[@resrvid='4230208' and contains(@title,'76. sougata mondal(G) ')]")
	public static WebElement GrpReservID_NoShow;

	@FindBy(xpath="//div[@resrvid='4239732' and contains(@title,'27. Yamini K(G) ')]")
	public static WebElement grpResrvID;

	@FindBy(xpath="//div[@resrvid='4313457' and contains(@title,'25.  Nikita K(G)')]")
	public static WebElement checkoutDueResrv;

	@FindBy(xpath="//div[@resrvid='4052388' and contains(@title,'11. Richard Gere')]")
	public static WebElement resrvId2;

	@FindBy(xpath="//div[@id='contextmenu']//ul//li[7]/a")
	public static WebElement rightClk_Payment;

	@FindBy(xpath="//div[@resrvid='4052390' and contains(@title,'13. April Monique(G)')]")
	public static WebElement grpResrvID1;

	@FindBy(xpath="//div[@resrvid='4250746' and contains(@title,'30. Guest 1 Abc(G)')]")
	public static WebElement grpResrvID2;

	@FindBy(xpath="//div[@resrvid='4263947' and contains(@title,'22. Richard S(G)')]")
	public static WebElement grpResrvID3;

	@FindBy(xpath="//div[@id='contextmenu']//ul//li[10]/a")
	public static WebElement grpcheckin;

	@FindBy(xpath="//a[text()='Web Reservation']")
	public static WebElement WebReservation_Link;

	@FindBy(xpath="//a[@class='link-top-unit' and text()='Admin Console']")
	public static WebElement Admin_lnk;

	@FindBy(xpath="//div[@id='pnl-nav-links']//img")
	public static WebElement LiveSupport_BT;

	@FindBy(xpath="//div[@resrvid='2315068' and @title='60. Harry Yadav(G) ']")
	public static WebElement UncheckinReserveID_G;

	@FindBy(xpath="//div[@resrvid='4044070' and @title='14. Janet Fonda(G) ']")
	public static WebElement UNcheckinReserveID_G;

	@FindBy(xpath="//div[@resrvid='4044065' and @title='10. Ken Sue']")
	public static WebElement ReserveID_TTR;

	@FindBy(xpath="//div[@resrvid='2314613' and @title='59. Baba Khan(G)']")
	public static WebElement ReserveID_G;

	@FindBy(xpath="//a[text()='Check In']")
	public  WebElement rightClk_CheckIN;

	@FindBy(xpath="//button[text()='Continue to Checkin']")
	public static WebElement ContinueToCheckIn_BT;

	@FindBy(xpath="//div[@resrvid='2316107' and @title='66. Ramesh Khanaaa(G) ']")
	public static WebElement RameshKhanna_ReserveID;

	@FindBy(xpath="//a[text()='Report']")
	public static WebElement Report_BT;

	@FindBy(xpath="//input[@value='Perform Auto Night Audit']")
	public static WebElement AutoNightAuditBtn;

	@FindBy(xpath="//a[text()='Frontdesk']")
	public static WebElement Frontdesk_BT;

	@FindBy(xpath="//a[text()='Perform Night Audit']")
	public static WebElement PerformNightAudit_Link;

	@FindBy(xpath="//img[@id='hkDNRImgCal1']")
	public static WebElement FromCal_DNRPopUp;

	@FindBy(xpath="//img[@id='hkDNRImgCal2']")
	public static WebElement ToCal_DNRPopUp;

	@FindBy(xpath="//table[@id='sr-calContainerPopup_t']//tbody//a")
	public static WebElement DateInCal_DNRPopUp;

	@FindBy(xpath="//button[text()='Ok']")
	public static WebElement OKbutton_DNRPopUp;

	@FindBy(xpath="//div[@rsvstatus='DNR']")
	public static WebElement DNR_Reservation;

	@FindBy(xpath="//td[@id='dnrListTdId']//img[2]")
	public static WebElement DeleteIcon_DNRPopUp;

	@FindBy(xpath="//textarea[@id='txtDnrComment']")
	public static WebElement TextBox_DNRPopUp;






	@FindBy(xpath="//div[@id='hhead348284']//input")
	public static WebElement Rooms_CB;

	@FindBy(xpath="//div[@id='PanelQuickRes']//td")
	public static WebElement addQuickResrv;

	@FindBy(xpath="//div[@id='quickLinkDiv']")
	public static WebElement tooltip;

	@FindBy(xpath="//select[@id='noofRooms1']")
	public static WebElement roomDD;

	@FindBy(xpath="//a[@id='lnkQResFormSingleEnab']")
	public static WebElement singleLnk;

	@FindBy(xpath="//a[contains(@onclick,'Tab_GroupRes(2)')]")
	public static WebElement groupLnk;

	@FindBy(xpath="//a[contains(@onclick,'Tab_GroupRes(0)')]")
	public static WebElement ag_corp_Lnk;

	@FindBy(xpath="//select[@id='qrSelRateType']")
	public static WebElement rateType;

	@FindBy(xpath="//select[@id='qrSelAdult']")
	public static WebElement adultDD;

	@FindBy(xpath="//span[@id='btnSrShowEditDetails']")
	public static WebElement viewBtn;

	@FindBy(xpath="//div[@id='PanelAutoNA_h']/span")
	public static WebElement nightaudit;

	@FindBy(xpath="//div[@resrvid='4239763' and @title='44. Ankit singh(G)']")
	public static WebElement GroupReservation_ID;

	@FindBy(xpath="//div[@resrvid='4299262']")
	public static WebElement GroupReservation_HarveshID;

	@FindBy(xpath="//a[text()='Cancel Check In']")
	public  WebElement rightClk_CancelCheckIN;

	@FindBy(xpath="//div[@resrvid='4304175']")
	public static WebElement GroupReservation_ForCheckIN;

	@FindBy(xpath="//div[@resrvid='4306773']")
	public static WebElement GroupReservation_ForTaxExempt;

	@FindBy(xpath="//div[@resrvid='4064928' and @title='10. Anastasia Hue']")
	public static WebElement reservID_Payment;

	@FindBy(xpath="//div[@resrvid='4221090']")
	public static WebElement GroupReservation_ForAddNewR;

	@FindBy(xpath="//div[@resrvid='4221090']")
	public static WebElement GrpReserID_Discount;

	@FindBy(xpath="//div[@resrvid='4240498']")
	public static WebElement GrpReservID_ManageSharer;

	@FindBy(xpath="//a[text()='Accounts']")
	public static WebElement Accounts_Link;


	
	@FindBy(xpath="//i[@id='profile-link']")
	public WebElement Link_profile;

	@FindBy(xpath="//span[text()='Admin Console']")
	public WebElement Link_AdmineConsole;

	@FindBy(xpath="//button[@id='btnSrShowEditDetails-button']")
	public WebElement Btn_View;




	@FindBy(xpath="//button[text()='View']")
	public WebElement Link_ViewOnResDetailForm;


	@FindBy(xpath=".//*[@id='panelSingleResShow']/div[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr[1]/td[2]")
	public WebElement Text_RateOverViewPane;

	public static String exp_msg="The room selected for Check-in is not clean. \n"+" "+
			"Do you still wish to check in ?";


	@FindBy(xpath="//table/tbody/tr[3]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr[1]/td[2]")
	public WebElement Text_RateViewPopup;


	@FindBy(xpath="//button[text()='Perform Auto Night Audit']")
	public WebElement Btn_AutoNightAudit;


	public static String resvId;


	@FindBy(xpath="//a[text()='Frontdesk']")
	public WebElement Link_Frontdesk;

	@FindBy(xpath="//ul/li[1]/div/div[1]/ul/li[4]/a")
	public WebElement Link_NightAudit;

	@FindBy(xpath="//a[contains(text(),'Payments')]")
	public WebElement Link_Payments;

	@FindBy(xpath="//a[text()='Check In']")
	public WebElement Link_CheckIn;

	@FindBy(xpath="//a[text()='View Details']")
	public WebElement Link_ViewDetails;

	@FindBy(xpath="//a[text()='Group Check In']")
	public WebElement Link_GroupCheckIn;

	@FindBy(xpath="//div[@id='PanelAutoNA_h']/span[1]")
	public WebElement Header_NightAuditPopUp;

	//@FindBy(xpath="//a[text()='Accounts']")
	@FindBy(xpath="//i[@title='Accounts']")
	public WebElement Link_AccountsFD;

	@FindBy(xpath="//a[text()='Group Check In']")
	public WebElement Link_groupCheckIn;

	@FindBy(xpath="//a[text()='Cancel Check In']")
	public WebElement Link_CancelCheckIn;

	@FindBy(xpath="//a[text()='DNR']")
	public WebElement Link_DNR;

	@FindBy(xpath="//div[@id='PanelTasksHKNew_h']")
	public static WebElement Header_DNRPopUp;

	@FindBy(xpath="//textarea[@id='txtDnrComment']")
	public WebElement TxtBX_CommentsForDNR;

	@FindBy(xpath="//button[@id='btnDNRSave-button']")
	public WebElement Btn_SubmitDNR;

	@FindBy(xpath="//a[text()='Split Reservation']")
	public WebElement Btn_SplitReservation;

	//@FindBy(css="div#srImgCal2")
	@FindBy(xpath="//i[@id='srImgCal2']")
	public WebElement Icon_ToDateForSplitReservation;

	//@FindBy(css="select#srSelRoomType")
	@FindBy(xpath="//select[@id='srSelRoomType']")
	public WebElement DD_RoomTypeForSplitResv;

	//@FindBy(css="select#srSelRoom")
	@FindBy(xpath="//select[@id='srSelRoom']")
	public WebElement DD_RoomNumberForSplitResv;

	//@FindBy(css="button#srBtnSelectRoom-button")
	@FindBy(xpath="//button[@id='srBtnSelectRoom-button']")
	public WebElement Btn_Split;

	@FindBy(css="div#PanelSplitRes>div.ft>table>tbody>tr")   //div#PanelSplitRes>div.ft>table>tbody>tr //div.ft>table>tbody>tr
	public List<WebElement> Detail_forSplittedRes;

	@FindBy(xpath="//div[@class='col-4']//span")
	public WebElement Txt_RoomTypeforResvbeingSplit;

	@FindBy(css="div#sr-calContainerPopup>table>tbody>tr>td>a")
	public List<WebElement> Link_AllActiveDateTillCheckOut;

	@FindBy(xpath="//button[@id='qrBtnBlock-button']")
	public WebElement btn_TempReserve;

	@FindBy(xpath="//div[@class='shead-border']//div[3]/a")
	public static WebElement txt_temp1;

	@FindBy(xpath="//div[@class='shead-border']//div[4]/a/u")
	public WebElement txt_temp2;

	@FindBy(xpath="//div[@class='shead-border']//div[3]/a")
	public WebElement link_tempRsv;
	
	


	

	public void fn_RightClickCheckin() throws Exception{
		try{
			GenericMethods.clickElement(rightClk_CheckIN);
			Thread.sleep(3000);
			GenericMethods.ActionOnAlert("Accept");
			Thread.sleep(1000);
			GenericMethods.ActionOnAlert("Accept");
			WebDriverWait wait=new WebDriverWait(GenericMethods.driver, 60);
			//			if(wait.until(ExpectedConditions.alertIsPresent())!=null){
			//				GenericMethods.ActionOnAlert("Accept");
			//			}
		}catch(UnhandledAlertException e){
			Thread.sleep(3000);
			GenericMethods.ActionOnAlert("Accept");
		}catch(Exception e){
			throw e;
		}
	}

	public void fn_ClickOnAutoNightAudit() throws Exception{
		try{
			GenericMethods.fn_ActionsClick(Btn_AutoNightAudit);
		}catch(Exception e){
			GenericMethods.js_Click(Btn_AutoNightAudit);
		}
	}

	public int fn_splitReservation() throws Exception{
		try{
			GenericMethods.clickElement(Btn_SplitReservation);
			GenericMethods.clickElement(Icon_ToDateForSplitReservation);
			Link_AllActiveDateTillCheckOut.get((0)).click();
			String roomType=GenericMethods.getText(Txt_RoomTypeforResvbeingSplit);
			Thread.sleep(2000);
			GenericMethods.selectElement(DD_RoomTypeForSplitResv, roomType);
			Thread.sleep(2000);
			GenericMethods.selectElementByIndex(DD_RoomNumberForSplitResv, 1);
			Thread.sleep(2000);
			GenericMethods.clickElement(Btn_Split);
			Thread.sleep(2000);
			int splittedDayz=GenericMethods.tr_count(Detail_forSplittedRes);
			Thread.sleep(1000);
			return splittedDayz;
		}catch(Exception e){
			throw e;
		}
	}



	public ViewDetailsPage fn_ClickOnViewDetailLink() throws Exception{
		try{
			GenericMethods.clickElement(Link_ViewDetails);
		}catch(Exception e){
			throw e;
		}
		ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
		return VDP;
	}



	public CheckinCard fn_GroupCheckIn() throws Exception{
		try{
			GenericMethods.clickElement(Link_groupCheckIn);	
			GenericMethods.ActionOnAlert("Accept");
			Thread.sleep(2000);
		}catch(UnhandledAlertException e){
			Thread.sleep(4000);
			GenericMethods.ActionOnAlert("Accept");
		}		catch(Exception e){			
			throw e;
		}
		CheckinCard CC=PageFactory.initElements(GenericMethods.driver, CheckinCard.class);
		return CC;
	}



	public FrontdeskLandingPage fn_performAutoNightAudit() throws Exception{
		try{
			GenericMethods.clickElement(Btn_AutoNightAudit);
			Thread.sleep(2000);
		}
		catch(Exception e){
			throw e;
		}
		FrontdeskLandingPage FP=PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
		return FP;
	}


	public FrontdeskLandingPage fn_refreshFrontdesk() throws Exception{
		try{
			GenericMethods.driver.navigate().refresh();	
			Thread.sleep(2000);
		}catch(Exception e){
			throw e;
		}
		FrontdeskLandingPage FP=PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
		return FP;
	}

	public void fn_ApplyDNRToRoom(WebElement ele,String cDNR) throws Exception{
		try{
			fn_rightClickOnReservation(ele);
			Thread.sleep(2000);
			GenericMethods.js_Click(Link_DNR);
			Thread.sleep(2000);
			headerDNR=GenericMethods.getText(Header_DNRPopUp).trim();
			Thread.sleep(2000);
			GenericMethods.js_Sendkey(TxtBX_CommentsForDNR, cDNR);
			Thread.sleep(2000);
			GenericMethods.js_Click(Btn_SubmitDNR);
		}
		catch(Exception e){
			throw e;
		}
	}

	public String fn_verifyRoomDNR(String title) throws Exception{
		WebElement ele1=null;
		String resStatus=null;
		try{
			ele1=GenericMethods.driver.findElement(By.xpath("//div[@title='"+title+"']"));
			Thread.sleep(2000);
			resStatus=ele1.getAttribute("rsvstatus").toString().trim();
		}catch(Exception e){
			throw e;
		}
		return resStatus;

	}



	public WebElement fn_selectRoomForDNR(String roomName) throws Exception{
		WebElement ele=null;
		try{
			System.out.println("AddRoomsPage.roomNumber::::::::"+AddRoomsPage.roomNumber);
			List<WebElement> al=GenericMethods.driver.findElements(By.xpath("//div[contains(@id,'rmtypehide')]/div"));
			int size=al.size();
			for(int i=size;i>=0;i--)
			{
			String text=	GenericMethods.driver.findElement(By.xpath("//div[contains(@id,'rmtypehide')]/div["+i+"]")).getText();
			System.out.println("Text came as::::::"+text);
			if(text.contains(AddRoomsPage.roomNumber))
			{
				ele=GenericMethods.driver.findElement(By.xpath("//div[contains(@id,'rmtypehide')]/div["+i+"]"));
				break;
			}
			}
			//ele=GenericMethods.driver.findElement(By.xpath("//div[@title='"+AddRoomsPage.roomNumber+"']"));
			Thread.sleep(2000);
			String id=ele.getAttribute("id");
			Thread.sleep(2000);
			GenericMethods.javascriptScroll(ele);
			GenericMethods.driver.findElement(By.xpath("//div[@id='"+id+"']/div")).click();
			Thread.sleep(2000);
		}catch(Exception e){
			throw e;
		}
		return ele;
	}

	public WebElement fn_getWebElementUsingXpath(String xpathStringFormat) throws Exception{
		WebElement ele=null;
		try{
			ele=GenericMethods.driver.findElement(By.xpath(xpathStringFormat));	
			Thread.sleep(2000);
		}catch(Exception e){
			throw e;
		}
		return ele;
	}


	public CheckinCard fn_groupCheckIn() throws Exception{
		try{
			GenericMethods.clickElement(Link_groupCheckIn);
			GenericMethods.ActionOnAlert("Accept");
		}catch(UnhandledAlertException e){
			Thread.sleep(2000);
			GenericMethods.ActionOnAlert("Accept");
		}catch(Exception e){
			throw e;
		}
		CheckinCard CC=PageFactory.initElements(GenericMethods.driver, CheckinCard.class);
		return CC;

	}

	public GroupViewDetailPage fn_clickOnViewDetailLink() throws Exception{
		try{
			GenericMethods.clickElement(Link_ViewDetails);	
		}catch(Exception e){
			throw e;
		}
		GroupViewDetailPage GVD=PageFactory.initElements(GenericMethods.driver, GroupViewDetailPage.class);
		return GVD;
	}

	public AccountsLandingPage fn_clickOnAccountsLink() throws Exception{
		try{
			GenericMethods.clickElement(Link_AccountsFD);
		} catch(Exception e){
			throw e;
		}
		AccountsLandingPage ALP=PageFactory.initElements(GenericMethods.driver, AccountsLandingPage.class);
		return ALP;
	}


	public ViewDetailsPage ClickOnViewDetailsLink() throws Exception{
		try{
			GenericMethods.clickElement(Link_ViewDetails);
		}catch(Exception e){
			throw e;
		}
		ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);	
		return VDP;
	}



	public AccountStatementLandingPage ClickOnPayment() throws Exception{
		try{
			GenericMethods.clickElement(Link_Payments);	
		}catch(Exception e){
			throw e;
		}
		AccountStatementLandingPage ASL=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
		return ASL;
	}


	public String getRateFromViewPane() throws Exception{
		String a=null;
		try{
			String pri=GenericMethods.getText(Text_RateViewPopup);
			if(pri.contains(",")==true){
				String pric []=pri.split(",");
				a=pric[0].toString().substring(3, pric[0].length()) + pric[1].toString().substring(0, pric[1].length()-1).trim();
				Thread.sleep(2000);
				TotalCharge=Float.parseFloat(a);
				System.out.println("Res Per night Price is"+ a);
			}else{
				a=pri.substring(3,pri.length()).trim();
				Thread.sleep(2000);
				TotalCharge=Float.parseFloat(a);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return a;
	}


	public ViewDetailsPage ClickOnViewlink() throws Exception{
		try{
			GenericMethods.clickElement(Btn_View);
		}catch(Exception e){
			throw e;
		}
		ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
		return VDP;
	}


	public BasePage fn_NavigateAdmineConsole() throws Exception {
		try{
			GenericMethods.js_Click(Link_profile);
			GenericMethods.js_Click(Link_AdmineConsole);
		} catch(Exception e) {
			Thread.sleep(2000);
			GenericMethods.js_Click(Link_AdmineConsole);
		}
		BasePage BP=PageFactory.initElements(GenericMethods.driver, BasePage.class);
		return BP;
	}


	public void fn_clickCurrentLnk() throws Exception{
		try{
			GenericMethods.js_Click(Current_Link);
			Thread.sleep(4000);
		}catch(Exception e){
			throw e;
		}
	}


	public String verifyTitle() throws Exception{
		String title=null;
		try{
			title=GenericMethods.driver.getTitle();
		}catch(Exception e){
			throw e;
		}
		return title;
	}




	public void VerifyDNRPopUp() throws Exception
	{
		try
		{
			Actions a=new Actions(GenericMethods.driver).contextClick(RoomForDNR);
			a.build().perform();
			a.click(DNROption).build().perform();
			//String t=GenericMethods.getText(DNRPopUpTitle);
			//Assert.assertEquals(t.contains("DNR Room#"), true);
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


	public void fn_ClickOnCancelButton() throws Exception
	{
		GenericMethods.clickElement(Cancel_BT);
		GenericMethods.ActionOnAlert("Accept");
		//GenericMethods.driver.findElement(By.xpath("//td[@id='cal1Container_t_cell16']/a")).click();
		Assert.assertEquals(GenericMethods.driver.getTitle(), "Frontdesk");
	}

	public ReservationSearchResultLandingPage fn_SearchByReservationID(String rid) throws Exception
	{
		try
		{
			Actions acobj= new Actions(GenericMethods.driver);
			Thread.sleep(2000);
			acobj.sendKeys(Search_ED, rid).build().perform();
			//GenericClass.sendKeys(Search_ED, ReservationID);
			GenericMethods.clickElement(Search_CB);
			//GenericMethods.clickElement(SearchAll_BT);
			ReservationSearchResultLandingPage RSLP=PageFactory.initElements(GenericMethods.driver, ReservationSearchResultLandingPage.class);
			return RSLP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public ViewDetailsPage fn_rightclkViewDetailsSingle(WebElement resrvId ) throws Exception
	{

		Actions action = new Actions(GenericMethods.driver);
		action.contextClick(resrvId).build().perform();
		GenericMethods.clickElement(rightClk_viewDetails);
		ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
		return VDP;
	}


	public SampleRestaurantPage ClickToSampleRestaurant() throws Exception
	{
		WebElement ele=GenericMethods.driver.findElement(By.xpath("//ul[@class='first-of-type']//li[3]/a"));
		String str=GenericMethods.getText(ele);
		if(str.equals("Sample Restaurant")||str.equals("Hlx_Restaurant"))
		{
			GenericMethods.clickElement(ele);
		}
		SampleRestaurantPage SRL=PageFactory.initElements(GenericMethods.driver,SampleRestaurantPage.class );
		return SRL;

	}


	public String fn_ClickCancelButton() throws Exception{
		String title=null;
		try{
			//Thread.sleep(2000);
			GenericMethods.clickElement(Cancel_BT);
			//Thread.sleep(4000);
			GenericMethods.Alert_Accept();
			GenericMethods.clickElement(Current_Link);
			//Thread.sleep(2000);
			title=GenericMethods.driver.getTitle();
		} catch(Exception e) {
			GenericMethods.driver.navigate().refresh();
			//Thread.sleep(2000);
			GenericMethods.clickElement(Cancel_BT);
			GenericMethods.Alert_Accept();
			GenericMethods.clickElement(Current_Link);
			//Thread.sleep(2000);
			title=GenericMethods.driver.getTitle();
		}
		return title;
	}


	public void fn_ClickCancelButtonAlert() throws Exception
	{

		GenericMethods.clickElement(Cancel_BT);
		GenericMethods.Alert_Accept();
		Assert.assertEquals(GenericMethods.driver.getTitle(), "Frontdesk");

	}


	public void fn_verifyNightAuditAlert() throws InterruptedException
	{
		String str=GenericMethods.getText(nightaudit);
		Assert.assertEquals(str, "Perform Night Audit");
	}


	public ReservationSearchResultLandingPage  fn_SearchReservationID(String rid) throws Exception{
		try{
			Thread.sleep(2000);
			GenericMethods.js_Sendkey(Search_ED, rid);
			GenericMethods.js_Click(Search_CB);
			//GenericMethods.clickElement(SearchAll_BT);
		}catch(Exception e){
			throw e;
		}
		ReservationSearchResultLandingPage RSLP=PageFactory.initElements(GenericMethods.driver, ReservationSearchResultLandingPage.class);
		return RSLP;
	}

	public CheckinCard fn_clkCheckin(WebElement ele) throws Exception{
		try{
			GenericMethods.clickElement(Link_CheckIn);
			Thread.sleep(2000);
			GenericMethods.ActionOnAlert("Accept");
			GenericMethods.AcceptAlertAfterValidate();
		}catch(Exception e){
			throw e;
		}
		CheckinCard CC=PageFactory.initElements(GenericMethods.driver, CheckinCard.class);
		return CC;
	}


	public void fn_cancelCheckin() throws Exception
	{
		Actions action = new Actions(GenericMethods.driver);
		action.contextClick(resrvId).build().perform();
		Thread.sleep(1000);
		//String a=GenericMethods.GetCurrentWindowID();
		GenericMethods.clickElement(rightClk_cnclcheckin);
		GenericMethods.ActionOnAlert("Accept");
		Thread.sleep(4000);
	}



	public void fn_closeCheckinCard() throws Exception
	{
		//String a=GenericMethods.GetCurrentWindowID();
		Actions action = new Actions(GenericMethods.driver);
		action.contextClick(resrvId).build().perform();
		GenericMethods.clickElement(rightClk_checkIn);
		GenericMethods.ActionOnAlert("Accept");
		Thread.sleep(4000);
		//GenericMethods.windowHandle(a);
		Thread.sleep(2000);
		//GenericMethods.js_Click(checkinCard_closeBtn);
		//GenericMethods.Switch_Parent_Window(a);
	}

	public void fn_verifyCnclCheckinPopup() throws Exception{
		try{
			Actions action = new Actions(GenericMethods.driver);
			action.contextClick(resrvId).build().perform();
			GenericMethods.clickElement(rightClk_cnclcheckin);
			String str=GenericMethods.ActionOnAlert("Dismiss");
			Thread.sleep(4000);
			Assert.assertEquals(str, "Do you wish to Unassign the reservation?");
		}catch(AssertionError e){
			throw e;
		}catch(Exception e){
			throw e;
		}
	}


	public void fn_acceptCnclCheckinPopup() throws Exception
	{
		try
		{
			Actions action = new Actions(GenericMethods.driver);
			action.contextClick(resrvId).build().perform();
			GenericMethods.clickElement(rightClk_cnclcheckin);
			GenericMethods.ActionOnAlert("Accept");
			Thread.sleep(4000);
			action.contextClick(resrvId).build().perform();
			String str=GenericMethods.getText(rightClk_checkIn);
			Assert.assertEquals(str, "Check In");
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


	public void fn_verifyCheckinPopup() throws Exception
	{
		try
		{
			Actions action = new Actions(GenericMethods.driver);
			action.contextClick(resrvId).build().perform();
			GenericMethods.clickElement(rightClk_checkIn);
			String str1=GenericMethods.ActionOnAlert("Dismiss");

			Assert.assertTrue(str1.contains(exp_msg));
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

	public ViewDetailsPage fn_rightclkViewDetailsGrp() throws Exception
	{
		Actions action = new Actions(GenericMethods.driver);
		action.contextClick(grpResrvID).build().perform();
		GenericMethods.clickElement(rightClk_viewDetails);
		ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
		return VDP;
	}

	public ViewDetailsPage fn_GrpAddOn() throws Exception
	{
		Actions action = new Actions(GenericMethods.driver);
		action.contextClick(GroupReservation_ID).build().perform();
		GenericMethods.clickElement(rightClk_viewDetails);
		ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
		return VDP;
	}



	public ViewDetailsPage fn_GrpAddNewRoom() throws Exception
	{
		try
		{
			Actions action = new Actions(GenericMethods.driver);
			action.contextClick(GroupReservation_ForAddNewR).build().perform();
			GenericMethods.clickElement(rightClk_viewDetails);
			Thread.sleep(3000);
			ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
			return VDP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public ViewDetailsPage fn_GrpNoShow() throws Exception
	{
		try
		{
			Actions action = new Actions(GenericMethods.driver);
			action.contextClick(GrpReservID_NoShow).build().perform();
			GenericMethods.clickElement(rightClk_viewDetails);
			Thread.sleep(3000);
			ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
			return VDP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public ViewDetailsPage fn_GrpDiscount() throws Exception
	{
		try
		{
			Actions action = new Actions(GenericMethods.driver);
			action.contextClick(GrpReserID_Discount).build().perform();
			GenericMethods.clickElement(rightClk_viewDetails);
			Thread.sleep(3000);
			ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
			return VDP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}



	public ViewDetailsPage fn_GrpManageSharer() throws Exception
	{
		try
		{
			Actions action = new Actions(GenericMethods.driver);
			action.contextClick(GrpReservID_ManageSharer).build().perform();
			GenericMethods.clickElement(rightClk_viewDetails);
			Thread.sleep(3000);
			ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
			return VDP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public AccountStatementLandingPage fn_NavigateAccountStmt() throws Exception
	{
		try
		{
			Actions action = new Actions(GenericMethods.driver);
			action.contextClick(resrvId2).build().perform();
			GenericMethods.clickElement(rightClk_Payment);
			AccountStatementLandingPage ASP=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
			return ASP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public AccountStatementLandingPage fn_NavigatePayment() throws Exception
	{
		Actions action = new Actions(GenericMethods.driver);
		action.contextClick(ReservID_dpk).build().perform();
		GenericMethods.clickElement(rightClk_Payment);
		AccountStatementLandingPage ASP=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
		return ASP;
	}


	public AccountStatementLandingPage fn_NavigatePayment1() throws Exception
	{
		Actions action = new Actions(GenericMethods.driver);
		action.contextClick(ReserveID_TTR).build().perform();
		GenericMethods.clickElement(rightClk_Payment);
		AccountStatementLandingPage ASP=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
		return ASP;
	}

	public AccountStatementLandingPage fn_NavigatePayment2() throws Exception
	{
		try
		{
			Actions action = new Actions(GenericMethods.driver);
			action.contextClick(reservID_Payment).build().perform();
			GenericMethods.clickElement(rightClk_Payment);
		}
		catch(Exception e)
		{
			throw e;
		}
		AccountStatementLandingPage ASP=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
		return ASP;

	}


	public CheckinCard fn_rightClkGrpCheckin() throws Exception
	{
		try
		{
			Actions action = new Actions(GenericMethods.driver);
			action.contextClick(grpResrvID2).build().perform();
			GenericMethods.clickElement(grpcheckin);
			GenericMethods.ActionOnAlert("Accept");
		}catch(UnhandledAlertException e){
			Thread.sleep(2000);
			GenericMethods.ActionOnAlert("Accept");
		}catch(Exception e){
			throw e;
		}
		CheckinCard CC=PageFactory.initElements(GenericMethods.driver, CheckinCard.class);
		return CC;
	}

	public ViewDetailsPage fn_rightclkViewDetailsGrp1() throws Exception
	{
		try
		{
			Actions action = new Actions(GenericMethods.driver);
			action.contextClick(grpResrvID2).build().perform();
			GenericMethods.clickElement(rightClk_viewDetails);
			ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
			return VDP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public ViewDetailsPage fn_rightClkViewDetailsGrp2() throws Exception
	{
		try
		{
			Actions action = new Actions(GenericMethods.driver);
			action.contextClick(grpResrvID3).build().perform();
			GenericMethods.clickElement(rightClk_viewDetails);
			ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
			return VDP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public void fn_rightClkCancelCheckinGrp() throws Exception
	{
		Actions action = new Actions(GenericMethods.driver);
		action.contextClick(grpResrvID2).build().perform();
		GenericMethods.clickElement(rightClk_cnclcheckin);
		String str=GenericMethods.ActionOnAlert("Dismiss");
		Thread.sleep(4000);
		Assert.assertEquals(str, "Do you wish to Unassign the reservation?");

	}


	public void fn_AcceptCancelCheckinGrp() throws Exception
	{
		try
		{
			Actions action = new Actions(GenericMethods.driver);
			action.contextClick(grpResrvID2).build().perform();
			GenericMethods.clickElement(rightClk_cnclcheckin);
			GenericMethods.ActionOnAlert("Accept");
			Thread.sleep(4000);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public AccountStatementLandingPage fn_NavigateAccntstmtGenerateFolio() throws Exception
	{
		Actions action = new Actions(GenericMethods.driver);
		action.contextClick(grpResrvID1).build().perform();
		GenericMethods.clickElement(rightClk_Payment);
		AccountStatementLandingPage ASP=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
		return ASP;
	}

	public static WebReservationHomePage fn_WebReservationLink() throws Exception
	{
		try
		{
			GenericMethods.clickElement(WebReservation_Link);
			WebReservationHomePage WRP = PageFactory.initElements(GenericMethods.driver, WebReservationHomePage.class);
			return WRP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public static AdminLoginPage fn_AdminLink() throws Exception
	{
		GenericMethods.clickElement(Admin_lnk);
		AdminLoginPage ALO = PageFactory.initElements(GenericMethods.driver, AdminLoginPage.class);
		return ALO;
	}


	public BasePage fn_clkAdminLnk() throws Exception
	{
		try
		{
			GenericMethods.clickElement(Admin_lnk);
			BasePage BP = PageFactory.initElements(GenericMethods.driver, BasePage.class);
			return BP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public AccountStatementLandingPage fn_NavigateAccntStmtGrp() throws Exception
	{
		try
		{
			Actions action = new Actions(GenericMethods.driver);
			action.contextClick(grpResrvID3).build().perform();
			GenericMethods.clickElement(rightClk_Payment);
			AccountStatementLandingPage ASP=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
			return ASP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public AccountStatementLandingPage fn_NavigateAccntStmtGrp1() throws Exception
	{
		Actions action = new Actions(GenericMethods.driver);
		action.contextClick(checkoutDueResrv).build().perform();
		GenericMethods.clickElement(rightClk_Payment);
		AccountStatementLandingPage ASP=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
		return ASP;
	}



	public LiveSupportLandingWindow fn_ClickLiveSupportButton() throws Exception
	{

		try
		{
			GenericMethods.clickElement(LiveSupport_BT);
			LiveSupportLandingWindow SRP = PageFactory.initElements(GenericMethods.driver, LiveSupportLandingWindow.class);
			return SRP;
		}

		catch(Exception e)
		{
			throw e;
		}

	}



	public ViewDetailsPage fn_RightclkSingles(WebElement ID, WebElement Link) throws Exception
	{
		try
		{
			//GenericMethods.clickElement(Current_Link);
			Actions action = new Actions(GenericMethods.driver);
			action.contextClick(ID).build().perform();
			GenericMethods.clickElement(Link);
			GenericMethods.ActionOnAlert("Accept");

			ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
			return VDP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public ViewDetailsPage fn_RightclkSingle(WebElement ID, WebElement Link) throws Exception
	{
		try
		{
			GenericMethods.clickElement(Current_Link);
			Actions action = new Actions(GenericMethods.driver);
			Thread.sleep(3000);
			action.contextClick(ID).build().perform();
			GenericMethods.clickElement(Link);
			GenericMethods.ActionOnAlert("Accept");

			ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
			return VDP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public ViewDetailsPage fn_rightclkViewDetailsSingle(WebElement ID, WebElement Link) throws Exception
	{
		try
		{
			GenericMethods.clickElement(Current_Link);
			Actions action = new Actions(GenericMethods.driver);
			action.contextClick(ID).build().perform();
			GenericMethods.clickElement(Link);

			ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
			return VDP;
		}
		catch(Exception e)
		{
			throw e;
		}

	}

	public void fn_GroupCheckIN() throws Exception
	{

		try
		{
			Thread.sleep(2000);
			GenericMethods.clickElement(ContinueToCheckIn_BT);
		}
		catch(Exception e)
		{
			throw e;
		}

	}


	public ReportLandingPage fn_ReportButton() throws Exception
	{
		try
		{
			GenericMethods.clickElement(Report_BT);
			ReportLandingPage BP = PageFactory.initElements(GenericMethods.driver, ReportLandingPage.class);
			return BP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public WebReservationHomePage ClickOnWebReservation() throws Exception
	{
		try
		{
			GenericMethods.clickElement(WebReservation_Link);
			WebReservationHomePage WRC=PageFactory.initElements(GenericMethods.driver,WebReservationHomePage.class);
			return WRC;
		}
		catch(Exception e)
		{
			throw e;
		}

	}


	public NightAuditLandingPage fn_AutoNightAudit() throws Exception
	{
		try
		{
			GenericMethods.js_Click(AutoNightAuditBtn);
			NightAuditLandingPage NAP=PageFactory.initElements(GenericMethods.driver, NightAuditLandingPage.class);
			return NAP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public void fn_AutoNightAudit1() throws Exception
	{
		try
		{
			GenericMethods.js_Click(AutoNightAuditBtn);
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public void fn_RefreshFrontdesk() throws Exception
	{


		GenericMethods.driver.navigate().refresh();
		if(Cancel_BT.isDisplayed()==true)
		{
			GenericMethods.clickElement(Cancel_BT);
			GenericMethods.ActionOnAlert("Accept");
		}
		else
		{
			System.out.println("Alert is not found");
		}

	}



	public NightAuditLandingPage fn_ClickPerformNightAudit_Link() throws Exception
	{
		try
		{
			GenericMethods.mouseOverElement(Frontdesk_BT);
			GenericMethods.js_Click(PerformNightAudit_Link);


		}
		catch(Exception e)
		{
			e.getMessage();
		}

		NightAuditLandingPage NAP=PageFactory.initElements(GenericMethods.driver, NightAuditLandingPage.class);
		return NAP;

	}



	public void fn_SetDNRDate() throws Exception
	{

		try{
			GenericMethods.clickElement(FromCal_DNRPopUp);
			GenericMethods.clickElement(DateInCal_DNRPopUp);
			GenericMethods.clickElement(ToCal_DNRPopUp);
			GenericMethods.clickElement(DateInCal_DNRPopUp);
			GenericMethods.sendKeys(TextBox_DNRPopUp, "Test");
			//GenericMethods.clickElement(Submit_DNRPopUp);
		}catch(Exception e){
			throw e;
		}
	}

	public void fn_DeleteDNR() throws Exception{

		try{
			GenericMethods.clickElement(DNR_Reservation);
			Thread.sleep(2000);
			GenericMethods.clickElement(DeleteIcon_DNRPopUp);
			GenericMethods.clickElement(OKbutton_DNRPopUp);
			Thread.sleep(5000);
		}catch(Exception e){
			throw e;
		}
	}


	//
	//
	//    public void fn_ValidateDNRPopUp_Title() throws Exception
	//    {
	//
	//      	 try
	//      	 {
	//      	  // String str= GenericMethods.getText(DNR_PopUp);
	//      	  // Assert.assertEquals(str, "DNR Room#209");
	//      	 }
	//      	 catch(Exception e)
	//      	 {
	//      		 throw e;
	//      	 }
	//           }

	public void fn_ValidateDNR_PopUp(WebElement roomNum, WebElement link) throws Exception
	{

		try
		{
			GenericMethods.clickElement(Current_Link);
			Thread.sleep(5000);
			GenericMethods.clickElement(Rooms_CB);
			Actions action = new Actions(GenericMethods.driver);
			action.contextClick(roomNum).build().perform();

			GenericMethods.clickElement(link);
		}
		catch(Exception e)
		{
			throw e;
		}

	}


	public BasePage fn_NavigateAdminConsole()
	{
		Actions act = new Actions(GenericMethods.driver);
		act.moveToElement(FrontdeskLandingPage.Admin_lnk).contextClick().sendKeys("T").perform();
		act.sendKeys(Keys.chord(Keys.CONTROL,Keys.TAB)).perform();
		GenericMethods.driver.switchTo().defaultContent();
		BasePage BP=PageFactory.initElements(GenericMethods.driver, BasePage.class);
		return BP;

	}





	public void WindowScroll() throws Exception{
		try{
			JavascriptExecutor jsx = (JavascriptExecutor)GenericMethods.driver;
			Thread.sleep(2000);
			jsx.executeScript("scroll(0, 700)");
		}catch(Exception e){
			throw e;
		}
	}


	public void windowScrollUp(){
		JavascriptExecutor jsx = (JavascriptExecutor)GenericMethods.driver;
		jsx.executeScript("scroll(0, -550)");

	}

	public EnableEditingPage fn_clkSingleLnk() throws Exception
	{
		GenericMethods.clickElement(singleLnk);
		Thread.sleep(7000);
		EnableEditingPage EEP=PageFactory.initElements(GenericMethods.driver, EnableEditingPage.class);
		return EEP;

	}

	public EnableEditingPage fn_clkGroupLnk() throws Exception
	{
		GenericMethods.clickElement(groupLnk);
		Thread.sleep(7000);
		EnableEditingPage EEP=PageFactory.initElements(GenericMethods.driver, EnableEditingPage.class);
		return EEP;

	}


	public EnableEditingPage fn_clkAgntCorpLnk() throws Exception
	{
		GenericMethods.clickElement(ag_corp_Lnk);
		Thread.sleep(7000);
		EnableEditingPage EEP=PageFactory.initElements(GenericMethods.driver, EnableEditingPage.class);
		return EEP;

	}



	public void fn_clickOnNewlyCreatedReservation(){
		WebElement ele1=GenericMethods.driver.findElement(By.cssSelector("div.rs-new"));
		Boolean b=ele1.isDisplayed();
		System.out.println(b);
		String ele=ele1.getAttribute("class");
		if(b.equals(true))
		{
			System.out.println("Reservation has been successfully saved on tapechart");
			ele1.click();
		}

		else
		{
			System.out.println("Reservation failed");
		}
	}




	public void fn_verifyReservation() throws Exception
	{
		WebElement ele1=null;
		
			//Thread.sleep(8000);
			//GenericMethods.driver.navigate().refresh();
			//fn_ClickCancelButton();
			
			int attempts = 0;
			   while(attempts < 2) {
			try{
				System.out.println("No of attempts:"+attempts);
				ele1=GenericMethods.driver.findElement(By.cssSelector("div.rs-new"));
				System.out.println("Aage badh gaya");
				
				(new WebDriverWait(GenericMethods.driver, 10000)).until(ExpectedConditions.visibilityOf(ele1));
					
				resvId=ele1.getAttribute("resrvid");
					System.out.println("resvId::"+resvId);
					
					Thread.sleep(1000);
					title=ele1.getAttribute("title");
					Thread.sleep(1000);
					System.out.println("title is " + title);
					
					System.out.println("Stale explicit wait crossed");
				//GenericMethods.ExplicitWait_stale(ele1);
				Boolean b=ele1.isDisplayed();
				
				System.out.println(b);
				//String ele=ele1.getAttribute("class");
				/*Thread.sleep(1000);
				
				resvId=ele1.getAttribute("resrvid");
				System.out.println("resvId::"+resvId);
				Thread.sleep(1000);
				title=ele1.getAttribute("title");
				Thread.sleep(1000);
				System.out.println("title is " + title);*/
				if(b.equals(true)){
					System.out.println("Reservation has been successfully saved on tapechart");
				}
				else{
					System.out.println("Reservation failed");
				}
			break; 
			} catch(StaleElementReferenceException  e) {
			//throw e; 
			e.printStackTrace();
			}
			catch(Exception e){
			throw e;

			}
			attempts++;
			   }
			
			
		}
	



	public WebElement  getWebElement(String rid) throws Exception{
		WebElement ele=null;
		try{
			Thread.sleep(5000);
			System.out.println("Reserve ID is _ " + rid);
			Thread.sleep(3000);
			ele=GenericMethods.driver.findElement(By.xpath("//div[@resrvid='"+rid+"']"));
			resTitle=GenericMethods.driver.findElement(By.xpath("//div[@resrvid='"+rid+"']")).getAttribute("title");
			System.out.println("resTitle in getwebelement method"+resTitle);
			Thread.sleep(4000);
		}catch(UnhandledAlertException e){
			Thread.sleep(1000);
			System.out.println("Reserve ID is _ " + rid);
			Thread.sleep(3000);
			ele=GenericMethods.driver.findElement(By.xpath("//div[@resrvid='"+rid+"']"));
			resTitle=GenericMethods.driver.findElement(By.xpath("//div[@resrvid='"+rid+"']")).getAttribute("title");
			Thread.sleep(4000);
			GenericMethods.ActionOnAlert("Accept");
		}catch(Exception e){
			throw e;
		}
		return ele;
	}





	public void fn_rightClickOnReservation(WebElement ele) throws Exception{
		
			int attempts = 0;
			   while(attempts < 2) {
				   try{
					  // GenericMethods.javascriptScroll(GenericMethods.driver.findElement(By.xpath("//div[@resrvid='"+FrontdeskLandingPage.resvId+"']")));
		System.out.println("No of Attempts::"+attempts);
			Thread.sleep(3000);
			new WebDriverWait(GenericMethods.driver, 10).until(ExpectedConditions.elementToBeClickable(ele));
			Actions action = new Actions(GenericMethods.driver);
			
			action.contextClick(ele).build().perform();
			break;
		}catch (StaleElementReferenceException e){
			Thread.sleep(3000);
			Actions action = new Actions(GenericMethods.driver);
			System.out.println("FrontdeskLandingPage.resvId in right click method stale catch:"+FrontdeskLandingPage.resvId);
			action.contextClick(GenericMethods.driver.findElement(By.xpath("//div[@resrvid='"+FrontdeskLandingPage.resvId+"']"))).build().perform();
			break;
		}catch(WebDriverException e){
			Actions action = new Actions(GenericMethods.driver);
			System.out.println("FrontdeskLandingPage.resvId in webdriver exception catch:"+FrontdeskLandingPage.resvId);
			action.contextClick(GenericMethods.driver.findElement(By.xpath("//div[@resrvid='"+FrontdeskLandingPage.resvId+"']"))).build().perform();
		}
				   attempts++;
			   }
			   attempts++;   
	}





	public void fn_verifyResFromDetailPage() throws Exception{
		try{
			WebElement ele1=GenericMethods.driver.findElement(By.cssSelector("div.rs-new"));
			Boolean b=ele1.isDisplayed();
			System.out.println(b);
			ele1.getAttribute("class");
			if(b.equals(true)) {
				System.out.println("Reservation has been successfully saved on tapechart");
				ele1.click();
			} else
			{
				System.out.println("Reservation failed");
			}
		}
		catch(Exception e){

			throw e;
		}
	}


	public CheckinCard fn_verifyReservAndCheckin() throws Exception
	{
		WebElement ele1=GenericMethods.driver.findElement(By.cssSelector("div.rs-new"));
		Boolean b=ele1.isDisplayed();
		System.out.println(b);
		ele1.getAttribute("class");
		if(b.equals(true))
		{
			System.out.println("Reservation has been successfully saved on tapechart");
			Actions obj=new Actions(GenericMethods.driver);
			obj.contextClick(ele1).build().perform();
			GenericMethods.clickElement(grpcheckin);
			GenericMethods.ActionOnAlert("Accept");
		}
		else
		{
			System.out.println("Reservation failed");
		}

		Thread.sleep(6000);
		CheckinCard CC=PageFactory.initElements(GenericMethods.driver, CheckinCard.class);
		return CC;
	}



	public  ViewDetailsPage fn_clkViewBtn() throws Exception
	{
		GenericMethods.clickElement(viewBtn);
		ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
		return VDP;
	}


	public void fn_verifyAddQuickResrvTitle() throws InterruptedException{
		Thread.sleep(2000);
		String text=GenericMethods.getText(addQuickResrv);
		Assert.assertEquals(text, "Add Quick Reservation");
	}


	public ViewDetailsPage fn_RightclkforViewDetailsPage(WebElement ID, WebElement Link) throws Exception{
		//GenericMethods.clickElement(Current_Link);
		Actions action = new Actions(GenericMethods.driver);
		action.moveToElement(ID).contextClick().build().perform();
		GenericMethods.js_Click(Link);
		GenericMethods.ActionOnAlert("Accept");

		ViewDetailsPage VDP=PageFactory.initElements(GenericMethods.driver, ViewDetailsPage.class);
		return VDP;
	}


	public AddQuickReservationForm fn_createFDReserv(String roomtype,String from,String to) throws InterruptedException{
		try{
			Thread.sleep(3000);
			List<WebElement> ele=GenericMethods.driver.findElements(By.xpath("//div[starts-with(@id,'rthead')]"));
			int RTsize=ele.size();
			for(int j=0;j<=RTsize-1;j++){
				int k=j+1;
				String str=ele.get(j).getText().trim();
				System.out.println(str);
				if(str.equals(roomtype)) {
					System.out.println("In If of room type match");
					Assert.assertEquals(str, roomtype);
					WebElement ele2= GenericMethods.driver.findElement(By.xpath("(//div[@class='rtype'])["+k+"]//div[contains(@id,'crossblock')]["+from+"]"));
					System.out.println(GenericMethods.driver.findElement(By.xpath("(//div[@class='rtype'])["+k+"]//div[contains(@id,'crossblock')]["+from+"]")));
					Rectangle rect=ele2.getRect();
					System.out.println("x from rect class is::"+rect.getX()+"and y from rect class is"+rect.getY());
					System.out.println("width from rect class is::"+rect.getWidth()+"and height from rect class is"+rect.getHeight());
					
				
					int x=	ele2.getLocation().getX();
					int y=  ele2.getLocation().getY();
					System.out.println("value of x is::"+x+"::and value of y is :::"+y);
					//x=x+5;
					WebElement ele3= GenericMethods.driver.findElement(By.xpath("(//div[@class='rtype'])["+k+"]//div[contains(@id,'crossblock')]["+to+"]"));
					System.out.println(GenericMethods.driver.findElement(By.xpath("(//div[@class='rtype'])["+k+"]//div[contains(@id,'crossblock')]["+to+"]")));
					rect=ele3.getRect();
				int	x3=rect.getX();
				int	y3=rect.getY();
				
				System.out.println("x3::::"+x3+"y3:::::"+y3);
					
					
					Actions act=new Actions(GenericMethods.driver);
					//act.moveByOffset(x+30, y).click().build().perform();
					System.out.println("after click call");
					if(to.equals("3"))
					{
						System.out.println("Value of to is::"+to);
						act.moveToElement(ele2).moveByOffset(x-240, 0).clickAndHold().moveToElement(ele3,x3-240,0).release().build().perform();
					}
					else if(to.equals("4"))
					{
						System.out.println("Value of to is::"+to);
						act.moveToElement(ele2).moveByOffset(x-240, 0).clickAndHold().moveToElement(ele3,x3-270,0).release().build().perform();
					}
					else if(to.equals("5"))
					{
						System.out.println("Value of to is::"+to);
						act.moveToElement(ele2).moveByOffset(x-240, 0).clickAndHold().moveToElement(ele3,x3-300,0).release().build().perform();
					}
					else if(to.equals("6"))
					{
						System.out.println("Value of to is::"+to);
						act.moveToElement(ele2).moveByOffset(x-240, 0).clickAndHold().moveToElement(ele3,x3-330,0).release().build().perform();
					}
					
					else
					{
						System.out.println("in last else case");
						
					}
				//	act.moveToElement(ele2).moveByOffset(x-240,0).click().build().perform();
				//	act.moveToElement(ele2).moveByOffset(x-240, 0).clickAndHold().moveToElement(ele3).release().build().perform();
				//	act.moveToElement(ele2).moveByOffset(x-240, 0).dragAndDropBy(ele3, x-210, 0).release().build().perform();
					//act.moveToElement(ele2).moveByOffset(x-240, 0).clickAndHold().moveToElement(ele3,x3-270,0).release().build().perform();
					//act.cl
					/*act.clickAndHold(ele2)
							.moveToElement(ele3)
							.release(ele3)
							.build().perform();
					*///act.dragAndDrop(ele2, ele3).build().perform(); 
					System.out.println("value of x passing in method:::"+x);
					//act.dragAndDropBy(ele2, x-210, y);
					
				}
			}
			
			
			
			/*Thread.sleep(6000);
			List<WebElement> ele=GenericMethods.driver.findElements(By.xpath("//div[starts-with(@id,'rthead')]"));
			
			int RTsize=ele.size();
			System.out.println(RTsize);
			for(int j=0;j<=RTsize-1;j++){
				int k=j+1;
				String str=ele.get(j).getText().trim();
				System.out.println("Name came for the rtype element is:::"+str);
				if(str.trim().equals(roomtype)) {
					Assert.assertEquals(str, roomtype);
					Thread.sleep(6000);
					WebElement ele2= GenericMethods.driver.findElement(By.xpath("(]"));
					Thread.sleep(6000);
					WebElement ele3= GenericMethods.driver.findElement(By.xpath("(//div[@class='rtype'])["+k+"]//div[contains(@id,'cross//div[@class='rtype'])["+k+"]//div[contains(@id,'crossblock')]["+from+"block')]["+to+"]"));
					Actions act=new Actions(GenericMethods.driver);
					act.dragAndDrop(ele2, ele3).build().perform(); 
					Thread.sleep(6000);
				}
			*/
		}catch(Exception e){
			System.out.println("In fd reserve catch block");
			Thread.sleep(3000);
			List<WebElement> ele=GenericMethods.driver.findElements(By.xpath("//div[starts-with(@id,'rthead')]"));
			int RTsize=ele.size();
			for(int j=0;j<=RTsize-1;j++){
				int k=j+1;
				String str=ele.get(j).getText().trim();
				System.out.println(str);
				if(str.trim().equals(roomtype)) {
					Assert.assertEquals(str, roomtype);
					WebElement ele2= GenericMethods.driver.findElement(By.xpath("(//div[@class='rtype'])["+k+"]//div[contains(@id,'crossblock')]["+from+"]"));
					System.out.println(GenericMethods.driver.findElement(By.xpath("(//div[@class='rtype'])["+k+"]//div[contains(@id,'crossblock')]["+from+"]")));
					WebElement ele3= GenericMethods.driver.findElement(By.xpath("(//div[@class='rtype'])["+k+"]//div[contains(@id,'crossblock')]["+to+"]"));
					System.out.println(GenericMethods.driver.findElement(By.xpath("(//div[@class='rtype'])["+k+"]//div[contains(@id,'crossblock')]["+to+"]")));
					Actions act=new Actions(GenericMethods.driver);
					act.dragAndDrop(ele2, ele3).build().perform(); 
				}
			}
		}
		AddQuickReservationForm AQF=PageFactory.initElements(GenericMethods.driver, AddQuickReservationForm.class);
		return AQF;
	}

	public CloseCashCounterPage fn_clkCloseCashCounter() throws Exception {
		try {
			GenericMethods.js_Click(Link_profile);
			Thread.sleep(3000);
			GenericMethods.clickElement(link_CloseCashCounter);
		}catch(Exception e) {
			throw e;
		}

		CloseCashCounterPage CCP=PageFactory.initElements(GenericMethods.driver, CloseCashCounterPage.class);
		return CCP;
	}
	

	public void fn_verifyTempReserve(String expValue) throws Exception {
		try {
			
			System.out.println(expValue);
			System.out.println("hi");
			System.out.println("hi2");		
			Thread.sleep(7000);
			txt_temp1.click();	
			System.out.println("hi3");
			 expValue = expValue.substring(0,1).toUpperCase() + expValue.substring(1);
			 System.out.println("NEW String:"+expValue);
			//String text=txt_temp1.getText();			
			 WebElement TempVerify = GenericMethods.driver.findElement(By.xpath("//table[@id='roomPoTableId']/tbody/tr/td[contains(text(),'"+expValue+"')]"));
			//WebElement TempVerify = driver.findElement(By.xpath("//table[@id='roomPoTableId']/tbody/tr[2]/td[contains(text(),'"+expValue+"')]"));		 
			String actual = TempVerify.getText();		
			System.out.println(actual);		
			Assert.assertTrue(actual.contains(expValue));	
			System.out.println("Temp Resv Exists");
			/*String text2=txt_temp2.getText();
			System.out.println(text2);
			Assert.assertEquals(text2.contains(expValue), true);*/
			//link_tempRsv.click();
		}catch(AssertionError e) {
			throw e;
		}catch(Exception e) {
			throw e;
		}
		//TempRoomList TRL=PageFactory.initElements(GenericMethods.driver, TempRoomList.class);
		//return TRL;

	}
}




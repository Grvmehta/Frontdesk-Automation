package com.hotelogix.smoke.FrontdeskTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotelogix.smoke.admin.BaseClass.AdmineHome;
import com.hotelogix.smoke.admin.roommanager.RoomsLandingPage;
import com.hotelogix.smoke.admin.roommanager.AddRoomsPage;
import com.hotelogix.smoke.frontdesk.CashCounter.CashCounterPage;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.FrontdeskLandingPage;
import com.hotelogix.smoke.frontdesk.FrontdeskTrialPage.FrontdeskContinueTrialPage;
import com.hotelogix.smoke.genericandbase.BasePage;
import com.hotelogix.smoke.genericandbase.GenericMethods;
import com.hotelogix.smoke.login.FrontdeskLoginPage;

public class TapeChartTestSpanish
{


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


	@Test(priority=1)
    public void TC_31() throws Exception
    {
   	    FrontdeskLoginPage AL=new FrontdeskLoginPage();
	    AL.Frontdesklogin_13009();
	    FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	    CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
//	    FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
//		FLP.fn_ClickCancelButton();
//        FLP.fn_clickCurrentLnk();
//        FLP.fn_NavigateAdminConsole();
//        BasePage.roomsPageNevigate();
//        RoomsLandingPage.click_AddRoom();
//        SaveRoomsPage SRP=new SaveRoomsPage();
//        SRP.AddRoomTypeName();
//        RoomsLandingPage RLP=new RoomsLandingPage();
//        RLP.fn_NavigateFrontdesk();
//		GenericMethods.driver.navigate().refresh();
//		FLP.fn_ClickCancelButton();
//        FLP.fn_clickCurrentLnk();
//        FLP.getCountOfRooms1();
//        FLP.WindowScroll();
//        FLP.fn_SingleResrvTwoRoomNT();
//        FLP.fn_verifyAddQuickResrvTitle();
        //FLP.fn_fillAddQuickResrv();
        //Thread.sleep(20000);
        System.out.println("TC_31 Executed");

    }








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

package com.hotelogix.smoke.FrontdeskTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hotelogix.smoke.frontdesk.CashCounter.CashCounterPage;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.AddQuickReservationForm;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.FrontdeskLandingPage;
import com.hotelogix.smoke.frontdesk.FrontdeskTrialPage.FrontdeskContinueTrialPage;
import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;
import com.hotelogix.smoke.hmsadmine.login.HmsadmineHomePage;
import com.hotelogix.smoke.hmsadmine.login.HmsadmineLogin;
import com.hotelogix.smoke.hmsadmine.login.HotelsNewPage;
import com.hotelogix.smoke.hmsadmine.login.ImportCsvPage;
import com.hotelogix.smoke.login.FrontdeskLoginPage;

public class HMSAdmineTest {
	
	private String rtype = "Deluxe";
	private String sTestCaseName;
	private int iTestCaseRow;
	public static ArrayList<String> a1 = new ArrayList<String>();
	public static ArrayList<String> gd = new ArrayList<String>();
	public static HashMap<String,Integer> hm=null;
	public static HashMap<String,Integer> hm1=null;
	FrontdeskContinueTrialPage FCT = new FrontdeskContinueTrialPage();
	private FrontdeskLoginPage AL;
	private FrontdeskLandingPage FP;

	private HmsadmineLogin HL;
	private HmsadmineHomePage HP;
	
	String fileName="sampleRsv111";
	@BeforeTest
	public void LaunchApp() throws Throwable {
		

		sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
				Constant.Sheet_Frontdesk3);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
		//hm=ExcelUtil.creatingCollectionofTestcaseNames();
		//iTestCaseRow=hm.get(sTestCaseName);
		String br = ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Browser));
		try {
			ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AppURL));
			GenericMethods.fn_OpenFrontdesk(br,
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AppURL)));
			Thread.sleep(10000);
			HL = new HmsadmineLogin();
			HL.HMSAdmineLogin(iTestCaseRow);
			/*FrontdeskContinueTrialPage CP = new FrontdeskContinueTrialPage();
			Thread.sleep(2000);
			CashCounterPage CCP = CP.fn_ClickCountinueWithTrail_BT();
			Thread.sleep(2000);
			FP = CCP.fn_ClickContinueButton();
*/
		} catch (Throwable e) {
			//Thread.sleep(4000);
			System.out.println("System is showing problem during login");
		e.printStackTrace();	
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
	
	@DataProvider(name="datafromexcel")
	public Object[][] datafromexcel() throws Exception
	{
	/*Object[] arr= hm.keySet().toArray();
	Object[] arr1=hm.values().toArray();
int len=	arr.length;
	int len1=arr1.length;
	
	Object[][] result=new Object[len][len1];
	for(int i=0;i<arr.length;i++)
	{
		
	
	
	}*/
	hm1=ExcelUtil.creatingCollectionofTestcaseNamesWithout1stRow();
		Object[][] arr = new Object[hm1.size()][2];
		Set entries = hm1.entrySet();
		Iterator entriesIterator = entries.iterator();

		int i = 0;
		while(entriesIterator.hasNext()){

		    Map.Entry mapping = (Map.Entry) entriesIterator.next();

		    arr[i][0] = mapping.getKey();
		    arr[i][1] = mapping.getValue();
		    System.out.println( "Key::"+arr[i][0]);
		    System.out.println( "value::"+arr[i][1]);
		    

		    i++;
		}
		
		
		return arr;
		
		
	
	
	
	}
	

	@Test(dataProvider="datafromexcel")
	public void fn_uploadingExcelFile(String sTestCaseName,int iTestCaseRow ) throws Throwable {// TC_31_32_33
		try {

			//sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_livestableFrontdeskTestData,
					Constant.Sheet_Frontdesk3);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
	//	Iterator i1=	hm.entrySet().iterator();
		/*for (Map.Entry mapElement : hm.entrySet()) {
            String key = (String)mapElement.getKey();
            sTestCaseName=key;
            System.out.println("key:::"+key);*/
			//iTestCaseRow=	hm.get(sTestCaseName);
			
				
				System.out.println("Itestcaserow is;::"+iTestCaseRow);
			HP=new HmsadmineHomePage();
			HP.clickOnHotelsNew();
			
			HotelsNewPage HNP=new HotelsNewPage();
			
			HNP.searchHotelId(iTestCaseRow);
		int iValue	=HNP.validatingHotel(iTestCaseRow);
			HNP.clickingOnImportRsv(iValue);
			
			
			ImportCsvPage ICP=new ImportCsvPage();
			
			ICP.clickingChooseFile(iTestCaseRow,fileName);
			//ICP.handlingFileUpload();
			
			//Assert.assertEquals(true, false);
			/*FP.fn_ClickCancelButton();
			Thread.sleep(6000);
			AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
			Thread.sleep(6000);
			FP = AQRP.FillQuickResForm(iTestCaseRow);
			FP.fn_verifyReservation();
			System.out.println("TC_31_32_33 Executed");
			Reporter.log("2 night single reservation created.", true);*/
			
		}catch (Throwable e) {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}


}

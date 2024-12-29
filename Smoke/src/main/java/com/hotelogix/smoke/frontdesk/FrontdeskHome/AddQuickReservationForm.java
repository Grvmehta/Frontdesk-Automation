package com.hotelogix.smoke.frontdesk.FrontdeskHome;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;


public class AddQuickReservationForm {
	
	
	
	
	
	
	public String fname;
	public String lname;
	public String phno;
	public String email;
	public String  pakFrontdesk;
	public float TotalCharge;
	
	public float chargePerNight;
	
	
	//@FindBy(xpath="//div[@id='PanelQuickRes_h']//table/tbody/tr/td[1]")
	@FindBy(xpath="//div[@id='PanelQuickRes_h']")
	public WebElement Text_FormTitle;
	
	
	
	
	@FindBy(xpath="//div[@id='lblRoomName']")
	public WebElement Text_RoomTypeName;
	
	
	@FindBy(xpath="//div[@id='PanelQuickRes_h']/table/tbody/tr/td[4]/input")
	public WebElement CB_AssignRoom;
	
	@FindBy(xpath="//div[@id='PanelQuickRes']/a")
	public WebElement Btn_CloseForm;
	
	
	
	@FindBy(xpath="//span[@id='qrDuration']")
	public WebElement Text_BookingDuration;
	
	
	@FindBy(xpath="//select[@id='qrSelAdult']")
	public WebElement DD_Adult;
	
	@FindBy(xpath="//select[@id='qrSelChildren']")
	public WebElement DD_Child;
	
	@FindBy(xpath="//select[@id='qrSelRateType']")
	public WebElement DD_RateType;
	
	@FindBy(xpath="//select[@id='noofRooms1']")
	public WebElement DD_Rooms;
	
	
	
	@FindBy(xpath="//select[@id='salutation']")
	public WebElement DD_Salutation;
	
	@FindBy(xpath="//input[@id='qrTxtFirstName']")
	public WebElement TxtBx_FirstName;
	
	@FindBy(xpath="//input[@id='qrTxtLastName']")
	public WebElement TxtBx_LastName;
	
	
	@FindBy(xpath="//input[@id='qrTxtPhone']")
	public WebElement TxtBx_Phone;
	
	
	@FindBy(xpath="//input[@id='rdPhAssign1']")
	public WebElement RB_Mobile;
	
	@FindBy(xpath="//input[@id='rdPhAssign2']")
	public WebElement RB_Teleph;
	
	
	
	@FindBy(xpath="//input[@id='qrEmail']")
	public WebElement TxtBx_EmailId;
	
	
	@FindBy(xpath="//div[@id='qrCCLinks']/table/tbody/tr/td/a[1]")
	public WebElement Link_CreditCardGuarantee;
	
	@FindBy(xpath="//span[@id='spnDeposit']")
	public WebElement Link_Deposit;
	
	
	@FindBy(xpath="//input[@id='chkBxkHold']")
	public WebElement CB_HoldTill;
	
	
	@FindBy(xpath="//button[@id='qrBtnBlock-button']")
	public WebElement Btn_TempReserve;
	
	@FindBy(xpath="//button[@id='qrBtnReserve-button']")
	public WebElement Btn_Reserve;
	
	
	@FindBy(xpath="//button[@id='qrBtnCheck-In-button']")
	public WebElement Btn_CheckIn;
	
	
	@FindBy(xpath="//a[@id='lnkQResFormSingleEnab']")
	public WebElement Link_SingleRes;
	
	//@FindBy(xpath="//div[@id='PanelQuickRes']/div[3]/table/tbody/tr/td[3]/a[3]")
	@FindBy(xpath="//a[@producttrialsel='CREATE_GROUP']")
	public WebElement Link_GroupRes;
	
	
	//@FindBy(xpath="//div[@id='PanelQuickRes']/div[3]/table/tbody/tr/td[3]/a[4]")
	@FindBy(xpath="//a[@producttrialsel='CREATE_TA_CORP']")
	public WebElement Link_AgentCorporate;
	
	//@FindBy(xpath="//span[@id='resPricePn']")
	@FindBy(xpath="//div[@id='resPricePn']")
	public WebElement Text_ResPerNPrice;
	
	
	@FindBy(xpath="//div[@id='resPrice']")
	public WebElement Text_TotalPrice;
	
	
	@FindBy(xpath="//button[@id='qrBtnHold-button']")
	public WebElement chkbx_HoldTill;

	@FindBy(xpath="//i[@id='grImgCal2']")
	public WebElement img_calendar;

	@FindBy(xpath="//button[text()='Hold']")
	public WebElement btn_Hold;

	@FindBy(xpath="//input[@id='chkQAssignRm']")
	public WebElement chkbx_Assign;
	
	@FindBy(xpath="//div[@id='sr-calContainerPopup']/table/tbody/tr/td/a")
	public WebElement link_holdTillDate;
	
	@FindBy(xpath="//select[@id='txtReleaseHH']")
	public WebElement drpdwn_hr;
	
	@FindBy(xpath="//select[@id='txtReleaseMM']")
	public WebElement drpdwn_min;
	
	@FindBy(xpath="//select[@id='txtReleaseAP']")
	public WebElement drpdwn_AP;
	
	
public String GetTotalPrice() throws Exception{
String b=null;
try{
	Thread.sleep(4000);
	String price=GenericMethods.getText(Text_TotalPrice);
	
	if(price.contains(",")==true){
		String pri []=price.split(",");
		Thread.sleep(2000);
		 b=pri[0].toString().substring(3, pri[0].length()) + pri[1].toString().substring(0, pri[1].length());
		 Thread.sleep(2000);
		 TotalCharge=Float.parseFloat(b);
		System.out.println("Res Per night Price is"+ b);
		
		
	}
	else{
		Thread.sleep(1000);
		b=price.substring(3,price.length()).trim();
		Thread.sleep(2000);
		TotalCharge=Float.parseFloat(b);
		
	}
	}
	catch(Exception e){
	
		throw e;
	}
	

	return b;
	
	
}






public String GetPrice() throws Exception{
		String a=null;
		try{
			
			
			Thread.sleep(4000);
		String price=GenericMethods.getText(Text_ResPerNPrice);
		
 		if(price.contains(",")==true){
			String pri []=price.split(",");
			String str=pri[0].toString();
			 a=pri[0].toString().substring(3, pri[0].length()) + pri[1].toString().substring(0, pri[1].length()-1).trim();
			 chargePerNight=Float.parseFloat(a);
			System.out.println("Res Per night Price is"+ a);
			
			
		}
		else{
			
			a=price.substring(3,price.length()-1).trim();
			Thread.sleep(2000);
			chargePerNight=Float.parseFloat(a);
			
		}
		}
		catch(Exception e){
			
			throw e;
		}
		

		return a.trim();
	}
	
	
public FrontdeskLandingPage FillQuickResForm(int iTestCaseRow) throws Exception{
	try{
	
	fname=	GenericMethods.generateRandomString();
	lname=GenericMethods.generateRandomString();
	phno=GenericMethods.generateRandomString();
	email=GenericMethods.generateRandomString();
	//Thread.sleep(2000);
	
	GenericMethods.selectElement(DD_Adult, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AdultForRes)));
	GenericMethods.selectElement(DD_Child, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ChildForRes)));
	GenericMethods.selectElement(DD_RateType, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ResRateType)));
	GenericMethods.selectElement(DD_Rooms, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomsToBook)));
	GenericMethods.selectElement(DD_Salutation, "Mr.");
	
	GenericMethods.sendKeys(TxtBx_FirstName, fname);
	GenericMethods.sendKeys(TxtBx_LastName,lname);	
	GenericMethods.sendKeys(TxtBx_Phone,  phno);
	email=email+"@gmail.com";
	
	GenericMethods.sendKeys(TxtBx_EmailId, email);
	 GenericMethods.clickElement(Btn_Reserve);
	 Thread.sleep(2000);
		}catch(Exception e){
			throw e;
		}
	  FrontdeskLandingPage FP=PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
	  return FP;
	}


public SingleReservationPage FillQuickResvForm(int iTestCaseRow) throws Exception{
	try{
fname=	GenericMethods.generateRandomString();
lname=GenericMethods.generateRandomString();
phno=GenericMethods.generateRandomString();
email=GenericMethods.generateRandomString();
GenericMethods.selectElement(DD_Adult, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AdultForRes)));
Thread.sleep(2000);
GenericMethods.selectElement(DD_Child, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ChildForRes)));
Thread.sleep(2000);
GenericMethods.selectElement(DD_RateType, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ResRateType)));
Thread.sleep(2000);
GenericMethods.selectElement(DD_Rooms, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomsToBook)));
Thread.sleep(2000);
GenericMethods.selectElement(DD_Salutation, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Salutation)));
Thread.sleep(2000);
GenericMethods.sendKeys(TxtBx_FirstName, fname);
Thread.sleep(2000);
GenericMethods.sendKeys(TxtBx_LastName,lname);	
Thread.sleep(2000);
GenericMethods.sendKeys(TxtBx_Phone,  phno);
Thread.sleep(2000);
email=email+"@gmail.com";
GenericMethods.sendKeys(TxtBx_EmailId, email);
Thread.sleep(2000);
 GenericMethods.clickElement(Link_SingleRes);
 Thread.sleep(8000);
	}
	catch(Exception e){
	
		throw e;
	}
SingleReservationPage SRP=PageFactory.initElements(GenericMethods.driver, SingleReservationPage.class);
return SRP;

}


public GroupReservationPage FillQuickResvsForm(int iTestCaseRow,WebElement eleToClick) throws Exception{
	try{
fname=	GenericMethods.generateRandomString();
lname=GenericMethods.generateRandomString();
phno=GenericMethods.generateRandomString();
email=GenericMethods.generateRandomString();
Thread.sleep(1000);
GenericMethods.selectElement(DD_Adult, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AdultForRes)));
Thread.sleep(1000);
GenericMethods.selectElement(DD_Child, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ChildForRes)));
//Thread.sleep(2000);
GenericMethods.selectElement(DD_RateType, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ResRateType)));
//Thread.sleep(2000);
GenericMethods.selectElement(DD_Rooms, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomsToBook)));
Thread.sleep(2000);
GenericMethods.selectElement(DD_Salutation, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Salutation)));
Thread.sleep(2000);
GenericMethods.sendKeys(TxtBx_FirstName, fname);
//Thread.sleep(2000);
GenericMethods.sendKeys(TxtBx_LastName,lname);	
Thread.sleep(2000);
GenericMethods.sendKeys(TxtBx_Phone,  phno);
//Thread.sleep(2000);
email=email+"@gmail.com";
GenericMethods.sendKeys(TxtBx_EmailId, email);
//Thread.sleep(2000);
GenericMethods.clickElement(eleToClick);
Thread.sleep(8000);
}
catch(Exception e){

throw e;
}
	
GroupReservationPage SRP=PageFactory.initElements(GenericMethods.driver, GroupReservationPage.class);
return SRP;

}

	
	

public FrontdeskLandingPage FillQuickResvsFormBySelectingPak(int iTestCaseRow,String packg) throws Exception{
	try{
fname=	GenericMethods.generateRandomString();
lname=GenericMethods.generateRandomString();
phno=GenericMethods.generateRandomString();
email=GenericMethods.generateRandomString();
Thread.sleep(2000);
GenericMethods.selectElement(DD_Adult, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AdultForRes)));
Thread.sleep(2000);
GenericMethods.selectElement(DD_Child, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ChildForRes)));
Thread.sleep(2000);
GenericMethods.selectElement(DD_RateType, packg);
Thread.sleep(2000);
GenericMethods.selectElement(DD_Rooms, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomsToBook)));
Thread.sleep(2000);
GenericMethods.selectElement(DD_Salutation, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Salutation)));
Thread.sleep(2000);
GenericMethods.sendKeys(TxtBx_FirstName, fname);
Thread.sleep(2000);
GenericMethods.sendKeys(TxtBx_LastName,lname);	
Thread.sleep(2000);
GenericMethods.sendKeys(TxtBx_Phone,  phno);
Thread.sleep(2000);
email=email+"@gmail.com";
GenericMethods.sendKeys(TxtBx_EmailId, email);
Thread.sleep(2000);
 GenericMethods.clickElement(Btn_Reserve);
Thread.sleep(2000);
	}
	catch(Exception e){
	
		throw e;
	}
FrontdeskLandingPage FP=PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
return FP;

}

	
/*public  void GetPackage(boolean res,int iTestCaseRow) throws Exception{
if(res==true){
	
	Select s=new Select(DD_RateType);
	Thread.sleep(2000);
	s.selectByVisibleText(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)));
	Thread.sleep(2000);
		
	
}

else{
	
}

}*/
	








public boolean CheckPackage(int iTestCaseRow ) throws Exception{
	boolean b=false;
	try{
	Select s=new Select(DD_RateType);
	List<WebElement> li=s.getOptions();
	for(int i=1;i<=li.size();i++){
		String pakname=li.get(i).getText();
		if(pakname.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)))){
			b=true;
			break;
		}
	   }
	}catch(Exception e){
		throw e;
	}
	    return b;
       }


public String GetSelectedPackage(String name) throws Exception {
	String txt=null;
	
	try{		
	Select s=new Select(DD_RateType);
	Thread.sleep(2000);
	List<WebElement> li=s.getOptions();
	for(WebElement we :li){
		if(we.getText().contains(name)){
			s.selectByVisibleText(we.getText());
		}
		
	}
	
	Thread.sleep(2000);
	txt=s.getFirstSelectedOption().getText();
	
	}
	catch(Exception e){
	
		throw e;
	}
	
	return txt;
}


public String getAddQuickResTitle(){
	String tit=null;
try{
String title=GenericMethods.getText(Text_FormTitle);
if(title.contains("How to use?")){
	 tit=title.substring(0, title.indexOf("Ho")-1).trim();
	 Reporter.log("Environment is live", true);
}
else{
	tit=GenericMethods.getText(Text_FormTitle).trim();
}
}
catch(Exception e){
e.printStackTrace();
}
	
return tit;
}
	
public void FillQuickResvsFormAssign(int iTestCaseRow,WebElement eleToClick) throws Exception{
	try{
fname=	GenericMethods.generateRandomString();
lname=GenericMethods.generateRandomString();
phno=GenericMethods.generateRandomString();
email=GenericMethods.generateRandomString();
Thread.sleep(1000);
GenericMethods.selectElement(DD_Adult, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AdultForRes)));
Thread.sleep(2000);
GenericMethods.selectElement(DD_Child, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ChildForRes)));
Thread.sleep(2000);
GenericMethods.selectElement(DD_RateType, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ResRateType)));
Thread.sleep(2000);
GenericMethods.selectElement(DD_Rooms, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomsToBook)));
Thread.sleep(2000);
GenericMethods.selectElement(DD_Salutation, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Salutation)));
Thread.sleep(2000);
GenericMethods.sendKeys(TxtBx_FirstName, fname);
Thread.sleep(2000);
GenericMethods.sendKeys(TxtBx_LastName,lname);	
Thread.sleep(2000);
GenericMethods.sendKeys(TxtBx_Phone,  phno);
Thread.sleep(2000);
email=email+"@gmail.com";
GenericMethods.sendKeys(TxtBx_EmailId, email);
Thread.sleep(2000);
GenericMethods.clickElement(chkbx_Assign);
GenericMethods.clickElement(eleToClick);
Thread.sleep(2000);
}
catch(Exception e){

throw e;
}


}


public void FillQuickResvsFormHoldTill(int iTestCaseRow,WebElement eleToClick) throws Exception{
	try{
fname=	GenericMethods.generateRandomString();
System.out.println(fname);
lname=GenericMethods.generateRandomString();
phno=GenericMethods.generateRandomString();
email=GenericMethods.generateRandomString();
Thread.sleep(1000);
GenericMethods.selectElement(DD_Adult, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AdultForRes)));
Thread.sleep(2000);
GenericMethods.selectElement(DD_Child, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ChildForRes)));
Thread.sleep(2000);
GenericMethods.selectElement(DD_RateType, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ResRateType)));
Thread.sleep(2000);
GenericMethods.selectElement(DD_Rooms, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomsToBook)));
Thread.sleep(2000);
GenericMethods.selectElement(DD_Salutation, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Salutation)));
Thread.sleep(2000);
GenericMethods.sendKeys(TxtBx_FirstName, fname);
Thread.sleep(2000);
GenericMethods.sendKeys(TxtBx_LastName,lname);	
Thread.sleep(2000);
GenericMethods.sendKeys(TxtBx_Phone,  phno);
Thread.sleep(2000);
email=email+"@gmail.com";
GenericMethods.sendKeys(TxtBx_EmailId, email);
Thread.sleep(2000);
GenericMethods.clickElement(chkbx_HoldTill);
//GenericMethods.clickElement(eleToClick);
Thread.sleep(2000);
}
catch(Exception e){

throw e;
}


}



public void fn_selectHoldTillDate() throws Exception {
	try {
	GenericMethods.clickElement(img_calendar);
	GenericMethods.clickElement(link_holdTillDate);
	Formatter fmt = new Formatter();
    Calendar cal = Calendar.getInstance();
    System.out.println("current date: " + cal.getTime());    
    Date date = new Date();
    date=cal.getTime();  
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
    String dt= dateFormat.format(date);  
    System.out.println(dt);
    System.out.println("Hi");
    String[] arr=dt.split(" ");
    System.out.println(arr);
    String[] arr1=arr[1].split(":");
    System.out.println(arr1);
    Integer mt=Integer.parseInt(arr1[1]);
    //if(mt>55)
        if(mt>59) {
    	Integer i=Integer.parseInt(arr1[0]);
    	int hr=i+1;
    	String str=Integer.toString(hr);
    	System.out.println(str);
    	GenericMethods.selectElement(drpdwn_hr, str);
    	Thread.sleep(500);
    	GenericMethods.selectElement(drpdwn_min, arr1[1]);
    	Thread.sleep(500);
    	GenericMethods.selectElement(drpdwn_AP, arr[2]);
    	Thread.sleep(500);
    }else{
        GenericMethods.selectElement(drpdwn_hr, arr1[0]);
        
        System.out.println(arr1[0]);
        Thread.sleep(5000);
        GenericMethods.selectElement(drpdwn_min, "55");
        Thread.sleep(500);
        GenericMethods.selectElement(drpdwn_AP, arr[2]);
    }
        GenericMethods.clickElement(btn_Hold); 
        System.out.println("Jump to Verfiy");
        //Thread.sleep(500);

	}catch(Exception e) {
		throw e;
	}
	
}
}

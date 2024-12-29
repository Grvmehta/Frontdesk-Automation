package com.hotelogix.smoke.frontdesk.ViewDetailsPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.hotelogix.smoke.frontdesk.Payment.AccountStatementLandingPage;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.SampleRestaurantPage;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class GroupToSingleReservationPage {


@FindBy(xpath="//table[@class='pnl_rates']//input[@type='checkbox']")
public static List<WebElement> AllTaxesToExempt;

@FindBy(xpath="//td[@class='lineheight size13']//span[2]")
public static WebElement Name;





@FindBy(xpath="//table[@class='table-cellspacing-patch']//tr")
public static List<WebElement> rowcount;



@FindBy(xpath="//table[@id='tblRoomSharers']//tr")
public static List<WebElement> sharerTable;

@FindBy(xpath="//input[@value='Cancel Check-in']")
public static WebElement cancelCheckin;

@FindBy(xpath="//input[@id='btnUnCheckIn']")
public static WebElement CancelCheckIn_BT;

@FindBy(xpath="//input[@name='btnSngResPayment']")
public  WebElement paymentBtn;

@FindBy(xpath="(//a[@id='linkRoomSharerDate1'])[2]")
public static WebElement CheckInDateOfSecondGuest_Link;

@FindBy(xpath="//div[@id='sr-calContainerPopup']//table//tbody//a")
public static List<WebElement> CheckInDateOfSGCalender_TB;

@FindBy(xpath="//a[@id='linkRoomSharerDate2']")
public static WebElement CheckOutDateOfSGDate;



@FindBy(xpath="//select[@id='extraBeds']")
public static WebElement ExtraBed_DD;

@FindBy(xpath="//input[@id='srTxtFirstName']")
public static WebElement GuestFirstName_ED;

@FindBy(xpath="//input[@id='srTxtLastName']")
public static WebElement GuestLastName_ED;

@FindBy(xpath="//input[@id='phoneNo']")
public static WebElement Phone_ED;

@FindBy(xpath="//input[@id='srTxtEmail']")
public static WebElement Email_ED;

@FindBy(xpath="//a[text()='Save & Add More']")
public static WebElement SaveAndMore_BT;

@FindBy(xpath="//button[@id='btnSave-button']")
public static WebElement GuestInformationSave_BT;

@FindBy(xpath="//input[@id='chkbxVipNo']")
public static WebElement VIP_CB;

@FindBy(xpath="//div[@class='edit-pencil-img']")
public static WebElement Pencil_IMG;

@FindBy(xpath="//fieldset[@id='fldstRoomExmptdTx']")
public static WebElement RoomTaxes_Link;

@FindBy(xpath="//input[@id='chkExmpt_0']")
public static WebElement RoomTaxCheckBox_InPopUp;

@FindBy(xpath="//button[@id='txBtnSave-button']")
public static WebElement RoomTaxOKButton_InPopUp;

@FindBy(xpath="(//a[@id='linkRoomSharerDate1'])")
public static WebElement CheckInDateOffirstGuest_Link;


@FindBy(xpath="//div[@id='sr-calContainerPopup']//table//tbody//a")
public static WebElement CheckInDateOfSGDate;


@FindBy(xpath="(//a[@id='linkRoomSharerDate2'])[2]")
public static WebElement CheckOutDateOfSGuestDate;

@FindBy(xpath="//select[@id='taxExmptReson']")
public static WebElement TaxExempt_DD;

@FindBy(xpath="//fieldset[@id='resLblRoomTariff']")
public static WebElement RoomRate;

@FindBy(xpath="//fieldset[@id='resLblBalance']")
public static WebElement TotalBalance;

@FindBy(xpath="//fieldset[@id='resLblRoomTaxes']")
public static  WebElement txt_RoomTax;

public static String EditName="Deepak";



public static String gname;
public static String text;

//-------------------------------------------------------------------------------------------------------------------------------------//



@FindBy(xpath="//select[@id='extraBeds']")
public WebElement DD_ExtraBed;

@FindBy(xpath="//input[@id='brnGroupSv']")
public  WebElement Btn_BackToGroup;

@FindBy(xpath="//a[@id='link-roomSharers']")
public WebElement Link_ManageSharer;

@FindBy(xpath="//div[@id='PanelRoomSharers_h']")
public WebElement Header_ManageSharer;

@FindBy(xpath="//select[contains(@id,'srSelTitle')]")
public WebElement DD_TitleName;

@FindBy(xpath="//input[contains(@id,'fName2')]")
public WebElement TxtBx_Fname;

@FindBy(xpath="//input[contains(@id,'lName2')]")
public WebElement TxtBx_Lname;

@FindBy(xpath="//input[contains(@id,'phoneNo2')]")
public WebElement TxtBx_phoneNo;

@FindBy(xpath="//input[@id='chargeSharer2']")
public WebElement CB_ChargeSharer;

@FindBy(xpath="//button[@id='rsBtnSave-button']")
public WebElement Btn_manageSharerSave;


@FindBy(xpath="//table[@id='tblRoomSharers']/tbody/tr")
public List<WebElement> AllGuestInRoom; 

@FindBy(xpath="//select[@id='resRoom']")
public WebElement DD_reservedRoom;

@FindBy(xpath="//input[@name='btnSngResPayment']")
public WebElement Btn_payment;

@FindBy(xpath="//a[contains(text(),'Restaurant')]")
public WebElement Link_Restaurant;






public ArrayList<String> al=new ArrayList<String>(Arrays.asList("gh", "ij", "123"));




public String selectedBed;
public String selectedBed1;
public String headerForManageSharer;
public String guestId;
public String guestFullName;
public String guestStayPeriod;
public String guestNightStay;
public String guestType;
public String chargeSharerGuest;






public AccountStatementLandingPage fn_clickOnPayment() throws Exception{
try{
GenericMethods.clickElement(Btn_payment);	
}
catch(Exception e){
throw e;
}
AccountStatementLandingPage ASL=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
return ASL;
}


public SampleRestaurantPage fn_ClickOnRestaurant() throws Exception{
try{
	GenericMethods.clickElement(Link_Restaurant);
}
catch(Exception e){
	throw e;
}
SampleRestaurantPage SRP=PageFactory.initElements(GenericMethods.driver, SampleRestaurantPage.class);
return SRP;
}


	public String fn_getReservedRoom() throws Exception{
		String resRoom=null;
	try{
	  resRoom=GenericMethods.fn_getDropdownSelectedValue(DD_reservedRoom).trim();
	}catch(Exception e){
	throw e;
	}
	return resRoom;
	}



public String[][] fn_getGuestAllDetailInArray() throws Exception{
	String dataTable[][]=null;
try{
	dataTable=new String [AllGuestInRoom.size()-1][6];
for(int i=2;i<=AllGuestInRoom.size();i++){
dataTable[i-2][i-2]=GenericMethods.driver.findElement(By.xpath("//table[@id='tblRoomSharers']/tbody/tr["+i+"]/td[1]")).getText().trim();
dataTable[i-2][(i-2)+1]=GenericMethods.driver.findElement(By.xpath("//table[@id='tblRoomSharers']/tbody/tr["+i+"]/td[2]")).getText().trim();
dataTable[i-2][(i-2)+2]=GenericMethods.driver.findElement(By.xpath("//table[@id='tblRoomSharers']/tbody/tr["+i+"]/td[3]")).getText().trim();
dataTable[i-2][(i-2)+3]=GenericMethods.driver.findElement(By.xpath("//table[@id='tblRoomSharers']/tbody/tr["+i+"]/td[4]")).getText().trim();
dataTable[i-2][(i-2)+4]=GenericMethods.driver.findElement(By.xpath("//table[@id='tblRoomSharers']/tbody/tr["+i+"]/td[5]")).getText().trim();
dataTable[i-2][(i-2)+5]=GenericMethods.driver.findElement(By.xpath("//table[@id='tblRoomSharers']/tbody/tr["+i+"]/td[6]")).getText().trim();
}
}
catch(Exception e){
	throw e;
}
return dataTable;
}

public ArrayList<String> fn_getGuestFirstNLastName(String nameString) throws Exception{
	 ArrayList<String> guestName=new ArrayList<String> ();
try{
		System.out.println("Name string came as:::"+nameString);
	String [] name=nameString.split("\\s+");
	String fname=name[1];
	String lname=name[2];
	guestName.add(fname);
	guestName.add(lname);
	System.out.println("fname is:::::::::"+fname);
	System.out.println("lname is:::::::::"+lname);
	
}
catch(Exception e){
throw e;
}
return guestName;
	
}


public void fn_getGuestAllDetail() throws Exception{
try{

guestId=GenericMethods.driver.findElement(By.xpath("//table[@id='tblRoomSharers']/tbody/tr[2]/td[2]")).getText().trim();
Thread.sleep(4000);
guestFullName=GenericMethods.driver.findElement(By.xpath("//table[@id='tblRoomSharers']/tbody/tr[2]/td[3]")).getText().trim();
System.out.println("guestFullName::::::::"+guestFullName);
Thread.sleep(3000);
//guestStayPeriod=GenericMethods.driver.findElement(By.xpath("//table[@id='tblRoomSharers']/tbody/tr[1]/td[4]")).getText().trim();
//Thread.sleep(700);
//guestNightStay=GenericMethods.driver.findElement(By.xpath("//table[@id='tblRoomSharers']/tbody/tr[1]/td[5]")).getText().trim();
//Thread.sleep(700);
GenericMethods.driver.findElement(By.xpath("//a[@id='link-roomSharers']")).click();

guestType=GenericMethods.driver.findElement(By.xpath("//table[@class='table table-striped table-hover']//tbody//tr[2]//td[7]")).getText().trim();
Thread.sleep(2000);
chargeSharerGuest=GenericMethods.driver.findElement(By.xpath("//table[@class='table table-striped table-hover']//tbody//tr[2]//td[6]//input")).getAttribute("value").trim();

GenericMethods.driver.findElement(By.xpath("//button[@id='rsBtnCancel-button']")).click();
}
catch(Exception e){
	throw e;
}
}


public void fn_addGuestDetail(ArrayList<String> al,String chargeSharing) throws Exception{
try{
if(chargeSharing.equalsIgnoreCase("Yes")){
GenericMethods.clickElement(CB_ChargeSharer);
headerForManageSharer=GenericMethods.getText(Header_ManageSharer).trim();
GenericMethods.selectElementByIndex(DD_TitleName, 1);
GenericMethods.js_Sendkey(TxtBx_Fname, al.get(0).toString());
GenericMethods.js_Sendkey(TxtBx_Lname, al.get(1).toString());
GenericMethods.js_Sendkey(TxtBx_phoneNo, al.get(2).toString());
}
else{
headerForManageSharer=GenericMethods.getText(Header_ManageSharer).trim();
GenericMethods.selectElementByIndex(DD_TitleName, 1);
GenericMethods.sendKeys(TxtBx_Fname, al.get(0).toString());
GenericMethods.sendKeys(TxtBx_Lname, al.get(1).toString());
GenericMethods.sendKeys(TxtBx_phoneNo, al.get(2).toString());
}
GenericMethods.clickElement(Btn_manageSharerSave);
Thread.sleep(3000);
}
catch(Exception e){
	throw e;
}
}


public GroupEnableEditingPage fn_clickOnBackToGroupBtn() throws Exception{
try{

	GenericMethods.clickElement(Btn_BackToGroup);
	
}
catch(Exception e){
throw e;
}
GroupEnableEditingPage GEE=PageFactory.initElements(GenericMethods.driver, GroupEnableEditingPage.class);
return GEE;
}

public void fn_setExtraBed(String numberOfBed) throws Exception{
try{

selectedBed=GenericMethods.fn_getDropdownSelectedValue(DD_ExtraBed);
Thread.sleep(2000);
GenericMethods.selectElement(DD_ExtraBed, numberOfBed);
Thread.sleep(2000);
selectedBed1=GenericMethods.fn_getDropdownSelectedValue(DD_ExtraBed);

	
}
catch(Exception e){
throw e;
}
}










public void CheckTaxExemptForRoom() throws Exception
{
	ArrayList<String> al=new ArrayList<String>();

	GenericMethods.clickElement(GenericMethods.driver.findElement(By.xpath("//fieldset[@id='fldstRoomExmptdTx']")));
	int count=GenericMethods.tr_count(AllTaxesToExempt)+1;
	for(int i=2;i<=count;i++)
	{
	String str=GenericMethods.driver.findElement(By.xpath("//table[@class='pnl_rates']//tr["+i+"]//td[3]//table//tr//td")).getText();
	String s2=str.substring(0, str.lastIndexOf("%"));
			al.add(s2);
	}
    GenericMethods.driver.findElement(By.xpath("//a[@class='container-close']")).click();
    GenericMethods.driver.findElement(By.xpath("//input[@value='Back To Group']")).click();

}

public void fn_verifyGuestName() throws Exception
{
	try
	{
	 String actualName=GenericMethods.getText(Name);
	 Assert.assertEquals(actualName, EnableEditingPage.gname);
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


public void fn_clkManageSharerLnk() throws Exception
{
	try
	{
	// text=GenericMethods.getText(manageSharer);
	// GenericMethods.js_Click(manageSharer);
	}
	catch(Exception e)
	{
		throw e;
	}
}


public void fn_verifyManageSharerTitle() throws Exception
{
	
	try
	{
	 //String text1=GenericMethods.getText(managerSharerWindow);
	// Assert.assertEquals(text1.equals("Manage Sharer(s)"), true);
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


public static String data;


public void fn_checkSharerGuest() throws Exception
{
	try
	{
	 int tr_count=GenericMethods.tr_count(rowcount);
	 for(int i=2;i<=tr_count;i++)
	 {
		 WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='table-cellspacing-patch']//tr["+i+"]//td[7]//input"));
		 data=GenericMethods.driver.findElement(By.xpath("//table[@class='table-cellspacing-patch']//tr["+i+"]//td[2]")).getText();
		 Boolean b=ele.isSelected();
		 if(b!=true)
		 {
			 Assert.assertEquals(ele.isSelected(), false);
			 ele.click();
			 break;
		 }

	 }
	 //GenericMethods.clickElement(managesharerSave);
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

public void fn_verifyManagerSharerYes() throws Exception
{
	try
	{
	ArrayList<String> arr=new ArrayList<String>();
   int count=GenericMethods.tr_count(sharerTable);
   for(int i=3;i<=count;i++)
   {
   	String data1=GenericMethods.driver.findElement(By.xpath("//table[@id='tblRoomSharers']//tr["+i+"]//td[2]")).getText();
   	arr.add(data1);
   	if(data1.equals(data))
   	{
   		Assert.assertEquals(data1.equals(data), true);
   		String value=GenericMethods.driver.findElement(By.xpath("//table[@id='tblRoomSharers']//tr["+i+"]//td[6]")).getText();
   		Assert.assertEquals(value, "Yes");
   		break;
   	}
   }
   Assert.assertEquals(arr.contains(data), true);
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


public EnableEditingPage fn_clkCancelCheckinGrp() throws Exception
{
	try
	{
	GenericMethods.js_Click(cancelCheckin);
	GenericMethods.ActionOnAlert("Accept");
	Thread.sleep(3000);
	EnableEditingPage VDP=PageFactory.initElements(GenericMethods.driver, EnableEditingPage.class);
    return VDP;
	}
	catch(Exception e)
	{
		throw e;
	}
}


public AccountStatementLandingPage fn_clkPaymentSingleguest() throws Exception
{
	try
	{
	GenericMethods.clickElement(paymentBtn);
	AccountStatementLandingPage ASP=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
	return ASP;
	}
	catch(Exception e)
	{
		throw e;
	}
}


public void fn_ClickAfterCheckIn_Link() throws Exception
{

  	 try
  	 {
  		GenericMethods.clickElement(CheckInDateOfSecondGuest_Link);
  		for(WebElement We: CheckInDateOfSGCalender_TB)
  		{
  			String str=We.getText();
  			if(str.equalsIgnoreCase("30"))
  			{
  				We.click();
  				break;
  	        }
  		}

  		Thread.sleep(2000);
  		String sobj=GenericMethods.getText(CheckInDateOfSecondGuest_Link);
			Assert.assertTrue(sobj.contains("30"));
  	 }
  	 catch(Exception e)
  	 {
  		 throw e;
  	 }

}


/*public void fn_ClickBeforeCheckOut_Link() throws Exception
{

  	 try
  	 {
  		GenericMethods.clickElement(CheckOutDateOfSGDate);
  		for(WebElement We: CheckInDateOfSGCalender_TB)
  		{
  			String str=We.getText();
  			if(str.equalsIgnoreCase("1"))
  			{
  				We.click();
  				break;
  			}

  		}
  		Thread.sleep(2000);
  		String sobj=GenericMethods.getText(CheckOutDateOfSGDate);
		Assert.assertTrue(sobj.contains("1"));
		GenericMethods.clickElement(Btn_BackToGroup);
  	 }
  	 catch(AssertionError e)
  	 {
  		 throw e;
  	 }
  	 catch(Exception e)
  	 {
  		 throw e;
  	 }

    }*/


public void fn_ValidateExtraBed() throws Exception
{

  	 try
  	 {
  	 text=GenericMethods.getText(TotalBalance);
  	 GenericMethods.selectElement(ExtraBed_DD, "1 Bed");
  	 Thread.sleep(2000);
  	 Select sobj=new Select(ExtraBed_DD);
  	 WebElement we=sobj.getFirstSelectedOption();
  	 String str=we.getText();
  	 Assert.assertEquals("1 Bed",str);
  	 Thread.sleep(2000);
  	 String str1=GenericMethods.getText(TotalBalance);
  	 Assert.assertFalse(str1.equals(text));

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


/*public void fn_ClickBackToGroup() throws Exception
{

  	 try
  	 {

  	 GenericMethods.clickElement(BackToGroup_BT);

  	 }
  	 catch(Exception e)
  	 {
  		 throw e;
  	 }

}*/


public static String GuestName=GenericMethods.generateRandomString();

public void fn_FillGuestDetails() throws Exception
{

  	 try
  	 {
  		 GuestFirstName_ED.clear();
  		GenericMethods.js_Sendkey(GuestFirstName_ED,GuestName );
  		GuestLastName_ED.clear();
  		GenericMethods.js_Sendkey(GuestLastName_ED, GenericMethods.generateRandomString());
  		GenericMethods.js_Sendkey(Phone_ED, "858564855");
  		GenericMethods.sendKeys(Email_ED, "xyz@gmail.com");
//  		GenericMethods.js_Sendkey(Address_ED, "Noida");
//  		GenericMethods.sendKeys(Organization_ED, "HMS");
  		GenericMethods.clickElement(SaveAndMore_BT);

  		GenericMethods.clickElement(GuestInformationSave_BT);
  	 }
  	 catch(Exception e)
  	 {
  		 throw e;
  	 }

}

public void fn_ValidateVIPcheckBox() throws Exception
{

  	 try
  	 {
  		 if(VIP_CB.isSelected()==true)
  		 {
  			 System.out.println("Its Checked");
  		 }
  		 else
  		 {
  			GenericMethods.clickElement(VIP_CB);
  		 }

  		boolean result=VIP_CB.isSelected();
  		Assert.assertEquals(result, true);


  	 }
  	 catch(Exception e)
  	 {
  		 throw e;
  	 }

}


public void fn_ClickAddEditDetails() throws Exception
{

   	 try

   	 {
   		GenericMethods.js_Click(Pencil_IMG);
   		Thread.sleep(2000);
   		//GenericMethods.clickElement(GuestFirstName_ED);
   		GenericMethods.sendKeys(GuestFirstName_ED, EditName);
   		GenericMethods.clickElement(GuestInformationSave_BT);
   	 }

   	 catch(Exception e)
   	 {
   		 throw e;
   	 }

}



public void fn_ClickCancelCheckIn_BT() throws Exception
{

	 try
	 {
	 GenericMethods.clickElement(CancelCheckIn_BT);
	 GenericMethods.ActionOnAlert("Accept");

	 }
	 catch(Exception e)
	 {
		 throw e;
	 }

}

public void fn_ValidateTaxExemptInPopUp() throws Exception
{

	try{

        GenericMethods.clickElement(RoomTaxes_Link);
        GenericMethods.selectbyNo(TaxExempt_DD, 1);
        if(RoomTaxCheckBox_InPopUp.isSelected()==true){
            System.out.println("It's Checked");
        }else{
           RoomTaxCheckBox_InPopUp.click();
        }
        GenericMethods.clickElement(RoomTaxOKButton_InPopUp);
    }catch(Exception e){
        throw e;
    }
}



public void fn_ClickAfterCheckInFirstGuest_Link() throws Exception{

    try{
       GenericMethods.clickElement(CheckInDateOffirstGuest_Link);
       for(WebElement We: CheckInDateOfSGCalender_TB){
           String str=We.getText();
           if(str.equalsIgnoreCase("30")){
               We.click();
               break;
       }
       }
       Thread.sleep(5000);
       String sobj=GenericMethods.getText(CheckInDateOffirstGuest_Link);
        Assert.assertTrue(sobj.contains("30"));
    }catch(Exception e){
        throw e;
    }
 }



public EnableEditingPage fn_getRoomTax() throws Exception
{
	try
	{
    	String a=GenericMethods.getText(txt_RoomTax).split(" ")[1];
    	String taxValue=a.split("\\.")[0];
    	tax1=Integer.parseInt(taxValue);
    	GenericMethods.clickElement(Btn_BackToGroup);
    	EnableEditingPage EEP=PageFactory.initElements(GenericMethods.driver, EnableEditingPage.class);
    	return EEP;
	}
	catch(Exception e)
	{
		throw e;
	}
}


public static int tax1;
public void fn_CalcTaxExemptGTS() throws Exception
{
	try
	{
	String tax=GenericMethods.getText(txt_RoomTax);
	Integer expTax=(EnableEditingPage.roomPrice*EnableEditingPage.TEValue)/100;
	Integer a=tax1-expTax;
    String expected=a.toString();
	Assert.assertTrue(tax.contains(expected));
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

}

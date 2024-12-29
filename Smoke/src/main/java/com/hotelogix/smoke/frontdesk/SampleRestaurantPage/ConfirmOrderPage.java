package com.hotelogix.smoke.frontdesk.SampleRestaurantPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.hotelogix.smoke.frontdesk.FrontdeskHome.CheckinCard;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class ConfirmOrderPage {


@FindBy(xpath="//input[@id='conOrderBtn']")
public static WebElement ConfirmOrderBtn;

@FindBy(id="folioNumberId")
public static WebElement ConfirmOrderPage;

@FindBy(id="roomNo")
public static WebElement RoomNumber_DD;


@FindBy(id="roomGuest")
public static WebElement RoomGuestName_DD;


@FindBy(xpath="//li[@id='##tabPOS']//table/tbody/tr/td/div")
public WebElement Text_OrderTab;


@FindBy(xpath="//select[@id='roomNo']")
public WebElement DD_RoomNo;

@FindBy(xpath="//table[@id='tblPOSProducts']/tbody/tr[3]/td[2]")
public WebElement Txt_SelectedProduct;

@FindBy(xpath="//table[contains(@class,'paymentbox table-cellspacing-patch')]/tbody/tr[4]/td[2]/span/input")
public WebElement Btn_TransferToRoom;



@FindBy(xpath="//select[@id='roomGuest']")
public WebElement DD_RoomGuest;


public String guestName;


public ConfirmOrderPage1 ConfirmOrder() throws Exception
{

GenericMethods.clickElement(ConfirmOrderBtn);
ConfirmOrderPage1 COP1=PageFactory.initElements(GenericMethods.driver,ConfirmOrderPage1.class);
return COP1;

}




public void fn_verifyTabTitle() throws InterruptedException
{

String str=GenericMethods.getText(ConfirmOrderPage);

if(str.contains("Order#")){
    System.out.println("Order gets displayed in new tab");
}else{
    System.out.println("Order does not gets displayed in new tab");
}

}

public ConfirmOrderPage1 fn_clkConfirmOrder1(String a) throws Exception
{
Thread.sleep(3000);
	GenericMethods.selectElement(RoomNumber_DD, a);
Thread.sleep(5000);
//GenericMethods.selectElement(GuestDropdown, b);
GenericMethods.clickElement(ConfirmOrderBtn);
Thread.sleep(6000);
ConfirmOrderPage1 COP1=PageFactory.initElements(GenericMethods.driver,ConfirmOrderPage1.class);
return COP1;

}




public ConfirmOrderPage1 fn_clkConfirmOrder() throws Exception
{
	try
	{
    Select selobj=new Select(RoomNumber_DD);
    selobj.selectByIndex(1);
    Thread.sleep(3000);
    Select seobj=new Select(RoomGuestName_DD);
    seobj.selectByIndex(1);
    GenericMethods.clickElement(ConfirmOrderBtn);
    Thread.sleep(3000);
    ConfirmOrderPage1 COP1=PageFactory.initElements(GenericMethods.driver,ConfirmOrderPage1.class);
    return COP1;
	}
	catch(Exception e)
	{
		throw e;
	}
}


public ConfirmOrderPage1 fn_clkConfirmOrderGrp() throws Exception
{
	try
	{
	Select selobj=new Select(RoomNumber_DD);
    selobj.selectByIndex(6);

//    Select seobj=new Select(RoomGuestName_DD);
//    seobj.selectByIndex(6);
    GenericMethods.clickElement(ConfirmOrderBtn);
    ConfirmOrderPage1 COP1=PageFactory.initElements(GenericMethods.driver,ConfirmOrderPage1.class);
    return COP1;
	}
	catch(Exception e)
	{
		throw e;
	}
}

public String getGeneratedPosId(){
	String orderId=null;
try{
	
	orderId=GenericMethods.getText(Text_OrderTab).trim();
	
}
catch(Exception e){
	e.printStackTrace();
}
return orderId;
	
}

	public OrderFolioPage fn_transferOrderToRoom(String roomNo) throws Exception{
	  try{
			GenericMethods.selectElement(DD_RoomNo, roomNo);
			Thread.sleep(2000);
			Select s=new Select(DD_RoomGuest);
			Thread.sleep(2000);
			guestName=s.getFirstSelectedOption().getText();
			Thread.sleep(2000);
			GenericMethods.clickElement(Btn_TransferToRoom);
		     Reporter.log("Order transfer to the:"+ roomNo , true);
		}catch(Exception e){
		throw e;
		}
		OrderFolioPage OFP=PageFactory.initElements(GenericMethods.driver, OrderFolioPage.class);
		return OFP;
		}
	}














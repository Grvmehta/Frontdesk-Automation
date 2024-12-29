package com.hotelogix.smoke.frontdesk.SampleRestaurantPage;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.hotelogix.smoke.frontdesk.FrontdeskHome.CheckinCard;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class ConfirmOrderPage1
{

public static String BalanceAmt="0.00";


@FindBy(xpath="//select[@id='roomNo']")
public static WebElement RoomNoDropdown;

@FindBy(xpath="//select[@id='roomNo']")
public static WebElement GuestDropdown;

@FindBy(xpath="//input[@id='trsnToRoomGrpBnt']")
public static WebElement TransferToRoomBtn;

@FindBy(id="folioNumberId")
public static WebElement ConfirmOrderPage;

@FindBy(id="trsnToRoomGrpBnt")
public static WebElement TransferToRoom_BT;

@FindBy(xpath="//fieldset[@id='paymentTab']//tr[3]//td[1]")
public static WebElement VerifyTTRBox;

@FindBy(xpath="//select[@id='roomNo']//option")
public static List<WebElement> RoomNumberText;

@FindBy(xpath="//fieldset[@id='folioNumberId']")
public static WebElement FolioNumberID;

@FindBy(xpath="//fieldset[@id='tarnsactinTab']//tr")
public static List<WebElement> Tr_Count;

@FindBy(xpath="//input[@value='Transaction Close']")
public static WebElement TransactionClose_BT;

@FindBy(name="paymentType")
public static WebElement PaymentType_DD;

@FindBy(xpath="//input[@value='Pay Now!']")
public static WebElement PayNow_BT;

@FindBy(xpath="//fieldset[@id='myBalId']")
public static WebElement BalanceAmountBox;

@FindBy(id="roomNo")
public static WebElement RoomNumber_DD;

@FindBy(id="roomGuest")
public static WebElement RoomGuestName_DD;




public OrderFolioPage BillTransferToRoom(String a) throws Exception
{

GenericMethods.selectElement(RoomNoDropdown, a);
//GenericMethods.selectElement(GuestDropdown, b);
GenericMethods.clickElement(TransferToRoomBtn);
OrderFolioPage OFP=PageFactory.initElements(GenericMethods.driver, OrderFolioPage.class);
return OFP;

}


public void fn_verifyConfirmedOrder() throws Exception
{
	try
	{
	String str=GenericMethods.getText(ConfirmOrderPage);
	Assert.assertTrue(str.contains("Order#"));
    Thread.sleep(6000);
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


public void fn_TransferToRoomButton() throws Exception
{

	try
	{
    GenericMethods.clickElement(TransferToRoom_BT);
    Thread.sleep(5000);
    String strobj=GenericMethods.getText(VerifyTTRBox);
    String[] parts=strobj.split(" ");
    String value=parts[2];
    String rmnumber=value.substring(value.indexOf("(")+1, value.indexOf(")"));
    System.out.println("Transferred to room  "+rmnumber);
    Thread.sleep(3000);
    for(int i=0; i<RoomNumberText.size();i++)
    {
        WebElement wobj=RoomNumberText.get(i);
        String stro=wobj.getText();
        if(rmnumber.equals(stro))
        {
            System.out.println("Transfer to Room Details section is visible on page");
            break;
        }
     }
	}
	catch(Exception e)
	{
		throw e;
	}
}


public OrderFolioPage fn_clkTransferTotRoom() throws Exception
{
	GenericMethods.clickElement(TransferToRoom_BT);
	OrderFolioPage OFP=PageFactory.initElements(GenericMethods.driver, OrderFolioPage.class);
	return OFP;
}



public static String str;
public void fn_verifyTransactionCloseButton() throws Exception
{
	try
	{
    //GenericMethods.clickElement(TransactionClose_BT);
    Thread.sleep(3000);
    str=GenericMethods.getText(FolioNumberID);
    GenericMethods.clickElement(TransactionClose_BT);
    Thread.sleep(5000);
    int inobj=GenericMethods.tr_count(Tr_Count);
    for(int i=2; i<=inobj-1; i++)
    {
        String attri_data =GenericMethods.driver.findElement(By.xpath("//fieldset[@id='tarnsactinTab']//tr["+i+"]//td[6]")).getText();
        if(str.contains(attri_data))
        {
            System.out.println("The closed transaction is being displayed in Transaction list ");
            break;
        }

    }
	}
	catch(Exception e)
	{
		throw e;
	}
}



public void fn_VerifyPayNowButton() throws Exception
{
	try
	{
    //GenericMethods.clickElement(FeaturedProductName_BT);
    //GenericMethods.clickElement(GenerateOrder_BT);
    //GenericMethods.clickElement(ConfirmOrder_BT);
    GenericMethods.selectElement(PaymentType_DD, "Cash");
    GenericMethods.clickElement(PayNow_BT);
    Thread.sleep(3000);
    String str=GenericMethods.getText(BalanceAmountBox);
//    if(str.contains(BalanceAmt))
//    {
//        System.out.println("Amount is paid by Cash");
//
//    }
    Assert.assertTrue(str.contains(BalanceAmt));
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


public OrderFolioPage fn_selectRoomGrp() throws Exception
{
   Select sel=new Select(RoomNumber_DD);
   sel.selectByVisibleText(CheckinCard.resrvRoom);
   Select sel1=new Select(RoomGuestName_DD);
   sel1.selectByIndex(1);
   GenericMethods.js_Click(TransferToRoomBtn);
   OrderFolioPage OFP=PageFactory.initElements(GenericMethods.driver, OrderFolioPage.class);
   return OFP;
}





}

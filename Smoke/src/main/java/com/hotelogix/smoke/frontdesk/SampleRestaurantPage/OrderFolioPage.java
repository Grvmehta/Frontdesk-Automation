package com.hotelogix.smoke.frontdesk.SampleRestaurantPage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class OrderFolioPage {

	public static String folioId;
	public static String folioTax;
	
	public String FNum;

	@FindBy(xpath="//input[@name='Submit2']")
	public static WebElement TransactionCloseBtn;

	@FindBy(xpath="//fieldset[@id='folioNumberId']")
	public static WebElement TransferItemFolioNum;

	@FindBy(xpath="//fieldset[@id='myTaxId']")
	public static WebElement PosItemTax;

	@FindBy(xpath="//fieldset[@id='folioNumberId']")
	public static WebElement FolioNumberID;

	@FindBy(xpath="//fieldset[@id='tarnsactinTab']//tr")
	public static List<WebElement> Tr_Count;

	@FindBy(id="trsnToRoomGrpBnt")
	public static WebElement TransferToRoom_BT;

	@FindBy(xpath="//fieldset[@id='paymentTab']//tr[3]//td[1]")
	public static WebElement VerifyTTRBox;

	@FindBy(xpath="//select[@id='roomNo']//option")
	public static List<WebElement> RoomNumberText;

	@FindBy(id="roomNo")
	public static WebElement RoomNumber_DD;


	@FindBy(id="roomGuest")
	public static WebElement RoomGuestName_DD;
	
	
	@FindBy(xpath="//fieldset[@id='folioNumberId']")
	public WebElement Txt_GeneratedPosFolio;

	@FindBy(xpath="//input[@name='Submit2']")
	public WebElement Btn_TransactionClose;



	public void fn_TransferToRoomButton() throws Exception
	{
        try
        {
	    //GenericMethods.clickElement(TransferToRoom_BT);
	    Thread.sleep(5000);
	    String strobj=GenericMethods.getText(VerifyTTRBox);
	    String[] parts=strobj.split(" ");
	    String value=parts[2];
	    String rmnumber=value.substring(value.indexOf("(")+1, value.indexOf(")"));
	    System.out.println("Transferred to room  "+rmnumber);
	    Thread.sleep(3000);
//	    for(int i=0; i<RoomNumberText.size();i++)
//	    {
//	        WebElement wobj=RoomNumberText.get(i);
//	        String stro=wobj.getText();
//	        if(rmnumber.equals(stro))
//	        {
//	        	Assert.assertTrue(true);
//	            System.out.println("Transfer to Room Details section is visible on page");
//
//	            break;
//	        }
//	     }
//        }
	    Select sel=new Select(RoomNumber_DD);
	    String text=sel.getFirstSelectedOption().getText();
        Assert.assertEquals(text, rmnumber);
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



public void CloseTransaction() throws Exception{
	folioId=getFolioNumber();
	folioTax=getPosItemTax();
GenericMethods.clickElement(TransactionCloseBtn);

}


public String getFolioNumber() throws Exception
{
	try
	{
String folioNum=GenericMethods.getText(TransferItemFolioNum);
String Foliono=folioNum.substring(folioNum.indexOf("#")+1,folioNum.length());
return Foliono;
	}
	catch(Exception e)
	{
		throw e;
	}
}

public String getPosItemTax() throws InterruptedException{
	String tax=GenericMethods.getText(PosItemTax);
	return tax;

}


public static String str;
/*public void fn_verifyTransactionCloseButton() throws Exception
{
	try
	{
		ArrayList<String> arr=new ArrayList<String>();
    //GenericMethods.clickElement(TransactionClose_BT);
    Thread.sleep(3000);
    //str=GenericMethods.getText(FolioNumberID);
    folioId=getFolioNumber();
    folioTax=getPosItemTax();
    GenericMethods.clickElement(TransactionCloseBtn);
    Thread.sleep(5000);
    int inobj=GenericMethods.tr_count(Tr_Count);
    for(int i=2; i<=inobj-1; i++)
    {
        String attri_data =GenericMethods.driver.findElement(By.xpath("//fieldset[@id='tarnsactinTab']//tr["+i+"]//td[6]")).getText();
        arr.add(attri_data);
        if(attri_data.contains(folioId.trim()))
        {
        	Assert.assertTrue(attri_data.contains(folioId.trim()));
            System.out.println("The closed transaction is being displayed in Transaction list ");
            break;
        }

    }
    Assert.assertEquals(arr.contains(folioId.trim()), true);
	}
	catch(Exception e)
	{
		throw e;
	}
	catch(AssertionError e)
	{
		throw e;
	}
}*/







public SampleRestaurantPage fn_closeTransaction(){
	try{
		
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	SampleRestaurantPage SRP=PageFactory.initElements(GenericMethods.driver, SampleRestaurantPage.class);
	
	return SRP;
	
	
}

public TransactionListPage fn_getFolioAndCloseTransaction() throws Exception{
	
try{
	
String fNum=GenericMethods.getText(Txt_GeneratedPosFolio);
Thread.sleep(2000);
FNum=fNum.substring(fNum.indexOf("#")+1, fNum.length()).trim();
Thread.sleep(2000);
GenericMethods.clickElement(Btn_TransactionClose);

}
catch(Exception e){

throw e;
}
Thread.sleep(2000);
TransactionListPage TLP=PageFactory.initElements(GenericMethods.driver,TransactionListPage.class);
return TLP;
	
}

}
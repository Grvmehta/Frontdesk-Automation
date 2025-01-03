package com.hotelogix.smoke.frontdesk.ViewDetailsPage;

import java.util.ArrayList;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.frontdesk.Payment.AccountStatementLandingPage;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.SampleRestaurantPage;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class ViewDetailsPage {




@FindBy(xpath="//input[@value='Enable Editing']")
public static WebElement EnableEditingBtn;

@FindBy(xpath="//input[@id='btnmainSRPay']")
public static WebElement PaymentBtn;

@FindBy(xpath="//form[@id='frmSingleResView']/table/tbody/tr/td/table[2]/tbody/tr/td[2]/table[1]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]")
public static WebElement Amt;


@FindBy(xpath="//form[@id='frmSingleResView']/table/tbody/tr/td/table[2]/tbody/tr/td[2]/table[1]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]")
public static WebElement Tax;

@FindBy(xpath="//form[@id='frmSingleResView']/table/tbody/tr/td/table[2]/tbody/tr/td[2]/table[1]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[6]/td[2]")
public static WebElement AmtWithTax;

@FindBy(xpath="//span[text()='Add/Edit Details']")
public static WebElement AddEditDetails_link;

@FindBy(xpath="//input[@id='srTxtLastName']")
public static WebElement LastName_ED;

@FindBy(xpath="//input[@id='phoneNo']")
public static WebElement Phone_ED;

@FindBy(xpath="//input[@id='btnSave']")
public static WebElement Save_BT;

@FindBy(xpath="//table[@id='roomGrTableId']//tr[2]//td[8]")
public static WebElement Status_Text;

@FindBy(xpath="//input[@id='btnmainSRClose']")
public static WebElement Close_BT;

@FindBy(xpath="//span[@class='closebtn']")
public static WebElement btn_closeReserv;


@FindBy(xpath="//input[@name='btnSngResPayment']")
public WebElement Btn_PaymentForSingleReservation;


@FindBy(xpath="//table[@class='size11']/tbody/tr[1]/td[2]")
public WebElement Text_RoomTariff;

//@FindBy(xpath="//form[@id='frmSingleResView']//table//table//td//tr//td[7]//span")
//@FindBy(xpath="//*[@class='gtoolbar1']/table/tbody/tr/td[8]/strong/span")
@FindBy(xpath="//div[contains(@class,'res-id')]")
public WebElement Txt_ResID;

@FindBy(xpath="//input[@value='Enable Editing']")
public WebElement Btn_EnableEditing;

//@FindBy(xpath="//form[@id='frmSingleResView']/table//table//table//tr//td[3]//tr//td[2]")
@FindBy(xpath="(//div[@class='col-auto']/span)[1]")
public WebElement Txt_RoomNumber;

@FindBy(xpath="//a[contains(text(),'Restaurant')]")
public WebElement Link_Restaurant;

@FindBy(xpath="//td[@class='front_tbl_lft']/table//tr[2]/td/table/tbody/tr/td/div/table/tbody/tr/td/table/tbody/tr/td")
private WebElement txt_GuestID;





	public SampleRestaurantPage ClickOnRestaurant() throws Exception{
		try{
			Thread.sleep(2000);
			GenericMethods.clickElement(Link_Restaurant);
		}
		catch(Exception e){
			throw e;
		}
		SampleRestaurantPage SRP=PageFactory.initElements(GenericMethods.driver, SampleRestaurantPage.class);	
		return SRP;
		
	}

	public String getRoomNum() throws Exception{
		String rnum=null;
		try{
			if(Txt_RoomNumber.isDisplayed())
			{
			
			rnum=GenericMethods.getText(Txt_RoomNumber).trim();
			System.out.println("rnum is::::"+rnum);
			}
			else
			{
				System.out.println("rnum not found");
			}
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	return rnum;
		
	}


	public EnableEditingPage ClickOnEnableEditing() throws Exception{
	try{
		Thread.sleep(2000);
	GenericMethods.clickElement(Btn_EnableEditing);
	}
	catch(Exception e){
	
	throw e;
	}
	EnableEditingPage EEP=PageFactory.initElements(GenericMethods.driver, EnableEditingPage.class);
	return EEP;
		
	}


public String GetResveration() throws Exception{
	String res=null;
	try{
	res=GenericMethods.getText(Txt_ResID);
	System.out.println("Res id text came as:::"+res);
	String s1[]=res.split("\\s+");
	res=s1[1];
	System.out.println("Returning res id as:::"+res);
	}
	catch(Exception e){
		
		throw e;
	}
	return res;
	
}



public static ArrayList<String> als=new ArrayList<String>();

public EnableEditingPage ClickToEnableEditingBtn() throws Exception
{
	try
	{
GenericMethods.clickElement(EnableEditingBtn);
	}
	catch(NoSuchElementException e)
	{
		Thread.sleep(1000);
		GenericMethods.js_Click(EnableEditingBtn);
	}
	catch(Exception e)
	{
		throw e;
	}
EnableEditingPage EEP = PageFactory.initElements(GenericMethods.driver, EnableEditingPage.class);
return EEP;
}

public AccountStatementLandingPage ClickToPayment() throws Exception
{
	try
	{
GenericMethods.clickElement(PaymentBtn);
	}
	catch(NoSuchElementException e)
	{
		Thread.sleep(2000);
		GenericMethods.js_Click(PaymentBtn);
	}
	catch(Exception e)
	{
		
		throw e;
	}
AccountStatementLandingPage ASL=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
return ASL;
}



public ArrayList<String> GetAmtDetails() throws InterruptedException
{
String amt=GenericMethods.getText(Amt);
String tax=GenericMethods.getText(Tax);
String amtWithTax=GenericMethods.getText(AmtWithTax);
als.add(amt);
als.add(tax);
als.add(amtWithTax);
return als;
}


public void fn_ClickAddEditDetails_link() throws Exception
{

	 try
	 {
         GenericMethods.clickElement(AddEditDetails_link);
	 }
	 catch(Exception e)
	 {
		 throw e;
	 }

}

public void fn_ChangeDetails() throws Exception
{

	 try
	 {
		String str=GenericMethods.generateRandomString();
		LastName_ED.clear();
        GenericMethods.sendKeys(LastName_ED, str);
        String num=GenericMethods.generateRandomnum();
        Phone_ED.clear();
        GenericMethods.sendKeys(Phone_ED, num);
        GenericMethods.clickElement(Save_BT);
        GenericMethods.clickElement(btn_closeReserv);
	 }
	 catch(Exception e)
	 {
		 throw e;
	 }

}

public void fn_ValidateCheckINstatus() throws Exception
{

  	 try
  	 {
  	    String str=GenericMethods.getText(Status_Text);
  	    Assert.assertTrue(str.contains("Checked In"));
        GenericMethods.clickElement(Close_BT);
  	 }
  	 catch(Exception e)
  	 {
  		 throw e;
  	 }

}






}

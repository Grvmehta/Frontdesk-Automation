package com.hotelogix.smoke.admin.Console;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddTravelAgentPage {

	public static String TaName;



	@FindBy(xpath="//input[@type='file']")
	public static WebElement Browse_Btn;

	@FindBy(xpath="//input[@id='businessName']")
	public static WebElement TravelAgentName;

	@FindBy(xpath="//input[@id='address1']")
	public static WebElement Address1;

	@FindBy(xpath="//select[@id='countryId']")
	public static WebElement Country_Dropdown;

	@FindBy(xpath="//select[@id='stateId']")
	public static WebElement State_Dropdown;

	@FindBy(xpath="//input[@id='city']")
	public static WebElement City;

	@FindBy(xpath="//td[@class='padingtd']//table//tr[16]/td[2]/input")
	public static WebElement ZipCode;

	@FindBy(xpath="//input[@id='fName']")
	public static WebElement FirstName;

	@FindBy(xpath="//input[@id='lName']")
	public static WebElement LastName;

	@FindBy(xpath="//input[@id='designation']")
	public static WebElement Designation;

	@FindBy(xpath="//input[@id='phoneNo']")
	public static WebElement OfficePhone;

	@FindBy(xpath="//input[@id='email']")
	public static WebElement EmailID;

	@FindBy(xpath="//input[@id='chkSameAsMainfficeAddress']")
	public static WebElement SameAsMainOfficeAdd_Checkbox;

	@FindBy(xpath="//input[@id='chkMainBillingContact']")
	public static WebElement SameAsContactPerson_Checkbox;

	@FindBy(xpath="//td[@class='comments']/input")
	public static WebElement Save_Btn;

	@FindBy(xpath="//div[@id='listing-icons']/ul/li[2]/input")
	public static WebElement SAVE_Btn;


	
	public static String Email;
	
public String  fn_fillTADetails() throws Exception{

	try
	{
	TaName=GenericMethods.generateRandomString();
	GenericMethods.sendKeys(TravelAgentName, TaName);
	GenericMethods.sendKeys(Address1, "NY City");

	GenericMethods.selectElementByIndex(Country_Dropdown, 10);
	Thread.sleep(4000);
	GenericMethods.selectElementByIndex(State_Dropdown, 17);
	Thread.sleep(4000);
	GenericMethods.sendKeys(City, "Rio Negro City");
	GenericMethods.sendKeys(ZipCode, "0000A1");
	GenericMethods.sendKeys(FirstName, GenericMethods.generateRandomString());
	GenericMethods.sendKeys(LastName, GenericMethods.generateRandomString());
	GenericMethods.sendKeys( Designation, "Owner");
	GenericMethods.sendKeys( OfficePhone, GenericMethods.generateRandomnum());
	GenericMethods.sendKeys( EmailID, AddTravelAgentPage.GetMailId());
	
	Email=EmailID.getAttribute("value");
	
	GenericMethods.clickElement(SameAsMainOfficeAdd_Checkbox);
	Thread.sleep(5000);
	GenericMethods.clickElement( SameAsContactPerson_Checkbox);

	return Email;
	
	}
	catch(Exception e)
	{
		throw e;
	}
}




public ListOfRegisteredTravelAgentLP clk_saveBtn() throws Exception
{
	try
	{
	GenericMethods.js_Click(SAVE_Btn);
	
	ListOfRegisteredTravelAgentLP RTA=PageFactory.initElements(GenericMethods.driver, ListOfRegisteredTravelAgentLP.class);
	return RTA;
	}
	catch(Exception e)
	{
		throw e;
	}
}


public static String GetMailId() throws Exception{
	
	try
	{
	String s1="deepakthayatharishbarkha@stayezee.com";
	String arr[]=s1.split("@");
	String rep=arr[0];
	int length=rep.length();


	Random rn=new Random();
	int randomnum=rn.nextInt(length-1)+1;
	System.out.println(randomnum);
	String result=rep.substring(0, randomnum)
	     +"."
	     +rep.substring(randomnum, length)
	     +"@"
	     +arr[1];
	System.out.println(result);
	return result;
	}
	catch(Exception e)
	{
		throw e;
	}
}











}

package com.hotelogix.smoke.admin.roommanager;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.hotelogix.smoke.admin.BaseClass.AdmineHome;
import com.hotelogix.smoke.admin.PosManager.POSPointsLandingPage;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.FrontdeskLandingPage;
import com.hotelogix.smoke.genericandbase.BasePage;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class RoomsLandingPage
{
	//Add A Room button xpath
	@FindBy(xpath="a[text()='Add a Room']")
	public static WebElement addroom;

	//xpath for Room Name/Number*
	@FindBy(id="rmNameOrNoMulName_0")
	public static WebElement roomNumber;

	//xpath for Room Type* dropdown
	@FindBy(xpath="select[@id='rmTypeId']//option[2]")
	public static WebElement selectRoomType;

	@FindBy(xpath="//a[text()='Add a Room']")
	public static WebElement addRooms;

	@FindBy(xpath="//table[@class='list_viewnew']//tr[2]//td[3]")
	public static WebElement room1;

	@FindBy(xpath="//form[@name='frmListView']//tr[2]//td")
	public static WebElement pgemsg;

	@FindBy(xpath="//table[@class='list_viewnew']//tr[2]//td[8]//img")
	public static WebElement status1;

	@FindBy(xpath="//td[8]//img[contains(@src,'https://20819.hotelogix.staygrid.com/images/on.GIF')]")
	public static WebElement Active;

	 @FindBy(xpath="//td[8]//img[contains(@src,'https://20819.hotelogix.staygrid.com/images/off.GIF')]")
	 public static WebElement deactive;

	 @FindBy(xpath="//table[@class='list_viewnew']/tbody/tr")
	 public static List<WebElement> roomname_count;

	 @FindBy(xpath="//input[@class='input-style2']")
	 public static WebElement Searchfield;

	 @FindBy(xpath="//input[@class='btn-style']")
	 public static WebElement Searchbt;

	 @FindBy(xpath="//td[@class='main-field']")
	 public static WebElement VerifyRoom;

	 @FindBy(xpath="//select[@name='maxEntries']")
		public static WebElement view_drpdown;

	 ArrayList<String> arr= new ArrayList<String>();

	public static String scr_value="on.GIF";
    public static String img_value;
    public static String saved_msg="- Room "+AddRoomsPage.rmNumber+" Saved Successfully";
    public static String saved_msg1="- Room "+'"'+AddRoomsPage.b+'"'+" Saved Successfully";


	//xpath for comment box
	@FindBy(xpath="//div[@class='logo']/a/img")
	public WebElement Link_hotelLogo;

	
	

	
public BasePage ClickOnLogo() throws Exception{
	try{
GenericMethods.clickElement(Link_hotelLogo);
System.out.println("Clicked over the link");
	}
	catch(Exception e){
	
		throw e;
	}
BasePage BP=PageFactory.initElements(GenericMethods.driver, BasePage.class);
return BP;
}
	
	
	
	public static void  view_all() throws Exception
    {
    	GenericMethods.selectElement(view_drpdown, "All");
    	GenericMethods.ActionOnAlert("Accept");
//    	POSPointsLandingPage pageObj=PageFactory.initElements(GenericMethods.driver, POSPointsLandingPage.class);
//		return pageObj;
    }

	public static String searchtxt;
	public  AddRoomsPage Existing_RoomCHk() throws Exception
	{

       String abc = AddRoomsPage.roomNumber;

       GenericMethods.sendKeys(Searchfield, abc);
  	   GenericMethods.clickElement(Searchbt);
  	   searchtxt=GenericMethods.getText(VerifyRoom);
  	   System.out.println(searchtxt);
  	   click_AddRoom();
  	   AddRoomsPage SRP = PageFactory.initElements(GenericMethods.driver, AddRoomsPage.class);
		return SRP;

	}



	public  AddRoomsPage click_AddRoom() throws Exception
	{
		try
		{

		GenericMethods.clickElement(addRooms);
		//..Initializing SaveRoomsPage
		
		}
		catch(Exception e)
		{
			
			throw e;
		}
		AddRoomsPage SRP = PageFactory.initElements(GenericMethods.driver, AddRoomsPage.class);
		return SRP;
	}

	
	
	public  void verify_savedroom() throws Exception
	{
		//Method verifies the message displayed on successful save
		try
		{
		String msg1=GenericMethods.getText(pgemsg);
		Assert.assertEquals(msg1, saved_msg);

		
		int rowcount=GenericMethods.tr_count(roomname_count);
		for(int i=2;i<=rowcount;i++)
		{
			String name=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
			arr.add(name);
			if(name.equals(AddRoomsPage.roomNumber))
			{
				System.out.println(name);
				String status=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]//img")).getAttribute("src");
//				if(status.contains(scr_value))
//				{
//					System.out.println("Saved room is being displayed in room list");
//					System.out.println("Status of saved room is active");
//					break;
//				}
				Assert.assertEquals(status.endsWith("on.GIF"),true);
				break;
			}
			Assert.assertEquals(arr.contains(AddRoomsPage.roomNumber),true);

		}
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

	public  void  verifyroom_savedupl() throws Exception
	{
		try
		{
		String msg=GenericMethods.getText(pgemsg);

		Assert.assertEquals(msg,"- Room "+'"'+AddRoomsPage.b+'"'+" Saved Successfully");
		Reporter.log("Correct page message is being displayed",true);

		int count=GenericMethods.tr_count(roomname_count);
		for(int i=2;i<=count;i++)
		{
			String roomname=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr[2]//td[3]")).getText();
			arr.add(roomname);
			if(roomname.equals(AddRoomsPage.b))
			{
			//Assert.assertEquals(roomname,SaveRoomsPage.b);
			String status=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr[2]//td[8]//img")).getAttribute("src");
			Assert.assertEquals(status.endsWith("on.GIF"),true);
			break;
		    }
			
			Assert.assertEquals(arr.contains(AddRoomsPage.b), true);

		//Reporter.log("Addred Room name is being displayed",true);


	   }
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
	public FrontdeskLandingPage fn_NavigateFrontdesk()
	{
		Actions act=new Actions(GenericMethods.driver);
		act.sendKeys(Keys.chord(Keys.CONTROL,Keys.TAB)).perform();
		GenericMethods.driver.switchTo().defaultContent();
		FrontdeskLandingPage FLP=PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
		return FLP;
	}

}

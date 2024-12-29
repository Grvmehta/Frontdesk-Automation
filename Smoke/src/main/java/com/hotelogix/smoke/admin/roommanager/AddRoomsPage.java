package com.hotelogix.smoke.admin.roommanager;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import com.hotelogix.smoke.frontdesk.FrontdeskHome.FrontdeskLandingPage;
import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddRoomsPage
{
	//xpath of ADD A ROOM

	//xpath of save button
	@FindBy(xpath="//input[@name='btnSave2']")
	public static WebElement save;

	//xpath of Room Name/Number Text box
	@FindBy(xpath="//input[@id='rmNameOrNoMulName_0']")
	public static WebElement roomNameNumber;

	//xpath of Room Type drop down
	@FindBy(id="rmTypeId")
	public static WebElement roomType;

	@FindBy(xpath="//form[@name='frmEditViewForLInk']//table//tr[2]//tbody//tr[3]//td[2]")
	public static WebElement RoomAddedMssg;

	@FindBy(xpath="//input[@name='Submit']")
	public static WebElement RoomCancel;
	
	@FindBy(xpath="//input[@name='rmNameOrNoMulName[]']")
	public WebElement RoomNameNumber_TB;
	
	@FindBy(xpath="//input[@name='roomCode']")
	public WebElement RoomCode;

	public static String a;
	public static String b;
	public String rtype;

	static String number = GenericMethods.randomUniqueString();
	public static String roomNumber = number+"";
	static String rmNumber='"'+roomNumber+'"';
	static String actTitle= "Room List";
	static String roomcodeno = number;


   
	
	
	public  RoomsLandingPage saveRooms() throws Exception
	{
		//..Method enters required details for adding a room
		//..Navigates to RoomsLandingPage and initializes it
		try
		{
		GenericMethods.sendKeys(roomNameNumber, roomNumber);



		//GenericMethods.selectElement(roomType, "fj");
		GenericMethods.selectElementByIndex(roomType, 1);
		GenericMethods.clickElement(save);

//		String expTitle = GenericMethods.driver.getTitle();
//
//		Assert.assertEquals(actTitle, expTitle);

		RoomsLandingPage RLP=PageFactory.initElements(GenericMethods.driver,RoomsLandingPage.class );
		return RLP;
		}
		catch(Exception e)
		{
			throw e;
		}

	}

	public static String GetSelectedRoomName()
	{

		String GetRoomTypeName = roomNumber;
		return GetRoomTypeName;

	}

	public void GetSelectedRoomType(int iTestCaseRow,String Filename) throws Exception
	{

		Select select = new Select(roomType);
		WebElement ele=select.getFirstSelectedOption();
		String abc=ele.getText();
		ExcelUtil.setCellData(abc, iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeName), Filename);
	}

	public String getSelectedRoomType() throws Exception
	{

		Select select = new Select(roomType);
		WebElement ele=select.getFirstSelectedOption();
		String abc=ele.getText();
		return abc;
		
	}


	public RoomsLandingPage AddRoomName(int iTestCaseRow,String Filename) throws Exception{
	     AddRoomsPage.roomNumber=roomNumber;
	     GenericMethods.driver.navigate().back();
	     new RoomsLandingPage().Existing_RoomCHk();
	      if(RoomsLandingPage.searchtxt.contains(roomNumber)) {
	    	  AddRoomsPage.roomNumber=AddRoomsPage.roomNumber+2;
	          GenericMethods.sendKeys(roomNameNumber, AddRoomsPage.roomNumber);
	          GenericMethods.selectElementByIndex(roomType, 1);
	    	   new  AddRoomsPage().GetSelectedRoomType(iTestCaseRow,Filename);
	      } else{
	    	  GenericMethods.sendKeys(roomNameNumber, roomNumber);
	    	  GenericMethods.selectElementByIndex(roomType, 1);
	    	  new AddRoomsPage().GetSelectedRoomType(iTestCaseRow,Filename);
	      }
		  GenericMethods.clickElement(save);
		  RoomsLandingPage RLP=PageFactory.initElements(GenericMethods.driver,RoomsLandingPage.class );
		  return RLP;
	}
	
	
	public String addRoomName(int rtypeIndex) throws Exception{
		try{
			roomNumber=GenericMethods.randomUniqueString();
			GenericMethods.sendKeys(RoomNameNumber_TB, roomNumber);
			GenericMethods.selectElementByIndex(roomType, rtypeIndex);
			GenericMethods.sendKeys(RoomCode, roomcodeno);
			
			rtype=GenericMethods.GetSelectedValueFromDropdown(roomType);
			System.out.println("Added room in Room Type :" + rtype);
			GenericMethods.clickElement(save);
		}catch(Exception e){
			throw e;
		}
		return rtype;
		}
	
	@FindBy(xpath="//input[@name='btnSave']")
	public static WebElement saveAndDuplicate;

	static int number2 = GenericMethods.randomNumber();
	static String roomNumber2 = number2+"";

	static int number3 = GenericMethods.randomNumber();
	static String roomNumber3 = number3+"";



	public String saveAndDuplicate(int rtypeIndex) throws Exception{
		try{
		//..Generates random 1st room name and stores it in variable a
	    a=GenericMethods.randomUniqueString();
		System.out.println(a);
		GenericMethods.sendKeys(roomNameNumber,a);
		//GenericMethods.selectElement(roomType, "HMS");
		GenericMethods.selectElementByIndex(roomType, rtypeIndex);
	  rtype= new  AddRoomsPage().getSelectedRoomType();
		GenericMethods.clickElement(saveAndDuplicate);
		//..Generates random 2nd room name and stores it in variable b
	    b=GenericMethods.randomUniqueString();
		System.out.println(b);
		GenericMethods.sendKeys(roomNameNumber,b);
		GenericMethods.clickElement(save);
		//..Initializing RoomsLandingPage
		/*RoomsLandingPage RLP=PageFactory.initElements(GenericMethods.driver,RoomsLandingPage.class );
		return RLP;*/
		return rtype;
		}
		catch(Exception e)
		{
		
			throw e;
		}
	}



	public static RoomsLandingPage fn_SaveAndDuplicateMultpl2RM() throws Exception{
		GenericMethods.sendKeys(roomNameNumber, roomNumber);
		GenericMethods.selectElementByIndex(roomType, 1);
		  GenericMethods.clickElement(saveAndDuplicate);
		  String RoomAddedMssgTxt = RoomAddedMssg.getText();
		  if(RoomAddedMssgTxt.contains("saved successfully")){
				GenericMethods.sendKeys(roomNameNumber, roomNumber=roomNumber+2);
				GenericMethods.selectElementByIndex(roomType, 1);
				  GenericMethods.clickElement(save);
			}
	RoomsLandingPage RLP = PageFactory.initElements(GenericMethods.driver, RoomsLandingPage.class);
	return RLP;
	}


	public static RoomsLandingPage fn_SaveAndDuplicateMultpl3RM() throws Exception
	{

		GenericMethods.sendKeys(roomNameNumber, roomNumber);
		GenericMethods.selectElementByIndex(roomType, 1);
		  GenericMethods.clickElement(saveAndDuplicate);
		  String RoomAddedMssgTxt = RoomAddedMssg.getText();
		  if(RoomAddedMssgTxt.contains("saved successfully"))
			{
				GenericMethods.sendKeys(roomNameNumber, roomNumber=roomNumber+2);
				GenericMethods.selectElementByIndex(roomType, 1);
				  GenericMethods.clickElement(saveAndDuplicate);
			}

		  String RoomAddedMssgTxt1 = RoomAddedMssg.getText();
		  if(RoomAddedMssgTxt.contains("saved successfully"))
			{
				GenericMethods.sendKeys(roomNameNumber, roomNumber=roomNumber+3);
				GenericMethods.selectElementByIndex(roomType, 1);
				  GenericMethods.clickElement(save);
			}
	RoomsLandingPage RLP = PageFactory.initElements(GenericMethods.driver, RoomsLandingPage.class);
	return RLP;
	}


	public static RoomsLandingPage fn_SaveAndDuplicateMultpl4RM() throws Exception
	{
		  String RoomAddedMssgTxt1 = RoomAddedMssg.getText();

		  if(RoomAddedMssgTxt1.contains("saved successfully"))
			{
				Thread.sleep(2500);

				GenericMethods.sendKeys(roomNameNumber, roomNumber+2);
				GenericMethods.selectElementByIndex(roomType, 1);
				  GenericMethods.clickElement(saveAndDuplicate);

			}
		  String RoomAddedMssgTxt2 = RoomAddedMssg.getText();
		  if(RoomAddedMssgTxt2.contains("saved successfully"))
			{
				Thread.sleep(2500);

				GenericMethods.sendKeys(roomNameNumber, roomNumber+3);
				GenericMethods.selectElementByIndex(roomType, 1);
				  GenericMethods.clickElement(saveAndDuplicate);

			}
		  String RoomAddedMssgTxt3 = RoomAddedMssg.getText();
		  if(RoomAddedMssgTxt3.contains("saved successfully"))
			{
				Thread.sleep(2500);

				GenericMethods.sendKeys(roomNameNumber, roomNumber+4);
				GenericMethods.selectElementByIndex(roomType, 1);
				  GenericMethods.clickElement(save);

			}
	RoomsLandingPage RLP = PageFactory.initElements(GenericMethods.driver, RoomsLandingPage.class);
	return RLP;
	}


	public static RoomsLandingPage fn_SaveAndDuplicateMultpl6RM() throws Exception
	{
		  String RoomAddedMssgTxt2 =  RoomAddedMssg.getText();
		  if(RoomAddedMssgTxt2.contains("saved successfully"))
			{
				Thread.sleep(2500);
				GenericMethods.sendKeys(roomNameNumber, roomNumber+6);
				GenericMethods.selectElementByIndex(roomType, 1);
				  GenericMethods.clickElement(saveAndDuplicate);

			}

		  else{
				Thread.sleep(2500);
				fn_SaveAndDuplicateMultpl6RM();
			}



		  Thread.sleep(9000);

			GenericMethods.clickElement(RoomCancel);

	RoomsLandingPage RLP = PageFactory.initElements(GenericMethods.driver, RoomsLandingPage.class);
	return RLP;


	}


	public static RoomsLandingPage fn_SaveAndDuplicateMultpl8RM() throws Exception
	{
		  String RoomAddedMssgTxt3 = RoomAddedMssg.getText();

		  if(RoomAddedMssgTxt3.contains("saved successfully"))
			{
				Thread.sleep(2500);
				GenericMethods.sendKeys(roomNameNumber, roomNumber+8);
				GenericMethods.selectElementByIndex(roomType, 1);
				  GenericMethods.clickElement(saveAndDuplicate);

			}

		  else{
				Thread.sleep(2500);
				fn_SaveAndDuplicateMultpl8RM();
			}

		  Thread.sleep(9000);

			GenericMethods.clickElement(RoomCancel);

	RoomsLandingPage RLP = PageFactory.initElements(GenericMethods.driver, RoomsLandingPage.class);
	return RLP;


	}









}

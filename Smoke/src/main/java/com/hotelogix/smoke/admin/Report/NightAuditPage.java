package com.hotelogix.smoke.admin.Report;


import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class NightAuditPage {




	@FindBy(xpath="//td[text()='Room Details ']")
	public static WebElement RoomDetailHeader;
	@FindBy(xpath="//table[2]//table//tr/td")
	public static WebElement NumOfOccupiedRoomHeader;
	@FindBy(xpath="(//td[@class='front_heading'])[2]")
	public static WebElement NumOfAvailableRoom;
	@FindBy(xpath="(//td[@class='front_heading'])[3]")
	public static WebElement NumOfCheckIn;
	@FindBy(xpath="(//td[@class='front_heading'])[4]")
	public static WebElement NumOfCheckOut;
	@FindBy(xpath="(//td[@class='front_heading'])[5]")
	public static WebElement NumOfNoShow;
	@FindBy(xpath="(//td[@class='front_heading'])[6]")
	public static WebElement NumOfCancellation;
	@FindBy(xpath="(//td[@class='front_heading'])[7]")
	public static WebElement NumOfDNRRooms;
	@FindBy(xpath="//td[text()=' Account Details ']")
	public static WebElement AccountDetailsHeader;
	@FindBy(xpath="//td[text()=' Room Inclusion ']")
	public static WebElement RoomInclusionHeader;
	@FindBy(xpath="//td[text()='Housekeeping Details']")
	public static WebElement HouseKeepingDetailsHeader;
	@FindBy(xpath="//td[text()='Housekeeping Task List ']")
	public static WebElement HouseKeepingTaskList;
	@FindBy(xpath="//table[3]//table[1]//td/table//td/input[2]")
	public static WebElement Export_Btn;






public void NightAuditTitle()
{

	String title=GenericMethods.driver.getTitle();
	Assert.assertEquals(title, "Night Audit");
}

public void VerifyHeaders() throws Exception{


	try
	{
	GenericMethods.checkElementDisplay(RoomDetailHeader);
	GenericMethods.checkElementDisplay( NumOfOccupiedRoomHeader);
	GenericMethods.checkElementDisplay(NumOfAvailableRoom);
	GenericMethods.checkElementDisplay(NumOfCheckIn);
	GenericMethods.checkElementDisplay(NumOfCheckOut);
	GenericMethods.checkElementDisplay(NumOfNoShow);
	GenericMethods.checkElementDisplay(NumOfCancellation);
	GenericMethods.checkElementDisplay(NumOfDNRRooms);
	GenericMethods.checkElementDisplay(AccountDetailsHeader);
	GenericMethods.checkElementDisplay(HouseKeepingDetailsHeader);
	GenericMethods.checkElementDisplay(HouseKeepingTaskList);
	GenericMethods.checkElementDisplay(RoomInclusionHeader);
	}
	catch(Exception e)
	{
		throw e;
	}
}

	public void DownloadNightAuditReportFile() throws Exception{

		try
		{
		Robot robo=new Robot();
		GenericMethods.clickElement(Export_Btn);
		 robo.keyPress(KeyEvent.VK_TAB);
	        robo.keyPress(KeyEvent.VK_TAB);
	        robo.keyPress(KeyEvent.VK_TAB);
	        Thread.sleep(1500);
	        robo.keyPress(KeyEvent.VK_ENTER);
	        Thread.sleep(1500);
		}
		catch(Exception e)
		{
			throw e;
		}




	}







}

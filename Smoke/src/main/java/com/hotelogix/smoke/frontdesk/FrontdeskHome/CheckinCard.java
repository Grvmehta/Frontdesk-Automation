package com.hotelogix.smoke.frontdesk.FrontdeskHome;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.frontdesk.ViewDetailsPage.EnableEditingPage;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class CheckinCard
{
	@FindBy(xpath="//input[@value='Close']")
    public static WebElement checkinCard_closeBtn;

    @FindBy(xpath="//h4")
    public static WebElement checkinCard_title;

    @FindBy(xpath="//tr[3]//td[2]//strong")
    public static WebElement guestName;


    public void fn_verifyCheckinCardtitle() throws InterruptedException
    {
    	String text=GenericMethods.getText(checkinCard_title);
    	Assert.assertEquals(text, "Check-in Card");
    }

    public FrontdeskLandingPage fn_clkCloseBtn() throws Exception
    {
    	GenericMethods.clickElement(checkinCard_closeBtn);
    	FrontdeskLandingPage AHO = PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
	    return AHO;
    }


    public FrontdeskLandingPage fn_verifyCheckedinGuest() throws Exception
    {
    	try
    	{
    	String name=GenericMethods.getText(guestName);
    	if(name.equalsIgnoreCase(EnableEditingPage.gname))
    	{
    		System.out.println("selected guest has been successfully checked-in.");
    	}
    	GenericMethods.clickElement(checkinCard_closeBtn);
    	FrontdeskLandingPage AHO = PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
	    return AHO;
    	}
    	catch(Exception e)
    	{
    		throw e;
    	}
    }

    public static String ID;
    public static String resrvRoom;

    public FrontdeskLandingPage fn_getIDRoomNum() throws Exception
    {
    	WebElement ele=GenericMethods.driver.findElement(By.cssSelector("td+td>h4"));
        String str[]=ele.getText().split(" ");
        ID=str[4];
        WebElement ele1=GenericMethods.driver.findElement(By.cssSelector("td+td>h1"));
        String s[]=ele1.getText().split(":");
        String parts[]=s[1].trim().split(",");
        String part1=parts[0].substring(0, parts[0].indexOf("("));
        resrvRoom=part1;
        System.out.println(ID+"   "+"   "+resrvRoom);
        GenericMethods.clickElement(checkinCard_closeBtn);
        FrontdeskLandingPage AHO = PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
 	    return AHO;
    }

}

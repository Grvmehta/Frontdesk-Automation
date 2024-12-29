package com.hotelogix.smoke.admin.General;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Factory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class BookingPolicyPage {

	@FindBy(xpath="//td[text()='Booking Policy List']")
	public static WebElement Booking_Policy_title;

	@FindBy(xpath="//a[@title='Add a Booking Policy']")
	public static WebElement Booking_Policy_Link;


	@FindBy(xpath="//table[@id='mainSeasonTable']//tbody//tr[last()-1]//td[3]")
	public static WebElement BPTitleText;

    @FindBy(xpath="//table[@id='mainSeasonTable']//tbody//tr[last()-1]//td[3]")
    public static WebElement Trail_History;


    @FindBy(xpath="//table[@id='mainSeasonTable']/tbody/tr")
    public static List<WebElement> tr_count_BP;


	public void BookingPolicy_PageVerify() throws Exception
	{
		String abc=Booking_Policy_title.getText();

		Assert.assertEquals(abc, "Booking Policy List");


	}


	public AddBookingPolicyPage add_booking_policy() throws Exception
	{
		try
		{
		GenericMethods.clickElement(Booking_Policy_Link);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(3000);
			GenericMethods.js_Click(Booking_Policy_Link);
		}
		catch(Exception e)
		{
			throw e;
		}
		AddBookingPolicyPage ABPP = PageFactory.initElements(GenericMethods.driver, AddBookingPolicyPage.class);
		return ABPP;

	}

	public  void fn_verifyBookingP() throws Exception
	{
		try
		{
		int trcount=GenericMethods.tr_count(tr_count_BP);
       // String data1=null;
		for(int i=2;i<trcount;i++)
		{
	       // String BText=AddBookingPolicyPage.BookPo1;
            String data= GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[3]")).getText();
            if(data.equals(AddBookingPolicyPage.BookPo1))
            {
            	Assert.assertEquals(data, AddBookingPolicyPage.BookPo1);
            	break;
            }
		
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
}

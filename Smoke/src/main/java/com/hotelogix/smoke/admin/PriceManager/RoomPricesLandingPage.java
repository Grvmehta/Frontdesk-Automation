package com.hotelogix.smoke.admin.PriceManager;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.BasePage;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class RoomPricesLandingPage
{
	@FindBy(xpath="//table[@class='table_price']//tr[2]//td[2]")
	public static WebElement roomType_name;

	@FindBy(xpath="//table[@class='table_price']//tr[2]//td[3]//table//tr[7]//td[3]//input")
	public static WebElement webratehigher_editbox;

	@FindBy(xpath="//table[@class='table_price']//tr[2]//td[3]//table//tr[6]//td[2]//input")
	public static WebElement webratebase_editbox;

	@FindBy(xpath="//div[@id='listing-icons']//a/img")
	public static WebElement cancel_btn;

	@FindBy(xpath="//td[text()='Room Prices List']")
	public static WebElement RoomPricesList;

	@FindBy(xpath="//table[@class='table_price']//tr[2]//td[3]//table//tr[5]//td[last()]//img")
	public static WebElement EditRatesRP;

	@FindBy(xpath="//table[@class='table_price']//tr[2]//td[3]//table//tr[5]//td[2]//input")
	public static WebElement LowBaseOccPrice;

	@FindBy(xpath="//table[@class='table_price']//tr[2]//td[3]//table//tr[5]//td[3]//input")
	public static WebElement LowHighPPP;

	@FindBy(xpath="//table[@class='table_price']//tr[2]//td[3]//table//tr[5]//td[15]//img[3]")
	public static WebElement LowPS;

	@FindBy(xpath="//table[@class='table_price']//tr[2]//td[3]//table//tr[5]//td[2]//input[@value]")
	public static WebElement SBOP;

	@FindBy(xpath="//table[@class='table-content']//tr[6]//td[13]/img")
	public static WebElement lastmin_editbtn;

	@FindBy(xpath="//table[@class='table_price']//tr[2]//td[3]//table//tr[6]//td[2]//input")
	public static WebElement lastminbase_editbox;

	@FindBy(xpath="//table[@class='table_price']//tr[2]//td[3]//table//tr[6]//td[2]//input[@value]")
	public static WebElement LMBase;

	@FindBy(xpath="//table[@class='table_price']//tr[2]//td[3]//table//tr[6]//td[3]//input")
	public static WebElement lastminhigher_editbox;

	@FindBy(xpath="//table//tr[6]//td[13]/img[@title='Save']")
	public static WebElement lastmin_save;

	@FindBy(xpath="//table//tr[7]//td[13]/img")
	public static WebElement webratebase_editbtn;

	@FindBy(xpath="//table[@class='table_price']//tr[2]//td[3]//table//tr[7]//td[2]//input[@value]")
	public static WebElement WRBase;

	@FindBy(xpath="//table//tr[7]//td[13]/img[@title='Save']")
	public static WebElement webrate_save;

	@FindBy(xpath="//table[@class='table_price']//tr")
    public static List<WebElement> rowcount;


	public static String name1;
	public static String price;

	public  String getName() throws Exception
	{
		try
		{
		String roomType=GenericMethods.getText(roomType_name);
		String[] lines=roomType.split("\n");
		name1=lines[0];
		System.out.println(name1);
		//System.out.println(roomType);
	    return name1;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public  String get_LastMinRate() throws Exception
	{
		try
		{
			int count=GenericMethods.tr_count(rowcount);
			for(int i=2;i<=count;i++)
			{
				String str=GenericMethods.driver.findElement(By.xpath("//table[@class='table_price']//tr[2]//td[3]//tr["+i+"]")).getText();
				if(str.contains("Last Min Rate"))
				{
					Assert.assertTrue(str.contains("Last Min Rate"));
					price=GenericMethods.driver.findElement(By.xpath("//table[@class='table_price']//tr[2]//td[3]//table//tr["+i+"]//td[2]//input")).getAttribute("value");
					System.out.println(price);
					break;
				}
			}

		return price;
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


	public  String get_WebRate() throws Exception
	{
		try
		{
			int count=GenericMethods.tr_count(rowcount);
			for(int i=2;i<=count;i++)
			{
				String str=GenericMethods.driver.findElement(By.xpath("//table[@class='table_price']//tr[2]//td[3]//tr["+i+"]")).getText();
				if(str.contains("Web Rate"))
				{
					Assert.assertTrue(str.contains("Web Rate"));
					price=GenericMethods.driver.findElement(By.xpath("//table[@class='table_price']//tr[2]//td[3]//table//tr["+i+"]//td[2]//input")).getAttribute("value");
					System.out.println(price);
					break;
				}
			}

		return price;
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



	public  BasePage clk_cancel() throws Exception
	{
		try
		{
		GenericMethods.clickElement(cancel_btn);
		BasePage BP = PageFactory.initElements(GenericMethods.driver, BasePage.class);
		return BP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}



	public static String abc;
	public static String a;
	public static String b;

	public String SpecialPeriod_Price() throws Exception
	{
		try
		{
		GenericMethods.clickElement(EditRatesRP);
		LowBaseOccPrice.clear();
		GenericMethods.sendKeys(LowBaseOccPrice, "500.00");
		abc="500.00";
		LowHighPPP.clear();
		GenericMethods.sendKeys(LowHighPPP, "400");
		//LowEBP.clear();
		//GenericMethods.sendKeys(LowEBP, "200");
		//GenericMethods.clickElement(LowPS);
		//RoomPricesLandingPage.abc=abc;
		return abc;
		}
		catch(Exception e)
		{
			throw e;
		}
   }


	public void fn_saveSPPrice() throws Exception
	{
		try
		{
		GenericMethods.clickElement(LowPS);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(3000);
			GenericMethods.js_Click(LowPS);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public void SpecialRatesVerify()
	{
      String abcd=SBOP.getAttribute("value");
      Assert.assertEquals(abcd, abc);
	}

	public String lastminrate() throws Exception
	{
		try
		{
		GenericMethods.clickElement(lastmin_editbtn);
		lastminbase_editbox.clear();
		GenericMethods.sendKeys(lastminbase_editbox, "550.00");
		a="550.00";
		lastminhigher_editbox.clear();
		GenericMethods.sendKeys(lastminhigher_editbox, "440");
		//RoomPricesLandingPage.a=a;
		return a;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public void lastmin_save() throws Exception
	{
		try
		{
		GenericMethods.clickElement(lastmin_save);
		}
		catch(NoSuchElementException e)
		{
		    Thread.sleep(3000);
		    GenericMethods.js_Click(lastmin_save);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public void lastmin_verify()
	{
		String verify=LMBase.getAttribute("value");
		Assert.assertEquals(verify, a);
	}


	public String webrate() throws Exception
	{
		try
		{
		GenericMethods.clickElement(webratebase_editbtn);
		webratebase_editbox.clear();
		GenericMethods.sendKeys(webratebase_editbox,"600.00");
		b="600.00";
		webratehigher_editbox.clear();
		GenericMethods.sendKeys(webratehigher_editbox, "650");
		//RoomPricesLandingPage.b=b;
		return b;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public void webrate_save() throws Exception
	{
		try
		{
		GenericMethods.clickElement(webrate_save);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(3000);
			GenericMethods.js_Click(webrate_save);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public void webrate_verify()
	{
		String verify1=WRBase.getAttribute("value");
		Assert.assertEquals(verify1,b );
	}


}

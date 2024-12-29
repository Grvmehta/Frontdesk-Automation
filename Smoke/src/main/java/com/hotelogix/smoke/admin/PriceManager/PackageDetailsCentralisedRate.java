package com.hotelogix.smoke.admin.PriceManager;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.admin.PriceManager.DefinePackageCentralizedRate;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackageCentralizedRate;
import com.hotelogix.smoke.genericandbase.GenericMethods;

import junit.framework.Assert;

public class PackageDetailsCentralisedRate {
	public static String priceOfPAckage;

	@FindBy(xpath="//td[@class='table-head-inside-light']//a")
	public static WebElement view_Link;

	@FindBy(xpath="//td[@class='table-validity']//table//tbody//tr[3]//tbody//tr[2]//td[5]/a")
    public static WebElement PPPR;

	@FindBy(xpath="//td[@class='table-head-inside-light']//div/a")
	public static WebElement editLink;


	@FindBy(xpath="//td[@class='table-head-inside-light']//div/a")
	public static WebElement configure_link;

	@FindBy(xpath="//tbody//tr//td[text()='fj ']")
	public static WebElement roomTypeName;

	//[contains(text(),('" + date1 + "') )]

	@FindBy(xpath="//td[@class='table-validity']//table//tbody//tr[3]//tbody//tr")
	public static List<WebElement> roomTypeDetails;

	@FindBy(xpath="//input[@name='btnSubmit']")
	public static WebElement save_Bt;

	@FindBy(xpath="//td[@class='pkgPropertyBack']//tbody/tr//td[2]/a")
	public static WebElement namePkg;

	public static String pkgName;

	@FindBy(xpath="//td[@class='table-validity']//tbody//tr[3]//tbody//tr[2]/td")
	public static WebElement roomTypeName1;




public static String nameRoomType;
	public String getRoomTypeName() throws Exception{
		try
		{
		nameRoomType=GenericMethods.getText(roomTypeName1);
		return nameRoomType;
		}
		catch(Exception e)
		{
			throw e;
		}
	}





	public  String getPkgName() throws Exception
	{
		try
		{
		pkgName=GenericMethods.getText(namePkg);
	    return pkgName;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public static void packageDetails(){
		int abc=GenericMethods.tr_count(roomTypeDetails);
		System.out.println(abc);
		}

	public  ListOfPackageCentralizedRate clickOnSave() throws Exception
	{
		try
		{
		GenericMethods.clickElement(save_Bt);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(3000);
			GenericMethods.js_Click(save_Bt);
		}
		catch(Exception e)
		{
			throw e;
		}
		ListOfPackageCentralizedRate pageobj=PageFactory.initElements(GenericMethods.driver, ListOfPackageCentralizedRate.class);
	return pageobj;
	}

	
	
	public  PackageDetailsCentralisedRate clickOnView() throws Exception{

		try
		{
		GenericMethods.clickElement(view_Link);
		}
		catch(Exception e)
		{
			throw e;
		}
		PackageDetailsCentralisedRate pageobj=	PageFactory.initElements(GenericMethods.driver, PackageDetailsCentralisedRate.class);
		return pageobj;
	}



	public static DefinePackageCentralizedRate clickOnEdit() throws Exception{
		GenericMethods.clickElement(editLink);

		DefinePackageCentralizedRate pageobj=	PageFactory.initElements(GenericMethods.driver, DefinePackageCentralizedRate.class);
		return pageobj;
	}

	public  String getPackagePrice(String Actual) throws Exception
	{
		try
		{
		 int trcount=GenericMethods.tr_count(roomTypeDetails);
       System.out.println("gettdfortr" + trcount);

       for(int i=2;i<trcount;i++)
       {
       String data=GenericMethods.driver.findElement(By.xpath("//td[@class='table-validity']//table//tbody//tr[3]//tbody//tr["+i+"]/td")).getText();
       System.out.println(data);
       if(data.equals(Actual))
       {
           WebElement toclick=GenericMethods.driver.findElement(By.xpath("//td[@class='table-validity']//table//tbody//tr[3]//tbody//tr["+i+"]//td[4]/a"));
          priceOfPAckage=toclick.getText();
          System.out.println(priceOfPAckage + " PackageDetailsCentralisedRate");
          break;

       }
       
       }
       
   
       return  priceOfPAckage;
		}
		catch(Exception e)
	       {
	    	   throw e;
	       }
       
}
	@FindBy(xpath="//input[starts-with(@id,'totalPackagePriceBox')]")
    public static WebElement PackagePrice_ED;

	public  String fn_alterPkgPrice(String Actual,String newPrice) throws Exception
	{
		try
		{
		
			ArrayList<String> arr=new ArrayList<String>();
		 int trcount=GenericMethods.tr_count(roomTypeDetails);
		 for(int i=2;i<trcount;i++)
		 {
		       String data=GenericMethods.driver.findElement(By.xpath("//td[@class='table-validity']//table//tbody//tr[3]//tbody//tr["+i+"]/td")).getText();
               arr.add(data);
		       if(data.equals(Actual))
		       {
		    	   
		    	   Assert.assertEquals(data.equals(Actual), true);
		          WebElement toclick=GenericMethods.driver.findElement(By.xpath("//td[@class='table-validity']//table//tbody//tr[3]//tbody//tr["+i+"]//td[4]/a"));
		          Actions action= new Actions(GenericMethods.driver);
		          action.moveToElement(toclick).click().perform();
		          PackagePrice_ED.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		          PackagePrice_ED.sendKeys(newPrice);
		          System.out.println(newPrice + "  Package Details Centralised Rate");
		          Thread.sleep(4000);
		          GenericMethods.js_Click(PPPR);
		          break;

		       }

	      }
		 
		 Assert.assertEquals(arr.contains(Actual), true);
		}
		catch(AssertionError e)
		{
			throw e;
		}

		catch(Exception e)
		{
			throw e;
		}
		return newPrice;
	}

}

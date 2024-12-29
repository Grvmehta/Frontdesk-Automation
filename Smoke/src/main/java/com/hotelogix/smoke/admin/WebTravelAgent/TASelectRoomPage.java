package com.hotelogix.smoke.admin.WebTravelAgent;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.hotelogix.smoke.admin.PriceManager.PackageDetailsCentralisedRate;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class TASelectRoomPage 
{

	@FindBy(xpath="//form[@id='frmWebRes']//table//tr[2]/td/span")
    public  WebElement txt_header;
		
	@FindBy(xpath="//form[@id='frmWebRes']//tbody//tr[7]//td[@class='brdr-btm'][2]//tbody//tr")
	public static List<WebElement> package_count;

	@FindBy(xpath="//form[@id='frmWebRes']//tbody//tr")
	public static List<WebElement> count;
	
	
	
	public String verify_pageHeader() throws Exception
	{
		try
		{
		String txt=GenericMethods.getText(txt_header);
		return txt;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	
	public  String  packageVerify(String pkgRate)
	{
//		List<WebElement> abc=package_count;
//		int a=abc.size();
		String pkgPrice = null;
		String price= null;
		int noOfPackage=GenericMethods.tr_count(package_count);
		for (int i=1; i<=noOfPackage;i=i+4)
		{
			String pkgName = GenericMethods.driver.findElement(By.xpath("//td[@class='brdr-btm']//tbody//tr["+i+"]/td/strong")).getText();
			//System.out.println(pkgName);
			if(pkgName.contains(PackageDetailsCentralisedRate.pkgName))
			{
				System.out.println("Package name matched");
				 pkgPrice = GenericMethods.driver.findElement(By.xpath("//td[@class='brdr-btm']//tbody//tr["+i+"]//td[2]/strong")).getText();
				System.out.println(pkgPrice);
				//int j=pkgPrice.indexOf(",");
				String[] p=pkgPrice.split(",");
				 price=p[0]+p[1];
				Assert.assertTrue(price.contains(pkgRate));
			break;
			}
//			else
//			{
//				System.out.println("Package name not matched");
//			}
		}
		return price;
	}
	
	
	
	public  void packagePriceVerify(String name,String pkgRate) throws Exception
	{
		try
		{
		ArrayList<String> arr=new ArrayList<String>();
		
		int no=GenericMethods.tr_count(count);
		for(int i=7;i<=no-2;i++)
		{
	     String nameRoomType = GenericMethods.driver.findElement(By.xpath("//form[@id='frmWebRes']//tbody//tr["+i+"]//td[@class='brdr-btm']/h5")).getText();
         arr.add(nameRoomType);
	     if(nameRoomType.equals(name))
	     {
	    	 Assert.assertEquals(nameRoomType.equals(name), true);
	    	 String pkgPrice =packageVerify(pkgRate);
		     String priceOfPackage = "Rs "+pkgRate;
		     System.out.println(priceOfPackage);
		     if(pkgPrice.contains(priceOfPackage))
		         {
	                 Assert.assertEquals(pkgPrice.contains(priceOfPackage), true);	    	 
			         System.out.println("Package Price Matched");
			         break;
		         }
		

		}
	    else
	     {
			System.out.println("Room Type not matched");
		}
	    
		}
		Assert.assertEquals(arr.contains(name), true);
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

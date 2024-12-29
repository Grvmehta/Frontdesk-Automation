package com.hotelogix.smoke.frontdesk.WebReservation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.admin.PriceManager.DefinePackageCentralizedRate;
import com.hotelogix.smoke.admin.PriceManager.PackageDetailsCentralisedRate;
import com.hotelogix.smoke.admin.PriceManager.PackageDetailsWeb;
import com.hotelogix.smoke.admin.PriceManager.RoomPricesLandingPage;
//import com.hotelogix.smoke.admin.WebBookingEngine.WebReservationConsole;
//import com.hotelogix.smoke.admin.WebBookingEngine.WebReservationConsole;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class WebSelectRoomPage
{
	public static String st = "OneNightpackage";


	@FindBy(xpath="//form[@id='frmWebRes']//table//tr[2]/td/span")
    public static WebElement SectionTitle;

	@FindBy(xpath="//input[@value='Select']")
    public static WebElement Select_BT;

	@FindBy(xpath="//table[@class='tbl-contentNew']//tr['2']//td[2]//table//tr")
    public static List<WebElement> Tr_Count;

	@FindBy(xpath="//table[@class='tbl-contentNew']//tr[2]/td[1]")
    public static List<WebElement> roomtype_count;

	@FindBy(xpath="//td/span[@class='title']")
	public static WebElement pageTitle;

	@FindBy(xpath="//a[@class='link-more-details']")
	public static WebElement moreDetailsLnk;

	@FindBy(xpath="//table[@class='tbl-contentNew']//tr[3]//table//td[2]//strong")
	public static WebElement pkgPrice;

	@FindBy(xpath="//table[@class='tbl-contentNew']//tr[3]//table//td[2]//span")
	public static WebElement discountPrice;

	@FindBy(xpath="//table[@class='tbl-contentNew']//tbody//tr[3]//td[2]//table//td[3]//input")
	public static WebElement RoomToSelect;

	@FindBy(xpath="//form[@id='frmWebRes']//tbody//tr[7]//td[@class='brdr-btm'][2]//tbody//tr")
	public static List<WebElement> package_count;

	@FindBy(xpath="//form[@id='frmWebRes']//tbody//tr")
	public static List<WebElement> count;

	@FindBy(xpath="//table[@class='tbl-contentNew']//tr[2]//td[6]//strong")
    public static WebElement AmountRate_Text;


    public static    String sobj;
    public static String LMR = "Last Min Rate";



	public String fn_ValidateRoomPackagesSection() throws Exception
	{
		try
		{
        String str=GenericMethods.getText(SectionTitle);
        return str;
		}
		catch(Exception e)
		{
			throw e;
		}
    }

	public WebAddMoreRoomPage fn_SelectRoomandRate() throws Exception
	{
		try
		{
        GenericMethods.clickElement(Select_BT);
        String str=GenericMethods.getText(SectionTitle);
        if(str.equalsIgnoreCase("Reservation Detail"))
        {
            System.out.println("Reservation Detail section is visible on Web Reservation");

        }

        WebAddMoreRoomPage WARP=PageFactory.initElements(GenericMethods.driver, WebAddMoreRoomPage.class);
        return WARP;
		}
		catch(Exception e)
		{
			throw e;
		}
     }

    public static String pPrice;
	public void fn_getPkgPriceDisc() throws Exception
	{

		try
		{
		pPrice=GenericMethods.getText(pkgPrice);
		String a=GenericMethods.getText(discountPrice);
		int i=a.indexOf("(");
		discPrice=a.substring(i+1, a.indexOf(")"));
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public static String discPrice;
	public void fn_getDiscountedPrice() throws InterruptedException
	{
		String a=GenericMethods.getText(discountPrice);
		int i=a.indexOf("(");
		discPrice=a.substring(i, a.indexOf(")"));

	}


    public WebMoreDetailsPage fn_clkMoreDetails() throws Exception
    {
    	try
    	{
    	GenericMethods.js_Click(moreDetailsLnk);
    	WebMoreDetailsPage MDP=PageFactory.initElements(GenericMethods.driver, WebMoreDetailsPage.class);
    	return MDP;
    	}
    	catch(Exception e)
    	{
    		throw e;
    	}
    }





	public WebAddMoreRoomPage fn_SelectWebPackagesOnWeb() throws Exception
	{
		try
		{
        int trobj=GenericMethods.tr_count(Tr_Count);

        for(int i=1; i<=trobj; i+=4)
        {
            WebElement str=GenericMethods.driver.findElement(By.xpath("//table[@class='tbl-contentNew']//tr['2']//td['2']//table//tr["+i+"]//strong"));
        	//table//tr[7]//table//tr[2]//table//tbody//tr[1]//strong
        	 //WebDriver driver = GenericMethods.driver;
        	 //driver.get("https://www.google.co.in/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=solution+for+null+pointer+exception");
        	//WebElement str=GenericMethods.driver.findElement(By.xpath("//form[@id='frmWebRes']"));
        	String str2 = str.getText();
          //  String str = GenericMethods.driver.findElement(By.xpath("//strong[@class='size12']")).getText();
        	if(str2.contains(WebSelectRoomPage.st))
        	{
                WebElement wobj=GenericMethods.driver.findElement(By.xpath("//table[@class='tbl-contentNew']//table//tr["+i+"]//input"));
                wobj.click();
                break;
            }
        }
        String str=GenericMethods.getText(SectionTitle);
        if(str.equalsIgnoreCase("Reservation Detail"))
        {
            System.out.println("Reservation Detail section is visible on Web Reservation");

        }

        WebAddMoreRoomPage WARP=PageFactory.initElements(GenericMethods.driver, WebAddMoreRoomPage.class);
        return WARP;
		}
		catch(Exception e)
		{
			throw e;
		}

	}


	public void fn_CheckWebRate()
    {
    	int count=GenericMethods.tr_count(roomtype_count);
    	for(int i=2;i<=count;i++)
    	{
    		String data=GenericMethods.driver.findElement(By.xpath("//table[@class='tbl-contentNew']//tr["+i+"]/td[1]//strong")).getText();
    		if(data.equals(RoomPricesLandingPage.name1))
    		{
    			int trobj=GenericMethods.tr_count(Tr_Count);
    	        for(int j=1; j<=trobj; j+=4)
    	        {
    	            String str=GenericMethods.driver.findElement(By.xpath("//table[@class='tbl-contentNew']//table//tr["+j+"]/td[1]/strong")).getText();
    	            if(str.contains(RoomPricesLandingPage.price))
    	            {
    	                sobj=GenericMethods.driver.findElement(By.xpath("//table[@class='tbl-contentNew']//table//tr["+i+"]//td[2]//strong")).getText();
    	                //WebElement wobj=GenericMethods.driver.findElement(By.xpath("//table[@class='tbl-contentNew']//table//tr["+i+"]//input"));
    	                //wobj.click();
    	                Assert.assertEquals(sobj,"Rs. "+RoomPricesLandingPage.price);
    	                break;
    	            }
    	        }

    		}
    	}
    }


	public void fn_ValidateLastMinRate() throws Exception
	{
		try
		{
        int trobj=GenericMethods.tr_count(Tr_Count);
        for(int i=1; i<=trobj; i+=4)
        {
            String str=GenericMethods.driver.findElement(By.xpath("//table[@class='tbl-contentNew']//table//tr["+i+"]//strong")).getText();
            if(str.contains(WebSelectRoomPage.LMR))
            {
            	Assert.assertTrue(str.contains(WebSelectRoomPage.LMR));
                System.out.println("LastMinRate is Seen on Select Rooms/Packages section");
                break;
             }
        }
		}
		catch(Exception e)
		{
			throw e;
		}

	}

	public  void pageVerify() throws Exception
	{

       try
       {
	Thread.sleep(3000);
	String titel=	GenericMethods.getText(pageTitle);
	Assert.assertEquals(titel, "Select Rooms/Packages");
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


	public WebAddMoreRoomPage SelectRoom() throws Exception
	{
		try
		{
		GenericMethods.clickElement(RoomToSelect);
		WebAddMoreRoomPage WMR=PageFactory.initElements(GenericMethods.driver, 	WebAddMoreRoomPage.class);
		return WMR;
		}
		catch(Exception e)
		{
			throw e;
		}

	}


	public static String  packageVerify(String pkgRate)
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
	     String nameRoomType1 = GenericMethods.driver.findElement(By.xpath("//form[@id='frmWebRes']//tbody//tr["+i+"]//td[@class='brdr-btm']/h5")).getText();
         arr.add(nameRoomType1);
	          if(nameRoomType1.equals(name))
	            {
	    	 
	        	    Assert.assertEquals(nameRoomType1.equals(name), true);
		            String pkgPrice =packageVerify(pkgRate);
		            String priceOfPackage = "Rs "+pkgRate;
		            System.out.println(priceOfPackage);
		               if(pkgPrice.contains(priceOfPackage))
		                 {
			               System.out.println("Package Price Matched");
			               break;
		                 }		           
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




	public void fn_CheckPackageRatePrice() throws Exception
	{
		try
		{
        int trobj=GenericMethods.tr_count(Tr_Count);
        for(int i=1; i<=trobj; i+=4)
        {
            String str=GenericMethods.driver.findElement(By.xpath("//table[@class='tbl-contentNew']//table//tr["+i+"]//strong")).getText();
            if(str.contains(WebSelectRoomPage.st))
            {
                sobj=GenericMethods.driver.findElement(By.xpath("//table[@class='tbl-contentNew']//table//tr["+i+"]//td[2]//strong")).getText();
                WebElement wobj=GenericMethods.driver.findElement(By.xpath("//table[@class='tbl-contentNew']//table//tr["+i+"]//input"));
                wobj.click();
                break;
        }
        }
        String str=GenericMethods.getText(AmountRate_Text);
        if(str.contains(sobj))
        {
            System.out.println("Price Matched to Select room page");
       }
		}
		catch(Exception e)
		{
			throw e;
		}
       }



	public void verify_PublishedPkgPrice() throws Exception
	{
		try
		{
        int trobj=GenericMethods.tr_count(Tr_Count);
        for(int i=1; i<=trobj; i+=4)
        {
            String str=GenericMethods.driver.findElement(By.xpath("//table[@class='tbl-contentNew']//table//tr["+i+"]//strong")).getText();
            if(str.contains(PackageDetailsWeb.name))
            {
                sobj=GenericMethods.driver.findElement(By.xpath("//table[@class='tbl-contentNew']//table//tr["+i+"]//td[2]//strong")).getText();
                String[] s=sobj.split("\\.");
                String[] a=s[0].split(",");
                String sobj1=a[0]+a[1];
                Assert.assertTrue(sobj1.contains(PackageDetailsWeb.pkgPrice));
                break;
        }
        }
		}
		catch(Exception e)
		{
			throw e;
		}

	}



	public void verify_LastMinPrice() throws Exception
	{
		try
		{
        int trobj=GenericMethods.tr_count(Tr_Count);
        for(int i=1; i<=trobj; i+=4)
        {
            String str=GenericMethods.driver.findElement(By.xpath("//table[@class='tbl-contentNew']//table//tr["+i+"]//strong")).getText();
            if(str.contains("Last Min Rate"))
            {
                sobj=GenericMethods.driver.findElement(By.xpath("//table[@class='tbl-contentNew']//table//tr["+i+"]//td[2]//strong")).getText();
                Assert.assertTrue(sobj.contains(RoomPricesLandingPage.price));
                break;
        }
        }
		}
		catch(Exception e)
		{
			throw e;
		}

	}

}


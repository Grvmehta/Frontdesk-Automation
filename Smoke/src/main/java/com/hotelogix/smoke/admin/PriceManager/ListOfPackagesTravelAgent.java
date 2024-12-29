package com.hotelogix.smoke.admin.PriceManager;

import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;


public class ListOfPackagesTravelAgent {
	public static String windowID;
	public static String statusDeactive;
	public static String statusActive;

	@FindBy(xpath="//div[@class='headingtxt']//tr//td[2]")
	public static WebElement pgetitle;

	@FindBy(xpath="//div[@id='listing-icons']//ul//li[4]/a")
	public static WebElement attachPackageImg_BT;

	@FindBy(xpath="//table[@class='list_viewnew']//tr//td[8]/a")
	public static WebElement configure_link;

	@FindBy(xpath="//table[@class='list_viewnew']//tr//td[7]/a")
	public static WebElement addActivationDate_link;

	@FindBy(xpath="//table[@class='list_viewnew']//tr//td[7]")
	public static WebElement activatedForever_txt;

	@FindBy(xpath="//table[@class='list_viewnew']//tr//td[9]/img")
	public static WebElement status;

	@FindBy(xpath="//select[@name='maxEntries']")
    public static WebElement view_DepDwn;

	@FindBy(xpath="//table[@class='list_viewnew']/tbody//tr//input[@type='checkbox']")
    public static List<WebElement> checkBox;

	@FindBy(xpath="//table[@class='list_viewnew']//tr[2]//td[8]/a")
	public static WebElement addviewpkg_lnk;

	@FindBy(xpath="//input[@name='id[]']")
	public static List<WebElement> chkbox;

	public static String actiDate_lnkWeb="Add Activation Date";
	public static String ActivForever="Activated Forever";

	public static void verify_title() throws InterruptedException
	{
		String text=GenericMethods.getText(pgetitle);
		Assert.assertEquals(text,"List of Packages (Travel Agent)-"+TravelAgentPackagesLandingPage.data);
	}



    public static ListOfPackagesTravelAgent view() throws Exception{

         GenericMethods.selectElement(view_DepDwn, "All");
         GenericMethods.ActionOnAlert("Accept");
         GenericMethods.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         ListOfPackagesTravelAgent pageobj=    PageFactory.initElements(GenericMethods.driver, ListOfPackagesTravelAgent.class);
         return pageobj;
        }

	public static attachPackages attachPackage() throws Exception{
		//windowID=GenericMethods.GetCurrentWindowID();
		GenericMethods.clickElement(attachPackageImg_BT);
		attachPackages pageobj=	PageFactory.initElements(GenericMethods.driver, attachPackages.class);
		return pageobj;
	}

	public static PackageDetailsTravelAgent configurePackageTA(String pkgName) throws Exception{

	    //    GenericMethods.clickElement(configure_link);


	        int trcount=GenericMethods.tr_count(checkBox);
	        for(int i=2;i<=trcount;i++)
	        {
	           String data=  findpackage(i);
	           if(data.contains(pkgName))
	           {
	            System.out.println("Searched Package Find");
	            WebElement  abc=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[8]/a[text()='Configure']"));
	            abc.click();
	            break;
	           }

	        else
	        {
	            System.out.println("Not verified");
	        }
	        }
	        PackageDetailsTravelAgent pageobj=PageFactory.initElements(GenericMethods.driver,PackageDetailsTravelAgent.class);
	        return pageobj;
	}

	public static AddActivationDateTA addActivationDateTA(String pkgName) throws Exception{
        windowID = GenericMethods.GetCurrentWindowID();

        int trcount=GenericMethods.tr_count(tr_count);
            for(int i=2;i<=trcount;i++){
               String data=  findpackage(i);
               if(data.contains(pkgName)){
                System.out.println("Searched Package Find");
                WebElement  abc=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[7]/a[text()='Add Activation Date']"));
                abc.click();
                break;
            }
            else{
                System.out.println("Not verified");
            }
         }
        AddActivationDateTA pageobj=PageFactory.initElements(GenericMethods.driver, AddActivationDateTA.class);
        return pageobj;
    }
	public static void verifyForeverActivationOfTAPackage() throws InterruptedException{
		String abc=GenericMethods.getText(activatedForever_txt);
		//statusActive=status.getAttribute("src");
		if(abc.contains("Activated Forever")){
			System.out.println("'Add Activation Date' link changed to 'Activated Forever' text");
		}else{
			System.out.println("link not changed");
		}

		Assert.assertEquals(abc, "Activated Forever");
	}


	public static String findpackage(int i){

		String name= GenericMethods.driver.findElement(By.xpath("//tr["+i+"]//td/strong//a")).getText();
		return name;
		}
	@FindBy(xpath="//input[@type='checkbox']")
	public static List<WebElement> tr_count;

	public static Boolean statusResult = null;
	public static Boolean chkStatus(String pkgName){
		int count=	GenericMethods.tr_count(tr_count);
		for(int i=2;i<=count;i++){
			String name=findpackage(i);
		if(name.equals(pkgName)){
		String src=	GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[9]/img")).getAttribute("src");
		if(src.contains("on.GIF")){
			System.out.println("Status is ON");
			statusResult=true;
		}else{
			System.out.println("status is Off");
			 statusResult=false;
		}
		break;
		}else{
			System.out.println("Added category matched on POS products List page");
		}

	}
		return statusResult;
	}

	public static Boolean statusResultAfter;
	public static Boolean chkStatusAfter(String pkgName){

		int count=	GenericMethods.tr_count(tr_count);
		for(int i=2;i<=count;i++){
			String name=findpackage(i);
		if(name.equals(pkgName)){
		String src=	GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[9]/img")).getAttribute("src");
		if(src.contains("on.GIF")){
			System.out.println("Status is ON");
			statusResultAfter=true;
		}else{
			System.out.println("status is Off");
			statusResultAfter=false;
		}
		break;
		}else{
			System.out.println("Added category matched on POS products List page");
		}

	}
		return statusResultAfter;
	}


	public static void compareStatus(){
		if(statusResult.equals(statusResultAfter)){
			System.out.println("Status not changed");
		}else{
			System.out.println("status changed");
		}
		Assert.assertEquals(statusResult.equals(statusResultAfter), false);
	}

	public static ListOfPackagesTravelAgent1 click_addviewpkg() throws Exception
	  {
		try
		{
		  //GenericMethods.clickElement(addviewpkg_lnk);
		GenericMethods.clickElement(addviewpkg_lnk);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(1000);
			GenericMethods.js_Click(addviewpkg_lnk);
		}
		catch(Exception  e)
		{
			Thread.sleep(1000);
			Actions actobj=new Actions(GenericMethods.driver);
			actobj.moveToElement(addviewpkg_lnk).click().perform();

		}
		  ListOfPackagesTravelAgent1 LPTA1=PageFactory.initElements(GenericMethods.driver, ListOfPackagesTravelAgent1.class);
		  return LPTA1;
	  }


	static ArrayList<String> list1=new ArrayList<String>();
	static ArrayList<String> list2=new ArrayList<String>();

	public static void getPkgID1()
	{
		int count1=GenericMethods.tr_count(chkbox)+1;
		for(int i=2;i<=count1;i++)
		{
			String url1=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]/a")).getAttribute("href");
			String ID1=url1.substring(url1.lastIndexOf("/")+1);
			list1.add(ID1);
		}
	}

	public static void getPkgID2()
	{
		int count2=GenericMethods.tr_count(chkbox)+1;
		for(int j=2;j<=count2;j++)
		{
			String url2=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+j+"]//td[8]/a")).getAttribute("href");
			String ID2=url2.substring(url2.lastIndexOf("/")+1);
			list2.add(ID2);
		}

	}

	public static String b;
	public static String name1;

	public static String verifyPkg_Relational()
	{
		list2.removeAll(list1);
	   	 b="";
	   	 for(String str1 : list2)
	   	 {
	   		 b+=str1;
	   	 }
	   	 System.out.println(b);
	   	int count=GenericMethods.tr_count(chkbox);
	   	for(int i=2;i<=count;i++)
	   	{
	   		 String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]/a")).getAttribute("href");
             if(data.contains(b))
             {
       			 String pkg_name=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
                 Assert.assertTrue(pkg_name.contains("Copy of "+attachPackages.c+"*"));
                 String activation=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]/img")).getAttribute("src");
                 Assert.assertTrue(activation.contains("off.GIF"));
                 String status=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[9]/img")).getAttribute("src");
                 Assert.assertTrue(status.contains("off.GIF"));
                 String configureLnk=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]/a")).getText();
                 Assert.assertEquals(configureLnk, "Configure");
                 System.out.println("attached package name is verified");
                 String[] lines=pkg_name.split("\n");
       			 String name1=lines[0];
       			 System.out.println(name1);
       			 Assert.assertTrue(name1.contains(attachPackages.c));
                 break;
             }
	   	}
	   	return name1;
	}




	public static String s;
	public static PackageDetailsTravelAgent confgr_attachedPkgTA() throws Exception

	{
		list2.removeAll(list1);
	    s="";
	    for (String str : list2)
	    {
	    	s+=str;
	    }
		System.out.println(list2);
		int item_count=GenericMethods.tr_count(chkbox);
		for(int k=2;k<=item_count;k++)
		{
			String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[8]/a")).getAttribute("href");
			System.out.println(data);
			if(data.contains(s))
			{
				GenericMethods.clickElement(configure_link);
				break;
			}
		}

		PackageDetailsTravelAgent PDW=PageFactory.initElements(GenericMethods.driver, PackageDetailsTravelAgent.class);
    	return PDW;

	}



	public static void verifyAddActivationDate_linkTA() throws Exception
	{
		int item_count=GenericMethods.tr_count(chkbox)+1;
		for(int k=2;k<=item_count;k++)
		{
			String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[8]/a")).getAttribute("href");
			System.out.println(data);
			if(data.contains(ListOfPackagesTravelAgent1.s))
			{
				String str=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[7]/a")).getText();
				Assert.assertEquals(str, actiDate_lnkWeb);
				String str1=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[8]/a")).getText();
				Assert.assertEquals(str1, "Edit");
				break;
			}
		}


	}

	public static AddActivationDateTA NavTo_ActivationDateTA() throws Exception
	{
		windowID = GenericMethods.GetCurrentWindowID();
		int count=GenericMethods.tr_count(chkbox)+1;
		for(int i=2;i<=count;i++)
		{

			String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]/a")).getAttribute("href");
			System.out.println(data);
			if(data.contains(ListOfPackagesTravelAgent1.s))
			{
				GenericMethods.clickElement(addActivationDate_link);
			}

		}
			AddActivationDateTA pageobj=PageFactory.initElements(GenericMethods.driver, AddActivationDateTA.class);
			return pageobj;
	}



	public static void verifyActivatedForever_textTA()
	{
		int tble_count=GenericMethods.tr_count(chkbox)+1;
		for(int i=2;i<=tble_count;i++)
		{
			String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]/a")).getAttribute("href");
			System.out.println(data);
			if(data.contains(ListOfPackagesTravelAgent1.s))
			{
				String str=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]")).getText();
				Assert.assertEquals(str, ActivForever);
			}

		}
	}

















}

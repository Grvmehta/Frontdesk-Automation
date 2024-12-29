package com.hotelogix.smoke.admin.PriceManager;

import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.hotelogix.smoke.admin.BaseClass.AdmineHome;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class ListOfPackagesTravelAgent1

{
	@FindBy(xpath="//a[@title='Attach a Package']")
	   public static WebElement attachPkg_btn;

	@FindBy(xpath="//select[@name='maxEntries']")
	public static WebElement view_dropdwn;

	@FindBy(xpath="//table[@class='list_viewnew']/tbody//tr")
    public static List<WebElement> trcount;

	@FindBy(xpath="//input[@type='checkbox']")
	public static List<WebElement> tr_count;

	@FindBy(xpath="//table[@class='list_viewnew']//tr//td[7]")
	public static WebElement activatedForever_txt;

	@FindBy(xpath="//input[@name='id[]']")
	public static List<WebElement> chkbox;

	@FindBy(xpath="//table[@class='list_viewnew']//tr//td[8]/a")
	public static WebElement configure_link;

	@FindBy(xpath="//table[@class='list_viewnew']//tr//td[7]/a")
	public static WebElement addActivationDate_link;



	   public static String windowID;

	   public  attachPackages click_attackPkgbtn() throws Exception
	   {
		   try
		   {
		   GenericMethods.clickElement(attachPkg_btn);
		   }
		   catch(NoSuchElementException e)
		   {
			   Thread.sleep(2000);
			   GenericMethods.js_Click(attachPkg_btn);
		   }
		   catch(Exception e)
		   {
			   throw e;
		   }
		   attachPackages pageobj=	PageFactory.initElements(GenericMethods.driver, attachPackages.class);
		   return pageobj;
	   }

	   public static String findpackage(int i){

			String name= GenericMethods.driver.findElement(By.xpath("//tr["+i+"]//td/strong//a")).getText();
			return name;
			}

	   public void  view_All() throws Exception
		{
		   try
		   {
			GenericMethods.selectElement(view_dropdwn, "All");
			GenericMethods.ActionOnAlert("Accept");
		   }
		   catch(Exception e)
		   {
			   throw e;
		   }
		}

	   public static PackageDetailsTravelAgent configurePackageTA(String pkgName) throws Exception{

		    //    GenericMethods.clickElement(configure_link);


		        int count=GenericMethods.tr_count(trcount);
		        for(int i=2;i<=count;i++)
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



	   public static AddActivationDateTA addActivationDateTA(String pkgName) throws Exception
	   {
	       // windowID = GenericMethods.GetCurrentWindowID();

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


	   public static Boolean statusResult = null;
	   public static Boolean chkStatus(String pkgName)
	   {
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


		public static void verifyForeverActivationOfTAPackage() throws InterruptedException{
			String abc=GenericMethods.getText(activatedForever_txt);
			//statusActive=status.getAttribute("src");
//			if(abc.contains("Activated Forever"))
//			{
//				System.out.println("'Add Activation Date' link changed to 'Activated Forever' text");
//
//			}
//			else
//			{
//				System.out.println("link not changed");
//			}

			//Assert.assertEquals(abc, "Activated Forever");
			if(abc.contains("Activated Forever"))
			{

            	AdmineHome.bResult=true;
                Reporter.log("Activate Forever text is being displayed",true);


            }
            else
            {
            	AdmineHome.bResult=false;
            	if(AdmineHome.bResult==false)
            	{
            		Reporter.log("Heyy Plss check on with verifyActivatedForeverFD_text method ",true);
            	}
            }

		}

		public static void compareStatus(){
			if(statusResult.equals(statusResultAfter)){
				System.out.println("Status not changed");
			}else{
				System.out.println("status changed");
			}
			Assert.assertEquals(statusResult.equals(statusResultAfter), false);
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

		public  String verifyPkg_Relational() throws Exception
		{
			try
			{
			/*list2.removeAll(list1);
		   	 b="";
		   	 for(String str1 : list2)
		   	 {
		   		 b+=str1;
		   	 }
		   	 System.out.println(b);*/
			ArrayList<String> arr=new ArrayList<String>();
		   	int count=GenericMethods.tr_count(trcount);
		   	for(int i=2;i<=count;i++)
		   	{
		   		 String name1=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
	             arr.add(name1.split("\n")[0]);
		   		 if(name1.contains(attachPackages.c.trim()))
	             {
	                 Assert.assertEquals(name1.contains("Copy of "+attachPackages.c+"*"),true);
	                 
	                 String activation=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]/img")).getAttribute("src");
                     Assert.assertEquals(activation.endsWith("off.GIF"), true);
	                 
                     String status=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[9]/img")).getAttribute("src");
                     Assert.assertEquals(status.endsWith("off.GIF"), true);
	                 
	                 String configureLnk=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]/a")).getText();
	                 Assert.assertEquals(configureLnk,"Configure");
	                 	                
	                 break;
	             }
		   	}
		   	
		   	Assert.assertEquals(arr.contains("Copy of "+attachPackages.c+"*"), true);
		   	return name1;
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




		public static String s;
		public  PackageDetailsTravelAgent confgr_attachedPkgTA() throws Exception

		{
			try
			{
			/*list2.removeAll(list1);
		    s="";
		    for (String str : list2)
		    {
		    	s+=str;
		    }
			System.out.println(list2);*/
			ArrayList<String> arr=new ArrayList<String>();
			int item_count=GenericMethods.tr_count(trcount);
			for(int k=2;k<=item_count;k++)
			{
				String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[3]")).getText();
				arr.add(data.split("\n")[0]);
				if(data.contains(attachPackages.c.trim()))
				{
					Assert.assertEquals(data.equals(attachPackages.c.trim()), true);
					GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[8]/a")).click();
					break;
				}
			}

			Assert.assertEquals(arr.contains(attachPackages.c.trim()), true);
			PackageDetailsTravelAgent PDW=PageFactory.initElements(GenericMethods.driver, PackageDetailsTravelAgent.class);
	    	return PDW;
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

		
		public  PackageDetailsTravelAgent confgr_CRattachedPkgTA() throws Exception

		{
			try
			{
			/*list2.removeAll(list1);
		    s="";
		    for (String str : list2)
		    {
		    	s+=str;
		    }
			System.out.println(list2);*/
			ArrayList<String> arr=new ArrayList<String>();
			int item_count1=GenericMethods.tr_count(trcount);
			for(int k=2;k<=item_count1;k++)
			{
				String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[3]")).getText();
				arr.add(data.split("\n")[0]);
				if(data.contains(attachPackages.c.trim()))
				{
					Assert.assertEquals(data.contains("Copy of "+attachPackages.c+"*"), true);
					GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[8]/a")).click();
					break;
				}
			}

			Assert.assertEquals(arr.contains("Copy of "+attachPackages.c+"*"), true);
			PackageDetailsTravelAgent PDW=PageFactory.initElements(GenericMethods.driver, PackageDetailsTravelAgent.class);
	    	return PDW;
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
		
		
		
		
		
		public static String actiDate_lnkWeb="Add Activation Date";
		public static String ActivForever="Activated Forever";

		public static void verifyAddActivationDate_linkTA() throws Exception
		{
			int item_count=GenericMethods.tr_count(trcount);
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

		public  AddActivationDateTA NavTo_ActivationDateTA() throws Exception
		{
			try
			{
			ArrayList<String> arr=new ArrayList<String>();
			int count=GenericMethods.tr_count(trcount);
			for(int i=2;i<=count;i++)
			{

				String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
				arr.add(data.split("\n")[0]);
				if(data.contains(attachPackages.c.trim()))
				{
					Assert.assertEquals(data.equals(attachPackages.c.trim()), true);
					GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]/a")).click();
				    break;
				}

			}
			Assert.assertEquals(arr.equals(attachPackages.c.trim()), true);
			AddActivationDateTA pageobj=PageFactory.initElements(GenericMethods.driver, AddActivationDateTA.class);
			return pageobj;
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


		public  AddActivationDateTA NavTo_ActivationDateTAfrmCR() throws Exception
		{
			try
			{
			ArrayList<String> arr=new ArrayList<String>();
			int count=GenericMethods.tr_count(trcount);
			for(int i=2;i<=count;i++)
			{

				String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
				arr.add(data.split("\n")[0]);
				if(data.contains(attachPackages.c.trim()))
				{
					Assert.assertEquals(data.contains(attachPackages.c.trim()), true);
					GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]/a")).click();
				    break;
				}

			}
			Assert.assertEquals(arr.contains("Copy of "+attachPackages.c.trim()+"*"), true);
			AddActivationDateTA pageobj=PageFactory.initElements(GenericMethods.driver, AddActivationDateTA.class);
			return pageobj;
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

		
		
		

		public void verifyActivatedForever_textTA() throws Exception
		{
			try
			{
			ArrayList<String> arr=new ArrayList<String>();
			int tble_count=GenericMethods.tr_count(trcount);
			for(int i=2;i<=tble_count;i++)
			{
				String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
                arr.add(data.split("\n")[0]);
				if(data.contains(attachPackages.c.trim()))
				{
					Assert.assertEquals(data.contains(attachPackages.c.trim()), true);
					String str=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]")).getText();
					Assert.assertEquals(str, ActivForever);
					break;
				}

			}
			Assert.assertEquals(arr.contains(attachPackages.c.trim()), true);
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
		
		
		
		public void verifyActivatedForever_textTAfrmCR() throws Exception
		{
			try
			{
			ArrayList<String> arr=new ArrayList<String>();
			int tble_count=GenericMethods.tr_count(trcount);
			for(int i=2;i<=tble_count;i++)
			{
				String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
                arr.add(data.split("\n")[0]);
				if(data.contains(attachPackages.c.trim()))
				{
					Assert.assertEquals(data.contains(attachPackages.c.trim()), true);
					String str=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]")).getText();
					Assert.assertEquals(str, ActivForever);
					break;
				}

			}
			Assert.assertEquals(arr.contains("Copy of "+attachPackages.c.trim()+"*"), true);
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
		
		

		public  String verifyCRPackage_name() throws Exception
		   {
			try
			{
		  	/* list2.removeAll(list1);
		  	 s="";
		  	 for(String str1 : list2)
		  	 {
		  		 s+=str1;
		  	 }
		  	 System.out.println(s);*/
			 ArrayList<String> arr=new ArrayList<String>();
		  	 int count=GenericMethods.tr_count(trcount);
		  	 for(int i=2;i<=count;i++)
		  	 {
		  		 String name1=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
				 arr.add(name1.split("\n")[0]); 		 
		  		 if(name1.contains(attachPackages.c.trim()))
		  		 {
		  			 
		  			 Assert.assertEquals(name1.contains(attachPackages.c.trim()),true);
		  			 Assert.assertEquals(name1.contains("*"),true);
		  			 System.out.println("Pass");
		  			 break;
		  		 }

		  	 }

		  	 Assert.assertEquals(arr.contains("Copy of "+attachPackages.c.trim()+"*"), true);
		  	 return name1;
			}
			catch(Exception e)
			{
				throw e;
			}
		  }



}

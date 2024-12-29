package com.hotelogix.smoke.admin.PriceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.hotelogix.smoke.admin.BaseClass.AdmineHome;
import com.hotelogix.smoke.genericandbase.BasePage;
import com.hotelogix.smoke.genericandbase.GenericMethods;
import com.hotelogix.smoke.login.AdminLoginPage;

public class ListOfPackageCentralizedRate {

	public static String windowID;

	public static String statusDeactive;

	public static String statusActive;

	@FindBy(xpath="//div[@id='listing-icons']//ul//li[4]/a")
	public static WebElement attachPackageImg_BT;

	@FindBy(xpath="//table[@class='list_viewnew']//tr[2]//td/a[text()='Edit']")
	public static WebElement editLink1;

	@FindBy(xpath="//tr//td/a")
	public static WebElement  main_link;

	@FindBy(xpath="//table[@class='list_viewnew']/tbody//tr")
	public static List<WebElement> trcount;


	@FindBy(xpath="//table[@class='list_viewnew']//tr//td[7]/a[text()='Add Activation Date']")
	public static WebElement addActivationDate_link;

	@FindBy(xpath="//select[@name='maxEntries']")
    public static WebElement view_DepDwn;


	@FindBy(xpath="	//a[@title='Attach a Package']")
	public static WebElement AttachPackage_Btn;

	@FindBy(xpath="	//td[@id='errorTd']")
	public static WebElement txt_Msg;

	@FindBy(xpath="//table[@class='list_viewnew']//td[7]/img")
	public static WebElement Activation_Data;

	@FindBy(xpath="//a[text()='Configure']")
	public static WebElement Configure_Link;

	@FindBy(xpath="//table[@class='list_viewnew']//td[7]/a")
	public static WebElement Activation_Data1;

	@FindBy(xpath="//a[text()='Add Activation Date']")
	public static WebElement AddActivationDate_link;

	@FindBy(xpath=" //table[@class='list_viewnew']//td[9]/img")
	public static WebElement ImgStatus;

	@FindBy(xpath="//table[@class='list_viewnew']//td[7]")
	public static WebElement Activation_column;




	public static String attr;
	public static String attr1;
	public static String text;
	public static String icon;
    public static String text1;
    public static String icon1;
    public static String actiDate_lnkCR="Add Activation Date";
    public static String src_off="off.GIF";
    public static String ActivForever="Activated Forever";




    public  void view() throws Exception{

    	try
    	{
        GenericMethods.selectElement(view_DepDwn, "All");
        GenericMethods.Alert_Accept();
        GenericMethods.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	}
    	catch(Exception e)
    	{
    		throw e;
    	}
       }


	public static PackageDetailsCentralisedRate fn_navToPackDetailsCentralisedRatePage() throws Exception{
		GenericMethods.clickElement(editLink1);
		PackageDetailsCentralisedRate pageobj=	PageFactory.initElements(GenericMethods.driver, PackageDetailsCentralisedRate.class);

	return pageobj;
	}

	public static BasePage fn_navigateToAdminMainPage() throws Exception{
		Thread.sleep(6000);
		GenericMethods.clickElement(main_link);
		BasePage ALO = PageFactory.initElements(GenericMethods.driver, BasePage.class);
	    return ALO;
	}
	public  attachPackages attachPackage() throws Exception{
		//windowID=GenericMethods.GetCurrentWindowID();
		try
		{
		GenericMethods.clickElement(attachPackageImg_BT);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(3000);
			GenericMethods.js_Click(attachPackageImg_BT);
		}
		catch(Exception e)
		{
			throw e;
		}
		attachPackages pageobj=	PageFactory.initElements(GenericMethods.driver, attachPackages.class);
		return pageobj;
	}


	//************************************************


	public static String getPkgName(int i){

	   String  data = GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[3]/strong[@class='main-field']")).getText();
   //    System.out.println(data);


       return data;
    }

	public static PackageDetailsCentralisedRate configurePackageCR(String pkgName) throws Exception{

		int count=GenericMethods.tr_count(trcount);
		for(int i=2;i<=count;i++){
		   String data=  getPkgName(i);
		   if(data.contains(pkgName)){
     	   System.out.println("Searched Package Find");
     	   WebElement  abc=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[8]/a[text()='Configure']"));
     	   abc.click();
     	   break;
        }
        else{
     	   System.out.println("Not verified");
        }

	}

		PackageDetailsCentralisedRate pageobj=PageFactory.initElements(GenericMethods.driver, PackageDetailsCentralisedRate.class);

	return pageobj;
	}

	


	public String verify_pkgSavedMsg() throws Exception
	{
		try
		{
		String msg=GenericMethods.getText(txt_Msg);
        return msg;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public PackageDetailsCentralisedRate Configure_Link() throws Exception{
		attr=Activation_Data.getAttribute("src");
			GenericMethods.clickElement(Configure_Link);
			PackageDetailsCentralisedRate EPD=PageFactory.initElements(GenericMethods.driver, PackageDetailsCentralisedRate.class);
			return EPD;
		}


	public void ValidateActivationCol() throws InterruptedException{

		attr1=GenericMethods.getText(Activation_Data1);
		if(attr.equals(attr1)){
			System.out.println("Package not configured");
		}else System.out.println("Package configured");

		}

	public AddActivationDateCR ActivationDate() throws Exception{

		 text=GenericMethods.getText(AddActivationDate_link);
		 System.out.println(text);
	     icon=ImgStatus.getAttribute("src");
	     System.out.println(icon);


		GenericMethods.clickElement(AddActivationDate_link);
		AddActivationDateCR AAD=PageFactory.initElements(GenericMethods.driver,AddActivationDateCR.class);
		return AAD;
	}


	public void VerifyActivationcolumnNStatus(){


		 text1=Activation_column.getText();
		 System.out.println(text1);
		 icon1=ImgStatus.getAttribute("src");

		 if(text.equals(text1)){
			 System.out.println("Activation status not changed");
		 }else System.out.println("Activation column  has been changed");

			if(icon.equals(icon1)){
				System.out.println("Icon not changed");
			}else System.out.println("Icon has been changed");


		}

	// new verification methods //

		static ArrayList<String> list1=new ArrayList<String>();
		static ArrayList<String> list2=new ArrayList<String>();

		public  void getPkgID1() throws Exception
		{
			try
			{
			int count1=GenericMethods.tr_count(trcount);
			for(int i=2;i<=count1;i++)
			{
				String url1=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]/a")).getAttribute("href");
				String ID1=url1.substring(url1.lastIndexOf("/")+1);
				list1.add(ID1);
			}
			}
			catch(Exception e)
			{
				throw e;
			}
		}

		public void getPkgID2() throws Exception
		{
			try
			{
			int count2=GenericMethods.tr_count(trcount);
			for(int j=2;j<=count2;j++)
			{
				String url2=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+j+"]//td[8]/a")).getAttribute("href");
				String ID2=url2.substring(url2.lastIndexOf("/")+1);
				list2.add(ID2);
			}
			}
			catch(Exception e)
			{
				throw e;
			}
		}


		public static String b;
		public static String name1;

		public  String verifyPackage_name() throws Exception
	    {
			try
			{
			ArrayList<String> arr=new ArrayList<String>();
	   /*	 list2.removeAll(list1);
	   	 b="";
	   	 for(String str1 : list2)
	   	 {
	   		 b+=str1;
	   	 }
	   	 System.out.println(b);*/
	   	 int count=GenericMethods.tr_count(trcount);
	   	 for(int i=2;i<=count;i++)
	   	 {
	   		 String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
	   		 arr.add(data.split("\n")[0]);
	   		 if(data.contains(attachPackages.c.trim()))
	   		 {
	   			 Assert.assertEquals(data.contains(attachPackages.c.trim()), true);
	   			 String src=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]//img")).getAttribute("src");
	   			 Assert.assertEquals(src.endsWith("off.GIF"), true);
	   			 String src1=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[9]//img")).getAttribute("src");
	   			 Assert.assertEquals(src1.endsWith("off.GIF"), true);
	   			 break;
	   		 }

	   	 }
	   	 Assert.assertEquals(arr.contains(attachPackages.c.trim()), true);

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
		public  PackageDetailsCentralisedRate confgr_attachedPkgCR() throws Exception

		{
			try
			{
			ArrayList<String> arr=new ArrayList<String>();
			/*list2.removeAll(list1);
		    s="";
		    for (String str : list2)
		    {
		    	s+=str;
		    }
			System.out.println(list2);*/
			int item_count=GenericMethods.tr_count(trcount);
			for(int k=2;k<=item_count;k++)
			{
				String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[3]")).getText();
				arr.add(data.split("\n")[0]);
				//System.out.println(data);
				if(data.contains(attachPackages.c.trim()))
				{
					Assert.assertEquals(data.contains(attachPackages.c.trim()), true);
					GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[8]/a")).click();
					break;
				}
			}
			Assert.assertEquals(arr.contains(attachPackages.c.trim()), true);

			PackageDetailsCentralisedRate PDC=PageFactory.initElements(GenericMethods.driver, PackageDetailsCentralisedRate.class);
	    	return PDC;
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


		public  void verifyAddActivationDate_linkCR() throws Exception
		{
			try
			{
			ArrayList<String> arr=new ArrayList<String>();
			int item_count=GenericMethods.tr_count(trcount);
			for(int k=2;k<=item_count;k++)
			{
				String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[3]")).getText();
				arr.add(data.split("\n")[0]);
				if(data.contains(attachPackages.c.trim()))
				{
					Assert.assertEquals(data.contains(attachPackages.c.trim()),true);
					String str=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[7]/a")).getText();
					Assert.assertEquals(str, actiDate_lnkCR);
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

		public  AddActivationDateCR NavTo_ActivationDateCR() throws Exception
		{
			try
			{
			ArrayList<String> arr=new ArrayList<String>();
			//windowID = GenericMethods.GetCurrentWindowID();
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
			Assert.assertEquals(arr.contains(attachPackages.c.trim()), true);
			Thread.sleep(3000);
			AddActivationDateCR AAD=PageFactory.initElements(GenericMethods.driver, AddActivationDateCR.class);
				return AAD;
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

		public  void verifyActivatedForever_textCR() throws Exception
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
		   			String src1=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[9]//img")).getAttribute("src");
		   			Assert.assertEquals(src1.endsWith("on.GIF"), true);
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

		public  void afterPkgattach_status()
	    {
	    	int item_count=GenericMethods.tr_count(trcount);
			for(int k=2;k<=item_count;k++)
			{
				String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[8]/a")).getAttribute("href");
				//System.out.println(data);
				if(data.contains(ListOfPackageCentralizedRate.b))
				{
					String str=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[7]/img")).getAttribute("src");
					String extracted_img1=str.substring(str.lastIndexOf("/")+1);
					Assert.assertEquals(extracted_img1, src_off);
					String status_img=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[9]/img")).getAttribute("src");
					String extracted_img2=status_img.substring(status_img.lastIndexOf("/")+1);
					Assert.assertEquals(extracted_img2, src_off);
					System.out.println("Pass");
					break;
				}
			}
	    }


	   public  PackageDetailsCentralisedRate click_EditLinkCRPkg()
	   {
		   int tble_cnt=GenericMethods.tr_count(trcount);
			for(int i=2;i<=tble_cnt;i++)
			{
				String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]/a")).getAttribute("href");
				//System.out.println(data);
				if(data.contains(s))
				{
					GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]/a")).click();
					break;
				}
			}
			PackageDetailsCentralisedRate PDC=PageFactory.initElements(GenericMethods.driver, PackageDetailsCentralisedRate.class);
	    	return PDC;
	   }


	   public  void verify_GridPkgCR()
	   {
		   int row_count=GenericMethods.tr_count(trcount);
			for(int i=2;i<=row_count;i++)
			{
				String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]/a")).getAttribute("href");
				if(data.contains(s))
				{
					String grid_pkg=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
					String[] lines=grid_pkg.split("\n");
		   			String name1=lines[0];
		   		    System.out.println(name1);
		   		    String exp_name=attachPackages.c.concat(" [GRID]");
		   		    Assert.assertEquals(name1,exp_name);
	  			    System.out.println("Pass");
	  			    break;
				}
			}
	   }






}

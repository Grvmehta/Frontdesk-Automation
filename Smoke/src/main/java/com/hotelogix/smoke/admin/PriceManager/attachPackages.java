package com.hotelogix.smoke.admin.PriceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class attachPackages {

	@FindBy(xpath="//div[@id='popup_head']")
	public static WebElement window_title;

	@FindBy(xpath="//table[@class='poptable']//tr//td/select")
	public static WebElement packageType_drpDwn;
	//Centralized Rate

	@FindBy(xpath="//table/tbody//tr[2]//td[2]/input")
	public static WebElement package_CB;


	@FindBy(xpath="//div[@class='padtop10']//input[2]")
	public static WebElement attachRelational_BT;

	@FindBy(xpath="//input[@name='save']")
	public static WebElement attach_BT;



		@FindBy(xpath="//tr//th/input[@type='checkbox']")
		public static WebElement Master_CB;

		@FindBy(xpath="//form[@id='frmListView']//table[2]//tbody//tr")
		public static List<WebElement> master_chkbox;

		@FindBy(xpath="//tr//td/input[@id='chkId_1']")
		public static WebElement CheckBox;

		 @FindBy(xpath="//input[@name='pkgMasterId[]']")
		   public static List<WebElement> checkBox;

		@FindBy(xpath="//table//tbody//tr//td[2]/input")
		public static List<WebElement> CheckBoxList;

		@FindBy(xpath="//tr//td[4]")
	    public static WebElement pkgName;

		@FindBy(xpath="//tr//td[4]")
		public static String pkgName1;

		@FindBy(xpath="//input[@id='chkId_3']")
		public static WebElement Package3;

		@FindBy(xpath="//td[@id='tdCancellationPolicy_3']")
		public static WebElement PackageName3;

		@FindBy(xpath="//table[@class='poptable']/tbody//tr[2]//td[2]/input[@type='checkbox']")
		public static WebElement chkbox1;

		@FindBy(xpath="//table[@class='poptable']/tbody//tr[4]//td[2]/input[@type='checkbox']")
		public static WebElement chkbox3;

		@FindBy(xpath="//table[@class='poptable']/tbody//tr[2]//td[4]")
		public static WebElement pkg1;

		@FindBy(xpath="//table[@class='poptable']/tbody//tr[4]//td[4]")
		public static WebElement pkg3;


		@FindBy(xpath="//input[@name='save']")
	    public static WebElement Attach_Btn;

		@FindBy(xpath="//div[@class='padtop10']//input[3]")
		public static WebElement close_btn;

		public static String pkgname;
        public static String title_txt="Attach Packages";
        public static String b;
        public static String c;



        public static ListOfPackagesTravelAgent clk_closeBtn() throws Exception
        {
        	GenericMethods.clickElement(close_btn);
    		ListOfPackagesTravelAgent pageobj=PageFactory.initElements(GenericMethods.driver, ListOfPackagesTravelAgent.class);

    		return pageobj;
        }


        public static ListOfPackagesTravelAgent1 clk_closeButton() throws Exception
        {
        	GenericMethods.clickElement(close_btn);
    		ListOfPackagesTravelAgent1 pageobj=PageFactory.initElements(GenericMethods.driver, ListOfPackagesTravelAgent1.class);

    		return pageobj;
        }

	public static ListOfPackagesFrontdesk verify_window() throws InterruptedException
	{
		//String childID=GenericMethods.windowHandle_admin(ListOfPackagesFrontdesk.windowID);
		String data=GenericMethods.getText(window_title);
		Assert.assertEquals(data, title_txt);
		//GenericMethods.Switch_Parent_Window(ListOfPackagesFrontdesk.windowID);
		ListOfPackagesFrontdesk pageobj=PageFactory.initElements(GenericMethods.driver, ListOfPackagesFrontdesk.class);
		return pageobj;

	}



	public static void  verify_windowTitle() throws InterruptedException
	{
		//String childID=GenericMethods.windowHandle_admin(ListOfPackagesFrontdesk.windowID);
		String data=GenericMethods.getText(window_title);
		Assert.assertEquals(data, title_txt);
		//GenericMethods.Switch_Parent_Window(ListOfPackagesFrontdesk.windowID);


	}



	public  ListOfPackagesTravelAgent1 selectPackageCentralizedTA(String pkgName) throws Exception
	{
		//String childID=GenericMethods.windowHandle_admin(ListOfPackagesTravelAgent.windowID);
		GenericMethods.selectElement(packageType_drpDwn, "Centralized Rate");
		GenericMethods.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getPkgName( pkgName);
		//	GenericMethods.clickElement(package_CB);
		GenericMethods.clickElement(attachRelational_BT);
		//GenericMethods.Switch_Parent_Window(ListOfPackagesTravelAgent.windowID);

		ListOfPackagesTravelAgent1 pageobj=PageFactory.initElements(GenericMethods.driver, ListOfPackagesTravelAgent1.class);

		return pageobj;
	}


	public  ListOfPackagesTravelAgent1 selectPkg_TAfrmCR(String pkgName) throws Exception
	{
		try
		{
		GenericMethods.selectElement(packageType_drpDwn, "Centralized Rate");
		GenericMethods.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getPkgName( pkgName);
		GenericMethods.clickElement(attachRelational_BT);

		ListOfPackagesTravelAgent1 pageobj=PageFactory.initElements(GenericMethods.driver, ListOfPackagesTravelAgent1.class);

		return pageobj;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	 	public static String data;


		public  String getPkgName(String pkgName) throws Exception
		{
			try
			{

			ArrayList<String> arr=new ArrayList<String>();
			int trcount=GenericMethods.tr_count(CheckBoxList);
	        int tr=trcount+2;
	        for(int i=2;i<=tr;i++)
	        {

	        data=GenericMethods.driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[4]")).getText();
	        int j=data.indexOf("(");
	   		c=data.substring(0,j);
	   		System.out.println(c);
	   	    arr.add(c.trim());
	        if(data.contains(pkgName))
	        {
	        	   Assert.assertEquals(data.contains(pkgName),true);
	        	   WebElement  abc=GenericMethods.driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[2]/input"));
	        	   abc.click();
	        	   break;

	        }

	        }
			Assert.assertEquals(arr.contains(pkgName), true);

	       return data;
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



		public  String getPkgName1(String pkgName) throws Exception
		{

			try
			{
			ArrayList<String> arr=new ArrayList<String>();
			int trcount=GenericMethods.tr_count(CheckBoxList);
	        int tr=trcount+2;
	        for(int i=2;i<=tr;i++)
	        {

	        data=GenericMethods.driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[4]")).getText();
	        int j=data.indexOf("(");
			c=data.substring(0,j);
			//System.out.println(c);
	        arr.add(c.trim());
	        if(data.contains(pkgName))
	        {
	        	Assert.assertEquals(data.contains(pkgName),true);
	        	 WebElement  abc=GenericMethods.driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[2]/input"));
	        	 abc.click();
	        	 break;
	        }
	        }

			
             
			Assert.assertEquals(arr.contains(pkgName), true);
			
			GenericMethods.clickElement(attach_BT);

	       return data;
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


		public void selectPkg_WebfrmFrontdesk(String pkgName) throws Exception
		{
			try
			{
			getPkgName(pkgName);
			GenericMethods.clickElement(attachRelational_BT);
			}
			catch(Exception e)
			{
				throw e;
			}
		}
		
		
		
	public  void selectSpecifiedPackage(String pkgType, String pkgName) throws Exception
	{

	//	GenericMethods.clickElement(packageType_drpDwn);
		GenericMethods.selectElement(packageType_drpDwn, pkgType);
		Thread.sleep(6000);
		System.out.println("drpdown selected");
		String a=getPkgName(pkgName);
		System.out.println(a);


		//Thread.sleep(3000);

	}

	public  void selectSpecifiedPackage1(String pkgType) throws Exception
	{
		
		try
		{
			GenericMethods.selectElement(packageType_drpDwn, pkgType);
			Thread.sleep(6000);
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public static void selectSpecifiedPackage1TA(String pkgType) throws Exception
	{
			GenericMethods.selectElement(packageType_drpDwn, pkgType);
			Thread.sleep(6000);
			System.out.println("drpdown selected");

		}



	public void selectpkgFrmMaster(String pkgName) throws Exception
	{
		try
		{
		getPkgName1(pkgName);
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public  ListOfPackageCentralizedRate selectPkgForCentralisedRate(String pkgName) throws Exception{
		try
		{
		getPkgName1(pkgName);
		//GenericMethods.clickElement(attach_BT);
		
		ListOfPackageCentralizedRate pageobj=PageFactory.initElements(GenericMethods.driver, ListOfPackageCentralizedRate.class);
		return pageobj;

		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public static ListOfPackagesFrontdesk selectPkg1_attachFD() throws Exception
	{
		//String childID=GenericMethods.windowHandle_admin(ListOfPackagesFrontdesk.windowID);
		GenericMethods.clickElement(chkbox1);
		b=GenericMethods.getText(pkg1);
		int i=b.indexOf("(");
		c=b.substring(0,i);
		System.out.println(c);
		GenericMethods.clickElement(attach_BT);
		//GenericMethods.Switch_Parent_Window(ListOfPackagesFrontdesk.windowID);
		ListOfPackagesFrontdesk pageobj=PageFactory.initElements(GenericMethods.driver, ListOfPackagesFrontdesk.class);
		return pageobj;

	}

	public  ListOfPackagesWeb selectPkg1_attachWeb() throws Exception
	{

		try
		{
		GenericMethods.clickElement(chkbox1);
		b=GenericMethods.getText(pkg1);
		int i=b.indexOf("(");
		c=b.substring(0,i);
		System.out.println(c);
		GenericMethods.clickElement(attach_BT);
		//GenericMethods.Switch_Parent_Window(ListOfPackagesWeb.windowID);
		ListOfPackagesWeb pageobj=PageFactory.initElements(GenericMethods.driver,ListOfPackagesWeb.class);
		return pageobj;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public  ListOfPackagesWeb selectPkg1_attachWebRelational() throws Exception
	{
		GenericMethods.clickElement(chkbox3);
		b=GenericMethods.getText(pkg3);
		int i=b.indexOf("(");
		c=b.substring(0,i);
		System.out.println(c);
		GenericMethods.clickElement(attachRelational_BT);
		ListOfPackagesWeb pageobj=PageFactory.initElements(GenericMethods.driver,ListOfPackagesWeb.class);
		return pageobj;
	}


	public static ListOfPackagesTravelAgent1 selectPkg1_attachTARelational() throws Exception
	{
		GenericMethods.clickElement(chkbox3);
		b=GenericMethods.getText(pkg3);
		int i=b.indexOf("(");
		c=b.substring(0,i);
		System.out.println(c);
		GenericMethods.clickElement(attachRelational_BT);
		ListOfPackagesTravelAgent1 pageobj=PageFactory.initElements(GenericMethods.driver,ListOfPackagesTravelAgent1.class);
		return pageobj;
	}



	public ListOfPackageCentralizedRate selectPkg1_attachCentralisedRate() throws Exception
	{
	
		try
		{
		GenericMethods.clickElement(chkbox1);
		b=GenericMethods.getText(pkg1);
		int i=b.indexOf("(");
		c=b.substring(0,i);
		System.out.println(c);
		GenericMethods.clickElement(attach_BT);
		ListOfPackageCentralizedRate CPL=PageFactory.initElements(GenericMethods.driver,ListOfPackageCentralizedRate.class);
		return CPL;
		}
		catch(Exception e)
		{
			throw e;
		}
	}



	public static GroupBookingSource selectPkg1_attachGrpBookingsource() throws Exception
	{
		GenericMethods.clickElement(chkbox1);
		b=GenericMethods.getText(pkg1);
		int i=b.indexOf("(");
		c=b.substring(0,i);
		System.out.println(c);
		GenericMethods.clickElement(attach_BT);
		GroupBookingSource CPL=PageFactory.initElements(GenericMethods.driver,GroupBookingSource.class);
		return CPL;
	}



	public  ListOfPackagesFrontdesk selectPkgForFD(String pkgName) throws Exception
	{
		selectpkgFrmMaster(pkgName);

		ListOfPackagesFrontdesk pageobj=PageFactory.initElements(GenericMethods.driver, ListOfPackagesFrontdesk.class);
		return pageobj;
	}

	public  ListOfPackagesWeb selectPkgForWeb(String pkgType) throws Exception
	{
		selectSpecifiedPackage1(pkgType);
		GenericMethods.clickElement(attachRelational_BT);
		ListOfPackagesWeb pageobj=PageFactory.initElements(GenericMethods.driver,ListOfPackagesWeb.class);
		return pageobj;
	}


	public static String pkg_attached;

	public ListOfPackagesWeb selectPkg_WEBfrmCR(String pkgType) throws Exception
	{
		try
		{
		selectSpecifiedPackage1(pkgType);
		
		ArrayList<String> arr=new ArrayList<String>();
		int count=GenericMethods.tr_count(master_chkbox);
		for(int j=2;j<=count;j++)
		{
	    pkg_attached=GenericMethods.driver.findElement(By.xpath("//form[@id='frmListView']//table[2]//tr["+j+"]//td[4]")).getText();
	    int k=pkg_attached.indexOf("(");
		c=pkg_attached.substring(0,k);
		System.out.println(c);
        arr.add(c.trim());
	    if(pkg_attached.contains(AddEditPackage.pkgName))
	    {
	    	Assert.assertEquals(pkg_attached.contains(AddEditPackage.pkgName), true);
			GenericMethods.driver.findElement(By.xpath("//form[@id='frmListView']//table[2]//tr["+j+"]//td[2]/input")).click();
			break;
	    }

		}
		Assert.assertEquals(arr.contains(AddEditPackage.pkgName), true);


		GenericMethods.clickElement(attachRelational_BT);
		ListOfPackagesWeb pageobj=PageFactory.initElements(GenericMethods.driver,ListOfPackagesWeb.class);

		return pageobj;
		}
		catch(Exception e)
		{
			throw e;
		}

	}


	public  ListOfPackagesWeb selectpkg(String pkgType) throws Exception
	{
		selectSpecifiedPackage1(pkgType);
	    pkg_attached=GenericMethods.getText(pkgName);
		int i=pkg_attached.indexOf("(");
		c=pkg_attached.substring(0,i);
		System.out.println(c);
		GenericMethods.clickElement(chkbox1);
		GenericMethods.clickElement(attachRelational_BT);
		ListOfPackagesWeb pageobj=PageFactory.initElements(GenericMethods.driver,ListOfPackagesWeb.class);

		return pageobj;

	}



	public ListOfPackageCentralizedRate AttachPackage() throws Exception{


		GenericMethods.clickElement(Package3);
		pkgname=GenericMethods.getText(PackageName3);
		System.out.println(pkgname);
		GenericMethods.clickElement(attach_BT);
		Thread.sleep(4000);

		ListOfPackageCentralizedRate CPL=PageFactory.initElements(GenericMethods.driver,ListOfPackageCentralizedRate.class );
		return CPL;

	}


	public static ListOfPackagesFrontdesk AttachToFrondesk() throws Exception
	{
        int
    trcount=GenericMethods.tr_count(checkBox);
        System.out.println(trcount);
       int tr=trcount+2;
        for(int i=2;i<=tr;i++){

        data=GenericMethods.driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[4]")).getText();
        System.out.println(data);

        if(data.contains(AddEditPackage.packageName)){
               System.out.println("Searched Package found and attaching it to the frontdesk ");
               WebElement  abc=GenericMethods.driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[2]/input"));
               abc.click();
               GenericMethods.clickElement(Attach_Btn);
               break;
           }
           else{
               System.out.println("Not verified");
           }
	}


        ListOfPackagesFrontdesk FPL=PageFactory.initElements(GenericMethods.driver, ListOfPackagesFrontdesk.class);
    	return FPL;
    }


	public static ListOfPackagesFrontdesk search_pkg() throws Exception
	{
		//String childID=GenericMethods.windowHandle_admin(ListOfPackagesFrontdesk.windowID);
		int count=GenericMethods.tr_count(master_chkbox);
		for(int i=2;i<=count;i++)
		{
		String data=GenericMethods.driver.findElement(By.xpath("//form[@id='frmListView']//table[2]//tr["+i+"]//td[4]")).getText();
		if(data.contains(AddEditPackage.pkgName))
		{
			System.out.println("Master package is being displayed.");
			break;
		}
		}
		GenericMethods.clickElement(close_btn);
		//GenericMethods.Switch_Parent_Window(ListOfPackagesFrontdesk.windowID);
		ListOfPackagesFrontdesk FPL=PageFactory.initElements(GenericMethods.driver, ListOfPackagesFrontdesk.class);
    	return FPL;
	}

	public ListOfPackageCentralizedRate fn_selectPkgCR() throws Exception
	{
		ArrayList<String> arr=new ArrayList<String>();
		int count=GenericMethods.tr_count(master_chkbox);
		for(int i=2;i<=count;i++)
		{
		String data=GenericMethods.driver.findElement(By.xpath("//form[@id='frmListView']//table[2]//tr["+i+"]//td[4]")).getText();
		int j=data.indexOf("(");
		c=data.substring(0,j);
		System.out.println(c);
        arr.add(c.trim());
		if(data.contains(AddEditPackage.pkgName))
		{
		
			GenericMethods.driver.findElement(By.xpath("//form[@id='frmListView']//table[2]//tr["+i+"]//td[2]/input")).click();
			System.out.println("Master package is being displayed.");
			break;
		}
		}
		GenericMethods.clickElement(attach_BT);
		ListOfPackageCentralizedRate LCR=PageFactory.initElements(GenericMethods.driver, ListOfPackageCentralizedRate.class);
    	return LCR;
	}


	public static ListOfPackagesFrontdesk AttachToFrondeskTC() throws Exception
	{
        
		int  trcount=GenericMethods.tr_count(checkBox);
        System.out.println(trcount);
         int tr=trcount+2;
        for(int i=2;i<=tr;i++){

        data=GenericMethods.driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[4]")).getText();
        System.out.println(data);

        if(data.contains(AddEditPackage.FDPkg)){
               System.out.println("Searched Package found and attaching it to the frontdesk ");
               WebElement  abc=GenericMethods.driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[2]/input"));
               abc.click();
               GenericMethods.clickElement(Attach_Btn);
               break;
           }
           else{
               System.out.println("Not verified");
           }
	}


        ListOfPackagesFrontdesk FPL=PageFactory.initElements(GenericMethods.driver, ListOfPackagesFrontdesk.class);
    	return FPL;
    }



}

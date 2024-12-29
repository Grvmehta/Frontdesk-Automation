package com.hotelogix.smoke.admin.PriceManager;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.frontdesk.FrontdeskHome.FrontdeskLandingPage;
import com.hotelogix.smoke.genericandbase.BasePage;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class ListofPackagesInPackageMaster {

	@FindBy(xpath="//div[@class='headingtxt']//tbody//td[2]")
	public static WebElement pge_title;


	@FindBy(xpath="//a[@title='Add a Package']")
	public static WebElement addApackage;


	@FindBy(xpath="//tr//th/input[@type='checkbox']")
	public static WebElement Master_CB;

	@FindBy(xpath="//tr//td/input[@id='id_1']")
	public static WebElement CheckBox;

	@FindBy(xpath="//input[@type='checkbox']")
	public static List<WebElement> CheckBoxList;

	@FindBy(xpath="//table[@class='list_viewnew']/tbody//tr[2]//td/strong")
    public static WebElement pkgName;

	@FindBy(xpath="//table[@class='list_viewnew']")
    public static WebElement tabletrs;

    @FindBy(xpath="//a[text()='Add a Package']")
    public static WebElement AddPackage_Btn;

    @FindBy(xpath="//select[@name='maxEntries']")
    public static WebElement view_drpdown;

    @FindBy(xpath="//table[@class='list_viewnew']/tbody//tr//th[3]")
    public static List<WebElement> pkg_count;

    @FindBy(xpath="//a[text()='Price Manager']")
    public static WebElement PriceManager;

    @FindBy(xpath="//a[text()='Frontdesk (Packages)']")
    public static WebElement frontDeskPackage;

    
    @FindBy(xpath="//table[@class='list_viewnew']//tr")
    public static List<WebElement> trcount;


    public static String txt="List of Packages";
	public static String pkg_src="on.GIF";

	
	
	
	public static void verify_page() throws Exception
	{
	 String pge_name=GenericMethods.getText(pge_title);
	 Assert.assertEquals(pge_name, txt);
	}

	public FrontdeskLandingPage fn_NavigateFrontdesk()
	{
		Actions act=new Actions(GenericMethods.driver);
		act.sendKeys(Keys.chord(Keys.CONTROL,Keys.TAB)).perform();
		GenericMethods.driver.switchTo().defaultContent();
		FrontdeskLandingPage FLP=PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
		return FLP;
	}




	public  AddEditPackage fn_NavigateToAddEditPackage() throws Exception
	{
		try
		{
		GenericMethods.clickElement(addApackage);
		AddEditPackage pageobj= PageFactory.initElements(GenericMethods.driver, AddEditPackage.class);
		return pageobj;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public void fn_chkInclPkg() throws Exception
	{
		int count=GenericMethods.tr_count(CheckBoxList);
        for(int i=2;i<=count;i++)
        {
        	ArrayList<String> list = new ArrayList<String>();
        	String list1=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[3]")).getText();
            list.add(list1);
        	if(list.contains("Sample Package FD"))
            {
            	fn_NavigateFrontdesk();
            	break;
            }

            else
            {
            	new ListofPackagesInPackageMaster().fn_NavigateToAddEditPackage();
                AddEditPackage.fillPkgDetailsFD("2");
                new AddEditPackage().checkadded_addon();
                AddMoreInclusions.select_inclusion();
                new AddEditPackage().clickOnSave();
            }
        }
	}


	public  ListOfPackagesFrontdesk fn_navigateFrontDskPkg() throws Exception
    {
        GenericMethods.mouseOverElement(PriceManager);
        GenericMethods.clickElement(frontDeskPackage);

        ListOfPackagesFrontdesk pageObj=PageFactory.initElements(GenericMethods.driver, ListOfPackagesFrontdesk.class);
        return pageObj;
    }




	public static String verifyAddedPKG(String ActualPkgName){
		String Name=null;
		int count=GenericMethods.tr_count(trcount);
		for(int i=2;i<count;i++){
			 Name=	GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td/strong")).getText();
			if(Name.contains(AddEditPackage.pkgName)){
				System.out.println("Package"+ " " + Name + " " +"Added sucessfully");
				break;
			}

			Assert.assertEquals(Name, ActualPkgName);
		}
		return Name;
	}




	public static void VerifyAddedPackage()
	{
		String value = null;
		List<WebElement> rows=tabletrs.findElements(By.tagName("tr"));
		//int rsize=rows.size();
		for(int rnum=0;rnum<1;rnum++)
		{
	List<WebElement> columns=rows.get(rnum).findElements(By.xpath("//table[@class='list_viewnew']//td[3]"));
	//int  colsize=columns.size();

	for(int cnum=0;cnum<columns.size()-1;cnum++)
		{
		value=columns.get(cnum).getText();
		if(value.contains(AddEditPackage.packageName))
			System.out.println("Package match and added to list");

			break;
	//System.out.println(cnum + " block is " + columns.get(cnum).getText());
		//System.out.println(columns.get(cnum).getText());
		}
		}
	}


	public  void verifysavedpkg() throws Exception
	{
		try
		{
		ArrayList<String> arr=new ArrayList<String>();
		int count=GenericMethods.tr_count(trcount);
		for(int i=2;i<=count;i++)
		{
			String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[3]/strong")).getText();
			arr.add(data);
			if(data.contains(AddEditPackage.pkgName))
			{
				Assert.assertEquals(data.contains(AddEditPackage.pkgName), true);
				String status=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[7]//img")).getAttribute("src");
				Assert.assertEquals(status.endsWith("on.GIF"), true);

				break;

			}
		}
		Assert.assertEquals(arr.contains(AddEditPackage.pkgName), true);
		
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


	public  void viewAll() throws Exception
	{
		try
		{
		GenericMethods.selectElement(view_drpdown, "All");
		GenericMethods.ActionOnAlert("Accept");
		}
		catch(Exception e)
		{
			throw e;
		}
	}



	public void fn_chkTaxInclusivePkg() throws Exception
	{
		ArrayList<String> list = new ArrayList<String>();


		int count=GenericMethods.tr_count(CheckBoxList);
        for(int i=2;i<=count;i++)
        {

        	String list1=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[3]")).getText();
            list.add(list1);

           for(int j=0;j<=list.size()-1;j++)
              {
                String str=list.get(j);
	            if(str.contains("Sample Inclusive of tax pkg FD"))
                   {
            	     fn_NavigateFrontdesk();
            	     break;

                   }

               else
               {
            	new ListofPackagesInPackageMaster().fn_NavigateToAddEditPackage();
            	AddEditPackage AEP=new AddEditPackage();
            	AEP.fillPkgDetailsFD1("2");
            	AEP.checkadded_addon();
                AddMoreInclusions.select_inclusion();
                new AddEditPackage().clickOnSave();
                new BasePage().fn_navigateFrontDskPkg();
                ListOfPackagesFrontdesk LOPF=new ListOfPackagesFrontdesk();
                LOPF.viewAll();
                LOPF.getPkgID1();
                String a=GenericMethods.GetCurrentWindowID();
                LOPF.attachPackage();
                GenericMethods.windowHandle(a);
                attachPackages.AttachToFrondeskTC();
                GenericMethods.Switch_Parent_Window(a);
                LOPF.viewAll();
                LOPF.getPkgID2();
                LOPF.confgr_attachedPkgFD();
                PackageDetailsFrontDesk PDF=new PackageDetailsFrontDesk();
                PDF.selectInclusiveTax();
                PDF.clickOnSave_BT();
                String b=GenericMethods.GetCurrentWindowID();
                LOPF.AddActivationDateFD_click1();
                GenericMethods.windowHandle(b);
               new  AddActivationDateFD().activateForeverPackateFD();
                GenericMethods.Switch_Parent_Window(b);
                fn_NavigateFrontdesk();
            }
        }
           break;

	}

}



	public void fn_chkInclChocBarPkg() throws Exception
	{
		ArrayList<String> list = new ArrayList<String>();


		int count=GenericMethods.tr_count(CheckBoxList);
        for(int i=2;i<=count;i++)
        {

        	String list1=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[3]")).getText();
            list.add(list1);

           for(int j=0;j<=list.size()-1;j++)
              {
                String str=list.get(j);
	            if(str.contains("Sample Choc Bar Pkg FD"))
                   {
            	     fn_NavigateFrontdesk();
            	     break;

                   }

               else
               {
            	new ListofPackagesInPackageMaster().fn_NavigateToAddEditPackage();
                AddEditPackage.fillPkgDetailsFD2("1");
                new AddEditPackage().checkadded_addon();
                AddMoreInclusions.select_ChocBarIncl();
                new AddEditPackage().clickOnSave();
                new BasePage().fn_navigateFrontDskPkg();
                ListOfPackagesFrontdesk LOPF=new ListOfPackagesFrontdesk();
                LOPF.viewAll();
                LOPF.getPkgID1();
                String a=GenericMethods.GetCurrentWindowID();
                LOPF.attachPackage();
                GenericMethods.windowHandle(a);
                attachPackages.AttachToFrondeskTC();
                GenericMethods.Switch_Parent_Window(a);
                LOPF.viewAll();
                LOPF.getPkgID2();
                LOPF.confgr_attachedPkgFD();
                //PackageDetailsFrontDesk.selectInclusiveTax();
                new PackageDetailsFrontDesk().clickOnSave_BT();
                String b=GenericMethods.GetCurrentWindowID();
                LOPF.AddActivationDateFD_click1();
                GenericMethods.windowHandle(b);
                new AddActivationDateFD().activateForeverPackateFD();
                GenericMethods.Switch_Parent_Window(b);
                fn_NavigateFrontdesk();
            }
        }
           break;
        }

	}


        public void fn_chkChocBarPAPkg() throws Exception
    	{
        	try{
    		ArrayList<String> list = new ArrayList<String>();
    		ArrayList<String> list2 = new ArrayList<String>();


    		int count=GenericMethods.tr_count(CheckBoxList);
            for(int i=2;i<=count;i++)
            {

            	String list1=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[3]")).getText();
                list.add(list1);
            }
               for(int j=0;j<=list.size()-1;j++)
               {
                   String str=list.get(j);
                    //list2.add(str);
                  boolean resutl= str.contains("Choc Bar PA Pkg");

    	            if(resutl==true)
                       {

    	            	fn_NavigateFrontdesk();
                        break;

                       }


               }

               }
        	catch(Exception e)
        	{

        		new ListofPackagesInPackageMaster().fn_NavigateToAddEditPackage();
        		AddEditPackage AEP=	 new AddEditPackage();
        		AEP.fillPkgDetailsFD3("1");
        		AEP.checkadded_addon();
              AddMoreInclusions.select_ChocBarPA();
              AEP.clickOnSave();
              new BasePage().fn_navigateFrontDskPkg();
              ListOfPackagesFrontdesk LOPF=new ListOfPackagesFrontdesk();
              LOPF.viewAll();
              LOPF.getPkgID1();
              String a=GenericMethods.GetCurrentWindowID();
              LOPF.attachPackage();
              GenericMethods.windowHandle(a);
              attachPackages.AttachToFrondeskTC();
              GenericMethods.Switch_Parent_Window(a);
              LOPF.viewAll();
              LOPF.getPkgID2();
              LOPF.confgr_attachedPkgFD();
              //PackageDetailsFrontDesk.selectInclusiveTax();
              new PackageDetailsFrontDesk().clickOnSave_BT();
              String b=GenericMethods.GetCurrentWindowID();
              LOPF.AddActivationDateFD_click1();
              GenericMethods.windowHandle(b);
              new AddActivationDateFD().activateForeverPackateFD();
              GenericMethods.Switch_Parent_Window(b);
              fn_NavigateFrontdesk();

        	}

}


    	public void fn_chkWeeklyRatePkg() throws Exception
    	{
    		ArrayList<String> list = new ArrayList<String>();


    		int count=GenericMethods.tr_count(CheckBoxList);
            for(int i=2;i<=count;i++)
            {

            	String list1=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[3]")).getText();
                list.add(list1);

               for(int j=0;j<=list.size()-1;j++)
                  {
                    String str=list.get(j);
    	            if(str.contains("Sample Weekly Rate pkg FD"))
                       {
                	     fn_NavigateFrontdesk();
                	     break;

                       }

                   else
                   {
                	new ListofPackagesInPackageMaster().fn_NavigateToAddEditPackage();
                	AddEditPackage AEP=new AddEditPackage();
                	AEP.fillPkgDetailsFD1("2");
                	AEP.checkadded_addon();
                    AddMoreInclusions.select_inclusion();
                    AEP.clickOnSave();
                    new BasePage().fn_navigateFrontDskPkg();
                    ListOfPackagesFrontdesk LOPF=new ListOfPackagesFrontdesk();
                    LOPF.viewAll();
                    LOPF.getPkgID1();
                    String a=GenericMethods.GetCurrentWindowID();
                    LOPF.attachPackage();
                    GenericMethods.windowHandle(a);
                    attachPackages.AttachToFrondeskTC();
                    GenericMethods.Switch_Parent_Window(a);
                    LOPF.viewAll();
                    LOPF.getPkgID2();
                    LOPF.confgr_attachedPkgFD();
                    PackageDetailsFrontDesk PDF=new PackageDetailsFrontDesk();
                    PDF.changeRatesToPost("Week");
                    PDF.clickOnSave_BT();
                    String b=GenericMethods.GetCurrentWindowID();
                    LOPF.AddActivationDateFD_click1();
                    GenericMethods.windowHandle(b);
                    new AddActivationDateFD().activateForeverPackateFD();
                    GenericMethods.Switch_Parent_Window(b);
                    fn_NavigateFrontdesk();
                }
            }
               break;

    	}

    }



}

package com.hotelogix.smoke.admin.PriceManager;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.frontdesk.FrontdeskHome.FrontdeskLandingPage;
import com.hotelogix.smoke.genericandbase.BasePage;
import com.hotelogix.smoke.genericandbase.GenericMethods;


public class AddonLandingPage
{
	@FindBy(xpath="//a[@title='Add Add-ons']")
	public static WebElement addAddon;

	@FindBy(xpath="//td[@class='main-field']")
	public static WebElement addon1;

	@FindBy(xpath="//form[@name='frmListView']//tbody//tr[2]")
	public static WebElement addon_savemsg;

	@FindBy(xpath="//table[@class='list_viewnew']//tr[2]//td[7]/img")
	public static WebElement addon_status;

	@FindBy(xpath="//select[@name='maxEntries']")
	public static WebElement view_drpDwe;

	@FindBy(xpath="//input[@type='checkbox']")
	public static List<WebElement> CheckBoxList;

	@FindBy(xpath="//table[@class='list_viewnew']//tr")
	public  List<WebElement> tr_count;


	public static String src="on.GIF";
	
	public static ArrayList<String> arr=new ArrayList<String>();

	public  SaveAddonsPage clickAddAddons() throws Exception
	{
	
		try
		{
		GenericMethods.clickElement(addAddon);

		SaveAddonsPage SAP = PageFactory.initElements(GenericMethods.driver, SaveAddonsPage.class);
		return SAP;
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
    	GenericMethods.selectElement(view_drpDwe, "All");
    	GenericMethods.Alert_Accept();
		}
		catch(Exception e)
		{
			throw e;
		}
    }

	public String verify_saveMsg() throws Exception
	{
		try
		{
		String exp_msg=GenericMethods.getText(addon_savemsg);
		return exp_msg;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public  void verify_savedAddOn() throws Exception
	{
		String str = null;
		try
		{
			
		int count=GenericMethods.tr_count(tr_count);
		for(int i=2;i<=count;i++)
		{
		String saved_addon=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
		str=saved_addon.split(" ")[0];
		//arr.add(str[0]);	
		if(saved_addon.contains(SaveAddonsPage.AddonName))
		{
			String status=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]/img")).getAttribute("src");
			Assert.assertEquals(status.endsWith("on.GIF"), true);
			break;
		}
		}
		Assert.assertEquals(str.contains(SaveAddonsPage.AddonName), true);
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

	public static void chkstatus()
	{
		String saved_status=addon_status.getAttribute("src");
		if(saved_status.contains(src))
		{
			Assert.assertTrue(true);
			System.out.println("Status of saved add-on is Active");
		}
		else
		{
			Assert.assertTrue(false);
			System.out.println("Status of saved add-on is De-active");
		}
	}


	public FrontdeskLandingPage fn_NavigateFrontdesk()
	{
		Actions act=new Actions(GenericMethods.driver);
		act.sendKeys(Keys.chord(Keys.CONTROL,Keys.TAB)).perform();
		GenericMethods.driver.switchTo().defaultContent();
		FrontdeskLandingPage FLP=PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
		return FLP;
	}


	public void fn_chkInclChocBarPA() throws Exception
	{
		ArrayList<String> list = new ArrayList<String>();


		int count=GenericMethods.tr_count(CheckBoxList);
        for(int i=2;i<=count;i++)
        {

        	String list1=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[3]")).getText();
            list.add(list1);
        }
           for(int j=0;j<=list.size()-1;j++)
              {
                String str=list.get(j);
	            if(str.contains("Sample Choc Bar Pkg FD"))
                   {
            	     ListofPackagesInPackageMaster LPM=new BasePage().fn_navigatePackageMaster();
            	     LPM.viewAll();
            	     LPM.fn_chkChocBarPAPkg();
            	     break;

                   }

               else
               {
            	clickAddAddons();
            	SaveAddonsPage.fn_addChocBar();
            	BasePage BP=new BasePage();
            	BP.fn_navigatePackageMaster();
            	new ListofPackagesInPackageMaster().fn_NavigateToAddEditPackage();
            	AddEditPackage AEP=new AddEditPackage();
            	AEP.fillPkgDetailsFD3("2");                
            	AEP.checkadded_addon();
                AddMoreInclusions.select_ChocBarPA();
                AEP.clickOnSave();
                BP.fn_navigateFrontDskPkg();
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
               new  PackageDetailsFrontDesk().clickOnSave_BT();
                String b=GenericMethods.GetCurrentWindowID();
                LOPF.AddActivationDateFD_click1();
                GenericMethods.windowHandle(b);
                new AddActivationDateFD().activateForeverPackateFD();
                GenericMethods.Switch_Parent_Window(b);
                fn_NavigateFrontdesk();
            }
	            break;
        }


	}





}

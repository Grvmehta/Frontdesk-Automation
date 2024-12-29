package com.hotelogix.smoke.admin.PriceManager;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;


public class PackageDetailsFrontDesk {

	@FindBy(xpath="//td[@class='container_box']//tr[1]//table[2]//tr[2]")
	public static WebElement title;

	@FindBy(xpath="//input[@name='btnSubmit']")
	public static WebElement save_Bt;

	@FindBy(xpath="//tbody//tr[10]/td//input[@type='checkbox']")
	public static WebElement inclusiveTax ;

	@FindBy(xpath="//td[@class='pkgPropertyBack']//tr[5]/td//a")
	public static WebElement chngRateToPost_link;

	@FindBy(xpath="//td[@class='pkgPropertyBack']//tr[5]/td//select")
	public static WebElement chngRateToPost_DrpDwn;

	@FindBy(xpath="//input[@id='postInclusiveTax']")
    public static WebElement InclusiveOfTax_ChkBox;

    @FindBy(id="btnSubmit")
    public static WebElement Save_Btn;

    @FindBy(xpath="//input[@value='Publish To Grid']")
    public static WebElement ToGrid_btn;

    @FindBy(xpath="//td[@class='error']")
    public static WebElement PkgDetl_savemsg;

    @FindBy(xpath="//td[@class='pkgPropertyBack']//tr[1]//td[2]")
    public static WebElement Edit_PkgName;

    @FindBy(xpath="//span[@class='comments']/input[1]")
    public static WebElement saveAsGrid_btn;

    @FindBy(xpath="//td[@class='crumbs']//a[2]")
    public static WebElement PkgFrontdesk_lnk;

    @FindBy(xpath="//input[@value='Publish To Daily Rate']")
    public static WebElement ToDailyRate_btn;

    @FindBy(xpath="//span[@class='comments']/input[1]")
    public static WebElement saveAsDailyRate_btn;

    @FindBy(xpath="//a[contains(@onclick,'closeOpenRateViewDetails')]")
    public static WebElement view_Lnk;

    @FindBy(xpath="//tr[3]//table//tr[2]//td[4]//a")
    public static WebElement price_text;
    
    @FindBy(xpath="//input[@id='postInclusiveTax']")
    public WebElement CB_IncusiveOfTax;
    
    @FindBy(xpath="//form/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[5]/td/a")
    public WebElement LinkChange_RateToPost;
    
    @FindBy(xpath="//select[@id='packagePostingRhythm']")
    public WebElement DD_RatePostingRhythm;
    
    
    
    
    
    
    
    
    
    

    public static String PageTitle="Package Details(Frontdesk)";
    public static String exp_msg="Any changes made to the package will be saved automatically and redirect to the grid preview page.\n"+
                                 " Would you like to proceed?";

    public static String Grid_msg="This action will permanently publish this package to grid.\n"+
"Are you sure to proceed?";

    public static String dailyRate="Any changes made to the package will be saved automatically and redirect to the daily rate preview page.\n"+
                                 " Would you like to proceed?";

    public static String dailyRate_savemsg="This action will permanently publish this package to Daily Rate.\n"+
"Are you sure to proceed?";

    
public void ChangePostingRhythm(String postingRhythm) throws Exception{
try{
GenericMethods.clickElement(LinkChange_RateToPost);
Thread.sleep(2000);
GenericMethods.selectElement(DD_RatePostingRhythm, postingRhythm);
Thread.sleep(2000);
}
catch(Exception e){
throw e;
}
}
 
    
    
    
    
    public static void verify_PageTitle() throws InterruptedException
    {
    	try{
    	String text=GenericMethods.getText(title);
    	Assert.assertEquals(text, PageTitle);
    	}catch(Exception e)
    	{
    		Thread.sleep(2000);
    		String text=GenericMethods.getText(title);
        	Assert.assertEquals(text, PageTitle);
    	}

    }


    
    
    public ListOfPackagesFrontdesk fn_doIncusiveTaxForPackage() throws Exception{
    	
    	try
		{
    	GenericMethods.clickElement(CB_IncusiveOfTax);
    	Thread.sleep(2000);
		GenericMethods.clickElement(save_Bt);
		
		}
		catch(NoSuchElementException e)
		{
			GenericMethods.clickElement(CB_IncusiveOfTax);
			Thread.sleep(3000);
			GenericMethods.js_Click(save_Bt);
		}
		catch(Exception e)
		{
			throw e;
		}
		ListOfPackagesFrontdesk pageobj=PageFactory.initElements(GenericMethods.driver, ListOfPackagesFrontdesk.class);
		return pageobj;
    	
    }
    
    
    
	public  ListOfPackagesFrontdesk clickOnSave_BT() throws Exception
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
		ListOfPackagesFrontdesk pageobj=PageFactory.initElements(GenericMethods.driver, ListOfPackagesFrontdesk.class);
		return pageobj;
	}

	public  void selectInclusiveTax() throws Exception
	{

		try
		{
		GenericMethods.clickElement(inclusiveTax);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public  PackageDetailsFrontDesk changeRatesToPost(String optionToSelect) throws Exception{
		
		try
		{
		GenericMethods.clickElement(chngRateToPost_link);
		GenericMethods.selectElement(chngRateToPost_DrpDwn, optionToSelect);

		PackageDetailsFrontDesk pageobj=PageFactory.initElements(GenericMethods.driver, PackageDetailsFrontDesk.class);
		return pageobj;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public static PackageDetailsFrontDesk clck_publishToGrid() throws Exception
	{
		GenericMethods.clickElement(ToGrid_btn);
		String popup_msg=GenericMethods.ActionOnAlert("Dismiss");
		//String str=popup_msg.trim();
		Assert.assertEquals(popup_msg,exp_msg);
		PackageDetailsFrontDesk pageobj=PageFactory.initElements(GenericMethods.driver, PackageDetailsFrontDesk.class);
		return pageobj;
	}

	public  String  accept_ToGrid() throws Exception
	{
		try
		{
		GenericMethods.clickElement(ToGrid_btn);
		String popup1_msg=GenericMethods.ActionOnAlert("Accept");
		return popup1_msg;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public static PackageDetailsFrontDesk clck_saveAsGrid() throws Exception
	{
		GenericMethods.clickElement(saveAsGrid_btn);
	    String popup=GenericMethods.ActionOnAlert("Dismiss");
	    Assert.assertEquals(popup, Grid_msg);
	    PackageDetailsFrontDesk pageobj=PageFactory.initElements(GenericMethods.driver, PackageDetailsFrontDesk.class);
		return pageobj;
	}


	public  String accept_SaveGrid() throws Exception
	{
		try
		{
		GenericMethods.clickElement(saveAsGrid_btn);
		String msg2=GenericMethods.ActionOnAlert("Accept");
		//PackageDetailsFrontDesk pageobj=PageFactory.initElements(GenericMethods.driver, PackageDetailsFrontDesk.class);
		return msg2;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public static PackageDetailsFrontDesk clk_publishToDailyRate() throws Exception
	{
		GenericMethods.clickElement(ToDailyRate_btn);
		String popup=GenericMethods.ActionOnAlert("Dismiss");
		Assert.assertEquals(popup, dailyRate);
		PackageDetailsFrontDesk pageobj=PageFactory.initElements(GenericMethods.driver, PackageDetailsFrontDesk.class);
		return pageobj;

	}

	public static PackageDetailsFrontDesk accept_ToDailyRate() throws Exception
	{
		GenericMethods.clickElement(ToDailyRate_btn);
		String popup1=GenericMethods.ActionOnAlert("Accept");
		PackageDetailsFrontDesk pageobj=PageFactory.initElements(GenericMethods.driver, PackageDetailsFrontDesk.class);
		return pageobj;

	}

	public static PackageDetailsFrontDesk clk_SaveAsDailyRate() throws Exception
	{
        GenericMethods.clickElement(saveAsDailyRate_btn);
        String popup=GenericMethods.ActionOnAlert("Dismiss");
        Assert.assertEquals(popup, dailyRate_savemsg);
        PackageDetailsFrontDesk pageobj=PageFactory.initElements(GenericMethods.driver, PackageDetailsFrontDesk.class);
		return pageobj;

	}


	public static PackageDetailsFrontDesk accept_SaveDailyRate() throws Exception
	{
		GenericMethods.clickElement(saveAsDailyRate_btn);
		GenericMethods.ActionOnAlert("Accept");
		PackageDetailsFrontDesk pageobj=PageFactory.initElements(GenericMethods.driver, PackageDetailsFrontDesk.class);
		return pageobj;
	}


	public static String name;

	public  String get_PkgName() throws Exception
	{
		try
		{
	    name=GenericMethods.getText(Edit_PkgName);
	    return name;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public  void verify_savemsg() throws Exception
	{
		try
		{
		get_PkgName();
	    String saving_Msg="- Package " + PackageDetailsFrontDesk.name + " saved successfully.";
		String msg_save=GenericMethods.getText(PkgDetl_savemsg);
//	    JavascriptExecutor jse = (JavascriptExecutor)GenericMethods.driver;
//	    WebElement element = GenericMethods.driver.findElement(By.xpath("//td[@class='error']"));
//	    jse.executeScript("return arguments[0].text", element);
		Assert.assertEquals(msg_save, saving_Msg);
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

  public static ListOfPackagesFrontdesk SaveDetails() throws Exception
   {

		GenericMethods.clickElement(InclusiveOfTax_ChkBox);
		GenericMethods.clickElement(Save_Btn);
		ListOfPackagesFrontdesk FPL=PageFactory.initElements(GenericMethods.driver, ListOfPackagesFrontdesk.class);
		return FPL;
   }

  public  ListOfPackagesFrontdesk clk_PkgFrontdeskLnk() throws Exception
  {
	  try
	  {
	  GenericMethods.clickElement(PkgFrontdesk_lnk);
	  }
	  catch(NoSuchElementException e)
	  {
		  Thread.sleep(3000);
		  GenericMethods.js_Click(PkgFrontdesk_lnk);
	  }
	  catch(Exception e)
	  {
		  throw e;
	  }
	  ListOfPackagesFrontdesk FPL=PageFactory.initElements(GenericMethods.driver, ListOfPackagesFrontdesk.class);
	  return FPL;
  }


  public static int pkgPrice;

  public static int fn_packagePrice() throws Exception
  {
	  GenericMethods.js_Click(view_Lnk);
	  Thread.sleep(5000);
	  String str=GenericMethods.getText(price_text);
	  String [] split=str.valueOf(str).split("\\.");
	  String frstpart=split[0];
	  pkgPrice=Integer.parseInt(frstpart);
	  //pkgPrice=(int)f;
	  //pkgPrice=Integer.parseInt(frstpart);

	  return pkgPrice;
  }

}

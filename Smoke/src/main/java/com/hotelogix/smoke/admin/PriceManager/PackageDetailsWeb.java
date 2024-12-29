package com.hotelogix.smoke.admin.PriceManager;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class PackageDetailsWeb {
	@FindBy(xpath="//input[@name='btnSubmit']")
	public static WebElement save_Bt;

	@FindBy(xpath="//td[@class='container_box']//tr[1]//table[2]//tr[2]")
	public static WebElement pge_titleWeb;

	@FindBy(xpath="//input[@value='Publish To Grid']")
	public static WebElement WebPkg_ToGrid;

	@FindBy(xpath="//td[@class='error']")
    public static WebElement PkgDetlWeb_savemsg;

    @FindBy(xpath="//td[@class='pkgPropertyBack']//tr[1]//td[2]")
    public static WebElement EditWeb_PkgName;

    @FindBy(xpath="//span[@class='comments']/input[1]")
    public static WebElement saveAsGridWeb_btn;

    @FindBy(xpath="//td[@class='crumbs']//a[2]")
    public static WebElement PkgWeb_lnk;

    @FindBy(xpath="//a[contains(@onclick,'return toggRelRate')]")
    public static WebElement relationRateModifier_Lnk;

    @FindBy(xpath="//input[@name='relValModfier']")
    public static WebElement RRModifier_txtbox;

    @FindBy(xpath="//input[@value='PV' and @name='relValModfierType']")
    public static WebElement RRModifier_percentage;

    @FindBy(xpath="//input[@value='FV' and @name='relValModfierType']")
    public static WebElement RRModifier_Rs;

    @FindBy(xpath="//a[contains(@onclick,'closeOpenRateViewDetails')]")
    public static WebElement view_WebLnk;

    @FindBy(xpath="//tr[3]//table//tr[2]//td[4]//a")
    public static WebElement price_Webtext;

    @FindBy(xpath="//tr[3]//table//tr[2]//td[4]")
    public static WebElement price_Webtext1;

    @FindBy(xpath="//td[@class='table-validity']//tbody//tr[3]//tbody//tr[2]/td")
	public static WebElement roomTypeName1;

	public static String title="Package Details(Web)";
	public static String exp_msgWeb="Any changes made to the package will be saved automatically and redirect to the grid preview page.\n"+
            " Would you like to proceed?";

public static String Grid_msgWeb="This action will permanently publish this package to grid.\n"+
"Are you sure to proceed?";




	public static void verify_PageTitle() throws InterruptedException
    {
    	String text=GenericMethods.getText(pge_titleWeb);
    	Assert.assertEquals(text, title);
    }

	public static PackageDetailsWeb clck_publishToGridWeb() throws Exception
	{
		GenericMethods.clickElement(WebPkg_ToGrid);
		String popup_msg=GenericMethods.ActionOnAlert("Dismiss");
		//String str=popup_msg.trim();
		Assert.assertEquals(popup_msg,exp_msgWeb);
		PackageDetailsWeb pageobj=PageFactory.initElements(GenericMethods.driver, PackageDetailsWeb.class);
	    return pageobj;
	}

	public  String accept_ToGridWeb() throws Exception
	{
		try
		{
		GenericMethods.clickElement(WebPkg_ToGrid);
		String popup1_msg=GenericMethods.ActionOnAlert("Accept");
		//PackageDetailsWeb pageobj=PageFactory.initElements(GenericMethods.driver, PackageDetailsWeb.class);
	    return popup1_msg;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public static PackageDetailsWeb clck_saveAsGridWeb() throws Exception
	{
		GenericMethods.clickElement(saveAsGridWeb_btn);
	    String popup=GenericMethods.ActionOnAlert("Dismiss");
	    Assert.assertEquals(popup, Grid_msgWeb);
	    PackageDetailsWeb pageobj=PageFactory.initElements(GenericMethods.driver, PackageDetailsWeb.class);
	    return pageobj;
	}


	public  String accept_SaveGridWeb() throws Exception
	{
		try
		{
		GenericMethods.clickElement(saveAsGridWeb_btn);
		String msg2=GenericMethods.ActionOnAlert("Accept");
		//PackageDetailsWeb pageobj=PageFactory.initElements(GenericMethods.driver, PackageDetailsWeb.class);
	    return msg2;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public static String name;

	public   String get_PkgName() throws Exception
	{
		try
		{
	    name=GenericMethods.getText(EditWeb_PkgName);
	    return name;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public  void verify_savemsgWeb() throws Exception
	{
		try
		{
		get_PkgName();
	    String saving_Msg="- Package " + PackageDetailsWeb.name + " saved successfully.";
		String msg_save=GenericMethods.getText(PkgDetlWeb_savemsg);
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



	public  ListOfPackagesWeb clickOnSave_BT() throws Exception
	{
		try
		{
		GenericMethods.clickElement(save_Bt);

		ListOfPackagesWeb pageobj=PageFactory.initElements(GenericMethods.driver, ListOfPackagesWeb.class);
		return pageobj;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public  ListOfPackagesWeb clk_PkgWebLink() throws Exception
	{
		try
		{
		GenericMethods.clickElement(PkgWeb_lnk);
		ListOfPackagesWeb pageobj=PageFactory.initElements(GenericMethods.driver, ListOfPackagesWeb.class);
		return pageobj;
		}
		catch(Exception e)
		{
			throw e;
		}
		
	}



	public static void add_relationalRateModifier() throws Exception
	{
		GenericMethods.clickElement(relationRateModifier_Lnk);
		Actions navigator = new Actions(GenericMethods.driver);
        navigator.click(RRModifier_txtbox)
            .sendKeys(Keys.END)
            .keyDown(Keys.SHIFT)
            .sendKeys(Keys.HOME)
            .keyUp(Keys.SHIFT)
            .sendKeys(Keys.BACK_SPACE)
            .perform();
        navigator.sendKeys("10").perform();
		//RRModifier_txtbox.clear();
		//GenericMethods.sendKeys(RRModifier_txtbox, "10");
		Thread.sleep(5000);
		Boolean value=RRModifier_percentage.isSelected();
		if(value.equals(true))
		{
			System.out.println("Percentage radio button is already selected.");
			GenericMethods.clickElement(relationRateModifier_Lnk);
		}
		else
		{
			GenericMethods.clickElement(RRModifier_percentage);
			//GenericMethods.clickElement(relationRateModifier_Lnk);
		}
	}


	public static void fn_packagePriceWeb() throws Exception
	  {
		GenericMethods.js_Click(view_WebLnk);
		  Thread.sleep(4000);
		  String price=GenericMethods.getText(price_Webtext1);
		  String[] part=price.valueOf(price).split("\\.");
		  String k=part[0];
		  int a=Integer.parseInt(k);
		  int b=(int)(0.1*PackageDetailsFrontDesk.pkgPrice);
		  int c=PackageDetailsFrontDesk.pkgPrice+b;
		  Assert.assertEquals(a, c);

	  }


	public static String pkgPrice;
	public static String RoomType;

	public String get_PublishedPkgPrice() throws InterruptedException
	{
		try
		{

		  GenericMethods.js_Click(view_WebLnk);
		  Thread.sleep(4000);
		  RoomType=GenericMethods.getText(roomTypeName1);
		  String price=GenericMethods.getText(price_Webtext1);
		  String[] part=price.valueOf(price).split("\\.");
		  String k=part[0];
		  pkgPrice=k;
		}
		catch(Exception e)
		{

		}
		return pkgPrice;
	}

}

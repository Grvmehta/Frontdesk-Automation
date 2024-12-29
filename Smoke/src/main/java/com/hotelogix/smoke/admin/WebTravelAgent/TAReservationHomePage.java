package com.hotelogix.smoke.admin.WebTravelAgent;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.crypto.SealedObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.hotelogix.smoke.admin.PriceManager.RoomPricesLandingPage;
import com.hotelogix.smoke.admin.WebTravelAgent.TravleAgent_LoginPage;
import com.hotelogix.smoke.frontdesk.WebReservation.WebSelectRoomPage;
//import com.hotelogix.smoke.admin.WebBookingEngine.SelectRoom_Packages;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class TAReservationHomePage
{


	public static String frmMonth="Nov";
	public static String frmYear="2015";
	public static String frmDate="1";
	public static String toMonth="Nov";
	public static String toYear="2015";
	public static String toDate="3";
	public static String noOfRoom="3";



	@FindBy(xpath="//form[@id='frmWebRes']//table//tr[2]/td")
    public static WebElement StayDetails_Text;

	@FindBy(xpath="//img[@id='calIn']")
    public static WebElement CheckINCalender_IMG;

    @FindBy(xpath="//input[@id='non']")
    public static WebElement NightEditBox_ED;

    @FindBy(xpath="//table[@id='webresCalPopup_t']//tbody//tr//td//a")
    public static WebElement CheckInCalenderDate_Link;

    @FindBy(xpath="//img[@id='calOut']")
    public static WebElement CheckOutCalender_IMG;

    @FindBy(name="noOfAdult")
    public static WebElement Adult_DD;

    @FindBy(name="Submit")
    public static WebElement CheckAvalibility_BT;

    @FindBy(xpath="//table[@id='webresCalPopup_t']//tbody//tr//td//a")
    public static List<WebElement> DateCollection;

    @FindBy(xpath="//table[@class='tbl-contentNew']//tr['2']//td[2]//table//tr")
    public static List<WebElement> Tr_Count;


    @FindBy(xpath="//form[@id='frmWebRes']//a/em")
    public static WebElement SpecialDiscount_Link;

    @FindBy(xpath="//select[@id='spDiscount']")
    public static WebElement SPdiscount_DD;

    @FindBy(xpath="//input[@name='Spvalue']")
    public static WebElement SPdiscount_ED;

    @FindBy(xpath="//table[@class='tbl-contentNew']//table//tr//td[2]//strong")
    public static WebElement Price_Text;

    @FindBy(xpath="//select[@id='spDiscount']//option[2]")
    public static WebElement Discount_Text;

    @FindBy(xpath="//select[@name='reqId']")
    public static WebElement reason_DD;

    @FindBy(xpath="//input[@name='Spvalue']")
    public static WebElement reason_editbox;


    @FindBy(xpath="//table[@class='tbl01']//td/img")
	public static WebElement arrivalCal;

    @FindBy(xpath="//td//img[@id='calOut']")
	public static WebElement departureCal;

    @FindBy(xpath="//table[@class='tbl01']//tr[11]//td/select")
	public static WebElement adult_DrpDwn;

	@FindBy(xpath="//input[@id='avlChkBtnId']")
	public static WebElement chkAvalibility_BT;

	@FindBy(xpath="//table[@class='tbl01']//tr[5]//td/input")
	public static WebElement noOfNight_txtField;

	@FindBy(xpath="//a[@class='calnav']")
	public static WebElement mnthYearTitelFrmcal;

	@FindBy(xpath="//div[@class='yui-cal-nav']/div/select")
	public static WebElement select_FrmMnth;

	@FindBy(xpath="//div[@class='yui-cal-nav']//div/input")
	public static WebElement enterFrmYear;

	@FindBy(xpath="//div[@class='yui-cal-nav']//div/span/button")
	public static WebElement okButton_Frmcalander;

	@FindBy(xpath="//div[@id='webresCalPopup']")
    public static WebElement chartfrom;

	@FindBy(xpath="//table[@id='web_res_id1']//td//a[2]")
	public static WebElement travleAgent_Link;

	public String verify_pageHeader() throws Exception
	{
		try
		{
        String str=GenericMethods.getText(StayDetails_Text);
        return str;
		}
		catch(Exception e)
		{
			throw e;
		}
    }


	public TASelectRoomPage fn_CheckAvability() throws Exception
	{
    	//GenericMethods.driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        GenericMethods.clickElement(CheckINCalender_IMG);
        GenericMethods.clickElement(CheckInCalenderDate_Link);
        GenericMethods.sendKeys(NightEditBox_ED, "1");
        Calendar cal = Calendar.getInstance();
        System.out.println("current date: " + cal.getTime());
        cal.add(Calendar.DATE, 1);
        Date dob=cal.getTime();
        String st=dob.toString();
        String[] parts=st.split(" ");
        String parts2=parts[2];
        System.out.println(parts2);
        GenericMethods.clickElement(CheckOutCalender_IMG);
        for(WebElement date: DateCollection )
        {
            String strobj=date.getText();
            if(parts2.contains(strobj)){
            date.click();
            break;
        }
        }
        GenericMethods.selectElement(Adult_DD, "1");
        GenericMethods.clickElement(CheckAvalibility_BT);

        TASelectRoomPage TASP =  PageFactory.initElements(GenericMethods.driver, TASelectRoomPage.class);
        return TASP;


	}

	public static float c;
    public static String disc;

    public WebSelectRoomPage spclDisc_chkAvailability() throws Exception
    {
    	GenericMethods.clickElement(CheckINCalender_IMG);
        GenericMethods.clickElement(CheckInCalenderDate_Link);
        GenericMethods.sendKeys(NightEditBox_ED, "1");
        Calendar cal = Calendar.getInstance();
        System.out.println("current date: " + cal.getTime());
        cal.add(Calendar.DATE, 1);
        Date dob=cal.getTime();
        String st=dob.toString();
        String[] parts=st.split(" ");
        String parts2=parts[2];
        System.out.println(parts2);
        GenericMethods.clickElement(CheckOutCalender_IMG);
        for(WebElement date: DateCollection )
        {
            String strobj=date.getText();
            if(parts2.contains(strobj)){
            date.click();
            break;
        }
        }
        GenericMethods.selectElement(Adult_DD, "1");
        GenericMethods.clickElement(SpecialDiscount_Link);
        Select sel=new Select(SPdiscount_DD);
        sel.selectByVisibleText("army(50.00%)");
        //GenericMethods.selectbyNo(SPdiscount_DD, 1);
        disc=SPdiscount_DD.getText();
        int i=disc.indexOf("(");
		String str=disc.substring(i+1,32);
		c=Float.parseFloat(str);
		System.out.println(c);
        GenericMethods.selectbyNo(reason_DD, 0);
        String data=GenericMethods.generateRandomString();
        GenericMethods.sendKeys(reason_editbox,data);
        GenericMethods.clickElement(CheckAvalibility_BT);
        WebSelectRoomPage WSP =  PageFactory.initElements(GenericMethods.driver, WebSelectRoomPage.class);
        return WSP;


        }

    public static WebSelectRoomPage fillRevForm() throws Exception{
		fn_SelectDateFrmDatePicker(arrivalCal,"Nov","2015","1");
		fn_SelectDateFrmDatePicker(departureCal,"Nov","2015","2");
		noOfNight_txtField.click();
		noOfNight_txtField.clear();
		GenericMethods.sendKeys(noOfNight_txtField, "1");
		GenericMethods.selectElement(adult_DrpDwn, "1");
		GenericMethods.clickElement(chkAvalibility_BT);
		WebSelectRoomPage pageobj=PageFactory.initElements(GenericMethods.driver, WebSelectRoomPage.class );
		return pageobj;
	}

  //************************************************ DatePicker method	------ From datePicker
  		public static void fn_SelectDateFrmDatePicker(WebElement calIcon, String month, String year, String date1) throws Exception{

  			 frmMonth=month;
  			 frmYear=year;
  			 frmDate=date1;


  			 GenericMethods.clickElement(calIcon);
  			 GenericMethods.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  			 GenericMethods.clickElement(mnthYearTitelFrmcal);

  			 GenericMethods.selectElement(select_FrmMnth, frmMonth);

  			 GenericMethods.clickElement(enterFrmYear);
  		     enterFrmYear.clear();
  		     GenericMethods.sendKeys(enterFrmYear, frmYear);

  		     GenericMethods.clickElement(okButton_Frmcalander);

  		     String classname = chartfrom.getAttribute("class");

  		     WebElement abc=  GenericMethods.driver.findElement(By.xpath("//table[@id='webresCalPopup_t']//tbody//tr//td//a[contains(text(),('" + frmDate + "') )]"));
  			 abc.click();

  			}

  		public static TravleAgent_LoginPage fn_NavigateToTA_Console() throws Exception
  		{
  			GenericMethods.clickElement(travleAgent_Link);
  			TravleAgent_LoginPage pageobj=PageFactory.initElements(GenericMethods.driver, TravleAgent_LoginPage.class);
  			return pageobj;
  		}



}

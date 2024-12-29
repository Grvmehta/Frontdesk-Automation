package com.hotelogix.smoke.frontdesk.WebReservation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class WebConfirmReservationPage
{
	@FindBy(xpath="//select[@id='salutation']")
    public static WebElement Salutation_DD;

    @FindBy(xpath="//input[@id='fName']")
    public static WebElement FirstName_ED;

    @FindBy(xpath="//input[@id='lName']")
    public static WebElement LastName_ED;

    @FindBy(xpath="//input[@id='telNo']")
    public static WebElement TelephoneNum_ED;

    @FindBy(xpath="//input[@id='mobNo']")
    public static WebElement MobileNum_ED;

    @FindBy(xpath="//input[@id='email']")
    public static WebElement Email_ED;

    @FindBy(xpath="//input[@id='comfemail']")
    public static WebElement ConfirmEmail_ED;

    @FindBy(xpath="//input[@id='address']")
    public static WebElement Address_ED;

    @FindBy(xpath="//select[@name='countryId']")
    public static WebElement Country_DD;

    @FindBy(xpath="//select[@id='stateId']")
    public static WebElement State_DD;

    @FindBy(xpath="//input[@id='city']")
    public static WebElement City_ED;

    @FindBy(xpath="//input[@id='zip']")
    public static WebElement Zip_ED;

    @FindBy(xpath="//textarea[@id='webNotes']")
    public static WebElement PreferenceTextArea;

    @FindBy(xpath="//input[@id='canPolicy']")
    public static WebElement TermsConditionCheckBox;

    @FindBy(xpath="//input[@id='radCc']")
    public static WebElement CreditCardRadioBtn;


    @FindBy(xpath="//select[@name='cardType']")
    public static WebElement CardType_DD;

    @FindBy(xpath="//input[@id='nameOnCard']")
    public static WebElement NameOnCard_ED;

    @FindBy(xpath="//input[@id='ccNo']")
    public static WebElement CardNumber_ED;

    @FindBy(xpath="//input[@id='cvc']")
    public static WebElement CVC_ED;

    @FindBy(xpath="//input[@id='expMonth']")
    public static WebElement ExpMonth_ED;

    @FindBy(xpath="//input[@id='expYear']")
    public static WebElement ExpYear_ED;

    @FindBy(xpath="//input[@value='Confirm By Credit Card']")
    public static WebElement ConfirmByCreditCard_BT;

    @FindBy(xpath="//input[@id='canPolicy']")
    public static WebElement TermAndCondition_CB;

    @FindBy(xpath="//form[@id='frmWebRes']//table//tbody/tr/td/h3/strong")
    public static WebElement BookingConfirmPage_Text;

    @FindBy(xpath="//form[@id='frmWebRes']//table//tr[2]/td/span")
    public static WebElement SectionTitle;

	public void fn_FillGuestDetails(String Salutation, String firstname, String Lastname, String Telephone, String Mobile, String Email, String ConfirmMale, String Country, String State, String Address, String City, String ZipCode) throws Exception
	{
        GenericMethods.selectElement(Salutation_DD, Salutation);
        GenericMethods.sendKeys(FirstName_ED, firstname);
        GenericMethods.sendKeys(LastName_ED, Lastname);
        GenericMethods.sendKeys(TelephoneNum_ED, Telephone);
        GenericMethods.sendKeys(MobileNum_ED, Mobile);
        GenericMethods.sendKeys(Email_ED, Email);
        GenericMethods.sendKeys(ConfirmEmail_ED, ConfirmMale);
        GenericMethods.selectElement(Country_DD, Country);
        GenericMethods.selectElement(State_DD, State);
        GenericMethods.sendKeys(Address_ED, Address);
        GenericMethods.sendKeys(City_ED, City);
        GenericMethods.sendKeys(Zip_ED, ZipCode);
    }


	public void fn_FillCreditCardDetails(String Cardtype, String CardName, String CardNumber, String CVCnumber, String Expmonth, String Expyear) throws Exception
	{
        GenericMethods.clickElement(TermAndCondition_CB);
        GenericMethods.selectElement(CardType_DD, Cardtype);
        GenericMethods.sendKeys(NameOnCard_ED, CardName);
        GenericMethods.sendKeys(CardNumber_ED, CardNumber);
        GenericMethods.sendKeys(CVC_ED, CVCnumber);
        GenericMethods.sendKeys(ExpMonth_ED, Expmonth);
        GenericMethods.sendKeys(ExpYear_ED, Expyear);
    }


	public void Fn_ClickConfirmCreditCardButton() throws Exception
	{
        GenericMethods.clickElement(ConfirmByCreditCard_BT);
        String str=GenericMethods.getText(BookingConfirmPage_Text);

        if(str.equalsIgnoreCase("Booking Confirmation"))
        {
            System.out.println("Confirm your Booking / Payments Page is nevigate on Booking Confirmation Page");
        }
    }


	/*public WebConfirmReservationPrintPage ConfirmBooking(int iTestCaseRow) throws Exception
	{

		try
		{
        ExcelUtil.setCellData(GenericMethods.generateRandomString(), iTestCaseRow, Constant.Col_GuestFirstName);

		ExcelUtil.setCellData(GenericMethods.generateRandomString(), iTestCaseRow, Constant.Col_GuestLastName);

		Thread.sleep(3000);

//		String str=ExcelUtil.setCellData(GenericMethods.getStayezeeUserName(GenericMethods.randomUniqueString()+"@stayezee.com"), iTestCaseRow, Constant.Col_EmailAddressUsername);
//
//		ExcelUtil.setCellData(str, iTestCaseRow, Constant.Col_ConfirmGuestMailId);
//

	    Thread.sleep(3000);
		GenericMethods.selectElement(Salutation_DD, "Mr.");
		Thread.sleep(3000);
		GenericMethods.sendKeys(FirstName_ED, ExcelUtil.getCellData(iTestCaseRow, Constant.Col_GuestFirstName));
		GenericMethods.sendKeys(LastName_ED, ExcelUtil.getCellData(iTestCaseRow, Constant.Col_GuestLastName));
		GenericMethods.sendKeys(TelephoneNum_ED, "8506853589");
		GenericMethods.sendKeys(MobileNum_ED, "1213456");
		GenericMethods.sendKeys(Email_ED, ExcelUtil.getCellData(iTestCaseRow, Constant.Col_GuestMailId));
		GenericMethods.sendKeys(ConfirmEmail_ED, ExcelUtil.getCellData(iTestCaseRow, Constant.Col_ConfirmGuestMailId));
		GenericMethods.selectElement(Country_DD, "India");
		Thread.sleep(3000);
		GenericMethods.selectElement(State_DD, "Delhi");
		Thread.sleep(3000);
		GenericMethods.sendKeys(Address_ED,"Delhi");
		GenericMethods.sendKeys(City_ED, "Delhi");
		GenericMethods.sendKeys(Zip_ED, "110096");
		GenericMethods.sendKeys(PreferenceTextArea, "Need Newspaper");
		GenericMethods.clickElement(TermsConditionCheckBox);
		Thread.sleep(3000);
		GenericMethods.clickElement(CreditCardRadioBtn);
		Thread.sleep(3000);
		GenericMethods.selectElement(CardType_DD, "Visa");
		Thread.sleep(3000);
		GenericMethods.sendKeys(NameOnCard_ED, "visa");
		GenericMethods.sendKeys(CardNumber_ED, "4111111111111111");
		GenericMethods.sendKeys(CVC_ED, "111");
		GenericMethods.sendKeys(ExpMonth_ED, "12");
		GenericMethods.sendKeys(ExpYear_ED, "2018");
		GenericMethods.clickElement(ConfirmByCreditCard_BT);
		Thread.sleep(5000);
		WebConfirmReservationPrintPage WCRP=PageFactory.initElements(GenericMethods.driver, WebConfirmReservationPrintPage.class);
		return WCRP;
		}
		catch(Exception e)
		{
			throw e;
		}

	}
*/
	public void fn_verifyAlertBox() throws Exception
	{
		GenericMethods.clickElement(ConfirmByCreditCard_BT);
		GenericMethods.ActionOnAlert("Accept");
	}


	public WebConfirmReservationPage fn_ConfirmBookingPaymentPage() throws Exception
	{
		try
		{
       // GenericMethods.clickElement(Confirm_BT);
        String str=GenericMethods.getText(SectionTitle);
       /* if(str.equalsIgnoreCase("Confirm your Booking / Payments"))
        {
            System.out.println("Confirm your Booking / Payments section is visible on Web Reservation");

        }*/
        Assert.assertEquals(str, "Confirm your Booking / Payments");
        WebConfirmReservationPage WCRP=PageFactory.initElements(GenericMethods.driver, WebConfirmReservationPage.class);
        return WCRP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

}

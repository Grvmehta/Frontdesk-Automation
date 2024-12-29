package com.hotelogix.smoke.frontdesk.WebReservation.GuestConsole;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.frontdesk.WebReservation.WebConfirmReservationPrintPage;
import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class WebGuestConfirmReservationPage {
	
	
	
@FindBy(xpath="//span[text()='Confirm your Booking / Payments']")
public static WebElement ConfirmBookingPageTitle;

@FindBy(xpath="//select[@id='salutation']")
public static WebElement Salutation;

@FindBy(xpath="//input[@id='fName']")
public static WebElement FName;

@FindBy(xpath="//input[@id='lName']")
public static WebElement LName;

@FindBy(xpath="//input[@id='telNo']")
public static WebElement TelNum;

@FindBy(xpath="//input[@id='mobNo']")
public static WebElement MobileNum;

@FindBy(xpath="//input[@id='email']")
public static WebElement EmailId;

@FindBy(xpath="//input[@id='comfemail']")
public static WebElement ConfirmEmail;

@FindBy(xpath="//div[@class='col-xs-7 col-sm-7 guestDetailsTbl']//table//tr[7]//td[2]//select")
public static WebElement CountryDropDown;

@FindBy(xpath="//select[@id='stateId']")
public static WebElement Statedropdown;

@FindBy(xpath="//input[@id='address']")
public static WebElement AddressField;

@FindBy(xpath="//input[@id='city']")
public static WebElement CityTxtField;

@FindBy(xpath="//input[@id='zip']")
public static WebElement ZipTextField;

@FindBy(xpath="//textarea[@id='webNotes']")
public static WebElement PreferenceTextArea;

@FindBy(xpath="//input[@id='canPolicy']")
public static WebElement TermsConditionCheckBox;

@FindBy(xpath="//input[@id='radCc']")
public static WebElement CreditCardRadioBtn;

@FindBy(xpath="//select[@name='cardType']")
public static WebElement CardTypeDropdown;

@FindBy(xpath="//input[@id='nameOnCard']")
public static WebElement NameOnCardTextfield;

@FindBy(xpath="//input[@id='ccNo']")
public static WebElement CardNumber;

@FindBy(xpath="//input[@id='cvc']")
public static WebElement CVCTextField;

@FindBy(xpath="//input[@id='expMonth']")
public static WebElement ExpiryMonthTextField;

@FindBy(xpath="//input[@id='expYear']")
public static WebElement ExpiryYearTextField;

@FindBy(xpath="//input[@id='confirmByCCBtn']")
public static WebElement CreditCardConfirmBtn;


public WebGuestConfirmReservationPrintPage ConfirmBooking() throws Exception{
	
	
	GenericMethods.clickElement(TermsConditionCheckBox);
	GenericMethods.clickElement(CreditCardRadioBtn);
	GenericMethods.selectElement(CardTypeDropdown, "Visa");
	GenericMethods.sendKeys(NameOnCardTextfield, "visa");
	GenericMethods.sendKeys(CardNumber, "4111111111111111");
	GenericMethods.sendKeys(CVCTextField, "111");
	GenericMethods.sendKeys(ExpiryMonthTextField, "12");
	GenericMethods.sendKeys(ExpiryYearTextField, "2018");
	GenericMethods.clickElement(CreditCardConfirmBtn);
	Thread.sleep(2000);
	WebGuestConfirmReservationPrintPage WCRP=PageFactory.initElements(GenericMethods.driver, WebGuestConfirmReservationPrintPage.class);
	return WCRP;
	
	
}





	
public void VerifyTitle() throws InterruptedException{
String title=GenericMethods.getText(ConfirmBookingPageTitle);
Assert.assertEquals(title, "Confirm your Booking / Payments");
}

}

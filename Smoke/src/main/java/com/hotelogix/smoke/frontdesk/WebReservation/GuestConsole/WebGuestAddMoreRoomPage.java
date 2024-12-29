package com.hotelogix.smoke.frontdesk.WebReservation.GuestConsole;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.hotelogix.smoke.genericandbase.GenericMethods;

public class WebGuestAddMoreRoomPage {
	
	
	
	
	@FindBy(xpath="//input[@value='Confirm']")
	public static WebElement ConfirmBtn;
	
	
	
	
public WebGuestConfirmReservationPage ClickOnConfirmBtn() throws Exception{
GenericMethods.clickElement(ConfirmBtn);
WebGuestConfirmReservationPage WCR=PageFactory.initElements(GenericMethods.driver,WebGuestConfirmReservationPage.class );
return WCR;
}

}

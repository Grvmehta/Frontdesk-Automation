package com.hotelogix.smoke.frontdesk.WebReservation.GuestConsole;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class WebGuestConsoleLandingPage {


	@FindBy(xpath="//td[text()='Reservation Details ']")
	public static WebElement GuestReservationPageTitle;

@FindBy(xpath="//a[text()='Book Now']")
public static WebElement BookNowBtn;



public WebGuestStayDetailsPage ClickOnBookNow() throws Exception{
	GenericMethods.clickElement(BookNowBtn);
	 WebGuestStayDetailsPage WGS=PageFactory.initElements(GenericMethods.driver,  WebGuestStayDetailsPage.class);
	return WGS;
}





}

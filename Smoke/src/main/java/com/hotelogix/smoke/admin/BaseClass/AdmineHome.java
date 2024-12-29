package com.hotelogix.smoke.admin.BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.admin.roommanager.RoomsLandingPage;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AdmineHome {
	
	
	
	
	
	

    @FindBy(xpath="//div[@id='all']//li/ul/li[5]/a[text()='Rooms']")
	public  WebElement rooms;
    
    @FindBy(xpath="//div[@id='all']//li/a[text()='Rooms Manager']")
	public  WebElement roommanager;

	public static WebDriver driver;

	public static boolean bResult;

	public  AdmineHome(WebDriver driver){

		AdmineHome.driver = driver;

		AdmineHome.bResult = true;
		
		
		
		
	}
		
		
		
		
		
		
public RoomsLandingPage roomsPageNavigate() {
	
			RoomsLandingPage RLP =null;
			
			try{
		
		
			GenericMethods.mouseOverElement(roommanager);
			GenericMethods.clickElement(rooms);

			
			 RLP = PageFactory.initElements(GenericMethods.driver, RoomsLandingPage.class);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return RLP;
		}



}
	
	
	
	
	
	
	
	
	
	
	
	
	

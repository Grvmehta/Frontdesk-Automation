package com.hotelogix.smoke.admin.PriceManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class FrontDeskPackageDetailPage {
	
	

	
	
@FindBy(xpath="//input[@id='postInclusiveTax']")
public static WebElement InclusiveOfTax_ChkBox;  

@FindBy(id="btnSubmit")
public static WebElement Save_Btn;
	
@FindBy(xpath="//strong[text()='View']")
public WebElement Link_View;

@FindBy(xpath="//td[@class='table-validity']//table//tbody//tr[3]//td//table//tbody//tr")
public List<WebElement> AllTheRates;
	
	
	public FrontdeskPackagesListPage SaveDetails() throws Exception{
			try{
				GenericMethods.clickElement(InclusiveOfTax_ChkBox);
				GenericMethods.clickElement(Save_Btn);
			}catch(Exception e){
				throw e;
			}
			FrontdeskPackagesListPage FPL=PageFactory.initElements(GenericMethods.driver, com.hotelogix.smoke.admin.PriceManager.FrontdeskPackagesListPage.class);
			return FPL;
	}

	public String getPerNightPrice(String rtype) throws Exception{
		String rate=null;
		try{
		GenericMethods.clickElement(Link_View);
		int size=AllTheRates.size()+2;
		for(int i=2;i<=size-2;i++){
			String rtname=GenericMethods.driver.findElement(By.xpath("//td[@class='table-validity']//table//tbody//tr[3]//td//table//tbody//tr["+i+"]//td[1]")).getText();
			if(rtname.equals(rtype)){
				 rate=GenericMethods.driver.findElement(By.xpath("//td[@class='table-validity']//table//tbody//tr[3]//td//table//tbody//tr[2]//td[5]//a")).getText();
				 break;
		}
		}
		}catch(Exception e){
			throw e;
		}
	     return rate;
	    }
	
	
	
	
	
	

}

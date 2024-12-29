package com.hotelogix.smoke.frontdesk.SampleRestaurantPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class SampleRestaurantPage {

@FindBy(xpath="//div[@id='btnsFeaturedContainer']/div/div")
public WebElement FeatureProduct;


@FindBy(xpath="//input[@class='bigbotton']")
public WebElement GenerateOrderBtn;

@FindBy(xpath="//div[@class='category-div']/div[1]")
public static WebElement frstCategory;

@FindBy(xpath="//div[@id='btnsProductContainer']//div[3]/div[1]")
public WebElement frstProduct;

@FindBy(name="btnConfirmOrder")
public WebElement ConfirmOrder_BT;

@FindBy(xpath="//li[@id='NEWTABBTN']/a/em/span[3]")
public  WebElement NewTab;

@FindBy(xpath="//div[@class='product-div']/div")
public WebElement FeaturedProductName_BT;

@FindBy(xpath="//input[@value='Generate Order']")
public WebElement GenerateOrder_BT;

@FindBy(id="folioNumberId")
public WebElement ConfirmOrderPage;

@FindBy(id="roomNo")
public WebElement RoomNumber_DD;

@FindBy(id="trsnToRoomGrpBnt")
public WebElement TransferToRoom_BT;

@FindBy(xpath="//select[@id='roomNo']//option")
public List<WebElement> RoomNumberText;

@FindBy(xpath="//fieldset[@id='paymentTab']//tr[3]//td[1]")
public WebElement VerifyTTRBox;

@FindBy(xpath="//div[@id='btnsCategoryContainer']/div/div")
public WebElement Btn_CategoryProduct;

@FindBy(xpath="//div[@class='product-div']/div")
public  WebElement Btn_product;









	public ConfirmOrderPage generateOrder() throws Exception{
		try{
			GenericMethods.js_Click(Btn_CategoryProduct);
			Thread.sleep(2000);
			GenericMethods.fn_ActionsClick(Btn_product);
			Thread.sleep(2000);
			GenericMethods.js_Click(GenerateOrderBtn);
		}catch(Exception e){
		   throw e;
		}
		ConfirmOrderPage COP=PageFactory.initElements(GenericMethods.driver, ConfirmOrderPage.class);
		return COP;
		}


	public ConfirmOrderPage GenrateOrder() throws Exception	{
	   try{
		GenericMethods.clickElement(FeatureProduct);
		GenericMethods.clickElement(GenerateOrderBtn);
		ConfirmOrderPage COP=PageFactory.initElements(GenericMethods.driver, ConfirmOrderPage.class);
		return COP;
	   }catch(Exception e){
		   throw e;
	   }
	   }


public ConfirmOrderPage fn_GenerateOrder() throws Exception{
	try{
	Thread.sleep(8000);
    GenericMethods.clickElement(FeaturedProductName_BT);
    Thread.sleep(4000);
    GenericMethods.clickElement(GenerateOrder_BT);
    Thread.sleep(5000);
    ConfirmOrderPage COP=PageFactory.initElements(GenericMethods.driver, ConfirmOrderPage.class);
    return COP;
	}
	catch(Exception e)
	{
		throw e;
	}
}





public OrderFromNewTab ClickOnNewTab() throws Exception{
try{
GenericMethods.clickElement(NewTab);
}
catch(Exception e){
throw e;
}
OrderFromNewTab	OFN = PageFactory.initElements(GenericMethods.driver, OrderFromNewTab.class);
return OFN;
}


public String fn_VerifySampleRestaurantPage(){
    String str=GenericMethods.driver.getTitle();
    return str;
}


//public static ConfirmOrderPage selectProduct() throws Exception
//{
//	GenericMethods.clickElement(frstCategory);
//	GenericMethods.clickElement(frstProduct);
//	GenericMethods.clickElement(GenerateOrderBtn);
//	GenericMethods.clickElement(ConfirmOrder_BT);
//	ConfirmOrderPage COP=PageFactory.initElements(GenericMethods.driver, ConfirmOrderPage.class);
//	return COP;
//}
//	public static
//    String str=GenericMethods.getText(ConfirmOrderPage);
//
//    if(str.contains("Order"))
//    {
//        System.out.println("Confirm Order Page gets displayed");
//    }else{
//        System.out.println("Confirm Order Page gets displayed");
//    }
//}



public void fn_VerifyGroupGenerateAndConfirmOrderPage() throws Exception
{
	GenericMethods.clickElement(FeaturedProductName_BT);
	GenericMethods.clickElement(GenerateOrder_BT);

	String str=GenericMethods.getText(ConfirmOrderPage);
	//GenericClass.selectElement(RoomNumber_DD, "201");
	Select selobj=new Select(RoomNumber_DD);
	selobj.selectByIndex(2);

//	Select seobj=new Select(RoomGuestName_DD);
//	seobj.selectByIndex(1);
	GenericMethods.clickElement(ConfirmOrder_BT);
    if(str.contains("Order")){
		System.out.println("page is nevigate on Folio Page");
	}else{
		System.out.println("page is not nevigate on Folio Page");
	}
    Assert.assertTrue(str.contains("Order"));
	//Assert.assertTrue(str, "Order");
}


public void fn_TransferToRoomButton() throws Exception
{

	GenericMethods.clickElement(TransferToRoom_BT);
	Thread.sleep(3000);
	String strobj=GenericMethods.getText(VerifyTTRBox);
	Thread.sleep(3000);
	for(int i=0; i<RoomNumberText.size();i++)
	{
		WebElement wobj=RoomNumberText.get(i);
		String stro=wobj.getText();
		if(strobj.contains(stro))
		{
			System.out.println("Transfer to RoomDetails section is visible on page");
			break;
		}

	}

}


public ConfirmOrderPage fn_selectChocBar() throws Exception
{
    WebElement ele=GenericMethods.driver.findElement(By.cssSelector("div[value^='Choc']"));
    ele.click();
    GenericMethods.clickElement(GenerateOrder_BT);
    ConfirmOrderPage COP=PageFactory.initElements(GenericMethods.driver, ConfirmOrderPage.class);
    return COP;

}


}

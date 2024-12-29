package com.hotelogix.smoke.frontdesk.SampleRestaurantPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.hotelogix.smoke.genericandbase.GenericMethods;

import junit.framework.Assert;

public class TransactionListPage {
	
	
	
	
	@FindBy(xpath="//fieldset[@id='tarnsactinTab']/table/tbody/tr")
	public List<WebElement> AllPosTransactionList;
	
	
public String getFolioNumber(String folio) throws Exception{
	String str=null;
	try{
int size=AllPosTransactionList.size();
for(int i=2;i<=size;i++){
 str=GenericMethods.driver.findElement(By.xpath("//fieldset[@id='tarnsactinTab']/table/tbody/tr["+i+"]/td[6]")).getText().trim();
if(str.equals(folio)){
Assert.assertEquals(folio, str);
Reporter.log("Folio Matched", true);
break;
}
}
}
catch(Exception e){
	
throw e;
}
	
	
	
return str;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}

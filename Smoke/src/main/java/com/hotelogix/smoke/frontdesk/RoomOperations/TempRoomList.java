package com.hotelogix.smoke.frontdesk.RoomOperations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class TempRoomList {

	@FindBy(xpath="//table[@id='roomPoTableId']//tr")
	public List<WebElement> count_tableRow;
	
	public  void fn_verifyTempResv(String gName) throws Exception {
		try {
		int count=GenericMethods.tr_count(count_tableRow);
		for(int i=2;i<=count;i++) {
			String gname=GenericMethods.driver.findElement(By.xpath("//table[@id='roomPoTableId']//tr["+i+"]//td[5]")).getText();
			if(gname.equalsIgnoreCase(gName)) {
				Assert.assertEquals(gname.equalsIgnoreCase(gName), true);
				GenericMethods.driver.findElement(By.xpath("//table[@id='roomPoTableId']//tr["+i+"]//td[16]//input")).click();
				GenericMethods.Alert_Accept();
				break;
			}
		}
		}catch(AssertionError e) {
			throw e;
		}catch(Exception e) {
			throw e;
		}
	}
	
	
}

package com.hotelogix.smoke.admin.PriceManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AttachPackagesPage {
	
	
	  @FindBy(xpath="//table[2]//tr")
	    public static List<WebElement> tabletrs;

	
	
    @FindBy(xpath="	//div[@class='padingtd']//table[2]/tbody/tr")
    public static List<WebElement> TR_Count; 
	

	
    @FindBy(xpath="//input[@name='save']")
    public static WebElement Attach_Btn;
	
    
    
  
    
    
    @FindBy(xpath="//input[@name='pkgMasterId[]']")
    public static List<WebElement> checkBox;
    
    
    public static String data;
	
    public static FrontdeskPackagesListPage AttachToFrondesk() throws Exception{
    	
    	
    	
   
    	  
  

        int trcount=GenericMethods.tr_count(checkBox);
        System.out.println(trcount);
       int tr=trcount+2;
        for(int i=2;i<=tr;i++){
         
        data=GenericMethods.driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[4]")).getText();
        System.out.println(data);         
          
        if(data.contains(AddEditPackagePage.packageName)){
               System.out.println("Searched Package Find and attaching it to the frontdesk ");
               WebElement  abc=GenericMethods.driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[2]/input"));
               abc.click();
               GenericMethods.clickElement(Attach_Btn);
               break;
           }
           else{
               System.out.println("Not verified");
           }
	}
    	
    	
    	FrontdeskPackagesListPage FPL=PageFactory.initElements(GenericMethods.driver, FrontdeskPackagesListPage.class);
    	return FPL;
    }
    
    
    
    
    
    public static FrontdeskPackagesListPage AttachToFrondesk(int iTestCaseRow) throws Exception{
    	
    	
    	
    	   
  	  
    	  

        int trcount=GenericMethods.tr_count(checkBox);
        System.out.println(trcount);
       int tr=trcount+2;
        for(int i=2;i<=tr-2;i++){
         
        data=GenericMethods.driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[4]")).getText();
        System.out.println(data);         
          
        if(data.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)))){
               System.out.println("Searched Package Find and attaching it to the frontdesk ");
               WebElement  abc=GenericMethods.driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[2]/input"));
               abc.click();
               GenericMethods.clickElement(Attach_Btn);
               break;
           }
           else{
               System.out.println("Not verified");
           }
	}
    	
    	
    	FrontdeskPackagesListPage FPL=PageFactory.initElements(GenericMethods.driver, FrontdeskPackagesListPage.class);
    	return FPL;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}

   
	
	
	
	
	
	




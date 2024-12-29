package com.hotelogix.smoke.admin.PriceManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.BasePage;
import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;
import com.itextpdf.text.log.SysoCounter;

public class FrontdeskPackagesListPage {
	
	
	
    public static String data;
    public static String src;
    
    public static String src1;
    
    
	  @FindBy(xpath="//input[@name='id[]']")
	    public static List<WebElement> ChkBox;
    
	//table//tr[4]/td
    
	  @FindBy(xpath="//table//tr[4]/td")
	    public static WebElement Msg;
	  
	  @FindBy(xpath="//select[@name='maxEntries']")
	    public WebElement DD_View;
	  
	   @FindBy(xpath="	//input[@name='id[]']")
       public List<WebElement> CB_All;
    
  
    

	    @FindBy(xpath="//a[@title='Attach a Package']")
	    public  WebElement AttachPackage_Btn;    
    
    
    
	    public attachPackages AttachPackage_Click() throws Exception{
	    	
	    	GenericMethods.clickElement(AttachPackage_Btn);
	    	attachPackages APP2=PageFactory.initElements(GenericMethods.driver, attachPackages.class);
	    	return APP2;
	     }
    
    
    
	
    public  FrontDeskPackageDetailPage  VerifyAndConfigure() throws Exception{
    	
    	
    	
   
    	  
  

        int trcount=GenericMethods.tr_count(ChkBox);
        System.out.println(trcount);
       int tr=trcount+2;
        for(int i=2;i<=tr;i++){
         
        data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
        System.out.println(data);         
          
        if(data.contains(AddEditPackagePage.packageName)){
               System.out.println(data +" Searched Package Find ");
                src=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]/img")).getAttribute("src");
                GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]/a")).click();
             
               break;
           }
          
	}
    	
    	
        FrontDeskPackageDetailPage FPD=PageFactory.initElements(GenericMethods.driver, FrontDeskPackageDetailPage.class);
    	return FPD;
    }


	
	
	
	
	public void VerifyConfigueration(){
		
	String msg=Msg.getText();
	System.out.println(msg);
	if(msg.contains(AddEditPackagePage.packageName)){
		System.out.println("syso Package added suceesfully goin to congigure it");
	}
		
	     int trcount=GenericMethods.tr_count(ChkBox);
	        System.out.println(trcount);
	       int tr=trcount+2;
	        for(int i=2;i<=tr;i++){
	         
	        data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
	        System.out.println(data);         
	          
	        if(data.contains(AddEditPackagePage.packageName)){
	               System.out.println(data +" Searched Package Find ");
	                src1=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]/a")).getText();
	             
	             
	               break;
	           }
	          
		}
		
		if(src.equals(src1)){
			System.out.println("Activation status remaining same");
		}
		else{
			System.out.println("Before configuring " +src);
			System.out.println("After configuring " +src1);
			
			System.out.println("Activation status changed");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void VerifyConfigurtn(int iTestCaseRow) throws Exception{
		
	String msg=Msg.getText();
	System.out.println(msg);
	if(msg.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)))){
		System.out.println("syso Package added suceesfully goin to congigure it");
	}
		
	     int trcount=GenericMethods.tr_count(ChkBox);
	        System.out.println(trcount);
	       int tr=trcount+2;
	        for(int i=2;i<=tr;i++){
	         
	        data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
	        System.out.println(data);         
	          
	        if(data.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)))){
	               System.out.println(data +" Searched Package Find ");
	                src1=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]/a")).getText();
	             
	             
	               break;
	           }
	          
		}
		
		if(src.equals(src1)){
			System.out.println("Activation status remaining same");
		}
		else{
			System.out.println("Before configuring " +src);
			System.out.println("After configuring " +src1);
			
			System.out.println("Activation status changed");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
    

public  FrontDeskPackageDetailPage clickOnPakEditlink(String PakName){
String aPname=null;
String fPname=null;
try
{
	
if(PakName.contains("(")){
	String b[]=PakName.split("\\(");
	fPname=b[0].toString();
}
	else{
			fPname=PakName;
		}

int trcount=GenericMethods.tr_count(ChkBox);
System.out.println(trcount);
int tr=trcount+2;
for(int i=2;i<=tr-2;i++){
     
    data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]/strong[1]")).getText();
    System.out.println(data);      
    if(data.contains("DLY")){
    	String a[]=data.split("\\[");
    	aPname=a[0].toString();
    	System.out.println("DLY there");
    }
    else if(data.contains("GRID")){
    	String a[]=data.split("\\[");
    	aPname=a[0].toString();
    	
    }
    else{
    	aPname=data;
    }
    
    if(aPname.equals(fPname)){
    	System.out.println(fPname +" Searched Package Find ");
     GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]/a")).click();
     break;
    }
      

	  
  }
	}
catch(Exception e){
	e.printStackTrace();
}
    FrontDeskPackageDetailPage FDPD=PageFactory.initElements(GenericMethods.driver,FrontDeskPackageDetailPage.class);
	return FDPD;
}












public boolean VerifyPackage(int iTestCaseRow) throws Exception{
	
	boolean pak=false;
GenericMethods.selectElement(DD_View, "All");
GenericMethods.ActionOnAlert("Accept");
int size=CB_All.size()+2;
for(int i=2;i<=size-1;i++){
    String pakname=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[3]/strong[1]")).getText();
	if(pakname.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)))){
		
		
		String src=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[8]/img")).getAttribute("src");
		Thread.sleep(2000);
		Assert.assertTrue(src.endsWith("on.GIF"));
		pak=true;
		break;
		
	}
}
return pak;
	

	
}




public void CreatePackageAndAttachToFD(int iTestCaseRow,boolean res) throws Exception{
if(res==false){
BasePage BP=new BasePage();
ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
AddEditPackage  AEP=LOPM.fn_NavigateToAddEditPackage();
LOPM=AEP.fillPkgDetail(iTestCaseRow);
ListOfPackagesFrontdesk  FPL= BP.fn_navigateFrontDskPkg();
String a=GenericMethods.driver.getTitle();
attachPackages  APP= FPL.AttachPackage_Click();
GenericMethods.switchToWindowHandle("Attach Package"); 
APP.selectPkgForFD(AddEditPackage.pkgName);
GenericMethods.switchToWindowHandle(a); 
PackageDetailsFrontDesk PDF=FPL.confgr_attachedPkgFD();	 
FPL=PDF.clickOnSave_BT();

String b=GenericMethods.driver.getTitle();

AddActivationDateFD AADF=FPL.AddActivationDateFD_click1();
GenericMethods.switchToWindowHandle("Add Activation Date"); 
AADF.activateForeverPackateFD();
GenericMethods.switchToWindowHandle(b);
FPL.verifyActivatedForeverFD_text();
}
}




public  FrontDeskPackageDetailPage  VerifyAndConfig(int iTestCaseRow) throws Exception{
	
	
	
	   
	  
	  

    int trcount=GenericMethods.tr_count(ChkBox);
    System.out.println(trcount);
   int tr=trcount+2;
    for(int i=2;i<=tr-2;i++){
     
    data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
    System.out.println(data);         
      
    if(data.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)))){
           System.out.println(data +" Searched Package Find ");
            src=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]/img")).getAttribute("src");
            GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]/a")).click();
         
           break;
       }
      
}
	
	
    FrontDeskPackageDetailPage FPD=PageFactory.initElements(GenericMethods.driver, FrontDeskPackageDetailPage.class);
	return FPD;
}




}

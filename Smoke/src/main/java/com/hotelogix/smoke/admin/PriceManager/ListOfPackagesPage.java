package com.hotelogix.smoke.admin.PriceManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class ListOfPackagesPage {

	  @FindBy(xpath="//table[@class='list_viewnew']")
	    public static WebElement tabletrs;



	    @FindBy(xpath="//a[text()='Add a Package']")
	    public static WebElement AddPackage_Btn;
	    
	    @FindBy(xpath="//select[@name='maxEntries']")
	    public WebElement DD_View;
	    
	    @FindBy(xpath="	//input[@name='id[]']")
        public List<WebElement> CB_All;
 
public AddEditPackagePage AddPackage_Btn() throws Exception{

	GenericMethods.clickElement(AddPackage_Btn);
	AddEditPackagePage AEP=PageFactory.initElements(GenericMethods.driver, AddEditPackagePage .class);
	return AEP;
}

public static void VerifyAddedPackage()
{
	String value = null;
	List<WebElement> rows=tabletrs.findElements(By.tagName("tr"));
	//int rsize=rows.size();
	for(int rnum=0;rnum<1;rnum++)
	{

      List<WebElement> columns=rows.get(rnum).findElements(By.xpath("//table[@class='list_viewnew']//td[3]"));
      //int  colsize=columns.size();
       for(int cnum=0;cnum<columns.size()-1;cnum++)
	{
	value=columns.get(cnum).getText();
	if(value.contains(AddEditPackagePage.packageName))
		System.out.println("Package has been successfully saved.");

		break;
//System.out.println(cnum + " block is " + columns.get(cnum).getText());
	//System.out.println(columns.get(cnum).getText());

	}

	}
}






public boolean VerifyPackage(int iTestCaseRow) throws Exception{
	
	boolean pak=false;
GenericMethods.selectElement(DD_View, "All");
GenericMethods.ActionOnAlert("Accept");
int size=CB_All.size()+2;
for(int i=2;i<=size;i++){
    String pakname=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[3]/strong[1]")).getText();
	if(pakname.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)))){
		pak=true;
		break;
		
	}
}
return pak;
	

	
}



















}

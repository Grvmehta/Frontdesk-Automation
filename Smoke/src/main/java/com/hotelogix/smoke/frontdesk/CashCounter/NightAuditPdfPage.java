package com.hotelogix.smoke.frontdesk.CashCounter;


import com.hotelogix.smoke.genericandbase.GenericMethods;

public class NightAuditPdfPage {



public String VerifyPage() throws Exception{
	String title=null;
try
	{
title=GenericMethods.driver.getTitle();
System.out.println(title);



	}
	catch(Exception e)
	{
		
		throw e;
	}
	return title;


}
}

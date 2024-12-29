package com.hotelogix.smoke.frontdesk.CashCounter;


import com.hotelogix.smoke.genericandbase.GenericMethods;

public class NightAuditVideoPage {


	public String VerifyPage() throws Exception
	{
		String title=null;
		try
		{
		 title=GenericMethods.driver.getTitle();
		
		}
	
		catch(Exception e)
		{
			
			throw e;
		}
		return title;

	}

}

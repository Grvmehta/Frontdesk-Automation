package com.hotelogix.smoke.FrontdeskTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hotelogix.smoke.AdminTest.TestNGCustomisedReport;

import junit.framework.Assert;


@Listeners(TestNGCustomisedReport.class)
public class TestRealReport
{

	 @Test(priority=0,description="testReporterOne")
	public void testRealReportOne()
	{
		Assert.assertTrue(true);
	}
	

	 @Test(priority=1,description="testReporterTwo")
	public void testRealReportTwo()
	{
		Assert.assertTrue(false);
	}
	
	
	//Test case depends on failed testcase= testRealReportTwo

    //@Test(dependsOnMethods="testRealReportTwo")

    public void testRealReportThree(){

        

    }
	
}

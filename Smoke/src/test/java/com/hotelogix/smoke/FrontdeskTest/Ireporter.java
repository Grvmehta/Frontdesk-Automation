package com.hotelogix.smoke.FrontdeskTest;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.IRetryAnalyzer;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Ireporter implements IReporter, IRetryAnalyzer, ITestListener{
	private static ExtentReports extent;
	public static ExtentTest test;
	
	static String s1="";
	
	public static void getstarttime(){
	//	test=RoomsTest.test;
		test.setStartedTime(new Date());
	}
	public static ExtentReports getExtent(){
		s1=LocalDate.now().toString();
		System.out.println(s1);
		
		//newly added for screesnhot code
		File fObj=new File(System.getProperty("user.dir")+"./Report/"+"Frontdesk NewUI "+s1+"/Screenshot");
		System.out.println(fObj.getAbsolutePath());
		boolean bObj=	fObj.mkdirs();
		System.out.println("Report folder created or not::"+bObj);
		//till here
		
		
		//ER=new ExtentReports("./Report/"+extentReport+s1+"/"+extentReport +s1+".html");
		
		//return extent = new ExtentReports("Report\\" + File.separator + "Frontdesk "+s1+".html");
		return extent = new ExtentReports("./Report/"+"Frontdesk NewUI "+s1+"/"+ "Frontdesk NewUI "+s1+".html");
	}
	 public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
			//   extent = new ExtentReports("Report\\" + File.separator + "ExtentReportTestNG.html", true);
			    	try{
			    	extent =getExtent();
			        for (ISuite suite : suites) {
			            Map<String, ISuiteResult> result = suite.getResults();
			            for (ISuiteResult r : result.values()) {
			                ITestContext context = r.getTestContext();
			                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
			                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
			                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			            }
			        }
			        extent.flush();
			        extent.close();
			        
			        GenericMethods.zipFolder("./Report/"+"Frontdesk NewUI " +s1, System.getProperty("user.dir")+"/Report/"+"Frontdesk NewUI "+s1+".zip");
			    	}catch(Exception e){
			    		try {
							throw e;
						} catch (Exception e1) {
							e1.printStackTrace();
						}
			    	    }
			           }
	 
	 
    public void buildTestNodes(IResultMap tests, LogStatus status) throws Exception {
         if (tests.size() > 0) {
             for (ITestResult result : tests.getAllResults()) {
            	
            	test = extent.startTest(result.getInstanceName().split("\\.")[4]+" :: "+result.getMethod().getMethodName());
                test.getStartedTime();
                test.getEndedTime();
                test.setStartedTime(getTime(result.getStartMillis()));
                test.setEndedTime(getTime(result.getEndMillis()));
                 for (String group : result.getMethod().getGroups())
                     test.assignCategory(group);
                 if (result.getThrowable() != null) {
                	
                	 // test.log(status, test.addScreenCapture(System.getProperty("user.dir")+"\\Screenshots\\"+ result.getMethod().getMethodName()+".jpg"),result.getThrowable());
                	 test.log(status, test.addScreenCapture("./Screenshot/"+ result.getMethod().getMethodName()+".jpg"),result.getThrowable());
                	
                 }else{
                     test.log(status, result.getMethod().getDescription());
                 } 
                 extent.endTest(test);
            }
            }
            }
    
    
    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();        
    }
    
    private int retryCount = 0;
	private int maxRetryCount = 1;
	public boolean retry(ITestResult result) {
		  if (retryCount < maxRetryCount) {
	            retryCount++;
	            return true;
	        }return false;
	}
//	ATUTestRecorder recorder;
	
	public void onTestStart(ITestResult result) {
//		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
//		  Date date = new Date();
//		try {
//			recorder = new ATUTestRecorder("D:\\livestable_Smoke\\livestable_Smoak\\livestable_Smoak\\FailedVideos",result.getMethod().getMethodName()+dateFormat.format(date),false);
//			recorder.start();
//		} catch (ATUTestRecorderException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("Start execution of Test "+ result.getMethod().getMethodName());
	}
	
	public void onTestSuccess(ITestResult result) {
//		 try {
//			recorder.stop();
//		} catch (ATUTestRecorderException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		String newLine = System.getProperty("line.separator");
		System.out.println(result.getMethod().getMethodName()+" is Passed."+newLine+result.getMethod().getDescription()+"::From extent report");
	}
	
	public void onTestFailure(ITestResult result) {
//		 try {
//			recorder.stop();
//		} catch (ATUTestRecorderException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		 System.err.println(result.getMethod().getMethodName()+" is Failed."+" Reason "+result.getThrowable().getMessage());
	}
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}
	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}
	
	public void onFinish(ITestContext context){
		// TODO Auto-generated method stub
		
		//super.onFinish(context);
		System.out.println("In On Finsh block");
        // List of test results which we will delete later
        List<ITestResult> testsToBeRemoved = new ArrayList<>();

        // collect all id's from passed test
        Set <Integer> passedTestIds = new HashSet<>();
        for (ITestResult passedTest : context.getPassedTests().getAllResults()) {
            passedTestIds.add(getId(passedTest));
            System.out.println("passedTest:"+passedTest+"passed test id::::"+passedTestIds);
        }

        Set <Integer> failedTestIds = new HashSet<>();
        for (ITestResult failedTest : context.getFailedTests().getAllResults()) {

            // id = class + method + dataprovider
        	
            int failedTestId = getId(failedTest);
            if(failedTestIds.contains(failedTestId))
            {
            	System.out.println("test case is repetetive and adding it to removing list");
            	testsToBeRemoved.add(failedTest);
            }
            else
            {
           
            failedTestIds.add(failedTestId);
            System.out.println("failedTest::::"+failedTest+"Failed Test case id::"+failedTestId);
            // if we saw this test as a failed test before we mark as to be deleted
            // or delete this failed test if there is at least one passed version
            if (failedTestIds.contains(failedTestId) && passedTestIds.contains(failedTestId)) {
            	System.out.println("In if of failed test case and test case added to teststo be removed list");
                testsToBeRemoved.add(failedTest);
            } else {
                failedTestIds.add(failedTestId);
                System.out.println("In else of failed test case and test case didn't added to teststoberemoved list");
            }
        }
        }

        // finally delete all tests that are marked
        
        
       // Set <Integer> skippedTestIds = new HashSet<>();
        for (ITestResult skippedTest : context.getSkippedTests().getAllResults()) {
        	
            // id = class + method + dataprovider
            int skippedTestId = getId(skippedTest);
            
            System.out.println("SkippedTestcase::"+skippedTest+"   Skippded test case id:::"+skippedTestId);
            // if we saw this test as a failed test before we mark as to be deleted
            // or delete this failed test if there is at least one passed version
            if (failedTestIds.contains(skippedTestId) || passedTestIds.contains(skippedTestId)) {
            	 System.out.println("In if of skipped test case and test case added to teststoberemoved list");
                testsToBeRemoved.add(skippedTest);
            } 
        }
        
        Iterator i2=testsToBeRemoved.iterator();
        while(i2.hasNext())
        {
        	System.out.println("testtoberemoved list elements::"+i2.next());
        }
        
        
        for (Iterator<ITestResult> iterator = context.getFailedTests().getAllResults().iterator(); iterator.hasNext(); ) {
            ITestResult testResult = iterator.next();
        System.out.println("Removing test case:::"+testResult);
       
        try
        {
        		System.out.println("In Try for failed");
            if (testsToBeRemoved.contains(testResult)) {
            	System.out.println("IN IF for failed ");
                iterator.remove();
            }
            else
            {
            	System.out.println("In Else for failed removal");
            }
        }catch(Exception e)
        {
        	e.printStackTrace();
        
        }
        }
       
        for (Iterator<ITestResult> iterator = context.getSkippedTests().getAllResults().iterator(); iterator.hasNext(); ) {
            ITestResult testResult = iterator.next();
        System.out.println("Removing skipped test case:::"+testResult);
       
        try
        {
        		System.out.println("In Try for skipped removal");
            if (testsToBeRemoved.contains(testResult)) {
            	System.out.println("IN IF for skipped removal");
                iterator.remove();
            }
            else
            {
            	System.out.println("In Else for skipped removal");
            }
        }catch(Exception e)
        {
        	e.printStackTrace();
        
        }
        }
       
        
        
        
        
      /*  for (ITestResult testResult1 :context.getFailedTests().getAllResults()) {
        	//Iterator<ITestResult> iterator = context.getFailedTests().getAllResults().iterator(); iterator.hasNext();
        System.out.println("Removing test case:::"+testResult1);
            if (testsToBeRemoved.contains(testResult1)) {
            	testsToBeRemoved.remove(testResult1);
                
            }
        }
      */  
        
        

    }

		
	public static int getId(ITestResult result) {
        int id = result.getTestClass().getName().hashCode();
        id = 31 * id + result.getMethod().getMethodName().hashCode();
        id = 31 * id + (result.getParameters() != null ? Arrays.hashCode(result.getParameters()) : 0);
        return id;
    }
	
	
    
}


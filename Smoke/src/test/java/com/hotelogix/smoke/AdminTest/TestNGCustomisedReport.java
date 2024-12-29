package com.hotelogix.smoke.AdminTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.testng.IInvokedMethod;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.collections.Lists;
import org.testng.internal.Utils;
import org.testng.xml.XmlSuite;

public class TestNGCustomisedReport implements IReporter{

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub
		 
		
		// Second parameter of this method ISuite will contain all the suite executed.

        for (ISuite iSuite : suites) {

         //Get a map of result of a single suite at a time

            Map<String,ISuiteResult> results = iSuite.getResults();

         //Get the key of the result map

            Set<String> keys = results.keySet();

        //Go to each map value one by one

            for (String key : keys) {

             //The Context object of current result

            ITestContext context = results.get(key).getTestContext();

            //Print Suite detail in Console

             System.out.println("Suite Name->"+context.getName()

                    + "::Report output Ditectory->"+context.getOutputDirectory()

                     +"::Suite Name->"+ context.getSuite().getName()

                     +"::Start Date Time for execution->"+context.getStartDate()

                     +"::End Date Time for execution->"+context.getEndDate());

            

             //Get Map for only failed test cases

            IResultMap resultMap = context.getFailedTests();

            //Get method detail of failed test cases

            Collection<ITestNGMethod> failedMethods = resultMap.getAllMethods();

            //Loop one by one in all failed methods

            System.out.println("--------FAILED TEST CASE---------");

            for (ITestNGMethod iTestNGMethod : failedMethods) {

                //Print failed test cases detail

                System.out.println("TESTCASE NAME->"+iTestNGMethod.getMethodName()

                        +"\nDescription->"+iTestNGMethod.getDescription()

                        +"\nPriority->"+iTestNGMethod.getPriority()

                        +"\n:Date->"+new Date(iTestNGMethod.getDate()));

                

            }

        }

        }

        

    }
	
	

}

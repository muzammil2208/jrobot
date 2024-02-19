package jrobot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class reporting {
	ExtentReports report;
	ExtentTest test;
	
	public  void createTest(String name)
	{
		String path=System.getProperty("user.dir");
		ExtentSparkReporter spark = new ExtentSparkReporter(path+"/Results/"+name+".html");
		report=new ExtentReports();
		report.attachReporter(spark);
		test=report.createTest(name);
		
	}
	public  void logFail(String message,String path)
	{
		test.fail(message,MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	}
	public  void logPass(String message,String path) 
	{
		test.pass(message,MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	}
	public void logPass(String message)
	{
		test.pass(message);
	}
	public void logFail(String message)
	{
		test.fail(message);
	}
	public void log(String message)
	{
		test.log(Status.INFO,message);
	}
	public void log(String message,String path)
	{
		test.log(Status.INFO,message, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	}
	public  void EndTest()
	{
		report.flush();
	}
}

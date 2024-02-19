package jrobot;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenshot {

	WebDriver driver;
	
	public screenshot(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String takeSnapShot(String filename) 
	{
		
			TakesScreenshot screenshot =((TakesScreenshot)driver);
			File src=screenshot.getScreenshotAs(OutputType.FILE);
			String home=System.getProperty("user.dir");
			String path=home+"/Results/ScreenShots/"+filename+".png";
			File des=new File(path);
			try {
			FileUtils.copyFile(src, des);
			System.out.println("ScreenShot is captured");
			
		}
		catch(Exception e)
		{
			System.out.println("Error while taking screenshot");
			System.out.println("Error message:"+e.getMessage());
		}
		return des.getAbsolutePath();
		
	}
}

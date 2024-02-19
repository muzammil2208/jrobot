package jrobot;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jrobot.reporting;
import jrobot.screenshot;

public class customActions
{
	 reporting report;
	 WebDriverWait wait;
	 screenshot sc;
	 Actions act;
	public customActions(WebDriver driver,reporting report)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		this.report=report;
		sc=new screenshot(driver);
		act=new Actions(driver);
	}
	
	public void enterText(WebElement element,String value)
	{
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(value);
			String name=element.getAccessibleName();
			report.logPass("entered text in "+name,sc.takeSnapShot("username_pass"));
		}
		catch(Exception e)
		{
			report.logFail("not able to find username filed", sc.takeSnapShot("username_fail"));
			System.out.println(e.getMessage());
		}
	}
	
	public void click(WebElement element)
	{
		
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
			report.logPass("element clicked successfully",sc.takeSnapShot("click element succsfully"));
		}
		catch(Exception e)
		{
			report.logFail("not able to find the element", sc.takeSnapShot("click element unsuccesfull"));
			System.out.println(e.getMessage());
		}
	}
	public void hower(WebElement element)
	{
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			act.moveToElement(element).perform();
			report.logPass("element is howered successfully",sc.takeSnapShot("element howered succsfully"));
		}
		catch(Exception e)
		{
			report.logFail("not able to find the element", sc.takeSnapShot("hower element unsuccesfull"));
			System.out.println(e.getMessage());
		}
	}

}
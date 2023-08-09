package com.bcci.ipl.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bcci.ipl.utility.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class Element extends BaseTest{

	public static WebElement getElement(WebDriver driver, String strLocator) {
		WebElement element = null;
		try {
			String strLocatorType = strLocator.split(":=")[0];
			String strLocatorValue = strLocator.split(":=")[1];
			
			if(strLocatorType.equalsIgnoreCase("NAME")) {
				element = driver.findElement(By.className(strLocatorValue));
			}else if(strLocatorType.equalsIgnoreCase("ID")) {
				element = driver.findElement(By.id(strLocatorValue));
			}else if(strLocatorType.equalsIgnoreCase("HTMLID")) {
				element = driver.findElement(By.id(strLocatorValue));
			}else if(strLocatorType.equalsIgnoreCase("XPATH")) {
				element = driver.findElement(By.xpath(strLocatorValue));
			}else if(strLocatorType.equalsIgnoreCase("CSS")) {
				element = driver.findElement(By.cssSelector(strLocatorValue));
			}else if(strLocatorType.equalsIgnoreCase("LINKTEXT")) {
				element = driver.findElement(By.className(strLocatorValue));
			}else if(strLocatorType.equalsIgnoreCase("TAGNAME")) {
				element = driver.findElement(By.className(strLocatorValue));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			assertion.fail(e.getMessage());
			report.log(LogStatus.FAIL,"exception : "+e.getMessage());
		}
		return element;
	}
	
	
}

package com.bcci.ipl.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bcci.ipl.selenium.Element;
import com.bcci.ipl.utility.BaseTest;

public class HomePage extends BaseTest{

	
	 public HomePage() { this.driver = driver; }
	 
	public String lnk_matches = "XPATH:=.//nav[@class='site-navigation text-center']//ul//a[@data-element_text='MATCHES']";
	public String lnk_logo = "XPATH:=.//div[@class='ap-ipl-logo']";
	
	WebElement ele_Matches = Element.getElement(driver, lnk_matches);
	WebElement ele_Logo = Element.getElement(driver, lnk_logo);
	
	public void verifyMatchesLnk() {
		visible(driver,ele_Matches,report,"Verfying Matches link");
	}
	
	public void verifyLogoLnk() {
		visible(driver,ele_Logo,report,"Verfying Logo");
	}
	
	
	
}

package testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IplLaunchTest2 {

	
	public static WebDriver driver;
	
	@BeforeClass
	public void runBeforeClass() {
		System.out.println("Before Class class 3 execution");
	}
	
	@BeforeMethod
	public void runBeforeMethod() {
		System.out.println("Before Method class 3 execution");
	}
	
	@Test
	@Parameters({"Url","Browser"})
	public void test1(@Optional("par1 is optional") String par1, String par2) {
		System.out.println("Launch class 3 Test1");
		System.out.println("parameter 1 value : "+par1 +" parameter 2 value : "+par2);
		ChromeOptions chromeOptions  = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		
		chromeOptions.addArguments("--disable-gpu");
		chromeOptions.addArguments("--no-sandbox");
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
		driver.get(par1);
		System.out.println("Closing Test1 browser");
		driver.close();
	}
	
	@Test
	@Parameters({"Url","Browser"})
	public void test2(@Optional("par1 is optional") String par1, String par2) {
		System.out.println("Launch class 3 Test2");
		System.out.println("parameter 1 value : "+par1 +" parameter 2 value : "+par2);
		ChromeOptions chromeOptions  = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		
		chromeOptions.addArguments("--disable-gpu");
		chromeOptions.addArguments("--no-sandbox");
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
		driver.get(par1);
		System.out.println("Closing Test2 browser");
		driver.close();
	}
	
	@Test
	public void test3() {
		System.out.println("Launch class 3 Test3");
	}
	
	@AfterMethod
	public void runAfterMethod() {
		System.out.println("After Method class 3 execution");
	}
	
	@AfterClass
	public void runAfterClass() {
		System.out.println("After Class class 3 execution");
	}
	
}

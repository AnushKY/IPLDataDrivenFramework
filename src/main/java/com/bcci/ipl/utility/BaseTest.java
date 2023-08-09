package com.bcci.ipl.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest extends ExtentReporter{
	
	

	public static void navigateToUrl(String browser, String url) {
		
		if(browser.equalsIgnoreCase("Chrome")) {
			ChromeOptions chromeOptions  = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);
			chromeOptions.addArguments("--disable-gpu");
			chromeOptions.addArguments("--no-sandbox");
			chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
		}else if(browser.equalsIgnoreCase("IE")) {
			InternetExplorerOptions internetexplorerOptions = new InternetExplorerOptions();
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver(internetexplorerOptions);
		}else if(browser.equalsIgnoreCase("Firefox")) {
			FirefoxOptions firefoxoptions = new FirefoxOptions();
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(firefoxoptions);
		}else if(browser.equalsIgnoreCase("Edge")) {
			EdgeOptions edgeoptions = new EdgeOptions();
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(edgeoptions);
		}else {
			System.out.println("No Browser configured"); 
		}
		driver.get(url);
	}
	
	public static void closeBrowser() {
		driver.close();
	}
	
	public static void setImplicitWait(long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
	
	public static String captureScreen(WebDriver driver, String imageName) {
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String encodedBase64 = null;
        FileInputStream fileInputStreamReader = null;
        try {
            fileInputStreamReader = new FileInputStream(sourceFile);
            byte[] bytes = new byte[(int) sourceFile.length()];
            fileInputStreamReader.read(bytes);
            encodedBase64 = new String(Base64.encodeBase64(bytes));
            String screenShotDestination = System.getProperty("user.dir") + "/ScreenShots/" + imageName + ".png";
            File destination = new File(screenShotDestination);
            FileUtils.copyFile(sourceFile, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "data:image/png;base64," + encodedBase64;
    }

	public static void highlightElement(WebDriver dr, WebElement elm) {
        JavascriptExecutor js = (JavascriptExecutor) dr;
        js.executeScript("arguments[0].setAttribute('style','border: 1.5px solid red;');", elm);
    }
	
	
	public static void visible(WebDriver dr, WebElement elm, ExtentTest extentTest, String message) {
        try {
            new WebDriverWait(dr, 15).until(ExpectedConditions.visibilityOf(elm));
            highlightElement(dr, elm);
            if (elm.isDisplayed()) {
                extentTest.log(LogStatus.PASS, message);
            } else {
                extentTest.log(LogStatus.FAIL, message + extentTest.addBase64ScreenShot(captureScreen(dr, message)));
            }
        } catch (Exception e) {
            e.printStackTrace();
            extentTest.log(LogStatus.FAIL,
                    message + extentTest.addBase64ScreenShot(captureScreen(dr, message)) + e.getMessage());
        }
    }
	
	
	
	
}

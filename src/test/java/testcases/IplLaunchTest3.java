package testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IplLaunchTest3 {

	
	@BeforeClass(alwaysRun=true)
	public void runBeforeClass() {
		System.out.println("Before Class class 3 execution");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void runBeforeMethod() {
		System.out.println("Before Method class 3 execution");
	}
	
	@Test(priority=2, groups= {"SmokeTest","RegressionTest"})
	public void test1() {
		System.out.println("Launch class 3 Test1");
	}
	
	@Test(groups= {"SmokeTest"})
	public void test2() {
		System.out.println("Launch class 3 Test2");
	}
	
	@Test(priority=0, groups= {"RegressionTest"})
	public void test3() {
		System.out.println("Launch class 3 Test3");
	}
	
	@AfterMethod(alwaysRun=true)
	public void runAfterMethod() {
		System.out.println("After Method class 3 execution");
	}
	
	@AfterClass(alwaysRun=true)
	public void runAfterClass() {
		System.out.println("After Class class 3 execution");
	}
	
}

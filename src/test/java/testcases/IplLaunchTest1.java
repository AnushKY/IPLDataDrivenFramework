package testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IplLaunchTest1 {

	
	@BeforeTest
	public void runBeforeTest() {
		System.out.println("Before Test class 1 execution");
	}
	
	@BeforeClass
	public void runBeforeClass() {
		System.out.println("Before Class class 1 execution");
	}
	
	@BeforeMethod
	public void runBeforeMethod() {
		System.out.println("Before Method class 1 execution");
	}
	
	@Test(priority=0)
	public void test1() {
		System.out.println("Launch class 1 Test1");
		Assert.assertTrue(true);
	}
	
	@Test(dependsOnMethods= {"test1"}, priority=1)
	public void test2() {
		System.out.println("Launch class 1 Test2");
	}
	
	@Test(dependsOnMethods= {"test2"},priority=2)
	public void test3() {
		System.out.println("Launch class 1 Test3");
	}
	
	@Test(invocationCount=3, priority=4)
	public void test4() {
		System.out.println("Launch class 1 Test4");
	}
	
	@AfterMethod
	public void runAfterMethod() {
		System.out.println("After Method class 1 execution");
	}
	
	@AfterClass
	public void runAfterClass() {
		System.out.println("After Class class 1 execution");
	}
	
	@AfterTest
	public void runAfterTest() {
		System.out.println("After Test class 1 execution");
	}
	
}

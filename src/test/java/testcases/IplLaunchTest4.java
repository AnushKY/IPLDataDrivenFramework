package testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IplLaunchTest4 {

	
	@BeforeClass(alwaysRun=true)
	public void runBeforeClass() {
		System.out.println("Before Class class 4 execution");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void runBeforeMethod() {
		System.out.println("Before Method class 4 execution");
	}
	
	@Test(dataProvider = "testDataProvider")
	public void test1(String val1, String val2) {
		System.out.println("Launch class 4 Test1");
		System.out.println("Value 1 : "+val1+"  Value 2 :"+val2);
	}
	
	@Test()
	public void test2() {
		System.out.println("Launch class 4 Test2");
	}
	
	@Test()
	public void test3() {
		System.out.println("Launch class 4 Test3");
	}
	
	@DataProvider(name="testDataProvider")
	public Object[][] dpMethod(){
		Object[][] a = new Object[2][2];
		a[0][0] = "Anush";
		a[0][1] = "Adiga";
		a[1][0] = "Ankush";
		a[1][1] = "Adiga";
		
		return a;
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

package com.test.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.base.Base;
import com.test.pageobjects.MyAccountpage;

public class MyAccounttestpage extends Base {
	MyAccountpage myaccnt;
	
//	@BeforeTest
//
//	public void setup(String browser)
//	{
//		intialize_properties();
//		intialize_driver(browser);
//	}
	
	@Test
	public void search() {
		myaccnt=new MyAccountpage();
	myaccnt.search("t-shirt");
	myaccnt.searchbtn();
	myaccnt.productresult();
	}
	
//	
//	@AfterTest
//	public void tearDown() {
//		getdriver().quit();
//	}
//
}

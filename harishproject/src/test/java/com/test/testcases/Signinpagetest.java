package com.test.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.base.Base;
import com.test.pageobjects.Homepage;
import com.test.pageobjects.Signin;
import com.test.pageobjects.Indexpage;



public class Signinpagetest extends Base {
public Signin signin;
public Indexpage ipage;
public Homepage homepage;

@Parameters("browser")
	@BeforeTest
	
	public void setup(String browser)
	{
		intialize_properties();
		intialize_driver(browser);
	}



	@Test(dataProvider="logindata")
	public void signin(String name,String pwd) throws InterruptedException {
		
	signin=new Signin();
	ipage=new Indexpage();
	homepage=new Homepage();
	
	ipage.signinlink();
	try {
		capturescreen(getdriver(), "login");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	signin.login(name, pwd, homepage);

	
	}
	
//	@AfterMethod
//	public void signout() {
//		try {
//			if(homepage.getSignout().isDisplayed()) {
//				homepage.getSignout().click();
//			}
//		}catch(Exception e) {
//			
//		}
//	}
	
	@AfterTest
	public void tearDown() {
		getdriver().quit();
	}
	
	@DataProvider(name="logindata")
	public String[][] getTestData() throws IOException {
	
	int row=com.test.util.Excelreader.getRowCount(excelread(), "credentials");
	int col=com.test.util.Excelreader.getCellCount(excelread(), "credentials", 1);
	String logindata1[][]=new String[row][col];
	for(int i=1;i<=row;i++) {
		for(int j=0;j<col;j++) {
			logindata1[i-1][j]=com.test.util.Excelreader.getCellData(excelread(), "credentials", i, j);
			
		}
	}
	return logindata1;
		
	}

}

	
	
	
	



	
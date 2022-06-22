package com.test.testcases;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.base.Base;
import com.test.pageobjects.Indexpage;
import com.test.util.Listener;

public class Indexpagetest extends Base{
	public static Indexpage ipage;
	
	public static Logger log=LogManager.getLogger(Listener.class);

	@AfterTest()
	public void tearDown() {
		getdriver().close();
	}
//	@Parameters("browser")
	@Test
	
	public void verifylogo() {
		ipage=new Indexpage();
		//intialize_driver(browser);
		//intialize_properties();
		boolean res=ipage.validatelogo();
	log.info("passed logo");;
		Assert.assertTrue(res);
			
		
	}
	
	@Test
	public void verifyurl() {
		String actual=ipage.geturl();
		Assert.assertEquals(actual,"My Store");
	}
	
	
	@Test
	public void signinlink() {
		try {
			ipage.signinlink();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	

}

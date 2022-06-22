package com.test.testcases;

import org.testng.annotations.Test;
import com.test.base.Base;
import com.test.pageobjects.Addtocartpage;

public class Addtocart extends Base {
	public static Addtocartpage add;
	
	
	
@Test
	public void addtcart() {
	add=new Addtocartpage();
	add.addtocart();
	
	add.proceedtocheck();
}
	
}

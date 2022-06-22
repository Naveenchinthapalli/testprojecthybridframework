package com.test.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.pageobjects.Addresspage;
import com.test.pageobjects.Addtocartpage;
import com.test.pageobjects.Orderconfirmationpage;
import com.test.pageobjects.Orderpage;
import com.test.pageobjects.Ordersummarypage;
import com.test.pageobjects.Paymentpage;
import com.test.pageobjects.Shippingpage;

public class Orderpagetest {
	
	
	
	Orderpage order;
	Addtocartpage add;
	Addresspage address;
	Shippingpage shipping;
	Paymentpage payment;
	Ordersummarypage summary;
	Orderconfirmationpage orderconfirm;
	@Test
	public void order() throws Throwable {
		order=new Orderpage();
		address=new Addresspage();
		shipping=new Shippingpage();
		payment=new Paymentpage();
		summary=new Ordersummarypage();
		orderconfirm=new Orderconfirmationpage();
		add=new Addtocartpage();
		add.addtocart();
		add.proceedtocheck();
	order.proceedtocheck();
	
	
	address.clickOnCheckOut();
	shipping.checkTheTerms();
	shipping.clickOnProceedToCheckOut();
	payment.bankwire();
	summary.clickOnconfirmOrderBtn();
	boolean msg=orderconfirm.confirmmsg();
	
	Assert.assertTrue(msg);
		
	}

}

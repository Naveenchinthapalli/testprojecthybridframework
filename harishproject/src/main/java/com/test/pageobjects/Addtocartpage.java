package com.test.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.base.Base;
import com.test.util.Elementaction;

public class Addtocartpage extends Base {
	
	public Addtocartpage() {

		PageFactory.initElements(getdriver(), this);
	}
	Elementaction action=new Elementaction();
	@FindBy(xpath="//span[contains(text(),'Add to cart')]")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedtocheckbtn;
	
	public void addtocart() {
		WebDriverWait wait=new WebDriverWait(getdriver(),20);
		wait.until(ExpectedConditions.visibilityOf(addToCartBtn));
		wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
		action.click(getdriver(), addToCartBtn);
	
	}
	
	public Orderpage proceedtocheck() {
		WebDriverWait wait=new WebDriverWait(getdriver(),20);
		wait.until(ExpectedConditions.visibilityOf(proceedtocheckbtn));
		wait.until(ExpectedConditions.elementToBeClickable(proceedtocheckbtn));
		action.click(getdriver(), proceedtocheckbtn);
		return new Orderpage();
	}
	
	
	
	
	
	
	

}

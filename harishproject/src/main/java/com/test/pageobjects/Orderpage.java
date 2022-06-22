package com.test.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.base.Base;
import com.test.util.Elementaction;

public class Orderpage extends Base {
	public Orderpage() {

		PageFactory.initElements(getdriver(), this);
	}
	Elementaction action=new Elementaction();
	@FindBy(xpath="//span[contains(text(),'16.51')]")
	private WebElement unitprice;
	@FindBy(xpath="//td[@class=\"cart_total\"]/span[1]")
	private WebElement totalprice;
	@FindBy(xpath="//span[(text()='Proceed to checkout')]")
	private WebElement proceedToCheckOutBtn;
	
	
	
	
	
	public double unitprice() {
		String unitprice1=unitprice.getText();
	String unit=	unitprice1.replaceAll("[^a-zA-Z0-9]", " ");
		Double finalunitprice=Double.parseDouble(unit);
		return finalunitprice/100;
	}
	public double totalprice() {
		String totalprice1=totalprice.getText();
	String total=	totalprice1.replaceAll("[^a-zA-Z0-9]", " ");
		Double finaltotalprice=Double.parseDouble(total);
		return finaltotalprice/100;
	}
	public Addresspage proceedtocheck() throws InterruptedException {
//		WebDriverWait wait=new WebDriverWait(getdriver(),20);
//		wait.until(ExpectedConditions.visibilityOf(proceedToCheckOutBtn));
//		wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckOutBtn));
		Thread.sleep(3000);
//		Actions act =new Actions(getdriver());
//		act.moveToElement(proceedToCheckOutBtn).build();
	//	action.click(getdriver(), proceedToCheckOutBtn);
		JavascriptExecutor executor = (JavascriptExecutor)getdriver();
		executor.executeScript("arguments[0].click();",proceedToCheckOutBtn);
		return new Addresspage();
	}
}

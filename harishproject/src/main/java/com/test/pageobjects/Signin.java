package com.test.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.base.Base;
import com.test.util.Elementaction;

public class Signin extends Base{
	public Elementaction action= new Elementaction();
	public Signin() {
		PageFactory.initElements(getdriver(), this);
	}
	
	@FindBy(id="email")
	private WebElement username;
	
	@FindBy(id="passwd")
	private WebElement password;

	@FindBy(id="SubmitLogin")
	private WebElement signinbtn;
	
	@FindBy(name="email_create")
	private WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	private WebElement createNewAccountBtn;
	
	public Homepage login(String uname,String pwd,Homepage homepage) throws InterruptedException {
		action.sendkeys(username, uname);
		action.sendkeys(password, pwd);
		Thread.sleep(2000);
		action.click(getdriver(), signinbtn);
		homepage=new Homepage();
		return homepage;
	}
	
	public Accountcreationpage createnewaccount(String newemail) {
		action.type(emailForNewAccount, newemail);
		action.click(getdriver(), createNewAccountBtn);
		return new Accountcreationpage();
		
	}
	
	
	
	
	
	
	
}

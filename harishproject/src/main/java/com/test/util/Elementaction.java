package com.test.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.base.Base;

public class Elementaction extends Base {
	
	public void click(WebDriver driver, WebElement ele) {
		Actions act=new Actions(driver);
		act.moveToElement(ele).click().build().perform();
		
	}
	public void sendkeys(WebElement ele,String nam) {
		ele.sendKeys(nam);
	}
	public boolean type(WebElement ele,String name) {
		ele.sendKeys(name);
	boolean flag=ele.isDisplayed();
		return flag;
	}
	public boolean isdisplayed(WebDriver driver,WebElement ele) {
	return ele.isDisplayed();

	}


	public boolean switchToFrame(int i) {
		getdriver().switchTo().frame(i);
		return true;
		
	}
	public void switchToalert() {
		getdriver().switchTo().alert().accept();
		
	}
	public void explicitWait(WebDriver driver, WebElement element, int timeOut ) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	
	}
	public void implicitWait(WebDriver driver, int timeOut) {
		getdriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public String getPageTitle() {
		return getdriver().getTitle();
	}
	public void screenshot(WebDriver driver, String filename ) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";
		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


}

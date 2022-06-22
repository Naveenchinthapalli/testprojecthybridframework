package com.test.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.HTMLReporter;
import com.test.util.Excelreader;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {
	
	public Properties prop;
	public static WebDriver driver;
	public static Excelreader read;
	//public static HTMLReporter htmlreport;
//	public static ExtentReports extent;
//	public static ExtentTest test;
	
	 public static ThreadLocal<WebDriver> ldriver=new ThreadLocal<WebDriver>();
@BeforeTest

	public  Properties intialize_properties(){
	//DOMConfigurator.configure("./src/test/resources/log4j.xml");
	//BasicConfigurator.configure();
	String log4jConfPath = "./resources/log4j2.xml";
	DOMConfigurator.configure(log4jConfPath);
  //  htmlreport=new HTMLReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport.html");
//extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport.html", true);
//extent.loadConfig(new File(System.getProperty("user.dir")+"\\extentconfig\\extent-config.xml"));
//		
		prop=new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//config.properties");
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		
	}
	
	public String excelread() {
		String path=System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testdata1.xlsx";
		read=new Excelreader();
		return path;
	}
	
	
	public void intialize_driver(String browsername) {
		
		//String browsername=prop.getProperty("browser");
	
		if(browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ldriver.set(new ChromeDriver());
		} else if(browsername.equals("firefox")) {
			
		}
		getdriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		getdriver().manage().window().maximize();
		getdriver().get(prop.getProperty("url"));
	}
	
	public static WebDriver getdriver() {
		return ldriver.get();
	}
	
	
	public void capturescreen(WebDriver driver,String name) throws IOException {
		String time=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+"/screenshots/"+name+time+".png");
		FileUtils.copyFile(source, dest);
		System.out.println("screenshot taken");
	}
	
	
	
	
}

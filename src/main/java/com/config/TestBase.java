package com.config;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.constants.PropertyConstant;

public class TestBase {
	
	public static Logger logger = Logger.getLogger("TestBase");
	private WebDriver driver;
	
	public WebDriver intilizeDriver() {
		logger.info("Initializing Driver");
		driver = getInstanceDriver();
		return driver;
		
	}

	private WebDriver getInstanceDriver() {
		// TODO Auto-generated method stub
		
		if(PropertyConstant.browser.equalsIgnoreCase("chrome")) 
		{
			logger.info("Initializing chrome Driver");
			System.setProperty("webdriver.chrome.driver", "/driverAgents/chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(PropertyConstant.browser.equalsIgnoreCase("firefox")) 
		{
			logger.info("Initializing Firefox Driver");
			System.setProperty("webdriver.gecko.driver", "/driverAgents/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if(PropertyConstant.browser.equalsIgnoreCase("IE")) 
		{
			System.setProperty("webdriver.ie.driver", "");
			driver = new InternetExplorerDriver();
		}
		else if(PropertyConstant.browser.equalsIgnoreCase("edge")) 
		{
			System.setProperty("webdriver.edge.driver", "");
			driver = new EdgeDriver();
		}
		else 
		{
			System.out.println("Browser not defined");		
		}
		driver.manage().timeouts().implicitlyWait(PropertyConstant.implicitTime, TimeUnit.SECONDS);
		return driver;
	}
	
	public void openUrl() {
		//driver=intilizeDriver();
		driver.get(PropertyConstant.url);
	}
}

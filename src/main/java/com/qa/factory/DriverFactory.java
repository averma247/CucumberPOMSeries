package com.qa.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver= new ThreadLocal<>();

	private enum browsers {
		IE, CHROME, FIREFOX
	};


	/**
	 * This method is to intilaize driver based on browser type
	 * @param browser
	 * @return Webdriver driver
	 */
	public WebDriver init_driverold(String browser){
		System.out.println("browser value is: "+ browser);

		if(browser.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.firefox.bin","C:\\Users\\ajayverma\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else{
			System.out.println("Please pass the correct browser value: "+browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return getDriver();
	}



	public WebDriver init_driver(String browser){
		System.out.println("browser value is: "+ browser);
		switch (browsers.valueOf(browser.toUpperCase())){
		case CHROME:
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
			break;
		case FIREFOX:
			System.setProperty("webdriver.firefox.bin","C:\\Users\\ajayverma\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
			break;
		case IE:
			break;
			
		default:
			System.out.println("Please pass the correct browser value: "+browser);
			break;
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return getDriver();
	}



	/**
	 * this is used to get the driver with Threadlocal
	 * @return
	 */
	public static synchronized WebDriver getDriver(){
		return tlDriver.get();
	}

}

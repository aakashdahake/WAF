package com.corelib;

import java.io.IOException;
import org.apache.log4j.Appender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Library1 {

	static Logger log = Logger.getLogger(Library1.class);
	
	// Logger method
	public Logger printLog(String message) {

		PatternLayout layout = new PatternLayout("[%-7p %d [%t] %c %x - %m%n]");
		Appender fileAppender = null;
		try {
			fileAppender = new FileAppender(layout, "D:/test.txt", false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		BasicConfigurator.configure(fileAppender);
		return log;
	}

	// Create WebDriver type variable for input browser type
	public WebDriver wakeBrowser(String browser) {

		WebDriver driver = null;

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"D:\\New folder\\cucumber-java-skeleton\\drivers\\chromedriver.exe");
			ChromeOptions chOption = new ChromeOptions();
			chOption.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(chOption);
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					"D:\\New folder\\cucumber-java-skeleton\\drivers\\geckodriver.exe");
			FirefoxOptions ffOption = new FirefoxOptions();
			ffOption.setAcceptInsecureCerts(true);
			driver = new FirefoxDriver(ffOption);
			driver.manage().deleteAllCookies();
			break;

		case "edge":
			System.setProperty("webdriver.edge.driver",
					"D:\\New folder\\cucumber-java-skeleton\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Unable to create Webdriver Object");
		}
		return driver;
	}

	// Close driver
	public void closeBrowser(WebDriver driver) {
		driver.close();
	}

	// Navigate to Webpage with user defined browser
	public WebDriver navigateToWebpage(String browser, String webAddress) {

		WebDriver driver;
		try {
			driver = wakeBrowser(browser);
			driver.manage().window().maximize();
			driver.get(webAddress);
		} catch (Exception e) {
			throw e;
		}
		return driver;
	}

	// Find textbox element and enter text
	public void findAndEnterText(WebDriver driver, String xpath, String text) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			driver.findElement(By.xpath(xpath)).sendKeys(text);
		} catch (Exception e) {
			throw e;
		}

	}

	// Find textbox element and enter text
	public void findAndClick(WebDriver driver, String xpath) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			driver.findElement(By.xpath(xpath)).click();
		} catch (Exception e) {
			throw e;
		}

	}

	// Create wait for element for provided time
	public void waitForElement(WebDriver driver, String xpath, int seconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		} catch (Exception err) {
			throw err;
		}
	}

}

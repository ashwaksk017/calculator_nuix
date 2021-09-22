package com.utility.Classes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





public class WebDriverUtility {

	public WebDriver initializeDriver(String browser, WebDriver driver) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ConfigProperties.ConfigClass.chromeDriverPath);
			driver = new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", ConfigProperties.ConfigClass.ieDriverPath);
			driver = new InternetExplorerDriver();
		}
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ConfigProperties.ConfigClass.firefoxDriverPath);
			driver = new FirefoxDriver();
		}
		return driver;
	}

	public void waitTillClickable(WebDriver driver, String css) {
		driver.findElement(By.cssSelector(css)).click();
		implicitDriverWait(driver);
	}
	
	

	public void waitTillElementLocated(WebDriver driver, By webElement) {
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(webElement));
	}

	@SuppressWarnings("deprecation")
	public void implicitDriverWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
}

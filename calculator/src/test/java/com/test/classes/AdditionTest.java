package com.test.classes;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Object.Factory.CalendarPage;
import com.utility.Classes.BaseClass;
import com.utility.Classes.ConfigProperties;
import com.utility.Classes.PerformAction;
import com.utility.Classes.WebDriverUtility;

public class AdditionTest extends BaseClass {
	@Parameters({ "csvFile", "start", "end" })
	public AdditionTest(String csvFile, int startRow, int endRow) {
		super(csvFile, startRow, endRow);
	}

	@Test(dataProvider = "csvData", groups = { "stage", "prod" })
	public void additionTest(Map<String, String> dataMap) {
		String env = System.getProperty("env");
		String browser=System.getProperty("browser");
		WebDriverUtility util = new WebDriverUtility();
		driver = util.initializeDriver(browser, driver);
		PerformAction act = new PerformAction(driver);
		SoftAssert softAssert = new SoftAssert();
		try {
			if (env.equals("prod")) {
				driver.get(ConfigProperties.ConfigClass.prodUrl);
			} else {
				driver.get(ConfigProperties.ConfigClass.stageUrl);
			}
			act.selectNumbersForMathOperation(driver, dataMap, softAssert);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.quit();
		softAssert.assertAll();
	}
	
	/*
	 * public static void main(String[] args) { String someInput = "123.45+56";
	 * char[] chars = someInput.toCharArray(); for(char singleChar : chars) {
	 * System.out.println(singleChar); } }
	 */
}


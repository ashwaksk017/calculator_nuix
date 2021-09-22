package com.utility.Classes;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import au.com.bytecode.opencsv.CSVReader;

public class BaseClass {
	public static WebDriver driver;
	public static WebDriverUtility utility = new WebDriverUtility();
	/*
	 * public static ExtentHtmlReporter htmlReporter = null; public static
	 * ExtentReports extent = null; public static ExtentTest logger = null;
	 */
	private String csvFile;
	private int startRow;
	private int endRow;
	private String browser;

	public BaseClass(String csvFile, int startRow, int endRow, String browser) {

		this.csvFile = csvFile;
		this.startRow = startRow;
		this.endRow = endRow;
		this.browser = browser;
	}

	public BaseClass(String csvFile, int startRow, int endRow) {
		this.csvFile = csvFile;
		this.startRow = startRow;
		this.endRow = endRow;
	}

	public String getBrowser() {
		return browser;
	}

	@DataProvider(name = "csvData")
	public Object[][] provideCSVData() {
		Object[][] testNgData = null;
		try {
			CSVReader reader = new CSVReader(
					new InputStreamReader(getClass().getResourceAsStream(csvFile), StandardCharsets.UTF_8));
			String[] headers = reader.readNext();
			String[] inputLine = null;
			List<LinkedHashMap<String, String>> maps = new LinkedList<LinkedHashMap<String, String>>();
			try {
				int counter1 = 1;
				while ((inputLine = reader.readNext()) != null) {
					if (startRow <= counter1 && endRow >= counter1) {
						LinkedHashMap<String, String> csvMap = new LinkedHashMap<String, String>();
						/* HashMap<String, String> csvMap = new HashMap<String, String>(); */
						for (int index = 0; index < inputLine.length; index++) {
							csvMap.put(headers[index], inputLine[index]);
						}
						maps.add(csvMap);
					}
					counter1++;
				}
				testNgData = new Object[maps.size()][1];
				int index = 0;
				for (Map<String, String> map : maps) {
					testNgData[index++][0] = map;
				}
			} catch (IOException ioe) {
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Returning to TestNG.....");
		return testNgData;
	}

}

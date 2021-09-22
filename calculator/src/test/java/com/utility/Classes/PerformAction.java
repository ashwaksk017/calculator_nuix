package com.utility.Classes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.Object.Factory.CalendarPage;
import com.Object.Factory.CalendarRepo;

public class PerformAction {
	WebDriver driver = null;

	public PerformAction(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	Set<Character> operandsSet = new HashSet<Character>();
	{
		operandsSet.add('0');
		operandsSet.add('1');
		operandsSet.add('2');
		operandsSet.add('3');
		operandsSet.add('4');
		operandsSet.add('5');
		operandsSet.add('6');
		operandsSet.add('7');
		operandsSet.add('8');
		operandsSet.add('9');
	}

	Map<Character, String> actionPathMap = new HashMap<Character, String>();
	{
		actionPathMap.put('.', "#panel > div.row-block > div:nth-child(4) > input.small");
		actionPathMap.put('-', "#subtract");
		actionPathMap.put('=', "#panel > div.y-row > input.double-y");
		actionPathMap.put('C', "#panel > div.x-row > input.double-x");
		actionPathMap.put('*', "#multiply");
		actionPathMap.put('/', "#divide");		
		actionPathMap.put('+', "#add");
		
	}
	public void selectNumbersForMathOperation(WebDriver driver, Map<String, String> dataMap, SoftAssert softAssert) {
		try {

			WebDriverUtility util = new WebDriverUtility();
			CalendarPage pge = new CalendarPage(driver);
			String inputData = dataMap.get("Input");
			char[] individualChars = inputData.toCharArray();
			for (char individualChar : individualChars) {
				if (operandsSet.contains(individualChar)) {
					String cssPath = pge.getCssPathNumbers().replace("##", String.valueOf(individualChar));
					util.waitTillClickable(driver, cssPath);
				} else {
					String cssPath = actionPathMap.get(individualChar);
					util.waitTillClickable(driver, cssPath);
				}
			}
			String actResult= driver.findElement(By.cssSelector("#display")).getText();
			
			softAssert.assertEquals(actResult,dataMap.get("ExpectedResult"));
			//util.waitTillClickable(driver, actionPathMap.get('C'));
			
			/*
			 * String firstNumber= dataMap.get("FirstNumber"); String
			 * secondNumber=dataMap.get("SecondNumber"); String
			 * operand=dataMap.get("Operand");
			 * 
			 * String first = firstNumber.substring(0, 1); String symbol="-"; String
			 * decimal="."; if(first.equals(symbol)) {
			 * util.waitTillClickableAndClickOnNUmbers(driver,
			 * pge.getMinusSign(),symbol+""); firstNumber=firstNumber.substring(1); }
			 * if(first.equals(decimal)) { util.waitTillClickableAndClickOnNUmbers(driver,
			 * pge.getDecimal(),decimal+""); firstNumber=firstNumber.substring(1); }
			 * if(firstNumber.contains("#")) { String[]
			 * multipleNumbers=firstNumber.split("#"); for (String str : multipleNumbers) {
			 * TimeUnit.SECONDS.SECONDS.sleep(3); if(str.equals(symbol)) {
			 * util.waitTillClickableAndClickOnNUmbers(driver,
			 * pge.getMinusSign(),symbol+""); } if(str==decimal+"") {
			 * util.waitTillClickableAndClickOnNUmbers(driver, pge.getDecimal(),decimal+"");
			 * } util.waitTillClickableAndClickOnNUmbers(driver,
			 * pge.getCssPathNumbers(),str); }
			 * 
			 * }else { util.waitTillClickableAndClickOnNUmbers(driver,
			 * pge.getCssPathNumbers(),firstNumber); }
			 */
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void cancel(WebDriver driver) {
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void divide(WebDriver driver) {
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void multiply(WebDriver driver) {
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void minus(WebDriver driver) {
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void plus(WebDriver driver) {
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void equals(WebDriver driver) {
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

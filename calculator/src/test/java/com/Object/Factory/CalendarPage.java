package com.Object.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage {
	WebDriver driver = null;
	private String cssPathNumbers = "#panel > div.row-block > div:nth-child(3) > input:nth-child(##)";
	private String minusSign = "#subtract";
	private String decimal = "#panel > div.row-block > div:nth-child(4) > input.small";
	private String equals="#panel > div.y-row > input.double-y";
	private String cancel="#panel > div.x-row > input.double-x";
	private String multiply="#multiply";
	private String divide ="#divide";
	

	public String getEquals() {
		return equals;
	}

	public String getDivide() {
		return divide;
	}

	public String getMultiply() {
		return multiply;
	}

	public String getCancel() {
		return cancel;
	}

	public String getMinusSign() {
		return minusSign;
	}

	public String getDecimal() {
		return decimal;
	}

	public String getCssPathNumbers() {
		return cssPathNumbers;
	}

	public CalendarPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = CalendarRepo.numbers)
	public WebElement numbers;

}

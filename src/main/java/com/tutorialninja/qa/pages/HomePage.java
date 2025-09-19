package com.tutorialninja.qa.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropDown;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement loginOption;
	
	
	public void clickonMyaccount() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(myAccountDropDown));
		//element.click();
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}
	
	public void selectLoginOption() {
		loginOption.click();
	}
	
	
}

package com.tutorialsnija.qa.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialninja.qa.pages.HomePage;
import com.tutorialninja.qa.pages.LoginPage;

import org.openqa.selenium.By;

// Priyanka has added some code
// given more details
public class Login extends BaseTestClass {
	
	public HomePage hm; 
	public LoginPage lg; 
	
	@Test(enabled=true)
	public void verifyLoginWithValidCredentials() throws InterruptedException {
		
		hm = new HomePage(driver);
		lg = new LoginPage(driver);
		hm.clickonMyaccount();
		hm.selectLoginOption();
		lg.enterEmail(prop.getProperty("email"));
		lg.enterpass(prop.getProperty("password"));
		lg.clickLogin();
		
//		driver.findElement(By.xpath("//span[text()='My Account']")).click();
//		driver.findElement(By.xpath("//a[text()='Login']")).click();
//		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(prop.getProperty("email"));
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("password"));
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	
	@Test(enabled=false,dataProvider="logiwithmultipledata")
	public void verifyLoginWithValidCredentialsExcelData(String email, String pass) {
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	
	@DataProvider(name="logiwithmultipledata")
	public Object[][] testdatasupply() {
		
		Object data[][] = {
				{"shindepratik1@gmail.com", "12345"},
				{"shindepratik2@gmail.com", "12345"}		
		};
		return data;
	}


}

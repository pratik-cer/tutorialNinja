package com.tutorialsnija.qa.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Register extends BaseTestClass {
	
	@Test
	public void VerifyRegisterPage() throws InterruptedException {
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Register")).click();
		boolean status = driver.findElement(By.xpath("//div[@id='content']/h1")).isDisplayed();
		Assert.assertTrue(status,"user is not on registerpage");
	}

}

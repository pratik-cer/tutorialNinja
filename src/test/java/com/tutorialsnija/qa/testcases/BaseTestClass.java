package com.tutorialsnija.qa.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestClass {

	WebDriver driver;
	Properties prop;
	
	public void loadPropertiesFile() throws IOException {
		
		prop = new Properties();
		InputStream fis = getClass().getClassLoader().getResourceAsStream("config.properties");
		if(fis == null) {
			throw new FileNotFoundException("config.properties not foundin resource folder");
		}
		//FileInputStream fis = new FileInputStream(System.getProperty("user.dir" + "/src/test/resources/config.properties"));
		prop.load(fis);
	}
	
	@BeforeMethod
	public void initilizaBrowserAndOpenApplicationURL() throws IOException {
		
		loadPropertiesFile();
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			
			driver = new ChromeDriver();
		}
		else if(browserName.equals("edge")) {
			
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	
	@AfterMethod
	public void tearnDown() {
		driver.quit();
	}
	
}

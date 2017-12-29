package com.Int.DataProviderTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultipleLogin {
	
	public WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://demo.n2hive.com/Login/Index");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.close();
		driver.quit();
		
	}
	
	@DataProvider()
	public Object[][] LoginCredentials() {
		
		Object[][] Credentials = new Object[2][2];
		
		Credentials[0][0] = "superadmin@ntooitive.com";
		Credentials[0][1] = "Ntooitive!23";	
		
		
		Credentials[1][0] = "shahnawaz.md@indusnet.co.in";
		Credentials[1][1] = "password";
		
		return Credentials;
	}
	
	@Test(dataProvider = "LoginCredentials")
	public void login(String EmailId, String Password) throws InterruptedException {
		
		driver.findElement(By.id("login-username")).clear();
		driver.findElement(By.id("login-username")).sendKeys(EmailId);
		Thread.sleep(2000);
		
		driver.findElement(By.id("login-password")).clear();
		driver.findElement(By.id("login-password")).sendKeys(Password);
		Thread.sleep(2000);
		
		driver.findElement(By.id("btn-login")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("html/body/div[1]/header/nav/div/ul/li/a/span")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("html/body/div[1]/header/nav/div/ul/li/ul/li[2]/div[2]/a")).click();
		Thread.sleep(1000);
	
	}
	
	

}

package com.groupExecutionClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Vikikaushal_Test {
	@Test(groups="Bollywood")
	public void executeScript() {
		Reporter.log("Vikikaushal", true);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com/vickykaushal09/");
		driver.quit();
		
	
}
}

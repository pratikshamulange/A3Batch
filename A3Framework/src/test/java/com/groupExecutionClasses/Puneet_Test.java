package com.groupExecutionClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Puneet_Test {
	@Test(groups="KFI")
	public void executeScript() {
		Reporter.log("Puneet", true);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com/puneethrajkumar.official/?hl=en");
		driver.quit();
}

}

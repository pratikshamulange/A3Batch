package com.groupExecutionClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AlluArjunTest {
	@Test(groups={"TFI","PanIndia"})
	public void executeScript() {
		Reporter.log("AlluArjunl", true);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com/alluarjunonline/?hl=en");
		driver.quit();

}
}

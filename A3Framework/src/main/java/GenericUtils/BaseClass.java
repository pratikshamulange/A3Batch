package GenericUtils;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import ElementRepository.BasePage;
import ElementRepository.LoginPage;

public class BaseClass implements IAutoConstant,ITestListener{



	//private static final String PropertyFilePath = null;
	 public static WebDriver driver;
	public FileLibrary flib;
	public BasePage bp;
	public LoginPage lp;
	
	@BeforeSuite
	public void beforeSuit() {
		Reporter.log("beforeSuit", true);

                }
	

        @BeforeTest
        public void beforeTest() {
     	Reporter.log("beforeTest", true);
                     }
      
	

      @Parameters("bname")
      @BeforeClass
       public void launchingBrowser(@Optional("chrome")String bname) {
	Reporter.log("beforeClass", true);
	if(bname.equalsIgnoreCase("chrome"))
	{
		driver= new ChromeDriver();
		
	}
	else if(bname.equalsIgnoreCase("firefox"))
	{
		driver=new FirefoxDriver();
		
	}
	else if(bname.equalsIgnoreCase("edge"))
	{
		driver=new EdgeDriver();
		
	}
	else {
		Reporter.log("Invalid Browser Name");
	}

     bp=new BasePage(driver);
     lp=new LoginPage(driver);
     flib = new FileLibrary();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitTimeOut));
}

     
@BeforeMethod
public void beforeMethod() {
	Reporter.log("beforeMethod", true);

	driver.get(flib.fetchDataFromProperties(propertyFilePath, "url"));
	lp.getLoginLink().click();
	lp.getEmailTextBox().sendKeys(flib.fetchDataFromProperties(screenshotpath, "email"));
	lp.getPasswordTextBox().sendKeys(flib.fetchDataFromProperties(propertyFilePath, "password"));
	lp.getLoginButton().click();
	
	
}
@AfterMethod
public void afterMethod() {
	Reporter.log("afterMethod", true);
	//lp.getLogOutlink();
}
@AfterClass
public void tearDownBrowser() {
	Reporter.log("tearDownBrowser", true);
}
@AfterTest
public void afterTest() {
	Reporter.log("afterTest", true);
}
@AfterSuite
public void aftersuit() {
	Reporter.log("afterSuits", true);
}


@Override
public void onTestStart(ITestResult result) {
	Reporter.log(("-----Testcase"+result.getName()+"is started----"));
}


@Override
public void onTestSuccess(ITestResult result) {
	Reporter.log(("-----Testcase"+result.getName()+"is passed----"));
}


@Override
public void onTestFailure(ITestResult result) {
	Reporter.log(("-----Testcase"+result.getName()+"is failed----"));
	LocalDateTime ldt = LocalDateTime.now();
	String time = ldt.toString().replace(":", "-");
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(screenshotpath+"Screenshot.png");
		try {
			FileHandler.copy(src, dest);
		} catch (Exception e) {
			
			
		}
		
	}
	

@Override
public void onTestSkipped(ITestResult result) {
	Reporter.log(("-----Testcase"+result.getName()+""));
	
}

@Override
public void onStart(ITestContext context) {
	Reporter.log(("<test>"+context.getName()+"is started----"));
	
	
}


@Override
public void onFinish(ITestContext context) {
	Reporter.log(("<test>"+context.getName()+"is Finished----"));
	
	
}


}


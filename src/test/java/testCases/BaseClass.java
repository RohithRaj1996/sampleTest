package testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.Screenshots;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	WebDriver driver;
	Screenshots sc;
	public static Properties po;
	
	public static void testBasic() throws IOException
	{
		po= new Properties();
		FileInputStream obj=new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//Properties//Config.properties");
		po.load(obj);
	}

	@BeforeMethod(alwaysRun=true)
	// @Parameters("browser")
	public void beforeMethod() throws IOException {
		testBasic();
//		if(text1.equals("Chrome"))
//		{
		System.setProperty(po.getProperty("PROPERTYNAME"),System.getProperty("user.dir") +po.getProperty("PATHDRIVER"));
		driver = new ChromeDriver();
//		}
//		else
//		{
//			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"//src//main//resources//Driver files//msedgedriver.exe");
//			   driver=new EdgeDriver();
//		}
		driver.get(po.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod(alwaysRun=true)
	public void afterMethod(ITestResult itestResult) throws IOException {

		if (itestResult.getStatus() == ITestResult.FAILURE) {
			sc = new Screenshots();
			sc.captureScreenshot(driver, itestResult.getName());

		}

		//driver.close();
	}

}

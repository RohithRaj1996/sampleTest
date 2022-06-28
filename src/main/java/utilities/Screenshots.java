package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshots {

	public void captureScreenshot(WebDriver driver, String methodName) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());

		File f1 = new File(System.getProperty("user.dir") + "//Outputscreenshot");
		if (!f1.exists()) {
			f1.mkdirs();
		}

		File finalDestination = new File(
				System.getProperty("user.dir") + "//Outputscreenshot//" + methodName + timeStamp + ".png");
		FileHandler.copy(screenShot, finalDestination);

	}

}

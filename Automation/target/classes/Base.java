package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public WebDriver driver;
	public Properties prop;

	public WebDriver initialiseDriver() throws IOException {
		// create properties object and get project path(homedirectory)
		prop = new Properties();
		String filePath = System.getProperty("user.dir");
		String sourcefilePath = filePath + "\\src\\main\\java\\Resources\\";
		FileInputStream file = new FileInputStream(sourcefilePath + "data.properties");
		prop.load(file);
		
		//fetch browser from properties file 
		String browsername = prop.getProperty("browser");
		//on the basis of browser name fetched one among the below 3 If block will be executed
		if (browsername.equals("Chrome")) {

			System.setProperty("webdriver.chrome.driver", sourcefilePath + "chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browsername.equals("Firefox")) {

			System.setProperty("webdriver.gecko.driver", sourcefilePath + "Firefox.exe");

		} else if (browsername.equals("IE")) {

			System.setProperty("webdriver.ie.driver", sourcefilePath + "IE.exe");

		}
		//return driver object 
		return driver;

	}

}

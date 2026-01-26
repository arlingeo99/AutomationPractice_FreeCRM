package base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.TestUtils;
import utils.WebEventListener;

public class BaseTest {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static WebDriverListener listener;
	
	public BaseTest()  {
		if (driver == null) {

			FileReader fr = null;
			try {
				fr = new FileReader(
						System.getProperty("user.dir") + "\\src\\main\\java\\config\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				prop.load(fr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void initialization() {
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		listener = new WebEventListener();
		driver = new EventFiringDecorator<>(listener).decorate(driver);
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtils.pageLoadTimeout));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.implicitWait));
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

	public void tearDown() {
		
	    driver.quit();
		System.out.println("Teardown successful");
	}

}

package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static Properties propert = new Properties();
	public static Properties locaters = new Properties();
	public static FileReader fr;
	public static FileReader fr_locaters;

	@BeforeTest
	public void setUp() throws IOException {

		if (driver == null) {
			System.out.println("The path is:" + System.getProperty("user.dir"));
			FileReader fr = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
			FileReader fr_locaters = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\locaters.properties");

			propert.load(fr);
			locaters.load(fr_locaters);

		}

		if (propert.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
//			driver.get(propert.getProperty("testurl"));

		} else if (propert.getProperty("browser").equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
//			driver.get(propert.getProperty("testurl"));

		} else if (propert.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

			driver.manage().window().maximize();
			driver.get(propert.getProperty("testurl"));

		}

	}

	@AfterTest
	public void tearDown() {

		driver.close();
		System.out.println("successfully close the browser");

	}

}

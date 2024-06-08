package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static Properties propert = new Properties();
    public static Properties locaters = new Properties();
    private static FileReader fr;
    private static FileReader fr_locaters;

    @BeforeMethod
    public void setUp() throws IOException {
        if (driver.get() == null) {
            System.out.println("The path is: " + System.getProperty("user.dir"));
            fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
            fr_locaters = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\locaters.properties");

            propert.load(fr);
            locaters.load(fr_locaters);

            // Close FileReader streams
            fr.close();
            fr_locaters.close();

            String browser = propert.getProperty("browser").toLowerCase();
            switch (browser) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver());
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver.set(new EdgeDriver());
                    break;
                default:
                    throw new IllegalArgumentException("Browser \"" + browser + "\" is not supported.");
            }

            // Maximize browser window and load the URL
            driver.get().manage().window().maximize();

            String testUrl = propert.getProperty("testurl");
            if (testUrl != null && !testUrl.trim().isEmpty()) {
                driver.get().get(testUrl);
            } else {
                throw new IllegalArgumentException("The test URL is not specified or is empty.");
            }
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    @AfterMethod
    public void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
        System.out.println("Successfully closed the browser");
    }
}

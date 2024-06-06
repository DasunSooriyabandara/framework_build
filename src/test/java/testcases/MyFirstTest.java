package testcases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MyFirstTest extends BaseTest {

	@Test
    public static void LoginTest() {
        

        try {
            
            // Print the title of the page
            System.out.println("Title of the page is: " + driver.getTitle());

            // Click on the "Sign in" link
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement signInLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(propert.getProperty("signin_link"))));
            signInLink.click();

            // Enter login credentials and click next
            WebElement loginIdField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(propert.getProperty("email_field"))));
            loginIdField.sendKeys("dasunsooriyabandara@gmail.com");

            WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(propert.getProperty("next_button"))));
            nextButton.click();

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(propert.getProperty("pwd_field"))));
            passwordField.sendKeys("Test@2024");

            WebElement nextButtonAfterPassword = wait.until(ExpectedConditions.elementToBeClickable(By.id(propert.getProperty("login_next_button"))));
            nextButtonAfterPassword.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }

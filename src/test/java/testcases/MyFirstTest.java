package testcases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;

public class MyFirstTest extends BaseTest {

    @Test(dataProvider = "LoginDataProvider")
    public void LoginTest(String username, String password) {
        try {
            System.out.println("Title of the page is: " + getDriver().getTitle());

            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement signInLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locaters.getProperty("signin_link"))));
            System.out.println("Sign in link found");
            signInLink.click();
            System.out.println("Clicked on Sign in link");

            WebElement loginIdField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locaters.getProperty("email_field"))));
            System.out.println("Email field found");
            loginIdField.sendKeys(username);
            System.out.println("Entered username: " + username);

            WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(locaters.getProperty("next_button"))));
            System.out.println("Next button found");
            nextButton.click();
            System.out.println("Clicked on Next button");

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locaters.getProperty("pwd_field"))));
            System.out.println("Password field found");
            passwordField.sendKeys(password);
            System.out.println("Entered password:"+ password);

            WebElement nextButtonAfterPassword = wait.until(ExpectedConditions.elementToBeClickable(By.id(locaters.getProperty("login_next_button"))));
            System.out.println("Next button after password found");
            nextButtonAfterPassword.click();
            System.out.println("Clicked on Next button after password");

           

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception occurred: " + e.getMessage());
            Assert.fail("Test encountered an exception.");
        }
    }

    @DataProvider(name = "LoginDataProvider")
    public Object[][] LoginData() {
        return new Object[][] {
        	
        	{ "dasunsooriyabandara@gmail.com", "Test@2024" },
            { "dfsdfsdf@gmail.com", "fafafafafas" },
            { "dfafsfasfaffs@gmail.com", "fafafafafas" },
            { "dasunsooriyabandara@gmail.com", "fafafafafas" },
            
        };
    }
}

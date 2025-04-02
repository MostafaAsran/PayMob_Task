package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateAccountPage {
    WebDriver driver;

    // Locators
    By firstNameField = By.id("firstname");
    By lastNameField = By.id("lastname");
    By emailField = By.id("email_address");
    By passwordField = By.id("password");
    By confirmPasswordField = By.id("password-confirmation");
    By submitButton = By.xpath("//button[@title='Create an Account']");
    By createAccountLink = By.linkText("Create an Account");

    // Methods
    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToCreateAccountPage() {
        driver.findElement(createAccountLink).click();
    }


    public void createAccount(String firstName, String lastName, String email, String password) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(password);
        driver.findElement(submitButton).click();
    }
    public static String generateUniqueEmail() {
        // Get the current date and time in the format "yyyyMMddHHmmss"
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        // Create a unique email by appending the timestamp to a base email address
        return "mostafa.asran" + timestamp + "@gmail.com";
    }
}

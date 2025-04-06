package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;

import javax.swing.plaf.PanelUI;
import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    By firstProduct = By.xpath("//ol/li[4]"); // Adjust based on product
    By secondProduct = By.xpath("//ol/li[3]");
    By addToCompareButtonLocatorFirst = By.xpath("//ol/li[4]/div/div/div[3]/div/div[2]/a[2]");
    By addToCompareButtonLocatorSecond = By.xpath("//ol/li[3]/div/div/div[3]/div/div[2]/a[2]");
    By successMessageLocator = By.xpath("//div[contains(text(),'You added product Argus All-Weather Tank to the ')]");

 //Methods
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }


    public void hoverAndAddFirstProductToCompare() {
        // Wait to be visible and clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productItem = wait.until(ExpectedConditions.elementToBeClickable(firstProduct));

        // Create hover
        Actions action = new Actions(driver);
        action.moveToElement(productItem).perform(); // Hover over the product

        WebElement addToCompareButton = wait.until(ExpectedConditions.elementToBeClickable(addToCompareButtonLocatorFirst));

        // Click the "Add to Compare" button
        addToCompareButton.click();
    }

    public void hoverAndAddSecondProductToCompare() {
        // Wait for the product item to be visible and clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productItem = wait.until(ExpectedConditions.elementToBeClickable(secondProduct));

        // Create an Actions object to simulate mouse hover
        Actions action = new Actions(driver);
        action.moveToElement(productItem).perform(); // Hover over the product

        // Wait for the "Add to Compare" button to appear (since it's hidden until hover)
        WebElement addToCompareButton = wait.until(ExpectedConditions.elementToBeClickable(addToCompareButtonLocatorSecond));

        // Click the "Add to Compare" button
        addToCompareButton.click();
    }
    /*public void getSuccessMessage(String expectedMessagePart) {
        // Locator for the success message
        By successMessageLocator = By.xpath("//div[contains(text(),'" + expectedMessagePart + "')]");

        // Wait for the success message to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageLocator));

        // Get the actual message text
        String actualMessage = successMessage.getText();
    }*/


    }
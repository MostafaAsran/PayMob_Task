package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;
import java.util.logging.Logger;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final JavascriptExecutor jsExecutor;

    // Logger to log important actions and errors
    private static final Logger logger = Logger.getLogger(HomePage.class.getName());

    // Locators
    private final By hotSellersLink = By.xpath("//h2[contains(text(),'Hot Sellers')]");
    private final By homePageLink = By.xpath("//a[@class='logo']");

    // Constructor to initialize WebDriver, WebDriverWait, and JavascriptExecutor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Default wait time
        this.jsExecutor = (JavascriptExecutor) driver;
    }

    // Method to navigate to the homepage
    public void navigateToHomePageLink() {
        try {
            WebElement homeLink = waitUntilElementVisible(homePageLink);
            homeLink.click();
            logger.info("Navigated to the homepage.");
        } catch (Exception e) {
            logger.severe("Error while navigating to homepage: " + e.getMessage());
        }
    }

    // Generic method for waiting until an element is visible
    private WebElement waitUntilElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Method to navigate to the Hot Sellers section and scroll to it
    public void navigateToHotSellers() {
        try {
            // Wait until the document is fully loaded
            waitUntilPageIsLoaded();

            // Wait until the Hot Sellers section is visible
            WebElement hotSellersElement = waitUntilElementVisible(hotSellersLink);

            // Scroll to the "Hot Sellers" section using JavaScript
            scrollToElement(hotSellersElement);
            logger.info("Navigated to Hot Sellers section and scrolled into view.");
        } catch (Exception e) {
            logger.severe("Error while navigating to Hot Sellers: " + e.getMessage());
        }
    }

    // Wait until the document is fully loaded (readyState = complete)
    private void waitUntilPageIsLoaded() {
        wait.until(driver -> Objects.equals(((JavascriptExecutor) driver).executeScript("return document.readyState"), "complete"));
        logger.info("Page is fully loaded.");
    }

    // Scroll to an element using JavaScript
    private void scrollToElement(WebElement element) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Additional method to verify if the Hot Sellers section is present
    public boolean isHotSellersVisible() {
        try {
            WebElement hotSellersElement = waitUntilElementVisible(hotSellersLink);
            return hotSellersElement.isDisplayed();
        } catch (Exception e) {
            logger.warning("Hot Sellers section is not visible: " + e.getMessage());
            return false;
        }
    }

    // Method to log the current URL for debugging
    public String getCurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        logger.info("Current URL: " + currentUrl);
        return currentUrl;
    }

    // Method to wait until the element is clickable and then click it
    public void waitAndClick(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            logger.info("Clicked on element: " + locator);
        } catch (Exception e) {
            logger.severe("Error while clicking element: " + locator + " - " + e.getMessage());
        }
    }

    // Example method to demonstrate adding products to the compare list (dummy method)
    public void addProductToCompareList(int productIndex) {
        try {
            // Use the product index or another unique way to locate the product
            By productSelector = By.xpath("(//button[contains(@class, 'action towishlist')])[" + productIndex + "]");
            waitAndClick(productSelector);
            logger.info("Product " + productIndex + " added to compare list.");
        } catch (Exception e) {
            logger.severe("Error while adding product to compare list: " + e.getMessage());
        }
    }
}

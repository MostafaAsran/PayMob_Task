package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import Pages.*;

public class MagentoTest {
    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;
    ProductPage productPage;
    CreateAccountPage createAccountPage;
    @BeforeMethod
    public void setup() {
        // Set up WebDriver (Chrome in this case)
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void testCreateAccountAndAddToCompare() throws InterruptedException {
        // Create an instance of Page classes
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);

        // 1. Create an account
        String uniqueEmail=CreateAccountPage.generateUniqueEmail();
        createAccountPage.navigateToCreateAccountPage();
        createAccountPage.createAccount("mostafa", "Asran", uniqueEmail, "Password123");
        homePage.navigateToHomePageLink();
        // 2. Navigate to Hot Sellers and add 2 products to the compare list
        homePage.navigateToHotSellers();
        productPage.hoverAndAddFirstProductToCompare(); // Add 1st product
        homePage.navigateToHotSellers();

        productPage.hoverAndAddSecondProductToCompare(); // Add 2nd product

    }

  /*  @AfterMethod
    public void tearDown() {
        // Close the browser after test
        driver.quit();
    }
*/
}

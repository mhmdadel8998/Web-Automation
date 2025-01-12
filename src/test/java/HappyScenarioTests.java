import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class HappyScenarioTests {
    protected WebDriver driver;

    SoftAssert softAssert;
    HomePage homePage;
    SignUpPage signUpPage;
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;
    PlaceOrderPage placeOrderPage;


    String username = "user" + new Random().nextInt(1000000);
    String password = "1234";


    @BeforeClass
    public void setUp() {
        // Set up the WebDriver
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
        homePage = new HomePage(driver);
        signUpPage = new SignUpPage(driver);
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        placeOrderPage = new PlaceOrderPage(driver);
    }
    @BeforeMethod
    public void assertionsSetup(){
        softAssert = new SoftAssert();
    }

    @Test(priority = 1)
    public void validateSuccessSignUp() throws InterruptedException {
        homePage.clickOnSignUp();
        signUpPage.enterUsername(username);
        signUpPage.enterPassword(password);
        signUpPage.clickOnSignUpBtnInForm();
        softAssert.assertEquals(signUpPage.getAlertText(),"Sign up successful.","Signup is not successful");
        // Accept the alert
        signUpPage.acceptAlert();
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void validateSuccessLogin() throws InterruptedException {
        homePage.clickOnLogin();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginBtnInForm();
        Thread.sleep(2000);
        softAssert.assertTrue(homePage.isLoginSuccessful(), "The login is not successful");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void validateProductOneAddedSuccessfully() throws InterruptedException {
        homePage.clickOnLaptops();
        Thread.sleep(1000);
        homePage.selectProduct("Sony vaio i5");
        productPage.clickOnAddToCartBtn();
        softAssert.assertEquals(productPage.getAlertText(),"Product added.");
        productPage.acceptAlert();
        homePage.clickOnHomeBtn();
        Thread.sleep(1000);
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void validateSecondProductAddedSuccessfully() throws InterruptedException {
        homePage.clickOnLaptops();
        Thread.sleep(1000);
        homePage.selectProduct("Sony vaio i7");
        productPage.clickOnAddToCartBtn();
        softAssert.assertEquals(productPage.getAlertText(),"Product added.");
        productPage.acceptAlert();
        softAssert.assertAll();
    }



    @Test(priority = 5)
    public void validateTheTwoProductsAddedSuccessfully() throws InterruptedException {
        homePage.clickOnCartBtn();
        Thread.sleep(3000);
        softAssert.assertEquals(cartPage.checkForCartItemsAdded(),2,"Cart should contain 2 items");
        softAssert.assertTrue(cartPage.checkForProductPresenceInCartAndItsPrice("Sony vaio i5","790"),"Either Product Name Or Price is not found in cart");
        softAssert.assertTrue(cartPage.checkForProductPresenceInCartAndItsPrice("Sony vaio i7","790"),"Either Product Name Or Price is not found in cart");
        softAssert.assertEquals(cartPage.getTotalAmount(), cartPage.getTotalProductsAmount(),"The total sum of the products doesn't match the final total amount");
        softAssert.assertAll();

    }

    @Test(priority = 6)
    public void validateSuccessfulPurchase() throws InterruptedException {
        cartPage.clickOnPlaceOrder();
        placeOrderPage.enterName("Tester XYZ");
        placeOrderPage.enterCountry("Spain");
        placeOrderPage.enterCity("Barcelona");
        placeOrderPage.enterCreditCard("123456");
        placeOrderPage.enterMonth("October");
        placeOrderPage.enterYear("1996");
        placeOrderPage.clickOnPurchaseButton();
        softAssert.assertEquals(placeOrderPage.getSuccessMessage(),"Thank you for your purchase!","The purchase is not successful");
        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }

}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{


    public HomePage(WebDriver driver) {
        super(driver);
    }

    String signUpBtn = "a[id='signin2']";
    WebElement signUp;

    String loginBtn = "a[id='login2']";
    WebElement login;

    String welcomeUserBtn = "a[id='nameofuser']";

    String laptopsBtn = "//a[3]";
    WebElement laptops;

    String homeBtn =  "//li[@class='nav-item active']//a[@class='nav-link']";
    WebElement home;

    String cartBtn = "//a[@id='cartur']";
    WebElement cart;


    public void clickOnSignUp(){
        signUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(signUpBtn)));
        signUp.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='signInModal']//div[@class='modal-content']")));
    }

    public void clickOnLogin(){
        login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(loginBtn)));
        login.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='logInModal']//div[@class='modal-content']")));
    }

    // Function to check that the login is successful
    public boolean isLoginSuccessful(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(welcomeUserBtn))).getText().contains("Welcome");
    }

    // Clicking on laptops button from categories sidebar
    public void clickOnLaptops(){
        laptops = driver.findElement(By.xpath(laptopsBtn));
        laptops.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Sony vaio i5']")));
    }

    //Select a product
    public void selectProduct(String prodName){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='"+ prodName +"']"))).click();
    }

    // Clicking on Home button in the nav bar
    public void clickOnHomeBtn(){
        home = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(homeBtn)));
        home.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(laptopsBtn)));

    }

    // Clicking on Cart button in the nav bar
    public void clickOnCartBtn(){
        cart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(cartBtn)));
        cart.click();
    }

}

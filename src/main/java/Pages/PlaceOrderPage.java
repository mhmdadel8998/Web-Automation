package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlaceOrderPage extends BasePage{
    public PlaceOrderPage(WebDriver driver) {
        super(driver);
    }

    String name = "//input[@id='name']";
    WebElement formName;

    String country ="//input[@id='country']";
    WebElement formCountry;


    String city = "//input[@id='city']";
    WebElement formCity;

    String creditCard = "//input[@id='card']";
    WebElement formCreditCard;

    String month = "//input[@id='month']";
    WebElement formMonth;

    String year = "//input[@id='year']";
    WebElement formYear;

    String purchaseBtn = "//button[normalize-space()='Purchase']";
    WebElement purchase;

    String successMessage = "//h2[normalize-space()='Thank you for your purchase!']";
    WebElement successMsg;

    public void enterName(String fName){
        formName = driver.findElement(By.xpath(name));
        formName.sendKeys(fName);
    }

    public void enterCountry(String fCountry){
        formCountry = driver.findElement(By.xpath(country));
        formCountry.sendKeys(fCountry);
    }

    public void enterCity(String fCity){
        formCity = driver.findElement(By.xpath(city));
        formCity.sendKeys(fCity);
    }

    public void enterCreditCard(String fCreditCard){
        formCreditCard = driver.findElement(By.xpath(creditCard));
        formCreditCard.sendKeys(fCreditCard);
    }

    public void enterMonth(String fMonth){
        formMonth = driver.findElement(By.xpath(month));
        formMonth.sendKeys(fMonth);
    }

    public void enterYear(String fYear){
        formYear = driver.findElement(By.xpath(year));
        formYear.sendKeys(fYear);
    }

    public void clickOnPurchaseButton(){
        //purchase = driver.findElement(By.xpath(purchaseBtn));
        //purchase.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        purchase = wait.until(driver -> driver.findElement(By.xpath(purchaseBtn)));
        purchase.click();
    }

    public String getSuccessMessage(){
        successMsg = driver.findElement(By.xpath(successMessage));
        return successMsg.getText();
    }
}

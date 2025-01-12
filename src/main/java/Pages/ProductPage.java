package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }



    String addToCartBtn = "//a[normalize-space()='Add to cart']";
    WebElement addToCart;



    // Click on Add to Cart button
    public void clickOnAddToCartBtn(){
        addToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(addToCartBtn)));
        addToCart.click();
    }




}

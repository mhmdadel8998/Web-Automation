package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }


    String cartItemsLocator = "//tr[@class='success']";
    List<WebElement> cartItems;

    String totalAmountPrice = "//h3[@id='totalp']";
    WebElement totalAmount;

    String placeOrderBtn = "//button[normalize-space()='Place Order']";
    WebElement placeOrder;


    // Function that gets the number of items added to the cart
    public int checkForCartItemsAdded(){
        cartItems = driver.findElements(By.xpath(cartItemsLocator));
        return cartItems.size();
    }


    // Function that checks if the product exists in cart. Then returns if the actual price is equal to the expected (only if the product is found)
    public boolean checkForProductPresenceInCartAndItsPrice(String prodName, String expectedPrice){
        try {
            driver.findElement(By.xpath("//tbody//td[normalize-space()='"+prodName+"']"));
        } catch (NoSuchElementException e) {
            System.out.println("Product '" + prodName + "' is not found in cart");
            return false;
        }
        String actualPrice = driver.findElement(By.xpath("//tbody//td[normalize-space()='"+prodName+"']//following-sibling::td[1]")).getText();
        return actualPrice.equals(expectedPrice);
    }

    // A function that returns the sum of price of all products in cart
    public int getTotalProductsAmount(){
        List<WebElement> priceElements = driver.findElements(By.xpath("//tbody//td[3]"));
        int sum = 0;
        for (WebElement x : priceElements){
            sum+= Integer.parseInt(x.getText());
        }
        return sum;
    }



    // A function that gets the total amount as integer
    public int getTotalAmount() {
        totalAmount = driver.findElement(By.xpath(totalAmountPrice));
        String totAmount = totalAmount.getText();
        return Integer.parseInt(totAmount);
    }

    // Click on place order button
    public void clickOnPlaceOrder(){
        placeOrder = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(placeOrderBtn)));
        placeOrder.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
    }


}

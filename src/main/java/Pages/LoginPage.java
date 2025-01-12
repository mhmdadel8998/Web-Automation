package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    String loginUsernameTextField = "input[id='loginusername']";
    WebElement loginUsername;

    String loginPasswordTextField = "input[id='loginpassword']";
    WebElement loginPassword;

    String loginFormBtn = "button[onclick='logIn()']";
    WebElement loginForm;


    // Function that allows the user to enter text in the username field
    public void enterUsername(String enteruserName){
        loginUsername = driver.findElement(By.cssSelector(loginUsernameTextField));
        loginUsername.sendKeys(enteruserName);
    }

    // Function that allows the user to enter text in the password field
    public void enterPassword(String enterPassword){
        loginPassword = driver.findElement(By.cssSelector(loginPasswordTextField));
        loginPassword.sendKeys(enterPassword);
    }

    //Function that clicks on sign-up button
    public void clickOnLoginBtnInForm(){
        loginForm = driver.findElement(By.cssSelector(loginFormBtn));
        loginForm.click();
    }

}

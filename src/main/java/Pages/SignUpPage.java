package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage extends BasePage{
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    String signUpUsernameTextField = "input[id='sign-username']";
    WebElement signUpUsername;

    String signUpPasswordTextField = "input[id='sign-password']";
    WebElement signUpPassword;

    String signUpFormBtn = "button[onclick='register()']";
    WebElement signUpForm;


    // Function that allows the user to enter text in the username field
    public void enterUsername(String enteruserName){
        signUpUsername = driver.findElement(By.cssSelector(signUpUsernameTextField));
        signUpUsername.sendKeys(enteruserName);
    }

    // Function that allows the user to enter text in the password field
    public void enterPassword(String enterPassword){
        signUpPassword = driver.findElement(By.cssSelector(signUpPasswordTextField));
        signUpPassword.sendKeys(enterPassword);
    }

    //Function that clicks on sign-up button
    public void clickOnSignUpBtnInForm(){
        signUpForm = driver.findElement(By.cssSelector(signUpFormBtn));
        signUpForm.click();
    }

}

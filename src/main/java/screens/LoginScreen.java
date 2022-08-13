package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.User;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginScreen extends BaseScreen {
    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/log_email_input']")
    MobileElement emailEditText;

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/log_password_input']")
    MobileElement passwordEditText;

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/login_btn']")
    MobileElement loginButton;

    @FindBy(xpath = "//*[@resource-id='android:id/message']")
    MobileElement errorMessage;
    @FindBy (xpath = "//*[@resource-id='android:id/button1']")
    MobileElement okBtn;

    public LoginScreen fillEmail(String email) {
        should(emailEditText, 10);
        type(emailEditText, email);
        // return new LoginScreen(driver);
        return this;
    }


    public LoginScreen fillPassword(String password) {
        type(passwordEditText, password);
        return this;
    }

    public HomeScreeen submitLogin() {
        driver.hideKeyboard();
        loginButton.click();
        return new HomeScreeen(driver);
    }

    public WizzardScreen submitRegistration() {
        driver.hideKeyboard();
        loginButton.click();
        return new WizzardScreen(driver);
    }

    public HomeScreeen complexLogin(User user) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(emailEditText));
        type(emailEditText, user.getEmail());
        type(passwordEditText, user.getPassword());
        driver.hideKeyboard();
        loginButton.click();
        return new HomeScreeen(driver);
    }

    public LoginScreen complexLoginNegative(User user) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(emailEditText));
        type(emailEditText, user.getEmail());
        type(passwordEditText, user.getPassword());
        driver.hideKeyboard();
        loginButton.click();
        return this;
    }

    public LoginScreen checkErrorMessage(String error) {
        shouldHave(errorMessage, error, 10);
        Assert.assertEquals(errorMessage.getText(), error);
        return this;
    }
    public LoginScreen confirmError(){
        okBtn.click();
        return this;
    }

}

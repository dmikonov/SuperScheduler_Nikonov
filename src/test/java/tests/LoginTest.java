package tests;

import manager.Configuration;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.HomeScreeen;
import screens.LoginScreen;
import screens.SplashScreen;

public class LoginTest extends Configuration {
    @Test
    public void loginTestSuccess() {
        //  boolean addPresent = new SplashScreen(driver)
        //       .checkCurrentVersion("0.0.3")
        boolean addPresent = new LoginScreen(driver)
                .fillEmail("d020797@gmail.com")
                .fillPassword("Ww12345$")
                .submitLogin()
                .isFabAddPresent();
        Assert.assertTrue(addPresent);
    }

    @Test
    public void loginTestSuccess2() {
        boolean addPresent = new LoginScreen(driver)
                .fillEmail("d020797@gmail.com")
                .fillPassword("Ww12345$")
                .submitLogin()
                .isFabAddPresent();
        Assert.assertTrue(addPresent);
    }

    @Test
    public void loginSuccessModel() {
        User user = User.builder()
                .email("d020797@gmail.com")
                .password("Ww12345$")
                .build();
        logger.info("Test start with user ---> "+user.toString());
        boolean addPresent = new LoginScreen(driver)
                .complexLogin(user)
                .isFabAddPresent();
        Assert.assertTrue(addPresent);
    }

    @Test
    public void loginNegativeModelWrongPassword() {
        User user = User.builder()
                .email("d020797@gmail.com")
                .password("Ww12346$")
                .build();
        new LoginScreen(driver)
                .complexLoginNegative(user)
                .checkErrorMessage("Wrong email or password")
                .confirmError();
    }

    @AfterMethod
    public void postCondtidion() {
        new HomeScreeen(driver)
                .openMenu()
                .logout();
    }
}

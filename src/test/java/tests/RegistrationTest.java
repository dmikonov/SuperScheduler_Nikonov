package tests;

import manager.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.LoginScreen;

public class RegistrationTest extends Configuration {
    @Test
    public void registrationSuccess() {
        int i = (int) System.currentTimeMillis() / 1000 % 3600;
        new LoginScreen(driver)
                .fillEmail("diiiiima" + i + "@mail.com")
                .fillPassword("Dima12345$")
                .submitRegistration()
                .skipWizzard()
                .checkFabButtonPresentAssert()
                .openMenu()
                .logout();
    }
}

package tests;

import manager.Configuration;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.HomeScreeen;
import screens.LoginScreen;

public class DeleteEventTest extends Configuration {
    @BeforeClass
    public void preCondition() {
        new LoginScreen(driver)
                .complexLogin(User.builder().email("d020797@gmail.com").password("Ww12345$").build());
    }

    @Test
    public void deleteOneEvent() {
        Boolean res = new HomeScreeen(driver)
                .deleteEvent();
        Assert.assertTrue(res);
    }

    @AfterClass
    public void postCondition() {
        new HomeScreeen(driver)
                .openMenu()
                .logout();
    }
}

package tests;

import manager.Configuration;
import models.Event;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.HomeScreeen;
import screens.LoginScreen;

public class EventCreateTest extends Configuration {
    @BeforeClass
    public void preCondition() {
        new LoginScreen(driver)
                .complexLogin(User.builder().email("d020797@gmail.com").password("Ww12345$").build());
    }

    @Test
    public void createNewEventSuccess() {
        Event event = Event.builder()
                .title("New title")
                .type("My type")
                .breaks(3)
                .wage(60)
                .build();
        boolean isFabPresent = new HomeScreeen(driver)
                .initCreationEvent()
                .createNewEvent(event)
                .isFabAddPresent();
                Assert.assertTrue(isFabPresent);
    }

    @AfterClass
    public void postCondition() {
        new HomeScreeen(driver)
                .openMenu()
                .logout();
    }
}

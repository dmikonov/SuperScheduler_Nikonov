package tests;

import manager.Configuration;
import models.Event;
import models.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.EditCreateEventScreen;
import screens.HomeScreeen;
import screens.LoginScreen;

public class EventCreateTest2 extends Configuration {

    @Test
    public void createNewEvent() {
        new LoginScreen(driver)
                .complexLogin(User.builder().email("d020797@gmail.com").password("Ww12345$").build());
        Event event = Event.builder()
                .title("New title")
                .type("My type")
                .breaks(3)
                .wage(60)
                .build();
        new HomeScreeen(driver)
                .initCreationEvent()
                .createNewEvent(event)
                .checkFabButtonPresentAssert()
                .openMenu()
                .logout();
    }
}

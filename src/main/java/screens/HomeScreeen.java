package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class HomeScreeen extends BaseScreen {
    public HomeScreeen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/fab_main']")
    MobileElement fabAdd;
    @FindBy(xpath = "//*[@content-desc='Open']")
    MobileElement burgerMenu;
    @FindBy(xpath = "//*[@content-desc='Open']")
    List<MobileElement> list;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/nav_fr_logout']")
    MobileElement logoutButton;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/fab_add_event']")
    MobileElement fabAddEvent;

    public EditCreateEventScreen initCreationEvent(){
        should(fabAdd,10);
        fabAdd.click();
        fabAddEvent.click();
        return new EditCreateEventScreen(driver);
    }
    public boolean isFabAddPresent() {
        should(fabAdd, 10);
        return fabAdd.isDisplayed();
    }

    public HomeScreeen openMenu() {
        if (isDisplayedWithExp(burgerMenu)) {
            burgerMenu.click();
        }
        return this;
    }

    public HomeScreeen openMenu2() {
        if (list.size() > 0) {
            list.get(0).click();
        }
        return this;
    }

    public LoginScreen logout() {
        if (isDisplayedWithExp(logoutButton)) {
            logoutButton.click();
        }
        return new LoginScreen(driver);
    }

    public HomeScreeen checkFabButtonPresentAssert() {
        should(fabAdd, 10);
        Assert.assertTrue(fabAdd.isDisplayed());
        return this;
    }


}

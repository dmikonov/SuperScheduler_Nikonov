package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomeScreeen extends BaseScreen{
    public HomeScreeen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/fab_main']")
    MobileElement fabAdd;
    @FindBy(xpath = "//*[@content-desc='Open']")
    MobileElement burgerMenu;
    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/nav_fr_logout']")
    MobileElement logoutButton;

    public boolean isFabAddPresent(){
        should(fabAdd,10);
        return fabAdd.isDisplayed();
    }

    public HomeScreeen openMenu(){
        burgerMenu.click();
        return this;
    }

    public LoginScreen logout(){
        logoutButton.click();
        return new LoginScreen(driver);
    }

    public HomeScreeen checkFabButtonPresentAssert(){
        should(fabAdd,10);
        Assert.assertTrue(fabAdd.isDisplayed());
        return this;
    }


}

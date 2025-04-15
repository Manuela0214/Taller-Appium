package hook;

import io.appium.java_client.AppiumDriver;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static constants.Constants.*;

@AllArgsConstructor
public class OpenMobileApp implements Task {

    @Getter
    private static AppiumDriver driver;
    private String url;

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("appium:automationName", AUTOMATION_NAME);
            capabilities.setCapability("appium:platformName", PLATFORM_NAME);
            capabilities.setCapability("appium:deviceName", DEVICE_NAME);
            capabilities.setCapability("appium:udid", UDID);
            capabilities.setCapability("appium:platformVersion", PLATFORM_VERSION);
            capabilities.setCapability("appium:appPackage", "com.google.android.contacts");
            capabilities.setCapability("appium:appActivity", "com.android.contacts.activities.PeopleActivity");

            driver = new AppiumDriver(new URL(url),capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }catch (Exception e){
            throw new RuntimeException("Failed to start the mobile app", e);
        }
    }

    public static OpenMobileApp openMobileApp(String url) {
        return Tasks.instrumented(OpenMobileApp.class, url);
    }

}
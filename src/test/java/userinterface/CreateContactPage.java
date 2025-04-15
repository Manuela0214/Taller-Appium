package userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class CreateContactPage extends PageObject {

    public static final Target FIRST_NAME_INPUT = Target.the("Input for new value name")
            .locatedBy("//android.widget.EditText[@text='First name']");
    public static final Target LAST_NAME_INPUT = Target.the("Input for new value last name")
            .locatedBy("//android.widget.EditText[@text='Last name']");
    public static final Target PHONE_INPUT = Target.the("Input for new value phone number")
            .locatedBy("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[4]/android.widget.EditText[1]");
    public static final Target SAVE_CONTACT_BUTTON = Target.the("Button to save new contact")
            .locatedBy("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button");
    public static final Target BACK_BUTTON = Target.the("Button to return to the contact list")
            .locatedBy("//android.widget.ImageButton[@content-desc='Navigate up']");
}

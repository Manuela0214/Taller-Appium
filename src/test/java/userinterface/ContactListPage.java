package userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ContactListPage extends PageObject {

    public static final Target HOME_CONTACT_APP = Target.the("Home page of Contacts app")
            .locatedBy("//android.widget.TextView[@text='All contacts']");
    public static final Target SECOND_CONTACT = Target.the("Second Contact")
            .locatedBy("//android.widget.TextView[@text='Juan Jose']");
    public static final Target CREATE_CONTACT_BUTTON = Target.the("Create new contact button")
            .locatedBy("com.google.android.contacts:id/floating_action_button");
    public static final Target CONTACT_LIST = Target.the("List of contacts")
            .locatedBy("//androidx.compose.ui.platform.ComposeView[@resource-id='com.google.android.contacts:id/contact_list_compose_view']/android.view.View/android.view.View/android.view.View");
}

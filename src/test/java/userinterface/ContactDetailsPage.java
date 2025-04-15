package userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ContactDetailsPage extends PageObject {

    public static final Target EDITION_BUTTON = Target.the("Edition contact button")
            .locatedBy("com.google.android.contacts:id/menu_insert_or_edit");
    public static final Target OPTIONS_BUTTON = Target.the("More options button")
            .locatedBy("com.google.android.contacts:id/menu_settings");
    public static final Target DELETE_BUTTON = Target.the("Delete contact button")
            .locatedBy("//androidx.compose.ui.platform.ComposeView[@resource-id='com.google.android.contacts:id/settings_view']/android.view.View/android.view.View/android.view.View[9]");
    public static final Target DELETE_OPTION_POPUP = Target.the("Popup to confirm contact deletion")
            .locatedBy("android:id/button1");

}

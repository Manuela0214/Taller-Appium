package tasks;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static userinterface.ContactDetailsPage.EDITION_BUTTON;
import static userinterface.ContactListPage.SECOND_CONTACT;
import static userinterface.EditContactPage.*;

@AllArgsConstructor
@NoArgsConstructor
public class EditContact implements Task {

    private String new_last_name;

    @Override
    @Step("{0} enter a new last name to update de contact")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SECOND_CONTACT),
                Click.on(EDITION_BUTTON),
                Clear.field(LAST_NAME_INPUT),
                Enter.keyValues(new_last_name).into(LAST_NAME_INPUT),
                Click.on(SAVE_CONTACT_BUTTON),
                Click.on(BACK_BUTTON)
        );
    }

    public static EditContact editContact(String new_last_name) {
        return Tasks.instrumented(EditContact.class, new_last_name);
    }
}

package tasks;

import lombok.NoArgsConstructor;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static userinterface.ContactDetailsPage.*;
import static userinterface.ContactListPage.SECOND_CONTACT;

@NoArgsConstructor
public class DeleteContact implements Task {

    @Override
    @Step("{0} select a contact and delete it")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SECOND_CONTACT),
                Click.on(OPTIONS_BUTTON),
                Click.on(DELETE_BUTTON),
                Click.on(DELETE_OPTION_POPUP)
        );
    }

    public static DeleteContact deleteContact() {
        return Tasks.instrumented(DeleteContact.class);
    }
}

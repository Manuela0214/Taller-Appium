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

import static userinterface.ContactListPage.CREATE_CONTACT_BUTTON;
import static userinterface.CreateContactPage.*;

@AllArgsConstructor
@NoArgsConstructor
public class CreateContact implements Task {

    private String name;
    private String last_name;
    private String phone_number;

    @Override
    @Step("{0} enter the name, last name and phone number to create a new contact")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CREATE_CONTACT_BUTTON),
                Clear.field(FIRST_NAME_INPUT),
                Enter.keyValues(name).into(FIRST_NAME_INPUT),
                Clear.field(LAST_NAME_INPUT),
                Enter.keyValues(last_name).into(LAST_NAME_INPUT),
                Clear.field(PHONE_INPUT),
                Enter.keyValues(phone_number).into(PHONE_INPUT),
                Click.on(SAVE_CONTACT_BUTTON),
                Click.on(BACK_BUTTON)
        );
    }

    public static CreateContact createContact(String name, String last_name, String phone_number) {
        return Tasks.instrumented(CreateContact.class, name, last_name, phone_number);

    }
}

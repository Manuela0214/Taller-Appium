package stepdefinitions;

import hook.OpenMobileApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import questions.ActualContactsAfterCreation;
import questions.ActualContactsAfterDeletion;
import questions.ActualContactsAfterEdition;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.is;
import static constants.Constants.ACTOR;
import static constants.Constants.URL_APPIUM_SERVER;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static tasks.CreateContact.createContact;
import static tasks.DeleteContact.deleteContact;
import static tasks.EditContact.editContact;
import static userinterface.ContactListPage.HOME_CONTACT_APP;

public class ContactValidationStep {
    @Given("A user is on the main screen of the application")
    public void aUserIsOnTheMainScreenOfTheApplication() {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                OpenMobileApp.openMobileApp(URL_APPIUM_SERVER)
        );
    }

    @When("user create a contact with name {string} and last name {string} and phone number {string}")
    public void userCreateAContactWithNameAndLastNameAndPhoneNumber(String name, String last_name, String phone_number) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                createContact(name, last_name, phone_number),
                WaitUntil.the(HOME_CONTACT_APP, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    @Then("the new contact appears in the contact list")
    public void theNewContactAppearsInTheContactList() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ActualContactsAfterCreation.actualContacts(), is(true))
        );
    }

    @When("user select a contact and update last name to {string}")
    public void userSelectAContactAndUpdateLastNameTo(String new_last_name) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                editContact(new_last_name),
                WaitUntil.the(HOME_CONTACT_APP, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    @Then("the contact has the last name updated in the contact list")
    public void theContactHasTheLastNameUpdatedInTheContactList() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ActualContactsAfterEdition.actualContacts(), is(true))
        );
    }

    @When("user select a contact and select the delete option")
    public void userSelectAContactAndSelectTheDeleteOption() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                deleteContact(),
                WaitUntil.the(HOME_CONTACT_APP, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    @Then("the contact is not present in the contact list")
    public void theContactIsNotPresentInTheContactList() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ActualContactsAfterDeletion.actualContacts(), is(true))
        );
    }

}

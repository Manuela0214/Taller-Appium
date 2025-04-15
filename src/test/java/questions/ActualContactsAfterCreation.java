package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static userinterface.ContactListPage.CONTACT_LIST;

public class ActualContactsAfterCreation implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        WebElement container = CONTACT_LIST.resolveFor(actor);
        List<WebElement> elements = container.findElements(By.xpath("//android.widget.TextView"));
        List<String> actualContactList = elements.stream()
                .map(WebElement::getText)
                .filter(s -> s.length() > 1)
                .collect(Collectors.toList());
        List<String> expectedContactList = Arrays.asList("Ana Maria","Juan Jose","Pepito Perez");

        return actualContactList.equals(expectedContactList);
    }

    public static ActualContactsAfterCreation actualContacts(){
        return new ActualContactsAfterCreation();
    }
}

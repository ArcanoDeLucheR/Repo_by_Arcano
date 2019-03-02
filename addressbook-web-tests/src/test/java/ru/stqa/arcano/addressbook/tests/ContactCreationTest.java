package ru.stqa.arcano.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.ContactData;
import ru.stqa.arcano.addressbook.model.Contacts;



import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTest extends TestBase {

  @Test()
  public void testContactCreation() throws Exception {
    app.contact().homePage();
    Contacts before = (Contacts) app.contact().all();
    app.goTo().addNewPage();
    ContactData contact = new ContactData()
            .withFirstname("Альберт")
            .withLastname("Эйнштейн")
            .withNickname("Гений")
            .withTitle("Физик")
            .withAddress("Германия, Уильм")
            .withCompany("E=mc^")
            .withMobilePhone("8800444333")
            .withMobilePhone("+7 (800) 333-333")
            .withEmail_1("albert_einstein@mail.ru")
            .withEmail_3("relativity@пmail.ru");
    app.contact().addContact(contact,true);
    app.contact().homePage();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = (Contacts) app.contact().all();


    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt()))));

  }

}
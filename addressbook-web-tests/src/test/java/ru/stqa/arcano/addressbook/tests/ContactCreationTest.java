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
            .withMobile("8800444333");
    app.contact().fillContackForm(contact,true);
    app.contact().submitAddNew();
    app.contact().homePage();
    Contacts after = (Contacts) app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt()))));
  }

}
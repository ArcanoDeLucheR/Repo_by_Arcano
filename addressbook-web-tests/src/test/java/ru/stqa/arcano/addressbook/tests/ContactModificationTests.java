package ru.stqa.arcano.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.ContactData;
import ru.stqa.arcano.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().homePage();
    if (!app.contact().isThereAContact()) {
      app.goTo().addNewPage();
      app.contact().addContact(new ContactData()
                      .withFirstname("Альберт")
                      .withFirstname("Эйнштейн")
                      .withNickname("Гений")
                      .withTitle("Физик")
                      .withAddress("Германия, Уильм")
                      .withCompany("E=mc^")
                      .withMobilePhone("8800444333"),
              true);
      app.contact().homePage();
    }
  }

  @Test()
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId())
            .withFirstname("Стивен")
            .withLastname("Хоккинг")
            .withNickname("Чёртов гений")
            .withTitle("Физик")
            .withAddress("Штаты")
            .withCompany("Black hole")
            .withMobilePhone("89307151199");
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}

package ru.stqa.arcano.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;


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
                      .withMobile("8800444333"),
              true);
      app.contact().homePage();
    }
  }

  @Test()
  public void testContactModification() {
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId())
            .withFirstname("Стивен")
            .withLastname("Хоккинг")
            .withNickname("Чёртов гений")
            .withTitle("Физик")
            .withAddress("Штаты")
            .withCompany("Black hole")
            .withMobile("89307151199");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);

    Assert.assertEquals(before, after);
  }


}

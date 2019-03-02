package ru.stqa.arcano.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;


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
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData()
            .withId(before.get(index).getId())
            .withFirstname("Стивен")
            .withLastname("Хоккинг")
            .withNickname("Чёртов гений")
            .withTitle("Физик")
            .withAddress("Штаты")
            .withCompany("Black hole")
            .withMobile("89307151199");
    app.contact().modify(index, contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);

    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }


}

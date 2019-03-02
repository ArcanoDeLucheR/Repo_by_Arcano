package ru.stqa.arcano.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.ContactData;


import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTest extends TestBase {

  @Test()
  public void testContactCreation() throws Exception {
    app.contact().homePage();
    Set<ContactData> before = app.contact().all();
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
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt());

    before.add(contact);
    Assert.assertEquals(before, after);
  }

}
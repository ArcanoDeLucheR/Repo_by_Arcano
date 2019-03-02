package ru.stqa.arcano.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.ContactData;


import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactDeletionTest extends TestBase {


  @BeforeMethod
  public void ensurePreconditions(){
    app.contact().homePage();
    if (! app.contact().isThereAContact())
    {
      app.goTo().addNewPage();
      app.contact().addContact(new ContactData()
              .withFirstname("Альберт")
              .withLastname("Эйнштейн")
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
  public void testContactDeletion() throws Exception {
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);


    Assert.assertEquals(before, after);


  }




}

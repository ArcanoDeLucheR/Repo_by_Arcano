package ru.stqa.arcano.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.ContactData;
import ru.stqa.arcano.addressbook.model.Contacts;


import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

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
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size() - 1);
    assertThat(after, CoreMatchers.equalTo(before.without(deletedContact)));




  }




}

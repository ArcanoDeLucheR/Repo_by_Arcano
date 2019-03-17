package ru.stqa.arcano.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.ContactData;
import ru.stqa.arcano.addressbook.model.Contacts;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

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
              .withMobilePhone("8800444333"),
              true);
      app.contact().homePage();
    }
  }
  @Test()
  public void testContactDeletion() throws Exception {
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.db().contacts();
    assertThat(after, CoreMatchers.equalTo(before.without(deletedContact)));
    verifyContactListInUI();




  }




}

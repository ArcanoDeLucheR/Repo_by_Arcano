package ru.stqa.arcano.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.ContactData;
import ru.stqa.arcano.addressbook.model.GroupData;

public class ContactDeletionTest extends TestBase{

  @Test
  public void testContactDeletion() throws Exception {
    app.getContactHelper().homePage();
    if (! app.getContactHelper().isThereAContact())
    {
              app.getNavigationHelper().addNewPage();
              app.getContactHelper().addContact(new ContactData("Альберт", "Эйнштейн", "Гений", "Физик", null, "Германия, Уильм", "8800444333", null), true);
              app.getContactHelper().homePage();
    }
    int before  = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact();
    app.getContactHelper().delete();
    app.getContactHelper().homePage();
    int after  = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);
  }
}

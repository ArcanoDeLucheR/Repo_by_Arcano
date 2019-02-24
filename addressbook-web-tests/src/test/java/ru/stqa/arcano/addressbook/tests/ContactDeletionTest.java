package ru.stqa.arcano.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.ContactData;
import ru.stqa.arcano.addressbook.model.GroupData;

import java.util.List;

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
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().delete();
    app.getContactHelper().homePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);


    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);



  }


}

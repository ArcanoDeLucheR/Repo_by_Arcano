package ru.stqa.arcano.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.ContactData;


import java.util.Comparator;
import java.util.List;

public class ContactDeletionTest extends TestBase {


  @BeforeMethod
  public void ensurePreconditions(){
    app.getContactHelper().homePage();
    if (! app.getContactHelper().isThereAContact())
    {
      app.getNavigationHelper().addNewPage();
      app.getContactHelper().addContact(new ContactData("Альберт", "Эйнштейн", "Гений", "Физик", null, "Германия, Уильм", "8800444333", null), true);
      app.getContactHelper().homePage();
    }
  }
  @Test(enabled = false)
  public void testContactDeletion() throws Exception {
    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size() -1;
    app.getContactHelper().selectContact(index);
    app.getContactHelper().delete();
    app.getContactHelper().homePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), index);
    before.remove(index);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before, after);


  }


}

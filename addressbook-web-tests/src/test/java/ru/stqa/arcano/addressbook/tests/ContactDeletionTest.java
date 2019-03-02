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
    app.contact().homePage();
    if (! app.contact().isThereAContact())
    {
      app.goTo().addNewPage();
      app.contact().addContact(new ContactData("Альберт", "Эйнштейн", "Гений", "Физик", null, "Германия, Уильм", "8800444333", null), true);
      app.contact().homePage();
    }
  }
  @Test()
  public void testContactDeletion() throws Exception {
    List<ContactData> before = app.contact().list();
    int index = before.size() -1;
    app.contact().select(index);
    app.contact().delete();
    app.contact().homePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(index);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before, after);


  }


}

package ru.stqa.arcano.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.ContactData;
import ru.stqa.arcano.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().homePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().addNewPage();
    ContactData contact = new ContactData("Альберт", "Эйнштейн", "Гений", "Физик", null, "Германия, Уильм", "8800444333", null);
    app.getContactHelper().fillContackForm(contact,true);
    app.getContactHelper().submitAddNew();
    app.getContactHelper().homePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    int max = 0;
    for (ContactData c : after) {
      if (c.getId() > max) {
        max = c.getId();
      }
    }
    contact.setId(max);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
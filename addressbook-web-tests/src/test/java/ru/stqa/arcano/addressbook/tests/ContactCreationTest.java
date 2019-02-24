package ru.stqa.arcano.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.ContactData;
import ru.stqa.arcano.addressbook.model.GroupData;

import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().homePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().addNewPage();
    app.getContactHelper().fillContackForm(new ContactData("Альберт", "Эйнштейн", "Гений", "Физик", null, "Германия, Уильм", "8800444333", null),true);
    app.getContactHelper().submitAddNew();
    app.getContactHelper().homePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }

}
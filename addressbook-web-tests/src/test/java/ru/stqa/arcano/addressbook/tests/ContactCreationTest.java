package ru.stqa.arcano.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().homePage();
    int before  = app.getContactHelper().getContactCount();
    app.getNavigationHelper().addNewPage();
    app.getContactHelper().fillContackForm(new ContactData("Альберт", "Эйнштейн", "Гений", "Физик", null, "Германия, Уильм", "8800444333", "test1"),true);
    app.getContactHelper().submitAddNew();
    app.getContactHelper().homePage();
    int after  = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);
  }

}
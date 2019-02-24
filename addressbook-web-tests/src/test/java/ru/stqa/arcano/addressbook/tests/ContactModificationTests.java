package ru.stqa.arcano.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.ContactData;

import java.util.List;


public class ContactModificationTests extends TestBase
{
  @Test
  public void testContactModification(){
    app.getContactHelper().homePage();
    if (! app.getContactHelper().isThereAContact())
    {
      app.getNavigationHelper().addNewPage();
      app.getContactHelper().addContact(new ContactData("Альберт", "Эйнштейн", "Гений", "Физик", null, "Германия, Уильм", "8800444333", null), true);
      app.getContactHelper().homePage();
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().editContact(before.size() - 1);
    app.getContactHelper().fillContackForm(new ContactData("Стивен", "Хоккинг", "Чёртов гений", "Физик", "\"Пятёрочка\"", "Германия, Уильм", "8800444333", null), false);
    app.getContactHelper().updateButton();
    app.getContactHelper().homePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
  }

}

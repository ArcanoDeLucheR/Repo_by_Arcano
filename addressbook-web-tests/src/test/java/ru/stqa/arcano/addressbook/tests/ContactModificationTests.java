package ru.stqa.arcano.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class ContactModificationTests extends TestBase
{
  @Test (enabled = false)
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
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"Стивен", "Хоккинг", "Чёртов гений", "Физик", "\"Пятёрочка\"", "Германия, Уильм", "8800444333", null);
    app.getContactHelper().fillContackForm(contact, false);
    app.getContactHelper().updateButton();
    app.getContactHelper().homePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() -1 );
    before.add(contact);

    Comparator<? super ContactData> byId = (g1 , g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}

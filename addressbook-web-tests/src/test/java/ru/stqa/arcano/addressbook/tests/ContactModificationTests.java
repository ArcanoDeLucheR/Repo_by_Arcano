package ru.stqa.arcano.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;


public class ContactModificationTests extends TestBase
{
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
  @Test ()
  public void testContactModification(){
    List<ContactData> before = app.contact().list();
    int index = before.size() -1;
    ContactData contact = new ContactData(before.get(index).getId(),"Стивен", "Хоккинг", "Чёртов гений", "Физик", "\"Пятёрочка\"", "Германия, Уильм", "8800444333", null);
    app.contact().modify(index, contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index );
    before.add(contact);

    Comparator<? super ContactData> byId = (g1 , g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }


}

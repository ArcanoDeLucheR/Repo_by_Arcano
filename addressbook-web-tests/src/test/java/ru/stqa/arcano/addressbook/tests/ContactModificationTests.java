package ru.stqa.arcano.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.ContactData;


public class ContactModificationTests extends TestBase
{
  @Test
  public void testContactModification(){
    app.getContactHelper().homePage();
    if (! app.getContactHelper().isThereAContact())
    {
      app.getNavigationHelper().addNewPage();
      app.getContactHelper().addContact(new ContactData("Альберт", "Эйнштейн", "Гений", "Физик", null, "Германия, Уильм", "8800444333", "[none]"), true);
      app.getContactHelper().homePage();
    }
    app.getContactHelper().editContact();
    app.getContactHelper().fillContackForm(new ContactData("Стивен", "Хоккинг", "Чёртов гений", "Физик", "\"Пятёрочка\"", "Германия, Уильм", "8800444333", null), false);
    app.getContactHelper().updateButton();
    app.getContactHelper().homePage();
  }

}

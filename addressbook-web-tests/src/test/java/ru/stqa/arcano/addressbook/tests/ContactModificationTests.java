package ru.stqa.arcano.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.ContactData;


public class ContactModificationTests extends TestBase
{
  @Test
  public void testContactModification(){
    app.getContactHelper().homePage();
    app.getContactHelper().editContact("4");
    app.getContactHelper().fillContackForm(new ContactData("Стивен", "Хоккинг", "Чёртов гений", "Физик", "\"Пятёрочка\"", "Германия, Уильм", "8800444333"));
    app.getContactHelper().updateBatton();
    app.getContactHelper().homePage();
  }

}

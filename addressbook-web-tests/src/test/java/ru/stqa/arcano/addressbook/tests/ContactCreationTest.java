package ru.stqa.arcano.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    addNewPage();
    fillContackForm(new ContactData("Альберт", "Эйнштейн", "Гений", "Физик", "\"Пятёрочка\"", "Германия, Уильм", "8800444333"));
    submitAddNew();
  }

}

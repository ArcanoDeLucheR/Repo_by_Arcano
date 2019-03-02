package ru.stqa.arcano.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.ContactData;

public class ContactPhoneTests extends TestBase {

  @Test
  public  void testPhones(){
    app.contact().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoEditFrom = app.contact().infoFromEditForm(contact);

  }
}

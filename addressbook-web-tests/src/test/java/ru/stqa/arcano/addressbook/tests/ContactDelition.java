package ru.stqa.arcano.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.ContactData;

public class ContactDelition extends TestBase{

  @Test
  public void testContactDelition() throws Exception {
    app.getContactHelper().homePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().delete();

  }
}

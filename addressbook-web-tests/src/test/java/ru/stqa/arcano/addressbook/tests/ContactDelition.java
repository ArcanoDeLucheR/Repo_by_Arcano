package ru.stqa.arcano.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDelition extends TestBase{

  @Test
  public void testContactDeletion() throws Exception {
    app.getContactHelper().homePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().delete();

  }
}

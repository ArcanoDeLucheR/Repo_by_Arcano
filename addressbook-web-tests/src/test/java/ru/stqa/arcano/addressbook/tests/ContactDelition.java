package ru.stqa.arcano.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDelition extends TestBase{

  @Test
  public void testContactDelition() throws Exception {
    app.getContactHelper().homePage();
    app.getContactHelper().selectContact("1");
    app.getContactHelper().delete();

  }
}

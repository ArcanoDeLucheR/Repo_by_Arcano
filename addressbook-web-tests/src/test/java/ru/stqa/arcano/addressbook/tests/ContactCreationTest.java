package ru.stqa.arcano.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.ContactData;


import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test()
  public void testContactCreation() throws Exception {
    app.contact().homePage();
    List<ContactData> before = app.contact().list();
    app.goTo().addNewPage();
    ContactData contact = new ContactData()
            .withFirstname("Альберт").withLastname("Эйнштейн").withNickname("Гений").withTitle("Физик").withAddress("Германия, Уильм").withCompany("E=mc^").withMobile("8800444333");
    app.contact().fillContackForm(contact,true);
    app.contact().submitAddNew();
    app.contact().homePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);


    before.add(contact);
    Comparator<? super ContactData> byId = (g1 , g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
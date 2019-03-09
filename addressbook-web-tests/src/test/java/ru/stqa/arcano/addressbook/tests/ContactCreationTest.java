package ru.stqa.arcano.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.ContactData;
import ru.stqa.arcano.addressbook.model.Contacts;


import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTest extends TestBase {

  @Test()
  public void testContactCreation() throws Exception {
    app.contact().homePage();
    Contacts before = (Contacts) app.contact().all();
    app.goTo().addNewPage();
    File photo = new File("src/test/resources/1.jpg");
    ContactData contact = new ContactData()
            .withFirstname("Альберт")
            .withLastname("Эйнштейн")
            .withNickname("Гений")
            .withTitle("Физик")
            .withAddress("Германия, Уильм")
            .withCompany("E=mc^")
            .withHomePhone("8800444333")
            .withMobilePhone("+7 (800) 333-333")
            .withEmail_1("albert_einstein@mail.ru")
            .withEmail_3("relativity@пmail.ru")
            .withPhoto(photo);

    app.contact().addContact(contact,true);
    app.contact().homePage();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = (Contacts) app.contact().all();


    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt()))));

  }

  //@Test// public void testCurrentDir(){
 //   File currentDir = new File(".");
 //   System.out.println(currentDir.getAbsolutePath());
 //   File photo = new File("src/test/resources/stru.png");
 //   System.out.println(photo.getAbsolutePath());
 //   System.out.println(photo.exists());
 // }
}
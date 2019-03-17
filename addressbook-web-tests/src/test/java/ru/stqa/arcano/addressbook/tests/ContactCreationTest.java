package ru.stqa.arcano.addressbook.tests;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.ContactData;
import ru.stqa.arcano.addressbook.model.Contacts;
import ru.stqa.arcano.addressbook.model.Groups;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File ("src/test/resources/contacts.json")));
    String json = "";
    String line = reader.readLine();
    while (line !=null){
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
    List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType()); //List<ContactData>.class
    return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
  }


  @Test(dataProvider = "validContactsFromJson")
  public void testContactCreation(ContactData contact) throws Exception {
 //   Groups groups = app.db().groups();
    app.contact().homePage();
    Contacts before = (Contacts) app.db().contacts();
    app.goTo().addNewPage();
  //  File photo = new File("src/test/resources/1.jpg");
  //  ContactData contact = new ContactData()
  //          .withFirstname("Альберт")
  //          .withLastname("Эйнштейн")
  //          .withNickname("Гений")
  //          .withTitle("Физик")
   //         .withAddress("Германия, Уильм")
  //          .withCompany("E=mc^")
 //           .withHomePhone("8800444333")
  //          .withMobilePhone("+7 (800) 333-333")
   //         .withEmail_1("albert_einstein@mail.ru")
   //         .withEmail_3("relativity@пmail.ru")
  //          .withPhoto(photo);

    app.contact().addContact(contact,true);
    app.contact().homePage();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = (Contacts) app.db().contacts();


    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt()))));
    verifyContactListInUI();

  }

  //@Test// public void testCurrentDir(){
 //   File currentDir = new File(".");
 //   System.out.println(currentDir.getAbsolutePath());
 //   File photo = new File("src/test/resources/stru.png");
 //   System.out.println(photo.getAbsolutePath());
 //   System.out.println(photo.exists());
 // }
}
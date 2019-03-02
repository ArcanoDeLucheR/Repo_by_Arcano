package ru.stqa.arcano.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactPhoneTests extends TestBase {

  @Test
  public  void testPhones(){
    app.contact().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoEditFrom = app.contact().infoFromEditForm(contact);

    assertThat(contact.getHomePhone(), equalTo(cleaned(contactInfoEditFrom.getHomePhone())));
    assertThat(contact.getMobilePhone(), equalTo(cleaned(contactInfoEditFrom.getMobilePhone())));
    assertThat(contact.getWorkPhone(), equalTo(cleaned(contactInfoEditFrom.getWorkPhone())));
  }
  public String cleaned(String phone){
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}

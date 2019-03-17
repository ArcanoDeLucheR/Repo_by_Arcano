package ru.stqa.arcano.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.sql.DriverManager.println;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {


  @Test
  public  void testAddress() {
    app.contact().homePage();
    ContactData contact = app.db().contacts().iterator().next();
    ContactData contactInfoEditFrom = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAddress(), equalTo(contactInfoEditFrom.getAddress()));
    verifyContactListInUI();
  }

  @Test
  public  void testAddressEmails() {
    app.contact().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoEditFrom = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAll_emails(), equalTo(mergeEmailes(contactInfoEditFrom)));
    verifyContactListInUI();
  }

  private String mergeEmailes(ContactData contact) {
    return Arrays.asList(contact.getEmail_1(), contact.getEmail_2(), contact.getEmail_3()).
            stream().filter((s) -> !s.equals("")).collect(Collectors.joining("\n"));
  }
}

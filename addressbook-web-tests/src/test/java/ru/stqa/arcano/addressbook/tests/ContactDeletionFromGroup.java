package ru.stqa.arcano.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.ContactData;
import ru.stqa.arcano.addressbook.model.Contacts;
import ru.stqa.arcano.addressbook.model.GroupData;
import ru.stqa.arcano.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionFromGroup extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().GroupPage();
      app.group().create(new GroupData().withName("test0"));
    }

    if (app.db().contacts().size() == 0) {
      app.contact().homePage();
      app.goTo().addNewPage();
      app.contact().addContact(new ContactData()
                      .withFirstname("Альберт")
                      .withLastname("Эйнштейн")
                      .withNickname("Гений")
                      .withTitle("Физик")
                      .withAddress("Германия, Уильм")
                      .withCompany("E=mc^")
                      .withMobilePhone("8800444333"),
              true);
      app.contact().homePage();
    }

    if (app.db().contacts().iterator().next().getGroups().size() == 0) {
      Contacts ContactBeforeAddingGroup = app.db().contacts();
      Groups beforeGroup = app.db().groups();
      ContactData selectedContact = ContactBeforeAddingGroup.iterator().next();
      GroupData selectedGroup = beforeGroup.iterator().next();
      app.contact().addContactToGroup(selectedContact, selectedGroup);
    }

  }

  @Test
  public void testContactDeletionFromGroup() {

    Contacts ContactBeforeDeletionFromGroup = app.db().contacts();
    Groups firstGroup = app.db().groups();
    ContactData selectedContact = ContactBeforeDeletionFromGroup.iterator().next();
    Groups GroupsOfSelectedContacts_before = ContactBeforeDeletionFromGroup.iterator().next().getGroups();
    GroupData selectedGroup = firstGroup.iterator().next();

    app.contact().ViewContactsFromGroup(selectedGroup);
    app.contact().DeleteContactFromGroup(selectedContact);

    Contacts ContactAfterDeletionFromGroup = app.db().contacts();
    Groups GroupsOfSelectedContacts_after = ContactAfterDeletionFromGroup.iterator().next().getGroups();
    assertThat(GroupsOfSelectedContacts_after, equalTo(GroupsOfSelectedContacts_before.without(selectedGroup)));
    verifyGroupListInUI();



  }



}

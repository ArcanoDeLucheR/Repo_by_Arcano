package ru.stqa.arcano.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.arcano.addressbook.model.ContactData;


import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContackForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobile());


    if (creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void submitAddNew() {
    click(By.name("submit"));
  }

  public void select(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
    //click(By.xpath("//td/input"));
  }

  public void homePage() {
    click(By.linkText("home"));
  }

  public void delete() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void editContact(int index) {
    wd.findElements(By.xpath("(//img[@alt='Edit'])")).get(index).click();
  }

  public void updateButton() {
    click(By.name("update"));
  }


  public void addContact(ContactData contact, boolean creation ) {
    fillContackForm(contact, creation);
    submitAddNew();
  }
  public void modify(int index, ContactData contact) {
    editContact(index);
    fillContackForm(contact, false);
    updateButton();
    homePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//td/input"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();

    List<WebElement> elements = wd.findElements(By.name("entry"));
    
    for (WebElement element: elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      ContactData contact = new ContactData().withId(id).withFirstname(firstname).withLastname(lastname);
      contacts.add(contact);
    }
    return contacts;
  }
}

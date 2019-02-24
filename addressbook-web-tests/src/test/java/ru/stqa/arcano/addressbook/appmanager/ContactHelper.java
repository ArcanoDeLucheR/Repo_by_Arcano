package ru.stqa.arcano.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.arcano.addressbook.model.ContactData;
import ru.stqa.arcano.addressbook.model.GroupData;

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

  public void selectContact(int index) {
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

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//td/input"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();

    List<WebElement> firstname_elements = wd.findElements(By.xpath("//*[@id='maintable']//td[2]"));
    List<WebElement> lastname_elements = wd.findElements(By.xpath("//*[@id='maintable']//td[3]"));
    int n = 0;
    for (WebElement firstname_element :  firstname_elements) {
      String firstname = firstname_element.getText();
      String lastname = lastname_elements.get(n).getText();
      ContactData contact = new ContactData(firstname, lastname, null, null, null, null, null, null);
      contacts.add(contact);
      n++;
    }
    return contacts;
  }
}

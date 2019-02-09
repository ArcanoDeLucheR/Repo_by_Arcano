package ru.stqa.arcano.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.arcano.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContackForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobile());
  }

  public void submitAddNew() {
    click(By.name("submit"));
  }

  public void selectContact(final String id) {
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Альберт'])[1]/following::input[" + id + "]"));
  }

  public void homePage() {
    click(By.linkText("home"));
  }

  public void delete() {
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select all'])[1]/following::input[2]"));
    wd.switchTo().alert().accept();
  }

  public void editContact(final String id) {
    click(By.xpath("(//img[@alt='Edit'])[" + id + "]"));
  }

  public void updateBatton() {
    click(By.name("update"));
  }
}

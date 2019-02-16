package ru.stqa.arcano.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By loacator) {
    wd.findElement(loacator).click();
  }

  protected void type(By loacator, String text) {
    click(loacator);
    if (text != null) {
      String existingText =wd.findElement(loacator).getAttribute("value");
      if(! text.equals(existingText)){
        wd.findElement(loacator).clear();
        wd.findElement(loacator).sendKeys(text);
      }
    }
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  protected boolean isElementPresent(By loacator) {
    try {
      wd.findElement(loacator);
      return true;
    } catch (NoSuchElementException ex){
      return false;
    }

  }
}

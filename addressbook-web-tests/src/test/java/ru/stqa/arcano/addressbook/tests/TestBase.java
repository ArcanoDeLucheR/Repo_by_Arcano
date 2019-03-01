package ru.stqa.arcano.addressbook.tests;


import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;
import ru.stqa.arcano.addressbook.appmanager.ApplicationManager;


public class TestBase {

  protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite
  public void tearDown() throws Exception {
    app.stop();
  }

}

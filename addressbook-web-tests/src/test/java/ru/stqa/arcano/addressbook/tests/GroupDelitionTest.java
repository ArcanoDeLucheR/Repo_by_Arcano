package ru.stqa.arcano.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDelitionTest extends TestBase {

  @Test
  public void testGroupDelition() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }

}
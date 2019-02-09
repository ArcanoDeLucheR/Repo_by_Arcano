package ru.stqa.arcano.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.GroupData;



public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification(){
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test1_update", "test2_update", "test3_update"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();

  }
}

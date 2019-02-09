package ru.stqa.arcano.addressbook;
import org.testng.annotations.*;

public class GroupCreationTest extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test1", "test2", "test3"));
    submitGroupCreation();
    returnToGroupPage();
  }

}

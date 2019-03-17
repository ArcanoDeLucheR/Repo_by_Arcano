package ru.stqa.arcano.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.GroupData;
import ru.stqa.arcano.addressbook.model.Groups;



import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;


public class GroupDelitionTest extends TestBase {


  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().GroupPage();
    if (app.db().groups().size() == 0) {
      app.group().create(new GroupData().withName("test2"));
    }
  }
  @Test
  public void testGroupDeletion() throws Exception {
    Groups before = app.db().groups();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    assertThat(app.group().Count(), equalTo(before.size() - 1));
    Groups after = app.db().groups();
    assertThat(after, CoreMatchers.equalTo(before.without((deletedGroup))));
    verifyGroupListInUI();



  }

}
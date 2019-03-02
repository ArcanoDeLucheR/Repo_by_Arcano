package ru.stqa.arcano.addressbook.tests;
import org.testng.annotations.*;
import ru.stqa.arcano.addressbook.model.GroupData;
import ru.stqa.arcano.addressbook.model.Groups;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTest extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().GroupPage();
    Groups before = (Groups) app.group().all();
    GroupData group = new GroupData().withName("test2");
    app.group().create(group);
    assertThat(app.group().Count(), equalTo(before.size() + 1));
    Groups after = (Groups) app.group().all();
    assertThat(after, equalTo(
            before.WithAdded(group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));

  }

  @Test
  public void testBadGroupCreation() throws Exception {
    app.goTo().GroupPage();
    Groups before = (Groups) app.group().all();
    GroupData group = new GroupData().withName("test2'");
    app.group().create(group);
    assertThat(app.group().Count(), equalTo(before.size()));
    Groups after = (Groups) app.group().all();
    assertThat(after, equalTo(before));

  }

}

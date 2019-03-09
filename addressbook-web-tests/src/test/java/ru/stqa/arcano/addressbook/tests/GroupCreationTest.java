package ru.stqa.arcano.addressbook.tests;
import org.testng.annotations.*;
import ru.stqa.arcano.addressbook.model.GroupData;
import ru.stqa.arcano.addressbook.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/groups.csv"));
    String line = reader.readLine();
    while (line !=null){
      String[] split = line.split(";");
      list.add(new Object[] {new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
      line = reader.readLine();
    }
    return list.iterator();
  }

  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) throws Exception {
  //  GroupData group = new GroupData().withName(name).withHeader(header).withFooter(footer);
    app.goTo().GroupPage();
    Groups before = (Groups) app.group().all();
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

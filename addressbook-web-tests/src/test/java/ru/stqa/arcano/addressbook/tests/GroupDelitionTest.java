package ru.stqa.arcano.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupDelitionTest extends TestBase {


  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().GroupPage();
    if (app.group().list().size() == 0)
    {
      app.group().create(new GroupData().withName("test2"));
    }
  }
  @Test
  public void testGroupDeletion() throws Exception {
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    app.group().delete(index);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(index);

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before, after);


  }

}
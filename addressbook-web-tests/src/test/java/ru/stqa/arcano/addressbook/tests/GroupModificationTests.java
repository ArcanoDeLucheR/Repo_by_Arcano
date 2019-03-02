package ru.stqa.arcano.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.arcano.addressbook.model.GroupData;
import ru.stqa.arcano.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;


public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().GroupPage();
    if (app.group().all().size() == 0)
    {
      app.group().create(new GroupData().withName("test2"));
    }
  }

  @Test
  public void testGroupModification(){
    Groups before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();


    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
    app.group().modify(group);
    assertThat(app.group().Count(), equalTo(before.size()));
    Groups after = app.group().all();
    assertThat(after, CoreMatchers.equalToObject(before.without(modifiedGroup).WithAdded(group)));

  }

}

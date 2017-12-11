package ru.stqa.pft.addressbook1.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook1.model.GroupData1;


public class GroupTest1 extends TestBase {

  @Test
  public void testGroup() {
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData1("test", "test1", "test2"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}

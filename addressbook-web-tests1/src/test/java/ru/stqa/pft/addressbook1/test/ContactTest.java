package ru.stqa.pft.addressbook1.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook1.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactTest extends TestBase {

  @Test
  public void testContact() {
    app.getNavigationHelper().goToHome();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().goToContact();
    ContactData group = new ContactData("Imie", "Nowak", "222-333-444", "ola@wp.pl");
    app.getContactHelper().fillData(group);
    app.getContactHelper().submitContactData();
    app.getContactHelper().returnToPage();
    List<ContactData> after = app.getContactHelper().getContactList();

    Assert.assertEquals(after.size(), before.size() + 1);

    int max = 0;
    for (ContactData c:after) {
      if (c.getId()>max){
        max = c.getId();
      }
    }
    group.setId(max);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
  }

}

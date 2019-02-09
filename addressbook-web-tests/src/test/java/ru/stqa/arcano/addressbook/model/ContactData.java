package ru.stqa.arcano.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String nickname;
  private final String title;
  private final String company;
  private final String address;
  private final String mobile;

  public ContactData(String firstname, String lastname, String nickname, String title, String company, String address, String mobile) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.mobile = mobile;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getMobile() {
    return mobile;
  }
}

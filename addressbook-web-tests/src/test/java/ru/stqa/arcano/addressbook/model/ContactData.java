package ru.stqa.arcano.addressbook.model;


import com.google.gson.annotations.Expose;

import java.io.File;

public class ContactData {

  private int id = Integer.MAX_VALUE;
  @Expose
  private  String firstname;
  @Expose
  private  String lastname;
  @Expose
  private  String nickname;
  @Expose
  private  String title;
  @Expose
  private  String company;
  @Expose
  private  String address;
  @Expose
  private  String email_1;
  @Expose
  private  String email_2;
  @Expose
  private  String email_3;
  @Expose
  private  String all_emails;
  @Expose
  private  String homePhone;
  @Expose
  private  String mobilePhone;
  @Expose
  private  String workPhone;
  @Expose
  private  String AllPhones;
  @Expose
  private File photo;

  public File getPhoto() {
    return photo;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public String getEmail_1() {
    return email_1;
  }

  public ContactData withEmail_1(String email_1) {
    this.email_1 = email_1;
    return this;
  }

  public String getEmail_2() {
    return email_2;
  }

  public ContactData withEmail_2(String email_2) {
    this.email_2 = email_2;
    return this;
  }

  public String getEmail_3() {
    return email_3;
  }

  public ContactData withEmail_3(String email_3) {
    this.email_3 = email_3;
    return this;
  }

  public String getAll_emails() {
    return all_emails;
  }

  public ContactData withAll_emails(String all_emails) {
    this.all_emails = all_emails;
    return this;
  }


  public String getAllPhones() {
    return AllPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    AllPhones = allPhones;
    return this;
  }

  private  String group;

  public ContactData() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }


  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }


  public ContactData withMobilePhone(String mobile) {
    this.mobilePhone = mobile;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }
  public ContactData withHomePhone(String home) {
    this.homePhone = home;
    return this;
  }

  public ContactData withWorkPhone(String work) {
    this.workPhone = work;
    return this;
  }


  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  public int getId() {
    return id;
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

  public String getMobilePhone() {
    return mobilePhone;
  }
  public String getHomePhone() {
    return homePhone;
  }
  public String getWorkPhone() {
    return workPhone;
  }

  public String getGroup() {
     if (group == null) {
       group = "[none]";
     }
    return group;
  }

}

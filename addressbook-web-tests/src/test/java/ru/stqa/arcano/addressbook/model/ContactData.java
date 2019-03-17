package ru.stqa.arcano.addressbook.model;


import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@Entity
@Table(name = "addressbook")

public class ContactData {

  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;
  @Expose
  @Column(name = "firstname")
  private  String firstname;
  @Expose
  @Column(name = "lastname")
  private  String lastname;
  @Expose
  @Column(name = "nickname")
  private  String nickname;
  @Expose
  @Column(name = "title")
  private  String title;
  @Expose
  @Column(name = "company")
  private  String company;
  @Expose
  @Type(type = "text")
  @Column(name = "address")
  private  String address;
  @Expose
  @Type(type = "text")
  @Column(name = "email")
  private  String email_1;
  @Expose
  @Type(type = "text")
  @Column(name = "email2")
  private  String email_2;
  @Expose
  @Type(type = "text")
  @Column(name = "email3")
  private  String email_3;
  @Expose
  @Transient
  private  String all_emails;
  @Expose
  @Column(name = "home")
  @Type(type = "text")
  private  String homePhone;
  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private  String mobilePhone;
  @Expose
  @Column(name = "work")
  @Type(type = "text")
  private  String workPhone;
  @Expose
  @Transient
  private  String AllPhones;
  @Expose
  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  @Transient
  private  String group;


  public File getPhoto() {
    return new File(photo);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
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


  public ContactData() {
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

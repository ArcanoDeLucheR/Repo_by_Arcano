package ru.stqa.pft.mantis.model;


import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mantis_user_table")

public class MantisUserData {

  @Id
  @Column(name = "id")
  private int id;

  @Expose
  @Column (name = "username")
  private  String username;

  @Expose
  @Column (name = "email")
  private  String email;

  public MantisUserData withId(int id) {
    this.id = id;
    return this;
  }

  public MantisUserData withUsername(String username) {
    this.username = username;
    return this;
  }

  public MantisUserData withEmail(String email) {
    this.email = email;
    return this;
  }


  public int getId(){
    return id;
  }

  public String getUsername(){
    return username;
  }


  public String getEmail() {
    return email;
  }

  @Override
  public String toString() {
    return "MantisUserData{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", email='" + email + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    MantisUserData that = (MantisUserData) o;

    if (id != that.id) return false;
    if (username != null ? !username.equals(that.username) : that.username != null) return false;
    return email != null ? email.equals(that.email) : that.email == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (username != null ? username.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    return result;
  }

}

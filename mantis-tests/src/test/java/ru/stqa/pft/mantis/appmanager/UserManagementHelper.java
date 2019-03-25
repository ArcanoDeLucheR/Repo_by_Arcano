package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import ru.stqa.pft.mantis.model.MantisUserData;

import java.sql.*;

public class UserManagementHelper extends HelperBase {

  public UserManagementHelper(ApplicationManager app) {
    super(app);
  }

  public void goToUserManagerPage() {
    wd.get(app.getProperty("web.baseUrl") + "/manage_user_page.php");
  }

  public void modifyCurrentUser(int id , String user ) {
  //  wd.findElement(By.linkText(user)).click();   Клик по юзеру (простой способ)
    try {
      wd.findElement(By.xpath("//a[contains(@href, 'manage_user_edit_page.php?user_id=" + id + "')]")).click(); //клик по ссылке использующий id
    } catch (NoSuchElementException err){
      System.out.println("Пользователь " + user + " не сущесвует!");
    }
  }

  public void sendEmailForResetPassword() {
    wd.findElement(By.xpath("//input[@value='Сбросить пароль']")).click();
    wd.findElement(By.linkText("Продолжить")).click();
  }

  public void loggingAsAdmin() {
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    wd.findElement(By.id("username")).click();
    wd.findElement(By.id("username")).clear();
    wd.findElement(By.id("username")).sendKeys("administrator");
    wd.findElement(By.id("password")).clear();
    wd.findElement(By.id("password")).sendKeys("root");
    wd.findElement(By.xpath("//input[@value='Войти']")).click();


  }

  public MantisUserData getUserId(String username) {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bugtracker?serverTimezone=UTC&user=root&password=");
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("SELECT id, username, email from mantis_user_table");
      while (rs.next()) {
        if (rs.getString("username").equals(username)) {
          return new MantisUserData().withId(rs.getInt("id")).withUsername(rs.getString("username")).withEmail(rs.getString("email"));
        }
      }
      rs.close();
      st.close();
      conn.close();
    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }
    return null;
  }
}

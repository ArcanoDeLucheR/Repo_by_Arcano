package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class UserManagementHelper extends HelperBase {

  public UserManagementHelper(ApplicationManager app) {
    super(app);
  }

  public void goToUserManagerPage() {
    wd.get(app.getProperty("web.baseUrl") + "/manage_user_page.php");
  }

  public void modifyCurrentUser(String user) {
    wd.findElement(By.linkText(user)).click();
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
}

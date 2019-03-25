package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.MantisUserData;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class ResetPasswordTests  extends TestBase {
  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
    app.userManagement().loggingAsAdmin();

  }



  @Test
  public void testResetPassword() throws IOException, MessagingException {
    long now = System.currentTimeMillis();
    String user = "user1553439080306";
    MantisUserData MantisUser = app.userManagement().getUserId(user);
    String newpassword = String.format("%s", now);
    app.userManagement().goToUserManagerPage();
    try {
      app.userManagement().modifyCurrentUser(MantisUser.getId(), MantisUser.getEmail());
    } catch (NullPointerException err) {
      System.out.println("Пользователь " + user + " не существует!");
    }
    app.userManagement().sendEmailForResetPassword();
    List<MailMessage> mailMessages = app.mail().waitForMail(1,10000);
    String confirmationLink = findConfirmationLink(mailMessages, MantisUser.getEmail());
    app.registration().finish(confirmationLink, newpassword);
    assertTrue(app.newSession().login(user,newpassword));


  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText((mailMessage.text));
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }


}

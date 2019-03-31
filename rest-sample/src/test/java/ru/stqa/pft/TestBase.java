package ru.stqa.pft;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;
import org.testng.SkipException;

public class TestBase {

  boolean isIssueOpen(int issue_id){
    if (!statusOfIssue(issue_id).equals("Resolved") || !statusOfIssue(issue_id).equals("Closed") ) {
      return true;
    } else return false;
  }

  public String statusOfIssue(int issue_id) {
    String json = RestAssured.get(String.format("http://bugify.stqa.ru/api/issues/"+ issue_id +".json")).asString();
    JsonElement parsed = new JsonParser().parse(json);
    return parsed.getAsJsonObject().get("issues").getAsJsonArray().get(0).getAsJsonObject().get("state_name").getAsString();
  }

  public void skipIfNotFixed(int issueId) {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }
}


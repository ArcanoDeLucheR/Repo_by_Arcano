package ru.stqa.pft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithubTests {

  @Test
  public void testCommits() throws IOException {
    Github github = new RtGithub("d2ba6d3071a458be44d169738efe75690d4e5767");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("ArcanoDeLucheR", "Repo_by_Arcano")).commits();
    for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String,String>().build())) {
      System.out.println(new RepoCommit.Smart(commit).message());
    }
  }

}

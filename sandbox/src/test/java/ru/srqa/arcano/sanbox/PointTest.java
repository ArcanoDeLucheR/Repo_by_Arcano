package ru.srqa.arcano.sanbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.arcano.sanbox.Point;

public class PointTest {

  @Test
  public void testDistance(){
    Point p1 = new Point(5.51, 12.74);
    Point p2 = new Point(6.25, -2.42);
    Assert.assertEquals(p1.distanceMethod(p2),15.17804994062149);
  }
}

package ru.stqa.arcano.sanbox;

public class Task2
{
  public static void main(String[] args) {

    Point p1 = new Point(5.51, 12.74);
    Point p2 = new Point(6.25, -2.42);
    System.out.println("Расстояние  между точкой p1 c координатами (" + p1.x + ";" + p1.y + ") и p2 с координатами (" + p2.x + ";" + p2.y + ") равно " +  distance(p1,p2));
    System.out.println("Расстояние  между точкой p1 c координатами (" + p1.x + ";" + p1.y + ") и p2 с координатами (" + p2.x + ";" + p2.y + ") равно " +  p1.distanceMethod(p2));
  }

  public static double distance(Point p1, Point p2){
   return Math.sqrt(Math.pow((p2.x - p1.x ),2) +  Math.pow(( p2.y - p1.y ),2));
  }
}
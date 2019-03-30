package ru.stqa.pft.soap;

import com.lavasoft.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTests {

  @Test
  public  void testMyIp(){
    String Ip = new GeoIPService().getGeoIPServiceSoap12().getCountryNameByISO2("194.28.29.1562");
    assertEquals(Ip,"<GeoIP><Country>UNITED STATES</Country></GeoIP>");
    }
}

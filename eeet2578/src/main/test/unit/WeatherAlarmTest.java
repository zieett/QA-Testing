package main.test.unit;

import main.WeatherAlarms;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeatherAlarmTest {

    @Test
    public void testReadWeatherConditions () {

        System.out.println("------------------------");
        System.out.println("Test reading weather condition in weather alarm test class");
        WeatherAlarms weatherAlarms = new WeatherAlarms();
        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(0);
        expectedList.add(2);
        expectedList.add(3);
        expectedList.add(1);
        assertEquals(expectedList , weatherAlarms.readWeatherConditions());
        System.out.println("Expected output: " + expectedList.toString());
        System.out.println("Actual output: " + weatherAlarms.readWeatherConditions().toString());
    }


    @Test
    public void testReadMissingWeatherFile () {

        System.out.println("------------------------");
        System.out.println("Test reading missing weather file");
        WeatherAlarms weatherAlarms = new WeatherAlarms();
        List<Integer> expectedList = new ArrayList<>();
        assertEquals(expectedList , weatherAlarms.readWeatherConditions());
        System.out.println("Expected output: " + expectedList.toString());
        System.out.println("Actual output: " + weatherAlarms.readWeatherConditions().toString());
    }
}
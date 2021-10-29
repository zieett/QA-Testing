package main.test.unit;

import main.LocationServer;
import org.junit.Test;
import org.junit.runners.Parameterized;

import javax.xml.stream.Location;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LocationServerTest {

    private LinkedHashMap<String, String> expectedResult;


    @Test
    public void testReadConfig(){

        System.out.println("--------------------");
        System.out.println("Test read config file");
        expectedResult = new LinkedHashMap<>();
        expectedResult.put("A" , "Indoor");
        expectedResult.put("B","Indoor");
        expectedResult.put("C" , "Outdoor");
        expectedResult.put("D","Outdoor");

        assertEquals(expectedResult , LocationServer.readConfig());
        System.out.println("Expected output: " + expectedResult.toString());
        System.out.println("Actual output: " + LocationServer.readConfig().toString());
        System.out.println();
    }


    @Test
    public void testReadMissingLocationFile(){

        System.out.println("--------------------");
        System.out.println("Test read config file");
        expectedResult = new LinkedHashMap<>();

        assertEquals(expectedResult , LocationServer.readConfig());
        System.out.println("Expected output: " + expectedResult.toString());
        System.out.println("Actual output: " + LocationServer.readConfig().toString());
        System.out.println();
    }


}
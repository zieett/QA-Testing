package main.test.unit.contextManager;

import helper.SensorData;
import helper.User;
import main.ContextManager;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import support.Sensor;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(Parameterized.class)
public class ContextManagerTestCalculation {

    private int medicalType;
    private int [] tempThreshold;
    private int apoThreshold;
    private int clock;
    private String username;
    private String location;
    private int currentTemp;
    private int currentAqi;
    private int currentWeather;
    private boolean apoReach;
    private boolean tempReach;
    private int expectedResult;
    private SensorData sensorData;
    private User user;


    @Before
    public void init (){
        sensorData = new SensorData(username,location , currentTemp , currentAqi);
    }

    public ContextManagerTestCalculation(int medicalType, int[] tempThreshold, int apoThreshold, int clock, String username, String location, int currentTemp, int currentAqi, int currentWeather, boolean apoReach, boolean tempReach , int expectedResult) {
        this.medicalType = medicalType;
        this.tempThreshold = tempThreshold;
        this.apoThreshold = apoThreshold;
        this.clock = clock;
        this.username = username;
        this.location = location;
        this.currentTemp = currentTemp;
        this.currentAqi = currentAqi;
        this.currentWeather = currentWeather;
        this.apoReach = apoReach;
        this.tempReach = tempReach;
        this.expectedResult = expectedResult;
    }


    // The change here is medical condition type and aqi
    @Parameterized.Parameters
    public static Collection data () {
        List<Integer> medicalType = new ArrayList<>();

        return Arrays.asList(new Object[] [] {
                {1 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 100 , 1 , true, true , 15 },
                {2 , new int[] {30} , 0 , 20 , "Jack" , "C" , 10 , 100 , 1 , true, true , 30 },
                {3 , new int[] {30} , 0 , 20 , "Jack" , "C" , 10 , 100 , 1 , true, true , 45},
                {1 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 0 , 1 , true, true , 30},
                {1 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 1 , 1 , true, true , 30},
                {1 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 50 , 1 , true, true , 30},
                {1 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 51 , 1 , true, true , 15},
                {1 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 100 , 1 , true, true , 15},
                {1 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 101 , 1 , true, true , 10},
                {1 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 150 , 1 , true, true , 10},
                {1 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 151 , 1 , true, true , 5},
                {1 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 200 , 1 , true, true , 5},
                {1 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 201 , 1 , true, true , "invalid"},
                {2 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 0 , 1 , true, true , 60},
                {2 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 1 , 1 , true, true , 60},
                {2 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 50 , 1 , true, true , 60},
                {2 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 51 , 1 , true, true , 30},
                {2 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 100 , 1 , true, true , 30},
                {2 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 101 , 1 , true, true , 20},
                {2 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 150 , 1 , true, true , 20},
                {2 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 151 , 1 , true, true , 10},
                {2 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 200 , 1 , true, true , 10},
                {2 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 201 , 1 , true, true , "invalid"},
                {3 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 0 , 1 , true, true , 90},
                {3 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 1 , 1 , true, true , 90},
                {3 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 50 , 1 , true, true , 90},
                {3 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 51 , 1 , true, true , 45},
                {3 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 100 , 1 , true, true , 45},
                {3 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 101 , 1 , true, true , 30},
                {3 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 150 , 1 , true, true , 30},
                {3 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 151 , 1 , true, true , 15},
                {3 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 200 , 1 , true, true , 15},
                {3 , new int[] {30} , 0 , 20 , "Jack" , "A" , 10 , 201 , 1 , true, true , "invalid"}
        });
    }


    @Test
    public void apoThresholdShouldBeCalculated () {
        System.out.println("-------------------------");
        System.out.println("Test calculating apo threshold");
        user = new User(medicalType , tempThreshold , apoThreshold , clock , sensorData ,currentWeather , apoReach , tempReach);
        System.out.println(user.medicalConditionType + " " + user.sensorData.aqi);
        assertEquals(expectedResult , ContextManager.calculateapoThreshhold(user));

        System.out.println("Expected threshold apo: " + expectedResult);
        System.out.println("Actual apo threshold: " + ContextManager.calculateapoThreshhold(user));
        System.out.println();
    }





}

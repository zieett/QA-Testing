package main.test.unit.contextManager;


import helper.SensorData;
import helper.User;
import main.ContextManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(Parameterized.class)
public class ContextManagerTestCheckApoReach {
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

    public ContextManagerTestCheckApoReach(int medicalType, int[] tempThreshold, int apoThreshold, int clock, String username, String location, int currentTemp, int currentAqi, int currentWeather, boolean apoReach, boolean tempReach , int expectedResult) {
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

    @Parameterized.Parameters
    public static Collection data () {
        List<Integer> medicalType = new ArrayList<>();

        return Arrays.asList(new Object[] [] {
                {1 , new int[] {30,10} , 40 , 20 , "Jack" , "A" , 5 , 100 , 1 , false, false , 15 },
                {2 , new int[] {30,10} , 40 , 45 , "Jack" , "C" , 10 , 100 , 1 , true, true , 30 },
                {3 , new int[] {30,15} , 40 , 40 , "Jack" , "C" , 20 , 100 , 1 , true, false , 45},
        });
    }

    @Test
    public void testCheckingApoReached () {
        System.out.println("-------------------------");
        System.out.println("Test checking apo reach");
        user = new User(medicalType , tempThreshold , apoThreshold , clock , sensorData ,currentWeather , apoReach , tempReach);

        assertEquals(apoReach , ContextManager.checkapoReached(user));
        System.out.println("Expected output: " + apoReach);
        System.out.println("Actual output: " +ContextManager.checkapoReached(user));
        System.out.println();

    }

    @Test
    public void testTickingClock () {
        System.out.println("-------------------------");
        System.out.println("Test ticking clock ");
        user = new User(medicalType , tempThreshold , apoThreshold , clock , sensorData ,currentWeather , apoReach , tempReach);
        LinkedHashMap<String , User> userLinkedHashMap = new LinkedHashMap<>();
        userLinkedHashMap.put(username , user);
        ContextManager.users = userLinkedHashMap;
        ContextManager.tickClock(username);
        assertEquals(clock + 1 , user.clock);
        System.out.println("Expected output: " + (clock + 1));
        System.out.println("Actual output: " +user.clock);
        System.out.println();

    }

    @Test
    public void testResettingClock () {
        System.out.println("-------------------------");
        System.out.println("Test reseting clock ");
        user = new User(medicalType , tempThreshold , apoThreshold , clock , sensorData ,currentWeather , apoReach , tempReach);
        LinkedHashMap<String , User> userLinkedHashMap = new LinkedHashMap<>();
        userLinkedHashMap.put(username , user);
        ContextManager.users = userLinkedHashMap;
        ContextManager.resetClock(username);
        clock = 0;
        assertEquals(clock  , user.clock);
        System.out.println("Expected output: " + clock );
        System.out.println("Actual output: " +user.clock);
        System.out.println();

    }

    @Test
    public void testCheckTempReached () {
        System.out.println("-------------------------");
        System.out.println("Test checking temp reach");
        user = new User(medicalType , tempThreshold , apoThreshold , clock , sensorData ,currentWeather , apoReach , tempReach);

        assertEquals(tempReach , ContextManager.checkTempReached(user));
        System.out.println("Expected output: " + tempReach);
        System.out.println("Actual output: " +ContextManager.checkTempReached(user));
        System.out.println();

    }


}

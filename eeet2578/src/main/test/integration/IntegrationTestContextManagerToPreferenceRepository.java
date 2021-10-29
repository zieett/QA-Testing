package main.test.integration;

import java.util.*;

import helper.ContextManagerWorker;
import helper.PreferenceRequest;
import main.ContextManager;
import main.LocationServer;
import main.PreferenceRepository;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import support.Preference;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

//@RunWith(Parameterized.class)
public class IntegrationTestContextManagerToPreferenceRepository {

    private static ContextManagerWorker CM_Worker;
    private String username;
    private int weather;
    private String value;
    private String suggest;


    @Before
    public void setUp() throws Exception {
        ContextManager.cityInfo = ContextManager.readCityInfo();
        PreferenceRepository.preferences = PreferenceRepository.readPreference();
        LocationServer.table = LocationServer.readConfig();

        username="Jack";

        ContextManager.communicator = com.zeroc.Ice.Util.initialize();
        ContextManager.iniPreferenceWorker();
        ContextManager.iniLocationMapper();
        ContextManager.iniWeatherAlarmWorker();
        ContextManager.runWeatherAlarm();
        ContextManager.setupContextManagerWorker();
        CM_Worker = new ContextManager.ContextManagerWorkerI();
        CM_Worker.addUser(username, null);
    }



    // Integration Test: Context Manager and Preference Repository
    @Test
    public void alertTemperatureShouldBeSent() {
        System.out.println("------------------------");
        System.out.println("Test Sending Temperature Alert: ");
        List<Preference> list = PreferenceRepository.readPreference();
        ContextManager cm = new ContextManager();
        PreferenceRequest request = new PreferenceRequest("Jack", 0, "30");
        // actual output from the PR
        String suggest = cm.preferenceWorker.getPreference(request);
        // assert the expected suggestion against the suggestion from the PR
        assertEquals("pool", suggest);
        System.out.println("Expected Result: " + "pool");
        System.out.println("Actual Result: " + suggest);
        System.out.println();
    }

    @Test
    public void alertTemperatureShouldNotBeSent1() {
        System.out.println("------------------------");
        System.out.println("Test Not Sending Temperature Alert (1): ");
        List<Preference> list = PreferenceRepository.readPreference();
        ContextManager cm = new ContextManager();
        PreferenceRequest request = new PreferenceRequest("Jack", 0, "15");
        // actual output from the PR
        String suggest = cm.preferenceWorker.getPreference(request);
        // assert the expected suggestion against the suggestion from the PR
        assertEquals("", suggest);
        System.out.println("Expected Result: " + "");
        System.out.println("Actual Result: " + suggest);
        System.out.println();
    }

    @Test
    public void alertTemperatureShouldNotBeSent2() {
        System.out.println("------------------------");
        System.out.println("Test Not Sending Temperature Alert (2): ");
        List<Preference> list = PreferenceRepository.readPreference();
        ContextManager cm = new ContextManager();
        PreferenceRequest request = new PreferenceRequest("Jack", 0, "-1");
        // actual output from the PR
        String suggest = cm.preferenceWorker.getPreference(request);
        // assert the expected suggestion against the suggestion from the PR
        assertEquals("", suggest);
        System.out.println("Expected Result: " + "");
        System.out.println("Actual Result: " + suggest);

        request = new PreferenceRequest("Jack", 0, "15");
        // actual output from the PR
        suggest = cm.preferenceWorker.getPreference(request);
        // assert the expected suggestion against the suggestion from the PR
        assertEquals("", suggest);
        System.out.println("Expected Result: " + "");
        System.out.println("Actual Result: " + suggest);

        System.out.println();
    }


    @Test
    public void alertWeatherShouldBeSent() {
        System.out.println("------------------------");
        System.out.println("Test Sending Weather Alert: ");
        List<Preference> list = PreferenceRepository.readPreference();
        PreferenceRepository.preferences = list;
        ContextManager cm = new ContextManager();

        PreferenceRequest request = new PreferenceRequest("David", 1, "");

        String suggest = cm.preferenceWorker.getPreference(request);
        assertEquals("shops", suggest);
        System.out.println("Expected Result: " + "shops");
        System.out.println("Actual Result: " + suggest);
        System.out.println();
    }


    @Test
    public void alertTemperatureShouldNotBeSent() {
        System.out.println("------------------------");
        System.out.println("Test Sending Weather Alert: ");
        List<Preference> list = PreferenceRepository.readPreference();
        PreferenceRepository.preferences = list;
        ContextManager cm = new ContextManager();

        PreferenceRequest request = new PreferenceRequest("David", 1, "16");

        String suggest = cm.preferenceWorker.getPreference(request);
        assertEquals("shops", suggest);
        System.out.println("Expected Result: " + "shops");
        System.out.println("Actual Result: " + suggest);
        System.out.println();
    }

    @Test
    public void alertAPOShouldNotBeSent() {
        System.out.println("------------------------");
        System.out.println("Test Sending Weather Alert: ");
        List<Preference> list = PreferenceRepository.readPreference();
        PreferenceRepository.preferences = list;
        ContextManager cm = new ContextManager();

        PreferenceRequest request = new PreferenceRequest("David", 1, "APO");

        String suggest = cm.preferenceWorker.getPreference(request);
        assertEquals("shops", suggest);
        System.out.println("Expected Result: " + "shops");
        System.out.println("Actual Result: " + suggest);
        System.out.println();
    }

    @Test
    public void alertWeatherShouldNotBeSent1() {
        System.out.println("------------------------");
        System.out.println("Test Not Sending Weather Alert (1): ");
        List<Preference> list = PreferenceRepository.readPreference();
        PreferenceRepository.preferences = list;
        ContextManager cm = new ContextManager();

        PreferenceRequest request = new PreferenceRequest("Jack", 0, "");

        String suggest = cm.preferenceWorker.getPreference(request);
        assertEquals(null, suggest);
        System.out.println("Expected Result: " );
        System.out.println("Actual Result: " + suggest);
        System.out.println();
    }

    @Test
    public void alertWeatherShouldNotBeSent2() {
        System.out.println("------------------------");
        System.out.println("Test Not Sending Weather Alert (2): ");
        List<Preference> list = PreferenceRepository.readPreference();
        PreferenceRepository.preferences = list;
        ContextManager cm = new ContextManager();

        PreferenceRequest request = new PreferenceRequest("Jack", -1, "");

        String suggest = cm.preferenceWorker.getPreference(request);
        assertEquals(null, suggest);
        System.out.println("Expected Result: " + "null");
        System.out.println("Actual Result: " + suggest);
        System.out.println();
    }

    @Test
    public void alertAPOShouldBeSent() {
        System.out.println("------------------------");
        System.out.println("Test Sending APO Alert: ");
        List<Preference> list = PreferenceRepository.readPreference();
        PreferenceRepository.preferences = list;
        ContextManager cm = new ContextManager();

        PreferenceRequest request = new PreferenceRequest(username, 0, "APO");
        String suggest = cm.preferenceWorker.getPreference(request);
        assertEquals("cinema", suggest);
        System.out.println("Expected Result: " + "cinema");
        System.out.println("Actual Result: " + suggest);
        System.out.println();
    }



    @After
    public void tearDown() {
        ContextManager.communicator.shutdown();
    }
}


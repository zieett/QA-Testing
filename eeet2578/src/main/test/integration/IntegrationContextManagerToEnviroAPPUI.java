package main.test.integration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import com.zeroc.Ice.Current;
import helper.ContextManagerWorker;
import helper.PreferenceRequest;
import helper.SensorData;
import main.ContextManager;
import main.LocationServer;
import main.PreferenceRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import support.Preference;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IntegrationContextManagerToEnviroAPPUI {

    private static ContextManagerWorker CM_Worker;
    private static String username;
    private String results ;
    private String items;
    private String location;

    @Before
    public void setUpBeforeClass() throws Exception {
        ContextManager.cityInfo = ContextManager.readCityInfo();
        PreferenceRepository.preferences = PreferenceRepository.readPreference();
        LocationServer.table = LocationServer.readConfig();
        username = "Jack";// These setup can be found in the ConTextManager.java module
        ContextManager.communicator = com.zeroc.Ice.Util.initialize();
        ContextManager.iniPreferenceWorker();
        ContextManager.iniLocationMapper();
        ContextManager.iniWeatherAlarmWorker();
        ContextManager.runWeatherAlarm();
        ContextManager.setupContextManagerWorker();
        CM_Worker = new ContextManager.ContextManagerWorkerI();
        CM_Worker.addUser(username, null);
    }

    public IntegrationContextManagerToEnviroAPPUI (String results , String items , String location){
        this.results = results;
        this.items = items;
        this.location = location;
    }

    @Parameterized.Parameters
    public static Collection data () {
        List<String> results = new ArrayList<>();
        results.add("Indooroopilly Shopping Centre is a major regional shopping centre in the western suburb of Indooroopilly, Brisbane, Queensland, Australia. It is the largest shopping centre in the western suburbs of Brisbane, by gross area, and contains the only Myer store in that region.");
        results.add("Garden City Shopping Centre is located 10km South of the Brisbane central business district (CBD) and includes Myer, David Jones, Hoyts Cinema, Freedom and over 230 specialty stores.");
        results.add("The South Bank Parklands area was created as part of the rejuvenation of the industrial waterfront undertaken for World Expo 1988. The Parklands area contains many shops, a cinema complex, and a large number of restaurants as well as the man-made beach, A river promenade stretches the length of South Bank Parklands");
        results.add("The Brisbane central business district (CBD), or ‘the City’ is located on a point on the northern bank of the Brisbane River. The triangular shaped area is bounded by the Brisbane River to the east, south and west. The point, known at its tip as Gardens Point, slopes upward to the north-west where ‘the city’ is bounded by parkland and the inner-city suburb of Spring Hill to the north. The City is bounded to the north-east by the suburb of Fortitude Valley.");


        List<String> items = new ArrayList<>();
        items.add("Indooroopilly Shopping Centre");
        items.add("Garden City");
        items.add("South Bank Parklands");
        items.add("Brisbane City");
        items.add("Melbourne central");

        List<String> locations = new ArrayList<>();
        locations.add("A");
        locations.add("B");
        locations.add("C");
        locations.add("D");

        return Arrays.asList(new Object[][] {
                {results.get(0) , items.get(0) , locations.get(0)},
                {results.get(1) , items.get(1), locations.get(1)},
                {results.get(2) , items.get(2), locations.get(2)},
                {results.get(3) , items.get(3), locations.get(3)},
                {results.get(3) , items.get(4), ""},
        });
    }

    @Test
    public void testSearchingInfo () {
        System.out.println("---------------");
        System.out.println("Test searching info");

        assertEquals(results ,
                CM_Worker.searchInfo(items, new Current()));
        System.out.println("Expected output: " +results);
        System.out.println("Actual output: " +CM_Worker.searchInfo(items, new Current()));

    }

    @Test
    public void testSearchItems () {
        System.out.println("--------------------");
        System.out.println("Test searching items");
        ContextManager.users.get(username).sensorData = new SensorData(username , location , 15 , 1);
        assertArrayEquals(new String[]{items} , CM_Worker.searchItems(username,new Current()));
        System.out.println("Expected result: " + new String[]{items}[0]);
        System.out.println("Actual result: " + CM_Worker.searchItems(username,new Current())[0] );
        System.out.println();
    }

    @After
    public void tearDown () {
        ContextManager.communicator.shutdown();
    }



}

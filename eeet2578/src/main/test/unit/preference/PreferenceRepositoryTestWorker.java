package main.test.unit.preference;

import com.zeroc.Ice.Current;
import helper.PreferenceRequest;
import main.PreferenceRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import support.Preference;

import static org.junit.jupiter.api.Assertions.*;

public class PreferenceRepositoryTestWorker {

    private PreferenceRepository.PreferenceWorkerI preferenceWorkerI = new  PreferenceRepository.PreferenceWorkerI();

    @Before
    public void init () {
        PreferenceRepository.preferences = PreferenceRepository.readPreference();
        String arg [] = new String[] {};
        PreferenceRepository.setupPreferenceWorker(arg);

    }

    @Test
    public void userInfoShouldBeGot (){

        System.out.println("------------------------");
        System.out.println("Test user info should be got");
        assertEquals(1 , preferenceWorkerI.getUserInfo("Jack" , new Current()).medicalConditionType);
        System.out.println("Expected result: 1");
        System.out.println("Actual result: " + preferenceWorkerI.getUserInfo("Jack" , new Current()).medicalConditionType);
        System.out.println();

        System.out.println("------------------------");
        System.out.println("Test user info should be got");
        assertEquals( 3, preferenceWorkerI.getUserInfo("David" , new Current()).toString());
        System.out.println("Expected result: 3");
        System.out.println("Actual result: " + preferenceWorkerI.getUserInfo("David" , new Current()));
        System.out.println();
    }

    @Test
    public void preferenceShouldBeGot (){

        System.out.println("----------------------");
        System.out.println("Test preference should be got");
        assertEquals("cinema",preferenceWorkerI.getPreference(new PreferenceRequest("Jack",0 , ""), new Current()));

        System.out.println("Expected result:  cinema" );
        System.out.println("Actual result: " + preferenceWorkerI.getPreference(new PreferenceRequest("Jack",0 , ""), new Current()));
        System.out.println();

        System.out.println("----------------------");
        System.out.println("Test preference should be got");
        assertEquals("cinema",preferenceWorkerI.getPreference(new PreferenceRequest("Jack",1 , ""), new Current()));


        System.out.println("Expected result:  cinema" );
        System.out.println("Actual result: " + preferenceWorkerI.getPreference(new PreferenceRequest("Jack",1 , ""), new Current()));
        System.out.println();

    }

    @Test
    public void preferenceShouldBeGotBasedOnApo (){
        System.out.println("----------------------");
        System.out.println("Test preference should be got");
        assertEquals("cinema",preferenceWorkerI.getPreference(new PreferenceRequest("Jack",0 , "APO"), new Current()));

        System.out.println("Expected result:  cinema" );
        System.out.println("Actual result: " + preferenceWorkerI.getPreference(new PreferenceRequest("Jack",0 , "APO"), new Current()));
        System.out.println();
    }

    @Test
    public void preferenceShouldBeGotBasedOnTemp (){
        System.out.println("----------------------");
        System.out.println("Test preference should be got");
        assertEquals("pool",preferenceWorkerI.getPreference(new PreferenceRequest("Jack",0 , "30"), new Current()));

        System.out.println("Expected result:  pool" );
        System.out.println("Actual result: " + preferenceWorkerI.getPreference(new PreferenceRequest("Jack",0 , "30"), new Current()));
        System.out.println();



    }

    @Test
    public void preferenceShouldNotBeGotBasedOnTemp (){
        System.out.println("----------------------");
        System.out.println("Test preference should be got");
        assertEquals("",preferenceWorkerI.getPreference(new PreferenceRequest("Jack",0 , "31"), new Current()));

        System.out.println("Expected result: " + "");
        System.out.println("Actual result: " + preferenceWorkerI.getPreference(new PreferenceRequest("Jack",0 , "31"), new Current()));
        System.out.println();
    }

    @After
    public void tearDown (){
        preferenceWorkerI.terminate(new Current());
    }
}

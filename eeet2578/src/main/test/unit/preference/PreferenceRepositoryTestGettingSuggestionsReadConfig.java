package main.test.unit.preference;


import main.PreferenceRepository;
import org.junit.Test;
import support.Preference;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PreferenceRepositoryTestGettingSuggestionsReadConfig {


    @Test
    public void testReadPreference() {

        System.out.println("-----------------------------");
        System.out.println("Test the reading preference file in Preference Repository class");
        List<Preference> expectedResult = new ArrayList<>();
        List<String> jackPreference = new ArrayList<>();
        jackPreference.add("name: Jack");
        jackPreference.add("Medical Condition Type: 1");
        jackPreference.add("pref: when 30 suggest pool");
        jackPreference.add("pref: when APO suggest cinema");
        jackPreference.add("pref: when weather suggest cinema");

        List<String> davidPreference = new ArrayList<>();
        davidPreference.add("name: David");
        davidPreference.add("Medical Condition Type: 3");
        davidPreference.add("pref: when 16 suggest pool");
        davidPreference.add("pref: when APO suggest cinema");
        davidPreference.add("pref: when weather suggest shops");


        expectedResult.add(new Preference(jackPreference));
        expectedResult.add(new Preference(davidPreference));

        assertEquals(expectedResult.toString() , PreferenceRepository.readPreference().toString());
        System.out.println("Expected output: " + expectedResult.toString());
        System.out.println("Actual output: " + PreferenceRepository.readPreference().toString());
    }


}

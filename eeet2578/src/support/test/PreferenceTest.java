package support.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import support.Preference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(Parameterized.class)
public class PreferenceTest {

    // Initialize all the tested parameter

    @Parameterized.Parameter(0)
    public String name ;

    @Parameterized.Parameter(1)
    public Integer medicalCondition;

    @Parameterized.Parameter(2)
    public List<String> suggestions;

    private Preference preference;

    // Set all the necessary data to test
    @Before
    public void initialize () {
        List<String> actualPreference = new ArrayList<>();
        actualPreference.add("name: " + name);
        actualPreference.add("Medical Condition Type: " + medicalCondition);
        for (String s : suggestions){
            actualPreference.add("pref: " + s);
        }

        preference = new Preference(actualPreference);
    }


    // Pass all the tested data
    @Parameterized.Parameters
    public static Collection<Object[]> data (){

        String name [] = {"Jack","David" , "Jeremy"};
        Integer medicalCondition [] = {2 , 3 , 1 };

        List<String> jackSuggestions = new ArrayList<>();
        jackSuggestions.add("when 20 suggest shops");
        jackSuggestions.add("when 30 suggest pool");
        jackSuggestions.add("when APO suggest bowling");
        jackSuggestions.add("when weather suggest cinema");

        List<String> davidSuggestions = new ArrayList<>();
        davidSuggestions.add("when 16 suggest pool");
        davidSuggestions.add("when APO suggest cinema");
        davidSuggestions.add("when weather suggest shops");

        List<String> jeremySuggestions = new ArrayList<>();
        jeremySuggestions.add("when 20 suggest cinema");
        jeremySuggestions.add("when APO suggest bowling");
        jeremySuggestions.add("when weather suggest shop");

        return Arrays.asList(new Object[][] {
                { name[0] , medicalCondition[0] ,jackSuggestions },
                {name[1] , medicalCondition[1] , davidSuggestions},

        });
    }

    // Test all the get methods first
    @Test
    public void nameShouldBeGot(){
        System.out.println("--------------------------");
        System.out.println("Test getting name method in Preference");
        assertEquals(preference.getName(), name );
        System.out.println("Actual output: " + preference.getName());
        System.out.println("Expected output: " + name);
        System.out.println();

    }

    @Test
    public void medicalConditionShouldBeGot () {
        System.out.println("--------------------------");
        System.out.println("Test getting medical condition method in Preference");
        assertEquals(preference.getMedicalCondition() , medicalCondition);
        System.out.println("Actual output: " +preference.getMedicalCondition());
        System.out.println("Expected output: " + medicalCondition);
        System.out.println();
    }

    @Test
    public void suggestionsShouldBeGot () {
        System.out.println("--------------------------");
        System.out.println("Test getting suggestions method in Preference");
        assertEquals(preference.getSuggestions() , suggestions);
        System.out.println("Actual output: " +preference.getSuggestions());
        System.out.println("Expected output: " + suggestions);
        System.out.println();
    }

    // Test all the set method
    @Test
    public void nameShouldBeSet () {
        System.out.println("--------------------");
        System.out.println("Test setting name in Preference");
        preference.setName("July");
        assertEquals("July",preference.getName()  );
        System.out.println("Actual output: " +preference.getName());
        System.out.println("Expected output: " + "July");
        System.out.println();
    }

    @Test
    public void medicalConditionShouldBeSet (){
        System.out.println("--------------------");
        System.out.println("Test setting medical condition in Preference");
        preference.setMedicalCondition(0);
        assertEquals(0,preference.getMedicalCondition());
        System.out.println("Actual output: " +preference.getMedicalCondition());
        System.out.println("Expected output: " + "0");
    }

    @Test
    public void suggestionsShouldBeSet () {
        System.out.println("--------------------");
        System.out.println("Test setting suggestions in Preference");
        List<String> newSuggestions = new ArrayList<>();
        newSuggestions.add("when 30 suggest cinema");
        newSuggestions.add("when APO suggest swimming");
        newSuggestions.add("when weather suggest bowling");

        preference.setSuggestions(newSuggestions);
        assertEquals(newSuggestions,preference.getSuggestions());
        System.out.println("Actual output: " +preference.getSuggestions().toString());
        System.out.println("Expected output: " + newSuggestions.toString());
        System.out.println();
    }
}
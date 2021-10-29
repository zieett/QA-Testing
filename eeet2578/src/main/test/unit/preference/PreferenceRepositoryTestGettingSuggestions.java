package main.test.unit.preference;

import main.PreferenceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import support.Preference;

import java.lang.reflect.Parameter;
import java.security.Policy;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(Parameterized.class)
public class PreferenceRepositoryTestGettingSuggestions {


    private String username;
    private String tempSuggestion;
    private String apoSuggestion;
    private String weatherSuggestion;
    private int temp;
    private int weather;

    public PreferenceRepositoryTestGettingSuggestions (String username , int temp,
                                                       int weather ,String tempSuggestion,
                                                       String apoSuggestion , String weatherSuggestion){
        this.username = username;
        this.tempSuggestion = tempSuggestion;
        this.apoSuggestion = apoSuggestion;
        this.weather = weather;
        this.weatherSuggestion = weatherSuggestion;
        this.temp = temp;
    }
    @Parameterized.Parameters
    public static Collection data () {

        return Arrays.asList(new Object[][] {
                {"Jack" , 30 , 0 , "pool" , "cinema" , null},
                {"Jack" , 30 , 1 , "pool", "cinema" , "cinema"},
                {"Jack" , 30 , 2 , "pool", "cinema" , "cinema"},
                {"Jack" , 30 , 3 , "pool", "cinema" , "cinema"},
                {"Jack" , 30 , 4 , "pool", "cinema" , "cinema"},
//                {"Jack" , 25 , 3 , null, "cinema" , "cinema"},
//                {"Jack" , 35 , 3 , null, "cinema" , "cinema"},
//                {"David" , 16 , 0 , "pool", "cinema" , null},
//                {"David" , 16 , 1 , "pool", "cinema" , "shops"},
//                {"David" , 16 , 2 , "pool", "cinema" , "shops"},
//                {"David" , 16 , 3 , "pool", "cinema" , "shops"},
//                {"David" , 10 , 3 , null, "cinema" , "shops"},
//                {"David" , 20 , 3 , null, "cinema" , "shops"}
        });
    }


    @Test
    public void testGettingSuggestionTemp () {
        System.out.println("------------------------");
        System.out.println("Test getting suggestion temperature of Preference Repository");
        List<Preference> preferences = PreferenceRepository.readPreference();
        PreferenceRepository.preferences = preferences;
        assertEquals(tempSuggestion , PreferenceRepository.getSuggestionTemp(username , temp));
        System.out.println("Expected output: " + tempSuggestion);
        System.out.println("Actual output: " +PreferenceRepository.getSuggestionTemp(username , temp) );
    }

    @Test
    public void testGettingSuggestionWeather () {
        System.out.println("------------------------");
        System.out.println("Test getting suggestion weather of Preference Repository");
        List<Preference> preferences = PreferenceRepository.readPreference();
        PreferenceRepository.preferences = preferences;
        assertEquals(weatherSuggestion , PreferenceRepository.getSuggestionWeather(username , weather));
        System.out.println("Expected output: " + weatherSuggestion);
        System.out.println("Actual output: " +PreferenceRepository.getSuggestionWeather(username , weather) );
    }

    @Test
    public void testGettingSuggestionAPO () {
        System.out.println("------------------------");
        System.out.println("Test getting suggestion temperature of Preference Repository");
        List<Preference> preferences = PreferenceRepository.readPreference();
        PreferenceRepository.preferences = preferences;
        assertEquals(apoSuggestion , PreferenceRepository.getSuggestionAPO(username ));
        System.out.println("Expected output:" + apoSuggestion);
        System.out.println("Actual output: " +PreferenceRepository.getSuggestionAPO(username) );
    }
}

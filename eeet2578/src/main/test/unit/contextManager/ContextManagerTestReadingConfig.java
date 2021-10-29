package main.test.unit.contextManager;

import helper.SensorData;
import helper.User;
import main.ContextManager;
import main.LocationServer;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import support.LocationDetails;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ContextManagerTestReadingConfig {

    private ContextManager actualContextManager;

    public ContextManagerTestReadingConfig() {
        actualContextManager = new ContextManager();
    }


    @Test
    public void testReadCityInfo () {
        System.out.println("------------------------");
        System.out.println("Test reading city info in Context Manager class");
//        ContextManager.ContextManagerWorkerI contextManagerWorkerI = new ContextManager.ContextManagerWorkerI();
        List<String> shoppingCentre = new ArrayList<>();
        shoppingCentre.add("name: Indooroopilly Shopping Centre");
        shoppingCentre.add("location: A");
        shoppingCentre.add("information: Indooroopilly Shopping Centre is a major regional shopping centre in the western suburb of Indooroopilly, Brisbane, Queensland, Australia. It is the largest shopping centre in the western suburbs of Brisbane, by gross area, and contains the only Myer store in that region.");
        shoppingCentre.add("services: cinema, restaurants, pool, shops");

        List<String> gardenCity = new ArrayList<>();
        gardenCity.add("name: Garden City");
        gardenCity.add("location: B");
        gardenCity.add("information: Garden City Shopping Centre is located 10km South of the Brisbane central business district (CBD) and includes Myer, David Jones, Hoyts Cinema, Freedom and over 230 specialty stores.");
        gardenCity.add("services: cinema, restaurants, pool, shops");

        List<String> southBank = new ArrayList<>();
        southBank.add("name: South Bank Parklands");
        southBank.add("location: C");
        southBank.add("information: The South Bank Parklands area was created as part of the rejuvenation of the industrial waterfront undertaken for World Expo 1988. The Parklands area contains many shops, a cinema complex, and a large number of restaurants as well as the man-made beach, A river promenade stretches the length of South Bank Parklands");
        southBank.add("services: restaurants, pool, shops, Ferris wheel");

        List<String> brisbaneCity = new ArrayList<>();
        brisbaneCity.add("name: Brisbane City");
        brisbaneCity.add("location: D");
        brisbaneCity.add("information: The Brisbane central business district (CBD), or ‘the City’ is located on a point on the northern bank of the Brisbane River. The triangular shaped area is bounded by the Brisbane River to the east, south and west. The point, known at its tip as Gardens Point, slopes upward to the north-west where ‘the city’ is bounded by parkland and the inner-city suburb of Spring Hill to the north. The City is bounded to the north-east by the suburb of Fortitude Valley.");
        brisbaneCity.add("services: restaurants, shops, market, bowling");

        List<LocationDetails> actualLocationDetails = new ArrayList<>();
        actualLocationDetails.add(new LocationDetails(shoppingCentre));
        actualLocationDetails.add(new LocationDetails(gardenCity));
        actualLocationDetails.add(new LocationDetails(southBank));
        actualLocationDetails.add(new LocationDetails(brisbaneCity));

        for (int i = 0 ; i < 4 ; i ++ ) {
            assertEquals(actualLocationDetails.get(i).getInfo(), ContextManager.readCityInfo().get(i).getInfo());
            System.out.println("Expected result: " + actualLocationDetails.get(i).getInfo() );
            System.out.println("Actual result: " + ContextManager.readCityInfo().get(i).getInfo() );
            System.out.println();
        }

    }



    @Test
    public void testReadMissingCityInfo () {
        System.out.println("------------------------");
        System.out.println("Test reading city info in Context Manager class");
//        ContextManager.ContextManagerWorkerI contextManagerWorkerI = new ContextManager.ContextManagerWorkerI();

        List<LocationDetails> actualLocationDetails = new ArrayList<>() ;
        assertEquals(actualLocationDetails , ContextManager.readCityInfo());
    }


}

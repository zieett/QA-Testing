package support.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import support.LocationDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(Parameterized.class)
public class LocationDetailsTest {

    private String name;
    private String location;
    private String info;
    private List<String> services;
    private List<String> data;
    private LocationDetails actualLocationDetail;
    // Create the constructor

    public LocationDetailsTest (String name, String location, String info , List<String> services , List<String> data ){
        this.name = name;
        this.location = location;
        this.info = info;
        this.services = services;
        this.data = data;
    }

    // Set up the data for every test case
    @Before
    public void initialize (){
        List<String> actualLocationDetails = new ArrayList<>();
        actualLocationDetails.add("name: " + name);
        actualLocationDetails.add("location: " +location);
        actualLocationDetails.add("information: "+info);
        String temp = "";
        for (String s : services) {
            temp += s + ",";
        }
        actualLocationDetails.add("services: " + temp);
        actualLocationDetail = new LocationDetails(actualLocationDetails);
    }

    // Create the parameter for testing
    @Parameterized.Parameters
    public static Collection<Object[]> data (){
        String name [] = {"Indooroopilly Shopping Centre","Garden City", "South Bank Parklands"
                , "Brisbane City"};

        String location [] = {"A" ,"B" ,"C" ,"D"};
        String info [] = {"Indooroopilly Shopping Centre is a major regional shopping centre in the western suburb of Indooroopilly, Brisbane, Queensland, Australia. It is the largest shopping centre in the western suburbs of Brisbane," +
                " by gross area, and contains the only Myer store in that region.",
                "Garden City Shopping Centre is located 10km South of th" +
                        "e Brisbane central business district (CBD) " +
                        "and includes Myer, David Jones, Hoyts Cinema, " +
                        "Freedom and over 230 specialty stores.",
                "The South Bank Parklands area was created as part" +
                        " of the rejuvenation of the industrial waterfront " +
                        "undertaken for World Expo 1988. " +
                        "The Parklands area contains many shops, " +
                        "a cinema complex, and a large number " +
                        "of restaurants as well as the man-made beach, " +
                        "A river promenade stretches the length of South Bank Parklands",
                "The Brisbane central business district (CBD), or ‘the City’ is located on a point on the northern bank of the Brisbane River. The triangular shaped area is bounded by the Brisbane River to the east, south and west. The point, known at its tip as Gardens Point, slopes upward to the north-west where ‘the city’ is bounded by parkland and the inner-city suburb of Spring Hill to the north. The City is bounded to the north-east by the suburb of Fortitude Valley."};

        List<String> shoppingCentreServices  = new ArrayList<>();
        shoppingCentreServices.add("cinema");
        shoppingCentreServices.add("restaurants");
        shoppingCentreServices.add("pool");
        shoppingCentreServices.add("shops");

        List<String> gardenServices = new ArrayList<>();
        gardenServices.add("cinema");
        gardenServices.add("restaurants");
        gardenServices.add("pool");
        gardenServices.add("shops");

        List<String> bankServices = new ArrayList<>();
        bankServices.add("restaurants");
        bankServices.add("pool");
        bankServices.add("shops");
        bankServices.add("Ferris wheel");

        List<String> brisbaneServices = new ArrayList<>();
        brisbaneServices.add("restaurants");
        brisbaneServices.add("shops");
        brisbaneServices.add("market");
        brisbaneServices.add("bowling");


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

        return Arrays.asList(new Object[][]{
                {name[0], location[0], info[0], shoppingCentreServices, shoppingCentre },
                {name[1], location[1] , info[1] , gardenServices, gardenCity},
                {name[2], location[2] , info[2],bankServices , southBank},
                {name[3], location[3] , info[3] , brisbaneServices , brisbaneCity}
        });
    }

    // Testing the name of the location detail for the get and set methods
    @Test
    public void nameShouldBeGot () {
        System.out.println("--------------------------------");
        System.out.println("Test get name in location detail");
        assertEquals(name, actualLocationDetail.getName());
        System.out.println("Expected output: " + name);
        System.out.println("Actual output: " +actualLocationDetail.getName());
        System.out.println();
    }

    @Test
    public void nameShouldBeSet() {
        System.out.println("-------------------------");
        System.out.println("Test set name in location detail");
        String name = "Jimmy";
        actualLocationDetail.setName(name);
        assertEquals(name, actualLocationDetail.getName() );
        System.out.println("Expected output: " +name);
        System.out.println("Actual output: " + actualLocationDetail.getName());
        System.out.println();
    }

    // Testing the location of the location detail for the get and set methods
    @Test
    public void locationShouldBeGot () {
        System.out.println("--------------------------------");
        System.out.println("Test get location in location detail");
        assertEquals(location, actualLocationDetail.getLocation());
        System.out.println("Expected output: " + location);
        System.out.println("Actual output: " +actualLocationDetail.getLocation());
        System.out.println();
    }

    @Test
    public void locationShouldBeSet() {
        System.out.println("-------------------------");
        System.out.println("Test setting location in location detail");
        String location = "Vivo";
        actualLocationDetail.setLocation(location);
        assertEquals(location, actualLocationDetail.getLocation() );
        System.out.println("Expected output: " +location);
        System.out.println("Actual output: " + actualLocationDetail.getLocation());
        System.out.println();
    }


    // Test the info with get and set functions
    @Test
    public void infoShouldBeGot () {
        System.out.println("--------------------------");
        System.out.println("Test getting information in location detail");

        assertEquals(info, actualLocationDetail.getInfo());
        System.out.println("Expected output: " + info);
        System.out.println("Actual output: " + actualLocationDetail.getInfo());
        System.out.println();
    }

    @Test
    public void infoShouldBeSet(){
        System.out.println("-------------------------");
        System.out.println("Test setting information in location detail");
        String info = "This is an interesting place";
        actualLocationDetail.setInfo(info);
        assertEquals(info, actualLocationDetail.getInfo() );
        System.out.println("Expected output: " +info);
        System.out.println("Actual output: " + actualLocationDetail.getInfo());
        System.out.println();
    }

    // Test the service with get and set methods
    @Test
    public void servicesShouldBeGot () {
        System.out.println("--------------------------");
        System.out.println("Test getting services in location detail");

        assertEquals(services, actualLocationDetail.getServices());
        System.out.println("Expected output: " + services.toString());
        System.out.println("Actual output: " + actualLocationDetail.getServices().toString());
        System.out.println();
    }

    @Test
    public void serviceShouldBeSet () {

        List<String> tempServices = new ArrayList<>();
        tempServices.add("restaurants");
        tempServices.add("shops");
        tempServices.add("bowling");

        System.out.println("-------------------------");
        System.out.println("Test setting information in location detail");
        actualLocationDetail.setServices(tempServices);
        assertEquals(tempServices, actualLocationDetail.getServices() );
        System.out.println("Expected output: " +tempServices.toString());
        System.out.println("Actual output: " + actualLocationDetail.getServices().toString());
        System.out.println();
    }

    @Test
    public void testConstructor() {
        System.out.println("-------------------------");
        System.out.println("Test the constructor");
        LocationDetails locationDetails = new LocationDetails(data);

        assertEquals(locationDetails.getInfo(), actualLocationDetail.getInfo());
        System.out.println("Expected output: " +info);
        System.out.println("Actual output: " + actualLocationDetail.getInfo());
        System.out.println();
    }

}
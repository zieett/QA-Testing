package main.test.unit.contextManager;


import main.ContextManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
@RunWith(Parameterized.class)
public class ContextManagerTestGetLocations {


    private String service;

    public ContextManagerTestGetLocations (String service){
        this.service = service;
    }

    @Parameterized.Parameters
    public static Collection data (){

        List<String> services = new ArrayList<>();
        services.add("pool");
        services.add("shops");
        services.add("cinema");
        services.add("restaurants");

        return Arrays.asList(new Object[] [] {
                {services.get(0)},
                {services.get(1)},
                {services.get(2)},
                {services.get(3)}
        });
    }

    @Test
    public void testGetLocationsByService(){

        System.out.println("-----------------------");
        System.out.println("Test getting locations by service in Context Manager");
        List<String> list = new ArrayList<>();
        list.add("Indooroopilly Shopping Centre, Garden City");
        String arr [] = new String[]{};
        ContextManager.communicator = com.zeroc.Ice.Util.initialize(arr);
        ContextManager.iniLocationMapper();
        ContextManager.cityInfo = ContextManager.readCityInfo();

        assertEquals(list.toString() , ContextManager.getLocationsByService(service).toString());
        System.out.println("Expected result: " + list.get(0));
        System.out.println("Actual result: " + ContextManager.getLocationsByService("pool"));
        System.out.println();
    }
}

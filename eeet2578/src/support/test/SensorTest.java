package support.test;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import support.Sensor;


import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(Parameterized.class)
public class SensorTest  {

    // Attribute of the sensor test
    private String username;
    private String type;
    private String value ;

    private LinkedHashMap<String, Integer> data;
    private Sensor actualSensor;


    @Before
    public void initialize () {
        actualSensor = new Sensor(username,type);
    }

    // Constructor of the sensor test
    public SensorTest (String name , String type , LinkedHashMap<String ,Integer> data ,String value ) {
        this.username = name ;
        this.type = type;
        this.data = data;
        this.value = value;
    }

    // Pass all the tested data
    @Parameterized.Parameters
    public static Collection<Object[]> data () {

        LinkedHashMap<String , Integer> davidLocationData = new LinkedHashMap<>();
        davidLocationData.put("A" , 1);
        davidLocationData.put("C" ,15);
        davidLocationData.put("D",14);

        LinkedHashMap<String , Integer> davidAQIData = new LinkedHashMap<>();
        davidAQIData.put("200",15);
        davidAQIData.put("90",11);

        LinkedHashMap<String , Integer> davidTemperatureData = new LinkedHashMap<>();
        davidTemperatureData.put("10",5);
        davidTemperatureData.put("25",3);
        davidTemperatureData.put("20",4);

        LinkedHashMap<String , Integer> jackLocationData = new LinkedHashMap<>();
        jackLocationData.put("A" , 20);
        jackLocationData.put("C" ,10);
        jackLocationData.put("B",20);
        jackLocationData.put("D",10);

        LinkedHashMap<String , Integer> jackAQIData = new LinkedHashMap<>();
        jackAQIData.put("30",10);
        jackAQIData.put("100",5);
        jackAQIData.put("81",10);
        jackAQIData.put("50" ,20);

        LinkedHashMap<String , Integer> jackTemperatureData = new LinkedHashMap<>();
        jackTemperatureData.put("32",10);
        jackTemperatureData.put("32",5);
        jackTemperatureData.put("38",19);
        jackTemperatureData.put("36",20);


        LinkedHashMap<String , Integer> jackMotionData = new LinkedHashMap<>();
        jackMotionData.put("12",1);
        jackMotionData.put("2",8);
        jackMotionData.put("3",1);
        jackMotionData.put("10",20);

        return Arrays.asList(new Object[][] {
                {"David", "Location", davidLocationData ,"A"},
                {"David", "AQI" , davidAQIData , "200"},
                {"David", "Temperature", davidTemperatureData , "10"},
                {"Jack", "Location", jackLocationData ,"A"},
                {"Jack", "AQI" , jackAQIData ,"30"},
                {"Jack", "Temperature", jackTemperatureData , "32"},
//                {"Jack", "Motion", jackTemperatureData , "32"}
        });
    }

    // Test all the getter methods for all the attribute
    @Test
    public void typeShouldBeGot(){
        System.out.println("---------------------");
        System.out.println("Test getting type of the Sensor");
//        assertEquals(actualSensor.getType(), type);

        System.out.println("Expected output: " + type );
        System.out.println("Actual output: " + actualSensor.getType());
        System.out.println();

    }

    @Test
    public void currentValueShouldBeGot () {
        System.out.println("--------------------");
        System.out.println("Test getting current value method in Sensor class for user " + username);
        String currentValue = actualSensor.getCurrentValue();
        assertEquals( value, currentValue  );
        System.out.println("Expected output: " + value);
        System.out.println("Actual output: " + currentValue);
        System.out.println();
    }


    @Test
    public void usernameShouldBeGot (){
        System.out.println("--------------------");
        System.out.println("Test getting username method in Sensor class");
        assertEquals(username, actualSensor.getUsername());
        System.out.println("Expected output: " + username);
        System.out.println("Actual output: " + actualSensor.getUsername());
        System.out.println();
    }

    @Test
    public void dataShouldBeGot(){
        System.out.println("--------------------");
        System.out.println("Test getting data method in Sensor class");
        assertEquals(actualSensor.getData(),data);
        System.out.println("Expected output: "+ data.toString());
        System.out.println("Actual output: " + actualSensor.getData().toString());
        System.out.println();
    }



    // Test all the setter methods
    @Test
    public void usernameShouldBeSet(){
        System.out.println("--------------------");
        System.out.println("Test setting username method in Sensor class");
        actualSensor.setUsername("Jimmy");
        assertEquals(actualSensor.getUsername() , "Jimmy");
        System.out.println("Expected output: Jimmy" );
        System.out.println("Actual output: " + actualSensor.getUsername());
        System.out.println();
    }

    @Test
    public void dataShouldBeSet () {
        System.out.println("--------------------");
        System.out.println("Test setting data method in Sensor class");
        LinkedHashMap<String , Integer> jimmyLocationData = new LinkedHashMap<>();
        jimmyLocationData.put("A" , 12);
        jimmyLocationData.put("C" ,20);
        jimmyLocationData.put("D",40);
        actualSensor.setData(jimmyLocationData);
        assertEquals(actualSensor.getData(),jimmyLocationData);
        System.out.println("Expected output: " + jimmyLocationData);
        System.out.println("Actual output: " +actualSensor.getData());
        System.out.println();
    }

    @Test
    public void typeShouldBeSet (){
        System.out.println("--------------------");
        System.out.println("Test type setting method in Sensor class");
        String type = "Environment";
        actualSensor.setType(type);
        assertEquals(actualSensor.getType() , type);
        System.out.println("Expected output: " +type);
        System.out.println("Actual output: " +actualSensor.getType());
        System.out.println();

    }

    // Test the private method
    @Test
    public void dataShouldBeReadByPrivateMethod (){
        System.out.println("--------------------");
        System.out.println("Test reading data method in Sensor class for user " + username + " with " + type + " sensor");
        try {
            Method method = Sensor.class.getDeclaredMethod("readData");
            method.setAccessible(true);
            //assertThrows(FileNotFoundException.class, () -> method.invoke(actualSensor));
            assertEquals(data , method.invoke(actualSensor));
            System.out.println("Expected output: "+ data.toString());
            System.out.println("Actual output: " + method.invoke(actualSensor).toString());
            System.out.println();
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }


}
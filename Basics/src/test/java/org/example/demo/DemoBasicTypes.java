package org.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class DemoBasicTypes {

    @Test
    void demoText(){
        String city = "Nantes";
        System.out.println(city);

        // Java 11: List.of
        List<String> cities = List.of("Pau", "Nantes", "Toulouse", "Vallet");
        System.out.println(cities);

        String aCity = cities.get(0);
        System.out.println("First city: " + aCity);

        System.out.println();
        cities.forEach(System.out::println);

        System.out.println();
        for (String oneCity: cities){
            System.out.println(oneCity);
        }

        System.out.println();
        for (String oneCity: cities){
            System.out.println("City: " + oneCity);
            System.out.println("City (upper): " + oneCity.toUpperCase());
            System.out.println("Nb of letters: " + oneCity.length());
            System.out.println("First 2 letters: " + oneCity.substring(0, 2));
            System.out.println(MessageFormat.format(
                    "The city {0} has {1} letters. Uppercase name : {2}.",
                    oneCity,
                    oneCity.length(),
                    oneCity.toUpperCase()
            ));
            System.out.println();
        }
    }

    @Test
    void demoTextJava11(){
        var city0 = "Rennes";
        var cities = List.of("Pau", "Nantes", "Toulouse", "Vallet");
        for (var city: cities){
            System.out.println(city);
        }
    }

    @Test
    void demoNumbers(){
        // integers : short, int, long
        int nbPersons = 6;
        System.out.println("Number of persons: " + nbPersons);
        // floating numbers: float (32b), double (64b)
        double temperature = 25.3;
        System.out.println("Temperature: " + temperature);
        System.out.println("Temperature (x3): " + (temperature * 3));
        // booleans: true, false
        boolean hotTemperature = temperature >= 30.0;
        System.out.println("Is it hot or cold ? " + hotTemperature);
        // characters
        String city = "Nantes";
        char letter = city.charAt(0);
        System.out.println("1st letter: " + letter);
        char letter2 = 'ÿ';
        System.out.println("Y trema: " + letter2);
        String cityJp = "東京";
        System.out.println(cityJp.length());
        System.out.println(cityJp.charAt(0));
        // byte
        System.out.println(Arrays.toString(cityJp.getBytes()));
    }

    @Test
    void demoFloatingPrecision(){
        float priceF = 0.1f; // base 2 : 0.0001100110011001100110011001100....
        double priceD = 0.1;
        System.out.println(3 * priceF);
        System.out.printf("%.8f%n", 3 * priceF);
        System.out.println(3 * priceD);
    }

    @Test
    void demoPrimitiveAsObject(){
        // autoboxing : int <-> Integer
        List<Integer> numbers = List.of(12, 25, 33, 7, 125);
        for (int nb: numbers){
            System.out.println(nb);
        }
        // zoom
        int nbIn = 12;
        Integer nbObject = nbIn; // Integer.valueOf(nb);
        int nbOut = nbObject;    // nbObject.intValue();
    }

}

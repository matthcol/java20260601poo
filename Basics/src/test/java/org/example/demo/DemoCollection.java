package org.example.demo;

import org.example.utils.CsvTools;
import org.junit.jupiter.api.Test;

import java.text.Collator;
import java.text.MessageFormat;
import java.util.*;

public class DemoCollection {

    @Test
    void demoListOf(){
        List<String> names = List.of("Laura", "Lucas", "Cédric", "Mathilde", "Guillaume", "Matthias");
        System.out.println(names);
//        Collections.sort(names);
//        names.add("Jean");
        for (String name: names){
            System.out.println(name.toUpperCase());
        }

        List<String> upperNames = names.stream()
                .map(name -> name.toUpperCase())
                .toList();
        System.out.println(upperNames);

        System.out.println("Type 1st list: " + names.getClass());
        System.out.println("Type 2nd list: " + upperNames.getClass());

        List<String> modifiableNames = new ArrayList<>(names);
        modifiableNames.add("Jean");
        System.out.println(modifiableNames);
    }

    @Test
    void demoArrayList(){
        List<String> names = new ArrayList<>();
        Collections.addAll(names, "Laura", "Lucas", "Cédric", "Mathilde", "Guillaume", "Matthias");
        System.out.println(names);
        names.add("Jean");
        names.add(0, "Xavier");
        names.set(7, "Loïc");
        names.remove("Matthias");  // uses equals
        System.out.println(names);
        int index = names.indexOf("Loïc"); // uses equals
        System.out.println("Position de Loïc : " + index);
        Collections.sort(names);
        System.out.println(names);
        Collections.addAll(names, "Claude", "Lola");
        Collections.sort(names);
        System.out.println(names);
        System.out.println("Nb person: " + names.size());
        names.add("romain");
        Collections.sort(names);
        System.out.println(names);
        Collections.sort(names, String::compareToIgnoreCase);
        Collections.sort(names, (n1, n2) -> n1.compareToIgnoreCase(n2));
        System.out.println(names);

        Collator collator = Collator.getInstance(Locale.FRENCH);
        Collections.sort(names, collator);
        System.out.println(names);
    }

    @Test
    void demoEsp(){
        List<String> words = List.of("mano", "mañana", "matador");
        Collator collatorEs = Collator.getInstance(Locale.of("es", "ES"));
        List<String> sortedWords = words.stream()
                .sorted(collatorEs)
                .toList();
        System.out.println(sortedWords);
    }

    @Test
    void demoComparisonString(){
        String name1 = "Loïc";
        String name2 = "Loic";
        String name = name1;
        System.out.println(name == name1); // même adresse
        System.out.println(name.equals(name1));
        System.out.println(name1.equals(name2));
        System.out.println(name1.equalsIgnoreCase("loïc"));
        System.out.println(!name.equals(name1));
        System.out.println(name1.compareTo(name2) < 0); // interface Comparable
    }

    @Test
    void demoCollections(){
        List<String> cities = List.of("Nantes", "Saint-Aubin", "Pau", "Saint-Aubin", "Rennes");
        System.out.println(cities);
        Set<String> citySet = new HashSet<>(cities);
        System.out.println(citySet);
        NavigableSet<String> citySortedSet = new TreeSet<>(cities);
        System.out.println(citySortedSet);
        NavigableSet<String> citySortedSetFr = new TreeSet<>(Collator.getInstance(Locale.FRENCH));
        citySortedSetFr.addAll(cities);
        System.out.println(citySortedSetFr);
        Collections.addAll(citySortedSetFr, "Nîmes", "Nice", "Niort");
        System.out.println(citySortedSetFr);
    }

    @Test
    void demoMap(){
        Map<String,Integer> mapCityPopulation = Map.of(
                "Nantes", 500_000,
                "Pau", 77_000,
                "Saint-Aubin", 200
        );
        System.out.println(mapCityPopulation);

        Map<String,Integer> mapCityPopulation2 = new TreeMap<>(mapCityPopulation);
        mapCityPopulation2.put("Rennes", 220_000);
        System.out.println(mapCityPopulation2);

        System.out.println();
        for (String city: mapCityPopulation2.keySet()){
            System.out.println(city);
        }

        System.out.println();
        for (int population: mapCityPopulation2.values()){
            System.out.println(population);
        }

        System.out.println();
        for (Map.Entry<String,Integer> namePopulation: mapCityPopulation2.entrySet()){
            System.out.println(MessageFormat.format(
                    "City {0} has {1} people",
                    namePopulation.getKey(),
                    namePopulation.getValue()
            ));
        }

        mapCityPopulation2.forEach(
                (city, population) -> System.out.println(
                        MessageFormat.format(
                            "City {0} has {1} people",
                            city,
                            population
                        )
                )
        );
    }

    @Test
    void demoListMap(){
        List<Map<String, Object>> cityCharacteristics = List.of(
                Map.of(
                        "name", "Nantes",
                        "population", 500_000,
                        "department", "44"
                ),
                Map.of(
                        "name", "Pau",
                        "population", 77_000,
                        "department", "64"
                ),
                Map.of(
                        "name", "Calvi",
                        "population", 5_746,
                        "department", "2B"
                )
        );
        int info = (Integer) cityCharacteristics.get(2).get("population");
        System.out.println(info);
    }


    @Test
    void lireVille(){
        CsvTools.listFromCsv("/communes-france-2025.csv", ',','"', 1)
                .stream()
                .limit(10)
                .forEach(line -> System.out.println(Arrays.toString(line)));
    }











}

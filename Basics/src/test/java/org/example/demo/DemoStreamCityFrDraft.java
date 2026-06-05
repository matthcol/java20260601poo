package org.example.demo;

import org.example.model.Ville;
import org.example.utils.CsvTools;
import org.example.utils.VilleCsv;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DemoStreamCityFrDraft {

    @Test
    void demoReadCity(){
        List<String[]> cities = CsvTools.listFromCsv("/communes-france-2025.csv");
        System.out.println(cities.size());
        System.out.println(Arrays.toString(cities.get(0)));

        var infoCityList = cities.stream()
                .skip(20_000)
                .limit(5)
                .map(line -> Map.of(
                        "nom", line[2],
                        "code_postal", line[20],
                        "population", line[29]
                ))
                .peek(System.out::println)
                .toList();
        System.out.println(infoCityList);
    }

    @Test
    void demoVille(){
        var ville = Ville.builder()
                .nom("Nantes")
                .population(500_000)
                .codePostal("44000")
                .codeInsee("44109")
                .build();
        System.out.println(ville);
    }

    @Test
    void demoReadVilles(){
        List<Ville> villes = CsvTools.streamFromCsv("/communes-france-2025.csv")
                // .limit(10)
                .map(line -> VilleCsv.lineToVille(line))
                //.forEach(System.out::println);
                .toList();

        villes.stream()
                .filter(ville -> ville.getDepartement().equals("44"))
                .filter(ville -> ville.getPopulation() >= 10_000)
                .forEach(System.out::println);
    }



}

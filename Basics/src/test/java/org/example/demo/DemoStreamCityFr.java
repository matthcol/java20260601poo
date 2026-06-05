package org.example.demo;

import org.example.model.Ville;
import org.example.utils.CsvTools;
import org.example.utils.VilleCsv;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

public class DemoStreamCityFr {

    static List<Ville> villes;

    @BeforeAll
    static void loadVilles(){
        villes = CsvTools.streamFromCsv("/communes-france-2025.csv")
                .map(VilleCsv::lineToVille)
                .toList();
    }

    @Test
    void demoViewSomeVilles(){
        // afficher 10 villes au 'mileu' de la liste
        villes.stream()
                .skip(17_800)
                .limit(10)
                .forEach(System.out::println);
    }

    @ParameterizedTest
    @CsvSource({
            "44, 10_000",
            "44, 100_000",
            "44, 1_000_000",
            "64, 10_000",
            "64, 100_000"
    })
    void demoListVilleDepartementPopulation(String departement, int populationThreshold){
        var villesDepPopThreshold = villes.stream()
                .filter(ville -> ville.getDepartement().equals(departement))
                .filter(ville -> ville.getPopulation() >= populationThreshold)
                .toList();

        System.out.println(MessageFormat.format(
                "Département {0}, seuil population {1} :", departement, populationThreshold)
        );
        villesDepPopThreshold.forEach(System.out::println);
        System.out.println();
    }

    @ParameterizedTest
    @CsvSource({
            "44, 10_000",
            "44, 100_000",
            "44, 1_000_000",
            "64, 10_000",
            "64, 100_000"
    })
    void demoArrayListVilleDepartementPopulation(String departement, int populationThreshold){
        var villesDepPopThreshold = villes.stream()
                .filter(ville -> ville.getDepartement().equals(departement))
                .filter(ville -> ville.getPopulation() >= populationThreshold)
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(MessageFormat.format(
                "Département {0}, seuil population {1} :", departement, populationThreshold)
        );
        villesDepPopThreshold.forEach(System.out::println);
        System.out.println();
    }

    @ParameterizedTest
    @CsvSource({
            "44, 10_000",
            "44, 100_000",
            "44, 1_000_000",
            "64, 10_000",
            "64, 100_000"
    })
    void demoSortedSetNomVilleDepartementPopulation(String departement, int populationThreshold){
        var villesDepPopThreshold = villes.stream()
                .filter(ville -> ville.getDepartement().equals(departement))
                .filter(ville -> ville.getPopulation() >= populationThreshold)
                .map(ville -> ville.getNom())
                // .collect(Collectors.toCollection(() -> new TreeSet<>(comparatorVillePopulationDesc)));
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println(MessageFormat.format(
                "Département {0}, seuil population {1} :", departement, populationThreshold)
        );
        villesDepPopThreshold.forEach(System.out::println);
        System.out.println();
    }

    @ParameterizedTest
    @CsvSource({
            "44, 10_000",
            "44, 100_000",
            "44, 1_000_000",
            "64, 10_000",
            "64, 100_000"
    })
    void demoSortedSetVilleDepartementPopulation(String departement, int populationThreshold){
        Comparator<Ville> comparatorVillePopulationDesc = Comparator.comparingInt(Ville::getPopulation).reversed();
        var villesDepPopThreshold = villes.stream()
                .filter(ville -> ville.getDepartement().equals(departement))
                .filter(ville -> ville.getPopulation() >= populationThreshold)
                .collect(Collectors.toCollection(() -> new TreeSet<>(comparatorVillePopulationDesc)));

        System.out.println(MessageFormat.format(
                "Département {0}, seuil population {1} :", departement, populationThreshold)
        );
        villesDepPopThreshold.forEach(System.out::println);
        System.out.println();
    }

    @ParameterizedTest
    @CsvSource({
            "44, 10_000",
            "44, 100_000",
            "44, 1_000_000",
            "64, 10_000",
            "64, 100_000"
    })
    void demoNomVilleDepartementPopulation(String departement, int populationThreshold){
        Comparator<Ville> comparatorVillePopulationDesc = Comparator.comparingInt(Ville::getPopulation).reversed();
        var noms = villes.stream()
                .filter(ville -> ville.getDepartement().equals(departement))
                .filter(ville -> ville.getPopulation() >= populationThreshold)
                .sorted(comparatorVillePopulationDesc)
                .map(Ville::getNom)
                .collect(Collectors.joining(", "));
        System.out.println(noms);
    }

    // villes du departement ?, total population des 5 plus grandes villes (>= 10_000)
    @ParameterizedTest
    @ValueSource(strings = {"44", "64", "65"})
    void demoPopulationTop5Departement(String departement){
        int populationTop5 = villes.stream()
                .filter(ville -> ville.getDepartement().equals(departement))
                .filter(ville -> ville.getPopulation() >= 10_000)
                .sorted(Comparator.comparing(Ville::getPopulation).reversed())
                .limit(5)
                .mapToInt(Ville::getPopulation)
                .sum();
        System.out.println(populationTop5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"44", "64", "65", "99"})
    void demoAltitudeMoyDepartement(String departement){
        OptionalDouble optAverageAltitude = villes.stream()
                .filter(ville -> ville.getDepartement().equals(departement))
                .mapToInt(Ville::getAltitudeMaximale)
                .average();
        System.out.println("Moyenne altitude (optionnelle) :" + optAverageAltitude);

        if (optAverageAltitude.isPresent()){
            System.out.println("Moyenne altitude : " + optAverageAltitude.getAsDouble());
        }

        double averageAltitude = optAverageAltitude.orElse(Double.NaN);
        System.out.println("Moyenne altitude (or NaN) : " + averageAltitude);

        optAverageAltitude.ifPresentOrElse(
                altitudeMoyenne -> System.out.println("Moyenne altitude (func) : " + altitudeMoyenne),
                () -> System.out.println("Pas de données pour calculer la moyenne (func)")
        );

        averageAltitude = optAverageAltitude.orElseThrow(); // NB: on peut choisir son exception
        System.out.println("Moyenne altitude (or throws) : " + averageAltitude);
    }

    @Test
    void demoGroupByDepartement(){
        Map<String, List<Ville>> villesParDepartement = villes.stream()
                .filter(ville -> ville.getPopulation() < 10)
                .collect(Collectors.groupingBy(Ville::getDepartement));

        villesParDepartement.forEach(
                (dept, listeVille) -> {
                    System.out.println(" * département : " + dept);
                    listeVille.forEach(
                            ville -> System.out.println("     - " + ville)
                    );
                }
        );
    }

    @Test
    void demoGroupByDepartementSorted(){
        Map<String, SortedSet<Ville>> villesParDepartement = villes.stream()
                .filter(ville -> ville.getPopulation() < 30)
                .collect(Collectors.groupingBy(
                        Ville::getDepartement,
                        TreeMap::new, Collectors.toCollection(
                                () -> new TreeSet<>(
                                        Comparator.comparingInt(Ville::getPopulation)
                                                .thenComparing(Ville::getCodeInsee)
                                )
                        ))
                );

        villesParDepartement.forEach(
                (dept, listeVille) -> {
                    System.out.println(" * département : " + dept);
                    listeVille.forEach(
                            ville -> System.out.println("     - " + ville)
                    );
                }
        );
    }

    @Test
    void demoCityZeroHabitants(){
        long nb = villes.stream().filter(ville -> ville.getPopulation() == 0).count();
        System.out.println(nb);

        villes.stream().filter(ville -> ville.getPopulation() == 0).forEach(System.out::println);
    }

    @Test
    void demoGroupby(){
        var statsAltitudeParDept = villes.stream()
                .filter(ville -> ville.getAltitudeMaximale() > 0)
                .collect(Collectors.groupingBy(
                        Ville::getDepartement,
                        TreeMap::new,
                        Collectors.summarizingInt(Ville::getAltitudeMaximale)
                ));

        statsAltitudeParDept.forEach(
                (dept, stat) -> System.out.println(
                        MessageFormat.format("{0} : {1}", dept, stat)
                ));
    }
}

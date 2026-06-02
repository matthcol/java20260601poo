package org.example.demo;

import org.example.Euclide;
import org.example.enums.Famille;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.MessageFormat;

public class DemoOperatorComparisonLogic {

    @ParameterizedTest
    @ValueSource(doubles = {-1.0, 5.5, 12.75, 22.5, 30.0, 40.1})
    void demoIf(double temperature){
        System.out.println("Temperature: " + temperature);
        if (temperature < 10) {
            System.out.println("Ski");
        } else if (temperature < 20) {
            System.out.println("Course");
        } else {
            System.out.println("Natation");
        }
    }

    @ParameterizedTest
    @EnumSource(Famille.class)
    void demoSwitchCaseEnum21(Famille famille){
        double temperature = 20;
        System.out.println("Famille: " + famille);
        // Java 21 : pattern matching
        // https://docs.oracle.com/en/java/javase/21/language/pattern-matching-switch.html
        switch (famille){
            case VIANDE -> System.out.println("Faisons un BBQ");
            case FRUIT, LEGUME -> System.out.println("C'est bon pour la santé (6 par jour)");
            case PRODUIT_LAITIER -> System.out.println("Bon pour la croissance");
            default -> System.out.println("Autre cas");
        }
    }

    @ParameterizedTest
    @EnumSource(Famille.class)
    @NullSource
    void demoSwitchCaseEnumValue21(Famille famille){
        System.out.println("Famille: " + famille);
        // Java 21 : pattern matching
        // https://docs.oracle.com/en/java/javase/21/language/pattern-matching-switch.html
        double score = switch (famille){
            case VIANDE -> 12.5;
            case FRUIT, LEGUME -> 25.0;
            case PRODUIT_LAITIER -> 17.5;
            case POISSON -> 24.5;
            case null -> -1.0;
            default -> -2.0;
        };
        System.out.println("Score : " + score);
    }

    @ParameterizedTest
    @EnumSource(Famille.class)
    void demoSwitchCaseEnumClassic(Famille famille){
        System.out.println("Famille: " + famille);
        // NB: limité aux types primitifs, enums (Java 5), String (Java 7)
        switch (famille){
            case PRODUIT_LAITIER:
                System.out.println("Bon pour les os");
            case VIANDE:
            case POISSON:
                System.out.println("Bon pour la santé");
                break;
            case FRUIT:
            case LEGUME:
                System.out.println("6 par jour");
                break;
        }
    }

    @Test
    void demoEuclide(){
        int x = 21;
        int y = 15;
        int g = Euclide.gcd(x, y);
        System.out.println(MessageFormat.format(
                "Le pgcd de {0} et {1} est {2}",
                x, y, g
        ));
    }
}

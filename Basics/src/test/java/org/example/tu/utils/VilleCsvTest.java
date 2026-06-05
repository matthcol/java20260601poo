package org.example.tu.utils;

import org.example.model.Ville;
import org.example.utils.VilleCsv;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class VilleCsvTest {

    @Test
    void testLineToVille_departementStartsWith0(){
        // given
        String[] line = {
                "0","01001","L'Abergement-Clémenciat","Abergement-Clémenciat","à Abergement-Clémenciat",
                "de l'Abergement-Clémenciat","l-abergement-clemenciat",
                "L'ABERGEMENT-CLÉMENCIAT","COM","commune","84","Auvergne-Rhône-Alpes",
                "01","Ain","0108","Châtillon-sur-Chalaronne","200069193","CC de la Dombes","10",
                "Lyon","01400","01400","08405","01053","01000","","0.0","HORS UNITE URBAINE",
                "H","832","1565","16","53.0","242","206.0","272.0","46.151","4.921","46.153",
                "4.926","6","Rural à habitat dispersé","0.0","communes non pôle","",
                "https://fr.wikipedia.org/wiki/fr:L'Abergement-Clémenciat",
                "https://villedereve.fr/ville/01001-l-abergement-clemenciat"
        };

        // when
        Ville ville = VilleCsv.lineToVille(line);
        // then
        assertNotNull(ville);
        assertAll(
                () -> assertEquals("L'Abergement-Clémenciat", ville.getNom(), "nom"),
                () -> assertEquals("01", ville.getDepartement(), "departement"),
                () -> assertEquals(832, ville.getPopulation(), "population"),
                () -> assertEquals("01001", ville.getCodeInsee(), "codeInsee"),
                () -> assertEquals("01400", ville.getCodePostal(), "codePostal"),
                () -> assertEquals(16, ville.getSuperficie(), "superficie"),
                () -> assertEquals(272, ville.getAltitudeMaximale(), "altitudeMaximale")
        );
    }

    // version factorisée

    @ParameterizedTest(name = "{0}")
    @MethodSource("org.example.tu.utils.VilleCsvProvider#lineProvider")
    void testLineToVille(
            String[] line,
            String expectedNom,
            String expectedDepartement,
            String expectedCodeInsee,
            String expectedCodePostal,
            int expectedPopulation,
            int expectedSuperficie,
            int expectedAltitudeMaximale
    ){
        // when
        Ville ville = VilleCsv.lineToVille(line);
        // then
        assertNotNull(ville);
        assertAll(
                () -> assertEquals(expectedNom, ville.getNom(), "nom"),
                () -> assertEquals(expectedDepartement, ville.getDepartement(), "departement"),
                () -> assertEquals(expectedCodeInsee, ville.getCodeInsee(), "codeInsee"),
                () -> assertEquals(expectedCodePostal, ville.getCodePostal(), "codePostal"),
                () -> assertEquals(expectedPopulation, ville.getPopulation(), "population"),
                () -> assertEquals(expectedSuperficie, ville.getSuperficie(), "superficie"),
                () -> assertEquals(expectedAltitudeMaximale, ville.getAltitudeMaximale(), "altitudeMaximale")
        );
    }


}
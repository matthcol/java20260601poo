package org.example.tu.utils;

import org.example.model.Ville;
import org.example.utils.VilleCsv;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VilleCsvTest {

    @Test
    void testLineToVille(){
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
                () -> assertEquals(832, ville.getPopulation(), "population")
                // TODO: all other fields
        );

    }

}
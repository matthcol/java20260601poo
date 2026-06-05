package org.example.utils;

import org.example.annotations.Kingdoo;
import org.example.model.Ville;

public class VilleCsv {

    @Kingdoo
    public static Ville lineToVille(String[] line){
        return Ville.builder()
                .nom(line[2])
                .codePostal(line[20])
                .codeInsee(line[1])
                .departement(line[12])
                .population(Integer.parseInt(line[29]))
                .altitudeMaximale((int) Double.parseDouble(line[35]))
                .superficie(Integer.parseInt(line[31]))
                .build();
    }
}

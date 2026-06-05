package org.example.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString(of={"codePostal", "nom", "population"})
public class Ville {
    @NotBlank
    @Size(min = 5, max = 5)
    private String codeInsee;

    @NotBlank
    @Size(min = 5, max = 5)
    private String codePostal;

    @NotBlank
    private String nom;

    @NotBlank
    private String departement;

    @Min(value = 0, message = "population must be positive or zero")
    private int population;

    @Min(0)
    private int superficie;

    @Min(0)
    private int altitudeMaximale;
}

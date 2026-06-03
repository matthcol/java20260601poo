package org.example.model;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Person {
    private String name;
    private LocalDate birthdate;
}

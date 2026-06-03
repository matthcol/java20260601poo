package org.example.demo.model;

import org.example.model.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class DemoPerson {

    @Test
    void demoPerson(){
        Person p1 = new Person();
        p1.setName("Jennifer Connelly");
        Person p2 = new Person("Tom Cruise", LocalDate.of(1962, 7, 3));
        List<Person> persons = List.of(p1, p2);
        for (Person p: persons){
            System.out.println(p);
        }
    }
}

package org.example.demo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class DemoArrays {

    @Test
    void demoArray(){
        // static array
        int[] ages = {23, 45, 58, 33, 43};
        System.out.println("Nb of values: " + ages.length);
        System.out.println(ages.toString()); // [I@75334b31
        System.out.println(Arrays.toString(ages));
        Arrays.sort(ages);
        System.out.println(Arrays.toString(ages));
        System.out.println("1st number: " + ages[0]);
        // System.out.println("1st number: " + ages[123]); // ArrayIndexOutOfBoundsException
        ages[4] = 57;
        System.out.println(Arrays.toString(ages));

        System.out.println();
        for (int i = 0; i < ages.length; i++) {
            System.out.print(ages[i] + " ");
        }
        System.out.println();

        System.out.println();
        for (int age : ages) {
            System.out.print(age + " ");
        }
        System.out.println();

        Arrays.stream(ages)
                .limit(3)
                .forEach(System.out::println);
    }
}

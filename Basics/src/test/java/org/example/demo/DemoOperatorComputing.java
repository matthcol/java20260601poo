package org.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.MessageFormat;

public class DemoOperatorComputing {

    @Test
    void demoNumericOperatorInt(){
        // Operators: + - * / %
        // - operator int x int => int
        int nbPerson = 6;
        int nbKm = 35;
        int total = nbPerson * nbKm;
        System.out.println("Total km: " +total);

        int part = total / 7;
        System.out.println(part);

        part = total / 13;
        System.out.println(part);
        int r = total % 13;
        System.out.println(r);
    }

    @Test
    void demoOverflow(){
        int km = 2_000_000_000;
        int res = km * 2;
        System.out.println("Result with overflow: " + res); // -294967296
        System.out.println(MessageFormat.format(
                "min = {0} ; max = {1}",
                Integer.MIN_VALUE,
                Integer.MAX_VALUE
        ));
    }

    @Test
    void demoMixedTypes(){
        int km = 2_000_000_000;
        long res = km * 2L;
        System.out.println(res); // 4000000000

        // cast
        int res2 = (int) (res / 1_000_000);
        System.out.println(res2);

        // floating number and ints
        double res3 = 3.5f * 2E64 / 3;
        System.out.println(res3);

        res3 = Long.MAX_VALUE;
        System.out.println(res3);
        System.out.println(Long.MAX_VALUE);
    }

    @Test
    void demoSpecialFloatingNumbers(){
        double distance = 1E308;
        System.out.println(distance);
        distance *= 2; // distance = distance * 2;  // Infinity
        System.out.println(distance);

        double res = distance / distance; // Nan
        System.out.println(res);

        res = 5.5 / 0.0; // Infinity
        System.out.println(res);
    }

    @Test
    void demoDivisionByZeroInt(){
        Assertions.assertThrows(
                ArithmeticException.class,
                () -> {
                    int res = 5 / 0;
                });
        // java.lang.ArithmeticException: / by zero
    }

    @Test
    void demoShotcutOperator(){
        int cpt = 0;
        cpt++;
        ++cpt;
        cpt--;
        --cpt;
        cpt += 10;
        cpt -= 5;
        cpt *= 2;
        cpt /= 4;
        System.out.println(cpt);

        // don't do that !
        cpt = 5;
        int res = cpt++ + ++cpt - cpt-- * --cpt;
        System.out.println(cpt);

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    @Test
    void demoUnaryBinaryMinusPlus(){
        // binary operations
        int x = (3 + 4) - (4 + 5);
        int y = -x;
        int z = +y;
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }

    @Test
    void demoOperatorBigDecimal(){
        BigDecimal price = new BigDecimal("0.1");
        BigDecimal total = price.multiply(new BigDecimal(3));
        System.out.println(total);
        Assertions.assertEquals(new BigDecimal("0.3"), total);

        BigDecimal res = total.add(new BigDecimal(500))
                .multiply(new BigDecimal("3.333"))
                .divide(new BigDecimal(2), RoundingMode.CEILING)
                .subtract(new BigDecimal(4));

    }

    @Test
    void demoComputing(){
        double x = 5.5;
        // sqrt is a class method (static)
        double res = Math.sqrt(
                Math.PI * Math.pow(x, 2)
                + Math.pow(7, 2)
        );
        System.out.println(res);
    }

}

package org.example.algo;

public class Euclide {

    /**
     * Compute the greatest common divider (gcd) of 2 strictly positive integers
     * @param a 1st integer (>0)
     * @param b 2nd integer (>0)
     * @return the gcd
     * @throws IllegalArgumentException if a or b is negative or zero
     */
    public static int gcd(int a, int b) {
        if ((a <= 0)  || (b <= 0)) {
            throw new IllegalArgumentException("gcd is not defined with negative or null values");
        }
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

}

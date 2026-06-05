package org.example.tu.algo;

import org.example.algo.Euclide;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


class EuclideTest {

    // doc parameterized test:
    // https://docs.junit.org/6.1.0/writing-tests/parameterized-classes-and-tests.html

    @ParameterizedTest
    @CsvSource({
            "5, 5, 5",
            "9, 6, 3",
            "6, 9, 3",
            "7, 13, 1",
            "4, 16, 4",
            "252, 180, 36",
            "6765, 4181, 1"
    })
    void testGcd_ok(int a, int b, int expectedGcd) {
        int actualGcd = Euclide.gcd(a, b);
        assertEquals(expectedGcd, actualGcd);
    }


    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "0, 2",
            "2, 0",
            "-5, 4",
            "4, -5",
            "-10, -20"
    })
    void testGcd_ko(int a, int b) {
        assertTimeoutPreemptively(
                Duration.ofSeconds(2),
                () -> assertThrows(IllegalArgumentException.class, () -> Euclide.gcd(a, b))
        );
    }


}
package org.example.tu.algo;

import org.example.algo.Euclide;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


class EuclideTest {

    // doc parameterized test:
    // https://docs.junit.org/6.1.0/writing-tests/parameterized-classes-and-tests.html

    // @ParameterizedTest(name = "{0} : gcd({1}, {2}) = {3}")
    @ParameterizedTest(name = "{0}")
    @CsvSource({
            "same numbers, 5, 5, 5",
            "first greater, 9, 6, 3",
            "second greater, 6, 9, 3",
            "prime numbers, 7, 13, 1",
            "multiple of each other, 4, 16, 4",
            "big numbers, 252, 180, 36",
            "fibonacci series, 6765, 4181, 1"
    })
    void testGcd_ok(String label, int a, int b, int expectedGcd) {
        int actualGcd = Euclide.gcd(a, b);
        assertEquals(expectedGcd, actualGcd);
    }

    // alternative
//    @ParameterizedTest
//    @CsvFileSource(resources = "gcd_ok.csv", useHeadersInDisplayName = true)
    @ParameterizedTest(name = "{0}")
    @CsvFileSource(resources = "gcd_ok.csv", numLinesToSkip = 1)
    void testGcd_okAlt(String label, int a, int b, int expectedGcd) {
        int actualGcd = Euclide.gcd(a, b);
        assertEquals(expectedGcd, actualGcd);
    }

    // TODO: add label
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
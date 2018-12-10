package de.de.lambdas;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

public class Mersenne {
    static Stream<BigInteger> primes(){
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);

    }

    public static void main(String[] args ){
        primes().limit(5) .forEach(System.out::println);

        System.out.printf("Mersenne Numbers: %n");

        // Mersenne Numbers: 2^p - 2
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE)).
                filter(mersenne -> mersenne.isProbablePrime(50)).
                limit(10).
                forEach(System.out::println);
    }
}

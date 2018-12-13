package de.de.lambdas;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

public class PiPie {

    // Primzahlzählfunktion

    static long pi(long n) {
        return LongStream.rangeClosed(2, n).mapToObj(BigInteger::valueOf).filter(i -> i.isProbablePrime(50)).count();
    }

    static long piParallel(long n) {
        return LongStream.rangeClosed(2, n).parallel().mapToObj(BigInteger::valueOf).filter(i -> i.isProbablePrime(50)).count();
    }


    public static void main(String[] args) {
        Instant starts = Instant.now();
        System.out.println(pi(1000));
        Instant ends = Instant.now();
        System.out.println(Duration.between(starts, ends));
        starts = Instant.now();
        piParallel(pi(1000));
        ends = Instant.now();
        System.out.println(Duration.between(starts, ends));
    }
}
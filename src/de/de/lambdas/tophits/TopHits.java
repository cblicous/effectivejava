package de.de.lambdas.tophits;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;


import static java.util.Comparator.comparing;

import static java.util.function.BinaryOperator.maxBy;
import static java.util.stream.Collectors.toMap;

public class TopHits {

    @FunctionalInterface
    private interface TakeLast<T>  extends BinaryOperator<T>  {

        public static <T> BinaryOperator<T> overrideWithLast() {
            return (a, b) -> b;
        }


    }
    public static void main(String[] args) {

        List<Album> albums = new ArrayList<>();

        Artist queen = new Artist("Queen");
        Artist davidBowie = new Artist("David Bowie");
        albums.add( new Album.Builder("Made in Heaven").withArtist(queen).withSales(20000).build());
        albums.add( new Album.Builder("The Game").withArtist(queen).withSales(4582).build());
        albums.add( new Album.Builder("The Miracle").withArtist(queen).withSales(1325).build());
        albums.add( new Album.Builder("The Rise and Fall of Ziggy Stardust and the Spiders from Mars").withArtist(davidBowie).withSales(1325).build());

        Map<Artist,Album> hitsMap = albums.stream().collect(toMap(Album::getArtist,album -> album,TakeLast.overrideWithLast()));
        hitsMap.forEach((artist, album) -> System.out.printf("%s , %s %n", artist.getName(),album.getName()));

       System.out.printf("------- %n");

        Map<Artist,Album> topHits = albums.stream().collect(
                toMap(Album::getArtist, album -> album,
                        maxBy(comparing(Album::getSales))));

        topHits.forEach((artist, album) -> System.out.printf("%s , %s %n", artist.getName(),album.getName()));

    }

}
package de.plants;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public class PlantsMain {
    public static void main(String[] args) {

        List<Plant> garden = new ArrayList<Plant>();
        Plant plant1 = new Plant("tulip", Plant.LifeCycle.PERENNIAL);
        garden.add(plant1);
        Plant plant2 = new Plant("rose", Plant.LifeCycle.BIENNIAL);
        garden.add(plant2);
        Plant plant3 = new Plant("lilly", Plant.LifeCycle.ANNUAL);
        garden.add(plant3);
        Plant plant4 = new Plant("jasmin", Plant.LifeCycle.ANNUAL);
        garden.add(plant4);


        // shitty way
        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
        for (int i = 0; i< plantsByLifeCycle.length; i++)
            plantsByLifeCycle[i] = new HashSet<>();

        for (Plant p : garden)
            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);

        for(int i = 0; i<plantsByLifeCycle.length; i++){
            System.out.printf("%s : %s%n ", Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }


        // better way
        EnumMap<Plant.LifeCycle, Set<Plant>> result = garden.stream().collect(groupingBy(p -> p.lifeCycle, () -> new EnumMap<>(Plant.LifeCycle.class), toSet()));
        result.entrySet().stream().forEach(p -> System.out.println(p));
    }
}

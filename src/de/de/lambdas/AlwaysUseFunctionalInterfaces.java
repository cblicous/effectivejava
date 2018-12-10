package de.de.lambdas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class AlwaysUseFunctionalInterfaces {
    public static void main(String[] args) {

        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("John", 40000);
        salaries.put("Freddy", 30000);
        salaries.put("Samuel", 50000);

        TwoInputsOneResultFunction<String,Integer,Integer> ownInterface = (name, oldValue) -> {
            if (name.equals("Freddy")){
                return oldValue + 1000;
            }
            return oldValue;
        };

        BiFunction<String,Integer,Integer> adjustFreddiesIncomeBiFunction = (name, oldValue) -> {
            if (name.equals("Freddy")){
                return oldValue + 1000;
            }
            return oldValue;
        };
        salaries.replaceAll(adjustFreddiesIncomeBiFunction);

        System.out.printf("Freddies Salary %s  %n",     salaries.get("Freddy"));

    }

}

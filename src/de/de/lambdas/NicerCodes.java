package de.de.lambdas;

import java.util.HashMap;
import java.util.Map;

public class NicerCodes {

    public static Integer doStuff(Integer a , Integer b) {
        return a + b;
    }
    public static void main(String[] args) {
        Map<String, Integer> integerMap = new HashMap<String,Integer>();
        integerMap.put("test",5);
        integerMap.put("bla",4);
        integerMap.put("blubb",7);

        String key = "test";
        Integer result = integerMap.merge(key, 1, (count, incr) -> count + incr);
        System.out.printf("Result %s , in map %s %n",result, integerMap.get("test"));
        // way shorter and better
         result = integerMap.merge(key,1,NicerCodes::doStuff);
        System.out.printf("Result %s , in map %s %n",result, integerMap.get("test"));

    }
}

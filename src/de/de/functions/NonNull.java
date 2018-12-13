package de.de.functions;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.ObjIntConsumer;

public class NonNull {

    private class Combiner implements BiConsumer<StringBuilder,StringBuilder> {

        @Override
        public void accept(StringBuilder stringBuilder, StringBuilder stringBuilder2) {
            stringBuilder.insert(0,stringBuilder2);
        }
    }


    private class Reverser implements ObjIntConsumer<StringBuilder> {

        @Override
        public void accept(StringBuilder stringBuilder, int singleChar) {
            stringBuilder.insert(0,(char)singleChar);
        }
    }

    public  String reverse(String string) {
        Objects.requireNonNull(string);
        return string.chars()
                .collect(StringBuilder::new, new Reverser(),new Combiner())
                .toString();
    }

    public static void main(String[] args) {
        NonNull reverser = new NonNull();
        String reverse = "1234";
        String nullString = null;
        System.out.println("Reverse " + reverser.reverse(reverse));
        System.out.println("Null " + reverser.reverse(nullString));
    }

}

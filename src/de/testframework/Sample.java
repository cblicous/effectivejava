package de.testframework;

public class Sample {
    @Test(ArithmeticException.class) public static void m1() {
        int i = 0;
        i = i/i;
    }
    public static void m2(){

    }
    @Test(ArithmeticException.class) public static void m3(){
        throw new RuntimeException("whops");
    }


}

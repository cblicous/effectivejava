package de.testframework;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests {

    public static void main(String[] args ) throws Exception{
        int passedTests = 0;
        int tests = 0;


        Class<?> testClass = Class.forName("de.testframework.Sample");
        for ( Method m : testClass.getDeclaredMethods()) {
            if(m.isAnnotationPresent(Test.class)){
                tests++;
                try {
                    m.invoke(null);

                } catch (InvocationTargetException ex){
                    Throwable exc = ex.getCause();
                    Class<? extends Throwable> execType =
                            m.getAnnotation(Test.class).value();
                    if(execType.isInstance(exc)){
                        passedTests ++;
                    } else {
                        System.out.println(m + " failed:" + exc +" expected "+execType);
                    }
                } catch (Exception ex) {
                    System.out.println("Invalid @Test: " + m);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passedTests,tests -passedTests);
    }
}

package de.de.lambdas;


@FunctionalInterface
public interface TwoInputsOneResultFunction<T, U, R> {

    R apply(T t, U u);


}

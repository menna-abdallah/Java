package Interfaces;

import java.util.List;
import java.util.function.Function;

//public interface MyInterface extends Function<Double, Double> {
public interface MyInterface{
    Double apply( List<Double> l);
}

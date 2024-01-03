package Interfaces;

import java.util.List;
import java.util.function.Function;

public class Equation implements MyInterface {
    //@Override
    public Double apply(List<Double> l) {
        Double root = 0.0;
        // Ensure the list has at least three elements
        if (l.size() < 3) {
            System.out.println("There are three operants for Quadratic Equation  ( a ,b ,c )" + "\n"
                    + "Enter 0 if any of them does not exist");
        } else if (l.size() > 3) {
            System.out.println("There are only three operants for Quadratic Equation  ( a ,b ,c ");
        } else {
            // get operants
            Double a = l.get(0);
            Double b = l.get(1);
            Double c = l.get(2);

            root = (b * b) - 4 * (a * c);

        }

        return root;
    }

    @Override
    public Double apply(Double value) {
        // Implement the transformation logic if needed
        return value;
    }

}

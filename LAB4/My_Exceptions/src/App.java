import java.util.*;
import java.math.*;
// Custom exception class
class MyException extends Exception {
    MyException(String message) {
        super(message);
    }
}

class Operations {
    // Method for division
    static int divide(int dividend, int divisor) throws MyException {
        if (divisor == 0) {
            throw new MyException("Division by zero is not allowed.");
        }
        return dividend / divisor;
    }

    // Method for subtraction
    static int subtract(int a, int b) throws MyException {
        if (a < b) {
            throw new MyException("Subtraction result would be negative.");
        }
        return a - b;
    }

    // Method for multiply in zero
     static double squareRoot(double number) throws MyException {
        if (number < 0) {
            throw new MyException("Cannot calculate square root of a negative number");
        }

        return  Math.sqrt(number);
    }

}

public class App {
    public static void main(String[] args) {
        try {
            // Calling methods for division and subtraction
            int result1 = Operations.divide(10, 2);
            System.out.println("Result of division: " + result1);
            int result4 = Operations.divide(5, 0);
        }
        catch (MyException e) {
            // Catching the custom exception
            System.out.println("Caught MyMathException: " + e.getMessage());
        }
        try{
            
            int result2 = Operations.subtract(8, 5);
            System.out.println("Result of subtraction: " + result2);
            int result5 = Operations.subtract(5, 8);
        }

        catch (MyException e) {
            // Catching the custom exception
            System.out.println("Caught MyMathException: " + e.getMessage());
        }
        try{

            double result3 = Operations.squareRoot(16);
            System.out.println("Result of SqrRoot: " + result3);
            double result6 = Operations.squareRoot(-16);
          
        } catch (MyException e) {
            // Catching the custom exception
            System.out.println("Caught MyMathException: " + e.getMessage());
        } finally {
            // Finally block, executed regardless of whether an exception was caught
            System.out.println("Finally block executed.");
        }
    }
}

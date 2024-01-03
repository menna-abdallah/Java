import java.util.*;

public class ComplexNumber<T extends Number> {
    //T extends Number, This ensures that only numeric types can be used 

    private T real;
    private T imaginary;

    public ComplexNumber(T real, T imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public T getReal() {
        return real;
    }

    public T getImaginary() {
        return imaginary;
    }

    ///////// Normal Arthematic Methods
    
    // add 
    private T addNumbers(T a, T b) {
        if (a instanceof Double || b instanceof Double) {
            double result = ((Number) a).doubleValue() + ((Number) b).doubleValue(); // casting
            return (T) Double.valueOf(result);
        } else {
            int result = ((Number) a).intValue() + ((Number) b).intValue();
            return (T) Integer.valueOf(result);
        }
    }

    // subtract 
    private T subtractNumbers(T a, T b) {
        if (a instanceof Double || b instanceof Double) {
        double result = ((Number) a).doubleValue() - ((Number) b).doubleValue(); // casting
        return (T) Double.valueOf(result);        
    } else {
           int result = ((Number) a).intValue() - ((Number) b).intValue();
            return (T) Integer.valueOf(result);
        }
    }

    //multiply 
    private T multiplyNumbers(T a, T b) {
        if (a instanceof Double || b instanceof Double) {
        double result = ((Number) a).doubleValue() * ((Number) b).doubleValue(); // casting
        return (T) Double.valueOf(result);            
    } else {
        int result = ((Number) a).intValue() * ((Number) b).intValue();
        return (T) Integer.valueOf(result);        }
    }


    //////////// Complex Methods >>> complex object is the caller
    // Addition 
    public ComplexNumber<T> add(ComplexNumber<T> other) {
        ComplexNumber<T> result = new ComplexNumber<T>(addNumbers(real, other.getReal()), addNumbers(imaginary, other.getImaginary()));
        return result;
    }   

    // Subtraction 
    public ComplexNumber<T> subtract(ComplexNumber<T> other) {
         ComplexNumber<T> result = new ComplexNumber<T>(subtractNumbers(real, other.getReal()), subtractNumbers(imaginary, other.getImaginary()));
        return result;
    }

    // Multiplication
    public ComplexNumber<T> multiply(ComplexNumber<T> other) {
        // (a + bi) * (c + di) = (ac - bd) + (ad + bc)i
        T newReal = subtractNumbers(multiplyNumbers(real, other.getReal()), multiplyNumbers(imaginary, other.getImaginary()));
        T newImaginary = addNumbers(multiplyNumbers(real, other.getImaginary()), multiplyNumbers(imaginary, other.getReal()));
        return new ComplexNumber<T>(newReal, newImaginary);
    }

    public void print() {
       System.out.println(real + " + " + imaginary + "i");
    }

    public static void main(String[] args) {

        ComplexNumber<Double> complex1 = new ComplexNumber<Double>(5.0, 4.0);
        ComplexNumber<Double> complex2 = new ComplexNumber<Double>(2.5, 4.5);
            complex1.print();
            complex2.print();
        ComplexNumber<Double> sum = complex1.add(complex2);
        System.out.println("Summition: ");
        sum.print();
        ComplexNumber<Double> difference = complex1.subtract(complex2);
        System.out.println("Difference: ");
        difference.print();
        ComplexNumber<Double> product = complex1.multiply(complex2);
        System.out.println("Production: " );
        product.print();
    }
}

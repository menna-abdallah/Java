import java.util.function.Function;

public class TemperatureConverter {

    public static void main(String[] args) {
 
        // double celsiusTemperature = 25.0;

		/*
		<T,R>
		T >> input type
		R >> return type
		celsiusToFahrenheit >> reference name
		
		
		celsiusTemperature >> argument
		*/
        Function<Double, Double> x = celsiusTemperature -> celsiusTemperature * 9/5 + 32;
        
        double fahrenheitTemperature = x.apply(25.0);

        System.out.println("25.0 Celsius is equal to " + fahrenheitTemperature + " Fahrenheit.");
    }
}


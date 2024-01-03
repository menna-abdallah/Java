import java.util.ArrayList;
import java.util.List;
import Interfaces.*;

public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Double> listOfElements = new ArrayList<Double>();

		listOfElements.add(Double.parseDouble(args[0]));
		listOfElements.add(Double.parseDouble(args[1]));
		listOfElements.add(Double.parseDouble(args[2]));

		Equation obj = new Equation();
		double sq_root = obj.apply(listOfElements);

		if (sq_root < 0) {
			System.out.println("The quadratic equation has imaginary roots.");
		} else {
			double a = Double.parseDouble(args[0]);
			double b = Double.parseDouble(args[1]);
			double root1 = ((b * -1) + Math.sqrt(sq_root)) / (2 * a);
			double root2 = ((b * -1) - Math.sqrt(sq_root)) / (2 * a);

			if (root1 == root2) {
				System.out.println("The quadratic equation has one real root: x = " + root1);
			} else {
				System.out.println("The quadratic equation has two real roots: x1 = " + root1 + ", x2 = " + root2);
			}
		}

	}
}

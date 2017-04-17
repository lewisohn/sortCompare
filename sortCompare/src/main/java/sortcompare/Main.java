package sortcompare;

import java.util.Random;
import sortcompare.algorithms.*;
import sortcompare.structures.CustomList;
import sortcompare.ui.Evaluator;
import sortcompare.ui.UI;

/**
 * Comparison of sorting algorithms.
 *
 * @author Oliver Lewisohn
 */
public class Main {

	/**
	 * Main method. If arguments are passed to this method, the program will run
	 * in automatic mode, otherwise it will run in manual mode by launching the
	 * user interface. Afterwards it calls the evaluator.
	 *
	 * @param args (Optional) A list of positive integers. Each integer
	 * corresponds to an "n" value, in other words, how many randomly generated
	 * numbers should be passed to the algorithms for sorting.
	 */
	public static void main(String[] args) {
		if (args.length == 0) { // ask for manual input if no arguments passed
			new UI().run().evaluate();
		} else { // else prepare for automatic mode
			int[] sizes = new int[args.length];
			int temp;
			for (int i = 0; i < args.length; i++) {
				try {
					temp = Integer.parseInt(args[i]); // exception thrown if argument is not an integer
					if (temp > 0) {
						sizes[i] = temp;
					} else {
						throw new NumberFormatException(); // thrown if argument is an integer but not positive
					}
				} catch (NumberFormatException e) {
					System.err.println("Error: " + args[i] + " is not a positive integer.");
					System.exit(1);
				}
			}
			automatic(sizes);
		}

	}

	private static void automatic(int[] sizes) {
		CustomList<Sort> algorithms = new CustomList<>();
		algorithms.addAll(new Sort[]{
			new Bubble(),
			new Bucket(),
			new Heap(),
			new Insertion(),
			new Merge(),
			new Quick()
		});
		CustomList<CustomList<Integer>> data = new CustomList<>();
		Random rand = new Random();
		for (int i = 0; i < sizes.length; i++) {
			CustomList<Integer> temp = new CustomList<>();
			for (int j = 0; j < sizes[i]; j++) {
				temp.add(rand.nextInt());
			}
			data.add(temp);
		}
		for (CustomList<Integer> integers : data) {
			new Evaluator(integers, algorithms).evaluate(10);
		}
	}

}

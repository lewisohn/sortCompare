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
	
	private static final int REPEAT_DEFAULT = 10;

	/**
	 * Main method. If two or more arguments are passed to this method, the
	 * program will run in automatic mode, otherwise it will run in manual mode
	 * by launching the user interface.
	 *
	 * @param args (Optional) A list of positive integers. The first integer is
	 * the number of times the sorting algorithms should be run for each input.
	 * The following integers correspond to the sizes of inputs, or in other
	 * words, how many randomly generated numbers should be passed to the
	 * algorithms for sorting.
	 */
	public static void main(String[] args) {
		int repeat = (args.length > 0 ? parse(args[0]) : REPEAT_DEFAULT);
		if (args.length > 1) {
			int[] sizes = new int[args.length - 1];
			for (int i = 1; i < args.length; i++) {
				sizes[i - 1] = parse(args[i]);
			}
			automatic(sizes, repeat);
		} else {
			new UI().run().evaluate(repeat);
		}
	}

	private static int parse(String arg) {
		try {
			int temp = Integer.parseInt(arg); // exception thrown if argument is not an integer
			if (temp <= 0) {
				throw new NumberFormatException(); // thrown if argument is not positive
			}
			return temp;
		} catch (NumberFormatException e) {
			System.err.println("Error: " + arg + " is not a positive integer.");
			System.exit(1);
		}
		return 1;
	}

	private static void automatic(int[] sizes, int repeat) {
		CustomList<Sort> algorithms = new CustomList<>();
		algorithms.append(new Sort[]{
			new Bubble(),
			new Bucket(),
			new Heap(),
			new Insertion(),
			new Merge(),
			new Quick()
		});
		CustomList<Integer>[] data = new CustomList[sizes.length];
		Random rand = new Random();
		for (int i = 0; i < data.length; i++) {
			CustomList<Integer> temp = new CustomList<>();
			for (int j = 0; j < sizes[i]; j++) {
				temp.add(rand.nextInt());
			}
			data[i] = temp;
		}
		for (CustomList<Integer> integers : data) {
			new Evaluator(integers, algorithms).evaluate(repeat);
		}
	}

}

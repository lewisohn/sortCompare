package sortcompare.ui;

import sortcompare.algorithms.Sort;
import sortcompare.structures.CustomList;
import sortcompare.structures.CustomPair;

/**
 * Evaluates sorting algorithms.
 * @author Oliver Lewisohn
 */
public class Evaluator {

	private final CustomList<Integer> data;
	private final CustomList<Sort> algorithms;

	/**
	 * Creates a new Evaluator.
	 * @param data The data to be sorted.
	 * @param algorithms The algorithms to compare.
	 */
	public Evaluator(CustomList<Integer> data, CustomList<Sort> algorithms) {
		this.data = data;
		this.algorithms = algorithms;
	}

	/**
	 * Evaluates the selected sorting algorithms with the provided data.
	 */
	public void evaluate() {
		CustomPair pair;
		for (Sort algorithm : algorithms) {
			pair = algorithm.measure((CustomList<Integer>) data.clone());
			System.out.println(algorithm.toString() + " sort finished in " + pair.getSecond()
					+ " ms and used approximately " + (pair.getFirst() / 1024) + " KiB of memory.");
		}
	}

}

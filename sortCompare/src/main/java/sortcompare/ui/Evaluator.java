package sortcompare.ui;

import sortcompare.algorithms.Sort;
import sortcompare.structures.FlexList;
import sortcompare.structures.SpaceTime;

/**
 * Evaluates sorting algorithms.
 * @author Oliver Lewisohn
 */
public class Evaluator {

	private final FlexList<Integer> data;
	private final FlexList<Sort> algorithms;

	/**
	 * Creates a new Evaluator.
	 * @param data The data to be sorted.
	 * @param algorithms The algorithms to compare.
	 */
	public Evaluator(FlexList<Integer> data, FlexList<Sort> algorithms) {
		this.data = data;
		this.algorithms = algorithms;
	}

	/**
	 * Evaluates the selected sorting algorithms with the provided data.
	 */
	public void evaluate() {
		SpaceTime st;
		for (Sort algorithm : algorithms) {
			st = algorithm.measure((FlexList<Integer>) data.clone());
			System.out.println(algorithm.toString() + " sort finished in " + st.getTime()
					+ " ms and used approximately " + (st.getSpace() / 1024) + " KiB of memory.");
		}
	}

}

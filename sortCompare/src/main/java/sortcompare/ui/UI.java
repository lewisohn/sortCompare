package sortcompare.ui;

import sortcompare.algorithms.Sort;
import sortcompare.structures.FlexList;

/**
 * Container class for user interaction.
 * @author Oliver Lewisohn
 */
public class UI {

	private FlexList<Integer> data;
	private FlexList<Sort> algorithms;

	/**
	 * Interacts with the user.
	 * @return Evaluator containing both data and a list of algorithms to
	 * compare.
	 */
	public Evaluator run() {
		data = new DataSelector().populate();
		algorithms = new SortSelector().populate();
		return new Evaluator(data, algorithms);
	}

}

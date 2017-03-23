package sortcompare;

import sortcompare.ui.UI;

/**
 * Comparison of sorting algorithms.
 * @author Oliver Lewisohn
 */
public class Main {

	/**
	 * Main method. Launches the user interface then calls the evaluator.
	 * @param args No arguments necessary.
	 */
	public static void main(String[] args) {
		new UI().run().evaluate();
	}

}
